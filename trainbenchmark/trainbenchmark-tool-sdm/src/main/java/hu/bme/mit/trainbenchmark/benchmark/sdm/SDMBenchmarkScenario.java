package hu.bme.mit.trainbenchmark.benchmark.sdm;

import hu.bme.mit.trainbenchmark.benchmark.emf.comparators.EmfMatchComparator;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.phases.BenchmarkScenario;
import hu.bme.mit.trainbenchmark.benchmark.sdm.config.SDMBenchmarkConfig;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriverFactory;
import hu.bme.mit.trainbenchmark.benchmark.sdm.operations.SDMModelOperationFactory;

public class SDMBenchmarkScenario
		extends BenchmarkScenario<EmfMatch, SDMDriver, SDMBenchmarkConfig> {

	public SDMBenchmarkScenario(final SDMBenchmarkConfig bc) throws Exception {
		super(new SDMDriverFactory(bc.getType()), new SDMModelOperationFactory(), new EmfMatchComparator(), bc);
	}

}
