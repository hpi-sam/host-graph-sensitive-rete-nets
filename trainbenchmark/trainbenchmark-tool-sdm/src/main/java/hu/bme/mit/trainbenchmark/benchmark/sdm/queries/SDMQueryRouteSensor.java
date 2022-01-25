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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfRouteSensorMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Route;
import hu.bme.mit.trainbenchmark.railway.Sensor;
import hu.bme.mit.trainbenchmark.railway.Switch;
import hu.bme.mit.trainbenchmark.railway.SwitchPosition;

public class SDMQueryRouteSensor extends SDMQuery<EmfRouteSensorMatch> {

	public SDMQueryRouteSensor(SDMDriver driver) {
		super(RailwayQuery.ROUTESENSOR, driver);
	}

	@Override
	protected String getPatternName() {
		return "RouteSensor";
	}

	@Override
	protected EmfRouteSensorMatch encodeTuple(ReteTuple tuple) {
		if(driver.getType() == DriverType.EMULATE) {
			return new EmfRouteSensorMatch((Route) tuple.get(3), (Sensor) tuple.get(1),
					(SwitchPosition) tuple.get(2), (Switch) tuple.get(0));
		}
		else {
			return new EmfRouteSensorMatch((Route) tuple.get(0), (Sensor) tuple.get(1),
					(SwitchPosition) tuple.get(2), (Switch) tuple.get(3));
		}
	}

}
