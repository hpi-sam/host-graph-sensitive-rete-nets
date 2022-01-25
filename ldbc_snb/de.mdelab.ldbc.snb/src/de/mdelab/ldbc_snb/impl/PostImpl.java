/**
 */
package de.mdelab.ldbc_snb.impl;

import de.mdelab.ldbc_snb.Forum;
import de.mdelab.ldbc_snb.IntegerIdentifiedElement;
import de.mdelab.ldbc_snb.Ldbc_snbPackage;
import de.mdelab.ldbc_snb.Post;
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
 * An implementation of the model object '<em><b>Post</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getIntId <em>Int Id</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getImageFile <em>Image File</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getLinkedPosts <em>Linked Posts</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.impl.PostImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostImpl extends MessageImpl implements Post {
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
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;
	/**
	 * The default value of the '{@link #getImageFile() <em>Image File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageFile()
	 * @generated
	 * @ordered
	 */
	protected static final String IMAGE_FILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getImageFile() <em>Image File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageFile()
	 * @generated
	 * @ordered
	 */
	protected String imageFile = IMAGE_FILE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected Post predecessor;
	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected Post successor;
	/**
	 * The cached value of the '{@link #getLinkedPosts() <em>Linked Posts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedPosts()
	 * @generated
	 * @ordered
	 */
	protected EList<Post> linkedPosts;
	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected Forum container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ldbc_snbPackage.Literals.POST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__INT_ID, oldIntId, intId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImageFile() {
		return imageFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageFile(String newImageFile) {
		String oldImageFile = imageFile;
		imageFile = newImageFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__IMAGE_FILE, oldImageFile, imageFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Post getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject)predecessor;
			predecessor = (Post)eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.POST__PREDECESSOR, oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(Post newPredecessor, NotificationChain msgs) {
		Post oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__PREDECESSOR, oldPredecessor, newPredecessor);
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
	public void setPredecessor(Post newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject)predecessor).eInverseRemove(this, Ldbc_snbPackage.POST__SUCCESSOR, Post.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject)newPredecessor).eInverseAdd(this, Ldbc_snbPackage.POST__SUCCESSOR, Post.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__PREDECESSOR, newPredecessor, newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Post getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject)successor;
			successor = (Post)eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.POST__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Post basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(Post newSuccessor, NotificationChain msgs) {
		Post oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__SUCCESSOR, oldSuccessor, newSuccessor);
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
	public void setSuccessor(Post newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject)successor).eInverseRemove(this, Ldbc_snbPackage.POST__PREDECESSOR, Post.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject)newSuccessor).eInverseAdd(this, Ldbc_snbPackage.POST__PREDECESSOR, Post.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__SUCCESSOR, newSuccessor, newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Post> getLinkedPosts() {
		if (linkedPosts == null) {
			linkedPosts = new EObjectResolvingEList<Post>(Post.class, this, Ldbc_snbPackage.POST__LINKED_POSTS);
		}
		return linkedPosts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Forum getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (Forum)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ldbc_snbPackage.POST__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forum basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(Forum newContainer, NotificationChain msgs) {
		Forum oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__CONTAINER, oldContainer, newContainer);
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
	public void setContainer(Forum newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, Ldbc_snbPackage.FORUM__CONTAINER_OF, Forum.class, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, Ldbc_snbPackage.FORUM__CONTAINER_OF, Forum.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ldbc_snbPackage.POST__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ldbc_snbPackage.POST__PREDECESSOR:
				if (predecessor != null)
					msgs = ((InternalEObject)predecessor).eInverseRemove(this, Ldbc_snbPackage.POST__SUCCESSOR, Post.class, msgs);
				return basicSetPredecessor((Post)otherEnd, msgs);
			case Ldbc_snbPackage.POST__SUCCESSOR:
				if (successor != null)
					msgs = ((InternalEObject)successor).eInverseRemove(this, Ldbc_snbPackage.POST__PREDECESSOR, Post.class, msgs);
				return basicSetSuccessor((Post)otherEnd, msgs);
			case Ldbc_snbPackage.POST__CONTAINER:
				if (container != null)
					msgs = ((InternalEObject)container).eInverseRemove(this, Ldbc_snbPackage.FORUM__CONTAINER_OF, Forum.class, msgs);
				return basicSetContainer((Forum)otherEnd, msgs);
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
			case Ldbc_snbPackage.POST__PREDECESSOR:
				return basicSetPredecessor(null, msgs);
			case Ldbc_snbPackage.POST__SUCCESSOR:
				return basicSetSuccessor(null, msgs);
			case Ldbc_snbPackage.POST__CONTAINER:
				return basicSetContainer(null, msgs);
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
			case Ldbc_snbPackage.POST__INT_ID:
				return getIntId();
			case Ldbc_snbPackage.POST__LANGUAGE:
				return getLanguage();
			case Ldbc_snbPackage.POST__IMAGE_FILE:
				return getImageFile();
			case Ldbc_snbPackage.POST__PREDECESSOR:
				if (resolve) return getPredecessor();
				return basicGetPredecessor();
			case Ldbc_snbPackage.POST__SUCCESSOR:
				if (resolve) return getSuccessor();
				return basicGetSuccessor();
			case Ldbc_snbPackage.POST__LINKED_POSTS:
				return getLinkedPosts();
			case Ldbc_snbPackage.POST__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case Ldbc_snbPackage.POST__INT_ID:
				setIntId((Integer)newValue);
				return;
			case Ldbc_snbPackage.POST__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case Ldbc_snbPackage.POST__IMAGE_FILE:
				setImageFile((String)newValue);
				return;
			case Ldbc_snbPackage.POST__PREDECESSOR:
				setPredecessor((Post)newValue);
				return;
			case Ldbc_snbPackage.POST__SUCCESSOR:
				setSuccessor((Post)newValue);
				return;
			case Ldbc_snbPackage.POST__LINKED_POSTS:
				getLinkedPosts().clear();
				getLinkedPosts().addAll((Collection<? extends Post>)newValue);
				return;
			case Ldbc_snbPackage.POST__CONTAINER:
				setContainer((Forum)newValue);
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
			case Ldbc_snbPackage.POST__INT_ID:
				setIntId(INT_ID_EDEFAULT);
				return;
			case Ldbc_snbPackage.POST__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case Ldbc_snbPackage.POST__IMAGE_FILE:
				setImageFile(IMAGE_FILE_EDEFAULT);
				return;
			case Ldbc_snbPackage.POST__PREDECESSOR:
				setPredecessor((Post)null);
				return;
			case Ldbc_snbPackage.POST__SUCCESSOR:
				setSuccessor((Post)null);
				return;
			case Ldbc_snbPackage.POST__LINKED_POSTS:
				getLinkedPosts().clear();
				return;
			case Ldbc_snbPackage.POST__CONTAINER:
				setContainer((Forum)null);
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
			case Ldbc_snbPackage.POST__INT_ID:
				return intId != INT_ID_EDEFAULT;
			case Ldbc_snbPackage.POST__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case Ldbc_snbPackage.POST__IMAGE_FILE:
				return IMAGE_FILE_EDEFAULT == null ? imageFile != null : !IMAGE_FILE_EDEFAULT.equals(imageFile);
			case Ldbc_snbPackage.POST__PREDECESSOR:
				return predecessor != null;
			case Ldbc_snbPackage.POST__SUCCESSOR:
				return successor != null;
			case Ldbc_snbPackage.POST__LINKED_POSTS:
				return linkedPosts != null && !linkedPosts.isEmpty();
			case Ldbc_snbPackage.POST__CONTAINER:
				return container != null;
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
		if (baseClass == IntegerIdentifiedElement.class) {
			switch (derivedFeatureID) {
				case Ldbc_snbPackage.POST__INT_ID: return Ldbc_snbPackage.INTEGER_IDENTIFIED_ELEMENT__INT_ID;
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
		if (baseClass == IntegerIdentifiedElement.class) {
			switch (baseFeatureID) {
				case Ldbc_snbPackage.INTEGER_IDENTIFIED_ELEMENT__INT_ID: return Ldbc_snbPackage.POST__INT_ID;
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
		result.append(", language: ");
		result.append(language);
		result.append(", imageFile: ");
		result.append(imageFile);
		result.append(')');
		return result.toString();
	}

} //PostImpl
