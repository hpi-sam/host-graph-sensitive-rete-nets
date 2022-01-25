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

import com.google.common.base.Preconditions;

import hu.bme.mit.trainbenchmark.benchmark.config.BenchmarkConfigBuilder;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;

public class SDMBenchmarkConfigBuilder
		extends BenchmarkConfigBuilder<SDMBenchmarkConfig, SDMBenchmarkConfigBuilder> {

	private DriverType type;

	@Override
	public SDMBenchmarkConfig createConfig() {
		checkNotNulls();
		return new SDMBenchmarkConfig(configBase, type);
	}
	
	@Override
	public void checkNotNulls() {
		super.checkNotNulls();
		Preconditions.checkNotNull(type);
	}

	public SDMBenchmarkConfigBuilder setType(final DriverType type) {
		this.type = type;
		return this;
	}

}
