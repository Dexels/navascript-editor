package com.dexels.navajo.ui.syntaxcoloring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

import com.google.inject.Singleton;

@Singleton
public class NavascriptTokenToAttributeIdManager extends AbstractAntlrTokenToAttributeIdMapper {

	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");

	static String [] typesArray = {
			"'binary'","'boolean'","'clocktime'","'date'","'float'","'coordinate'","'integer'","'memo'","'percentage'","'string'","'timestamp'","'money'","'array'","'overwrite'",
			"'ignore'","'simple'","'arrayelement'","'selection'"
	};
	
	static String [] keywordArray =
		{
				"'if'",
				"'@debug'",
				"'then'",
				"'else'",
				"'map.'",
				"'map'",
				"'methods'",
				"'includes'",
				"'finally'",
				"'synchronized'",
				"'print'",
				"'log'",
				"'break'",
				"'validations'",
				"'methods'",
				"'include'",
				"'type'",
				"'subtype'",
				"'mode'",
				"'direction'",
				"'length'",
				"'cardinality'",
				"'var'",
				"'code'",
				"'description'",
				"'error'",
				"'check'",
				"'filter'",
				"'context'",
				"'breakOnNoLock'",
				"'timeout'",
				"'breakOnNoLock'",
				"'key'",
				"'loop'",
				"'object'",
				"RULE_IF",
				"RULE_THEN",
				"RULE_ELSE",
				"RULE_LOOP_DEF",
				"RULE_INCLUDE_DEF",
				"RULE_PRINT_DEF",
				"RULE_LOG_DEF",
				"RULE_SYNCHRONIZED_DEF",
				"RULE_METHODS_DEF",
				"RULE_VALIDATIONS_DEF",
				"RULE_FINALLY_DEF",
				"RULE_DEFINE_DEF",
				"RULE_CHECK_DEF",
				"RULE_TRUE",
				"RULE_FALSE",
				"RULE_IN_DEF",
				"RULE_OUT_DEF",
				"RULE_INOUT_DEF",
				"RULE_DESCRIPTION_DEF",
				"RULE_DIRECTION_DEF",
				"RULE_LENGTH_DEF",
				"RULE_TYPE_DEF",
				"RULE_SUBTYPE_DEF",
				"RULE_CARDINALITY_DEF",
				"RULE_FILTER_DEF",
				"RULE_FORALL",
				"RULE_EXISTS",
				"RULE_CODE_DEF",
				"RULE_VAR_DEF",
				"RULE_MAP_OLDSKOOL_DEF",
				"RULE_MAP_DEF",
				"RULE_MODE_DEF",
				"RULE_OBJECT_OLDSKOOL_DEF",
				"RULE_BREAK_DEF"
		};
	
	private static Set<String> keywordsSet = new HashSet<>(Arrays.asList(keywordArray));
	private static Set<String> typesSet = new HashSet<>(Arrays.asList(typesArray));
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		
		if ( "RULE_METHOD_IDENTIFIER".equals(tokenName) || "RULE_MAPPABLE_IDENTIFIER".equals(tokenName)) {
			return NavascriptLexicalHighlightingConfiguration.METHOD_NAME;
		}
		if(PUNCTUATION.matcher(tokenName).matches()) {
			return HighlightingStyles.PUNCTUATION_ID;
		}
		if( keywordsSet.contains(tokenName) || typesSet.contains(tokenName) ) {
			return HighlightingStyles.KEYWORD_ID;
		}
		if ("RULE_STRING_LITERAL".equals(tokenName) || "RULE_STRING_CONSTANT".equals(tokenName)) {
			return HighlightingStyles.STRING_ID;
		}
		if("RULE_QUOTED_IDENTIFIER".equals(tokenName)) {
			return NavascriptLexicalHighlightingConfiguration.QUOTED_IDENTIFIER_ID;
		}
		if ("'message'".equals(tokenName) || "'antimessage'".equals(tokenName) || "'property'".equals(tokenName) || "'option'".equals(tokenName)) {
			return NavascriptLexicalHighlightingConfiguration.TML_KEYWORD;
		}
		if ("RULE_TML_LITERAL".equals(tokenName)) {
			return NavascriptLexicalHighlightingConfiguration.TML_LITERAL;
		}
		if("RULE_INT".equals(tokenName)) {
			return HighlightingStyles.NUMBER_ID;
		}
		if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return HighlightingStyles.COMMENT_ID;
		}
		return HighlightingStyles.DEFAULT_ID;
	}

}
