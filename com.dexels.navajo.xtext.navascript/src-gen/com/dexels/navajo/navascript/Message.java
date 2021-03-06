/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.Message#getMessageName <em>Message Name</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Message#getArguments <em>Arguments</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Message#getStatements <em>Statements</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Message#getArrayField <em>Array Field</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Message#getArrayMessage <em>Array Message</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Message#getMessageArray <em>Message Array</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends EObject
{
  /**
   * Returns the value of the '<em><b>Message Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Name</em>' attribute.
   * @see #setMessageName(String)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_MessageName()
   * @model
   * @generated
   */
  String getMessageName();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Message#getMessageName <em>Message Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Name</em>' attribute.
   * @see #getMessageName()
   * @generated
   */
  void setMessageName(String value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference.
   * @see #setArguments(MessageArguments)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_Arguments()
   * @model containment="true"
   * @generated
   */
  MessageArguments getArguments();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Message#getArguments <em>Arguments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arguments</em>' containment reference.
   * @see #getArguments()
   * @generated
   */
  void setArguments(MessageArguments value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link com.dexels.navajo.navascript.InnerBody}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_Statements()
   * @model containment="true"
   * @generated
   */
  EList<InnerBody> getStatements();

  /**
   * Returns the value of the '<em><b>Array Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Field</em>' containment reference.
   * @see #setArrayField(MappedArrayField)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_ArrayField()
   * @model containment="true"
   * @generated
   */
  MappedArrayField getArrayField();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Message#getArrayField <em>Array Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Field</em>' containment reference.
   * @see #getArrayField()
   * @generated
   */
  void setArrayField(MappedArrayField value);

  /**
   * Returns the value of the '<em><b>Array Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Message</em>' containment reference.
   * @see #setArrayMessage(MappedArrayMessage)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_ArrayMessage()
   * @model containment="true"
   * @generated
   */
  MappedArrayMessage getArrayMessage();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Message#getArrayMessage <em>Array Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Message</em>' containment reference.
   * @see #getArrayMessage()
   * @generated
   */
  void setArrayMessage(MappedArrayMessage value);

  /**
   * Returns the value of the '<em><b>Message Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Array</em>' containment reference.
   * @see #setMessageArray(MessageArray)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMessage_MessageArray()
   * @model containment="true"
   * @generated
   */
  MessageArray getMessageArray();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Message#getMessageArray <em>Message Array</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Array</em>' containment reference.
   * @see #getMessageArray()
   * @generated
   */
  void setMessageArray(MessageArray value);

} // Message
