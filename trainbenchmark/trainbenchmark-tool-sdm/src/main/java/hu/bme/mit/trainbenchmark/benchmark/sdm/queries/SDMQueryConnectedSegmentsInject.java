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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfConnectedSegmentsInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Sensor;
import hu.bme.mit.trainbenchmark.railway.Segment;

public class SDMQueryConnectedSegmentsInject extends SDMQuery<EmfConnectedSegmentsInjectMatch> {

	public SDMQueryConnectedSegmentsInject(SDMDriver driver) {
		super(RailwayQuery.CONNECTEDSEGMENTS_INJECT, driver);
	}

	@Override
	protected String getPatternName() {
		return "ConnectedSegmentsInject";
	}

	@Override
	protected EmfConnectedSegmentsInjectMatch encodeTuple(ReteTuple tuple) {
		if(driver.getType() == DriverType.EMULATE) {
			return new EmfConnectedSegmentsInjectMatch((Sensor) tuple.get(2), (Segment) tuple.get(0), (Segment) tuple.get(1));
		}
		else {
			return new EmfConnectedSegmentsInjectMatch((Sensor) tuple.get(0), (Segment) tuple.get(1), (Segment) tuple.get(2));
		}
	}

}
