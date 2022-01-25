/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.IdentifiedElement;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Message;
import de.mdelab.ldbc_snb.Person;
import de.mdelab.ldbc_snb.Tag;
import de.mdelab.ldbc_snb.TagClass;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getIntId <em>Int Id</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getID <em>ID</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getHasType <em>Has Type</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getHasTagOpp <em>Has Tag Opp</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.TagImpl#getHasInterestOpp <em>Has Interest Opp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagImpl extends MinimalEObjectImpl.Container implements Tag {
	/**
	 * The default value of the '{@link #getIntId() <em>Int Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntId()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getIntId() <em>Int Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntId()
	 * @generated
	 * @ordered
	 */
	protected int intId = INT_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getHasType() <em>Has Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasType()
	 * @generated
	 * @ordered
	 */
	protected EList<TagClass> hasType;
	/**
	 * The cached value of the '{@link #getHasTagOpp() <em>Has Tag Opp</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasTagOpp()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> hasTagOpp;
	/**
	 * The cached value of the '{@link #getHasInterestOpp() <em>Has Interest Opp</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasInterestOpp()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> hasInterestOpp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.TAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIntId() {
		return intId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntId(int newIntId) {
		int oldIntId = intId;
		intId = newIntId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.TAG__INT_ID, oldIntId, intId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setID(long newID) {
		long oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.TAG__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.TAG__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<TagClass> getHasType() {
		if (hasType == null) {
			hasType = new EObjectResolvingEList<TagClass>(TagClass.class, this, Ldbc_snbPackage.TAG__HAS_TYPE);
		}
		return hasType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Message> getHasTagOpp() {
		if (hasTagOpp == null) {
			hasTagOpp = new EObjectWithInverseResolvingEList.ManyInverse<Message>(Message.class, this, Ldbc_snbPackage.TAG__HAS_TAG_OPP, Ldbc_snbPackage.MESSAGE__HAS_TAG);
		}
		return hasTagOpp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Person> getHasInterestOpp() {
		if (hasInterestOpp == null) {
			hasInterestOpp = new EObjectWithInverseResolvingEList.ManyInverse<Person>(Person.class, this, Ldbc_snbPackage.TAG__HAS_INTEREST_OPP, Ldbc_snbPackage.PERSON__HAS_INTEREST);
		}
		return hasInterestOpp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHasTagOpp()).basicAdd(otherEnd, msgs);
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHasInterestOpp()).basicAdd(otherEnd, msgs);
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
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				return ((InternalEList<?>)getHasTagOpp()).basicRemove(otherEnd, msgs);
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				return ((InternalEList<?>)getHasInterestOpp()).basicRemove(otherEnd, msgs);
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
			case Ldbc_snbPackage.TAG__INT_ID:
				return getIntId();
			case Ldbc_snbPackage.TAG__ID:
				return getID();
			case Ldbc_snbPackage.TAG__NAME:
				return getName();
			case Ldbc_snbPackage.TAG__HAS_TYPE:
				return getHasType();
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				return getHasTagOpp();
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				return getHasInterestOpp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Ldbc_snbPackage.TAG__INT_ID:
				setIntId((Integer)newValue);
				return;
			case Ldbc_snbPackage.TAG__ID:
				setID((Long)newValue);
				return;
			case Ldbc_snbPackage.TAG__NAME:
				setName((String)newValue);
				return;
			case Ldbc_snbPackage.TAG__HAS_TYPE:
				getHasType().clear();
				getHasType().addAll((Collection<? extends TagClass>)newValue);
				return;
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				getHasTagOpp().clear();
				getHasTagOpp().addAll((Collection<? extends Message>)newValue);
				return;
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				getHasInterestOpp().clear();
				getHasInterestOpp().addAll((Collection<? extends Person>)newValue);
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
			case Ldbc_snbPackage.TAG__INT_ID:
				setIntId(INT_ID_EDEFAULT);
				return;
			case Ldbc_snbPackage.TAG__ID:
				setID(ID_EDEFAULT);
				return;
			case Ldbc_snbPackage.TAG__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Ldbc_snbPackage.TAG__HAS_TYPE:
				getHasType().clear();
				return;
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				getHasTagOpp().clear();
				return;
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				getHasInterestOpp().clear();
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
			case Ldbc_snbPackage.TAG__INT_ID:
				return intId != INT_ID_EDEFAULT;
			case Ldbc_snbPackage.TAG__ID:
				return id != ID_EDEFAULT;
			case Ldbc_snbPackage.TAG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Ldbc_snbPackage.TAG__HAS_TYPE:
				return hasType != null && !hasType.isEmpty();
			case Ldbc_snbPackage.TAG__HAS_TAG_OPP:
				return hasTagOpp != null && !hasTagOpp.isEmpty();
			case Ldbc_snbPackage.TAG__HAS_INTEREST_OPP:
				return hasInterestOpp != null && !hasInterestOpp.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IdentifiedElement.class) {
			switch (derivedFeatureID) {
				case Ldbc_snbPackage.TAG__ID: return Ldbc_snbPackage.IDENTIFIED_ELEMENT__ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IdentifiedElement.class) {
			switch (baseFeatureID) {
				case Ldbc_snbPackage.IDENTIFIED_ELEMENT__ID: return Ldbc_snbPackage.TAG__ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (intId: ");
		result.append(intId);
		result.append(", ID: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TagImpl
