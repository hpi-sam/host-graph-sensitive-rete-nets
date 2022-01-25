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
package hu.bme.mit.trainbenchmark.benchmark.sdm.operations;

import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfConnectedSegmentsInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfConnectedSegmentsMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfPosLengthInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfPosLengthMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfRouteSensorInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfRouteSensorMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSemaphoreNeighborInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchMonitoredInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchMonitoredMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchSetInjectMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.matches.EmfSwitchSetMatch;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.EmfTransformation;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectConnectedSegments;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectPosLength;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectRouteSensor;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectSemaphoreNeighbor;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectSwitchMonitored;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.inject.EmfTransformationInjectSwitchSet;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.query.EmfApiQuery;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairConnectedSegments;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairPosLength;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairRouteSensor;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairSemaphoreNeighbor;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairSwitchMonitored;
import hu.bme.mit.trainbenchmark.benchmark.emf.transformation.repair.EmfTransformationRepairSwitchSet;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQueryConnectedSegments;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQueryPosLength;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQueryRouteSensor;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQuerySemaphoreNeighbor;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQuerySwitchMonitored;
import hu.bme.mit.trainbenchmark.benchmark.emfapi.queries.EmfApiQuerySwitchSet;
import hu.bme.mit.trainbenchmark.benchmark.operations.ModelOperation;
import hu.bme.mit.trainbenchmark.benchmark.operations.ModelOperationFactory;
import hu.bme.mit.trainbenchmark.benchmark.sdm.driver.SDMDriver;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuery;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryConnectedSegments;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryConnectedSegmentsInject;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryPosLength;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryPosLengthInject;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryRouteSensor;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQueryRouteSensorInject;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySemaphoreNeighbor;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySemaphoreNeighborInject;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySwitchMonitored;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySwitchMonitoredInject;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySwitchSet;
import hu.bme.mit.trainbenchmark.benchmark.sdm.queries.SDMQuerySwitchSetInject;
import hu.bme.mit.trainbenchmark.constants.RailwayOperation;

public class SDMModelOperationFactory extends ModelOperationFactory<EmfMatch, SDMDriver> {

	@Override
	public ModelOperation<? extends EmfMatch, SDMDriver> createOperation(final RailwayOperation operationEnum, final String workspaceDir,
			final SDMDriver driver) throws Exception {

		switch (operationEnum) {
			// ConnectedSegments
		case CONNECTEDSEGMENTS: {
			final SDMQuery<EmfConnectedSegmentsMatch> query = new SDMQueryConnectedSegments(driver);
			final ModelOperation<EmfConnectedSegmentsMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case CONNECTEDSEGMENTS_INJECT: {
			final SDMQuery<EmfConnectedSegmentsInjectMatch> query = new SDMQueryConnectedSegmentsInject(driver);
			final EmfTransformation<EmfConnectedSegmentsInjectMatch, SDMDriver> transformation = new EmfTransformationInjectConnectedSegments<>(driver);
			final ModelOperation<EmfConnectedSegmentsInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;

		}
		case CONNECTEDSEGMENTS_REPAIR: {
			final EmfApiQuery<EmfConnectedSegmentsMatch, SDMDriver> query = new EmfApiQueryConnectedSegments<>(driver);
			final EmfTransformation<EmfConnectedSegmentsMatch, SDMDriver> transformation = new EmfTransformationRepairConnectedSegments<>(driver);
			final ModelOperation<EmfConnectedSegmentsMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}

			// PosLength
		case POSLENGTH: {
			final SDMQuery<EmfPosLengthMatch> query = new SDMQueryPosLength(driver);
			final ModelOperation<EmfPosLengthMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case POSLENGTH_INJECT: {
			final SDMQuery<EmfPosLengthInjectMatch> query = new SDMQueryPosLengthInject(driver);
			final EmfTransformation<EmfPosLengthInjectMatch, SDMDriver> transformation = new EmfTransformationInjectPosLength<>(driver);
			final ModelOperation<EmfPosLengthInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		case POSLENGTH_REPAIR: {
			final EmfApiQuery<EmfPosLengthMatch, SDMDriver> query = new EmfApiQueryPosLength<>(driver);
			final EmfTransformation<EmfPosLengthMatch, SDMDriver> transformation = new EmfTransformationRepairPosLength<>(driver);
			final ModelOperation<EmfPosLengthMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}

			// RouteSensor
		case ROUTESENSOR: {
			final SDMQuery<EmfRouteSensorMatch> query = new SDMQueryRouteSensor(driver);
			final ModelOperation<EmfRouteSensorMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case ROUTESENSOR_INJECT: {
			final SDMQuery<EmfRouteSensorInjectMatch> query = new SDMQueryRouteSensorInject(driver);
			final EmfTransformation<EmfRouteSensorInjectMatch, SDMDriver> transformation = new EmfTransformationInjectRouteSensor<>(driver);
			final ModelOperation<EmfRouteSensorInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		case ROUTESENSOR_REPAIR: {
			final EmfApiQuery<EmfRouteSensorMatch, SDMDriver> query = new EmfApiQueryRouteSensor<>(driver);
			final EmfTransformation<EmfRouteSensorMatch, SDMDriver> transformation = new EmfTransformationRepairRouteSensor<>(driver);
			final ModelOperation<EmfRouteSensorMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}

			// SemaphoreNeighbor
		case SEMAPHORENEIGHBOR: {
			final SDMQuery<EmfSemaphoreNeighborMatch> query = new SDMQuerySemaphoreNeighbor(driver);
			final ModelOperation<EmfSemaphoreNeighborMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case SEMAPHORENEIGHBOR_INJECT: {
			final SDMQuery<EmfSemaphoreNeighborInjectMatch> query = new SDMQuerySemaphoreNeighborInject(driver);
			final EmfTransformation<EmfSemaphoreNeighborInjectMatch, SDMDriver> transformation = new EmfTransformationInjectSemaphoreNeighbor<>(driver);
			final ModelOperation<EmfSemaphoreNeighborInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		case SEMAPHORENEIGHBOR_REPAIR: {
			final EmfApiQuery<EmfSemaphoreNeighborMatch, SDMDriver> query = new EmfApiQuerySemaphoreNeighbor<>(driver);
			final EmfTransformation<EmfSemaphoreNeighborMatch, SDMDriver> transformation = new EmfTransformationRepairSemaphoreNeighbor<>(driver);
			final ModelOperation<EmfSemaphoreNeighborMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}

			// SwitchMonitored
		case SWITCHMONITORED: {
			final SDMQuery<EmfSwitchMonitoredMatch> query = new SDMQuerySwitchMonitored(driver);
			final ModelOperation<EmfSwitchMonitoredMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case SWITCHMONITORED_INJECT: {
			final SDMQuery<EmfSwitchMonitoredInjectMatch> query = new SDMQuerySwitchMonitoredInject(driver);
			final EmfTransformation<EmfSwitchMonitoredInjectMatch, SDMDriver> transformation = new EmfTransformationInjectSwitchMonitored<>(driver);
			final ModelOperation<EmfSwitchMonitoredInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		case SWITCHMONITORED_REPAIR: {
			final EmfApiQuery<EmfSwitchMonitoredMatch, SDMDriver> query = new EmfApiQuerySwitchMonitored<>(driver);
			final EmfTransformation<EmfSwitchMonitoredMatch, SDMDriver> transformation = new EmfTransformationRepairSwitchMonitored<>(driver);
			final ModelOperation<EmfSwitchMonitoredMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}

			// SwitchSet
		case SWITCHSET: {
			final SDMQuery<EmfSwitchSetMatch> query = new SDMQuerySwitchSet(driver);
			final ModelOperation<EmfSwitchSetMatch, SDMDriver> operation = ModelOperation.of(query);
			return operation;
		}
		case SWITCHSET_INJECT: {
			final SDMQuery<EmfSwitchSetInjectMatch> query = new SDMQuerySwitchSetInject(driver);
			final EmfTransformation<EmfSwitchSetInjectMatch, SDMDriver> transformation = new EmfTransformationInjectSwitchSet<>(driver);
			final ModelOperation<EmfSwitchSetInjectMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		case SWITCHSET_REPAIR: {
			final EmfApiQuery<EmfSwitchSetMatch, SDMDriver> query = new EmfApiQuerySwitchSet<>(driver);
			final EmfTransformation<EmfSwitchSetMatch, SDMDriver> transformation = new EmfTransformationRepairSwitchSet<>(driver);
			final ModelOperation<EmfSwitchSetMatch, SDMDriver> operation = ModelOperation.of(query, transformation);
			return operation;
		}
		default:
			break;
		}
		throw new UnsupportedOperationException("Operation " + operationEnum + " not supported.");
	}

}
