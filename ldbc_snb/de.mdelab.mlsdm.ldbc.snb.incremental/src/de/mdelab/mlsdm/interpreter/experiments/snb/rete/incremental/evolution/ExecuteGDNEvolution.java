package de.mdelab.mlsdm.interpreter.experiments.snb.rete.incremental.evolution;

import java.io.IOException;

import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.gdn.GDN;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentLogger;
import de.mdelab.mlsdm.interpreter.experiments.util.ExperimentsUtil;
import de.mdelab.mlsdm.interpreter.incremental.QueryManagerNotificationReceiver;
import de.mdelab.mlsdm.interpreter.incremental.change.SDMChangeEvent;
import de.mdelab.mlsdm.interpreter.incremental.rete.GDNReteBuilder;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteNet;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteSDMWrapper;
import de.mdelab.sdm.interpreter.core.SDMException;

public class ExecuteGDNEvolution {

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

		GDN gdn = ExperimentsUtil.readGDN(ruleFile);
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataFile);

		ReteQueryManager queryManager = new ReteQueryManager() {

			@Override
			public void flushUnhandledEvents() {
				FlushStatus previousFlushing = flushing;
				flushing = FlushStatus.FLUSH;
				for(SDMChangeEvent change:unhandledChanges) {
					notifyUpdateStart();
					flushEvent(change);
					notifyUpdateEnd();
					notifyCustom();
				}
				unhandledChanges.clear();
				flushing = previousFlushing;
			}

			protected void notifyCustom() {
				for(QueryManagerNotificationReceiver receiver:notificationReceivers) {
					receiver.notifyCustom();
				}
			}

		};
		queryManager.registerEObject(logReader.getModel());
		ReteNet reteNet = ((ReteSDMWrapper)new GDNReteBuilder().buildReteQuery(gdn, queryManager)).getResultProvider().getNet();

        ExperimentLogger logger = new ExperimentLogger(10000, logMem) {

        	@Override
        	public void notifyCustom(Object... args) {
        		if(updateCount % increments == 0) {
        			customBuffer.append(updateCount + "\t" + (long) computeNetSize(reteNet) + "\n");
        		}
        	}
        	
        };
        
		//create initial elements
		for(int i = 0; i < 0; i++) {
			logReader.executeNextAction();
		}
		queryManager.flushUnhandledEvents();
		
		EvolutionExecutor executor = new EvolutionExecutor();
		executor.executeEvolution(logReader, queryManager, logger, logMem);
	}

	private static void warmUp(String dataFile, String ruleFile) throws IOException, SDMException {
		GDN gdn = ExperimentsUtil.readGDN(ruleFile);
		LDBC_SNBLogReader logReader = new LDBC_SNBLogReader(dataFile);
		
		//create initial elements
		ReteQueryManager queryManager = new ReteQueryManager();
		queryManager.registerEObject(logReader.getModel());
		while(logReader.hasNextElement()) {
			logReader.executeNextAction();
		}

		//find initial matches
		new GDNReteBuilder().buildReteQuery(gdn, queryManager);
		queryManager.flushUnhandledEvents();
	}
}
