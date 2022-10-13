package de.mdelab.trainbenchmark.rete.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import de.mdelab.mlsdm.incremental.rete.tests.QueryTest;
import hu.bme.mit.trainbenchmark.railway.RailwayPackage;

public class TrainBenchmarkQueryTest extends QueryTest {

	@Before
	public void setUp() {
		registerEPackages();
	}

	@Override
	public void registerEPackages() {
		super.registerEPackages();
		registerEPackage(RailwayPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
	}

	@Override
	protected EObject getFullModel(String dataSet) {
		return readEObject("resource/instances/" + dataSet);
	}

	//batch tests

	@Test
	public void testConnectedSegmentsBatch() {
		testBatchQuery("ConnectedSegments.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testConnectedSegmentsInjectBatch() {
		testBatchQuery("ConnectedSegmentsInject.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testPosLengthBatch() {
		testBatchQuery("PosLength.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testPosLengthInjectBatch() {
		testBatchQuery("PosLengthInject.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testRouteSensorBatch() {
		testBatchQuery("RouteSensor.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testRouteSensorInjectBatch() {
		testBatchQuery("RouteSensorInject.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSemaphoreNeighborBatch() {
		testBatchQuery("SemaphoreNeighbor.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSemaphoreNeighborInjectBatch() {
		testBatchQuery("SemaphoreNeighborInject.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSwitchMonitoredBatch() {
		testBatchQuery("SwitchMonitored.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSwitchMonitoredInjectBatch() {
		testBatchQuery("SwitchMonitoredInject.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSwitchSetBatch() {
		testBatchQuery("SwitchSet.mlsp", "railway-inject-2.xmi");
	}

	@Test
	public void testSwitchSetInjectBatch() {
		testBatchQuery("SwitchSetInject.mlsp", "railway-inject-2.xmi");
	}

}
