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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver.DriverType;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Route;
import hu.bme.mit.trainbenchmark.railway.Semaphore;
import hu.bme.mit.trainbenchmark.railway.Sensor;
import hu.bme.mit.trainbenchmark.railway.TrackElement;

public class SDMQuerySemaphoreNeighbor extends SDMQuery<EmfSemaphoreNeighborMatch> {

	public SDMQuerySemaphoreNeighbor(SDMDriver driver) {
		super(RailwayQuery.SEMAPHORENEIGHBOR, driver);
	}

	@Override
	protected String getPatternName() {
		return "SemaphoreNeighbor";
	}

	@Override
	protected EmfSemaphoreNeighborMatch encodeTuple(ReteTuple tuple) {
		if(driver.getType() == DriverType.EMULATE) {
			return new EmfSemaphoreNeighborMatch((Semaphore) tuple.get(6), (Route) tuple.get(5), (Route) tuple.get(2), (Sensor) tuple.get(4),
					(Sensor) tuple.get(1), (TrackElement) tuple.get(3), (TrackElement) tuple.get(0));
		}
		else {
			return new EmfSemaphoreNeighborMatch((Semaphore) tuple.get(0), (Route) tuple.get(1), (Route) tuple.get(2), (Sensor) tuple.get(3),
					(Sensor) tuple.get(4), (TrackElement) tuple.get(5), (TrackElement) tuple.get(6));
		}
	}

}
