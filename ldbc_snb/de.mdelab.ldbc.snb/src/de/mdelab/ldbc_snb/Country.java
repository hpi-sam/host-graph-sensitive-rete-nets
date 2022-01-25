/**
 */
package de.mdelab.ldbc_snb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.Country#getIsPartOf <em>Is Part Of</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCountry()
 * @model
 * @generated
 */
public interface Country extends Place {
	/**
	 * Returns the value of the '<em><b>Is Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Part Of</em>' reference.
	 * @see #setIsPartOf(Continent)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCountry_IsPartOf()
	 * @model required="true"
	 * @generated
	 */
	Continent getIsPartOf();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.Country#getIsPartOf <em>Is Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Part Of</em>' reference.
	 * @see #getIsPartOf()
	 * @generated
	 */
	void setIsPartOf(Continent value);

} // Country
