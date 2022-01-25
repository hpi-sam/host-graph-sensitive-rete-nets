/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.Company;
import de.mdelab.ldbc_snb.Country;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.CompanyImpl#getIsLocatedIn <em>Is Located In</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompanyImpl extends OrganisationImpl implements Company {
	/**
	 * The cached value of the '{@link #getIsLocatedIn() <em>Is Located In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsLocatedIn()
	 * @generated
	 * @ordered
	 */
	protected Country isLocatedIn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Country getIsLocatedIn() {
		if (isLocatedIn != null && isLocatedIn.eIsProxy()) {
			InternalEObject oldIsLocatedIn = (InternalEObject)isLocatedIn;
			isLocatedIn = (Country)eResolveProxy(oldIsLocatedIn);
			if (isLocatedIn != oldIsLocatedIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.COMPANY__IS_LOCATED_IN, oldIsLocatedIn, isLocatedIn));
			}
		}
		return isLocatedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Country basicGetIsLocatedIn() {
		return isLocatedIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsLocatedIn(Country newIsLocatedIn) {
		Country oldIsLocatedIn = isLocatedIn;
		isLocatedIn = newIsLocatedIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.COMPANY__IS_LOCATED_IN, oldIsLocatedIn, isLocatedIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ldbc_snbPackage.COMPANY__IS_LOCATED_IN:
				if (resolve) return getIsLocatedIn();
				return basicGetIsLocatedIn();
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
			case Ldbc_snbPackage.COMPANY__IS_LOCATED_IN:
				setIsLocatedIn((Country)newValue);
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
			case Ldbc_snbPackage.COMPANY__IS_LOCATED_IN:
				setIsLocatedIn((Country)null);
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
			case Ldbc_snbPackage.COMPANY__IS_LOCATED_IN:
				return isLocatedIn != null;
		}
		return super.eIsSet(featureID);
	}

} //CompanyImpl
