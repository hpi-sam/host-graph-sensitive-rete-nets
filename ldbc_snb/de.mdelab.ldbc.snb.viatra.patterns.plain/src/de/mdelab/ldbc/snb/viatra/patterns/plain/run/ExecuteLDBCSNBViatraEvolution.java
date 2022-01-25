package de.mdelab.ldbc.snb.viatra.patterns.plain.run;

import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive1;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive10;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive11;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive12;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive2;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive3;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive4;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive5;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive6;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive7;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive8;
import de.mdelab.ldbc.snb.viatra.patterns.plain.Interactive9;
import de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots.LDBCSNBKnowsBot;
import de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots.LDBCSNBPostConverter;
import de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots.LDBCSNBPostConverterBot;
import de.mdelab.ldbc_snb.LdbcSNBModel;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;

public class ExecuteLDBCSNBViatraEvolution {

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
		INTERACTIVE_12}
	
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
		
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataDir + "/social_network/stream_evolution.csv");

		ViatraQueryEngine engine = createEngine(logReader.getModel());
		registerQueries(engine, queryID);
		
		LdbcSNBModel model = (LdbcSNBModel) logReader.getModel();
		
		Runtime runtime = Runtime.getRuntime();
		StringBuffer buffer = new StringBuffer();
		if(logMem) {
			buffer.append("MEMORY\n");
		}
		else {
			buffer.append("UPDATES\n");
		}
		long updateCount = 0;
		long updateTime = 0;
		for(int i = 0; i < logReader.getLogSize() * LDBCSNBPostConverter.RELATIVE_TIPPING_POINT; i++) {
			long start = System.nanoTime();
			logReader.executeNextAction();
			long end = System.nanoTime();
			updateTime += (end - start);
			updateCount++;
			if(updateCount % 1000 == 0) {
				if(logMem) {
			        runtime.gc();
			        long memory = runtime.totalMemory() - runtime.freeMemory();
					buffer.append(updateCount + "\t" + memory + "\n");
				}
				else {
					buffer.append(updateCount + "\t" + updateTime + "\n");
					updateTime = 0;
				}
			}
		}
		
		//start the bots
		LDBCSNBPostConverterBot postConverter = new LDBCSNBPostConverterBot(123l, model);
		LDBCSNBKnowsBot knowsBot = new LDBCSNBKnowsBot(LDBCSNBKnowsBot.TARGET_KNOWS_PER_PERSON, model, 123l);

		while(!postConverter.getPostsToConvert().isEmpty() || knowsBot.getKnowsToCreate() > 0) {
			if(!postConverter.getPostsToConvert().isEmpty()) {
				long start = System.nanoTime();
				postConverter.convertPost();
				long end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % 1000 == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
					}
				}
			}
			
			if(knowsBot.getKnowsToCreate() > 0) {
				long start = System.nanoTime();
				knowsBot.addRandomElement();
				long end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % 1000 == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
					}
				}
			}
		}
			
		while(logReader.hasNextElement()) {
			long start = System.nanoTime();
			logReader.executeNextAction();
			long end = System.nanoTime();
			
			updateTime += (end - start);
			updateCount++;
			if(updateCount % 1000 == 0) {
				if(logMem) {
			        runtime.gc();
			        long memory = runtime.totalMemory() - runtime.freeMemory();
					buffer.append(updateCount + "\t" + memory + "\n");
				}
				else {
					buffer.append(updateCount + "\t" + updateTime + "\n");
					updateTime = 0;
				}
			}
			
			while(knowsBot.getKnowsToCreate() > 0) {
				start = System.nanoTime();
				knowsBot.addRandomElement();
				end = System.nanoTime();

				updateTime += (end - start);
				updateCount++;
				if(updateCount % 1000 == 0) {
					if(logMem) {
				        runtime.gc();
				        long memory = runtime.totalMemory() - runtime.freeMemory();
						buffer.append(updateCount + "\t" + memory + "\n");
					}
					else {
						buffer.append(updateCount + "\t" + updateTime + "\n");
						updateTime = 0;
					}
				}
			}
		}

		buffer.append("-------------------------------------\n");
		System.out.println(buffer.toString());
	}

	private static void registerEPackages() {
		Ldbc_snbPackage.eINSTANCE.getName();
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

	private static void warmUp(String dataDir, QueryID queryID) throws IOException, ViatraQueryException {
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataDir + "/social_network/stream.csv");
		
		ViatraQueryEngine engine = createEngine(logReader.getModel());
		
		BaseMatcher<?> matcher = registerQueries(engine, queryID);

		for(; logReader.hasNextElement(); ) {
			logReader.executeNextAction();
		}
		
		countElements(matcher.getAllMatches().iterator());
	}
	
}
