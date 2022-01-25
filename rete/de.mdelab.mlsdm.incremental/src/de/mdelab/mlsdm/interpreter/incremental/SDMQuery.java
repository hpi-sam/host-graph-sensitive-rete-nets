package de.mdelab.mlsdm.interpreter.incremental;

import java.util.Iterator;

public abstract class SDMQuery implements ChangeListener {

	protected SDMQueryManager manager;
	
	public SDMQuery(SDMQueryManager manager) {
		this.manager = manager;
	}
	
	public abstract void findInitialMatches();
	
	public abstract Iterator<SDMQueryMatch> getMatches();
	
	public void updateMatches() {
		manager.flushUnhandledEvents();
	}
	
}
