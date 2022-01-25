package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental;

import java.io.IOException;

import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentLogger;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteNet;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.StaticNetQueryManager;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.interpreter.core.SDMException;

public class StaticIncrementalExecutor extends IncrementalExecutor {

	public static final double RETE_NET_COMPUTATION_BASE = 1.0;

	public void executeIncremental(LDBC_SNBLogReader logReader, ReteQueryManager queryManager, ExperimentLogger logger, boolean logMem, String dataFile, StoryPattern pattern) {
		queryManager.registerEObject(logReader.getModel());

		//create initial elements
		for(int i = 0;  i < logReader.getLogSize() * RETE_NET_COMPUTATION_BASE; i++) {
			logReader.executeNextAction();
		}
		long start = System.nanoTime();
		((StaticNetQueryManager) queryManager).computeNewNetStructure();
		System.out.println("RETE Computation: " + (System.nanoTime() - start) / 1000000);
		
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
		
		System.gc();
		
//		while(logReader.hasPreviousElement()) {
//			logReader.removePreviousElement();
//		}
//		queryManager.clearUnhandledChanges();
		
		super.executeIncremental(logReader, queryManager, logger, logMem);
	}
//
//	private void clear(LdbcSNBModel model) {
//		model.getMessages().clear();
//		model.getOwnedForums().clear();
//		model.getOwnedHasMemberLinks().clear();
//		model.getOwnedKnowsLinks().clear();
//		model.getOwnedLikesLinks().clear();
//		model.getOwnedPersons().clear();
//		model.getOwnedPosts().clear();
//	}
}
