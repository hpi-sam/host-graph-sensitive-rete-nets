package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.interpreter.incremental.QueryManagerNotificationReceiver;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;

public class IncrementalExecutor {

	public static final double INITIAL_ELEMENTS = 0.0;
	
	public void executeIncremental(LDBC_SNBLogReader logReader, ReteQueryManager queryManager, QueryManagerNotificationReceiver logger, boolean logMem) {		
		queryManager.registerEObject(logReader.getModel());

		//create initial elements
		for(int i = 0;  i < logReader.getLogSize() * INITIAL_ELEMENTS; i++) {
			logReader.executeNextAction();
		}
		queryManager.flushUnhandledEvents();
		
		//create elements
		Runtime runtime = Runtime.getRuntime();
		int outputFrequency;
		int timeout;
		if(logMem) {
			System.out.println("MEMORY\n");
			outputFrequency = 10000;
			timeout = 18000000;
		}
		else {
			System.out.println("UPDATES\n");
			outputFrequency = 1000;
			timeout = 18000000;
		}
		
		long updateCount = 0;
		long updateTime = 0;
		long gcTimeStart = getGarbageCollectionTime();
		long absoluteStart = System.currentTimeMillis();
		for(; logReader.hasNextElement(); ) {
			long start = System.nanoTime();
			logReader.executeNextAction();
			queryManager.flushUnhandledEvents();
			long end = System.nanoTime();
			updateTime += (end - start);
			updateCount++;
			long gcTime = getGarbageCollectionTime() - gcTimeStart;
			
			if(updateCount % outputFrequency == 0) {
				String logEntry;
				if(logMem) {
			        runtime.gc();
			        long memory = runtime.totalMemory() - runtime.freeMemory();
			        logEntry = updateCount + "\t" + memory;
				}
				else {
					logEntry = updateCount + "\t" + updateTime;
					updateTime = 0;
				}
				
				System.out.println("UPDATE;" + logEntry);
				System.out.println("GC;" + updateCount + "\t" + gcTime);
			}
			
			if(System.currentTimeMillis() - absoluteStart >= timeout) {
				break;
			}
		}
	}

	private static long getGarbageCollectionTime() {
	    long collectionTime = 0;
	    for (GarbageCollectorMXBean garbageCollectorMXBean : ManagementFactory.getGarbageCollectorMXBeans()) {
	        collectionTime += garbageCollectorMXBean.getCollectionTime();
	    }
	    return collectionTime;
	}
}
