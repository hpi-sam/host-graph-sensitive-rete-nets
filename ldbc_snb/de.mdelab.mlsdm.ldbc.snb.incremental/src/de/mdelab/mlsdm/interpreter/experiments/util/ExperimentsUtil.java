package de.mdelab.mlsdm.interpreter.experiments.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.mlsdm.MlsdmPackage;
import de.mdelab.mlsdm.gdn.GDN;
import de.mdelab.mlsdm.gdn.GdnPackage;
import de.mdelab.mlstorypatterns.MlstorypatternsPackage;
import de.mdelab.mlstorypatterns.StoryPattern;

public class ExperimentsUtil {

	public static void registerEPackages() {
		registerEPackage(EcorePackage.eINSTANCE);
		registerEPackage(MlstorypatternsPackage.eINSTANCE);
		registerEPackage(MlsdmPackage.eINSTANCE);
		registerEPackage(Ldbc_snbPackage.eINSTANCE);
		registerEPackage(GdnPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mlsp", new XMIResourceFactoryImpl());
	}
	
	public static void registerEPackage(EPackage pkg) {
		//register ResourceFactory for loading models
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(pkg.getName().toLowerCase(), new XMIResourceFactoryImpl());
	}
	
	public static StoryPattern readPattern(String ruleFile) {
		return (StoryPattern) readEObject(ruleFile);
	}
	
	public static EObject readEObject(String file) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(file), true);
		try {
			r.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r.getContents().get(0);
	}

	public static EClassifier getEClassifier(Object value) {
		if(value instanceof Long) {
			return EcorePackage.Literals.ELONG;
		}
		else if(value instanceof String) {
			return EcorePackage.Literals.ESTRING;
		}
		else if(value instanceof EObject) {
			return ((EObject) value).eClass();
		}
		else {
			return EcorePackage.Literals.EJAVA_OBJECT;
		}
	}

	public static GDN readGDN(String ruleFile) {
		return (GDN) readEObject(ruleFile);
	}

}
