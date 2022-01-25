/**
 */
package de.mdelab.ldbc_snb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getBrowserUsed <em>Browser Used</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getLocationIP <em>Location IP</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getContent <em>Content</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getLength <em>Length</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getIsLocatedIn <em>Is Located In</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getHasTag <em>Has Tag</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getHasCreator <em>Has Creator</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getComments <em>Comments</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Message#getLikes <em>Likes</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends IdentifiedElement, DynamicElement {
	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(long)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_CreationDate()
	 * @model
	 * @generated
	 */
	long getCreationDate();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(long value);

	/**
	 * Returns the value of the '<em><b>Browser Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Browser Used</em>' attribute.
	 * @see #setBrowserUsed(String)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_BrowserUsed()
	 * @model
	 * @generated
	 */
	String getBrowserUsed();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getBrowserUsed <em>Browser Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Browser Used</em>' attribute.
	 * @see #getBrowserUsed()
	 * @generated
	 */
	void setBrowserUsed(String value);

	/**
	 * Returns the value of the '<em><b>Location IP</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location IP</em>' attribute.
	 * @see #setLocationIP(String)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_LocationIP()
	 * @model
	 * @generated
	 */
	String getLocationIP();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getLocationIP <em>Location IP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location IP</em>' attribute.
	 * @see #getLocationIP()
	 * @generated
	 */
	void setLocationIP(String value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_Length()
	 * @model
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

	/**
	 * Returns the value of the '<em><b>Is Located In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Located In</em>' reference.
	 * @see #setIsLocatedIn(Country)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_IsLocatedIn()
	 * @model required="true"
	 * @generated
	 */
	Country getIsLocatedIn();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getIsLocatedIn <em>Is Located In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Located In</em>' reference.
	 * @see #getIsLocatedIn()
	 * @generated
	 */
	void setIsLocatedIn(Country value);

	/**
	 * Returns the value of the '<em><b>Has Tag</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Tag}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Tag#getHasTagOpp <em>Has Tag Opp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Tag</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_HasTag()
	 * @see de.mdelab.ldbc_snb.Tag#getHasTagOpp
	 * @model opposite="hasTagOpp" ordered="false"
	 * @generated
	 */
	EList<Tag> getHasTag();

	/**
	 * Returns the value of the '<em><b>Has Creator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Person#getHasCreated <em>Has Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Creator</em>' reference.
	 * @see #setHasCreator(Person)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_HasCreator()
	 * @see de.mdelab.ldbc_snb.Person#getHasCreated
	 * @model opposite="hasCreated"
	 * @generated
	 */
	Person getHasCreator();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Message#getHasCreator <em>Has Creator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Creator</em>' reference.
	 * @see #getHasCreator()
	 * @generated
	 */
	void setHasCreator(Person value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Comment}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Comment#getReplyOf <em>Reply Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_Comments()
	 * @see de.mdelab.ldbc_snb.Comment#getReplyOf
	 * @model opposite="replyOf"
	 * @generated
	 */
	EList<Comment> getComments();

	/**
	 * Returns the value of the '<em><b>Likes</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.LikesLink}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.LikesLink#getLikes <em>Likes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likes</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getMessage_Likes()
	 * @see de.mdelab.ldbc_snb.LikesLink#getLikes
	 * @model opposite="likes"
	 * @generated
	 */
	EList<LikesLink> getLikes();

} // Message
