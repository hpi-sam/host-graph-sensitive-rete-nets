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
package hu.bme.mit.trainbenchmark.benchmark.sdm.config;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigBase;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;

public class SDMBenchmarkConfig extends BenchmarkConfig {

	private DriverType type;

	public SDMBenchmarkConfig(final BenchmarkConfigBase configBase, DriverType type) {
		super(configBase);
		this.type = type;
	}
	
	@Override
	public String getToolName() {
		return String.format(getType().toString());
	}

	@Override
	public String getProjectName() {
		return "sdm";
	}

	public DriverType getType() {
		return type;
	}

}
