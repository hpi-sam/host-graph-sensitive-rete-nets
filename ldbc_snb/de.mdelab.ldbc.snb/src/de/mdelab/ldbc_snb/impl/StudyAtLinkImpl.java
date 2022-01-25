/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Person;
import de.mdelab.ldbc_snb.StudyAtLink;
import de.mdelab.ldbc_snb.University;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Study At Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.StudyAtLinkImpl#getClassYear <em>Class Year</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.StudyAtLinkImpl#getStudyAt <em>Study At</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.StudyAtLinkImpl#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StudyAtLinkImpl extends MinimalEObjectImpl.Container implements StudyAtLink {
	/**
	 * The default value of the '{@link #getClassYear() <em>Class Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassYear()
	 * @generated
	 * @ordered
	 */
	protected static final int CLASS_YEAR_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getClassYear() <em>Class Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassYear()
	 * @generated
	 * @ordered
	 */
	protected int classYear = CLASS_YEAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getStudyAt() <em>Study At</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudyAt()
	 * @generated
	 * @ordered
	 */
	protected University studyAt;
	/**
	 * The cached value of the '{@link #getPerson() <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerson()
	 * @generated
	 * @ordered
	 */
	protected Person person;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StudyAtLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.STUDY_AT_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getClassYear() {
		return classYear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassYear(int newClassYear) {
		int oldClassYear = classYear;
		classYear = newClassYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.STUDY_AT_LINK__CLASS_YEAR, oldClassYear, classYear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public University getStudyAt() {
		if (studyAt != null && studyAt.eIsProxy()) {
			InternalEObject oldStudyAt = (InternalEObject)studyAt;
			studyAt = (University)eResolveProxy(oldStudyAt);
			if (studyAt != oldStudyAt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT, oldStudyAt, studyAt));
			}
		}
		return studyAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public University basicGetStudyAt() {
		return studyAt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStudyAt(University newStudyAt) {
		University oldStudyAt = studyAt;
		studyAt = newStudyAt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT, oldStudyAt, studyAt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person getPerson() {
		if (person != null && person.eIsProxy()) {
			InternalEObject oldPerson = (InternalEObject)person;
			person = (Person)eResolveProxy(oldPerson);
			if (person != oldPerson) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.STUDY_AT_LINK__PERSON, oldPerson, person));
			}
		}
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person basicGetPerson() {
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPerson(Person newPerson, NotificationChain msgs) {
		Person oldPerson = person;
		person = newPerson;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.STUDY_AT_LINK__PERSON, oldPerson, newPerson);
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
	public void setPerson(Person newPerson) {
		if (newPerson != person) {
			NotificationChain msgs = null;
			if (person != null)
				msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__STUDY_AT, Person.class, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, Ldbc_snbPackage.PERSON__STUDY_AT, Person.class, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.STUDY_AT_LINK__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				if (person != null)
					msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__STUDY_AT, Person.class, msgs);
				return basicSetPerson((Person)otherEnd, msgs);
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
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				return basicSetPerson(null, msgs);
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
			case Ldbc_snbPackage.STUDY_AT_LINK__CLASS_YEAR:
				return getClassYear();
			case Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT:
				if (resolve) return getStudyAt();
				return basicGetStudyAt();
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
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
			case Ldbc_snbPackage.STUDY_AT_LINK__CLASS_YEAR:
				setClassYear((Integer)newValue);
				return;
			case Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT:
				setStudyAt((University)newValue);
				return;
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				setPerson((Person)newValue);
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
			case Ldbc_snbPackage.STUDY_AT_LINK__CLASS_YEAR:
				setClassYear(CLASS_YEAR_EDEFAULT);
				return;
			case Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT:
				setStudyAt((University)null);
				return;
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				setPerson((Person)null);
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
			case Ldbc_snbPackage.STUDY_AT_LINK__CLASS_YEAR:
				return classYear != CLASS_YEAR_EDEFAULT;
			case Ldbc_snbPackage.STUDY_AT_LINK__STUDY_AT:
				return studyAt != null;
			case Ldbc_snbPackage.STUDY_AT_LINK__PERSON:
				return person != null;
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
		result.append(" (classYear: ");
		result.append(classYear);
		result.append(')');
		return result.toString();
	}

} //StudyAtLinkImpl
