package de.mdelab.ldbc.snb.incremental.rete.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.log.LDBC_SNBLogReader;
import de.mdelab.mlsdm.gdn.GDN;
import de.mdelab.mlsdm.incremental.rete.tests.QueryTest;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteResultProvider;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.interpreter.core.SDMException;

public class LDBCQueryTest extends QueryTest {
	
	@Override
	public void registerEPackages() {
		super.registerEPackages();
		registerEPackage(Ldbc_snbPackage.eINSTANCE);
	}

	public void testIncrementalQueryGDN(String queryName, String patternName, String dataSet) {
		GDN gdn = readGDN(queryName);
		StoryPattern pattern = readPattern(patternName);
		LDBC_SNBLogReader logReader = getLogReader(dataSet);
		
		//replay prefix
		
		for(int i = 0; i < logReader.getLogSize() - 1000; i++) {
			logReader.executeNextAction();
		}
		EObject model = logReader.getModel();
		
		//test correctness of result after prefix
		
		ReteQueryManager queryManager = createGDNQueryManager();
		ReteResultProvider resultProvider = getGDNResultProvider(gdn, queryManager, model);
		
		int result = countMatches(resultProvider);
		
		int reference = -1;
		try {
			reference = findMatchesReference(pattern, model).size();
		} catch (SDMException e) {
			fail();
		}

		assertEquals(result, reference);
		
		//replay remaining log
		
		while(logReader.hasNextElement()) {
			logReader.executeNextAction();
		}

		//test correctness of result for final model
		
		queryManager.flushUnhandledEvents();
		result = countMatches(resultProvider);
		
		try {
			reference = findMatchesReference(pattern, model).size();
		} catch (SDMException e) {
			fail();
		}
		
		assertEquals(result, reference);
	}

	public void testIncrementalQueryStatic(String queryName, String dataSet) {
		StoryPattern pattern = readPattern(queryName);
		LDBC_SNBLogReader logReader = getLogReader(dataSet);
		
		//replay prefix
		
		for(int i = 0; i < logReader.getLogSize() - 1000; i++) {
			logReader.executeNextAction();
		}
		EObject model = logReader.getModel();
		
		//test correctness of result after prefix
		
		DynamicReteQueryManager queryManager = null;
		try {
			queryManager = createStaticReteQueryManager(pattern, model);
		} catch (SDMException e1) {
			fail();
		}
		
		Set<Map<String, Object>> result = getMatches(queryManager);
		
		Set<Map<String, Object>> reference = null;
		try {
			reference = findMatchesReference(pattern, model);
		} catch (SDMException e) {
			fail();
		}

		assertEquals(result, reference);
		
		//replay remaining log
		
		while(logReader.hasNextElement()) {
			logReader.executeNextAction();
		}

		//test correctness of result for final model
		
		queryManager.flushUnhandledEvents();
		result = getMatches(queryManager);
		
		try {
			reference = findMatchesReference(pattern, model);
		} catch (SDMException e) {
			fail();
		}
		
		assertEquals(result, reference);
	}

	public void testIncrementalQueryDynamic(String queryName, String dataSet) {
		StoryPattern pattern = readPattern(queryName);
		LDBC_SNBLogReader logReader = getLogReader(dataSet);
		EObject model = logReader.getModel();

		DynamicReteQueryManager queryManager = null;
		try {
			queryManager = createDynamicReteQueryManager(pattern, model);
		} catch (SDMException e1) {
			fail();
		}
		
		//replay prefix

		for(int i = 0; i < logReader.getLogSize() - 1000; i++) {
			logReader.executeNextAction();
		}
		
		//test correctness of result after prefix
		
		queryManager.flushUnhandledEvents();
		Set<Map<String, Object>> result = getMatches(queryManager);
		
		Set<Map<String, Object>> reference = null;
		try {
			reference = findMatchesReference(pattern, model);
		} catch (SDMException e) {
			fail();
		}

		assertEquals(result, reference);
		
		//replay remaining log
		
		while(logReader.hasNextElement()) {
			logReader.executeNextAction();
		}

		//test correctness of result for final model
		
		queryManager.flushUnhandledEvents();
		result = getMatches(queryManager);
		
		try {
			reference = findMatchesReference(pattern, model);
		} catch (SDMException e) {
			fail();
		}
		
		assertEquals(result, reference);
	}

	@Override
	protected EObject getFullModel(String dataSet) {
		LDBC_SNBLogReader logReader = getLogReader(dataSet);
		while(logReader.hasNextElement()) {
			logReader.executeNextAction();
		}
		return logReader.getModel();
	}

	protected LDBC_SNBLogReader getLogReader(String dataSet) {
		try {
			LDBC_SNBLogReader logReader = new LDBC_SNBLogReader("resource/instances/" + dataSet);
			return logReader;
		} catch (IOException e1) {
			fail();
		}
		return null;
	}

}
