/**
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.navascript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.dexels.navajo.navascript.Map#getAdapterName <em>Adapter Name</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Map#getArguments <em>Arguments</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Map#getObjectName <em>Object Name</em>}</li>
 *   <li>{@link com.dexels.navajo.navascript.Map#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see com.dexels.navajo.navascript.NavascriptPackage#getMap()
 * @model
 * @generated
 */
public interface Map extends EObject
{
  /**
   * Returns the value of the '<em><b>Adapter Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter Name</em>' attribute.
   * @see #setAdapterName(String)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMap_AdapterName()
   * @model
   * @generated
   */
  String getAdapterName();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Map#getAdapterName <em>Adapter Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adapter Name</em>' attribute.
   * @see #getAdapterName()
   * @generated
   */
  void setAdapterName(String value);

  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference.
   * @see #setArguments(KeyValueArguments)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMap_Arguments()
   * @model containment="true"
   * @generated
   */
  KeyValueArguments getArguments();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Map#getArguments <em>Arguments</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arguments</em>' containment reference.
   * @see #getArguments()
   * @generated
   */
  void setArguments(KeyValueArguments value);

  /**
   * Returns the value of the '<em><b>Object Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Name</em>' attribute.
   * @see #setObjectName(String)
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMap_ObjectName()
   * @model
   * @generated
   */
  String getObjectName();

  /**
   * Sets the value of the '{@link com.dexels.navajo.navascript.Map#getObjectName <em>Object Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Name</em>' attribute.
   * @see #getObjectName()
   * @generated
   */
  void setObjectName(String value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link com.dexels.navajo.navascript.InnerBody}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see com.dexels.navajo.navascript.NavascriptPackage#getMap_Statements()
   * @model containment="true"
   * @generated
   */
  EList<InnerBody> getStatements();

} // Map
