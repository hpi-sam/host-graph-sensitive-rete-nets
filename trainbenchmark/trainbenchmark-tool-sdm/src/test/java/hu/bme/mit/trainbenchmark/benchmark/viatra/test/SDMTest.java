/*******************************************************************************
 * Copyright (c) 2010-2015, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Matthias Barkowsky - initial implementation
 *******************************************************************************/

package hu.bme.mit.trainbenchmark.benchmark.viatra.test;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigBase;
import hu.bme.mit.trainbenchmark.benchmark.runcomponents.BenchmarkResult;
import hu.bme.mit.trainbenchmark.benchmark.sdm.SDMBenchmarkScenario;
import hu.bme.mit.trainbenchmark.benchmark.sdm.config.SDMBenchmarkConfig;
import hu.bme.mit.trainbenchmark.benchmark.sdm.config.SDMBenchmarkConfigBuilder;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.benchmark.test.TrainBenchmarkTest;

public class SDMTest extends TrainBenchmarkTest {

	@Override
	protected BenchmarkResult runTest(final BenchmarkConfigBase bcb) throws Exception {
		final SDMBenchmarkConfig bc = new SDMBenchmarkConfigBuilder().setConfigBase(bcb).setType(DriverType.DYNAMIC).createConfig();
		final SDMBenchmarkScenario scenario = new SDMBenchmarkScenario(bc);
		final BenchmarkResult result = scenario.performBenchmark();
		return result;
	}

}
