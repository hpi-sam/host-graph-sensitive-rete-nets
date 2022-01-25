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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfRouteSensorInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Route;
import hu.bme.mit.trainbenchmark.railway.Sensor;

public class SDMQueryRouteSensorInject extends SDMQuery<EmfRouteSensorInjectMatch> {

	public SDMQueryRouteSensorInject(SDMDriver driver) {
		super(RailwayQuery.ROUTESENSOR_INJECT, driver);
	}

	@Override
	protected String getPatternName() {
		return "RouteSensorInject";
	}

	@Override
	protected EmfRouteSensorInjectMatch encodeTuple(ReteTuple tuple) {
		EmfRouteSensorInjectMatch match = new EmfRouteSensorInjectMatch((Route) tuple.get(0), (Sensor) tuple.get(1));
		return match;
	}

}
