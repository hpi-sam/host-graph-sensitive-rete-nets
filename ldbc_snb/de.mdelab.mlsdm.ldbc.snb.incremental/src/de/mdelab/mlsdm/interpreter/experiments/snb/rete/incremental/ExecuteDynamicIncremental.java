package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental;

import java.io.IOException;

import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentLogger;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentsUtil;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.NetSizeBasedQueryManager;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.interpreter.core.SDMException;

public class ExecuteDynamicIncremental {

	public static void main(String args[]) throws IOException, SDMException {
		if(args.length < 3) {
			System.out.println("3 arguments: dataDir, ruleFile, logMem");
			return;
		}
		
		final String dataFile = args[0] + "/social_network/stream.csv";
		final String ruleFile = args[1];
		final boolean logMem = Boolean.parseBoolean(args[2]);
		
		ExperimentsUtil.registerEPackages();

		warmUp(dataFile, ruleFile);

		StoryPattern pattern = ExperimentsUtil.readPattern(ruleFile);
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataFile);

        ExperimentLogger logger = new ExperimentLogger(10000, false);
        
		DynamicReteQueryManager queryManager = new NetSizeBasedQueryManager(pattern, logReader.getModel());
		
		IncrementalExecutor executor = new IncrementalExecutor();
		executor.executeIncremental(logReader, queryManager, logger, logMem);
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
	}
}
