/**
 */
package de.mdelab.ldbc_snb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Likes Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.LikesLink#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.LikesLink#getLikes <em>Likes</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.LikesLink#getPerson <em>Person</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.LikesLink#getLikes2 <em>Likes2</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getLikesLink()
 * @model
 * @generated
 */
public interface LikesLink extends DynamicElement {
	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(long)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getLikesLink_CreationDate()
	 * @model
	 * @generated
	 */
	long getCreationDate();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.LikesLink#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(long value);

	/**
	 * Returns the value of the '<em><b>Likes</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Message#getLikes <em>Likes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likes</em>' reference.
	 * @see #setLikes(Message)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getLikesLink_Likes()
	 * @see de.mdelab.ldbc_snb.Message#getLikes
	 * @model opposite="likes" required="true"
	 * @generated
	 */
	Message getLikes();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.LikesLink#getLikes <em>Likes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Likes</em>' reference.
	 * @see #getLikes()
	 * @generated
	 */
	void setLikes(Message value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Person#getLikes <em>Likes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getLikesLink_Person()
	 * @see de.mdelab.ldbc_snb.Person#getLikes
	 * @model opposite="likes"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.LikesLink#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Likes2</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likes2</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getLikesLink_Likes2()
	 * @model
	 * @generated
	 */
	EList<Message> getLikes2();

} // LikesLink
