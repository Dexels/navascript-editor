package com.dexels.navajo.navigation;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;

import com.dexels.navajo.navascript.InnerBody;
import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.navascript.impl.LoopImpl;
import com.dexels.navajo.navascript.impl.MapImpl;
import com.dexels.navajo.navascript.impl.MappedArrayFieldImpl;
import com.dexels.navajo.navascript.impl.SetterFieldImpl;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;

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

	/**
	 * Finds first adapter class given a model as a starting point.
	 * 
	 * @param adapters
	 * @param model
	 * @param childAdapter
	 * @return
	 */
	public static AdapterClassDefinition findAdapterClass(NavajoProxyStub adapters, EObject model) {
				
		if ( model instanceof MapImpl ) {
			String adapterName = ((MapImpl) model).getAdapterName();
			AdapterClassDefinition acd = adapters.getAdapter( adapterName );
			return acd;
		}
		
		if ( model instanceof LoopImpl ) {
			LoopImpl loop = (LoopImpl) model;
			if ( loop.getMappable() != null ) { // It's not a loop over an array message.
				String fieldName = getFieldFromMappableIdentifier(loop.getMappable());
				int level = countMappableParentLevel(fieldName);
				EObject parent = NavigationUtils.findFirstMapOrMappedField(loop.eContainer(), level);
				AdapterClassDefinition parentMde = findAdapterClass(adapters, parent);
				try {
					AdapterClassDefinition acd = parentMde.getMappedFieldType(fieldName);
					return acd;
				} catch (Exception e) {
					//logger.error("Could not find adapter field: " + fieldName + "[" + e.getLocalizedMessage() + "]");
					return null;
				}
			}
		} 
		
		if ( model instanceof MappedArrayFieldImpl ) {
			MappedArrayFieldImpl maf = (MappedArrayFieldImpl) model;
			String fieldName = getFieldFromMappableIdentifier(maf.getField());
			int level = countMappableParentLevel(maf.getField());
			EObject parent = NavigationUtils.findFirstMapOrMappedField(maf.eContainer(), level);
			AdapterClassDefinition parentMde = findAdapterClass(adapters, parent);
			try {
				AdapterClassDefinition acd = parentMde.getMappedFieldType(fieldName);
				return acd;
			} catch (Exception e) {
				//logger.error("Could not find adapter field: " + fieldName + "[" + e.getLocalizedMessage() + "]");
				return null;
			}
		} 

		if ( model instanceof SetterFieldImpl ) {
			SetterFieldImpl sfi = (SetterFieldImpl) model;
			String fieldName = getFieldFromMappableIdentifier(sfi.getField());
			int level = countMappableParentLevel(sfi.getField());
			EObject parent = NavigationUtils.findFirstMapOrMappedField(sfi.eContainer(), level);
			AdapterClassDefinition parentMde = findAdapterClass(adapters, parent);
			try {
				AdapterClassDefinition acd = parentMde.getMappedFieldType(fieldName);
				return acd;
			} catch (Exception e) {
				//logger.error("Could not find adapter field: " + fieldName + "[" + e.getLocalizedMessage() + "]");
				return null;
			}

		} 
		
		return findAdapterClass(adapters, model.eContainer());
		
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

	// findFirstMapOrMappedField
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
				if ( sfi.getMappedField() != null || sfi.getMappedMessage() != null || sfi.getField() != null ) {
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
			// Check for LoopImpl. If it's the start node, fetch parents of LoopImpl to find parent adapter.
			if ( node instanceof LoopImpl && ((LoopImpl) node).getMappable() != null ) {
				
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
			if ( e instanceof SetterFieldImpl && ( ((SetterFieldImpl) e).getMappedMessage() != null || 
					                               ((SetterFieldImpl) e).getField() != null  ||
												   ((SetterFieldImpl) e).getMappedField() != null )) { //
				if ( currentLevel == 0 ) {
					return e;
				} else {
					currentLevel--;
				}
			} else if ( e instanceof MapImpl || e instanceof MappedArrayFieldImpl || e instanceof LoopImpl ) {
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
