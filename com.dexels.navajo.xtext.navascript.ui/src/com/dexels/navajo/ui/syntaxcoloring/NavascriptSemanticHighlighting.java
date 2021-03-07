package com.dexels.navajo.ui.syntaxcoloring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import com.dexels.navajo.navascript.NavascriptPackage;
import com.dexels.navajo.navascript.impl.OptionImpl;
import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;
import com.dexels.navajo.xtext.navascript.navajobridge.OSGIRuntime;

public class NavascriptSemanticHighlighting extends DefaultSemanticHighlightingCalculator implements ServiceListener {

	NavajoProxyStub adapters = null;
	BundleContext context;

	public NavascriptSemanticHighlighting() {
		context = OSGIRuntime.getDefaultBundleContext();
		context.addServiceListener(this);
		System.err.println("In NavascriptSemanticHighlighting: " + context);
	}

	public synchronized void init() {
		if ( adapters == null ) {
			ServiceReference<NavajoProxyStub> ref = context.getServiceReference(NavajoProxyStub.class);
			adapters = context.getService(ref);
			System.err.println("In NavascriptSemanticHighlighting.init(): " + ref);
		}
	}
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		EObject rootObject = resource.getParseResult().getRootASTElement();

		// Find options in the document and color the "name", "value" and "selected" names as KEYWORD_ID
		for ( OptionImpl o : EcoreUtil2.getAllContentsOfType(rootObject, OptionImpl.class)) {

			for (INode node : NodeModelUtils.findNodesForFeature(o, NavascriptPackage.Literals.OPTION__OPTION) ) {

				acceptor.addPosition(node.getOffset(), node.getLength(), NavascriptLexicalHighlightingConfiguration.TML_KEYWORD);			
			}

		}

		super.provideHighlightingFor(resource, acceptor, cancelIndicator);
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		init();
	}

}

