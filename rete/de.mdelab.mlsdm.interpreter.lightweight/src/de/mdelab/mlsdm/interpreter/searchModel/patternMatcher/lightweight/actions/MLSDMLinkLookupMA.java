package de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.lightweight.actions;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.MLSDMReferenceIndex;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.MLSDMReferenceIndex.MLSDMReferenceAdapterTuple;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.lightweight.MLSDMLightweightMA;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.lightweight.MLSDMLightweightMatcher;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.lightweight.MLSDMLightweightPC;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.lightweight.MLSDMLightweightPN;

public class MLSDMLinkLookupMA extends MLSDMLightweightMA {

	private MLSDMReferenceIndex ra;
	private MLSDMLightweightPN source;
	private MLSDMLightweightPN target;
	private EReference feature;
	private Iterator<MLSDMReferenceAdapterTuple<EObject>> it;
	
	public MLSDMLinkLookupMA(MLSDMLightweightPC patternConstraint,
			MLSDMLightweightMatcher matcher,
			MLSDMLightweightPN source,
			MLSDMLightweightPN target,
			EReference feature,
			MLSDMReferenceIndex ra) {
		super(patternConstraint, matcher);
		this.source = source;
		this.target = target;
		this.feature = feature;
		this.ra = ra;
	}

	@Override
	protected double doEstimateCardinality() {
		return ra.getReferences(feature).size();
	}

	@Override
	protected boolean doApply() {
		if(it == null) {
			it = ra.getReferences(feature).iterator();
		}
		
		while(it.hasNext()) {
			MLSDMReferenceAdapterTuple<EObject> mapping = it.next();
			if(matcher.matchPatternNode(source, mapping.e1)) {
				if(matcher.matchPatternNode(target, mapping.e2)) {
					return true;
				}
				else {
					matcher.unmatchPatternNode(source);
				}
			}
		}
		return false;
	}

	@Override
	protected void doRollBack() {
		it = null;
	}

	@Override
	public void revertMapping() {
		matcher.unmatchPatternNode(source);
		matcher.unmatchPatternNode(target);
	}

	@Override
	public String toString() {
		return source.toString() + " -" + feature.getName() + "-> " + target.toString();
	}

}
