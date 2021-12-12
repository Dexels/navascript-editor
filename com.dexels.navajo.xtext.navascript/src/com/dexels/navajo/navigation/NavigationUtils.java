package com.dexels.navajo.navigation;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;

import com.dexels.navajo.navascript.InnerBody;
import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.navascript.impl.MapImpl;
import com.dexels.navajo.navascript.impl.MappedArrayFieldImpl;
import com.dexels.navajo.navascript.impl.SetterFieldImpl;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;
import com.dexels.navajo.xtext.navascript.navajobridge.ProxyValueDefinition;

/**
 * This class contains helper method to find current "class context" in a script (findAdapterClass).
 *  
 * @author arjenschoneveld
 *
 */
public final class NavigationUtils {

	private static final Logger logger = Logger.getLogger(NavigationUtils.class);
			
	public NavigationUtils() {

	}

	public static AdapterClassDefinition findAdapterClass(NavajoProxyStub adapters, EObject model, String childAdapter) {

		if ( model instanceof MapImpl ) {
			return adapters.getAdapter(((MapImpl) model).getAdapterName());
		} 

		if ( model instanceof MappedArrayFieldImpl ) {
			MappedArrayFieldImpl maf = (MappedArrayFieldImpl) model;
			String fieldName = getFieldFromMappableIdentifier(maf.getField());
			int level = countMappableParentLevel(maf.getField());
			EObject parent = NavigationUtils.findFirstMapOrMappedField(maf.eContainer(), level);
			if ( parent instanceof MapImpl ) {
				MapImpl parentMap = (MapImpl) parent;
				AdapterClassDefinition mde = adapters.getAdapter(parentMap.getAdapterName());
				ProxyValueDefinition vdef = mde.getMapDefinition().getValueDefinition(fieldName);
				return adapters.getAdapter(vdef.getMapType());
			} else if ( parent instanceof MappedArrayFieldImpl ) {
				return findAdapterClass(adapters, parent.eContainer(), childAdapter);
			} 
		} else if ( model instanceof SetterFieldImpl ) {
			SetterFieldImpl sfi = (SetterFieldImpl) model;
			String fieldName = getFieldFromMappableIdentifier(sfi.getField());
			int level = countMappableParentLevel(sfi.getField());
			EObject parent = NavigationUtils.findFirstMapOrMappedField(sfi.eContainer(), level);
			if ( parent instanceof MapImpl ) {
				MapImpl parentMap = (MapImpl) parent;
				AdapterClassDefinition mde = adapters.getAdapter(parentMap.getAdapterName());
				try {
					AdapterClassDefinition fieldClass = mde.getMappedFieldType(fieldName);
					// Check if childAdapter is non-zero
					if ( childAdapter != null ) {
						for ( String nextChild : childAdapter.split("\\.")) {
							fieldClass = fieldClass.getMappedFieldType(nextChild);
						}
					}
					return fieldClass;
				} catch (Exception e) {
					return null;
				}
			} else if ( parent instanceof MappedArrayFieldImpl ) {
				return findAdapterClass(adapters, parent.eContainer(), childAdapter);
			} else if ( parent instanceof SetterFieldImpl ) {
				return findAdapterClass(adapters, parent, ( childAdapter != null ? fieldName + "." + childAdapter : fieldName ));
			}

		} else {
			logger.warn("In findAdapterClass. model is unknown: " + model);
		}

		return null;
	}

	public static InnerBody findInnerBody(EObject node) {

		if ( node == null ) {
			return null;
		}

		if ( node instanceof InnerBody ) {
			return (InnerBody) node;
		}

		return findInnerBody(node.eContainer());
	}

	public static Message findMessage(EObject node) {

		if ( node == null ) {
			return null;
		}

		if ( node instanceof Message ) {
			return (Message) node;
		}

		return findMessage(node.eContainer());
	}

	public static EObject findFirstMapOrMappedField(EObject node, int level) {

		if ( level < 0 ) {
			return null;
		}

		int currentLevel = level;
		if ( node != null ) {
			boolean isMappedSetterField = false;
			if ( node instanceof SetterFieldImpl ) {
				// mappedField
				SetterFieldImpl sfi = (SetterFieldImpl) node;
				if ( sfi.getMappedField() != null || sfi.getMappedMessage() != null ) {
					isMappedSetterField = true;
				}
			}
			if ( node instanceof MapImpl || node instanceof MappedArrayFieldImpl || isMappedSetterField ) {
				if ( currentLevel == 0 ) {
					return node;
				} else {
					currentLevel--;
				}
			} 
			return findFirstMapOrMappedField(node.eContainer(), currentLevel);
		} else {
			logger.warn("EObject is null");
			return null;
		}
	}

	public static EObject findFirstMapOrMappedField(INode node, int level) {

		if ( level < 0 ) {
			return null;
		}

		int currentLevel = level;
		if ( node != null ) {
			EObject e = node.getSemanticElement();
			if ( e instanceof SetterFieldImpl && ((SetterFieldImpl) e).getMappedMessage() != null ) { //
				if ( currentLevel == 0 ) {
					return e;
				} else {
					currentLevel--;
				}
			} else if ( e instanceof MapImpl || e instanceof MappedArrayFieldImpl ) {
				if ( currentLevel == 0 ) {
					return e;
				} else {
					currentLevel--;
				}
			} 
			return findFirstMapOrMappedField(node.getParent(), currentLevel);
		} else {
			return null;
		}
	}

	public static int countMappableParentLevel(String prefix) {

		if ( prefix.indexOf("../") == -1 ) {
			return 0;
		} else {
			prefix = prefix.replaceFirst("\\.\\.\\/", "");
			return 1 + countMappableParentLevel(prefix);
		}

	}

	public static String getParentPrefix(String raw, StringBuffer cleaned) {

		if ( cleaned.toString().equals("") ) {
			cleaned.append("$");
		}

		if ( raw.indexOf("../") != -1 ) {
			cleaned.append("../");
			return getParentPrefix(raw.replaceFirst("\\.\\.\\/", ""), cleaned);
		}
		return cleaned.toString();
	}

	public static String getFieldFromMappableIdentifier(String raw) {

		raw = raw.replaceAll("\\$", "");
		raw = raw.replaceAll("\\.\\.\\/", "");
		return raw;

	}

}
