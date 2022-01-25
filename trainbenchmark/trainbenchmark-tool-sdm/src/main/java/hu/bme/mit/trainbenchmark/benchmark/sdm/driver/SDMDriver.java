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
package hu.bme.mit.trainbenchmark.benchmark.sdm.driver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.mdelab.mlsdm.gdn.GDN;
import de.mdelab.mlsdm.gdn.GdnPackage;
import de.mdelab.mlsdm.interpreter.incremental.IncrementalQueryManager.FlushStatus;
import de.mdelab.mlsdm.interpreter.incremental.rete.GDNReteBuilder;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteNet;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.ReteSDMWrapper;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.DynamicReteQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.EventNumberBasedQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.NetSizeBasedQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.dynamic.StaticNetQueryManager;
import de.mdelab.mlsdm.interpreter.incremental.rete.nodes.ReteResultProvider;
import de.mdelab.mlstorypatterns.MlstorypatternsPackage;
import de.mdelab.mlstorypatterns.StoryPattern;
import de.mdelab.sdm.interpreter.core.SDMException;
import hu.bme.mit.trainbenchmark.benchmark.emf.driver.EmfDriver;
import hu.bme.mit.trainbenchmark.railway.RailwayPackage;

public class SDMDriver extends EmfDriver {
	
	public static enum DriverType {DYNAMIC, EMULATE, STATIC}
	
	private Map<Object, ReteResultProvider> resultProviders;
	private Map<String, StoryPattern> patterns;
	private Map<String, GDN> gdns;
	private ResourceSet rs;
	private DriverType type;
	
	public SDMDriver(DriverType type) {
		super();
		this.type = type;
		
		RailwayPackage.eINSTANCE.eClass();
		MlstorypatternsPackage.eINSTANCE.eClass();
		GdnPackage.eINSTANCE.eClass();

		this.rs = new ResourceSetImpl();
		this.rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mlsp", new XMIResourceFactoryImpl());
		this.rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gdn", new XMIResourceFactoryImpl());

		this.resultProviders = new HashMap<Object, ReteResultProvider>();
		this.patterns = new HashMap<String, StoryPattern>();
		this.gdns = new HashMap<String, GDN>();
	}

	public DriverType getType() {
		return type;
	}

	public ReteResultProvider getResultProvider(String name) {
		if(type == DriverType.DYNAMIC || type == DriverType.STATIC) {
			StoryPattern pattern = getPattern(name);
			if(!resultProviders.containsKey(pattern)) {
				resultProviders.put(pattern, createResultProvider(pattern));
			}
			return resultProviders.get(pattern);
		}
		else {
			GDN gdn = getGDN(name);
			if(!resultProviders.containsKey(gdn)) {
				resultProviders.put(gdn, createResultProvider(gdn));
			}
			return resultProviders.get(gdn);
		}
	}

	private ReteResultProvider createResultProvider(GDN gdn) {
		ReteQueryManager queryManager = new ReteQueryManager();
		queryManager.setFlushing(FlushStatus.FLUSH);
		
		ReteResultProvider resultProvider = ((ReteSDMWrapper)new GDNReteBuilder().buildReteQuery(gdn, queryManager)).getResultProvider();
		ReteNet net = resultProvider.getNet();
		queryManager.registerReteNet(net);

		queryManager.registerEObject(container);
		
		return resultProvider;
	}

	private GDN getGDN(String name) {
		if(!gdns.containsKey(name)) {
			gdns.put(name, (GDN) loadEObject(URI.createFileURI("../trainbenchmark-tool-sdm/src/main/gdn/" + name + ".gdn")));
		}
		return gdns.get(name);
	}

	private ReteResultProvider createResultProvider(StoryPattern pattern) {
		DynamicReteQueryManager qm = null;
		try {
			if(type == DriverType.DYNAMIC) {
				qm = new NetSizeBasedQueryManager(pattern, container);
			}
			else if(type == DriverType.STATIC) {
				qm = new StaticNetQueryManager(pattern, container);
			}
			qm.setFlushing(FlushStatus.FLUSH);
		} catch (SDMException e) {
			e.printStackTrace();
		}
		return qm.getResultProvider();
	}

	public StoryPattern getPattern(String name) {
		if(!patterns.containsKey(name)) {
			patterns.put(name, (StoryPattern) loadEObject(URI.createFileURI("../trainbenchmark-tool-sdm/src/main/pattern/" + name + ".mlsp")));
		}
		return patterns.get(name);
	}

	private EObject loadEObject(URI uri) {
		Resource r = rs.createResource(uri);
		try {
			r.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r.getContents().get(0);
	}

}
