package de.mdelab.mlsdm.interpreter.incremental;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.mlexpressions.MLExpression;
import de.mdelab.mlexpressions.MLStringExpression;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.MLSDMMetadataIndex;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.icl.iCL.ICLExpression;
import de.mdelab.sdm.interpreter.core.SDMException;
import de.mdelab.sdm.interpreter.icl.ICLExpressionInterpreter;

public class SDMQueryManager extends IncrementalQueryManager {

	private MLSDMMetadataIndex metadataIndex;
	
	protected Map<StoryPattern, SDMQuery> registeredQueries;
	private ICLExpressionInterpreter<MLExpression> iclInterpreter;
	private Map<MLExpression, ICLExpression> iclExpressions;
	
	public SDMQueryManager() {
		this.metadataIndex = new MLSDMMetadataIndex();
		this.registeredQueries = new HashMap<StoryPattern, SDMQuery>();
		this.notificationReceivers = new ArrayList<QueryManagerNotificationReceiver>();
		this.iclInterpreter = new ICLExpressionInterpreter<MLExpression>();
		this.iclExpressions = new HashMap<MLExpression, ICLExpression>();
	}
	
	public MLSDMMetadataIndex getMetadataIndex() {
		return metadataIndex;
	}

	@Override
	public void registerEObjects(Collection<EObject> eObjects) {
		super.registerEObjects(eObjects);
		metadataIndex.registerEObjects(eObjects);
	}
	
	@Override
	public void removeEObject(EObject eObject) {
		super.removeEObject(eObject);
		metadataIndex.removeEObject(eObject);
	}
	
	public boolean isRegistered(StoryPattern storyPattern) {
		return registeredQueries.containsKey(storyPattern);
	}

	public Iterator<? extends Map<String, Object>> getMatches(StoryPattern storyPattern) throws SDMException {
		SDMQuery query = registeredQueries.get(storyPattern);
		if(query == null) {
			throw new SDMException("query not registered: " + storyPattern.getName());
		}
		return query.getMatches();
	}
	
	protected ICLExpression getAST(MLExpression expression) throws IOException {
		if(iclExpressions.containsKey(expression)) {
			return iclExpressions.get(expression);
		}
		else {
			ICLExpression ast = iclInterpreter.parseExpression(((MLStringExpression) expression).getExpressionString());
			iclExpressions.put(expression, ast);
			return ast;
		}
	}
}
