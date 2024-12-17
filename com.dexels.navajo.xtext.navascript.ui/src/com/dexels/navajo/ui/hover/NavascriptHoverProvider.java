package com.dexels.navajo.ui.hover;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;

import com.dexels.navajo.navascript.impl.MapImpl;
import com.google.inject.Inject;

public class NavascriptHoverProvider extends DispatchingEObjectTextHover  {

	@Inject 
	private IResourceServiceProvider thisLanguageServiceProvider;

	private IInformationControlCreatorProvider lastCreatorProvider;

	@Override
	public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {		
		if ( first instanceof MapImpl ) {
			MapImpl map = (MapImpl) first;
			return map.getAdapterName();
		} else {
			return "Nothing to tell about this element...";
		}
		
//		IEObjectHoverProvider hoverProvider = findService(getURI(first));
//		if (hoverProvider==null)
//			return null;
//		IInformationControlCreatorProvider creatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
//		if (creatorProvider==null)
//			return null;
//		this.lastCreatorProvider = creatorProvider;
//		return lastCreatorProvider.getInfo();
	}

	public IEObjectHoverProvider findService(URI uri) {
		if (thisLanguageServiceProvider.canHandle(uri) || "asdoc".equals(uri.fileExtension()))
			return thisLanguageServiceProvider.get(IEObjectHoverProvider.class);
		return null;
	}

	public URI getURI(EObject eObject) {
		System.err.println("In getURI(" + eObject + ")");
//		if (eObject.eIsProxy()) {
//			return ((InternalEObject)eObject).eProxyURI();
//		} else {
//			return eObject.eResource().getURI();
//		}
		return null;
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return this.lastCreatorProvider==null?null:lastCreatorProvider.getHoverControlCreator();
	}

	@Override
	@Deprecated
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		final Object hoverInfo2 = getHoverInfo2(textViewer, hoverRegion);
		return hoverInfo2!=null ? hoverInfo2.toString() : null;
	}

}
