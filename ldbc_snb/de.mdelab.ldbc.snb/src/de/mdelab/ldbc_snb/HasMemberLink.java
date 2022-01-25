/**
 */
package de.mdelab.ldbc_snb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has Member Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.HasMemberLink#getJoinDate <em>Join Date</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.HasMemberLink#getForum <em>Forum</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.HasMemberLink#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getHasMemberLink()
 * @model
 * @generated
 */
public interface HasMemberLink extends DynamicElement {
	/**
	 * Returns the value of the '<em><b>Join Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Date</em>' attribute.
	 * @see #setJoinDate(long)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getHasMemberLink_JoinDate()
	 * @model
	 * @generated
	 */
	long getJoinDate();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.HasMemberLink#getJoinDate <em>Join Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Date</em>' attribute.
	 * @see #getJoinDate()
	 * @generated
	 */
	void setJoinDate(long value);

	/**
	 * Returns the value of the '<em><b>Forum</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Forum#getHasMember <em>Has Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forum</em>' reference.
	 * @see #setForum(Forum)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getHasMemberLink_Forum()
	 * @see de.mdelab.ldbc_snb.Forum#getHasMember
	 * @model opposite="hasMember" required="true"
	 * @generated
	 */
	Forum getForum();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.HasMemberLink#getForum <em>Forum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forum</em>' reference.
	 * @see #getForum()
	 * @generated
	 */
	void setForum(Forum value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Person#getIsMember <em>Is Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getHasMemberLink_Person()
	 * @see de.mdelab.ldbc_snb.Person#getIsMember
	 * @model opposite="isMember"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.HasMemberLink#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

} // HasMemberLink
