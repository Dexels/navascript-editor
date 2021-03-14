package com.dexels.navajo.navigation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;

import com.dexels.navajo.navascript.InnerBody;
import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.navascript.impl.MapImpl;
import com.dexels.navajo.navascript.impl.MappedArrayFieldImpl;
import com.dexels.navajo.navascript.impl.PropertyImpl;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;
import com.dexels.navajo.xtext.navascript.navajobridge.ProxyValueDefinition;

public final class NavigationUtils {

	public NavigationUtils() {

	}

	public static AdapterClassDefinition findAdapterClass(NavajoProxyStub adapters, EObject model) {

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
				return findAdapterClass(adapters, parent.eContainer());
			}
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
			if ( node instanceof MapImpl || node instanceof MappedArrayFieldImpl ) {
				if ( currentLevel == 0 ) {
					return node;
				} else {
					currentLevel--;
				}
			} 
			return findFirstMapOrMappedField(node.eContainer(), currentLevel);
		} else {
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
			if ( e instanceof MapImpl || e instanceof MappedArrayFieldImpl ) {
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
