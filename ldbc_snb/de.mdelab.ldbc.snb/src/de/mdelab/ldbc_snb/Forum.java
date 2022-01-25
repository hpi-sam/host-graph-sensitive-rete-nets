/**
 */
package de.mdelab.ldbc_snb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getTitle <em>Title</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getHasModerator <em>Has Moderator</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getHasTag <em>Has Tag</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getContainerOf <em>Container Of</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Forum#getHasMember <em>Has Member</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum()
 * @model
 * @generated
 */
public interface Forum extends IdentifiedElement, DynamicElement {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Forum#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(long)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_CreationDate()
	 * @model
	 * @generated
	 */
	long getCreationDate();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Forum#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(long value);

	/**
	 * Returns the value of the '<em><b>Has Moderator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Moderator</em>' reference.
	 * @see #setHasModerator(Person)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_HasModerator()
	 * @model required="true"
	 * @generated
	 */
	Person getHasModerator();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Forum#getHasModerator <em>Has Moderator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Moderator</em>' reference.
	 * @see #getHasModerator()
	 * @generated
	 */
	void setHasModerator(Person value);

	/**
	 * Returns the value of the '<em><b>Has Tag</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Tag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Tag</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_HasTag()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Tag> getHasTag();

	/**
	 * Returns the value of the '<em><b>Container Of</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Post}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Post#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Of</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_ContainerOf()
	 * @see de.mdelab.ldbc_snb.Post#getContainer
	 * @model opposite="container" required="true" ordered="false"
	 * @generated
	 */
	EList<Post> getContainerOf();

	/**
	 * Returns the value of the '<em><b>Has Member</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.HasMemberLink}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.HasMemberLink#getForum <em>Forum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Member</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getForum_HasMember()
	 * @see de.mdelab.ldbc_snb.HasMemberLink#getForum
	 * @model opposite="forum"
	 * @generated
	 */
	EList<HasMemberLink> getHasMember();

} // Forum
