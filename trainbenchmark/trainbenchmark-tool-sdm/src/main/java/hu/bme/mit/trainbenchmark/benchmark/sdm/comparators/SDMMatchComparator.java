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
package hu.bme.mit.trainbenchmark.benchmark.sdm.comparators;

import de.mdelab.mlsdm.interpreter.incremental.rete.util.ReteTuple;
import hu.bme.mit.trainbenchmark.benchmark.emf.comparators.RailwayElementComparator;
import hu.bme.mit.trainbenchmark.benchmark.matches.comparators.MatchComparator;
import hu.bme.mit.trainbenchmark.railway.RailwayElement;

public class SDMMatchComparator extends MatchComparator<ReteTuple, RailwayElement> {
 
	public SDMMatchComparator() {
		super(new RailwayElementComparator());
	}
	
	@Override
	public int compare(final ReteTuple o1, final ReteTuple o2) {
		final Object[] m1 = o1.toArray();
		final Object[] m2 = o2.toArray();
		return compareArrays(m1, m2);
	}

}
