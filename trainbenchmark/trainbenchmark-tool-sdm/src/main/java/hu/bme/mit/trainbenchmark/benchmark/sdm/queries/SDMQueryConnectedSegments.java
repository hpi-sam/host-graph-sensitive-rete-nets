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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfConnectedSegmentsMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Sensor;
import hu.bme.mit.trainbenchmark.railway.Segment;

public class SDMQueryConnectedSegments extends SDMQuery<EmfConnectedSegmentsMatch> {

	public SDMQueryConnectedSegments(SDMDriver driver) {
		super(RailwayQuery.CONNECTEDSEGMENTS, driver);
	}

	@Override
	protected String getPatternName() {
		return "ConnectedSegments";
	}

	@Override
	protected EmfConnectedSegmentsMatch encodeTuple(ReteTuple tuple) {
		if(driver.getType() == DriverType.EMULATE) {
			return new EmfConnectedSegmentsMatch((Sensor) tuple.get(2), (Segment) tuple.get(6), (Segment) tuple.get(5),
					(Segment) tuple.get(4), (Segment) tuple.get(3), (Segment) tuple.get(1), (Segment) tuple.get(0));
		}
		else {
			return new EmfConnectedSegmentsMatch((Sensor) tuple.get(0), (Segment) tuple.get(1), (Segment) tuple.get(2),
					(Segment) tuple.get(3), (Segment) tuple.get(4), (Segment) tuple.get(5), (Segment) tuple.get(6));
		}
	}

}
