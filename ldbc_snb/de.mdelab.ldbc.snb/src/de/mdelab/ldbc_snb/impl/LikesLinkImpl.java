/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.LikesLink;
import de.mdelab.ldbc_snb.Message;
import de.mdelab.ldbc_snb.Person;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Likes Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.LikesLinkImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.LikesLinkImpl#getLikes <em>Likes</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.LikesLinkImpl#getPerson <em>Person</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.LikesLinkImpl#getLikes2 <em>Likes2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LikesLinkImpl extends DynamicElementImpl implements LikesLink {
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
	 * The cached value of the '{@link #getLikes() <em>Likes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikes()
	 * @generated
	 * @ordered
	 */
	protected Message likes;
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
	 * The cached value of the '{@link #getLikes2() <em>Likes2</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikes2()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> likes2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LikesLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.LIKES_LINK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.LIKES_LINK__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Message getLikes() {
		if (likes != null && likes.eIsProxy()) {
			InternalEObject oldLikes = (InternalEObject)likes;
			likes = (Message)eResolveProxy(oldLikes);
			if (likes != oldLikes) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.LIKES_LINK__LIKES, oldLikes, likes));
			}
		}
		return likes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetLikes() {
		return likes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLikes(Message newLikes, NotificationChain msgs) {
		Message oldLikes = likes;
		likes = newLikes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.LIKES_LINK__LIKES, oldLikes, newLikes);
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
	public void setLikes(Message newLikes) {
		if (newLikes != likes) {
			NotificationChain msgs = null;
			if (likes != null)
				msgs = ((InternalEObject)likes).eInverseRemove(this, Ldbc_snbPackage.MESSAGE__LIKES, Message.class, msgs);
			if (newLikes != null)
				msgs = ((InternalEObject)newLikes).eInverseAdd(this, Ldbc_snbPackage.MESSAGE__LIKES, Message.class, msgs);
			msgs = basicSetLikes(newLikes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.LIKES_LINK__LIKES, newLikes, newLikes));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.LIKES_LINK__PERSON, oldPerson, person));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.LIKES_LINK__PERSON, oldPerson, newPerson);
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
				msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__LIKES, Person.class, msgs);
			if (newPerson != null)
				msgs = ((InternalEObject)newPerson).eInverseAdd(this, Ldbc_snbPackage.PERSON__LIKES, Person.class, msgs);
			msgs = basicSetPerson(newPerson, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.LIKES_LINK__PERSON, newPerson, newPerson));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Message> getLikes2() {
		if (likes2 == null) {
			likes2 = new EObjectResolvingEList<Message>(Message.class, this, Ldbc_snbPackage.LIKES_LINK__LIKES2);
		}
		return likes2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				if (likes != null)
					msgs = ((InternalEObject)likes).eInverseRemove(this, Ldbc_snbPackage.MESSAGE__LIKES, Message.class, msgs);
				return basicSetLikes((Message)otherEnd, msgs);
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
				if (person != null)
					msgs = ((InternalEObject)person).eInverseRemove(this, Ldbc_snbPackage.PERSON__LIKES, Person.class, msgs);
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
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				return basicSetLikes(null, msgs);
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
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
			case Ldbc_snbPackage.LIKES_LINK__CREATION_DATE:
				return getCreationDate();
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				if (resolve) return getLikes();
				return basicGetLikes();
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
				if (resolve) return getPerson();
				return basicGetPerson();
			case Ldbc_snbPackage.LIKES_LINK__LIKES2:
				return getLikes2();
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
			case Ldbc_snbPackage.LIKES_LINK__CREATION_DATE:
				setCreationDate((Long)newValue);
				return;
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				setLikes((Message)newValue);
				return;
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
				setPerson((Person)newValue);
				return;
			case Ldbc_snbPackage.LIKES_LINK__LIKES2:
				getLikes2().clear();
				getLikes2().addAll((Collection<? extends Message>)newValue);
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
			case Ldbc_snbPackage.LIKES_LINK__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				setLikes((Message)null);
				return;
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
				setPerson((Person)null);
				return;
			case Ldbc_snbPackage.LIKES_LINK__LIKES2:
				getLikes2().clear();
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
			case Ldbc_snbPackage.LIKES_LINK__CREATION_DATE:
				return creationDate != CREATION_DATE_EDEFAULT;
			case Ldbc_snbPackage.LIKES_LINK__LIKES:
				return likes != null;
			case Ldbc_snbPackage.LIKES_LINK__PERSON:
				return person != null;
			case Ldbc_snbPackage.LIKES_LINK__LIKES2:
				return likes2 != null && !likes2.isEmpty();
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

} //LikesLinkImpl
