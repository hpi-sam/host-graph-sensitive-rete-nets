package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental.evolution;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentLogger;
import de.mdelab.mlsdm.interpreter.experiments.util.LDBCSNBKnowsBot;
import de.mdelab.mlsdm.interpreter.experiments.util.LDBCSNBPostConverterBot;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;

public class EvolutionExecutor {
	
	public static double RELATIVE_TIPPING_POINT = 0.25;

	public void executeEvolution(LDBC_SNBLogReader logReader, ReteQueryManager queryManager, ExperimentLogger logger, boolean logMem) {
		LdbcSNBModel model = (LdbcSNBModel) logReader.getModel();
		
//		if(logger != null) {
//			queryManager.registerNotificationReceiver(logger);
//		}
		
		Runtime runtime = Runtime.getRuntime();
		StringBuffer buffer = new StringBuffer();
		long measurementFrequency;
		if(logMem) {
			buffer.append("MEMORY\n");
			measurementFrequency = 10000;
		}
		else {
			buffer.append("UPDATES\n");
			measurementFrequency = 1000;
		}
		StringBuffer gcBuffer = new StringBuffer();
		gcBuffer.append("GC\n");
		
		long gcTimeStart = getGarbageCollectionTime();
		long updateCount = 0;
		long updateTime = 0;
		for(int i = 0; i < logReader.getLogSize() * EvolutionExecutor.RELATIVE_TIPPING_POINT; i++) {
			long start = System.nanoTime();
			logReader.executeNextAction();
			queryManager.flushUnhandledEvents();
			long end = System.nanoTime();
			updateTime += (end - start);
			updateCount++;
			if(updateCount % measurementFrequency == 0) {
				if(logMem) {
			        runtime.gc();
			        long memory = runtime.totalMemory() - runtime.freeMemory();
					buffer.append(updateCount + "\t" + memory + "\n");
				}
				else {
					buffer.append(updateCount + "\t" + updateTime + "\n");
					updateTime = 0;
					
					long gcTime = getGarbageCollectionTime() - gcTimeStart;
					gcBuffer.append(updateCount + "\t" + gcTime + "\n");
				}
			}
		}
		
		//start the bots
		LDBCSNBPostConverterBot postConverter = new LDBCSNBPostConverterBot(123l, model, logReader);
		LDBCSNBKnowsBot knowsBot = new LDBCSNBKnowsBot(LDBCSNBKnowsBot.TARGET_KNOWS_PER_PERSON, model, 123l);

		while(!postConverter.getPostsToConvert().isEmpty() || knowsBot.getKnowsToCreate() > 0) {
			if(!postConverter.getPostsToConvert().isEmpty()) {
				long start = System.nanoTime();
				postConverter.convertPost();
				queryManager.flushUnhandledEvents();
				long end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % measurementFrequency == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
						
						long gcTime = getGarbageCollectionTime() - gcTimeStart;
						gcBuffer.append(updateCount + "\t" + gcTime + "\n");
					}
				}
			}
			
			if(knowsBot.getKnowsToCreate() > 0) {
				long start = System.nanoTime();
				knowsBot.addRandomElement();
				queryManager.flushUnhandledEvents();
				long end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % measurementFrequency == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
						
						long gcTime = getGarbageCollectionTime() - gcTimeStart;
						gcBuffer.append(updateCount + "\t" + gcTime + "\n");
					}
				}
			}
		}
		
		while(logReader.hasNextElement()) {
			long start = System.nanoTime();
			logReader.executeNextAction();
			queryManager.flushUnhandledEvents();
			long end = System.nanoTime();
			
			updateTime += (end - start);
			updateCount++;
			if(updateCount % measurementFrequency == 0) {
				if(logMem) {
			        runtime.gc();
			        long memory = runtime.totalMemory() - runtime.freeMemory();
					buffer.append(updateCount + "\t" + memory + "\n");
				}
				else {
					buffer.append(updateCount + "\t" + updateTime + "\n");
					updateTime = 0;
					
					long gcTime = getGarbageCollectionTime() - gcTimeStart;
					gcBuffer.append(updateCount + "\t" + gcTime + "\n");
				}
			}
			
			while(knowsBot.getKnowsToCreate() > 0) {
				start = System.nanoTime();
				knowsBot.addRandomElement();
				queryManager.flushUnhandledEvents();
				end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % measurementFrequency == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
						
						long gcTime = getGarbageCollectionTime() - gcTimeStart;
						gcBuffer.append(updateCount + "\t" + gcTime + "\n");
					}
				}
			}
		}

		buffer.append("-------------------------------------\n");
		System.out.println(buffer.toString());
		
		gcBuffer.append("-------------------------------------\n");
		System.out.println(gcBuffer.toString());
//		if(logger != null) {
//			logger.flush(System.out);
//		}
	}

	private static long getGarbageCollectionTime() {
	    long collectionTime = 0;
	    for (GarbageCollectorMXBean garbageCollectorMXBean : ManagementFactory.getGarbageCollectorMXBeans()) {
	        collectionTime += garbageCollectorMXBean.getCollectionTime();
	    }
	    return collectionTime;
	}
}
