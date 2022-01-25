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
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchMonitoredInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;
import hu.bme.mit.trainbenchmark.railway.Switch;

public class SDMQuerySwitchMonitoredInject extends SDMQuery<EmfSwitchMonitoredInjectMatch> {

	public SDMQuerySwitchMonitoredInject(SDMDriver driver) {
		super(RailwayQuery.SWITCHMONITORED_INJECT, driver);
	}

	@Override
	protected String getPatternName() {
		return "SwitchMonitoredInject";
	}

	@Override
	protected EmfSwitchMonitoredInjectMatch encodeTuple(ReteTuple tuple) {
		EmfSwitchMonitoredInjectMatch match = new EmfSwitchMonitoredInjectMatch((Switch) tuple.get(0));
		return match;
	}

}
