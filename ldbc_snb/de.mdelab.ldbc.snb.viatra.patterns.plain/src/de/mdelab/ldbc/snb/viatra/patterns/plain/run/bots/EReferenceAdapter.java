package de.mdelab.ldbc.snb.viatra.patterns.plain.run.bots;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class EReferenceAdapter implements Adapter {

	/*
	 * Set of all objects registered at this reference adapter
	 */
	protected Set<EObject> registeredObjects;

	public EReferenceAdapter() {
		registeredObjects = new LinkedHashSet<EObject>();
	}

	/**
	 * Registers a new instance object at this adapter.
	 * 
	 * @param eObject
	 * 			The instance object.
	 */
	public void registerEObject(EObject eObject) {
		registerEObjects(Collections.singletonList(eObject));
	}
	
	/**
	 * Registers all instance objects in a given collection of
	 * instance objects.
	 * 
	 * @param eObjects
	 * 			The collection of objects to register.
	 */
	@SuppressWarnings("unchecked")
	public void registerEObjects(Collection<EObject> eObjects) {
		/*
		 * Loop to register all objects in the transitive closure.
		 */
		while(!eObjects.isEmpty()) {
			/*
			 * Store all new objects found by traversing links from
			 * instance objects in the current collection to consider
			 * them in the next execution of the loop.
			 */
			Set<EObject> newlyAddedObjects = new LinkedHashSet<EObject>();
			
			for(EObject eObject:eObjects) {
				if(registeredObjects.contains(eObject)) {
					continue;
				}
				
				addEObject(eObject);
				
				EClass eClass = eObject.eClass();
				
				/*
				 * Update data structures with all instance links from the
				 * current object.
				 */
				for(EReference reference:eClass.getEAllReferences()) {
					if(reference.isMany()) {
						for(EObject target:(Collection<? extends EObject>) eObject.eGet(reference)) {
							if(!registeredObjects.contains(target) && !eObjects.contains(target)) {
								newlyAddedObjects.add(target);
							}
							
							addReference(eObject, reference, target);
						}
					}
					else {
						EObject target = (EObject) eObject.eGet(reference);
						
						if(target != null) {
							if(!registeredObjects.contains(target) && !eObjects.contains(target)) {
								newlyAddedObjects.add(target);
							}
							
							addReference(eObject, reference, target);
						}
					}
				}
			}
			
			eObjects = newlyAddedObjects;
		}
	}
	
	/**
	 * Do add the given instance object to the registered objects
	 * and the domain map.
	 * 
	 * @param eObject
	 * 			The instance object.
	 */
	protected void addEObject(EObject eObject) {
		if(!registeredObjects.contains(eObject)) {
			registeredObjects.add(eObject);
			eObject.eAdapters().add(this);
			
			doAddEObject(eObject);
		}
	}
	
	protected void doAddEObject(EObject eObject) {
		
	}

	/**
	 * Remove an instance object from the adapter. This does not
	 * include the removal of incoming and outgoing instance links.
	 * 
	 * @param eObject
	 * 			The instance object to remove.
	 */
	public void removeEObject(EObject eObject) {	//TODO We need to be careful with this if changes are made outside of the SDI
		registeredObjects.remove(eObject);
		eObject.eAdapters().remove(this);
		
		doRemoveEObject(eObject);
	}

	protected void doRemoveEObject(EObject eObject) {
		
	}

	protected void addReference(EObject source, EReference reference, EObject target) {
		doAddReference(source, reference, target);
	}

	protected void doAddReference(EObject source, EReference reference,
			EObject target) {
		
	}

	protected void removeReference(EObject source, EReference reference, EObject target) {
		doRemoveReference(source, reference, target);
	}

	protected void doRemoveReference(EObject source, EReference reference,
			EObject target) {
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		/*
		 * Adapt to changes based on EMF notifications.
		 */
		if((notification.getFeature() instanceof EReference)) {
			EReference reference = (EReference) notification.getFeature();
			EObject source = (EObject) notification.getNotifier();
			EObject newTarget;
			EObject oldTarget;
			switch(notification.getEventType()) {
				case Notification.ADD:
					newTarget = (EObject) notification.getNewValue();
					registerEObject(newTarget);
					addReference(source, reference, newTarget);
					break;
				case Notification.REMOVE:
					oldTarget = (EObject) notification.getOldValue();
					removeReference(source, reference, oldTarget);
					if(reference.isContainment()) {
						removeEObject(oldTarget);
					}
					break;
				case Notification.SET:
					newTarget = (EObject) notification.getNewValue();
					oldTarget = (EObject) notification.getOldValue();
					if(oldTarget != null) {
						removeReference(source, reference, oldTarget);
					}
					if(newTarget != null) {
						registerEObject(newTarget);
						addReference(source, reference, newTarget);
					}
					break;
				case Notification.UNSET:
					oldTarget = (EObject) notification.getOldValue();
					if(oldTarget != null) {
						removeReference(source, reference, oldTarget);
					}
					break;
				case Notification.ADD_MANY:
					@SuppressWarnings("unchecked")
					Collection<? extends EObject> newTargets = (Collection<? extends EObject>) notification.getNewValue();
					for(EObject object:newTargets) {
						registerEObject(object);
						addReference(source, reference, object);
					}
					break;
				case Notification.REMOVE_MANY:
					@SuppressWarnings("unchecked")
					Collection<? extends EObject> oldTargets = (Collection<? extends EObject>) notification.getOldValue();
					for(EObject object:oldTargets) {
						removeReference(source, reference, object);
					}
					break;
				default:
					break;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	@Override
	public Notifier getTarget() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void setTarget(Notifier newTarget) {
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof EClass;
	}

	public Set<EObject> getRegisteredObjects() {
		return registeredObjects;
	}

}
