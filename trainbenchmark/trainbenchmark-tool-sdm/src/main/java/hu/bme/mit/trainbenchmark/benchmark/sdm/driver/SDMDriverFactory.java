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
package hu.bme.mit.trainbenchmark.benchmark.sdm.driver;

import hu.bme.mit.trainbenchmark.benchmark.driver.DriverFactory;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;

public class SDMDriverFactory extends DriverFactory<SDMDriver> {

	private DriverType type;

	public SDMDriverFactory(final DriverType type) {
		super();
		this.type = type;
	}
	
	@Override
	public SDMDriver createInstance() throws Exception {
		return new SDMDriver(type);
	}

}
