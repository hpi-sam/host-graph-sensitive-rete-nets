/**
 */
package de.mdelab.ldbc_snb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.Tag#getName <em>Name</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Tag#getHasType <em>Has Type</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Tag#getHasTagOpp <em>Has Tag Opp</em>}</li>
 *   <li>{@link de.mdelab.ldbc_snb.Tag#getHasInterestOpp <em>Has Interest Opp</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends IntegerIdentifiedElement, IdentifiedElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getTag_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Tag#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Has Type</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.TagClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Type</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getTag_HasType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TagClass> getHasType();

	/**
	 * Returns the value of the '<em><b>Has Tag Opp</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Message}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Message#getHasTag <em>Has Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Tag Opp</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getTag_HasTagOpp()
	 * @see de.mdelab.ldbc_snb.Message#getHasTag
	 * @model opposite="hasTag"
	 * @generated
	 */
	EList<Message> getHasTagOpp();

	/**
	 * Returns the value of the '<em><b>Has Interest Opp</b></em>' reference list.
	 * The list contents are of type {@link de.mdelab.ldbc_snb.Person}.
	 * It is bidirectional and its opposite is '{@link de.mdelab.ldbc_snb.Person#getHasInterest <em>Has Interest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interest Opp</em>' reference list.
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getTag_HasInterestOpp()
	 * @see de.mdelab.ldbc_snb.Person#getHasInterest
	 * @model opposite="hasInterest"
	 * @generated
	 */
	EList<Person> getHasInterestOpp();

} // Tag
