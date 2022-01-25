/**
 */
package de.mdelab.ldbc_snb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>City</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.ldbc_snb.City#getIsPartOf <em>Is Part Of</em>}</li>
 * </ul>
 *
 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCity()
 * @model
 * @generated
 */
public interface City extends Place {
	/**
	 * Returns the value of the '<em><b>Is Part Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Part Of</em>' reference.
	 * @see #setIsPartOf(Country)
	 * @see de.mdelab.ldbc_snb.Ldbc_snbPackage#getCity_IsPartOf()
	 * @model required="true"
	 * @generated
	 */
	Country getIsPartOf();

	/**
	 * Sets the value of the '{@link de.mdelab.ldbc_snb.City#getIsPartOf <em>Is Part Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Part Of</em>' reference.
	 * @see #getIsPartOf()
	 * @generated
	 */
	void setIsPartOf(Country value);

} // City
