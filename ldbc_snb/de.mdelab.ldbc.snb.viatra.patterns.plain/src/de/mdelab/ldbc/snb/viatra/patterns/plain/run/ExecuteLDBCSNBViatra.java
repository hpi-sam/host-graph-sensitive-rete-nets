package de.mdelab.ldbc.snb.viatra.patterns.plain.run;

import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive1;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive10;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive11;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive12;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive2;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive3;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive3nac;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive4;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive4nac;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive5;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive6;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive7;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive8;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive9;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

public class ExecuteLDBCSNBViatra {

	public static final boolean FLUSH_LOG = true;
	
	public static enum EngineType {INCREMENTAL};
	
	private static enum QueryID {
		INTERACTIVE_1,
		INTERACTIVE_2,
		INTERACTIVE_3,
		INTERACTIVE_4,
		INTERACTIVE_5,
		INTERACTIVE_6,
		INTERACTIVE_7,
		INTERACTIVE_8,
		INTERACTIVE_9,
		INTERACTIVE_10,
		INTERACTIVE_11,
		INTERACTIVE_12,
		INTERACTIVE_3_NGC,
		INTERACTIVE_4_NGC}
	
	public static void main(String[] args) throws ViatraQueryException, IOException {
		if(args.length < 3) {
			System.out.println("3 arguments: dataDir, queryID, logMem");
			return;
		}
		
		String dataDir = args[0];
		QueryID queryID = QueryID.valueOf(args[1]);
		boolean logMem = Boolean.parseBoolean(args[2]);
		
		registerEPackages();
		
		warmUp(dataDir, queryID);
		
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataDir + "/social_network/stream.csv");

		ViatraQueryEngine engine = createEngine(logReader.getModel());
		BaseMatcher<?> matcher = registerQueries(engine, queryID);

		Runtime runtime = Runtime.getRuntime();
//		StringBuffer buffer = new StringBuffer();
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

//		StringBuffer gcBuffer = new StringBuffer();
//		gcBuffer.append("GC\n");
		
		long updateCount = 0;
		long updateTime = 0;
		long gcTimeStart = getGarbageCollectionTime();
		long absoluteStart = System.currentTimeMillis();
		for(; logReader.hasNextElement(); ) {
			long start = System.nanoTime();
			logReader.executeNextAction();
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
		System.out.println("matches: " + matcher.countMatches());
		
//		System.out.println("-------------------------------------\n");
//		System.out.println(buffer.toString());
		
//		System.out.println(updateCount + "\t" + (getGarbageCollectionTime() - gcTimeStart) + "\n");
//		System.out.println("-------------------------------------\n");
//		System.out.println(gcBuffer.toString());
	}

	private static void registerEPackages() {
		Ldbc_snbPackage.eINSTANCE.getName();
	}

	private static long getGarbageCollectionTime() {
	    long collectionTime = 0;
	    for (GarbageCollectorMXBean garbageCollectorMXBean : ManagementFactory.getGarbageCollectorMXBeans()) {
	        collectionTime += garbageCollectorMXBean.getCollectionTime();
	    }
	    return collectionTime;
	}
	
	private static int countElements(Iterator<?> iterator) {
		int count = 0;
		while(iterator.hasNext()) {
			count++;
			iterator.next();
		}
		return count;
	}

	public static ViatraQueryEngine createEngine(EObject model) throws ViatraQueryException {
		ViatraQueryEngineOptions.setSystemDefaultBackends(ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE, ReteBackendFactory.INSTANCE);
		EMFScope scope = new EMFScope(model);
		ViatraQueryEngine engine = ViatraQueryEngine.on(scope);
		return engine;
	}

	private static BaseMatcher<?> registerQueries(ViatraQueryEngine engine, QueryID queryID) throws ViatraQueryException {
		switch(queryID) {
		case INTERACTIVE_1:
			return registerQuery1(engine);
		case INTERACTIVE_2:
			return registerQuery2(engine);
		case INTERACTIVE_3:
			return registerQuery3(engine);
		case INTERACTIVE_4:
			return registerQuery4(engine);
		case INTERACTIVE_5:
			return registerQuery5(engine);
		case INTERACTIVE_6:
			return registerQuery6(engine);
		case INTERACTIVE_7:
			return registerQuery7(engine);
		case INTERACTIVE_8:
			return registerQuery8(engine);
		case INTERACTIVE_9:
			return registerQuery9(engine);
		case INTERACTIVE_10:
			return registerQuery10(engine);
		case INTERACTIVE_11:
			return registerQuery11(engine);
		case INTERACTIVE_12:
			return registerQuery12(engine);
		case INTERACTIVE_3_NGC:
			return registerQuery3NAC(engine);
		case INTERACTIVE_4_NGC:
			return registerQuery4NAC(engine);
		}
		return null;
	}

	private static BaseMatcher<?> registerQuery1(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher1 = engine.getMatcher(Interactive1.Matcher.querySpecification());
		matcher1.countMatches();
		return matcher1;
	}

	private static BaseMatcher<?> registerQuery2(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher2 = engine.getMatcher(Interactive2.Matcher.querySpecification());
		matcher2.countMatches();
		return matcher2;
	}

	private static BaseMatcher<?> registerQuery3(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher3 = engine.getMatcher(Interactive3.Matcher.querySpecification());
		matcher3.countMatches();
		return matcher3;
	}

	private static BaseMatcher<?> registerQuery4(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher4 = engine.getMatcher(Interactive4.Matcher.querySpecification());
		matcher4.countMatches();
		return matcher4;
	}

	private static BaseMatcher<?> registerQuery5(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher5 = engine.getMatcher(Interactive5.Matcher.querySpecification());
		matcher5.countMatches();
		return matcher5;
	}

	private static BaseMatcher<?> registerQuery6(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher6 = engine.getMatcher(Interactive6.Matcher.querySpecification());
		matcher6.countMatches();
		return matcher6;
	}

	private static BaseMatcher<?> registerQuery7(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher7 = engine.getMatcher(Interactive7.Matcher.querySpecification());
		matcher7.countMatches();
		return matcher7;
	}

	private static BaseMatcher<?> registerQuery8(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher8 = engine.getMatcher(Interactive8.Matcher.querySpecification());
		matcher8.countMatches();
		return matcher8;
	}
	
	private static BaseMatcher<?> registerQuery9(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher9 = engine.getMatcher(Interactive9.Matcher.querySpecification());
		matcher9.countMatches();
		return matcher9;
	}
	
	private static BaseMatcher<?> registerQuery10(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher10 = engine.getMatcher(Interactive10.Matcher.querySpecification());
		matcher10.countMatches();
		return matcher10;
	}
	
	private static BaseMatcher<?> registerQuery11(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher11 = engine.getMatcher(Interactive11.Matcher.querySpecification());
		matcher11.countMatches();
		return matcher11;
	}

	private static BaseMatcher<?> registerQuery12(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher12 = engine.getMatcher(Interactive12.Matcher.querySpecification());
		matcher12.countMatches();
		return matcher12;
	}

	private static BaseMatcher<?> registerQuery3NAC(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher3NAC = engine.getMatcher(Interactive3nac.Matcher.querySpecification());
		matcher3NAC.countMatches();
		return matcher3NAC;
	}

	private static BaseMatcher<?> registerQuery4NAC(ViatraQueryEngine engine) throws ViatraQueryException {
		BaseMatcher<?> matcher4NAC = engine.getMatcher(Interactive4nac.Matcher.querySpecification());
		matcher4NAC.countMatches();
		return matcher4NAC;
	}

	private static void warmUp(String dataDir, QueryID queryID) throws IOException, ViatraQueryException {
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataDir + "/social_network/stream.csv");
		
		ViatraQueryEngine engine = createEngine(logReader.getModel());
		
		BaseMatcher<?> matcher = registerQueries(engine, queryID);

//		for(; logReader.hasNextElement(); ) {
//			logReader.createNextElement();
//		}

		for(int i = 0; i < logReader.getLogSize() / 200; i++) {
			logReader.executeNextAction();
		}
		
		countElements(matcher.getAllMatches().iterator());
	}
	
}
