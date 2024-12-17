package com.dexels.navajo.ui.hyperlink;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

public class HyperlinkProvider implements IHyperlinkDetector {

	public HyperlinkProvider() {
		System.err.println("In HyperlinkProvider.....");
	}
	
	@Override
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
			IRegion region, boolean canShowMultipleHyperlinks) {
		System.err.println("In detectHyperLinks: ");
		return null;
//		this.setHelper(new MyHyperlinkHelper());
//		return super.detectHyperlinks(textViewer, region, canShowMultipleHyperlinks);
	}
	
}
