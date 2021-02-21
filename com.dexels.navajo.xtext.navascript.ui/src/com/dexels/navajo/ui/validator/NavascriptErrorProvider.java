package com.dexels.navajo.ui.validator;

import static org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC;

import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

public class NavascriptErrorProvider extends SyntaxErrorMessageProvider {
	
	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		System.err.println("In NavascriptErrorProvider.getSyntaxErrorMessage: " + context);
		return new SyntaxErrorMessage(context.getDefaultMessage(), SYNTAX_DIAGNOSTIC);
	}
}

