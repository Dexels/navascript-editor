package com.dexels.navajo.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

import com.dexels.navajo.xtext.navascript.navajobridge.NavajoProxyStub;

public class NavascriptLexicalHighlightingConfiguration implements IHighlightingConfiguration {

	public static final String KEYWORD_ID = HighlightingStyles.KEYWORD_ID;
	public static final String PUNCTUATION_ID = HighlightingStyles.PUNCTUATION_ID;
	public static final String COMMENT_ID = HighlightingStyles.COMMENT_ID;
	public static final String STRING_ID = HighlightingStyles.STRING_ID;
	public static final String NUMBER_ID = HighlightingStyles.NUMBER_ID;
	public static final String DEFAULT_ID = HighlightingStyles.DEFAULT_ID;
	public static final String INVALID_TOKEN_ID = HighlightingStyles.INVALID_TOKEN_ID;
	public static final String QUOTED_IDENTIFIER_ID = "quotedIdentifier";
	public static final String TML_KEYWORD = "tml";
	public static final String TML_LITERAL = "tmlLiteral";
	public static final String METHOD_NAME = "Method name";
	public static final String MISSING_PARAMETERS = "Missing Parameters";
	
	/**
	 * @since 2.6
	 */
	public static final String TASK_ID = HighlightingStyles.TASK_ID;
	

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		
		NavajoProxyStub i = NavajoProxyStub.getInstance();

		System.err.println("In NavascriptLexicalHighlightingConfiguration.configure: " + i);
		
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
		acceptor.acceptDefaultHighlighting(QUOTED_IDENTIFIER_ID, "Quoted Identifier", identifierTextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation character", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(TASK_ID, "Task Tag", taskTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", errorTextStyle());
		acceptor.acceptDefaultHighlighting(TML_KEYWORD, "TML entity", tmlTextStyle());
		acceptor.acceptDefaultHighlighting(TML_LITERAL, "TML literal", tmlLiteralTextStyle());
		acceptor.acceptDefaultHighlighting(METHOD_NAME, "Method Name", methodTextStyle());
		acceptor.acceptDefaultHighlighting(MISSING_PARAMETERS, "Missing Parameters", errorTextStyle());
	}
	
	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		return textStyle;
	}
	
	public TextStyle errorTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255,0,0));
		textStyle.setStyle(SWT.UNDERLINE_ERROR);
		return textStyle;
	}
	
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}
	
	public TextStyle identifierTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(80, 0, 255));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}
	
	public TextStyle taskTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle methodTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
	
	public TextStyle tmlTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	public TextStyle tmlLiteralTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		return textStyle;
	}
	
	public TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

}
