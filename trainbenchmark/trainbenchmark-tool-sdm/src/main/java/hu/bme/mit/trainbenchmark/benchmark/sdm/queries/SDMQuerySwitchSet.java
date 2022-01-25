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
package hu.bme.mit.trainbenchmark.benchmark.sdm.queries;

import de.mdelab.mlsdm.interpreter.incremental.rete.util.ReteTuple;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchSetMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Route;
import hu.bme.mit.trainbenchmark.railway.Semaphore;
import hu.bme.mit.trainbenchmark.railway.Switch;
import hu.bme.mit.trainbenchmark.railway.SwitchPosition;

public class SDMQuerySwitchSet extends SDMQuery<EmfSwitchSetMatch> {

	public SDMQuerySwitchSet(SDMDriver driver) {
		super(RailwayQuery.SWITCHSET, driver);
	}

	@Override
	protected String getPatternName() {
		return "SwitchSet";
	}

	@Override
	protected EmfSwitchSetMatch encodeTuple(ReteTuple tuple) {
		if(driver.getType() == DriverType.EMULATE) {
			return new EmfSwitchSetMatch((Semaphore) tuple.get(3), (Route) tuple.get(2), (SwitchPosition) tuple.get(0), (Switch) tuple.get(1));
		}
		else {
			return new EmfSwitchSetMatch((Semaphore) tuple.get(0), (Route) tuple.get(1), (SwitchPosition) tuple.get(2), (Switch) tuple.get(3));
		}
	}

}
