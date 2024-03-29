/*
 * generated by Xtext 2.24.0
 */
package com.dexels.navajo.formatting2;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import com.dexels.navajo.NavascriptStandaloneSetup;
import com.dexels.navajo.navascript.AntiMessage;
import com.dexels.navajo.navascript.BlockStatements;
import com.dexels.navajo.navascript.Break;
import com.dexels.navajo.navascript.Check;
import com.dexels.navajo.navascript.ConditionalExpression;
import com.dexels.navajo.navascript.Include;
import com.dexels.navajo.navascript.InnerBody;
import com.dexels.navajo.navascript.Log;
import com.dexels.navajo.navascript.Loop;
import com.dexels.navajo.navascript.Map;
import com.dexels.navajo.navascript.MappedArrayField;
import com.dexels.navajo.navascript.MappedArrayMessage;
import com.dexels.navajo.navascript.Message;
import com.dexels.navajo.navascript.MessageArray;
import com.dexels.navajo.navascript.MessageArrayElement;
import com.dexels.navajo.navascript.Method;
import com.dexels.navajo.navascript.MethodOrSetter;
import com.dexels.navajo.navascript.Methods;
import com.dexels.navajo.navascript.Navascript;
import com.dexels.navajo.navascript.NavascriptPackage;
import com.dexels.navajo.navascript.Option;
import com.dexels.navajo.navascript.Print;
import com.dexels.navajo.navascript.Property;
import com.dexels.navajo.navascript.SelectionArray;
import com.dexels.navajo.navascript.SelectionArrayElement;
import com.dexels.navajo.navascript.Synchronized;
import com.dexels.navajo.navascript.TopLevelStatement;
import com.dexels.navajo.navascript.TopLevelStatements;
import com.dexels.navajo.navascript.Validations;
import com.dexels.navajo.navascript.Var;
import com.dexels.navajo.services.NavascriptGrammarAccess;
import com.google.inject.Injector;

public class NavascriptFormatter extends AbstractJavaFormatter {

	NavascriptGrammarAccess grammar;
	
	public NavascriptFormatter() {
		grammar = getAllKeywords();
		System.err.println("NavascriptFormatter constructor called: " + grammar);
		//GrammarUtil.getAllKeywords(NavascriptGrammarAccess.class);
	}

	/**
	 * protected void _format(Parent parent, IFormattableDocument doc) {
	 * 		doc.prepend(regionFor(parent).keyword("parent"), this::noSpace);
	 * 		doc.append(regionFor(parent).keyword("parent"), this::oneSpace);
	 * 		doc.append(regionFor(parent).feature(PARENT__NAME), this::oneSpace);
	 * 		doc.prepend(regionFor(parent).keyword("{"), this::oneSpace);
	 * 		doc.append(regionFor(parent).keyword("{"), this::newLine);
	 * 		doc.interior(regionFor(parent).keyword("{"), regionFor(parent).keyword("}"), this::indent);
	 * 		doc.append(regionFor(parent).keyword("}"), it -> it.setNewLines(1, 1, 2));
	 * 		for (Child child : parent.getChildren())
	 * 			doc.format(child);
	 * 	}
	 * 
	 * @param navascript
	 * @param doc
	 */
	protected void format(Navascript navascript, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		//doc.format(navascript.getValidations());
		formatValidations(navascript.getValidations(), doc);
		//regionFor(navascript.getValidations());
		//doc.append(regionFor(navascript.getValidations()).keyword("}"), it -> it.setNewLines(1, 2, 2));
		doc.format(navascript.getToplevelStatements());
		doc.format(navascript.getFinally());
	}

	protected void format(TopLevelStatements topLevelStatements, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (TopLevelStatement topLevelStatement : topLevelStatements.getStatements()) {
			doc.format(topLevelStatement);
		}
	}

	// 	statement=( Message | Var | Map | AntiMessage | Define | Print | Log | Loop | Methods | Include | Break | Synchronized | BlockStatements )
	protected void format(TopLevelStatement tls, IFormattableDocument doc) {
		try {
			formatStatement(tls.getStatement(), doc, true);
		} catch (org.eclipse.xtext.formatting2.internal.ConflictingRegionsException cre) {

		}
	}

	protected void formatStatement(EObject statement, IFormattableDocument doc, boolean topLevel) {

		if ( statement instanceof Map ) {
			Map map = (Map) statement;
			formatMap(map, doc);
		}
		if ( statement instanceof Methods ) {
			Methods map = (Methods) statement;
			formatMethods(map, doc);
		}
		if ( statement instanceof Message ) {
			Message message = (Message) statement;
			formatMessage(message, doc);
		}
		if ( statement instanceof BlockStatements ) {
			BlockStatements var = (BlockStatements) statement;
			formatBlockStatements(var, doc);
		}
		if ( statement instanceof Validations ) {
			Validations message = (Validations) statement;
			formatValidations(message, doc);
		}
		if ( statement instanceof Property ) {
			Property property = (Property) statement;
			formatProperty(property, doc);
		}
		if ( statement instanceof Option ) {
			Option property = (Option) statement;
			formatOption(property, doc);
		}
		if ( statement instanceof Var ) {
			Var var = (Var) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof Print ) {
			Print var = (Print) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof Log ) {
			Log var = (Log) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof Break ) {
			Break var = (Break) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof Include ) {
			Include var = (Include) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof AntiMessage ) {
			AntiMessage var = (AntiMessage) statement;
			singleStatement(var, doc);
		}
		if ( statement instanceof MethodOrSetter ) {
			MethodOrSetter var = (MethodOrSetter) statement;
			formatMethodOrSetter(var, doc);
		}
		if ( statement instanceof Loop ) {
			Loop var = (Loop) statement;
			formatLoop(var, doc);
		}
		if ( statement instanceof Synchronized ) {
			Synchronized var = (Synchronized) statement;
			formatSynchronized(var, doc);
		}
		if ( statement instanceof BlockStatements ) {
			BlockStatements var = (BlockStatements) statement;
			formatBlockStatement(var, doc);
		}
	}

	private void formatBalancedCharBlock(EObject eo, IFormattableDocument doc, String openChar, String closeChar) {

		try {
			doc.interior(regionFor(eo).keyword(openChar), regionFor(eo).keyword(closeChar), it -> it.indent());
			doc.prepend(regionFor(eo).keyword(openChar), it -> it.oneSpace());
			doc.append(regionFor(eo).keyword(openChar), it ->  it.setNewLines(1, 1, 2));
			doc.prepend(regionFor(eo).keyword(closeChar), it -> it.setNewLines(1, 1, 2));
		} catch (Throwable t) {

		}
	}

	private void formatEOL(EObject eo, IFormattableDocument doc) {
		try {
			doc.append(regionFor(eo).keyword(";"), it -> it.setNewLines(1, 1, 2));
		} catch (Throwable t) {

		}
	}
	/**
	 * InnerBody:
	{InnerBody} (IF condition=Expression THEN)?
	statement=( Property |  Option | MethodOrSetter|  Message | AntiMessage | Include | Methods | Var | Print | Log | Define | Loop | Map | Break | BlockStatements )
;

	 * @param map
	 * @param doc
	 */
	protected void formatMap(Map map, IFormattableDocument doc) {

		doc.prepend(regionFor(map).keyword("map."), it ->  it.setNewLines(1, 1, 2));
		formatBalancedCharBlock(map, doc, "{", "}");
		doc.append(regionFor(map).keyword("}"), it ->  it.setNewLines(1, 1, 2));
		formatInnerBody( map.getStatements(), doc);
	}

	private NavascriptGrammarAccess getAllKeywords() {
		
		Injector injector = new NavascriptStandaloneSetup().createInjectorAndDoEMFRegistration();
		NavascriptGrammarAccess ga = injector.getInstance(NavascriptGrammarAccess.class);
		Set<String> keywords = GrammarUtil.getAllKeywords(ga.getGrammar());
		System.err.println("keywords: " + keywords);
		
		return ga;

	}

	protected void formatMethods(Methods map, IFormattableDocument doc) {

		doc.prepend(regionFor(map).keyword("methods"), it ->  it.setNewLines(1, 1, 2));
		formatBalancedCharBlock(map, doc, "{", "}");
		EList<Method> methods = map.getMethods();
		for ( Method m : methods ) {
			singleStatement(m, doc);
		}
		doc.append(regionFor(map).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void formatBlockStatement(BlockStatements var, IFormattableDocument doc) {
		formatBalancedCharBlock(var, doc, "{", "}");
		formatInnerBody(var.getStatements(), doc);
		doc.append(regionFor(var).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void formatLoop(Loop var, IFormattableDocument doc) {
		formatBalancedCharBlock(var, doc, "{", "}");
		formatInnerBody(var.getStatements(), doc);
		doc.append(regionFor(var).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}
	
	private void formatBlockStatements(BlockStatements var, IFormattableDocument doc) {
		formatBalancedCharBlock(var, doc, "{", "}");
		formatInnerBody(var.getStatements(), doc);
		doc.append(regionFor(var).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}
	
	private void formatValidations(Validations var, IFormattableDocument doc) {
		if ( var == null ) {
			return;
		}
		doc.prepend(regionFor(var).keyword("validations"), it ->  it.setNewLines(1, 1, 2));
		formatBalancedCharBlock(var, doc, "{", "}");
		EList<Check> checks = var.getChecks();
		if ( checks == null ) {
			return;
		}
		for ( Check m : checks ) {
			singleStatement(m, doc);
		}
		doc.append(regionFor(var).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void formatSynchronized(Synchronized var, IFormattableDocument doc) {
		if ( var == null ) {
			return;
		}
		formatBalancedCharBlock(var, doc, "{", "}");
		EList<TopLevelStatement> statements = var.getStatements();
		for ( TopLevelStatement tls : statements ) {
			format(tls, doc);
		}
		doc.append(regionFor(var).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void formatInnerBody(EList<InnerBody> ib, IFormattableDocument doc) {
		for ( InnerBody child : ib ) {
			formatStatement(child.getStatement(), doc, false);
		}
	}

	protected void formatMessage(Message map, IFormattableDocument doc) {

		doc.prepend(regionFor(map).keyword("message"), it ->  it.setNewLines(1, 1, 2));
		
		formatBalancedCharBlock(map, doc, "{", "}");
		formatBalancedCharBlock(map, doc, "[", "]");

		EList<InnerBody> children =  map.getStatements();
		for ( InnerBody child : children ) {
			formatStatement(child.getStatement(), doc, false);
		}
		if ( map.getArrayField() != null ) {
			formatMappedArrayField(map.getArrayField(), doc);
		}
		formatEOL(map, doc);
		if ( map.getMessageArray() != null ) {
			MessageArray ma = map.getMessageArray();
			EList<MessageArrayElement> sae = ma.getArrayMessageElements();
			for ( MessageArrayElement elt : sae) {
				formatBalancedCharBlock(elt, doc, "{", "}");
				EList<InnerBody> eltChildren =  elt.getStatements();
				for ( InnerBody child : eltChildren ) {
					formatStatement(child.getStatement(), doc, false);
				}
			}
		}
		if ( map.getArrayMessage() != null ) {
			formatMappedArrayMessage(map.getArrayMessage(), doc);
		}
		doc.append(regionFor(map).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	protected void formatMappedArrayField(MappedArrayField maf, IFormattableDocument doc) {
		formatBalancedCharBlock(maf, doc, "{", "}");
		EList<InnerBody> children =  maf.getStatements();
		for ( InnerBody child : children ) {
			formatStatement(child.getStatement(), doc, false);
		}
		doc.append(regionFor(maf).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void formatMappedArrayMessage(MappedArrayMessage mam, IFormattableDocument doc) {
		formatBalancedCharBlock(mam, doc, "{", "}");
		EList<InnerBody> children =  mam.getStatements();
		for ( InnerBody child : children ) {
			formatStatement(child.getStatement(), doc, false);
		}
		doc.append(regionFor(mam).keyword("}"), it ->  it.setNewLines(1, 1, 2));
	}

	private void singleStatement(EObject single, IFormattableDocument doc) {
		formatEOL(single, doc);
	}

	protected void formatOption(Option map, IFormattableDocument doc) {
		formatEOL(map, doc);
	}

	protected void formatProperty(Property map, IFormattableDocument doc) {

		formatBalancedCharBlock(map, doc, "{", "}");

		formatBalancedCharBlock(map, doc, "[", "]");

		doc.surround(regionFor(map).keyword("="), it->it.oneSpace());
		doc.surround(regionFor(map).feature(NavascriptPackage.Literals.PROPERTY__PROPERTY_NAME), it->it.oneSpace());

		doc.append(regionFor(map.getArguments()).keyword(","), it->it.oneSpace());

		if ( map.getExpressionList() != null && map.getExpressionList().getConditionalExpressions() != null ) {
			doc.interior(regionFor(map).keyword("="), regionFor(map).keyword(";"), it -> it.indent());
			EList<ConditionalExpression> ceList = map.getExpressionList().getConditionalExpressions();
			doc.prepend(regionFor(map.getExpressionList()).keyword("else"), it -> it.setNewLines(1, 2, 2));
			for ( ConditionalExpression ce : ceList) {
				doc.interior(regionFor(ce).keyword("if"), regionFor(ce).keyword(";"), it -> it.indent());
				doc.prepend(regionFor(ce).keyword("if"), it -> it.setNewLines(1, 2, 2) );
			}
		} 
		formatEOL(map, doc);
		if ( map.getSelectionArray() != null ) {
			SelectionArray sa = map.getSelectionArray();
			formatBalancedCharBlock(sa, doc, "[", "]");
			EList<SelectionArrayElement> sae = sa.getArrayElements();
			for ( SelectionArrayElement elt : sae) {
				formatSelectionArrayElt(elt, doc);
			}
		}
	}

	private void formatSelectionArrayElt(SelectionArrayElement sae, IFormattableDocument doc) {
		formatInnerBody(sae.getInnerBody(), doc);
	}

	protected void formatMethodOrSetter(MethodOrSetter map, IFormattableDocument doc) {
		formatEOL(map, doc);
	}

	// TODO: implement for TopLevelStatement, InnerBody, BlockStatements, Synchronized, SynchronizedArguments, Break, BreakParameter, BreakParameters, Validations, Define, Check, CheckAttribute, LiteralOrExpression, Print, Log, Finally, Loop, Message, MessageArray, MessageArrayElement, MessageArguments, Map, AdapterMethod, SetterField, MappedArrayField, MappedArrayMessage, KeyValueArguments, KeyValueArgument, Var, VarArray, VarArrayElement, VarElement, VarArguments, VarArgument, VarType, VarMode, Property, SelectionArray, SelectionArrayElement, Option, PropertyArguments, DescriptionArgument, TypeArgument, ConditionalExpressions, ConditionalExpression, AndOrExpression, Comparison, Equals, MultiOrDiv, BooleanNegation, ArithmeticSigned, ExpressionLiteral, FunctionCallLiteral, MappableIdentifierLiteral, TmlIdentifierLiteral, ForAllLiteral, ForAllIdentifier, FunctionIdentifier, MappableIdentifier, Plus, Minus
}
