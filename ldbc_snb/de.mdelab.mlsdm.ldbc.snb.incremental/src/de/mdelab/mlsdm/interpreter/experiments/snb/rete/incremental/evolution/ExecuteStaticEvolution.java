package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental.evolution;

import java.io.IOException;
import java.util.Iterator;

import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentLogger;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentsUtil;
import de.mdelab.mlsdm.interpreter.incremental.SDMQueryMatch;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteSDMWrapper;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteNet;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.NetSizeBasedQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.StaticNetQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteIndex;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.interpreter.core.SDMException;

public class ExecuteStaticEvolution {

	public static void main(String args[]) throws IOException, SDMException {
		if(args.length < 3) {
			System.out.println("3 arguments: dataDir, ruleFile, logMem");
			return;
		}
		
		final String dataFile = args[0] + "/social_network/stream_evolution.csv";
		final String ruleFile = args[1];
		final boolean logMem = Boolean.parseBoolean(args[2]);
		
		ExperimentsUtil.registerEPackages();

		warmUp(dataFile, ruleFile);

		StoryPattern pattern = ExperimentsUtil.readPattern(ruleFile);
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataFile);
        
        StaticNetQueryManager queryManager = new StaticNetQueryManager(pattern, logReader.getModel());

		//create initial elements
		for(int i = 0; i < logReader.getLogSize() * EvolutionExecutor.RELATIVE_TIPPING_POINT; i++) {
			logReader.executeNextAction();
		}
		queryManager.computeNewNetStructure();
		
		try {
			logReader = new LDBC_SNBLogReader(dataFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		StaticNetQueryManager old = (StaticNetQueryManager) queryManager;
		try {
			queryManager = new StaticNetQueryManager(pattern, logReader.getModel());
		} catch (SDMException e) {
			e.printStackTrace();
		}
		((StaticNetQueryManager)queryManager).setNet((DynamicReteNet) old.getCurrentNet());
		//----------------------
		
		System.gc();
		
		EvolutionExecutor executor = new EvolutionExecutor();
		executor.executeEvolution(logReader, queryManager, new ExperimentLogger(10000, logMem), logMem);
	}

	private static void warmUp(String dataFile, String ruleFile) throws IOException, SDMException {
		StoryPattern pattern = ExperimentsUtil.readPattern(ruleFile);
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataFile);

		DynamicReteQueryManager reteNet = new NetSizeBasedQueryManager(pattern);
		reteNet.registerEObject(logReader.getModel());
		for(int i = 0; i < logReader.getLogSize() / 200; i++) {
			logReader.executeNextAction();
		}

		//find initial matches
		reteNet.flushUnhandledEvents();
		for(Iterator<SDMQueryMatch> it = new ReteSDMWrapper(reteNet.getResultProvider()).getMatches(); it.hasNext();) {
			it.next();
		}
		ReteIndex.TOTAL_TUPLES = 0;
	}
}
