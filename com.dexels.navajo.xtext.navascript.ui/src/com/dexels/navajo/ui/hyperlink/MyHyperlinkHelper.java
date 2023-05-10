package com.dexels.navajo.ui.hyperlink;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.util.TextRegion;

import com.dexels.navajo.navascript.impl.ScriptIdentifierImpl;
import com.dexels.navajo.xtext.navascript.ui.internal.NavascriptActivator;
import com.google.inject.Injector;

public class MyHyperlinkHelper extends HyperlinkHelper {	
	
	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		IParseResult parseResult = resource.getParseResult();

		if (parseResult != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), new TextRegion(offset, 0).getOffset());

			EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(leaf);
			if ( semanticObject.eContainer() instanceof ScriptIdentifierImpl ) {
				ScriptIdentifierImpl scriptIdentifier = (ScriptIdentifierImpl) semanticObject.eContainer();
				try {
					openHyperlinkInEditor(scriptIdentifier);
				} catch (RuntimeException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return null;
	}
		    
	private void openHyperlinkInEditor( EObject target ) {
		URI targetUriWithFragment = EcoreUtil.getURI(target);
		String findScriptsFolder = targetUriWithFragment.toString().substring(0, targetUriWithFragment.toString().indexOf("/scripts/") );
		ScriptIdentifierImpl scriptIdentifier = (ScriptIdentifierImpl) target;
		String fileName = findScriptsFolder + "/scripts" +  scriptIdentifier.getValue().getScript() + ".ns";
		targetUriWithFragment = URI.createURI(fileName);
		if (targetUriWithFragment != null && targetUriWithFragment.isPlatform() ) {
			Injector injector = NavascriptActivator.getInstance().getInjector("com.dexels.navajo.Navascript");
			IURIEditorOpener editorOpener = injector.getInstance(GlobalURIEditorOpener.class);
			editorOpener.open(targetUriWithFragment, true);			
		}
	}
    
}
