/**
 */
package de.mdelab.ldbc_snb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.Company#getIsLocatedIn <em>Is Located In</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends Organisation {
	/**
	 * Returns the value of the '<em><b>Is Located In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Located In</em>' reference.
	 * @see #setIsLocatedIn(Country)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCompany_IsLocatedIn()
	 * @model required="true"
	 * @generated
	 */
	Country getIsLocatedIn();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Company#getIsLocatedIn <em>Is Located In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Located In</em>' reference.
	 * @see #getIsLocatedIn()
	 * @generated
	 */
	void setIsLocatedIn(Country value);

} // Company
