/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.KnowsLink;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Person;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Knows Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.KnowsLinkImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.KnowsLinkImpl#getKnows <em>Knows</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.KnowsLinkImpl#getKnowsOpp <em>Knows Opp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KnowsLinkImpl extends DynamicElementImpl implements KnowsLink {
	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATION_DATE_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected long creationDate = CREATION_DATE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getKnows() <em>Knows</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKnows()
	 * @generated
	 * @ordered
	 */
	protected Person knows;
	/**
	 * The cached value of the '{@link #getKnowsOpp() <em>Knows Opp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKnowsOpp()
	 * @generated
	 * @ordered
	 */
	protected Person knowsOpp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KnowsLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.KNOWS_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationDate(long newCreationDate) {
		long oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.KNOWS_LINK__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person getKnows() {
		if (knows != null && knows.eIsProxy()) {
			InternalEObject oldKnows = (InternalEObject)knows;
			knows = (Person)eResolveProxy(oldKnows);
			if (knows != oldKnows) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.KNOWS_LINK__KNOWS, oldKnows, knows));
			}
		}
		return knows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetKnows() {
		return knows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKnows(Person newKnows, NotificationChain msgs) {
		Person oldKnows = knows;
		knows = newKnows;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.KNOWS_LINK__KNOWS, oldKnows, newKnows);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnows(Person newKnows) {
		if (newKnows != knows) {
			NotificationChain msgs = null;
			if (knows != null)
				msgs = ((InternalEObject)knows).eInverseRemove(this, Ldbc_snbPackage.PERSON__KNOWS_OPP, Person.class, msgs);
			if (newKnows != null)
				msgs = ((InternalEObject)newKnows).eInverseAdd(this, Ldbc_snbPackage.PERSON__KNOWS_OPP, Person.class, msgs);
			msgs = basicSetKnows(newKnows, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.KNOWS_LINK__KNOWS, newKnows, newKnows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person getKnowsOpp() {
		if (knowsOpp != null && knowsOpp.eIsProxy()) {
			InternalEObject oldKnowsOpp = (InternalEObject)knowsOpp;
			knowsOpp = (Person)eResolveProxy(oldKnowsOpp);
			if (knowsOpp != oldKnowsOpp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP, oldKnowsOpp, knowsOpp));
			}
		}
		return knowsOpp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetKnowsOpp() {
		return knowsOpp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKnowsOpp(Person newKnowsOpp, NotificationChain msgs) {
		Person oldKnowsOpp = knowsOpp;
		knowsOpp = newKnowsOpp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP, oldKnowsOpp, newKnowsOpp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKnowsOpp(Person newKnowsOpp) {
		if (newKnowsOpp != knowsOpp) {
			NotificationChain msgs = null;
			if (knowsOpp != null)
				msgs = ((InternalEObject)knowsOpp).eInverseRemove(this, Ldbc_snbPackage.PERSON__KNOWS, Person.class, msgs);
			if (newKnowsOpp != null)
				msgs = ((InternalEObject)newKnowsOpp).eInverseAdd(this, Ldbc_snbPackage.PERSON__KNOWS, Person.class, msgs);
			msgs = basicSetKnowsOpp(newKnowsOpp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP, newKnowsOpp, newKnowsOpp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				if (knows != null)
					msgs = ((InternalEObject)knows).eInverseRemove(this, Ldbc_snbPackage.PERSON__KNOWS_OPP, Person.class, msgs);
				return basicSetKnows((Person)otherEnd, msgs);
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				if (knowsOpp != null)
					msgs = ((InternalEObject)knowsOpp).eInverseRemove(this, Ldbc_snbPackage.PERSON__KNOWS, Person.class, msgs);
				return basicSetKnowsOpp((Person)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				return basicSetKnows(null, msgs);
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				return basicSetKnowsOpp(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__CREATION_DATE:
				return getCreationDate();
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				if (resolve) return getKnows();
				return basicGetKnows();
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				if (resolve) return getKnowsOpp();
				return basicGetKnowsOpp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__CREATION_DATE:
				setCreationDate((Long)newValue);
				return;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				setKnows((Person)newValue);
				return;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				setKnowsOpp((Person)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				setKnows((Person)null);
				return;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				setKnowsOpp((Person)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Ldbc_snbPackage.KNOWS_LINK__CREATION_DATE:
				return creationDate != CREATION_DATE_EDEFAULT;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS:
				return knows != null;
			case Ldbc_snbPackage.KNOWS_LINK__KNOWS_OPP:
				return knowsOpp != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} //KnowsLinkImpl
