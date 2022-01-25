package de.mdelab.mlsdm.interpreter.incremental.rete;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.mdelab.mlsdm.interpreter.incremental.SDMQuery;
import de.mdelab.mlsdm.interpreter.incremental.SDMQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.SDMQueryMatch;
import de.mdelab.mlsdm.interpreter.incremental.change.SDMChangeEvent;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteResultProvider;

public class ReteSDMWrapper extends SDMQuery {

	private ReteResultProvider resultProvider;

	public ReteSDMWrapper(ReteResultProvider resultProvider) {
		this(null, resultProvider);
	}

	public ReteSDMWrapper(SDMQueryManager manager, ReteResultProvider resultProvider) {
		super(manager);
		this.resultProvider = resultProvider;
	}

	@Override
	public void updateMatches() {
		
	}
	
	@Override
	public void registerChange(SDMChangeEvent change) {
		
	}

	@Override
	public void findInitialMatches() {

	}

	@Override
	public Iterator<SDMQueryMatch> getMatches() {
		return new Iterator<SDMQueryMatch>() {

			Iterator<? extends List<Object>> matchIt = resultProvider.getTuples(Collections.emptyList()).iterator();
			
			@Override
			public boolean hasNext() {
				return matchIt.hasNext();
			}

			@Override
			public SDMQueryMatch next() {
				matchIt.next();
				return null;	//TODO wrap into SDMQueryMatch
			}
			
		};
	}

	public ReteResultProvider getResultProvider() {
		return resultProvider;
	}
}
