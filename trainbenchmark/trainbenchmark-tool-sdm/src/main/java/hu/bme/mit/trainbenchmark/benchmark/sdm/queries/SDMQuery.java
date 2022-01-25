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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import de.mdelab.mlsdm.interpreter.incremental.rete.ReteNotificationReceiver;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteNotifier;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteResultProvider;
import de.mdelab.mlsdm.interpreter.incremental.rete.util.ReteTuple;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.operations.ModelQuery;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.constants.RailwayQuery;

public abstract class SDMQuery<TMatch extends EmfMatch> extends ModelQuery<TMatch, SDMDriver> {

	protected Collection<TMatch> matches;

	public SDMQuery(final RailwayQuery query, final SDMDriver driver) {
		super(query, driver);
	}

	@Override
	public Collection<TMatch> evaluate() {
		if(matches == null) {
			matches = new HashSet<TMatch>();
			
			ReteResultProvider resultProvider = driver.getResultProvider(getPatternName());
			Collection<ReteTuple> tuples = resultProvider.getTuples(Collections.emptyList());
			for(ReteTuple tuple:tuples) {
				matches.add(encodeTuple(tuple));
			}
			resultProvider.addNotificationReceiver(new ReteNotificationReceiver() {
				
				@Override
				public void notifyRemoval(ReteTuple tuple, ReteNotifier notifier) {
					matches.remove(encodeTuple(tuple));
				}
				
				@Override
				public void notifyAddition(ReteTuple tuple, ReteNotifier notifier) {
					matches.add(encodeTuple(tuple));
				}
			});
		}
		return matches;
	}

	protected abstract String getPatternName();

	protected abstract TMatch encodeTuple(ReteTuple tuple);

}
