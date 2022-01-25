/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.Forum;
import de.mdelab.ldbc_snb.HasMemberLink;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Person;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Has Member Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.HasMemberLinkImpl#getJoinDate <em>Join Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.HasMemberLinkImpl#getForum <em>Forum</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.HasMemberLinkImpl#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HasMemberLinkImpl extends DynamicElementImpl implements HasMemberLink {
	/**
	 * The default value of the '{@link #getJoinDate() <em>Join Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinDate()
	 * @generated
	 * @ordered
	 */
	protected static final long JOIN_DATE_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getJoinDate() <em>Join Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinDate()
	 * @generated
	 * @ordered
	 */
	protected long joinDate = JOIN_DATE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getForum() <em>Forum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForum()
	 * @generated
	 * @ordered
	 */
	protected Forum forum;
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
	protected HasMemberLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.HAS_MEMBER_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getJoinDate() {
		return joinDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJoinDate(long newJoinDate) {
		long oldJoinDate = joinDate;
		joinDate = newJoinDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.HAS_MEMBER_LINK__JOIN_DATE, oldJoinDate, joinDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Forum getForum() {
		if (forum != null && forum.eIsProxy()) {
			InternalEObject oldForum = (InternalEObject)forum;
			forum = (Forum)eResolveProxy(oldForum);
			if (forum != oldForum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM, oldForum, forum));
			}
		}
		return forum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forum basicGetForum() {
		return forum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForum(Forum newForum, NotificationChain msgs) {
		Forum oldForum = forum;
		forum = newForum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM, oldForum, newForum);
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
	public void setForum(Forum newForum) {
		if (newForum != forum) {
			NotificationChain msgs = null;
			if (forum != null)
				msgs = ((InternalEObject)forum).eInverseRemove(this, Ldbc_snbPackage.FORUM__HAS_MEMBER, Forum.class, msgs);
			if (newForum != null)
				msgs = ((InternalEObject)newForum).eInverseAdd(this, Ldbc_snbPackage.FORUM__HAS_MEMBER, Forum.class, msgs);
			msgs = basicSetForum(newForum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM, newForum, newForum));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON, oldPerson, person));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON, oldPerson, newPerson);
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
				msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__IS_MEMBER, Person.class, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, Ldbc_snbPackage.PERSON__IS_MEMBER, Person.class, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				if (forum != null)
					msgs = ((InternalEObject)forum).eInverseRemove(this, Ldbc_snbPackage.FORUM__HAS_MEMBER, Forum.class, msgs);
				return basicSetForum((Forum)otherEnd, msgs);
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
				if (person != null)
					msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__IS_MEMBER, Person.class, msgs);
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
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				return basicSetForum(null, msgs);
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
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
			case Ldbc_snbPackage.HAS_MEMBER_LINK__JOIN_DATE:
				return getJoinDate();
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				if (resolve) return getForum();
				return basicGetForum();
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
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
			case Ldbc_snbPackage.HAS_MEMBER_LINK__JOIN_DATE:
				setJoinDate((Long)newValue);
				return;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				setForum((Forum)newValue);
				return;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
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
			case Ldbc_snbPackage.HAS_MEMBER_LINK__JOIN_DATE:
				setJoinDate(JOIN_DATE_EDEFAULT);
				return;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				setForum((Forum)null);
				return;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
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
			case Ldbc_snbPackage.HAS_MEMBER_LINK__JOIN_DATE:
				return joinDate != JOIN_DATE_EDEFAULT;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__FORUM:
				return forum != null;
			case Ldbc_snbPackage.HAS_MEMBER_LINK__PERSON:
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
		result.append(" (joinDate: ");
		result.append(joinDate);
		result.append(')');
		return result.toString();
	}

} //HasMemberLinkImpl
