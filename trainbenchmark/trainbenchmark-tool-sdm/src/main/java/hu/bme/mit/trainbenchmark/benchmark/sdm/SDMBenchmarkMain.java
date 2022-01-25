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
package hu.bme.mit.trainbenchmark.benchmark.sdm;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.benchmark.sdm.config.SDMBenchmarkConfig;

public class SDMBenchmarkMain {

	public static void main(final String[] args) throws Exception {
		final SDMBenchmarkConfig bc = BenchmarkConfig.fromFile(args[0], SDMBenchmarkConfig.class);
		final SDMBenchmarkScenario scenario = new SDMBenchmarkScenario(bc);
		scenario.performBenchmark();
	}

}
