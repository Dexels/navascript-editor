/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tml Identifier Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.TmlIdentifierLiteral#isHasExists <em>Has Exists</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.TmlIdentifierLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getTmlIdentifierLiteral()
 * @model
 * @generated
 */
public interface TmlIdentifierLiteral extends Expression
{
  /**
   * Returns the value of the '<em><b>Has Exists</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Has Exists</em>' attribute.
   * @see #setHasExists(boolean)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getTmlIdentifierLiteral_HasExists()
   * @model
   * @generated
   */
  boolean isHasExists();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.TmlIdentifierLiteral#isHasExists <em>Has Exists</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Has Exists</em>' attribute.
   * @see #isHasExists()
   * @generated
   */
  void setHasExists(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(TmlIdentifier)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getTmlIdentifierLiteral_Value()
   * @model containment="true"
   * @generated
   */
  TmlIdentifier getValue();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.TmlIdentifierLiteral#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(TmlIdentifier value);

} // TmlIdentifierLiteral
