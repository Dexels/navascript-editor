package com.dexels.navajo.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.dexels.navajo.services.NavascriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalNavascriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SYNCHRONIZED_DEF", "RULE_ARGS_START", "RULE_ARGS_END", "RULE_CONTEXT_DEF", "RULE_KEY_DEF", "RULE_TIMEOUT_DEF", "RULE_BREAKONNOLOCK_DEF", "RULE_BREAK_DEF", "RULE_CODE_DEF", "RULE_DESCRIPTION_DEF", "RULE_ERROR_DEF", "RULE_VALIDATIONS_DEF", "RULE_DEFINE_DEF", "RULE_QUOTED_IDENTIFIER", "RULE_CHECK_DEF", "RULE_STRING_CONSTANT", "RULE_PRINT_DEF", "RULE_LOG_DEF", "RULE_FINALLY_DEF", "RULE_LOOP_DEF", "RULE_FILTER_DEF", "RULE_INCLUDE_DEF", "RULE_TYPE_DEF", "RULE_MODE_DEF", "RULE_IDENTIFIER", "RULE_MAP_OLDSKOOL_DEF", "RULE_OBJECT_OLDSKOOL_DEF", "RULE_OBJECT_IDENTIFIER", "RULE_METHOD_IDENTIFIER", "RULE_MAPPABLE_IDENTIFIER", "RULE_TML_LITERAL", "RULE_VAR_DEF", "RULE_PROPERTY_DEF", "RULE_OPTION_DEF", "RULE_LENGTH_DEF", "RULE_INTEGER", "RULE_DIRECTION_DEF", "RULE_IN_DEF", "RULE_OUT_DEF", "RULE_INOUT_DEF", "RULE_CARDINALITY_DEF", "RULE_SUBTYPE_DEF", "RULE_STRING_LITERAL", "RULE_TRUE", "RULE_FALSE", "RULE_NULL_DEF", "RULE_FORALL", "RULE_EXISTS", "RULE_MAPPABLE_ID", "RULE_LETTER", "RULE_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_CHARACTER", "'if'", "'then'", "'{'", "'}'", "','", "'='", "':'", "'user'", "'service'", "';'", "'methods'", "'antimessage'", "'message'", "'['", "']'", "'map.'", "'+'", "'1'", "'else'", "'OR'", "'AND'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'-'", "'*'", "'/'", "'!'", "'?'", "'`'", "'integer'", "'string'", "'boolean'", "'date'", "'float'", "'binary'", "'clocktime'", "'memo'", "'timestamp'", "'percentage'", "'selection'", "'name'", "'value'", "'selected'", "'array'", "'simple'", "'arrayelement'", "'ignore'", "'overwrite'"
    };
    public static final int RULE_FINALLY_DEF=22;
    public static final int RULE_CHARACTER=58;
    public static final int T__59=59;
    public static final int RULE_BREAKONNOLOCK_DEF=10;
    public static final int RULE_DIRECTION_DEF=40;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_DIGIT=54;
    public static final int RULE_TYPE_DEF=26;
    public static final int RULE_EXISTS=51;
    public static final int RULE_NULL_DEF=49;
    public static final int RULE_MAPPABLE_IDENTIFIER=33;
    public static final int RULE_METHOD_IDENTIFIER=32;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=55;
    public static final int T__67=67;
    public static final int RULE_CARDINALITY_DEF=44;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_BREAK_DEF=11;
    public static final int RULE_FALSE=48;
    public static final int T__62=62;
    public static final int RULE_FILTER_DEF=24;
    public static final int T__63=63;
    public static final int RULE_INOUT_DEF=43;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_KEY_DEF=8;
    public static final int RULE_OPTION_DEF=37;
    public static final int RULE_DEFINE_DEF=16;
    public static final int RULE_QUOTED_IDENTIFIER=17;
    public static final int RULE_CODE_DEF=12;
    public static final int RULE_LETTER=53;
    public static final int RULE_IN_DEF=41;
    public static final int RULE_MAPPABLE_ID=52;
    public static final int RULE_ERROR_DEF=14;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_SUBTYPE_DEF=45;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_PRINT_DEF=20;
    public static final int RULE_CHECK_DEF=18;
    public static final int RULE_ARGS_START=5;
    public static final int T__99=99;
    public static final int RULE_OUT_DEF=42;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int RULE_INCLUDE_DEF=25;
    public static final int T__98=98;
    public static final int RULE_CONTEXT_DEF=7;
    public static final int RULE_STRING_CONSTANT=19;
    public static final int RULE_OBJECT_OLDSKOOL_DEF=30;
    public static final int RULE_DESCRIPTION_DEF=13;
    public static final int RULE_SYNCHRONIZED_DEF=4;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_IDENTIFIER=28;
    public static final int RULE_STRING_LITERAL=46;
    public static final int RULE_SL_COMMENT=56;
    public static final int RULE_PROPERTY_DEF=36;
    public static final int RULE_FORALL=50;
    public static final int RULE_TML_LITERAL=34;
    public static final int T__77=77;
    public static final int RULE_TRUE=47;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int RULE_MAP_OLDSKOOL_DEF=29;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_LOG_DEF=21;
    public static final int RULE_WS=57;
    public static final int RULE_ARGS_END=6;
    public static final int RULE_TIMEOUT_DEF=9;
    public static final int RULE_LENGTH_DEF=38;
    public static final int RULE_VAR_DEF=35;
    public static final int RULE_VALIDATIONS_DEF=15;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int RULE_LOOP_DEF=23;
    public static final int RULE_OBJECT_IDENTIFIER=31;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=39;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int RULE_MODE_DEF=27;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalNavascriptParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNavascriptParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNavascriptParser.tokenNames; }
    public String getGrammarFileName() { return "InternalNavascript.g"; }



     	private NavascriptGrammarAccess grammarAccess;

        public InternalNavascriptParser(TokenStream input, NavascriptGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Navascript";
       	}

       	@Override
       	protected NavascriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleNavascript"
    // InternalNavascript.g:64:1: entryRuleNavascript returns [EObject current=null] : iv_ruleNavascript= ruleNavascript EOF ;
    public final EObject entryRuleNavascript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavascript = null;


        try {
            // InternalNavascript.g:64:51: (iv_ruleNavascript= ruleNavascript EOF )
            // InternalNavascript.g:65:2: iv_ruleNavascript= ruleNavascript EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavascriptRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNavascript=ruleNavascript();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavascript; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavascript"


    // $ANTLR start "ruleNavascript"
    // InternalNavascript.g:71:1: ruleNavascript returns [EObject current=null] : ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? ) ;
    public final EObject ruleNavascript() throws RecognitionException {
        EObject current = null;

        EObject lv_validations_1_0 = null;

        EObject lv_toplevelStatements_2_0 = null;

        EObject lv_finally_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:77:2: ( ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? ) )
            // InternalNavascript.g:78:2: ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? )
            {
            // InternalNavascript.g:78:2: ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? )
            // InternalNavascript.g:79:3: () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )?
            {
            // InternalNavascript.g:79:3: ()
            // InternalNavascript.g:80:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNavascriptAccess().getNavascriptAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:86:3: ( (lv_validations_1_0= ruleValidations ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_VALIDATIONS_DEF) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNavascript.g:87:4: (lv_validations_1_0= ruleValidations )
                    {
                    // InternalNavascript.g:87:4: (lv_validations_1_0= ruleValidations )
                    // InternalNavascript.g:88:5: lv_validations_1_0= ruleValidations
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNavascriptAccess().getValidationsValidationsParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_validations_1_0=ruleValidations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNavascriptRule());
                      					}
                      					set(
                      						current,
                      						"validations",
                      						lv_validations_1_0,
                      						"com.dexels.navajo.Navascript.Validations");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:105:3: ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:106:4: (lv_toplevelStatements_2_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:106:4: (lv_toplevelStatements_2_0= ruleTopLevelStatements )
            // InternalNavascript.g:107:5: lv_toplevelStatements_2_0= ruleTopLevelStatements
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNavascriptAccess().getToplevelStatementsTopLevelStatementsParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_toplevelStatements_2_0=ruleTopLevelStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNavascriptRule());
              					}
              					set(
              						current,
              						"toplevelStatements",
              						lv_toplevelStatements_2_0,
              						"com.dexels.navajo.Navascript.TopLevelStatements");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:124:3: ( (lv_finally_3_0= ruleFinally ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_FINALLY_DEF) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalNavascript.g:125:4: (lv_finally_3_0= ruleFinally )
                    {
                    // InternalNavascript.g:125:4: (lv_finally_3_0= ruleFinally )
                    // InternalNavascript.g:126:5: lv_finally_3_0= ruleFinally
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNavascriptAccess().getFinallyFinallyParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_finally_3_0=ruleFinally();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNavascriptRule());
                      					}
                      					set(
                      						current,
                      						"finally",
                      						lv_finally_3_0,
                      						"com.dexels.navajo.Navascript.Finally");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavascript"


    // $ANTLR start "entryRuleTopLevelStatements"
    // InternalNavascript.g:147:1: entryRuleTopLevelStatements returns [EObject current=null] : iv_ruleTopLevelStatements= ruleTopLevelStatements EOF ;
    public final EObject entryRuleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatements = null;


        try {
            // InternalNavascript.g:147:59: (iv_ruleTopLevelStatements= ruleTopLevelStatements EOF )
            // InternalNavascript.g:148:2: iv_ruleTopLevelStatements= ruleTopLevelStatements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelStatementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTopLevelStatements=ruleTopLevelStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelStatements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelStatements"


    // $ANTLR start "ruleTopLevelStatements"
    // InternalNavascript.g:154:1: ruleTopLevelStatements returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) ;
    public final EObject ruleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:160:2: ( ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) )
            // InternalNavascript.g:161:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            {
            // InternalNavascript.g:161:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            // InternalNavascript.g:162:3: () ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            {
            // InternalNavascript.g:162:3: ()
            // InternalNavascript.g:163:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTopLevelStatementsAccess().getTopLevelStatementsAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:169:3: ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_SYNCHRONIZED_DEF||LA3_0==RULE_BREAK_DEF||LA3_0==RULE_DEFINE_DEF||(LA3_0>=RULE_PRINT_DEF && LA3_0<=RULE_LOG_DEF)||LA3_0==RULE_LOOP_DEF||LA3_0==RULE_INCLUDE_DEF||LA3_0==RULE_MAP_OLDSKOOL_DEF||LA3_0==RULE_VAR_DEF||LA3_0==59||LA3_0==61||(LA3_0>=69 && LA3_0<=71)||LA3_0==74) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalNavascript.g:170:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:170:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:171:5: lv_statements_1_0= ruleTopLevelStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTopLevelStatementsAccess().getStatementsTopLevelStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_statements_1_0=ruleTopLevelStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTopLevelStatementsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"com.dexels.navajo.Navascript.TopLevelStatement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelStatements"


    // $ANTLR start "entryRuleTopLevelStatement"
    // InternalNavascript.g:192:1: entryRuleTopLevelStatement returns [EObject current=null] : iv_ruleTopLevelStatement= ruleTopLevelStatement EOF ;
    public final EObject entryRuleTopLevelStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatement = null;


        try {
            // InternalNavascript.g:192:58: (iv_ruleTopLevelStatement= ruleTopLevelStatement EOF )
            // InternalNavascript.g:193:2: iv_ruleTopLevelStatement= ruleTopLevelStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopLevelStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTopLevelStatement=ruleTopLevelStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelStatement"


    // $ANTLR start "ruleTopLevelStatement"
    // InternalNavascript.g:199:1: ruleTopLevelStatement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) ;
    public final EObject ruleTopLevelStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_statement_4_1 = null;

        EObject lv_statement_4_2 = null;

        EObject lv_statement_4_3 = null;

        EObject lv_statement_4_4 = null;

        EObject lv_statement_4_5 = null;

        EObject lv_statement_4_6 = null;

        EObject lv_statement_4_7 = null;

        EObject lv_statement_4_8 = null;

        EObject lv_statement_4_9 = null;

        EObject lv_statement_4_10 = null;

        EObject lv_statement_4_11 = null;

        EObject lv_statement_4_12 = null;

        EObject lv_statement_4_13 = null;



        	enterRule();

        try {
            // InternalNavascript.g:205:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:206:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:206:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:207:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:207:3: ()
            // InternalNavascript.g:208:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTopLevelStatementAccess().getTopLevelStatementAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:214:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==59) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalNavascript.g:215:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTopLevelStatementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:219:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:220:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:220:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:221:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_condition_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"condition",
                      							lv_condition_2_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,60,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTopLevelStatementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:243:3: ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            // InternalNavascript.g:244:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            {
            // InternalNavascript.g:244:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            // InternalNavascript.g:245:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            {
            // InternalNavascript.g:245:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            int alt5=13;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt5=1;
                }
                break;
            case RULE_VAR_DEF:
                {
                alt5=2;
                }
                break;
            case RULE_MAP_OLDSKOOL_DEF:
            case 74:
                {
                alt5=3;
                }
                break;
            case 70:
                {
                alt5=4;
                }
                break;
            case RULE_DEFINE_DEF:
                {
                alt5=5;
                }
                break;
            case RULE_PRINT_DEF:
                {
                alt5=6;
                }
                break;
            case RULE_LOG_DEF:
                {
                alt5=7;
                }
                break;
            case RULE_LOOP_DEF:
                {
                alt5=8;
                }
                break;
            case 69:
                {
                alt5=9;
                }
                break;
            case RULE_INCLUDE_DEF:
                {
                alt5=10;
                }
                break;
            case RULE_BREAK_DEF:
                {
                alt5=11;
                }
                break;
            case RULE_SYNCHRONIZED_DEF:
                {
                alt5=12;
                }
                break;
            case 61:
                {
                alt5=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalNavascript.g:246:6: lv_statement_4_1= ruleMessage
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementMessageParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_1=ruleMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_1,
                      							"com.dexels.navajo.Navascript.Message");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:262:6: lv_statement_4_2= ruleVar
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementVarParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_2=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_2,
                      							"com.dexels.navajo.Navascript.Var");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:278:6: lv_statement_4_3= ruleMap
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementMapParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_3=ruleMap();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_3,
                      							"com.dexels.navajo.Navascript.Map");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalNavascript.g:294:6: lv_statement_4_4= ruleAntiMessage
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementAntiMessageParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_4=ruleAntiMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_4,
                      							"com.dexels.navajo.Navascript.AntiMessage");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalNavascript.g:310:6: lv_statement_4_5= ruleDefine
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementDefineParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_5=ruleDefine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_5,
                      							"com.dexels.navajo.Navascript.Define");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalNavascript.g:326:6: lv_statement_4_6= rulePrint
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementPrintParserRuleCall_2_0_5());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_6=rulePrint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_6,
                      							"com.dexels.navajo.Navascript.Print");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalNavascript.g:342:6: lv_statement_4_7= ruleLog
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementLogParserRuleCall_2_0_6());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_7=ruleLog();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_7,
                      							"com.dexels.navajo.Navascript.Log");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 8 :
                    // InternalNavascript.g:358:6: lv_statement_4_8= ruleLoop
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementLoopParserRuleCall_2_0_7());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_8=ruleLoop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_8,
                      							"com.dexels.navajo.Navascript.Loop");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 9 :
                    // InternalNavascript.g:374:6: lv_statement_4_9= ruleMethods
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementMethodsParserRuleCall_2_0_8());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_9=ruleMethods();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_9,
                      							"com.dexels.navajo.Navascript.Methods");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 10 :
                    // InternalNavascript.g:390:6: lv_statement_4_10= ruleInclude
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementIncludeParserRuleCall_2_0_9());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_10=ruleInclude();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_10,
                      							"com.dexels.navajo.Navascript.Include");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 11 :
                    // InternalNavascript.g:406:6: lv_statement_4_11= ruleBreak
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementBreakParserRuleCall_2_0_10());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_11=ruleBreak();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_11,
                      							"com.dexels.navajo.Navascript.Break");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 12 :
                    // InternalNavascript.g:422:6: lv_statement_4_12= ruleSynchronized
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementSynchronizedParserRuleCall_2_0_11());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_12=ruleSynchronized();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_12,
                      							"com.dexels.navajo.Navascript.Synchronized");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 13 :
                    // InternalNavascript.g:438:6: lv_statement_4_13= ruleBlockStatements
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getStatementBlockStatementsParserRuleCall_2_0_12());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_13=ruleBlockStatements();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTopLevelStatementRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_13,
                      							"com.dexels.navajo.Navascript.BlockStatements");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelStatement"


    // $ANTLR start "entryRuleInnerBody"
    // InternalNavascript.g:460:1: entryRuleInnerBody returns [EObject current=null] : iv_ruleInnerBody= ruleInnerBody EOF ;
    public final EObject entryRuleInnerBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInnerBody = null;


        try {
            // InternalNavascript.g:460:50: (iv_ruleInnerBody= ruleInnerBody EOF )
            // InternalNavascript.g:461:2: iv_ruleInnerBody= ruleInnerBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInnerBodyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInnerBody=ruleInnerBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInnerBody; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInnerBody"


    // $ANTLR start "ruleInnerBody"
    // InternalNavascript.g:467:1: ruleInnerBody returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) ;
    public final EObject ruleInnerBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_statement_4_1 = null;

        EObject lv_statement_4_2 = null;

        EObject lv_statement_4_3 = null;

        EObject lv_statement_4_4 = null;

        EObject lv_statement_4_5 = null;

        EObject lv_statement_4_6 = null;

        EObject lv_statement_4_7 = null;

        EObject lv_statement_4_8 = null;

        EObject lv_statement_4_9 = null;

        EObject lv_statement_4_10 = null;

        EObject lv_statement_4_11 = null;

        EObject lv_statement_4_12 = null;

        EObject lv_statement_4_13 = null;

        EObject lv_statement_4_14 = null;

        EObject lv_statement_4_15 = null;



        	enterRule();

        try {
            // InternalNavascript.g:473:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:474:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:474:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:475:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:475:3: ()
            // InternalNavascript.g:476:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInnerBodyAccess().getInnerBodyAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:482:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==59) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalNavascript.g:483:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInnerBodyAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:487:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:488:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:488:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:489:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_condition_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"condition",
                      							lv_condition_2_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,60,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getInnerBodyAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:511:3: ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            // InternalNavascript.g:512:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            {
            // InternalNavascript.g:512:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            // InternalNavascript.g:513:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            {
            // InternalNavascript.g:513:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            int alt7=15;
            switch ( input.LA(1) ) {
            case RULE_PROPERTY_DEF:
                {
                alt7=1;
                }
                break;
            case RULE_OPTION_DEF:
                {
                alt7=2;
                }
                break;
            case RULE_METHOD_IDENTIFIER:
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt7=3;
                }
                break;
            case 71:
                {
                alt7=4;
                }
                break;
            case 70:
                {
                alt7=5;
                }
                break;
            case RULE_INCLUDE_DEF:
                {
                alt7=6;
                }
                break;
            case 69:
                {
                alt7=7;
                }
                break;
            case RULE_VAR_DEF:
                {
                alt7=8;
                }
                break;
            case RULE_PRINT_DEF:
                {
                alt7=9;
                }
                break;
            case RULE_LOG_DEF:
                {
                alt7=10;
                }
                break;
            case RULE_DEFINE_DEF:
                {
                alt7=11;
                }
                break;
            case RULE_LOOP_DEF:
                {
                alt7=12;
                }
                break;
            case RULE_MAP_OLDSKOOL_DEF:
            case 74:
                {
                alt7=13;
                }
                break;
            case RULE_BREAK_DEF:
                {
                alt7=14;
                }
                break;
            case 61:
                {
                alt7=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalNavascript.g:514:6: lv_statement_4_1= ruleProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementPropertyParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_1=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_1,
                      							"com.dexels.navajo.Navascript.Property");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:530:6: lv_statement_4_2= ruleOption
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementOptionParserRuleCall_2_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_2=ruleOption();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_2,
                      							"com.dexels.navajo.Navascript.Option");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:546:6: lv_statement_4_3= ruleMethodOrSetter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementMethodOrSetterParserRuleCall_2_0_2());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_3=ruleMethodOrSetter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_3,
                      							"com.dexels.navajo.Navascript.MethodOrSetter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalNavascript.g:562:6: lv_statement_4_4= ruleMessage
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementMessageParserRuleCall_2_0_3());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_4=ruleMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_4,
                      							"com.dexels.navajo.Navascript.Message");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalNavascript.g:578:6: lv_statement_4_5= ruleAntiMessage
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementAntiMessageParserRuleCall_2_0_4());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_5=ruleAntiMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_5,
                      							"com.dexels.navajo.Navascript.AntiMessage");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalNavascript.g:594:6: lv_statement_4_6= ruleInclude
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementIncludeParserRuleCall_2_0_5());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_6=ruleInclude();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_6,
                      							"com.dexels.navajo.Navascript.Include");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalNavascript.g:610:6: lv_statement_4_7= ruleMethods
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementMethodsParserRuleCall_2_0_6());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_7=ruleMethods();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_7,
                      							"com.dexels.navajo.Navascript.Methods");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 8 :
                    // InternalNavascript.g:626:6: lv_statement_4_8= ruleVar
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementVarParserRuleCall_2_0_7());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_8=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_8,
                      							"com.dexels.navajo.Navascript.Var");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 9 :
                    // InternalNavascript.g:642:6: lv_statement_4_9= rulePrint
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementPrintParserRuleCall_2_0_8());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_9=rulePrint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_9,
                      							"com.dexels.navajo.Navascript.Print");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 10 :
                    // InternalNavascript.g:658:6: lv_statement_4_10= ruleLog
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementLogParserRuleCall_2_0_9());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_10=ruleLog();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_10,
                      							"com.dexels.navajo.Navascript.Log");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 11 :
                    // InternalNavascript.g:674:6: lv_statement_4_11= ruleDefine
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementDefineParserRuleCall_2_0_10());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_11=ruleDefine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_11,
                      							"com.dexels.navajo.Navascript.Define");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 12 :
                    // InternalNavascript.g:690:6: lv_statement_4_12= ruleLoop
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementLoopParserRuleCall_2_0_11());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_12=ruleLoop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_12,
                      							"com.dexels.navajo.Navascript.Loop");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 13 :
                    // InternalNavascript.g:706:6: lv_statement_4_13= ruleMap
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementMapParserRuleCall_2_0_12());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_13=ruleMap();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_13,
                      							"com.dexels.navajo.Navascript.Map");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 14 :
                    // InternalNavascript.g:722:6: lv_statement_4_14= ruleBreak
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementBreakParserRuleCall_2_0_13());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_14=ruleBreak();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_14,
                      							"com.dexels.navajo.Navascript.Break");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 15 :
                    // InternalNavascript.g:738:6: lv_statement_4_15= ruleBlockStatements
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getStatementBlockStatementsParserRuleCall_2_0_14());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_4_15=ruleBlockStatements();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInnerBodyRule());
                      						}
                      						set(
                      							current,
                      							"statement",
                      							lv_statement_4_15,
                      							"com.dexels.navajo.Navascript.BlockStatements");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInnerBody"


    // $ANTLR start "entryRuleBlockStatements"
    // InternalNavascript.g:760:1: entryRuleBlockStatements returns [EObject current=null] : iv_ruleBlockStatements= ruleBlockStatements EOF ;
    public final EObject entryRuleBlockStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatements = null;


        try {
            // InternalNavascript.g:760:56: (iv_ruleBlockStatements= ruleBlockStatements EOF )
            // InternalNavascript.g:761:2: iv_ruleBlockStatements= ruleBlockStatements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockStatementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockStatements=ruleBlockStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockStatements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStatements"


    // $ANTLR start "ruleBlockStatements"
    // InternalNavascript.g:767:1: ruleBlockStatements returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockStatements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:773:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:774:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:774:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:775:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:775:3: ()
            // InternalNavascript.g:776:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockStatementsAccess().getBlockStatementsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockStatementsAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:786:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_BREAK_DEF||LA8_0==RULE_DEFINE_DEF||(LA8_0>=RULE_PRINT_DEF && LA8_0<=RULE_LOG_DEF)||LA8_0==RULE_LOOP_DEF||LA8_0==RULE_INCLUDE_DEF||LA8_0==RULE_MAP_OLDSKOOL_DEF||(LA8_0>=RULE_METHOD_IDENTIFIER && LA8_0<=RULE_MAPPABLE_IDENTIFIER)||(LA8_0>=RULE_VAR_DEF && LA8_0<=RULE_OPTION_DEF)||LA8_0==59||LA8_0==61||(LA8_0>=69 && LA8_0<=71)||LA8_0==74) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalNavascript.g:787:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:787:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:788:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockStatementsAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_2_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockStatementsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getBlockStatementsAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStatements"


    // $ANTLR start "entryRuleSynchronized"
    // InternalNavascript.g:813:1: entryRuleSynchronized returns [EObject current=null] : iv_ruleSynchronized= ruleSynchronized EOF ;
    public final EObject entryRuleSynchronized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronized = null;


        try {
            // InternalNavascript.g:813:53: (iv_ruleSynchronized= ruleSynchronized EOF )
            // InternalNavascript.g:814:2: iv_ruleSynchronized= ruleSynchronized EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSynchronizedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSynchronized=ruleSynchronized();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSynchronized; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynchronized"


    // $ANTLR start "ruleSynchronized"
    // InternalNavascript.g:820:1: ruleSynchronized returns [EObject current=null] : (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) ;
    public final EObject ruleSynchronized() throws RecognitionException {
        EObject current = null;

        Token this_SYNCHRONIZED_DEF_0=null;
        Token this_ARGS_START_1=null;
        Token this_ARGS_END_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_statements_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:826:2: ( (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) )
            // InternalNavascript.g:827:2: (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            {
            // InternalNavascript.g:827:2: (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            // InternalNavascript.g:828:3: this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}'
            {
            this_SYNCHRONIZED_DEF_0=(Token)match(input,RULE_SYNCHRONIZED_DEF,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_SYNCHRONIZED_DEF_0, grammarAccess.getSynchronizedAccess().getSYNCHRONIZED_DEFTerminalRuleCall_0());
              		
            }
            this_ARGS_START_1=(Token)match(input,RULE_ARGS_START,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_1, grammarAccess.getSynchronizedAccess().getARGS_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:836:3: ( (lv_arguments_2_0= ruleSynchronizedArguments ) )
            // InternalNavascript.g:837:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            {
            // InternalNavascript.g:837:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            // InternalNavascript.g:838:5: lv_arguments_2_0= ruleSynchronizedArguments
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSynchronizedAccess().getArgumentsSynchronizedArgumentsParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_arguments_2_0=ruleSynchronizedArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSynchronizedRule());
              					}
              					set(
              						current,
              						"arguments",
              						lv_arguments_2_0,
              						"com.dexels.navajo.Navascript.SynchronizedArguments");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_ARGS_END_3=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_3, grammarAccess.getSynchronizedAccess().getARGS_ENDTerminalRuleCall_3());
              		
            }
            otherlv_4=(Token)match(input,61,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSynchronizedAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:863:3: ( (lv_statements_5_0= ruleTopLevelStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_SYNCHRONIZED_DEF||LA9_0==RULE_BREAK_DEF||LA9_0==RULE_DEFINE_DEF||(LA9_0>=RULE_PRINT_DEF && LA9_0<=RULE_LOG_DEF)||LA9_0==RULE_LOOP_DEF||LA9_0==RULE_INCLUDE_DEF||LA9_0==RULE_MAP_OLDSKOOL_DEF||LA9_0==RULE_VAR_DEF||LA9_0==59||LA9_0==61||(LA9_0>=69 && LA9_0<=71)||LA9_0==74) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalNavascript.g:864:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:864:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:865:5: lv_statements_5_0= ruleTopLevelStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSynchronizedAccess().getStatementsTopLevelStatementParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_statements_5_0=ruleTopLevelStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSynchronizedRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_5_0,
            	      						"com.dexels.navajo.Navascript.TopLevelStatement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_6=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSynchronizedAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynchronized"


    // $ANTLR start "entryRuleSynchronizedArguments"
    // InternalNavascript.g:890:1: entryRuleSynchronizedArguments returns [EObject current=null] : iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF ;
    public final EObject entryRuleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArguments = null;


        try {
            // InternalNavascript.g:890:62: (iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF )
            // InternalNavascript.g:891:2: iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSynchronizedArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSynchronizedArguments=ruleSynchronizedArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSynchronizedArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynchronizedArguments"


    // $ANTLR start "ruleSynchronizedArguments"
    // InternalNavascript.g:897:1: ruleSynchronizedArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) ;
    public final EObject ruleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:903:2: ( ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) )
            // InternalNavascript.g:904:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            {
            // InternalNavascript.g:904:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            // InternalNavascript.g:905:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            {
            // InternalNavascript.g:905:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) )
            // InternalNavascript.g:906:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            {
            // InternalNavascript.g:906:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            // InternalNavascript.g:907:5: lv_arguments_0_0= ruleSynchronizedArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSynchronizedArgumentsAccess().getArgumentsSynchronizedArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_arguments_0_0=ruleSynchronizedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSynchronizedArgumentsRule());
              					}
              					add(
              						current,
              						"arguments",
              						lv_arguments_0_0,
              						"com.dexels.navajo.Navascript.SynchronizedArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:924:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==63) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalNavascript.g:925:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,63,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSynchronizedArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:929:4: ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    // InternalNavascript.g:930:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    {
            	    // InternalNavascript.g:930:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    // InternalNavascript.g:931:6: lv_arguments_2_0= ruleSynchronizedArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSynchronizedArgumentsAccess().getArgumentsSynchronizedArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_arguments_2_0=ruleSynchronizedArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSynchronizedArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arguments",
            	      							lv_arguments_2_0,
            	      							"com.dexels.navajo.Navascript.SynchronizedArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynchronizedArguments"


    // $ANTLR start "entryRuleSynchronizedArgument"
    // InternalNavascript.g:953:1: entryRuleSynchronizedArgument returns [EObject current=null] : iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF ;
    public final EObject entryRuleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArgument = null;


        try {
            // InternalNavascript.g:953:61: (iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF )
            // InternalNavascript.g:954:2: iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSynchronizedArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSynchronizedArgument=ruleSynchronizedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSynchronizedArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynchronizedArgument"


    // $ANTLR start "ruleSynchronizedArgument"
    // InternalNavascript.g:960:1: ruleSynchronizedArgument returns [EObject current=null] : ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) ;
    public final EObject ruleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject this_SKey_2 = null;

        EObject this_STimeout_3 = null;

        EObject this_SBreakOnNoLock_4 = null;



        	enterRule();

        try {
            // InternalNavascript.g:966:2: ( ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) )
            // InternalNavascript.g:967:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            {
            // InternalNavascript.g:967:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_CONTEXT_DEF:
                {
                alt11=1;
                }
                break;
            case RULE_KEY_DEF:
                {
                alt11=2;
                }
                break;
            case RULE_TIMEOUT_DEF:
                {
                alt11=3;
                }
                break;
            case RULE_BREAKONNOLOCK_DEF:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalNavascript.g:968:3: ( () ruleSContext )
                    {
                    // InternalNavascript.g:968:3: ( () ruleSContext )
                    // InternalNavascript.g:969:4: () ruleSContext
                    {
                    // InternalNavascript.g:969:4: ()
                    // InternalNavascript.g:970:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSynchronizedArgumentAccess().getSynchronizedArgumentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getSynchronizedArgumentAccess().getSContextParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleSContext();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:985:3: this_SKey_2= ruleSKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSynchronizedArgumentAccess().getSKeyParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SKey_2=ruleSKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SKey_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:994:3: this_STimeout_3= ruleSTimeout
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSynchronizedArgumentAccess().getSTimeoutParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_STimeout_3=ruleSTimeout();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_STimeout_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalNavascript.g:1003:3: this_SBreakOnNoLock_4= ruleSBreakOnNoLock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSynchronizedArgumentAccess().getSBreakOnNoLockParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SBreakOnNoLock_4=ruleSBreakOnNoLock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SBreakOnNoLock_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynchronizedArgument"


    // $ANTLR start "entryRuleSContext"
    // InternalNavascript.g:1015:1: entryRuleSContext returns [String current=null] : iv_ruleSContext= ruleSContext EOF ;
    public final String entryRuleSContext() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSContext = null;


        try {
            // InternalNavascript.g:1015:48: (iv_ruleSContext= ruleSContext EOF )
            // InternalNavascript.g:1016:2: iv_ruleSContext= ruleSContext EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSContextRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSContext=ruleSContext();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSContext.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSContext"


    // $ANTLR start "ruleSContext"
    // InternalNavascript.g:1022:1: ruleSContext returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF (kw= '=' | kw= ':' ) this_SContextType_3= ruleSContextType ) ;
    public final AntlrDatatypeRuleToken ruleSContext() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CONTEXT_DEF_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_SContextType_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1028:2: ( (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF (kw= '=' | kw= ':' ) this_SContextType_3= ruleSContextType ) )
            // InternalNavascript.g:1029:2: (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF (kw= '=' | kw= ':' ) this_SContextType_3= ruleSContextType )
            {
            // InternalNavascript.g:1029:2: (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF (kw= '=' | kw= ':' ) this_SContextType_3= ruleSContextType )
            // InternalNavascript.g:1030:3: this_CONTEXT_DEF_0= RULE_CONTEXT_DEF (kw= '=' | kw= ':' ) this_SContextType_3= ruleSContextType
            {
            this_CONTEXT_DEF_0=(Token)match(input,RULE_CONTEXT_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_CONTEXT_DEF_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CONTEXT_DEF_0, grammarAccess.getSContextAccess().getCONTEXT_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:1037:3: (kw= '=' | kw= ':' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==64) ) {
                alt12=1;
            }
            else if ( (LA12_0==65) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalNavascript.g:1038:4: kw= '='
                    {
                    kw=(Token)match(input,64,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1044:4: kw= ':'
                    {
                    kw=(Token)match(input,65,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSContextAccess().getSContextTypeParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_SContextType_3=ruleSContextType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_SContextType_3);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSContext"


    // $ANTLR start "entryRuleSKey"
    // InternalNavascript.g:1064:1: entryRuleSKey returns [EObject current=null] : iv_ruleSKey= ruleSKey EOF ;
    public final EObject entryRuleSKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSKey = null;


        try {
            // InternalNavascript.g:1064:45: (iv_ruleSKey= ruleSKey EOF )
            // InternalNavascript.g:1065:2: iv_ruleSKey= ruleSKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSKey=ruleSKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSKey; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSKey"


    // $ANTLR start "ruleSKey"
    // InternalNavascript.g:1071:1: ruleSKey returns [EObject current=null] : (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression ) ;
    public final EObject ruleSKey() throws RecognitionException {
        EObject current = null;

        Token this_KEY_DEF_0=null;
        EObject this_LiteralOrExpression_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1077:2: ( (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression ) )
            // InternalNavascript.g:1078:2: (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:1078:2: (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression )
            // InternalNavascript.g:1079:3: this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression
            {
            this_KEY_DEF_0=(Token)match(input,RULE_KEY_DEF,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_KEY_DEF_0, grammarAccess.getSKeyAccess().getKEY_DEFTerminalRuleCall_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSKeyAccess().getLiteralOrExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_LiteralOrExpression_1=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LiteralOrExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSKey"


    // $ANTLR start "entryRuleSTimeout"
    // InternalNavascript.g:1095:1: entryRuleSTimeout returns [EObject current=null] : iv_ruleSTimeout= ruleSTimeout EOF ;
    public final EObject entryRuleSTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTimeout = null;


        try {
            // InternalNavascript.g:1095:49: (iv_ruleSTimeout= ruleSTimeout EOF )
            // InternalNavascript.g:1096:2: iv_ruleSTimeout= ruleSTimeout EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTimeoutRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSTimeout=ruleSTimeout();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTimeout; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTimeout"


    // $ANTLR start "ruleSTimeout"
    // InternalNavascript.g:1102:1: ruleSTimeout returns [EObject current=null] : (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSTimeout() throws RecognitionException {
        EObject current = null;

        Token this_TIMEOUT_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1108:2: ( (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1109:2: (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1109:2: (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1110:3: this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            this_TIMEOUT_DEF_0=(Token)match(input,RULE_TIMEOUT_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TIMEOUT_DEF_0, grammarAccess.getSTimeoutAccess().getTIMEOUT_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:1114:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==64) ) {
                alt13=1;
            }
            else if ( (LA13_0==65) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalNavascript.g:1115:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSTimeoutAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1120:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSTimeoutAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSTimeoutAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_Expression_3=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTimeout"


    // $ANTLR start "entryRuleSBreakOnNoLock"
    // InternalNavascript.g:1137:1: entryRuleSBreakOnNoLock returns [EObject current=null] : iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF ;
    public final EObject entryRuleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSBreakOnNoLock = null;


        try {
            // InternalNavascript.g:1137:55: (iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF )
            // InternalNavascript.g:1138:2: iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSBreakOnNoLockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSBreakOnNoLock=ruleSBreakOnNoLock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSBreakOnNoLock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSBreakOnNoLock"


    // $ANTLR start "ruleSBreakOnNoLock"
    // InternalNavascript.g:1144:1: ruleSBreakOnNoLock returns [EObject current=null] : (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        Token this_BREAKONNOLOCK_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1150:2: ( (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1151:2: (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1151:2: (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1152:3: this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            this_BREAKONNOLOCK_DEF_0=(Token)match(input,RULE_BREAKONNOLOCK_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BREAKONNOLOCK_DEF_0, grammarAccess.getSBreakOnNoLockAccess().getBREAKONNOLOCK_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:1156:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==64) ) {
                alt14=1;
            }
            else if ( (LA14_0==65) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalNavascript.g:1157:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSBreakOnNoLockAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1162:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSBreakOnNoLockAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSBreakOnNoLockAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_Expression_3=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSBreakOnNoLock"


    // $ANTLR start "entryRuleSContextType"
    // InternalNavascript.g:1179:1: entryRuleSContextType returns [String current=null] : iv_ruleSContextType= ruleSContextType EOF ;
    public final String entryRuleSContextType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSContextType = null;


        try {
            // InternalNavascript.g:1179:52: (iv_ruleSContextType= ruleSContextType EOF )
            // InternalNavascript.g:1180:2: iv_ruleSContextType= ruleSContextType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSContextTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSContextType=ruleSContextType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSContextType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSContextType"


    // $ANTLR start "ruleSContextType"
    // InternalNavascript.g:1186:1: ruleSContextType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'user' | kw= 'service' ) ;
    public final AntlrDatatypeRuleToken ruleSContextType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:1192:2: ( (kw= 'user' | kw= 'service' ) )
            // InternalNavascript.g:1193:2: (kw= 'user' | kw= 'service' )
            {
            // InternalNavascript.g:1193:2: (kw= 'user' | kw= 'service' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==66) ) {
                alt15=1;
            }
            else if ( (LA15_0==67) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalNavascript.g:1194:3: kw= 'user'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSContextTypeAccess().getUserKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1200:3: kw= 'service'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSContextTypeAccess().getServiceKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSContextType"


    // $ANTLR start "entryRuleBreak"
    // InternalNavascript.g:1209:1: entryRuleBreak returns [EObject current=null] : iv_ruleBreak= ruleBreak EOF ;
    public final EObject entryRuleBreak() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreak = null;


        try {
            // InternalNavascript.g:1209:46: (iv_ruleBreak= ruleBreak EOF )
            // InternalNavascript.g:1210:2: iv_ruleBreak= ruleBreak EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreak=ruleBreak();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreak; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreak"


    // $ANTLR start "ruleBreak"
    // InternalNavascript.g:1216:1: ruleBreak returns [EObject current=null] : ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? otherlv_5= ';' ) ;
    public final EObject ruleBreak() throws RecognitionException {
        EObject current = null;

        Token this_BREAK_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token otherlv_5=null;
        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1222:2: ( ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? otherlv_5= ';' ) )
            // InternalNavascript.g:1223:2: ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? otherlv_5= ';' )
            {
            // InternalNavascript.g:1223:2: ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? otherlv_5= ';' )
            // InternalNavascript.g:1224:3: () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? otherlv_5= ';'
            {
            // InternalNavascript.g:1224:3: ()
            // InternalNavascript.g:1225:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBreakAccess().getBreakAction_0(),
              					current);
              			
            }

            }

            this_BREAK_DEF_1=(Token)match(input,RULE_BREAK_DEF,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BREAK_DEF_1, grammarAccess.getBreakAccess().getBREAK_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:1235:3: (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ARGS_START) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalNavascript.g:1236:4: this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getBreakAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    // InternalNavascript.g:1240:4: ( (lv_parameters_3_0= ruleBreakParameters ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=RULE_CODE_DEF && LA16_0<=RULE_ERROR_DEF)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalNavascript.g:1241:5: (lv_parameters_3_0= ruleBreakParameters )
                            {
                            // InternalNavascript.g:1241:5: (lv_parameters_3_0= ruleBreakParameters )
                            // InternalNavascript.g:1242:6: lv_parameters_3_0= ruleBreakParameters
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getBreakAccess().getParametersBreakParametersParserRuleCall_2_1_0());
                              					
                            }
                            pushFollow(FOLLOW_13);
                            lv_parameters_3_0=ruleBreakParameters();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getBreakRule());
                              						}
                              						set(
                              							current,
                              							"parameters",
                              							lv_parameters_3_0,
                              							"com.dexels.navajo.Navascript.BreakParameters");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    this_ARGS_END_4=(Token)match(input,RULE_ARGS_END,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_4, grammarAccess.getBreakAccess().getARGS_ENDTerminalRuleCall_2_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getBreakAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreak"


    // $ANTLR start "entryRuleBreakParameter"
    // InternalNavascript.g:1272:1: entryRuleBreakParameter returns [EObject current=null] : iv_ruleBreakParameter= ruleBreakParameter EOF ;
    public final EObject entryRuleBreakParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameter = null;


        try {
            // InternalNavascript.g:1272:55: (iv_ruleBreakParameter= ruleBreakParameter EOF )
            // InternalNavascript.g:1273:2: iv_ruleBreakParameter= ruleBreakParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakParameter=ruleBreakParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakParameter"


    // $ANTLR start "ruleBreakParameter"
    // InternalNavascript.g:1279:1: ruleBreakParameter returns [EObject current=null] : ( (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) ;
    public final EObject ruleBreakParameter() throws RecognitionException {
        EObject current = null;

        Token this_CODE_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_DESCRIPTION_DEF_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_ERROR_DEF_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_code_3_0 = null;

        EObject lv_description_7_0 = null;

        EObject this_LiteralOrExpression_11 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1285:2: ( ( (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:1286:2: ( (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:1286:2: ( (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_CODE_DEF:
                {
                alt21=1;
                }
                break;
            case RULE_DESCRIPTION_DEF:
                {
                alt21=2;
                }
                break;
            case RULE_ERROR_DEF:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalNavascript.g:1287:3: (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1287:3: (this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1288:4: this_CODE_DEF_0= RULE_CODE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    {
                    this_CODE_DEF_0=(Token)match(input,RULE_CODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_CODE_DEF_0, grammarAccess.getBreakParameterAccess().getCODE_DEFTerminalRuleCall_0_0());
                      			
                    }
                    // InternalNavascript.g:1292:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==64) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==65) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalNavascript.g:1293:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1298:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBreakParameterAccess().getColonKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1303:4: ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1304:5: (lv_code_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1304:5: (lv_code_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1305:6: lv_code_3_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakParameterAccess().getCodeLiteralOrExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_code_3_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakParameterRule());
                      						}
                      						set(
                      							current,
                      							"code",
                      							lv_code_3_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1324:3: (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1324:3: (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1325:4: this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    {
                    this_DESCRIPTION_DEF_4=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DESCRIPTION_DEF_4, grammarAccess.getBreakParameterAccess().getDESCRIPTION_DEFTerminalRuleCall_1_0());
                      			
                    }
                    // InternalNavascript.g:1329:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==64) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==65) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalNavascript.g:1330:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1335:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getBreakParameterAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1340:4: ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1341:5: (lv_description_7_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1341:5: (lv_description_7_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1342:6: lv_description_7_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakParameterAccess().getDescriptionLiteralOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_description_7_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakParameterRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_7_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:1361:3: (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1361:3: (this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    // InternalNavascript.g:1362:4: this_ERROR_DEF_8= RULE_ERROR_DEF (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression
                    {
                    this_ERROR_DEF_8=(Token)match(input,RULE_ERROR_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ERROR_DEF_8, grammarAccess.getBreakParameterAccess().getERROR_DEFTerminalRuleCall_2_0());
                      			
                    }
                    // InternalNavascript.g:1366:4: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==64) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==65) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalNavascript.g:1367:5: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_2_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1372:5: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_10, grammarAccess.getBreakParameterAccess().getColonKeyword_2_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBreakParameterAccess().getLiteralOrExpressionParserRuleCall_2_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralOrExpression_11=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LiteralOrExpression_11;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakParameter"


    // $ANTLR start "entryRuleBreakParameters"
    // InternalNavascript.g:1390:1: entryRuleBreakParameters returns [EObject current=null] : iv_ruleBreakParameters= ruleBreakParameters EOF ;
    public final EObject entryRuleBreakParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameters = null;


        try {
            // InternalNavascript.g:1390:56: (iv_ruleBreakParameters= ruleBreakParameters EOF )
            // InternalNavascript.g:1391:2: iv_ruleBreakParameters= ruleBreakParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakParametersRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakParameters=ruleBreakParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakParameters; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakParameters"


    // $ANTLR start "ruleBreakParameters"
    // InternalNavascript.g:1397:1: ruleBreakParameters returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) ;
    public final EObject ruleBreakParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1403:2: ( ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) )
            // InternalNavascript.g:1404:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            {
            // InternalNavascript.g:1404:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            // InternalNavascript.g:1405:3: ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            {
            // InternalNavascript.g:1405:3: ( (lv_parameters_0_0= ruleBreakParameter ) )
            // InternalNavascript.g:1406:4: (lv_parameters_0_0= ruleBreakParameter )
            {
            // InternalNavascript.g:1406:4: (lv_parameters_0_0= ruleBreakParameter )
            // InternalNavascript.g:1407:5: lv_parameters_0_0= ruleBreakParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBreakParametersAccess().getParametersBreakParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_parameters_0_0=ruleBreakParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBreakParametersRule());
              					}
              					add(
              						current,
              						"parameters",
              						lv_parameters_0_0,
              						"com.dexels.navajo.Navascript.BreakParameter");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:1424:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==63) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalNavascript.g:1425:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,63,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBreakParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:1429:4: ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    // InternalNavascript.g:1430:5: (lv_parameters_2_0= ruleBreakParameter )
            	    {
            	    // InternalNavascript.g:1430:5: (lv_parameters_2_0= ruleBreakParameter )
            	    // InternalNavascript.g:1431:6: lv_parameters_2_0= ruleBreakParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBreakParametersAccess().getParametersBreakParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_parameters_2_0=ruleBreakParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBreakParametersRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameters",
            	      							lv_parameters_2_0,
            	      							"com.dexels.navajo.Navascript.BreakParameter");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakParameters"


    // $ANTLR start "entryRuleValidations"
    // InternalNavascript.g:1453:1: entryRuleValidations returns [EObject current=null] : iv_ruleValidations= ruleValidations EOF ;
    public final EObject entryRuleValidations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidations = null;


        try {
            // InternalNavascript.g:1453:52: (iv_ruleValidations= ruleValidations EOF )
            // InternalNavascript.g:1454:2: iv_ruleValidations= ruleValidations EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidationsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidations=ruleValidations();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidations; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidations"


    // $ANTLR start "ruleValidations"
    // InternalNavascript.g:1460:1: ruleValidations returns [EObject current=null] : ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) ;
    public final EObject ruleValidations() throws RecognitionException {
        EObject current = null;

        Token this_VALIDATIONS_DEF_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_checks_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1466:2: ( ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:1467:2: ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:1467:2: ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            // InternalNavascript.g:1468:3: () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:1468:3: ()
            // InternalNavascript.g:1469:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValidationsAccess().getValidationsAction_0(),
              					current);
              			
            }

            }

            this_VALIDATIONS_DEF_1=(Token)match(input,RULE_VALIDATIONS_DEF,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_VALIDATIONS_DEF_1, grammarAccess.getValidationsAccess().getVALIDATIONS_DEFTerminalRuleCall_1());
              		
            }
            otherlv_2=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getValidationsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:1483:3: ( (lv_checks_3_0= ruleCheck ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_CHECK_DEF||LA23_0==59) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalNavascript.g:1484:4: (lv_checks_3_0= ruleCheck )
            	    {
            	    // InternalNavascript.g:1484:4: (lv_checks_3_0= ruleCheck )
            	    // InternalNavascript.g:1485:5: lv_checks_3_0= ruleCheck
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getValidationsAccess().getChecksCheckParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_checks_3_0=ruleCheck();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getValidationsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"checks",
            	      						lv_checks_3_0,
            	      						"com.dexels.navajo.Navascript.Check");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_4=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getValidationsAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidations"


    // $ANTLR start "entryRuleDefine"
    // InternalNavascript.g:1510:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // InternalNavascript.g:1510:47: (iv_ruleDefine= ruleDefine EOF )
            // InternalNavascript.g:1511:2: iv_ruleDefine= ruleDefine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefine=ruleDefine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefine"


    // $ANTLR start "ruleDefine"
    // InternalNavascript.g:1517:1: ruleDefine returns [EObject current=null] : ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleDefine() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_DEF_1=null;
        Token lv_defineKey_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1523:2: ( ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) )
            // InternalNavascript.g:1524:2: ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            {
            // InternalNavascript.g:1524:2: ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            // InternalNavascript.g:1525:3: () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';'
            {
            // InternalNavascript.g:1525:3: ()
            // InternalNavascript.g:1526:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDefineAccess().getDefineAction_0(),
              					current);
              			
            }

            }

            this_DEFINE_DEF_1=(Token)match(input,RULE_DEFINE_DEF,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_DEFINE_DEF_1, grammarAccess.getDefineAccess().getDEFINE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:1536:3: ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:1537:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:1537:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:1538:5: lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_defineKey_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_defineKey_2_0, grammarAccess.getDefineAccess().getDefineKeyQUOTED_IDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDefineRule());
              					}
              					setWithLastConsumed(
              						current,
              						"defineKey",
              						lv_defineKey_2_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:1554:3: (otherlv_3= '=' | otherlv_4= ':' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==64) ) {
                alt24=1;
            }
            else if ( (LA24_0==65) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalNavascript.g:1555:4: otherlv_3= '='
                    {
                    otherlv_3=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDefineAccess().getEqualsSignKeyword_3_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1560:4: otherlv_4= ':'
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDefineAccess().getColonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1565:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalNavascript.g:1566:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalNavascript.g:1566:4: (lv_expression_5_0= ruleExpression )
            // InternalNavascript.g:1567:5: lv_expression_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefineAccess().getExpressionExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefineRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_5_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getDefineAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefine"


    // $ANTLR start "entryRuleCheck"
    // InternalNavascript.g:1592:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalNavascript.g:1592:46: (iv_ruleCheck= ruleCheck EOF )
            // InternalNavascript.g:1593:2: iv_ruleCheck= ruleCheck EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCheck=ruleCheck();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheck; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheck"


    // $ANTLR start "ruleCheck"
    // InternalNavascript.g:1599:1: ruleCheck returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token this_CHECK_DEF_4=null;
        Token this_ARGS_START_5=null;
        Token otherlv_7=null;
        Token this_ARGS_END_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_condition_2_0 = null;

        EObject lv_checkAttributes_6_0 = null;

        EObject lv_checkAttributes_8_0 = null;

        EObject lv_expression_12_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1605:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) )
            // InternalNavascript.g:1606:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            {
            // InternalNavascript.g:1606:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            // InternalNavascript.g:1607:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';'
            {
            // InternalNavascript.g:1607:3: ()
            // InternalNavascript.g:1608:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCheckAccess().getCheckAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:1614:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==59) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalNavascript.g:1615:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCheckAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1619:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:1620:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1620:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:1621:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_condition_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCheckRule());
                      						}
                      						set(
                      							current,
                      							"condition",
                      							lv_condition_2_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,60,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCheckAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            this_CHECK_DEF_4=(Token)match(input,RULE_CHECK_DEF,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CHECK_DEF_4, grammarAccess.getCheckAccess().getCHECK_DEFTerminalRuleCall_2());
              		
            }
            this_ARGS_START_5=(Token)match(input,RULE_ARGS_START,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_5, grammarAccess.getCheckAccess().getARGS_STARTTerminalRuleCall_3());
              		
            }
            // InternalNavascript.g:1651:3: ( (lv_checkAttributes_6_0= ruleCheckAttribute ) )
            // InternalNavascript.g:1652:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            {
            // InternalNavascript.g:1652:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            // InternalNavascript.g:1653:5: lv_checkAttributes_6_0= ruleCheckAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckAccess().getCheckAttributesCheckAttributeParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_checkAttributes_6_0=ruleCheckAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCheckRule());
              					}
              					add(
              						current,
              						"checkAttributes",
              						lv_checkAttributes_6_0,
              						"com.dexels.navajo.Navascript.CheckAttribute");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:1670:3: (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==63) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalNavascript.g:1671:4: otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    {
                    otherlv_7=(Token)match(input,63,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCheckAccess().getCommaKeyword_5_0());
                      			
                    }
                    // InternalNavascript.g:1675:4: ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    // InternalNavascript.g:1676:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    {
                    // InternalNavascript.g:1676:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    // InternalNavascript.g:1677:6: lv_checkAttributes_8_0= ruleCheckAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAccess().getCheckAttributesCheckAttributeParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_checkAttributes_8_0=ruleCheckAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCheckRule());
                      						}
                      						add(
                      							current,
                      							"checkAttributes",
                      							lv_checkAttributes_8_0,
                      							"com.dexels.navajo.Navascript.CheckAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_ARGS_END_9=(Token)match(input,RULE_ARGS_END,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_9, grammarAccess.getCheckAccess().getARGS_ENDTerminalRuleCall_6());
              		
            }
            // InternalNavascript.g:1699:3: (otherlv_10= '=' | otherlv_11= ':' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==64) ) {
                alt27=1;
            }
            else if ( (LA27_0==65) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalNavascript.g:1700:4: otherlv_10= '='
                    {
                    otherlv_10=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCheckAccess().getEqualsSignKeyword_7_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1705:4: otherlv_11= ':'
                    {
                    otherlv_11=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCheckAccess().getColonKeyword_7_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1710:3: ( (lv_expression_12_0= ruleExpression ) )
            // InternalNavascript.g:1711:4: (lv_expression_12_0= ruleExpression )
            {
            // InternalNavascript.g:1711:4: (lv_expression_12_0= ruleExpression )
            // InternalNavascript.g:1712:5: lv_expression_12_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckAccess().getExpressionExpressionParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_12_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCheckRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_12_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_13=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getCheckAccess().getSemicolonKeyword_9());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheck"


    // $ANTLR start "entryRuleCheckAttribute"
    // InternalNavascript.g:1737:1: entryRuleCheckAttribute returns [EObject current=null] : iv_ruleCheckAttribute= ruleCheckAttribute EOF ;
    public final EObject entryRuleCheckAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckAttribute = null;


        try {
            // InternalNavascript.g:1737:55: (iv_ruleCheckAttribute= ruleCheckAttribute EOF )
            // InternalNavascript.g:1738:2: iv_ruleCheckAttribute= ruleCheckAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCheckAttribute=ruleCheckAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheckAttribute; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheckAttribute"


    // $ANTLR start "ruleCheckAttribute"
    // InternalNavascript.g:1744:1: ruleCheckAttribute returns [EObject current=null] : ( ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) ;
    public final EObject ruleCheckAttribute() throws RecognitionException {
        EObject current = null;

        Token this_CODE_DEF_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_DESCRIPTION_DEF_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_value_4_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1750:2: ( ( ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) )
            // InternalNavascript.g:1751:2: ( ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            {
            // InternalNavascript.g:1751:2: ( ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_CODE_DEF) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_DESCRIPTION_DEF) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalNavascript.g:1752:3: ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    {
                    // InternalNavascript.g:1752:3: ( () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    // InternalNavascript.g:1753:4: () (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1753:4: ()
                    // InternalNavascript.g:1754:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCheckAttributeAccess().getCheckAttributeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1760:4: (this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1761:5: this_CODE_DEF_1= RULE_CODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    {
                    this_CODE_DEF_1=(Token)match(input,RULE_CODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_CODE_DEF_1, grammarAccess.getCheckAttributeAccess().getCODE_DEFTerminalRuleCall_0_1_0());
                      				
                    }
                    // InternalNavascript.g:1765:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==64) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==65) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalNavascript.g:1766:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_0_1_1_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1771:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getCheckAttributeAccess().getColonKeyword_0_1_1_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1776:5: ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1777:6: (lv_value_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1777:6: (lv_value_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1778:7: lv_value_4_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getCheckAttributeAccess().getValueLiteralOrExpressionParserRuleCall_0_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getCheckAttributeRule());
                      							}
                      							set(
                      								current,
                      								"value",
                      								lv_value_4_0,
                      								"com.dexels.navajo.Navascript.LiteralOrExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1798:3: (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1798:3: (this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1799:4: this_DESCRIPTION_DEF_5= RULE_DESCRIPTION_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    {
                    this_DESCRIPTION_DEF_5=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DESCRIPTION_DEF_5, grammarAccess.getCheckAttributeAccess().getDESCRIPTION_DEFTerminalRuleCall_1_0());
                      			
                    }
                    // InternalNavascript.g:1803:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==64) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==65) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalNavascript.g:1804:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1809:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getCheckAttributeAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1814:4: ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1815:5: (lv_value_8_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1815:5: (lv_value_8_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1816:6: lv_value_8_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAttributeAccess().getValueLiteralOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_8_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCheckAttributeRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_8_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheckAttribute"


    // $ANTLR start "entryRuleLiteralOrExpression"
    // InternalNavascript.g:1838:1: entryRuleLiteralOrExpression returns [EObject current=null] : iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF ;
    public final EObject entryRuleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrExpression = null;


        try {
            // InternalNavascript.g:1838:60: (iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF )
            // InternalNavascript.g:1839:2: iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralOrExpression=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralOrExpression"


    // $ANTLR start "ruleLiteralOrExpression"
    // InternalNavascript.g:1845:1: ruleLiteralOrExpression returns [EObject current=null] : ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_1=null;
        Token lv_literal_1_2=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1851:2: ( ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalNavascript.g:1852:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalNavascript.g:1852:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_QUOTED_IDENTIFIER||LA32_0==RULE_STRING_CONSTANT) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ARGS_START||LA32_0==RULE_IDENTIFIER||(LA32_0>=RULE_MAPPABLE_IDENTIFIER && LA32_0<=RULE_TML_LITERAL)||LA32_0==RULE_INTEGER||(LA32_0>=RULE_STRING_LITERAL && LA32_0<=RULE_EXISTS)||LA32_0==86||(LA32_0>=89 && LA32_0<=90)) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalNavascript.g:1853:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    {
                    // InternalNavascript.g:1853:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    // InternalNavascript.g:1854:4: () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    {
                    // InternalNavascript.g:1854:4: ()
                    // InternalNavascript.g:1855:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralOrExpressionAccess().getLiteralOrExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1861:4: ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    // InternalNavascript.g:1862:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    {
                    // InternalNavascript.g:1862:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    // InternalNavascript.g:1863:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    {
                    // InternalNavascript.g:1863:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_QUOTED_IDENTIFIER) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_STRING_CONSTANT) ) {
                        alt31=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalNavascript.g:1864:7: lv_literal_1_1= RULE_QUOTED_IDENTIFIER
                            {
                            lv_literal_1_1=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_literal_1_1, grammarAccess.getLiteralOrExpressionAccess().getLiteralQUOTED_IDENTIFIERTerminalRuleCall_0_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLiteralOrExpressionRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"literal",
                              								lv_literal_1_1,
                              								"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1879:7: lv_literal_1_2= RULE_STRING_CONSTANT
                            {
                            lv_literal_1_2=(Token)match(input,RULE_STRING_CONSTANT,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_literal_1_2, grammarAccess.getLiteralOrExpressionAccess().getLiteralSTRING_CONSTANTTerminalRuleCall_0_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLiteralOrExpressionRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"literal",
                              								lv_literal_1_2,
                              								"com.dexels.navajo.Navascript.STRING_CONSTANT");
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1898:3: ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // InternalNavascript.g:1898:3: ( (lv_expression_2_0= ruleExpression ) )
                    // InternalNavascript.g:1899:4: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1899:4: (lv_expression_2_0= ruleExpression )
                    // InternalNavascript.g:1900:5: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLiteralOrExpressionAccess().getExpressionExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLiteralOrExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"com.dexels.navajo.Navascript.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralOrExpression"


    // $ANTLR start "entryRulePrint"
    // InternalNavascript.g:1921:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalNavascript.g:1921:46: (iv_rulePrint= rulePrint EOF )
            // InternalNavascript.g:1922:2: iv_rulePrint= rulePrint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrint=rulePrint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalNavascript.g:1928:1: rulePrint returns [EObject current=null] : ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token this_PRINT_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1934:2: ( ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) )
            // InternalNavascript.g:1935:2: ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            {
            // InternalNavascript.g:1935:2: ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            // InternalNavascript.g:1936:3: () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';'
            {
            // InternalNavascript.g:1936:3: ()
            // InternalNavascript.g:1937:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrintAccess().getPrintAction_0(),
              					current);
              			
            }

            }

            this_PRINT_DEF_1=(Token)match(input,RULE_PRINT_DEF,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_PRINT_DEF_1, grammarAccess.getPrintAccess().getPRINT_DEFTerminalRuleCall_1());
              		
            }
            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_2, grammarAccess.getPrintAccess().getARGS_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:1951:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:1952:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:1952:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:1953:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrintAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrintRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_ARGS_END_4=(Token)match(input,RULE_ARGS_END,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_4, grammarAccess.getPrintAccess().getARGS_ENDTerminalRuleCall_4());
              		
            }
            otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPrintAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRuleLog"
    // InternalNavascript.g:1982:1: entryRuleLog returns [EObject current=null] : iv_ruleLog= ruleLog EOF ;
    public final EObject entryRuleLog() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLog = null;


        try {
            // InternalNavascript.g:1982:44: (iv_ruleLog= ruleLog EOF )
            // InternalNavascript.g:1983:2: iv_ruleLog= ruleLog EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLog=ruleLog();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLog; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLog"


    // $ANTLR start "ruleLog"
    // InternalNavascript.g:1989:1: ruleLog returns [EObject current=null] : ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) ;
    public final EObject ruleLog() throws RecognitionException {
        EObject current = null;

        Token this_LOG_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1995:2: ( ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) )
            // InternalNavascript.g:1996:2: ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            {
            // InternalNavascript.g:1996:2: ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            // InternalNavascript.g:1997:3: () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';'
            {
            // InternalNavascript.g:1997:3: ()
            // InternalNavascript.g:1998:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLogAccess().getLogAction_0(),
              					current);
              			
            }

            }

            this_LOG_DEF_1=(Token)match(input,RULE_LOG_DEF,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LOG_DEF_1, grammarAccess.getLogAccess().getLOG_DEFTerminalRuleCall_1());
              		
            }
            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_2, grammarAccess.getLogAccess().getARGS_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:2012:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:2013:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:2013:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:2014:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLogRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_ARGS_END_4=(Token)match(input,RULE_ARGS_END,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_4, grammarAccess.getLogAccess().getARGS_ENDTerminalRuleCall_4());
              		
            }
            otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLogAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLog"


    // $ANTLR start "entryRuleFinally"
    // InternalNavascript.g:2043:1: entryRuleFinally returns [EObject current=null] : iv_ruleFinally= ruleFinally EOF ;
    public final EObject entryRuleFinally() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinally = null;


        try {
            // InternalNavascript.g:2043:48: (iv_ruleFinally= ruleFinally EOF )
            // InternalNavascript.g:2044:2: iv_ruleFinally= ruleFinally EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFinallyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFinally=ruleFinally();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFinally; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinally"


    // $ANTLR start "ruleFinally"
    // InternalNavascript.g:2050:1: ruleFinally returns [EObject current=null] : ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) ;
    public final EObject ruleFinally() throws RecognitionException {
        EObject current = null;

        Token this_FINALLY_DEF_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_finallyStatements_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2056:2: ( ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) )
            // InternalNavascript.g:2057:2: ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            {
            // InternalNavascript.g:2057:2: ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            // InternalNavascript.g:2058:3: () this_FINALLY_DEF_1= RULE_FINALLY_DEF otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}'
            {
            // InternalNavascript.g:2058:3: ()
            // InternalNavascript.g:2059:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFinallyAccess().getFinallyAction_0(),
              					current);
              			
            }

            }

            this_FINALLY_DEF_1=(Token)match(input,RULE_FINALLY_DEF,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_FINALLY_DEF_1, grammarAccess.getFinallyAccess().getFINALLY_DEFTerminalRuleCall_1());
              		
            }
            otherlv_2=(Token)match(input,61,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFinallyAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2073:3: ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:2074:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:2074:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            // InternalNavascript.g:2075:5: lv_finallyStatements_3_0= ruleTopLevelStatements
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFinallyAccess().getFinallyStatementsTopLevelStatementsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_finallyStatements_3_0=ruleTopLevelStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFinallyRule());
              					}
              					set(
              						current,
              						"finallyStatements",
              						lv_finallyStatements_3_0,
              						"com.dexels.navajo.Navascript.TopLevelStatements");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getFinallyAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinally"


    // $ANTLR start "entryRuleMethods"
    // InternalNavascript.g:2100:1: entryRuleMethods returns [EObject current=null] : iv_ruleMethods= ruleMethods EOF ;
    public final EObject entryRuleMethods() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethods = null;


        try {
            // InternalNavascript.g:2100:48: (iv_ruleMethods= ruleMethods EOF )
            // InternalNavascript.g:2101:2: iv_ruleMethods= ruleMethods EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethods=ruleMethods();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethods; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethods"


    // $ANTLR start "ruleMethods"
    // InternalNavascript.g:2107:1: ruleMethods returns [EObject current=null] : ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleMethods() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2113:2: ( ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:2114:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:2114:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // InternalNavascript.g:2115:3: () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:2115:3: ()
            // InternalNavascript.g:2116:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodsAccess().getMethodsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMethodsAccess().getMethodsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,61,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMethodsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2130:3: ( (lv_methods_3_0= ruleMethod ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_QUOTED_IDENTIFIER) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalNavascript.g:2131:4: (lv_methods_3_0= ruleMethod )
            	    {
            	    // InternalNavascript.g:2131:4: (lv_methods_3_0= ruleMethod )
            	    // InternalNavascript.g:2132:5: lv_methods_3_0= ruleMethod
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMethodsAccess().getMethodsMethodParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_methods_3_0=ruleMethod();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMethodsRule());
            	      					}
            	      					add(
            	      						current,
            	      						"methods",
            	      						lv_methods_3_0,
            	      						"com.dexels.navajo.Navascript.Method");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_4=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getMethodsAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethods"


    // $ANTLR start "entryRuleMethod"
    // InternalNavascript.g:2157:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalNavascript.g:2157:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalNavascript.g:2158:2: iv_ruleMethod= ruleMethod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethod=ruleMethod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // InternalNavascript.g:2164:1: ruleMethod returns [EObject current=null] : ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token lv_methodName_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:2170:2: ( ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) )
            // InternalNavascript.g:2171:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            {
            // InternalNavascript.g:2171:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            // InternalNavascript.g:2172:3: () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';'
            {
            // InternalNavascript.g:2172:3: ()
            // InternalNavascript.g:2173:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodAccess().getMethodAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2179:3: ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2180:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2180:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2181:5: lv_methodName_1_0= RULE_QUOTED_IDENTIFIER
            {
            lv_methodName_1_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_methodName_1_0, grammarAccess.getMethodAccess().getMethodNameQUOTED_IDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMethodRule());
              					}
              					setWithLastConsumed(
              						current,
              						"methodName",
              						lv_methodName_1_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleLoop"
    // InternalNavascript.g:2205:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalNavascript.g:2205:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalNavascript.g:2206:2: iv_ruleLoop= ruleLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoop; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalNavascript.g:2212:1: ruleLoop returns [EObject current=null] : ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token this_LOOP_DEF_1=null;
        Token this_ARGS_START_4=null;
        Token this_FILTER_DEF_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token this_ARGS_END_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_mappable_2_0 = null;

        EObject lv_tml_3_0 = null;

        EObject lv_filter_8_0 = null;

        EObject lv_statements_11_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2218:2: ( ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) )
            // InternalNavascript.g:2219:2: ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            {
            // InternalNavascript.g:2219:2: ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            // InternalNavascript.g:2220:3: () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}'
            {
            // InternalNavascript.g:2220:3: ()
            // InternalNavascript.g:2221:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLoopAccess().getLoopAction_0(),
              					current);
              			
            }

            }

            this_LOOP_DEF_1=(Token)match(input,RULE_LOOP_DEF,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LOOP_DEF_1, grammarAccess.getLoopAccess().getLOOP_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:2231:3: ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_TML_LITERAL) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalNavascript.g:2232:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:2232:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:2233:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:2233:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    // InternalNavascript.g:2234:6: lv_mappable_2_0= ruleMappableIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getMappableMappableIdentifierParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_32);
                    lv_mappable_2_0=ruleMappableIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLoopRule());
                      						}
                      						set(
                      							current,
                      							"mappable",
                      							lv_mappable_2_0,
                      							"com.dexels.navajo.Navascript.MappableIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2252:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:2252:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:2253:5: (lv_tml_3_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:2253:5: (lv_tml_3_0= ruleTmlIdentifier )
                    // InternalNavascript.g:2254:6: lv_tml_3_0= ruleTmlIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getTmlTmlIdentifierParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_32);
                    lv_tml_3_0=ruleTmlIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLoopRule());
                      						}
                      						set(
                      							current,
                      							"tml",
                      							lv_tml_3_0,
                      							"com.dexels.navajo.Navascript.TmlIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalNavascript.g:2272:3: (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ARGS_START) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalNavascript.g:2273:4: this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) this_ARGS_END_9= RULE_ARGS_END
                    {
                    this_ARGS_START_4=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_4, grammarAccess.getLoopAccess().getARGS_STARTTerminalRuleCall_3_0());
                      			
                    }
                    this_FILTER_DEF_5=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_5, grammarAccess.getLoopAccess().getFILTER_DEFTerminalRuleCall_3_1());
                      			
                    }
                    // InternalNavascript.g:2281:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==64) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==65) ) {
                        alt35=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalNavascript.g:2282:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getEqualsSignKeyword_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2287:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getColonKeyword_3_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:2292:4: ( (lv_filter_8_0= ruleExpression ) )
                    // InternalNavascript.g:2293:5: (lv_filter_8_0= ruleExpression )
                    {
                    // InternalNavascript.g:2293:5: (lv_filter_8_0= ruleExpression )
                    // InternalNavascript.g:2294:6: lv_filter_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getFilterExpressionParserRuleCall_3_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLoopRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_8_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_9=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_9, grammarAccess.getLoopAccess().getARGS_ENDTerminalRuleCall_3_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:2320:3: ( (lv_statements_11_0= ruleInnerBody ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_BREAK_DEF||LA37_0==RULE_DEFINE_DEF||(LA37_0>=RULE_PRINT_DEF && LA37_0<=RULE_LOG_DEF)||LA37_0==RULE_LOOP_DEF||LA37_0==RULE_INCLUDE_DEF||LA37_0==RULE_MAP_OLDSKOOL_DEF||(LA37_0>=RULE_METHOD_IDENTIFIER && LA37_0<=RULE_MAPPABLE_IDENTIFIER)||(LA37_0>=RULE_VAR_DEF && LA37_0<=RULE_OPTION_DEF)||LA37_0==59||LA37_0==61||(LA37_0>=69 && LA37_0<=71)||LA37_0==74) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalNavascript.g:2321:4: (lv_statements_11_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2321:4: (lv_statements_11_0= ruleInnerBody )
            	    // InternalNavascript.g:2322:5: lv_statements_11_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLoopAccess().getStatementsInnerBodyParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_11_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getLoopRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_11_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_12=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleInclude"
    // InternalNavascript.g:2347:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalNavascript.g:2347:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalNavascript.g:2348:2: iv_ruleInclude= ruleInclude EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclude; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclude"


    // $ANTLR start "ruleInclude"
    // InternalNavascript.g:2354:1: ruleInclude returns [EObject current=null] : ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_DEF_1=null;
        Token lv_scriptName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2360:2: ( ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2361:2: ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2361:2: ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2362:3: () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2362:3: ()
            // InternalNavascript.g:2363:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIncludeAccess().getIncludeAction_0(),
              					current);
              			
            }

            }

            this_INCLUDE_DEF_1=(Token)match(input,RULE_INCLUDE_DEF,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INCLUDE_DEF_1, grammarAccess.getIncludeAccess().getINCLUDE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:2373:3: ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2374:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2374:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2375:5: lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_scriptName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_scriptName_2_0, grammarAccess.getIncludeAccess().getScriptNameQUOTED_IDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIncludeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"scriptName",
              						lv_scriptName_2_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIncludeAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclude"


    // $ANTLR start "entryRuleAntiMessage"
    // InternalNavascript.g:2399:1: entryRuleAntiMessage returns [EObject current=null] : iv_ruleAntiMessage= ruleAntiMessage EOF ;
    public final EObject entryRuleAntiMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntiMessage = null;


        try {
            // InternalNavascript.g:2399:52: (iv_ruleAntiMessage= ruleAntiMessage EOF )
            // InternalNavascript.g:2400:2: iv_ruleAntiMessage= ruleAntiMessage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAntiMessageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAntiMessage=ruleAntiMessage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAntiMessage; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAntiMessage"


    // $ANTLR start "ruleAntiMessage"
    // InternalNavascript.g:2406:1: ruleAntiMessage returns [EObject current=null] : ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleAntiMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_messageName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2412:2: ( ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2413:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2413:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2414:3: () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2414:3: ()
            // InternalNavascript.g:2415:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAntiMessageAccess().getAntiMessageAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAntiMessageAccess().getAntimessageKeyword_1());
              		
            }
            // InternalNavascript.g:2425:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2426:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2426:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2427:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_messageName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_messageName_2_0, grammarAccess.getAntiMessageAccess().getMessageNameQUOTED_IDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAntiMessageRule());
              					}
              					setWithLastConsumed(
              						current,
              						"messageName",
              						lv_messageName_2_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAntiMessageAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAntiMessage"


    // $ANTLR start "entryRuleMessage"
    // InternalNavascript.g:2451:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalNavascript.g:2451:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalNavascript.g:2452:2: iv_ruleMessage= ruleMessage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessage; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalNavascript.g:2458:1: ruleMessage returns [EObject current=null] : ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) ) ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_messageName_2_0=null;
        Token this_ARGS_START_3=null;
        Token this_ARGS_END_5=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_statements_7_0 = null;

        EObject lv_arrayField_8_0 = null;

        EObject lv_arrayMessage_9_0 = null;

        EObject lv_messageArray_13_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2464:2: ( ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) ) ) )
            // InternalNavascript.g:2465:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) ) )
            {
            // InternalNavascript.g:2465:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) ) )
            // InternalNavascript.g:2466:3: () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) )
            {
            // InternalNavascript.g:2466:3: ()
            // InternalNavascript.g:2467:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageAccess().getMessageAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,71,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
              		
            }
            // InternalNavascript.g:2477:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2478:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2478:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2479:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_messageName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_messageName_2_0, grammarAccess.getMessageAccess().getMessageNameQUOTED_IDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMessageRule());
              					}
              					setWithLastConsumed(
              						current,
              						"messageName",
              						lv_messageName_2_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:2495:3: (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ARGS_START) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalNavascript.g:2496:4: this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END
                    {
                    this_ARGS_START_3=(Token)match(input,RULE_ARGS_START,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_3, grammarAccess.getMessageAccess().getARGS_STARTTerminalRuleCall_3_0());
                      			
                    }
                    // InternalNavascript.g:2500:4: ( (lv_arguments_4_0= ruleMessageArguments ) )
                    // InternalNavascript.g:2501:5: (lv_arguments_4_0= ruleMessageArguments )
                    {
                    // InternalNavascript.g:2501:5: (lv_arguments_4_0= ruleMessageArguments )
                    // InternalNavascript.g:2502:6: lv_arguments_4_0= ruleMessageArguments
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMessageAccess().getArgumentsMessageArgumentsParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_arguments_4_0=ruleMessageArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMessageRule());
                      						}
                      						set(
                      							current,
                      							"arguments",
                      							lv_arguments_4_0,
                      							"com.dexels.navajo.Navascript.MessageArguments");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_5=(Token)match(input,RULE_ARGS_END,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_5, grammarAccess.getMessageAccess().getARGS_ENDTerminalRuleCall_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:2524:3: ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt41=1;
                }
                break;
            case 68:
                {
                alt41=2;
                }
                break;
            case 72:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalNavascript.g:2525:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    {
                    // InternalNavascript.g:2525:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    // InternalNavascript.g:2526:5: otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_4_0_0());
                      				
                    }
                    // InternalNavascript.g:2530:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )
                    int alt40=3;
                    switch ( input.LA(1) ) {
                    case RULE_BREAK_DEF:
                    case RULE_DEFINE_DEF:
                    case RULE_PRINT_DEF:
                    case RULE_LOG_DEF:
                    case RULE_LOOP_DEF:
                    case RULE_INCLUDE_DEF:
                    case RULE_MAP_OLDSKOOL_DEF:
                    case RULE_METHOD_IDENTIFIER:
                    case RULE_VAR_DEF:
                    case RULE_PROPERTY_DEF:
                    case RULE_OPTION_DEF:
                    case 59:
                    case 61:
                    case 62:
                    case 69:
                    case 70:
                    case 71:
                    case 74:
                        {
                        alt40=1;
                        }
                        break;
                    case RULE_MAPPABLE_IDENTIFIER:
                        {
                        switch ( input.LA(2) ) {
                        case RULE_MAPPABLE_IDENTIFIER:
                        case 64:
                        case 65:
                            {
                            alt40=1;
                            }
                            break;
                        case RULE_ARGS_START:
                            {
                            int LA40_4 = input.LA(3);

                            if ( (LA40_4==RULE_FILTER_DEF) ) {
                                alt40=2;
                            }
                            else if ( (LA40_4==RULE_IDENTIFIER||(LA40_4>=103 && LA40_4<=105)) ) {
                                alt40=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 40, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 61:
                            {
                            int LA40_5 = input.LA(3);

                            if ( (LA40_5==RULE_BREAK_DEF||LA40_5==RULE_DEFINE_DEF||(LA40_5>=RULE_PRINT_DEF && LA40_5<=RULE_LOG_DEF)||LA40_5==RULE_LOOP_DEF||LA40_5==RULE_INCLUDE_DEF||LA40_5==RULE_MAP_OLDSKOOL_DEF||(LA40_5>=RULE_METHOD_IDENTIFIER && LA40_5<=RULE_MAPPABLE_IDENTIFIER)||(LA40_5>=RULE_VAR_DEF && LA40_5<=RULE_OPTION_DEF)||LA40_5==59||(LA40_5>=61 && LA40_5<=62)||(LA40_5>=69 && LA40_5<=71)||LA40_5==74) ) {
                                alt40=2;
                            }
                            else if ( (LA40_5==RULE_TML_LITERAL) ) {
                                alt40=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 40, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case RULE_TML_LITERAL:
                        {
                        alt40=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // InternalNavascript.g:2531:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            {
                            // InternalNavascript.g:2531:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==RULE_BREAK_DEF||LA39_0==RULE_DEFINE_DEF||(LA39_0>=RULE_PRINT_DEF && LA39_0<=RULE_LOG_DEF)||LA39_0==RULE_LOOP_DEF||LA39_0==RULE_INCLUDE_DEF||LA39_0==RULE_MAP_OLDSKOOL_DEF||(LA39_0>=RULE_METHOD_IDENTIFIER && LA39_0<=RULE_MAPPABLE_IDENTIFIER)||(LA39_0>=RULE_VAR_DEF && LA39_0<=RULE_OPTION_DEF)||LA39_0==59||LA39_0==61||(LA39_0>=69 && LA39_0<=71)||LA39_0==74) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // InternalNavascript.g:2532:7: (lv_statements_7_0= ruleInnerBody )
                            	    {
                            	    // InternalNavascript.g:2532:7: (lv_statements_7_0= ruleInnerBody )
                            	    // InternalNavascript.g:2533:8: lv_statements_7_0= ruleInnerBody
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getMessageAccess().getStatementsInnerBodyParserRuleCall_4_0_1_0_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_10);
                            	    lv_statements_7_0=ruleInnerBody();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getMessageRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"statements",
                            	      									lv_statements_7_0,
                            	      									"com.dexels.navajo.Navascript.InnerBody");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop39;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2551:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            {
                            // InternalNavascript.g:2551:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            // InternalNavascript.g:2552:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            {
                            // InternalNavascript.g:2552:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            // InternalNavascript.g:2553:8: lv_arrayField_8_0= ruleMappedArrayField
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMessageAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_0_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_29);
                            lv_arrayField_8_0=ruleMappedArrayField();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMessageRule());
                              								}
                              								set(
                              									current,
                              									"arrayField",
                              									lv_arrayField_8_0,
                              									"com.dexels.navajo.Navascript.MappedArrayField");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalNavascript.g:2571:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            {
                            // InternalNavascript.g:2571:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            // InternalNavascript.g:2572:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            {
                            // InternalNavascript.g:2572:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            // InternalNavascript.g:2573:8: lv_arrayMessage_9_0= ruleMappedArrayMessage
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMessageAccess().getArrayMessageMappedArrayMessageParserRuleCall_4_0_1_2_0());
                              							
                            }
                            pushFollow(FOLLOW_29);
                            lv_arrayMessage_9_0=ruleMappedArrayMessage();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMessageRule());
                              								}
                              								set(
                              									current,
                              									"arrayMessage",
                              									lv_arrayMessage_9_0,
                              									"com.dexels.navajo.Navascript.MappedArrayMessage");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2597:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getMessageAccess().getSemicolonKeyword_4_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:2602:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' )
                    {
                    // InternalNavascript.g:2602:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']' )
                    // InternalNavascript.g:2603:5: otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) ) otherlv_14= ']'
                    {
                    otherlv_12=(Token)match(input,72,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_12, grammarAccess.getMessageAccess().getLeftSquareBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:2607:5: ( (lv_messageArray_13_0= ruleMessageArray ) )
                    // InternalNavascript.g:2608:6: (lv_messageArray_13_0= ruleMessageArray )
                    {
                    // InternalNavascript.g:2608:6: (lv_messageArray_13_0= ruleMessageArray )
                    // InternalNavascript.g:2609:7: lv_messageArray_13_0= ruleMessageArray
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getMessageAccess().getMessageArrayMessageArrayParserRuleCall_4_2_1_0());
                      						
                    }
                    pushFollow(FOLLOW_38);
                    lv_messageArray_13_0=ruleMessageArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getMessageRule());
                      							}
                      							set(
                      								current,
                      								"messageArray",
                      								lv_messageArray_13_0,
                      								"com.dexels.navajo.Navascript.MessageArray");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getMessageAccess().getRightSquareBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRuleMessageArray"
    // InternalNavascript.g:2636:1: entryRuleMessageArray returns [EObject current=null] : iv_ruleMessageArray= ruleMessageArray EOF ;
    public final EObject entryRuleMessageArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArray = null;


        try {
            // InternalNavascript.g:2636:53: (iv_ruleMessageArray= ruleMessageArray EOF )
            // InternalNavascript.g:2637:2: iv_ruleMessageArray= ruleMessageArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageArray=ruleMessageArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageArray"


    // $ANTLR start "ruleMessageArray"
    // InternalNavascript.g:2643:1: ruleMessageArray returns [EObject current=null] : ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) ;
    public final EObject ruleMessageArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayMessageElements_0_0 = null;

        EObject lv_arrayMessageElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2649:2: ( ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) )
            // InternalNavascript.g:2650:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            {
            // InternalNavascript.g:2650:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            // InternalNavascript.g:2651:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            {
            // InternalNavascript.g:2651:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) )
            // InternalNavascript.g:2652:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            {
            // InternalNavascript.g:2652:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            // InternalNavascript.g:2653:5: lv_arrayMessageElements_0_0= ruleMessageArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMessageArrayAccess().getArrayMessageElementsMessageArrayElementParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_arrayMessageElements_0_0=ruleMessageArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMessageArrayRule());
              					}
              					add(
              						current,
              						"arrayMessageElements",
              						lv_arrayMessageElements_0_0,
              						"com.dexels.navajo.Navascript.MessageArrayElement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:2670:3: (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==63) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalNavascript.g:2671:4: otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,63,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2675:4: ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    // InternalNavascript.g:2676:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    {
            	    // InternalNavascript.g:2676:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    // InternalNavascript.g:2677:6: lv_arrayMessageElements_2_0= ruleMessageArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMessageArrayAccess().getArrayMessageElementsMessageArrayElementParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_arrayMessageElements_2_0=ruleMessageArrayElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMessageArrayRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arrayMessageElements",
            	      							lv_arrayMessageElements_2_0,
            	      							"com.dexels.navajo.Navascript.MessageArrayElement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageArray"


    // $ANTLR start "entryRuleMessageArrayElement"
    // InternalNavascript.g:2699:1: entryRuleMessageArrayElement returns [EObject current=null] : iv_ruleMessageArrayElement= ruleMessageArrayElement EOF ;
    public final EObject entryRuleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArrayElement = null;


        try {
            // InternalNavascript.g:2699:60: (iv_ruleMessageArrayElement= ruleMessageArrayElement EOF )
            // InternalNavascript.g:2700:2: iv_ruleMessageArrayElement= ruleMessageArrayElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageArrayElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageArrayElement=ruleMessageArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageArrayElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageArrayElement"


    // $ANTLR start "ruleMessageArrayElement"
    // InternalNavascript.g:2706:1: ruleMessageArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2712:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:2713:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:2713:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:2714:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:2714:3: ()
            // InternalNavascript.g:2715:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageArrayElementAccess().getMessageArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:2725:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_BREAK_DEF||LA43_0==RULE_DEFINE_DEF||(LA43_0>=RULE_PRINT_DEF && LA43_0<=RULE_LOG_DEF)||LA43_0==RULE_LOOP_DEF||LA43_0==RULE_INCLUDE_DEF||LA43_0==RULE_MAP_OLDSKOOL_DEF||(LA43_0>=RULE_METHOD_IDENTIFIER && LA43_0<=RULE_MAPPABLE_IDENTIFIER)||(LA43_0>=RULE_VAR_DEF && LA43_0<=RULE_OPTION_DEF)||LA43_0==59||LA43_0==61||(LA43_0>=69 && LA43_0<=71)||LA43_0==74) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalNavascript.g:2726:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2726:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:2727:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMessageArrayElementAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_2_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMessageArrayElementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getMessageArrayElementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageArrayElement"


    // $ANTLR start "entryRuleMessageArgument"
    // InternalNavascript.g:2752:1: entryRuleMessageArgument returns [EObject current=null] : iv_ruleMessageArgument= ruleMessageArgument EOF ;
    public final EObject entryRuleMessageArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArgument = null;


        try {
            // InternalNavascript.g:2752:56: (iv_ruleMessageArgument= ruleMessageArgument EOF )
            // InternalNavascript.g:2753:2: iv_ruleMessageArgument= ruleMessageArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageArgument=ruleMessageArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageArgument"


    // $ANTLR start "ruleMessageArgument"
    // InternalNavascript.g:2759:1: ruleMessageArgument returns [EObject current=null] : ( (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) ;
    public final EObject ruleMessageArgument() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_MODE_DEF_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject this_MessageType_3 = null;

        EObject this_MessageMode_7 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2765:2: ( ( (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) )
            // InternalNavascript.g:2766:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            {
            // InternalNavascript.g:2766:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_TYPE_DEF) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_MODE_DEF) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalNavascript.g:2767:3: (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    {
                    // InternalNavascript.g:2767:3: (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    // InternalNavascript.g:2768:4: this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType
                    {
                    this_TYPE_DEF_0=(Token)match(input,RULE_TYPE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TYPE_DEF_0, grammarAccess.getMessageArgumentAccess().getTYPE_DEFTerminalRuleCall_0_0());
                      			
                    }
                    // InternalNavascript.g:2772:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==64) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==65) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalNavascript.g:2773:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,64,FOLLOW_39); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2778:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,65,FOLLOW_39); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getMessageArgumentAccess().getColonKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getMessageArgumentAccess().getMessageTypeParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MessageType_3=ruleMessageType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MessageType_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2793:3: (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    {
                    // InternalNavascript.g:2793:3: (this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    // InternalNavascript.g:2794:4: this_MODE_DEF_4= RULE_MODE_DEF (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode
                    {
                    this_MODE_DEF_4=(Token)match(input,RULE_MODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MODE_DEF_4, grammarAccess.getMessageArgumentAccess().getMODE_DEFTerminalRuleCall_1_0());
                      			
                    }
                    // InternalNavascript.g:2798:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==64) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==65) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalNavascript.g:2799:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,64,FOLLOW_40); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2804:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,65,FOLLOW_40); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getMessageArgumentAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getMessageArgumentAccess().getMessageModeParserRuleCall_1_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MessageMode_7=ruleMessageMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MessageMode_7;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageArgument"


    // $ANTLR start "entryRuleMessageArguments"
    // InternalNavascript.g:2822:1: entryRuleMessageArguments returns [EObject current=null] : iv_ruleMessageArguments= ruleMessageArguments EOF ;
    public final EObject entryRuleMessageArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArguments = null;


        try {
            // InternalNavascript.g:2822:57: (iv_ruleMessageArguments= ruleMessageArguments EOF )
            // InternalNavascript.g:2823:2: iv_ruleMessageArguments= ruleMessageArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageArguments=ruleMessageArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageArguments"


    // $ANTLR start "ruleMessageArguments"
    // InternalNavascript.g:2829:1: ruleMessageArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) ;
    public final EObject ruleMessageArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2835:2: ( ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) )
            // InternalNavascript.g:2836:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            {
            // InternalNavascript.g:2836:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            // InternalNavascript.g:2837:3: ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            {
            // InternalNavascript.g:2837:3: ( (lv_arguments_0_0= ruleMessageArgument ) )
            // InternalNavascript.g:2838:4: (lv_arguments_0_0= ruleMessageArgument )
            {
            // InternalNavascript.g:2838:4: (lv_arguments_0_0= ruleMessageArgument )
            // InternalNavascript.g:2839:5: lv_arguments_0_0= ruleMessageArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMessageArgumentsAccess().getArgumentsMessageArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_arguments_0_0=ruleMessageArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMessageArgumentsRule());
              					}
              					add(
              						current,
              						"arguments",
              						lv_arguments_0_0,
              						"com.dexels.navajo.Navascript.MessageArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:2856:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==63) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalNavascript.g:2857:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,63,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2861:4: ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    // InternalNavascript.g:2862:5: (lv_arguments_2_0= ruleMessageArgument )
            	    {
            	    // InternalNavascript.g:2862:5: (lv_arguments_2_0= ruleMessageArgument )
            	    // InternalNavascript.g:2863:6: lv_arguments_2_0= ruleMessageArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMessageArgumentsAccess().getArgumentsMessageArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_arguments_2_0=ruleMessageArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMessageArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arguments",
            	      							lv_arguments_2_0,
            	      							"com.dexels.navajo.Navascript.MessageArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageArguments"


    // $ANTLR start "entryRuleMap"
    // InternalNavascript.g:2885:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalNavascript.g:2885:44: (iv_ruleMap= ruleMap EOF )
            // InternalNavascript.g:2886:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMap"


    // $ANTLR start "ruleMap"
    // InternalNavascript.g:2892:1: ruleMap returns [EObject current=null] : ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_adapterName_2_0=null;
        Token this_ARGS_START_3=null;
        Token this_ARGS_END_5=null;
        Token this_MAP_OLDSKOOL_DEF_6=null;
        Token this_ARGS_START_7=null;
        Token this_OBJECT_OLDSKOOL_DEF_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_objectName_11_0=null;
        Token otherlv_12=null;
        Token this_ARGS_END_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_13_0 = null;

        EObject lv_statements_16_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2898:2: ( ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' ) )
            // InternalNavascript.g:2899:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' )
            {
            // InternalNavascript.g:2899:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' )
            // InternalNavascript.g:2900:3: () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}'
            {
            // InternalNavascript.g:2900:3: ()
            // InternalNavascript.g:2901:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMapAccess().getMapAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2907:3: ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==74) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_MAP_OLDSKOOL_DEF) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalNavascript.g:2908:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? )
                    {
                    // InternalNavascript.g:2908:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? )
                    // InternalNavascript.g:2909:5: otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )?
                    {
                    otherlv_1=(Token)match(input,74,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getMapAccess().getMapKeyword_1_0_0());
                      				
                    }
                    // InternalNavascript.g:2913:5: ( (lv_adapterName_2_0= RULE_IDENTIFIER ) )
                    // InternalNavascript.g:2914:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    {
                    // InternalNavascript.g:2914:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    // InternalNavascript.g:2915:7: lv_adapterName_2_0= RULE_IDENTIFIER
                    {
                    lv_adapterName_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_adapterName_2_0, grammarAccess.getMapAccess().getAdapterNameIDENTIFIERTerminalRuleCall_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMapRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"adapterName",
                      								lv_adapterName_2_0,
                      								"com.dexels.navajo.Navascript.IDENTIFIER");
                      						
                    }

                    }


                    }

                    // InternalNavascript.g:2931:5: (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==RULE_ARGS_START) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalNavascript.g:2932:6: this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END
                            {
                            this_ARGS_START_3=(Token)match(input,RULE_ARGS_START,FOLLOW_42); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_START_3, grammarAccess.getMapAccess().getARGS_STARTTerminalRuleCall_1_0_2_0());
                              					
                            }
                            // InternalNavascript.g:2936:6: ( (lv_arguments_4_0= ruleKeyValueArguments ) )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==RULE_IDENTIFIER||(LA48_0>=103 && LA48_0<=105)) ) {
                                alt48=1;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalNavascript.g:2937:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    {
                                    // InternalNavascript.g:2937:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    // InternalNavascript.g:2938:8: lv_arguments_4_0= ruleKeyValueArguments
                                    {
                                    if ( state.backtracking==0 ) {

                                      								newCompositeNode(grammarAccess.getMapAccess().getArgumentsKeyValueArgumentsParserRuleCall_1_0_2_1_0());
                                      							
                                    }
                                    pushFollow(FOLLOW_13);
                                    lv_arguments_4_0=ruleKeyValueArguments();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElementForParent(grammarAccess.getMapRule());
                                      								}
                                      								set(
                                      									current,
                                      									"arguments",
                                      									lv_arguments_4_0,
                                      									"com.dexels.navajo.Navascript.KeyValueArguments");
                                      								afterParserOrEnumRuleCall();
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            this_ARGS_END_5=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_END_5, grammarAccess.getMapAccess().getARGS_ENDTerminalRuleCall_1_0_2_2());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2962:4: (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END )
                    {
                    // InternalNavascript.g:2962:4: (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END )
                    // InternalNavascript.g:2963:5: this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? this_ARGS_END_14= RULE_ARGS_END
                    {
                    this_MAP_OLDSKOOL_DEF_6=(Token)match(input,RULE_MAP_OLDSKOOL_DEF,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_MAP_OLDSKOOL_DEF_6, grammarAccess.getMapAccess().getMAP_OLDSKOOL_DEFTerminalRuleCall_1_1_0());
                      				
                    }
                    this_ARGS_START_7=(Token)match(input,RULE_ARGS_START,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ARGS_START_7, grammarAccess.getMapAccess().getARGS_STARTTerminalRuleCall_1_1_1());
                      				
                    }
                    this_OBJECT_OLDSKOOL_DEF_8=(Token)match(input,RULE_OBJECT_OLDSKOOL_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_OBJECT_OLDSKOOL_DEF_8, grammarAccess.getMapAccess().getOBJECT_OLDSKOOL_DEFTerminalRuleCall_1_1_2());
                      				
                    }
                    // InternalNavascript.g:2975:5: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==64) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==65) ) {
                        alt50=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalNavascript.g:2976:6: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,64,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_9, grammarAccess.getMapAccess().getEqualsSignKeyword_1_1_3_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2981:6: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,65,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getMapAccess().getColonKeyword_1_1_3_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:2986:5: ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) )
                    // InternalNavascript.g:2987:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    {
                    // InternalNavascript.g:2987:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    // InternalNavascript.g:2988:7: lv_objectName_11_0= RULE_OBJECT_IDENTIFIER
                    {
                    lv_objectName_11_0=(Token)match(input,RULE_OBJECT_IDENTIFIER,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_objectName_11_0, grammarAccess.getMapAccess().getObjectNameOBJECT_IDENTIFIERTerminalRuleCall_1_1_4_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMapRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"objectName",
                      								lv_objectName_11_0,
                      								"com.dexels.navajo.Navascript.OBJECT_IDENTIFIER");
                      						
                    }

                    }


                    }

                    // InternalNavascript.g:3004:5: (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==63) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalNavascript.g:3005:6: otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            {
                            otherlv_12=(Token)match(input,63,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_12, grammarAccess.getMapAccess().getCommaKeyword_1_1_5_0());
                              					
                            }
                            // InternalNavascript.g:3009:6: ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3010:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3010:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3011:8: lv_arguments_13_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMapAccess().getArgumentsKeyValueArgumentsParserRuleCall_1_1_5_1_0());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_arguments_13_0=ruleKeyValueArguments();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMapRule());
                              								}
                              								set(
                              									current,
                              									"arguments",
                              									lv_arguments_13_0,
                              									"com.dexels.navajo.Navascript.KeyValueArguments");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_ARGS_END_14=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ARGS_END_14, grammarAccess.getMapAccess().getARGS_ENDTerminalRuleCall_1_1_6());
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_15, grammarAccess.getMapAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:3039:3: ( (lv_statements_16_0= ruleInnerBody ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_BREAK_DEF||LA53_0==RULE_DEFINE_DEF||(LA53_0>=RULE_PRINT_DEF && LA53_0<=RULE_LOG_DEF)||LA53_0==RULE_LOOP_DEF||LA53_0==RULE_INCLUDE_DEF||LA53_0==RULE_MAP_OLDSKOOL_DEF||(LA53_0>=RULE_METHOD_IDENTIFIER && LA53_0<=RULE_MAPPABLE_IDENTIFIER)||(LA53_0>=RULE_VAR_DEF && LA53_0<=RULE_OPTION_DEF)||LA53_0==59||LA53_0==61||(LA53_0>=69 && LA53_0<=71)||LA53_0==74) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalNavascript.g:3040:4: (lv_statements_16_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3040:4: (lv_statements_16_0= ruleInnerBody )
            	    // InternalNavascript.g:3041:5: lv_statements_16_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMapAccess().getStatementsInnerBodyParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_16_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMapRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_16_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_17=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_17, grammarAccess.getMapAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRuleMethodOrSetter"
    // InternalNavascript.g:3066:1: entryRuleMethodOrSetter returns [EObject current=null] : iv_ruleMethodOrSetter= ruleMethodOrSetter EOF ;
    public final EObject entryRuleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodOrSetter = null;


        try {
            // InternalNavascript.g:3066:55: (iv_ruleMethodOrSetter= ruleMethodOrSetter EOF )
            // InternalNavascript.g:3067:2: iv_ruleMethodOrSetter= ruleMethodOrSetter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodOrSetterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethodOrSetter=ruleMethodOrSetter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethodOrSetter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodOrSetter"


    // $ANTLR start "ruleMethodOrSetter"
    // InternalNavascript.g:3073:1: ruleMethodOrSetter returns [EObject current=null] : (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) ;
    public final EObject ruleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject this_AdapterMethod_0 = null;

        EObject this_SetterField_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3079:2: ( (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) )
            // InternalNavascript.g:3080:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            {
            // InternalNavascript.g:3080:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_METHOD_IDENTIFIER) ) {
                alt54=1;
            }
            else if ( (LA54_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalNavascript.g:3081:3: this_AdapterMethod_0= ruleAdapterMethod
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getMethodOrSetterAccess().getAdapterMethodParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AdapterMethod_0=ruleAdapterMethod();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AdapterMethod_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3090:3: this_SetterField_1= ruleSetterField
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getMethodOrSetterAccess().getSetterFieldParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetterField_1=ruleSetterField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetterField_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodOrSetter"


    // $ANTLR start "entryRuleAdapterMethod"
    // InternalNavascript.g:3102:1: entryRuleAdapterMethod returns [EObject current=null] : iv_ruleAdapterMethod= ruleAdapterMethod EOF ;
    public final EObject entryRuleAdapterMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdapterMethod = null;


        try {
            // InternalNavascript.g:3102:54: (iv_ruleAdapterMethod= ruleAdapterMethod EOF )
            // InternalNavascript.g:3103:2: iv_ruleAdapterMethod= ruleAdapterMethod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdapterMethodRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdapterMethod=ruleAdapterMethod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdapterMethod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdapterMethod"


    // $ANTLR start "ruleAdapterMethod"
    // InternalNavascript.g:3109:1: ruleAdapterMethod returns [EObject current=null] : ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) ;
    public final EObject ruleAdapterMethod() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token otherlv_5=null;
        EObject lv_arguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3115:2: ( ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' ) )
            // InternalNavascript.g:3116:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            {
            // InternalNavascript.g:3116:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';' )
            // InternalNavascript.g:3117:3: () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END otherlv_5= ';'
            {
            // InternalNavascript.g:3117:3: ()
            // InternalNavascript.g:3118:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAdapterMethodAccess().getAdapterMethodAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3124:3: ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) )
            // InternalNavascript.g:3125:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            {
            // InternalNavascript.g:3125:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            // InternalNavascript.g:3126:5: lv_method_1_0= RULE_METHOD_IDENTIFIER
            {
            lv_method_1_0=(Token)match(input,RULE_METHOD_IDENTIFIER,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_method_1_0, grammarAccess.getAdapterMethodAccess().getMethodMETHOD_IDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAdapterMethodRule());
              					}
              					setWithLastConsumed(
              						current,
              						"method",
              						lv_method_1_0,
              						"com.dexels.navajo.Navascript.METHOD_IDENTIFIER");
              				
            }

            }


            }

            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_2, grammarAccess.getAdapterMethodAccess().getARGS_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:3146:3: ( (lv_arguments_3_0= ruleKeyValueArguments ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_IDENTIFIER||(LA55_0>=103 && LA55_0<=105)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalNavascript.g:3147:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    {
                    // InternalNavascript.g:3147:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    // InternalNavascript.g:3148:5: lv_arguments_3_0= ruleKeyValueArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAdapterMethodAccess().getArgumentsKeyValueArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
                    lv_arguments_3_0=ruleKeyValueArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAdapterMethodRule());
                      					}
                      					set(
                      						current,
                      						"arguments",
                      						lv_arguments_3_0,
                      						"com.dexels.navajo.Navascript.KeyValueArguments");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            this_ARGS_END_4=(Token)match(input,RULE_ARGS_END,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_4, grammarAccess.getAdapterMethodAccess().getARGS_ENDTerminalRuleCall_4());
              		
            }
            otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAdapterMethodAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdapterMethod"


    // $ANTLR start "entryRuleSetterField"
    // InternalNavascript.g:3177:1: entryRuleSetterField returns [EObject current=null] : iv_ruleSetterField= ruleSetterField EOF ;
    public final EObject entryRuleSetterField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetterField = null;


        try {
            // InternalNavascript.g:3177:52: (iv_ruleSetterField= ruleSetterField EOF )
            // InternalNavascript.g:3178:2: iv_ruleSetterField= ruleSetterField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetterFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetterField=ruleSetterField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetterField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetterField"


    // $ANTLR start "ruleSetterField"
    // InternalNavascript.g:3184:1: ruleSetterField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) ) ) ;
    public final EObject ruleSetterField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token this_ARGS_START_6=null;
        Token this_ARGS_END_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_expressionList_4_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_mappedArray_10_0 = null;

        EObject lv_mappedField_12_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3190:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) ) ) )
            // InternalNavascript.g:3191:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) ) )
            {
            // InternalNavascript.g:3191:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) ) )
            // InternalNavascript.g:3192:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) )
            {
            // InternalNavascript.g:3192:3: ()
            // InternalNavascript.g:3193:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetterFieldAccess().getSetterFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3199:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3200:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3200:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3201:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_field_1_0, grammarAccess.getSetterFieldAccess().getFieldMAPPABLE_IDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSetterFieldRule());
              					}
              					setWithLastConsumed(
              						current,
              						"field",
              						lv_field_1_0,
              						"com.dexels.navajo.Navascript.MAPPABLE_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:3217:3: ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 64:
            case 65:
                {
                alt58=1;
                }
                break;
            case RULE_ARGS_START:
            case 61:
                {
                alt58=2;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalNavascript.g:3218:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    {
                    // InternalNavascript.g:3218:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    // InternalNavascript.g:3219:5: (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
                    {
                    // InternalNavascript.g:3219:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==64) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==65) ) {
                        alt56=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalNavascript.g:3220:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,64,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getSetterFieldAccess().getEqualsSignKeyword_2_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3225:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,65,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getSetterFieldAccess().getColonKeyword_2_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3230:5: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3231:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3231:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3232:7: lv_expressionList_4_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getExpressionListConditionalExpressionsParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_22);
                    lv_expressionList_4_0=ruleConditionalExpressions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      							}
                      							set(
                      								current,
                      								"expressionList",
                      								lv_expressionList_4_0,
                      								"com.dexels.navajo.Navascript.ConditionalExpressions");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getSetterFieldAccess().getSemicolonKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3255:4: ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    {
                    // InternalNavascript.g:3255:4: ( (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    // InternalNavascript.g:3256:5: (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}'
                    {
                    // InternalNavascript.g:3256:5: (this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==RULE_ARGS_START) ) {
                        alt57=1;
                    }
                    switch (alt57) {
                        case 1 :
                            // InternalNavascript.g:3257:6: this_ARGS_START_6= RULE_ARGS_START ( (lv_arguments_7_0= ruleKeyValueArguments ) ) this_ARGS_END_8= RULE_ARGS_END
                            {
                            this_ARGS_START_6=(Token)match(input,RULE_ARGS_START,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_START_6, grammarAccess.getSetterFieldAccess().getARGS_STARTTerminalRuleCall_2_1_0_0());
                              					
                            }
                            // InternalNavascript.g:3261:6: ( (lv_arguments_7_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3262:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3262:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3263:8: lv_arguments_7_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getSetterFieldAccess().getArgumentsKeyValueArgumentsParserRuleCall_2_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_arguments_7_0=ruleKeyValueArguments();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                              								}
                              								set(
                              									current,
                              									"arguments",
                              									lv_arguments_7_0,
                              									"com.dexels.navajo.Navascript.KeyValueArguments");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            this_ARGS_END_8=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_END_8, grammarAccess.getSetterFieldAccess().getARGS_ENDTerminalRuleCall_2_1_0_2());
                              					
                            }

                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getSetterFieldAccess().getLeftCurlyBracketKeyword_2_1_1());
                      				
                    }
                    // InternalNavascript.g:3289:5: ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3290:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3290:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3291:7: lv_mappedArray_10_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedArrayMappedArrayMessageParserRuleCall_2_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArray_10_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      							}
                      							set(
                      								current,
                      								"mappedArray",
                      								lv_mappedArray_10_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getSetterFieldAccess().getRightCurlyBracketKeyword_2_1_3());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3314:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    {
                    // InternalNavascript.g:3314:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3315:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3315:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:3316:6: lv_mappedField_12_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedFieldMappedArrayFieldParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_mappedField_12_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      						}
                      						set(
                      							current,
                      							"mappedField",
                      							lv_mappedField_12_0,
                      							"com.dexels.navajo.Navascript.MappedArrayField");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetterField"


    // $ANTLR start "entryRuleMappedArrayField"
    // InternalNavascript.g:3338:1: entryRuleMappedArrayField returns [EObject current=null] : iv_ruleMappedArrayField= ruleMappedArrayField EOF ;
    public final EObject entryRuleMappedArrayField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayField = null;


        try {
            // InternalNavascript.g:3338:57: (iv_ruleMappedArrayField= ruleMappedArrayField EOF )
            // InternalNavascript.g:3339:2: iv_ruleMappedArrayField= ruleMappedArrayField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappedArrayFieldRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMappedArrayField=ruleMappedArrayField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappedArrayField; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappedArrayField"


    // $ANTLR start "ruleMappedArrayField"
    // InternalNavascript.g:3345:1: ruleMappedArrayField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
    public final EObject ruleMappedArrayField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_FILTER_DEF_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ARGS_END_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_filter_6_0 = null;

        EObject lv_statements_9_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3351:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3352:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3352:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3353:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3353:3: ()
            // InternalNavascript.g:3354:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayFieldAccess().getMappedArrayFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3360:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3361:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3361:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3362:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_field_1_0, grammarAccess.getMappedArrayFieldAccess().getFieldMAPPABLE_IDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMappedArrayFieldRule());
              					}
              					setWithLastConsumed(
              						current,
              						"field",
              						lv_field_1_0,
              						"com.dexels.navajo.Navascript.MAPPABLE_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:3378:3: (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ARGS_START) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalNavascript.g:3379:4: this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappedArrayFieldAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    this_FILTER_DEF_3=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_3, grammarAccess.getMappedArrayFieldAccess().getFILTER_DEFTerminalRuleCall_2_1());
                      			
                    }
                    // InternalNavascript.g:3387:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==64) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==65) ) {
                        alt59=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalNavascript.g:3388:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayFieldAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3393:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayFieldAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3398:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3399:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3399:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3400:6: lv_filter_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMappedArrayFieldRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_6_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_7=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_7, grammarAccess.getMappedArrayFieldAccess().getARGS_ENDTerminalRuleCall_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayFieldAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3426:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_BREAK_DEF||LA61_0==RULE_DEFINE_DEF||(LA61_0>=RULE_PRINT_DEF && LA61_0<=RULE_LOG_DEF)||LA61_0==RULE_LOOP_DEF||LA61_0==RULE_INCLUDE_DEF||LA61_0==RULE_MAP_OLDSKOOL_DEF||(LA61_0>=RULE_METHOD_IDENTIFIER && LA61_0<=RULE_MAPPABLE_IDENTIFIER)||(LA61_0>=RULE_VAR_DEF && LA61_0<=RULE_OPTION_DEF)||LA61_0==59||LA61_0==61||(LA61_0>=69 && LA61_0<=71)||LA61_0==74) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalNavascript.g:3427:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3427:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3428:5: lv_statements_9_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_9_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMappedArrayFieldRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_9_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_10=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getMappedArrayFieldAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappedArrayField"


    // $ANTLR start "entryRuleMappedArrayMessage"
    // InternalNavascript.g:3453:1: entryRuleMappedArrayMessage returns [EObject current=null] : iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF ;
    public final EObject entryRuleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayMessage = null;


        try {
            // InternalNavascript.g:3453:59: (iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF )
            // InternalNavascript.g:3454:2: iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappedArrayMessageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMappedArrayMessage=ruleMappedArrayMessage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappedArrayMessage; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappedArrayMessage"


    // $ANTLR start "ruleMappedArrayMessage"
    // InternalNavascript.g:3460:1: ruleMappedArrayMessage returns [EObject current=null] : ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
    public final EObject ruleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_FILTER_DEF_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ARGS_END_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_filter_6_0 = null;

        EObject lv_statements_9_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3466:2: ( ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3467:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3467:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3468:3: () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3468:3: ()
            // InternalNavascript.g:3469:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayMessageAccess().getMappedArrayMessageAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3475:3: ( (lv_message_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:3476:4: (lv_message_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:3476:4: (lv_message_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:3477:5: lv_message_1_0= RULE_TML_LITERAL
            {
            lv_message_1_0=(Token)match(input,RULE_TML_LITERAL,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_message_1_0, grammarAccess.getMappedArrayMessageAccess().getMessageTML_LITERALTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMappedArrayMessageRule());
              					}
              					setWithLastConsumed(
              						current,
              						"message",
              						lv_message_1_0,
              						"com.dexels.navajo.Navascript.TML_LITERAL");
              				
            }

            }


            }

            // InternalNavascript.g:3493:3: (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ARGS_START) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalNavascript.g:3494:4: this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) this_ARGS_END_7= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappedArrayMessageAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    this_FILTER_DEF_3=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_3, grammarAccess.getMappedArrayMessageAccess().getFILTER_DEFTerminalRuleCall_2_1());
                      			
                    }
                    // InternalNavascript.g:3502:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==64) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==65) ) {
                        alt62=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalNavascript.g:3503:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,64,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayMessageAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3508:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,65,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayMessageAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3513:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3514:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3514:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3515:6: lv_filter_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMappedArrayMessageRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_6_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_7=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_7, grammarAccess.getMappedArrayMessageAccess().getARGS_ENDTerminalRuleCall_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayMessageAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3541:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_BREAK_DEF||LA64_0==RULE_DEFINE_DEF||(LA64_0>=RULE_PRINT_DEF && LA64_0<=RULE_LOG_DEF)||LA64_0==RULE_LOOP_DEF||LA64_0==RULE_INCLUDE_DEF||LA64_0==RULE_MAP_OLDSKOOL_DEF||(LA64_0>=RULE_METHOD_IDENTIFIER && LA64_0<=RULE_MAPPABLE_IDENTIFIER)||(LA64_0>=RULE_VAR_DEF && LA64_0<=RULE_OPTION_DEF)||LA64_0==59||LA64_0==61||(LA64_0>=69 && LA64_0<=71)||LA64_0==74) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalNavascript.g:3542:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3542:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3543:5: lv_statements_9_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_9_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMappedArrayMessageRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_9_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_10=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getMappedArrayMessageAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappedArrayMessage"


    // $ANTLR start "entryRuleKeyValueArguments"
    // InternalNavascript.g:3568:1: entryRuleKeyValueArguments returns [EObject current=null] : iv_ruleKeyValueArguments= ruleKeyValueArguments EOF ;
    public final EObject entryRuleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArguments = null;


        try {
            // InternalNavascript.g:3568:58: (iv_ruleKeyValueArguments= ruleKeyValueArguments EOF )
            // InternalNavascript.g:3569:2: iv_ruleKeyValueArguments= ruleKeyValueArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyValueArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyValueArguments=ruleKeyValueArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyValueArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValueArguments"


    // $ANTLR start "ruleKeyValueArguments"
    // InternalNavascript.g:3575:1: ruleKeyValueArguments returns [EObject current=null] : ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) ;
    public final EObject ruleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_keyValueArguments_1_0 = null;

        EObject lv_keyValueArguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3581:2: ( ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) )
            // InternalNavascript.g:3582:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            {
            // InternalNavascript.g:3582:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            // InternalNavascript.g:3583:3: () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            {
            // InternalNavascript.g:3583:3: ()
            // InternalNavascript.g:3584:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3590:3: ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) )
            // InternalNavascript.g:3591:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            {
            // InternalNavascript.g:3591:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            // InternalNavascript.g:3592:5: lv_keyValueArguments_1_0= ruleKeyValueArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsKeyValueArgumentParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_keyValueArguments_1_0=ruleKeyValueArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getKeyValueArgumentsRule());
              					}
              					add(
              						current,
              						"keyValueArguments",
              						lv_keyValueArguments_1_0,
              						"com.dexels.navajo.Navascript.KeyValueArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:3609:3: (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==63) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalNavascript.g:3610:4: otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    {
            	    otherlv_2=(Token)match(input,63,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentsAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:3614:4: ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    // InternalNavascript.g:3615:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    {
            	    // InternalNavascript.g:3615:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    // InternalNavascript.g:3616:6: lv_keyValueArguments_3_0= ruleKeyValueArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsKeyValueArgumentParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_keyValueArguments_3_0=ruleKeyValueArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getKeyValueArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"keyValueArguments",
            	      							lv_keyValueArguments_3_0,
            	      							"com.dexels.navajo.Navascript.KeyValueArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValueArguments"


    // $ANTLR start "entryRuleKeyValueArgument"
    // InternalNavascript.g:3638:1: entryRuleKeyValueArgument returns [EObject current=null] : iv_ruleKeyValueArgument= ruleKeyValueArgument EOF ;
    public final EObject entryRuleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArgument = null;


        try {
            // InternalNavascript.g:3638:57: (iv_ruleKeyValueArgument= ruleKeyValueArgument EOF )
            // InternalNavascript.g:3639:2: iv_ruleKeyValueArgument= ruleKeyValueArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyValueArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyValueArgument=ruleKeyValueArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyValueArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValueArgument"


    // $ANTLR start "ruleKeyValueArgument"
    // InternalNavascript.g:3645:1: ruleKeyValueArgument returns [EObject current=null] : ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_key_1_2 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3651:2: ( ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:3652:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:3652:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:3653:3: () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:3653:3: ()
            // InternalNavascript.g:3654:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentAccess().getKeyValueArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3660:3: ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) )
            // InternalNavascript.g:3661:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            {
            // InternalNavascript.g:3661:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            // InternalNavascript.g:3662:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:3662:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_IDENTIFIER) ) {
                alt66=1;
            }
            else if ( ((LA66_0>=103 && LA66_0<=105)) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalNavascript.g:3663:6: lv_key_1_1= RULE_IDENTIFIER
                    {
                    lv_key_1_1=(Token)match(input,RULE_IDENTIFIER,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_key_1_1, grammarAccess.getKeyValueArgumentAccess().getKeyIDENTIFIERTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getKeyValueArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"key",
                      							lv_key_1_1,
                      							"com.dexels.navajo.Navascript.IDENTIFIER");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3678:6: lv_key_1_2= ruleOPTION_TYPE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getKeyValueArgumentAccess().getKeyOPTION_TYPEParserRuleCall_1_0_1());
                      					
                    }
                    pushFollow(FOLLOW_17);
                    lv_key_1_2=ruleOPTION_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getKeyValueArgumentRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_1_2,
                      							"com.dexels.navajo.Navascript.OPTION_TYPE");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalNavascript.g:3696:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==64) ) {
                alt67=1;
            }
            else if ( (LA67_0==65) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalNavascript.g:3697:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3702:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getKeyValueArgumentAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:3707:3: ( (lv_value_4_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:3708:4: (lv_value_4_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:3708:4: (lv_value_4_0= ruleLiteralOrExpression )
            // InternalNavascript.g:3709:5: lv_value_4_0= ruleLiteralOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getKeyValueArgumentAccess().getValueLiteralOrExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getKeyValueArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"com.dexels.navajo.Navascript.LiteralOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValueArgument"


    // $ANTLR start "entryRuleVar"
    // InternalNavascript.g:3730:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalNavascript.g:3730:44: (iv_ruleVar= ruleVar EOF )
            // InternalNavascript.g:3731:2: iv_ruleVar= ruleVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVar=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // InternalNavascript.g:3737:1: ruleVar returns [EObject current=null] : ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token this_VAR_DEF_1=null;
        Token lv_varName_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_expressionList_6_0 = null;

        EObject lv_varArray_9_0 = null;

        EObject lv_varElements_12_0 = null;

        EObject lv_mappedArrayField_15_0 = null;

        EObject lv_mappedArrayMessage_18_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3743:2: ( ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) )
            // InternalNavascript.g:3744:2: ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            {
            // InternalNavascript.g:3744:2: ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            // InternalNavascript.g:3745:3: () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            {
            // InternalNavascript.g:3745:3: ()
            // InternalNavascript.g:3746:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarAccess().getVarAction_0(),
              					current);
              			
            }

            }

            this_VAR_DEF_1=(Token)match(input,RULE_VAR_DEF,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_VAR_DEF_1, grammarAccess.getVarAccess().getVAR_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:3756:3: ( (lv_varName_2_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:3757:4: (lv_varName_2_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:3757:4: (lv_varName_2_0= RULE_IDENTIFIER )
            // InternalNavascript.g:3758:5: lv_varName_2_0= RULE_IDENTIFIER
            {
            lv_varName_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varName_2_0, grammarAccess.getVarAccess().getVarNameIDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVarRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varName",
              						lv_varName_2_0,
              						"com.dexels.navajo.Navascript.IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:3774:3: ( (lv_arguments_3_0= ruleVarArguments ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ARGS_START) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalNavascript.g:3775:4: (lv_arguments_3_0= ruleVarArguments )
                    {
                    // InternalNavascript.g:3775:4: (lv_arguments_3_0= ruleVarArguments )
                    // InternalNavascript.g:3776:5: lv_arguments_3_0= ruleVarArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVarAccess().getArgumentsVarArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_49);
                    lv_arguments_3_0=ruleVarArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVarRule());
                      					}
                      					set(
                      						current,
                      						"arguments",
                      						lv_arguments_3_0,
                      						"com.dexels.navajo.Navascript.VarArguments");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:3793:3: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            int alt72=5;
            switch ( input.LA(1) ) {
            case 64:
            case 65:
                {
                alt72=1;
                }
                break;
            case 72:
                {
                alt72=2;
                }
                break;
            case 61:
                {
                switch ( input.LA(2) ) {
                case RULE_TML_LITERAL:
                    {
                    alt72=5;
                    }
                    break;
                case RULE_VAR_DEF:
                case 59:
                case 62:
                    {
                    alt72=3;
                    }
                    break;
                case RULE_MAPPABLE_IDENTIFIER:
                    {
                    alt72=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalNavascript.g:3794:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    {
                    // InternalNavascript.g:3794:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    // InternalNavascript.g:3795:5: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';'
                    {
                    // InternalNavascript.g:3795:5: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==64) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==65) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalNavascript.g:3796:6: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,64,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getVarAccess().getEqualsSignKeyword_4_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3801:6: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,65,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_5, grammarAccess.getVarAccess().getColonKeyword_4_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3806:5: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3807:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3807:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3808:7: lv_expressionList_6_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_22);
                    lv_expressionList_6_0=ruleConditionalExpressions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"expressionList",
                      								lv_expressionList_6_0,
                      								"com.dexels.navajo.Navascript.ConditionalExpressions");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getVarAccess().getSemicolonKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3831:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    {
                    // InternalNavascript.g:3831:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    // InternalNavascript.g:3832:5: otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,72,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getVarAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:3836:5: ( (lv_varArray_9_0= ruleVarArray ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==61) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalNavascript.g:3837:6: (lv_varArray_9_0= ruleVarArray )
                            {
                            // InternalNavascript.g:3837:6: (lv_varArray_9_0= ruleVarArray )
                            // InternalNavascript.g:3838:7: lv_varArray_9_0= ruleVarArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVarAccess().getVarArrayVarArrayParserRuleCall_4_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_38);
                            lv_varArray_9_0=ruleVarArray();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getVarRule());
                              							}
                              							set(
                              								current,
                              								"varArray",
                              								lv_varArray_9_0,
                              								"com.dexels.navajo.Navascript.VarArray");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getVarAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3861:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    {
                    // InternalNavascript.g:3861:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    // InternalNavascript.g:3862:5: otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,61,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:3866:5: ( (lv_varElements_12_0= ruleVarElement ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==RULE_VAR_DEF||LA71_0==59) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalNavascript.g:3867:6: (lv_varElements_12_0= ruleVarElement )
                    	    {
                    	    // InternalNavascript.g:3867:6: (lv_varElements_12_0= ruleVarElement )
                    	    // InternalNavascript.g:3868:7: lv_varElements_12_0= ruleVarElement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getVarAccess().getVarElementsVarElementParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_51);
                    	    lv_varElements_12_0=ruleVarElement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getVarRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"varElements",
                    	      								lv_varElements_12_0,
                    	      								"com.dexels.navajo.Navascript.VarElement");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:3891:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:3891:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    // InternalNavascript.g:3892:5: otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,61,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:3896:5: ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3897:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3897:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    // InternalNavascript.g:3898:7: lv_mappedArrayField_15_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayFieldMappedArrayFieldParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArrayField_15_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"mappedArrayField",
                      								lv_mappedArrayField_15_0,
                      								"com.dexels.navajo.Navascript.MappedArrayField");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_16, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_3_2());
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:3921:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    {
                    // InternalNavascript.g:3921:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    // InternalNavascript.g:3922:5: otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_4_0());
                      				
                    }
                    // InternalNavascript.g:3926:5: ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3927:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3927:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3928:7: lv_mappedArrayMessage_18_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayMessageMappedArrayMessageParserRuleCall_4_4_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArrayMessage_18_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"mappedArrayMessage",
                      								lv_mappedArrayMessage_18_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_19=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_19, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_4_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleVarArray"
    // InternalNavascript.g:3955:1: entryRuleVarArray returns [EObject current=null] : iv_ruleVarArray= ruleVarArray EOF ;
    public final EObject entryRuleVarArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArray = null;


        try {
            // InternalNavascript.g:3955:49: (iv_ruleVarArray= ruleVarArray EOF )
            // InternalNavascript.g:3956:2: iv_ruleVarArray= ruleVarArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarArray=ruleVarArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarArray"


    // $ANTLR start "ruleVarArray"
    // InternalNavascript.g:3962:1: ruleVarArray returns [EObject current=null] : ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) ;
    public final EObject ruleVarArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_vararrayelement_1_0 = null;

        EObject lv_vararrayelement_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3968:2: ( ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) )
            // InternalNavascript.g:3969:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            {
            // InternalNavascript.g:3969:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            // InternalNavascript.g:3970:3: () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            {
            // InternalNavascript.g:3970:3: ()
            // InternalNavascript.g:3971:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayAccess().getVarArrayAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3977:3: ( (lv_vararrayelement_1_0= ruleVarArrayElement ) )
            // InternalNavascript.g:3978:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            {
            // InternalNavascript.g:3978:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            // InternalNavascript.g:3979:5: lv_vararrayelement_1_0= ruleVarArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarArrayAccess().getVararrayelementVarArrayElementParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_vararrayelement_1_0=ruleVarArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarArrayRule());
              					}
              					add(
              						current,
              						"vararrayelement",
              						lv_vararrayelement_1_0,
              						"com.dexels.navajo.Navascript.VarArrayElement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:3996:3: (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==63) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalNavascript.g:3997:4: otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    {
            	    otherlv_2=(Token)match(input,63,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getVarArrayAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:4001:4: ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    // InternalNavascript.g:4002:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    {
            	    // InternalNavascript.g:4002:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    // InternalNavascript.g:4003:6: lv_vararrayelement_3_0= ruleVarArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarArrayAccess().getVararrayelementVarArrayElementParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_vararrayelement_3_0=ruleVarArrayElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVarArrayRule());
            	      						}
            	      						add(
            	      							current,
            	      							"vararrayelement",
            	      							lv_vararrayelement_3_0,
            	      							"com.dexels.navajo.Navascript.VarArrayElement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarArray"


    // $ANTLR start "entryRuleVarArrayElement"
    // InternalNavascript.g:4025:1: entryRuleVarArrayElement returns [EObject current=null] : iv_ruleVarArrayElement= ruleVarArrayElement EOF ;
    public final EObject entryRuleVarArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArrayElement = null;


        try {
            // InternalNavascript.g:4025:56: (iv_ruleVarArrayElement= ruleVarArrayElement EOF )
            // InternalNavascript.g:4026:2: iv_ruleVarArrayElement= ruleVarArrayElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarArrayElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarArrayElement=ruleVarArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarArrayElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarArrayElement"


    // $ANTLR start "ruleVarArrayElement"
    // InternalNavascript.g:4032:1: ruleVarArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleVarArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_varElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4038:2: ( ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:4039:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:4039:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            // InternalNavascript.g:4040:3: () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:4040:3: ()
            // InternalNavascript.g:4041:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayElementAccess().getVarArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:4051:3: ( (lv_varElements_2_0= ruleVarElement ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_VAR_DEF||LA74_0==59) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalNavascript.g:4052:4: (lv_varElements_2_0= ruleVarElement )
            	    {
            	    // InternalNavascript.g:4052:4: (lv_varElements_2_0= ruleVarElement )
            	    // InternalNavascript.g:4053:5: lv_varElements_2_0= ruleVarElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getVarArrayElementAccess().getVarElementsVarElementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_51);
            	    lv_varElements_2_0=ruleVarElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getVarArrayElementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"varElements",
            	      						lv_varElements_2_0,
            	      						"com.dexels.navajo.Navascript.VarElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getVarArrayElementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarArrayElement"


    // $ANTLR start "entryRuleVarElement"
    // InternalNavascript.g:4078:1: entryRuleVarElement returns [EObject current=null] : iv_ruleVarElement= ruleVarElement EOF ;
    public final EObject entryRuleVarElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarElement = null;


        try {
            // InternalNavascript.g:4078:51: (iv_ruleVarElement= ruleVarElement EOF )
            // InternalNavascript.g:4079:2: iv_ruleVarElement= ruleVarElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarElement=ruleVarElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarElement"


    // $ANTLR start "ruleVarElement"
    // InternalNavascript.g:4085:1: ruleVarElement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) ;
    public final EObject ruleVarElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_var_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4091:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) )
            // InternalNavascript.g:4092:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            {
            // InternalNavascript.g:4092:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            // InternalNavascript.g:4093:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) )
            {
            // InternalNavascript.g:4093:3: ()
            // InternalNavascript.g:4094:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarElementAccess().getVarElementAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4100:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==59) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalNavascript.g:4101:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVarElementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:4105:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:4106:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:4106:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:4107:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarElementAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_condition_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarElementRule());
                      						}
                      						set(
                      							current,
                      							"condition",
                      							lv_condition_2_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,60,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarElementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4129:3: ( (lv_var_4_0= ruleVar ) )
            // InternalNavascript.g:4130:4: (lv_var_4_0= ruleVar )
            {
            // InternalNavascript.g:4130:4: (lv_var_4_0= ruleVar )
            // InternalNavascript.g:4131:5: lv_var_4_0= ruleVar
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarElementAccess().getVarVarParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_var_4_0=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarElementRule());
              					}
              					set(
              						current,
              						"var",
              						lv_var_4_0,
              						"com.dexels.navajo.Navascript.Var");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarElement"


    // $ANTLR start "entryRuleVarArguments"
    // InternalNavascript.g:4152:1: entryRuleVarArguments returns [EObject current=null] : iv_ruleVarArguments= ruleVarArguments EOF ;
    public final EObject entryRuleVarArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArguments = null;


        try {
            // InternalNavascript.g:4152:53: (iv_ruleVarArguments= ruleVarArguments EOF )
            // InternalNavascript.g:4153:2: iv_ruleVarArguments= ruleVarArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarArguments=ruleVarArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarArguments"


    // $ANTLR start "ruleVarArguments"
    // InternalNavascript.g:4159:1: ruleVarArguments returns [EObject current=null] : ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) ;
    public final EObject ruleVarArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARGS_START_1=null;
        Token otherlv_3=null;
        Token this_ARGS_END_5=null;
        EObject lv_varArguments_2_0 = null;

        EObject lv_varArguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4165:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) )
            // InternalNavascript.g:4166:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            {
            // InternalNavascript.g:4166:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            // InternalNavascript.g:4167:3: () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END
            {
            // InternalNavascript.g:4167:3: ()
            // InternalNavascript.g:4168:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArgumentsAccess().getVarArgumentsAction_0(),
              					current);
              			
            }

            }

            this_ARGS_START_1=(Token)match(input,RULE_ARGS_START,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_1, grammarAccess.getVarArgumentsAccess().getARGS_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4178:3: ( (lv_varArguments_2_0= ruleVarArgument ) )
            // InternalNavascript.g:4179:4: (lv_varArguments_2_0= ruleVarArgument )
            {
            // InternalNavascript.g:4179:4: (lv_varArguments_2_0= ruleVarArgument )
            // InternalNavascript.g:4180:5: lv_varArguments_2_0= ruleVarArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarArgumentsAccess().getVarArgumentsVarArgumentParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_varArguments_2_0=ruleVarArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarArgumentsRule());
              					}
              					add(
              						current,
              						"varArguments",
              						lv_varArguments_2_0,
              						"com.dexels.navajo.Navascript.VarArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:4197:3: (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==63) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalNavascript.g:4198:4: otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,63,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getVarArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4202:4: ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    // InternalNavascript.g:4203:5: (lv_varArguments_4_0= ruleVarArgument )
            	    {
            	    // InternalNavascript.g:4203:5: (lv_varArguments_4_0= ruleVarArgument )
            	    // InternalNavascript.g:4204:6: lv_varArguments_4_0= ruleVarArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarArgumentsAccess().getVarArgumentsVarArgumentParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_varArguments_4_0=ruleVarArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getVarArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"varArguments",
            	      							lv_varArguments_4_0,
            	      							"com.dexels.navajo.Navascript.VarArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            this_ARGS_END_5=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_5, grammarAccess.getVarArgumentsAccess().getARGS_ENDTerminalRuleCall_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarArguments"


    // $ANTLR start "entryRuleVarArgument"
    // InternalNavascript.g:4230:1: entryRuleVarArgument returns [EObject current=null] : iv_ruleVarArgument= ruleVarArgument EOF ;
    public final EObject entryRuleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArgument = null;


        try {
            // InternalNavascript.g:4230:52: (iv_ruleVarArgument= ruleVarArgument EOF )
            // InternalNavascript.g:4231:2: iv_ruleVarArgument= ruleVarArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarArgument=ruleVarArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarArgument"


    // $ANTLR start "ruleVarArgument"
    // InternalNavascript.g:4237:1: ruleVarArgument returns [EObject current=null] : ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) ;
    public final EObject ruleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_argument_1_1 = null;

        EObject lv_argument_1_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4243:2: ( ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) )
            // InternalNavascript.g:4244:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            {
            // InternalNavascript.g:4244:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            // InternalNavascript.g:4245:3: () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            {
            // InternalNavascript.g:4245:3: ()
            // InternalNavascript.g:4246:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArgumentAccess().getVarArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4252:3: ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            // InternalNavascript.g:4253:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            {
            // InternalNavascript.g:4253:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            // InternalNavascript.g:4254:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            {
            // InternalNavascript.g:4254:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_TYPE_DEF) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_MODE_DEF) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalNavascript.g:4255:6: lv_argument_1_1= ruleVarType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarArgumentAccess().getArgumentVarTypeParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_argument_1_1=ruleVarType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarArgumentRule());
                      						}
                      						set(
                      							current,
                      							"argument",
                      							lv_argument_1_1,
                      							"com.dexels.navajo.Navascript.VarType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4271:6: lv_argument_1_2= ruleVarMode
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarArgumentAccess().getArgumentVarModeParserRuleCall_1_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_argument_1_2=ruleVarMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarArgumentRule());
                      						}
                      						set(
                      							current,
                      							"argument",
                      							lv_argument_1_2,
                      							"com.dexels.navajo.Navascript.VarMode");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarArgument"


    // $ANTLR start "entryRuleVarType"
    // InternalNavascript.g:4293:1: entryRuleVarType returns [EObject current=null] : iv_ruleVarType= ruleVarType EOF ;
    public final EObject entryRuleVarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarType = null;


        try {
            // InternalNavascript.g:4293:48: (iv_ruleVarType= ruleVarType EOF )
            // InternalNavascript.g:4294:2: iv_ruleVarType= ruleVarType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarType=ruleVarType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarType"


    // $ANTLR start "ruleVarType"
    // InternalNavascript.g:4300:1: ruleVarType returns [EObject current=null] : ( () this_TYPE_DEF_1= RULE_TYPE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) ;
    public final EObject ruleVarType() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_type_4_1 = null;

        EObject lv_type_4_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4306:2: ( ( () this_TYPE_DEF_1= RULE_TYPE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) )
            // InternalNavascript.g:4307:2: ( () this_TYPE_DEF_1= RULE_TYPE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            {
            // InternalNavascript.g:4307:2: ( () this_TYPE_DEF_1= RULE_TYPE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            // InternalNavascript.g:4308:3: () this_TYPE_DEF_1= RULE_TYPE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            {
            // InternalNavascript.g:4308:3: ()
            // InternalNavascript.g:4309:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarTypeAccess().getVarTypeAction_0(),
              					current);
              			
            }

            }

            this_TYPE_DEF_1=(Token)match(input,RULE_TYPE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TYPE_DEF_1, grammarAccess.getVarTypeAccess().getTYPE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4319:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==64) ) {
                alt78=1;
            }
            else if ( (LA78_0==65) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalNavascript.g:4320:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarTypeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4325:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,65,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarTypeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4330:3: ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            // InternalNavascript.g:4331:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            {
            // InternalNavascript.g:4331:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            // InternalNavascript.g:4332:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            {
            // InternalNavascript.g:4332:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=106 && LA79_0<=108)) ) {
                alt79=1;
            }
            else if ( ((LA79_0>=92 && LA79_0<=102)) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalNavascript.g:4333:6: lv_type_4_1= ruleMessageType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarTypeAccess().getTypeMessageTypeParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_4_1=ruleMessageType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarTypeRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_4_1,
                      							"com.dexels.navajo.Navascript.MessageType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4349:6: lv_type_4_2= rulePropertyType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarTypeAccess().getTypePropertyTypeParserRuleCall_3_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_4_2=rulePropertyType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarTypeRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_4_2,
                      							"com.dexels.navajo.Navascript.PropertyType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarType"


    // $ANTLR start "entryRuleVarMode"
    // InternalNavascript.g:4371:1: entryRuleVarMode returns [EObject current=null] : iv_ruleVarMode= ruleVarMode EOF ;
    public final EObject entryRuleVarMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarMode = null;


        try {
            // InternalNavascript.g:4371:48: (iv_ruleVarMode= ruleVarMode EOF )
            // InternalNavascript.g:4372:2: iv_ruleVarMode= ruleVarMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarMode=ruleVarMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarMode"


    // $ANTLR start "ruleVarMode"
    // InternalNavascript.g:4378:1: ruleVarMode returns [EObject current=null] : ( () this_MODE_DEF_1= RULE_MODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) ;
    public final EObject ruleVarMode() throws RecognitionException {
        EObject current = null;

        Token this_MODE_DEF_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_mode_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4384:2: ( ( () this_MODE_DEF_1= RULE_MODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) )
            // InternalNavascript.g:4385:2: ( () this_MODE_DEF_1= RULE_MODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            {
            // InternalNavascript.g:4385:2: ( () this_MODE_DEF_1= RULE_MODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            // InternalNavascript.g:4386:3: () this_MODE_DEF_1= RULE_MODE_DEF (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) )
            {
            // InternalNavascript.g:4386:3: ()
            // InternalNavascript.g:4387:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarModeAccess().getVarModeAction_0(),
              					current);
              			
            }

            }

            this_MODE_DEF_1=(Token)match(input,RULE_MODE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_MODE_DEF_1, grammarAccess.getVarModeAccess().getMODE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4397:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==64) ) {
                alt80=1;
            }
            else if ( (LA80_0==65) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // InternalNavascript.g:4398:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarModeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4403:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,65,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarModeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4408:3: ( (lv_mode_4_0= ruleMessageMode ) )
            // InternalNavascript.g:4409:4: (lv_mode_4_0= ruleMessageMode )
            {
            // InternalNavascript.g:4409:4: (lv_mode_4_0= ruleMessageMode )
            // InternalNavascript.g:4410:5: lv_mode_4_0= ruleMessageMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarModeAccess().getModeMessageModeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_mode_4_0=ruleMessageMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarModeRule());
              					}
              					set(
              						current,
              						"mode",
              						lv_mode_4_0,
              						"com.dexels.navajo.Navascript.MessageMode");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarMode"


    // $ANTLR start "entryRuleProperty"
    // InternalNavascript.g:4431:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalNavascript.g:4431:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalNavascript.g:4432:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalNavascript.g:4438:1: ruleProperty returns [EObject current=null] : ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token this_PROPERTY_DEF_1=null;
        Token lv_propertyName_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_expressionList_6_0 = null;

        EObject lv_selectionArray_9_0 = null;

        EObject lv_arrayField_12_0 = null;

        EObject lv_arrayMessage_15_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4444:2: ( ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) )
            // InternalNavascript.g:4445:2: ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            {
            // InternalNavascript.g:4445:2: ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            // InternalNavascript.g:4446:3: () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            {
            // InternalNavascript.g:4446:3: ()
            // InternalNavascript.g:4447:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyAccess().getPropertyAction_0(),
              					current);
              			
            }

            }

            this_PROPERTY_DEF_1=(Token)match(input,RULE_PROPERTY_DEF,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_PROPERTY_DEF_1, grammarAccess.getPropertyAccess().getPROPERTY_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4457:3: ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:4458:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:4458:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:4459:5: lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_propertyName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_propertyName_2_0, grammarAccess.getPropertyAccess().getPropertyNameQUOTED_IDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyRule());
              					}
              					setWithLastConsumed(
              						current,
              						"propertyName",
              						lv_propertyName_2_0,
              						"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:4475:3: ( (lv_arguments_3_0= rulePropertyArguments ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ARGS_START) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalNavascript.g:4476:4: (lv_arguments_3_0= rulePropertyArguments )
                    {
                    // InternalNavascript.g:4476:4: (lv_arguments_3_0= rulePropertyArguments )
                    // InternalNavascript.g:4477:5: lv_arguments_3_0= rulePropertyArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyAccess().getArgumentsPropertyArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_56);
                    lv_arguments_3_0=rulePropertyArguments();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyRule());
                      					}
                      					set(
                      						current,
                      						"arguments",
                      						lv_arguments_3_0,
                      						"com.dexels.navajo.Navascript.PropertyArguments");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:4494:3: ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            int alt84=4;
            switch ( input.LA(1) ) {
            case 64:
            case 65:
            case 68:
                {
                alt84=1;
                }
                break;
            case 72:
                {
                alt84=2;
                }
                break;
            case 61:
                {
                int LA84_3 = input.LA(2);

                if ( (LA84_3==RULE_MAPPABLE_IDENTIFIER) ) {
                    alt84=3;
                }
                else if ( (LA84_3==RULE_TML_LITERAL) ) {
                    alt84=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalNavascript.g:4495:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    {
                    // InternalNavascript.g:4495:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    // InternalNavascript.g:4496:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';'
                    {
                    // InternalNavascript.g:4496:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( ((LA83_0>=64 && LA83_0<=65)) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalNavascript.g:4497:6: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            {
                            // InternalNavascript.g:4497:6: (otherlv_4= '=' | otherlv_5= ':' )
                            int alt82=2;
                            int LA82_0 = input.LA(1);

                            if ( (LA82_0==64) ) {
                                alt82=1;
                            }
                            else if ( (LA82_0==65) ) {
                                alt82=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 82, 0, input);

                                throw nvae;
                            }
                            switch (alt82) {
                                case 1 :
                                    // InternalNavascript.g:4498:7: otherlv_4= '='
                                    {
                                    otherlv_4=(Token)match(input,64,FOLLOW_47); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_4, grammarAccess.getPropertyAccess().getEqualsSignKeyword_4_0_0_0_0());
                                      						
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalNavascript.g:4503:7: otherlv_5= ':'
                                    {
                                    otherlv_5=(Token)match(input,65,FOLLOW_47); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonKeyword_4_0_0_0_1());
                                      						
                                    }

                                    }
                                    break;

                            }

                            // InternalNavascript.g:4508:6: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            // InternalNavascript.g:4509:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            {
                            // InternalNavascript.g:4509:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            // InternalNavascript.g:4510:8: lv_expressionList_6_0= ruleConditionalExpressions
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getPropertyAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_22);
                            lv_expressionList_6_0=ruleConditionalExpressions();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getPropertyRule());
                              								}
                              								set(
                              									current,
                              									"expressionList",
                              									lv_expressionList_6_0,
                              									"com.dexels.navajo.Navascript.ConditionalExpressions");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getPropertyAccess().getSemicolonKeyword_4_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4534:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    {
                    // InternalNavascript.g:4534:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    // InternalNavascript.g:4535:5: otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,72,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getPropertyAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4539:5: ( (lv_selectionArray_9_0= ruleSelectionArray ) )
                    // InternalNavascript.g:4540:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    {
                    // InternalNavascript.g:4540:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    // InternalNavascript.g:4541:7: lv_selectionArray_9_0= ruleSelectionArray
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getSelectionArraySelectionArrayParserRuleCall_4_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_38);
                    lv_selectionArray_9_0=ruleSelectionArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"selectionArray",
                      								lv_selectionArray_9_0,
                      								"com.dexels.navajo.Navascript.SelectionArray");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getPropertyAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4564:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    {
                    // InternalNavascript.g:4564:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    // InternalNavascript.g:4565:5: otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,61,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4569:5: ( (lv_arrayField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4570:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4570:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:4571:7: lv_arrayField_12_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_2_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_arrayField_12_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"arrayField",
                      								lv_arrayField_12_0,
                      								"com.dexels.navajo.Navascript.MappedArrayField");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getPropertyAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4594:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:4594:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    // InternalNavascript.g:4595:5: otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4599:5: ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4600:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4600:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4601:7: lv_arrayMessage_15_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayMessageMappedArrayMessageParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_arrayMessage_15_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"arrayMessage",
                      								lv_arrayMessage_15_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_16, grammarAccess.getPropertyAccess().getRightCurlyBracketKeyword_4_3_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleSelectionArray"
    // InternalNavascript.g:4628:1: entryRuleSelectionArray returns [EObject current=null] : iv_ruleSelectionArray= ruleSelectionArray EOF ;
    public final EObject entryRuleSelectionArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArray = null;


        try {
            // InternalNavascript.g:4628:55: (iv_ruleSelectionArray= ruleSelectionArray EOF )
            // InternalNavascript.g:4629:2: iv_ruleSelectionArray= ruleSelectionArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectionArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelectionArray=ruleSelectionArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectionArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectionArray"


    // $ANTLR start "ruleSelectionArray"
    // InternalNavascript.g:4635:1: ruleSelectionArray returns [EObject current=null] : ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) ;
    public final EObject ruleSelectionArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayElements_0_0 = null;

        EObject lv_arrayElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4641:2: ( ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) )
            // InternalNavascript.g:4642:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            {
            // InternalNavascript.g:4642:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            // InternalNavascript.g:4643:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            {
            // InternalNavascript.g:4643:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) )
            // InternalNavascript.g:4644:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            {
            // InternalNavascript.g:4644:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            // InternalNavascript.g:4645:5: lv_arrayElements_0_0= ruleSelectionArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSelectionArrayAccess().getArrayElementsSelectionArrayElementParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_arrayElements_0_0=ruleSelectionArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSelectionArrayRule());
              					}
              					add(
              						current,
              						"arrayElements",
              						lv_arrayElements_0_0,
              						"com.dexels.navajo.Navascript.SelectionArrayElement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:4662:3: (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==63) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalNavascript.g:4663:4: otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,63,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSelectionArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:4667:4: ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    // InternalNavascript.g:4668:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    {
            	    // InternalNavascript.g:4668:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    // InternalNavascript.g:4669:6: lv_arrayElements_2_0= ruleSelectionArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSelectionArrayAccess().getArrayElementsSelectionArrayElementParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_arrayElements_2_0=ruleSelectionArrayElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSelectionArrayRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arrayElements",
            	      							lv_arrayElements_2_0,
            	      							"com.dexels.navajo.Navascript.SelectionArrayElement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectionArray"


    // $ANTLR start "entryRuleSelectionArrayElement"
    // InternalNavascript.g:4691:1: entryRuleSelectionArrayElement returns [EObject current=null] : iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF ;
    public final EObject entryRuleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArrayElement = null;


        try {
            // InternalNavascript.g:4691:62: (iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF )
            // InternalNavascript.g:4692:2: iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelectionArrayElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSelectionArrayElement=ruleSelectionArrayElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelectionArrayElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectionArrayElement"


    // $ANTLR start "ruleSelectionArrayElement"
    // InternalNavascript.g:4698:1: ruleSelectionArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_innerBody_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4704:2: ( ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:4705:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:4705:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:4706:3: () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:4706:3: ()
            // InternalNavascript.g:4707:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSelectionArrayElementAccess().getSelectionArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSelectionArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:4717:3: ( (lv_innerBody_2_0= ruleInnerBody ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==RULE_BREAK_DEF||LA86_0==RULE_DEFINE_DEF||(LA86_0>=RULE_PRINT_DEF && LA86_0<=RULE_LOG_DEF)||LA86_0==RULE_LOOP_DEF||LA86_0==RULE_INCLUDE_DEF||LA86_0==RULE_MAP_OLDSKOOL_DEF||(LA86_0>=RULE_METHOD_IDENTIFIER && LA86_0<=RULE_MAPPABLE_IDENTIFIER)||(LA86_0>=RULE_VAR_DEF && LA86_0<=RULE_OPTION_DEF)||LA86_0==59||LA86_0==61||(LA86_0>=69 && LA86_0<=71)||LA86_0==74) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalNavascript.g:4718:4: (lv_innerBody_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:4718:4: (lv_innerBody_2_0= ruleInnerBody )
            	    // InternalNavascript.g:4719:5: lv_innerBody_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSelectionArrayElementAccess().getInnerBodyInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_innerBody_2_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSelectionArrayElementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"innerBody",
            	      						lv_innerBody_2_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSelectionArrayElementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectionArrayElement"


    // $ANTLR start "entryRuleOption"
    // InternalNavascript.g:4744:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalNavascript.g:4744:47: (iv_ruleOption= ruleOption EOF )
            // InternalNavascript.g:4745:2: iv_ruleOption= ruleOption EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOption=ruleOption();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOption; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalNavascript.g:4751:1: ruleOption returns [EObject current=null] : (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) ;
    public final EObject ruleOption() throws RecognitionException {
        EObject current = null;

        Token this_OPTION_DEF_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_option_1_0 = null;

        EObject lv_expressionList_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4757:2: ( (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) )
            // InternalNavascript.g:4758:2: (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            {
            // InternalNavascript.g:4758:2: (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            // InternalNavascript.g:4759:3: this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
            {
            this_OPTION_DEF_0=(Token)match(input,RULE_OPTION_DEF,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_OPTION_DEF_0, grammarAccess.getOptionAccess().getOPTION_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:4763:3: ( (lv_option_1_0= ruleOPTION_TYPE ) )
            // InternalNavascript.g:4764:4: (lv_option_1_0= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:4764:4: (lv_option_1_0= ruleOPTION_TYPE )
            // InternalNavascript.g:4765:5: lv_option_1_0= ruleOPTION_TYPE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionAccess().getOptionOPTION_TYPEParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_option_1_0=ruleOPTION_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOptionRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"com.dexels.navajo.Navascript.OPTION_TYPE");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:4782:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==64) ) {
                alt87=1;
            }
            else if ( (LA87_0==65) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalNavascript.g:4783:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4788:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,65,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4793:3: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
            // InternalNavascript.g:4794:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            {
            // InternalNavascript.g:4794:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            // InternalNavascript.g:4795:5: lv_expressionList_4_0= ruleConditionalExpressions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionAccess().getExpressionListConditionalExpressionsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expressionList_4_0=ruleConditionalExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOptionRule());
              					}
              					set(
              						current,
              						"expressionList",
              						lv_expressionList_4_0,
              						"com.dexels.navajo.Navascript.ConditionalExpressions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getOptionAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRulePropertyArguments"
    // InternalNavascript.g:4820:1: entryRulePropertyArguments returns [EObject current=null] : iv_rulePropertyArguments= rulePropertyArguments EOF ;
    public final EObject entryRulePropertyArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArguments = null;


        try {
            // InternalNavascript.g:4820:58: (iv_rulePropertyArguments= rulePropertyArguments EOF )
            // InternalNavascript.g:4821:2: iv_rulePropertyArguments= rulePropertyArguments EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyArgumentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyArguments=rulePropertyArguments();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyArguments; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyArguments"


    // $ANTLR start "rulePropertyArguments"
    // InternalNavascript.g:4827:1: rulePropertyArguments returns [EObject current=null] : ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) ;
    public final EObject rulePropertyArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARGS_START_1=null;
        Token otherlv_3=null;
        Token this_ARGS_END_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4833:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) )
            // InternalNavascript.g:4834:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            {
            // InternalNavascript.g:4834:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            // InternalNavascript.g:4835:3: () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END
            {
            // InternalNavascript.g:4835:3: ()
            // InternalNavascript.g:4836:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyArgumentsAccess().getPropertyArgumentsAction_0(),
              					current);
              			
            }

            }

            this_ARGS_START_1=(Token)match(input,RULE_ARGS_START,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_1, grammarAccess.getPropertyArgumentsAccess().getARGS_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4846:3: ( (lv_arguments_2_0= rulePropertyArgument ) )
            // InternalNavascript.g:4847:4: (lv_arguments_2_0= rulePropertyArgument )
            {
            // InternalNavascript.g:4847:4: (lv_arguments_2_0= rulePropertyArgument )
            // InternalNavascript.g:4848:5: lv_arguments_2_0= rulePropertyArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyArgumentsAccess().getArgumentsPropertyArgumentParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_arguments_2_0=rulePropertyArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyArgumentsRule());
              					}
              					add(
              						current,
              						"arguments",
              						lv_arguments_2_0,
              						"com.dexels.navajo.Navascript.PropertyArgument");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:4865:3: (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==63) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalNavascript.g:4866:4: otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,63,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getPropertyArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4870:4: ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    // InternalNavascript.g:4871:5: (lv_arguments_4_0= rulePropertyArgument )
            	    {
            	    // InternalNavascript.g:4871:5: (lv_arguments_4_0= rulePropertyArgument )
            	    // InternalNavascript.g:4872:6: lv_arguments_4_0= rulePropertyArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPropertyArgumentsAccess().getArgumentsPropertyArgumentParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_arguments_4_0=rulePropertyArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPropertyArgumentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"arguments",
            	      							lv_arguments_4_0,
            	      							"com.dexels.navajo.Navascript.PropertyArgument");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            this_ARGS_END_5=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_5, grammarAccess.getPropertyArgumentsAccess().getARGS_ENDTerminalRuleCall_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyArguments"


    // $ANTLR start "entryRulePropertyArgument"
    // InternalNavascript.g:4898:1: entryRulePropertyArgument returns [EObject current=null] : iv_rulePropertyArgument= rulePropertyArgument EOF ;
    public final EObject entryRulePropertyArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArgument = null;


        try {
            // InternalNavascript.g:4898:57: (iv_rulePropertyArgument= rulePropertyArgument EOF )
            // InternalNavascript.g:4899:2: iv_rulePropertyArgument= rulePropertyArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyArgument=rulePropertyArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyArgument"


    // $ANTLR start "rulePropertyArgument"
    // InternalNavascript.g:4905:1: rulePropertyArgument returns [EObject current=null] : (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) ;
    public final EObject rulePropertyArgument() throws RecognitionException {
        EObject current = null;

        EObject this_DirectionArgument_0 = null;

        EObject this_TypeArgument_1 = null;

        EObject this_SubTypeArgument_2 = null;

        EObject this_DescriptionArgument_3 = null;

        EObject this_CardinalityArgument_4 = null;

        EObject this_LengthArgument_5 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4911:2: ( (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) )
            // InternalNavascript.g:4912:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            {
            // InternalNavascript.g:4912:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            int alt89=6;
            switch ( input.LA(1) ) {
            case RULE_DIRECTION_DEF:
                {
                alt89=1;
                }
                break;
            case RULE_TYPE_DEF:
                {
                alt89=2;
                }
                break;
            case RULE_SUBTYPE_DEF:
                {
                alt89=3;
                }
                break;
            case RULE_DESCRIPTION_DEF:
                {
                alt89=4;
                }
                break;
            case RULE_CARDINALITY_DEF:
                {
                alt89=5;
                }
                break;
            case RULE_LENGTH_DEF:
                {
                alt89=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalNavascript.g:4913:3: this_DirectionArgument_0= ruleDirectionArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getDirectionArgumentParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DirectionArgument_0=ruleDirectionArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DirectionArgument_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4922:3: this_TypeArgument_1= ruleTypeArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getTypeArgumentParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeArgument_1=ruleTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeArgument_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4931:3: this_SubTypeArgument_2= ruleSubTypeArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getSubTypeArgumentParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SubTypeArgument_2=ruleSubTypeArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SubTypeArgument_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4940:3: this_DescriptionArgument_3= ruleDescriptionArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getDescriptionArgumentParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DescriptionArgument_3=ruleDescriptionArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DescriptionArgument_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalNavascript.g:4949:3: this_CardinalityArgument_4= ruleCardinalityArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getCardinalityArgumentParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CardinalityArgument_4=ruleCardinalityArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CardinalityArgument_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalNavascript.g:4958:3: this_LengthArgument_5= ruleLengthArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyArgumentAccess().getLengthArgumentParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LengthArgument_5=ruleLengthArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LengthArgument_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyArgument"


    // $ANTLR start "entryRuleLengthArgument"
    // InternalNavascript.g:4970:1: entryRuleLengthArgument returns [EObject current=null] : iv_ruleLengthArgument= ruleLengthArgument EOF ;
    public final EObject entryRuleLengthArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLengthArgument = null;


        try {
            // InternalNavascript.g:4970:55: (iv_ruleLengthArgument= ruleLengthArgument EOF )
            // InternalNavascript.g:4971:2: iv_ruleLengthArgument= ruleLengthArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLengthArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLengthArgument=ruleLengthArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLengthArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLengthArgument"


    // $ANTLR start "ruleLengthArgument"
    // InternalNavascript.g:4977:1: ruleLengthArgument returns [EObject current=null] : (this_LENGTH_DEF_0= RULE_LENGTH_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleLengthArgument() throws RecognitionException {
        EObject current = null;

        Token this_LENGTH_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:4983:2: ( (this_LENGTH_DEF_0= RULE_LENGTH_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) )
            // InternalNavascript.g:4984:2: (this_LENGTH_DEF_0= RULE_LENGTH_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            {
            // InternalNavascript.g:4984:2: (this_LENGTH_DEF_0= RULE_LENGTH_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            // InternalNavascript.g:4985:3: this_LENGTH_DEF_0= RULE_LENGTH_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) )
            {
            this_LENGTH_DEF_0=(Token)match(input,RULE_LENGTH_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LENGTH_DEF_0, grammarAccess.getLengthArgumentAccess().getLENGTH_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:4989:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==64) ) {
                alt90=1;
            }
            else if ( (LA90_0==65) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalNavascript.g:4990:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLengthArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4995:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLengthArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5000:3: ( (lv_value_3_0= RULE_INTEGER ) )
            // InternalNavascript.g:5001:4: (lv_value_3_0= RULE_INTEGER )
            {
            // InternalNavascript.g:5001:4: (lv_value_3_0= RULE_INTEGER )
            // InternalNavascript.g:5002:5: lv_value_3_0= RULE_INTEGER
            {
            lv_value_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_3_0, grammarAccess.getLengthArgumentAccess().getValueINTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLengthArgumentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_3_0,
              						"com.dexels.navajo.Navascript.INTEGER");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLengthArgument"


    // $ANTLR start "entryRuleDirectionArgument"
    // InternalNavascript.g:5022:1: entryRuleDirectionArgument returns [EObject current=null] : iv_ruleDirectionArgument= ruleDirectionArgument EOF ;
    public final EObject entryRuleDirectionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionArgument = null;


        try {
            // InternalNavascript.g:5022:58: (iv_ruleDirectionArgument= ruleDirectionArgument EOF )
            // InternalNavascript.g:5023:2: iv_ruleDirectionArgument= ruleDirectionArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectionArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirectionArgument=ruleDirectionArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirectionArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectionArgument"


    // $ANTLR start "ruleDirectionArgument"
    // InternalNavascript.g:5029:1: ruleDirectionArgument returns [EObject current=null] : (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) ) ) ;
    public final EObject ruleDirectionArgument() throws RecognitionException {
        EObject current = null;

        Token this_DIRECTION_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_3_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:5035:2: ( (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) ) ) )
            // InternalNavascript.g:5036:2: (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) ) )
            {
            // InternalNavascript.g:5036:2: (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) ) )
            // InternalNavascript.g:5037:3: this_DIRECTION_DEF_0= RULE_DIRECTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) )
            {
            this_DIRECTION_DEF_0=(Token)match(input,RULE_DIRECTION_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_DIRECTION_DEF_0, grammarAccess.getDirectionArgumentAccess().getDIRECTION_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5041:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==64) ) {
                alt91=1;
            }
            else if ( (LA91_0==65) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalNavascript.g:5042:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5047:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDirectionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5052:3: ( ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) ) )
            // InternalNavascript.g:5053:4: ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) )
            {
            // InternalNavascript.g:5053:4: ( (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF ) )
            // InternalNavascript.g:5054:5: (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF )
            {
            // InternalNavascript.g:5054:5: (lv_value_3_1= RULE_IN_DEF | lv_value_3_2= RULE_OUT_DEF | lv_value_3_3= RULE_INOUT_DEF )
            int alt92=3;
            switch ( input.LA(1) ) {
            case RULE_IN_DEF:
                {
                alt92=1;
                }
                break;
            case RULE_OUT_DEF:
                {
                alt92=2;
                }
                break;
            case RULE_INOUT_DEF:
                {
                alt92=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalNavascript.g:5055:6: lv_value_3_1= RULE_IN_DEF
                    {
                    lv_value_3_1=(Token)match(input,RULE_IN_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_1, grammarAccess.getDirectionArgumentAccess().getValueIN_DEFTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_1,
                      							"com.dexels.navajo.Navascript.IN_DEF");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5070:6: lv_value_3_2= RULE_OUT_DEF
                    {
                    lv_value_3_2=(Token)match(input,RULE_OUT_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_2, grammarAccess.getDirectionArgumentAccess().getValueOUT_DEFTerminalRuleCall_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_2,
                      							"com.dexels.navajo.Navascript.OUT_DEF");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:5085:6: lv_value_3_3= RULE_INOUT_DEF
                    {
                    lv_value_3_3=(Token)match(input,RULE_INOUT_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_3, grammarAccess.getDirectionArgumentAccess().getValueINOUT_DEFTerminalRuleCall_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_3,
                      							"com.dexels.navajo.Navascript.INOUT_DEF");
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectionArgument"


    // $ANTLR start "entryRuleDescriptionArgument"
    // InternalNavascript.g:5106:1: entryRuleDescriptionArgument returns [EObject current=null] : iv_ruleDescriptionArgument= ruleDescriptionArgument EOF ;
    public final EObject entryRuleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionArgument = null;


        try {
            // InternalNavascript.g:5106:60: (iv_ruleDescriptionArgument= ruleDescriptionArgument EOF )
            // InternalNavascript.g:5107:2: iv_ruleDescriptionArgument= ruleDescriptionArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionArgument=ruleDescriptionArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionArgument"


    // $ANTLR start "ruleDescriptionArgument"
    // InternalNavascript.g:5113:1: ruleDescriptionArgument returns [EObject current=null] : (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        Token this_DESCRIPTION_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5119:2: ( (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5120:2: (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5120:2: (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5121:3: this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) )
            {
            this_DESCRIPTION_DEF_0=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_DESCRIPTION_DEF_0, grammarAccess.getDescriptionArgumentAccess().getDESCRIPTION_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5125:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==64) ) {
                alt93=1;
            }
            else if ( (LA93_0==65) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // InternalNavascript.g:5126:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDescriptionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5131:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDescriptionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5136:3: ( (lv_value_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5137:4: (lv_value_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5137:4: (lv_value_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5138:5: lv_value_3_0= ruleLiteralOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDescriptionArgumentAccess().getValueLiteralOrExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDescriptionArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
              						"com.dexels.navajo.Navascript.LiteralOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionArgument"


    // $ANTLR start "entryRuleCardinalityArgument"
    // InternalNavascript.g:5159:1: entryRuleCardinalityArgument returns [EObject current=null] : iv_ruleCardinalityArgument= ruleCardinalityArgument EOF ;
    public final EObject entryRuleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCardinalityArgument = null;


        try {
            // InternalNavascript.g:5159:60: (iv_ruleCardinalityArgument= ruleCardinalityArgument EOF )
            // InternalNavascript.g:5160:2: iv_ruleCardinalityArgument= ruleCardinalityArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCardinalityArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCardinalityArgument=ruleCardinalityArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCardinalityArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCardinalityArgument"


    // $ANTLR start "ruleCardinalityArgument"
    // InternalNavascript.g:5166:1: ruleCardinalityArgument returns [EObject current=null] : (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) ) ) ;
    public final EObject ruleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        Token this_CARDINALITY_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:5172:2: ( (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) ) ) )
            // InternalNavascript.g:5173:2: (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) ) )
            {
            // InternalNavascript.g:5173:2: (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) ) )
            // InternalNavascript.g:5174:3: this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) )
            {
            this_CARDINALITY_DEF_0=(Token)match(input,RULE_CARDINALITY_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CARDINALITY_DEF_0, grammarAccess.getCardinalityArgumentAccess().getCARDINALITY_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5178:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==64) ) {
                alt94=1;
            }
            else if ( (LA94_0==65) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalNavascript.g:5179:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCardinalityArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5184:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCardinalityArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5189:3: ( ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) ) )
            // InternalNavascript.g:5190:4: ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) )
            {
            // InternalNavascript.g:5190:4: ( (lv_value_3_1= '+' | lv_value_3_2= '1' ) )
            // InternalNavascript.g:5191:5: (lv_value_3_1= '+' | lv_value_3_2= '1' )
            {
            // InternalNavascript.g:5191:5: (lv_value_3_1= '+' | lv_value_3_2= '1' )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==75) ) {
                alt95=1;
            }
            else if ( (LA95_0==76) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalNavascript.g:5192:6: lv_value_3_1= '+'
                    {
                    lv_value_3_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_1, grammarAccess.getCardinalityArgumentAccess().getValuePlusSignKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCardinalityArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5203:6: lv_value_3_2= '1'
                    {
                    lv_value_3_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_2, grammarAccess.getCardinalityArgumentAccess().getValue1Keyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCardinalityArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCardinalityArgument"


    // $ANTLR start "entryRuleTypeArgument"
    // InternalNavascript.g:5220:1: entryRuleTypeArgument returns [EObject current=null] : iv_ruleTypeArgument= ruleTypeArgument EOF ;
    public final EObject entryRuleTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeArgument = null;


        try {
            // InternalNavascript.g:5220:53: (iv_ruleTypeArgument= ruleTypeArgument EOF )
            // InternalNavascript.g:5221:2: iv_ruleTypeArgument= ruleTypeArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeArgument=ruleTypeArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeArgument"


    // $ANTLR start "ruleTypeArgument"
    // InternalNavascript.g:5227:1: ruleTypeArgument returns [EObject current=null] : (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) ;
    public final EObject ruleTypeArgument() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5233:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) )
            // InternalNavascript.g:5234:2: (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            {
            // InternalNavascript.g:5234:2: (this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            // InternalNavascript.g:5235:3: this_TYPE_DEF_0= RULE_TYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) )
            {
            this_TYPE_DEF_0=(Token)match(input,RULE_TYPE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TYPE_DEF_0, grammarAccess.getTypeArgumentAccess().getTYPE_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5239:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==64) ) {
                alt96=1;
            }
            else if ( (LA96_0==65) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalNavascript.g:5240:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5245:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5250:3: ( (lv_value_3_0= rulePropertyType ) )
            // InternalNavascript.g:5251:4: (lv_value_3_0= rulePropertyType )
            {
            // InternalNavascript.g:5251:4: (lv_value_3_0= rulePropertyType )
            // InternalNavascript.g:5252:5: lv_value_3_0= rulePropertyType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeArgumentAccess().getValuePropertyTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=rulePropertyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
              						"com.dexels.navajo.Navascript.PropertyType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeArgument"


    // $ANTLR start "entryRuleSubTypeArgument"
    // InternalNavascript.g:5273:1: entryRuleSubTypeArgument returns [EObject current=null] : iv_ruleSubTypeArgument= ruleSubTypeArgument EOF ;
    public final EObject entryRuleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeArgument = null;


        try {
            // InternalNavascript.g:5273:56: (iv_ruleSubTypeArgument= ruleSubTypeArgument EOF )
            // InternalNavascript.g:5274:2: iv_ruleSubTypeArgument= ruleSubTypeArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubTypeArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubTypeArgument=ruleSubTypeArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubTypeArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubTypeArgument"


    // $ANTLR start "ruleSubTypeArgument"
    // InternalNavascript.g:5280:1: ruleSubTypeArgument returns [EObject current=null] : (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        Token this_SUBTYPE_DEF_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5286:2: ( (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) )
            // InternalNavascript.g:5287:2: (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            {
            // InternalNavascript.g:5287:2: (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            // InternalNavascript.g:5288:3: this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) )
            {
            this_SUBTYPE_DEF_0=(Token)match(input,RULE_SUBTYPE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_SUBTYPE_DEF_0, grammarAccess.getSubTypeArgumentAccess().getSUBTYPE_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5292:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==64) ) {
                alt97=1;
            }
            else if ( (LA97_0==65) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalNavascript.g:5293:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,64,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSubTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5298:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5303:3: ( (lv_value_3_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:5304:4: (lv_value_3_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:5304:4: (lv_value_3_0= RULE_IDENTIFIER )
            // InternalNavascript.g:5305:5: lv_value_3_0= RULE_IDENTIFIER
            {
            lv_value_3_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_3_0, grammarAccess.getSubTypeArgumentAccess().getValueIDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSubTypeArgumentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_3_0,
              						"com.dexels.navajo.Navascript.IDENTIFIER");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubTypeArgument"


    // $ANTLR start "entryRuleConditionalExpressions"
    // InternalNavascript.g:5325:1: entryRuleConditionalExpressions returns [EObject current=null] : iv_ruleConditionalExpressions= ruleConditionalExpressions EOF ;
    public final EObject entryRuleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressions = null;


        try {
            // InternalNavascript.g:5325:63: (iv_ruleConditionalExpressions= ruleConditionalExpressions EOF )
            // InternalNavascript.g:5326:2: iv_ruleConditionalExpressions= ruleConditionalExpressions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpressions=ruleConditionalExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpressions; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalExpressions"


    // $ANTLR start "ruleConditionalExpressions"
    // InternalNavascript.g:5332:1: ruleConditionalExpressions returns [EObject current=null] : ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_conditionalExpressions_1_0 = null;

        EObject lv_elseExpresssion_3_0 = null;

        EObject lv_singleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5338:2: ( ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5339:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5339:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==59) ) {
                alt99=1;
            }
            else if ( (LA99_0==RULE_ARGS_START||LA99_0==RULE_QUOTED_IDENTIFIER||LA99_0==RULE_STRING_CONSTANT||LA99_0==RULE_IDENTIFIER||(LA99_0>=RULE_MAPPABLE_IDENTIFIER && LA99_0<=RULE_TML_LITERAL)||LA99_0==RULE_INTEGER||(LA99_0>=RULE_STRING_LITERAL && LA99_0<=RULE_EXISTS)||LA99_0==86||(LA99_0>=89 && LA99_0<=90)) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // InternalNavascript.g:5340:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:5340:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:5341:4: () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5341:4: ()
                    // InternalNavascript.g:5342:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getConditionalExpressionsAccess().getConditionalExpressionsAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5348:4: ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+
                    int cnt98=0;
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==59) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalNavascript.g:5349:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    {
                    	    // InternalNavascript.g:5349:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    // InternalNavascript.g:5350:6: lv_conditionalExpressions_1_0= ruleConditionalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getConditionalExpressionsAccess().getConditionalExpressionsConditionalExpressionParserRuleCall_0_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_61);
                    	    lv_conditionalExpressions_1_0=ruleConditionalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getConditionalExpressionsRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"conditionalExpressions",
                    	      							lv_conditionalExpressions_1_0,
                    	      							"com.dexels.navajo.Navascript.ConditionalExpression");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt98 >= 1 ) break loop98;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(98, input);
                                throw eee;
                        }
                        cnt98++;
                    } while (true);

                    otherlv_2=(Token)match(input,77,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionsAccess().getElseKeyword_0_2());
                      			
                    }
                    // InternalNavascript.g:5371:4: ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5372:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5372:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5373:6: lv_elseExpresssion_3_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionsAccess().getElseExpresssionLiteralOrExpressionParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseExpresssion_3_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionsRule());
                      						}
                      						set(
                      							current,
                      							"elseExpresssion",
                      							lv_elseExpresssion_3_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5392:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5392:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5393:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5393:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5394:5: lv_singleExpression_4_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConditionalExpressionsAccess().getSingleExpressionLiteralOrExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_singleExpression_4_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConditionalExpressionsRule());
                      					}
                      					set(
                      						current,
                      						"singleExpression",
                      						lv_singleExpression_4_0,
                      						"com.dexels.navajo.Navascript.LiteralOrExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpressions"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalNavascript.g:5415:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalNavascript.g:5415:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalNavascript.g:5416:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // InternalNavascript.g:5422:1: ruleConditionalExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5428:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5429:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5429:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5430:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConditionalExpressionAccess().getIfKeyword_0());
              		
            }
            // InternalNavascript.g:5434:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalNavascript.g:5435:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalNavascript.g:5435:4: (lv_condition_1_0= ruleExpression )
            // InternalNavascript.g:5436:5: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_condition_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getThenKeyword_2());
              		
            }
            // InternalNavascript.g:5457:3: ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5458:4: (lv_expression_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5458:4: (lv_expression_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5459:5: lv_expression_3_0= ruleLiteralOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConditionalExpressionAccess().getExpressionLiteralOrExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"com.dexels.navajo.Navascript.LiteralOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalNavascript.g:5480:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalNavascript.g:5480:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalNavascript.g:5481:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalNavascript.g:5487:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5493:2: (this_BooleanExpression_0= ruleBooleanExpression )
            // InternalNavascript.g:5494:2: this_BooleanExpression_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_BooleanExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalNavascript.g:5505:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalNavascript.g:5505:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalNavascript.g:5506:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalNavascript.g:5512:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5518:2: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalNavascript.g:5519:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalNavascript.g:5519:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalNavascript.g:5520:3: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_62);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5528:3: ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( ((LA101_0>=78 && LA101_0<=79)) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalNavascript.g:5529:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalNavascript.g:5529:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) )
            	    // InternalNavascript.g:5530:5: () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    {
            	    // InternalNavascript.g:5530:5: ()
            	    // InternalNavascript.g:5531:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5537:5: ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    // InternalNavascript.g:5538:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    {
            	    // InternalNavascript.g:5538:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    // InternalNavascript.g:5539:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    {
            	    // InternalNavascript.g:5539:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    int alt100=2;
            	    int LA100_0 = input.LA(1);

            	    if ( (LA100_0==78) ) {
            	        alt100=1;
            	    }
            	    else if ( (LA100_0==79) ) {
            	        alt100=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 100, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt100) {
            	        case 1 :
            	            // InternalNavascript.g:5540:8: lv_op_2_1= 'OR'
            	            {
            	            lv_op_2_1=(Token)match(input,78,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getBooleanExpressionAccess().getOpORKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:5551:8: lv_op_2_2= 'AND'
            	            {
            	            lv_op_2_2=(Token)match(input,79,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getBooleanExpressionAccess().getOpANDKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalNavascript.g:5565:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalNavascript.g:5566:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalNavascript.g:5566:5: (lv_right_3_0= ruleComparison )
            	    // InternalNavascript.g:5567:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.dexels.navajo.Navascript.Comparison");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleComparison"
    // InternalNavascript.g:5589:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalNavascript.g:5589:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalNavascript.g:5590:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalNavascript.g:5596:1: ruleComparison returns [EObject current=null] : (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Equals_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5602:2: ( (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) )
            // InternalNavascript.g:5603:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            {
            // InternalNavascript.g:5603:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            // InternalNavascript.g:5604:3: this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getEqualsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_63);
            this_Equals_0=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Equals_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5612:3: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( ((LA103_0>=80 && LA103_0<=83)) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // InternalNavascript.g:5613:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) )
            	    {
            	    // InternalNavascript.g:5613:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) )
            	    // InternalNavascript.g:5614:5: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    {
            	    // InternalNavascript.g:5614:5: ()
            	    // InternalNavascript.g:5615:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5621:5: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalNavascript.g:5622:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalNavascript.g:5622:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalNavascript.g:5623:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalNavascript.g:5623:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt102=4;
            	    switch ( input.LA(1) ) {
            	    case 80:
            	        {
            	        alt102=1;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt102=2;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt102=3;
            	        }
            	        break;
            	    case 83:
            	        {
            	        alt102=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 102, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt102) {
            	        case 1 :
            	            // InternalNavascript.g:5624:8: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,80,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:5635:8: lv_op_2_2= '>'
            	            {
            	            lv_op_2_2=(Token)match(input,81,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalNavascript.g:5646:8: lv_op_2_3= '<='
            	            {
            	            lv_op_2_3=(Token)match(input,82,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_0_1_0_2());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalNavascript.g:5657:8: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,83,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1_0_3());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalNavascript.g:5671:4: ( (lv_right_3_0= ruleEquals ) )
            	    // InternalNavascript.g:5672:5: (lv_right_3_0= ruleEquals )
            	    {
            	    // InternalNavascript.g:5672:5: (lv_right_3_0= ruleEquals )
            	    // InternalNavascript.g:5673:6: lv_right_3_0= ruleEquals
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightEqualsParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_63);
            	    lv_right_3_0=ruleEquals();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.dexels.navajo.Navascript.Equals");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleEquals"
    // InternalNavascript.g:5695:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalNavascript.g:5695:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalNavascript.g:5696:2: iv_ruleEquals= ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquals=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquals; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalNavascript.g:5702:1: ruleEquals returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5708:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalNavascript.g:5709:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalNavascript.g:5709:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalNavascript.g:5710:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualsAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_64);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5718:3: ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( ((LA105_0>=84 && LA105_0<=85)) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalNavascript.g:5719:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalNavascript.g:5719:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) )
            	    // InternalNavascript.g:5720:5: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    {
            	    // InternalNavascript.g:5720:5: ()
            	    // InternalNavascript.g:5721:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5727:5: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalNavascript.g:5728:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalNavascript.g:5728:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalNavascript.g:5729:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalNavascript.g:5729:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt104=2;
            	    int LA104_0 = input.LA(1);

            	    if ( (LA104_0==84) ) {
            	        alt104=1;
            	    }
            	    else if ( (LA104_0==85) ) {
            	        alt104=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 104, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt104) {
            	        case 1 :
            	            // InternalNavascript.g:5730:8: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,84,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:5741:8: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,85,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getEqualsAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalNavascript.g:5755:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalNavascript.g:5756:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalNavascript.g:5756:5: (lv_right_3_0= ruleAddition )
            	    // InternalNavascript.g:5757:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualsAccess().getRightAdditionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_64);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualsRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.dexels.navajo.Navascript.Addition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleAddition"
    // InternalNavascript.g:5779:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalNavascript.g:5779:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalNavascript.g:5780:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalNavascript.g:5786:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5792:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalNavascript.g:5793:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalNavascript.g:5793:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalNavascript.g:5794:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_65);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5802:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==75||LA107_0==86) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalNavascript.g:5803:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalNavascript.g:5803:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt106=2;
            	    int LA106_0 = input.LA(1);

            	    if ( (LA106_0==75) ) {
            	        alt106=1;
            	    }
            	    else if ( (LA106_0==86) ) {
            	        alt106=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 106, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt106) {
            	        case 1 :
            	            // InternalNavascript.g:5804:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalNavascript.g:5804:5: ( () otherlv_2= '+' )
            	            // InternalNavascript.g:5805:6: () otherlv_2= '+'
            	            {
            	            // InternalNavascript.g:5805:6: ()
            	            // InternalNavascript.g:5806:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_2=(Token)match(input,75,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:5818:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalNavascript.g:5818:5: ( () otherlv_4= '-' )
            	            // InternalNavascript.g:5819:6: () otherlv_4= '-'
            	            {
            	            // InternalNavascript.g:5819:6: ()
            	            // InternalNavascript.g:5820:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_4=(Token)match(input,86,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // InternalNavascript.g:5832:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalNavascript.g:5833:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalNavascript.g:5833:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalNavascript.g:5834:6: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_65);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"com.dexels.navajo.Navascript.Multiplication");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalNavascript.g:5856:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalNavascript.g:5856:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalNavascript.g:5857:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalNavascript.g:5863:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5869:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalNavascript.g:5870:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalNavascript.g:5870:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalNavascript.g:5871:3: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_66);
            this_Prefixed_0=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prefixed_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5879:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( ((LA109_0>=87 && LA109_0<=88)) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalNavascript.g:5880:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalNavascript.g:5880:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalNavascript.g:5881:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalNavascript.g:5881:5: ()
            	    // InternalNavascript.g:5882:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5888:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalNavascript.g:5889:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalNavascript.g:5889:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalNavascript.g:5890:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalNavascript.g:5890:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt108=2;
            	    int LA108_0 = input.LA(1);

            	    if ( (LA108_0==87) ) {
            	        alt108=1;
            	    }
            	    else if ( (LA108_0==88) ) {
            	        alt108=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 108, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt108) {
            	        case 1 :
            	            // InternalNavascript.g:5891:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,87,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:5902:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,88,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalNavascript.g:5916:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalNavascript.g:5917:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalNavascript.g:5917:5: (lv_right_3_0= rulePrefixed )
            	    // InternalNavascript.g:5918:6: lv_right_3_0= rulePrefixed
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_66);
            	    lv_right_3_0=rulePrefixed();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.dexels.navajo.Navascript.Prefixed");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrefixed"
    // InternalNavascript.g:5940:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalNavascript.g:5940:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalNavascript.g:5941:2: iv_rulePrefixed= rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixed=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixed; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // InternalNavascript.g:5947:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5953:2: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalNavascript.g:5954:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalNavascript.g:5954:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt110=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt110=1;
                }
                break;
            case 86:
                {
                alt110=2;
                }
                break;
            case RULE_ARGS_START:
            case RULE_IDENTIFIER:
            case RULE_MAPPABLE_IDENTIFIER:
            case RULE_TML_LITERAL:
            case RULE_INTEGER:
            case RULE_STRING_LITERAL:
            case RULE_TRUE:
            case RULE_FALSE:
            case RULE_NULL_DEF:
            case RULE_FORALL:
            case RULE_EXISTS:
            case 90:
                {
                alt110=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalNavascript.g:5955:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:5955:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalNavascript.g:5956:4: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:5956:4: ()
                    // InternalNavascript.g:5957:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5963:4: ( ( '!' )=>otherlv_1= '!' )
                    // InternalNavascript.g:5964:5: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      				
                    }

                    }

                    // InternalNavascript.g:5970:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalNavascript.g:5971:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalNavascript.g:5971:5: (lv_expression_2_0= ruleAtomic )
                    // InternalNavascript.g:5972:6: lv_expression_2_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"com.dexels.navajo.Navascript.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5991:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:5991:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalNavascript.g:5992:4: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:5992:4: ()
                    // InternalNavascript.g:5993:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5999:4: ( ( '-' )=>otherlv_4= '-' )
                    // InternalNavascript.g:6000:5: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,86,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      				
                    }

                    }

                    // InternalNavascript.g:6006:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalNavascript.g:6007:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalNavascript.g:6007:5: (lv_expression_5_0= ruleAtomic )
                    // InternalNavascript.g:6008:6: lv_expression_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_5_0,
                      							"com.dexels.navajo.Navascript.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6027:3: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Atomic_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // InternalNavascript.g:6039:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalNavascript.g:6039:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalNavascript.g:6040:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalNavascript.g:6046:1: ruleAtomic returns [EObject current=null] : ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token this_ARGS_START_1=null;
        Token this_ARGS_END_3=null;
        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_1=null;
        Token lv_value_9_2=null;
        Token lv_hasExists_15_0=null;
        Token lv_value_20_0=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_11_0 = null;

        EObject lv_value_13_0 = null;

        EObject lv_value_16_0 = null;

        EObject lv_value_18_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6052:2: ( ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) )
            // InternalNavascript.g:6053:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            {
            // InternalNavascript.g:6053:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            int alt113=9;
            switch ( input.LA(1) ) {
            case RULE_ARGS_START:
                {
                alt113=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt113=2;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt113=3;
                }
                break;
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt113=4;
                }
                break;
            case RULE_IDENTIFIER:
                {
                alt113=5;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt113=6;
                }
                break;
            case RULE_TML_LITERAL:
            case 90:
                {
                alt113=7;
                }
                break;
            case RULE_FORALL:
            case RULE_EXISTS:
                {
                alt113=8;
                }
                break;
            case RULE_NULL_DEF:
                {
                alt113=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalNavascript.g:6054:3: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END )
                    {
                    // InternalNavascript.g:6054:3: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END )
                    // InternalNavascript.g:6055:4: () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END
                    {
                    // InternalNavascript.g:6055:4: ()
                    // InternalNavascript.g:6056:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getExpressionLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    this_ARGS_START_1=(Token)match(input,RULE_ARGS_START,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_1, grammarAccess.getAtomicAccess().getARGS_STARTTerminalRuleCall_0_1());
                      			
                    }
                    // InternalNavascript.g:6066:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalNavascript.g:6067:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:6067:5: (lv_value_2_0= ruleExpression )
                    // InternalNavascript.g:6068:6: lv_value_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_value_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_3=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_3, grammarAccess.getAtomicAccess().getARGS_ENDTerminalRuleCall_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6091:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    {
                    // InternalNavascript.g:6091:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    // InternalNavascript.g:6092:4: () ( (lv_value_5_0= RULE_INTEGER ) )
                    {
                    // InternalNavascript.g:6092:4: ()
                    // InternalNavascript.g:6093:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6099:4: ( (lv_value_5_0= RULE_INTEGER ) )
                    // InternalNavascript.g:6100:5: (lv_value_5_0= RULE_INTEGER )
                    {
                    // InternalNavascript.g:6100:5: (lv_value_5_0= RULE_INTEGER )
                    // InternalNavascript.g:6101:6: lv_value_5_0= RULE_INTEGER
                    {
                    lv_value_5_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_5_0, grammarAccess.getAtomicAccess().getValueINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_5_0,
                      							"com.dexels.navajo.Navascript.INTEGER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6119:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    {
                    // InternalNavascript.g:6119:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    // InternalNavascript.g:6120:4: () ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    {
                    // InternalNavascript.g:6120:4: ()
                    // InternalNavascript.g:6121:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getStringLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6127:4: ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    // InternalNavascript.g:6128:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    {
                    // InternalNavascript.g:6128:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    // InternalNavascript.g:6129:6: lv_value_7_0= RULE_STRING_LITERAL
                    {
                    lv_value_7_0=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_7_0, grammarAccess.getAtomicAccess().getValueSTRING_LITERALTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_7_0,
                      							"com.dexels.navajo.Navascript.STRING_LITERAL");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:6147:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    {
                    // InternalNavascript.g:6147:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    // InternalNavascript.g:6148:4: () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    {
                    // InternalNavascript.g:6148:4: ()
                    // InternalNavascript.g:6149:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6155:4: ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    // InternalNavascript.g:6156:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    {
                    // InternalNavascript.g:6156:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    // InternalNavascript.g:6157:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    {
                    // InternalNavascript.g:6157:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==RULE_TRUE) ) {
                        alt111=1;
                    }
                    else if ( (LA111_0==RULE_FALSE) ) {
                        alt111=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalNavascript.g:6158:7: lv_value_9_1= RULE_TRUE
                            {
                            lv_value_9_1=(Token)match(input,RULE_TRUE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_9_1, grammarAccess.getAtomicAccess().getValueTRUETerminalRuleCall_3_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"value",
                              								lv_value_9_1,
                              								"com.dexels.navajo.Navascript.TRUE");
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:6173:7: lv_value_9_2= RULE_FALSE
                            {
                            lv_value_9_2=(Token)match(input,RULE_FALSE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_9_2, grammarAccess.getAtomicAccess().getValueFALSETerminalRuleCall_3_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"value",
                              								lv_value_9_2,
                              								"com.dexels.navajo.Navascript.FALSE");
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:6192:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    {
                    // InternalNavascript.g:6192:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    // InternalNavascript.g:6193:4: () ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    {
                    // InternalNavascript.g:6193:4: ()
                    // InternalNavascript.g:6194:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getFunctionCallLiteralAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6200:4: ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    // InternalNavascript.g:6201:5: (lv_value_11_0= ruleFunctionIdentifier )
                    {
                    // InternalNavascript.g:6201:5: (lv_value_11_0= ruleFunctionIdentifier )
                    // InternalNavascript.g:6202:6: lv_value_11_0= ruleFunctionIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueFunctionIdentifierParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_11_0=ruleFunctionIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_11_0,
                      							"com.dexels.navajo.Navascript.FunctionIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalNavascript.g:6221:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    {
                    // InternalNavascript.g:6221:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    // InternalNavascript.g:6222:4: () ( (lv_value_13_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:6222:4: ()
                    // InternalNavascript.g:6223:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getMappableIdentifierLiteralAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6229:4: ( (lv_value_13_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:6230:5: (lv_value_13_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:6230:5: (lv_value_13_0= ruleMappableIdentifier )
                    // InternalNavascript.g:6231:6: lv_value_13_0= ruleMappableIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueMappableIdentifierParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_13_0=ruleMappableIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_13_0,
                      							"com.dexels.navajo.Navascript.MappableIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalNavascript.g:6250:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    {
                    // InternalNavascript.g:6250:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    // InternalNavascript.g:6251:4: () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:6251:4: ()
                    // InternalNavascript.g:6252:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getTmlIdentifierLiteralAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6258:4: ( (lv_hasExists_15_0= '?' ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==90) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // InternalNavascript.g:6259:5: (lv_hasExists_15_0= '?' )
                            {
                            // InternalNavascript.g:6259:5: (lv_hasExists_15_0= '?' )
                            // InternalNavascript.g:6260:6: lv_hasExists_15_0= '?'
                            {
                            lv_hasExists_15_0=(Token)match(input,90,FOLLOW_67); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_hasExists_15_0, grammarAccess.getAtomicAccess().getHasExistsQuestionMarkKeyword_6_1_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getAtomicRule());
                              						}
                              						setWithLastConsumed(current, "hasExists", lv_hasExists_15_0 != null, "?");
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalNavascript.g:6272:4: ( (lv_value_16_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:6273:5: (lv_value_16_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:6273:5: (lv_value_16_0= ruleTmlIdentifier )
                    // InternalNavascript.g:6274:6: lv_value_16_0= ruleTmlIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueTmlIdentifierParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_16_0=ruleTmlIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_16_0,
                      							"com.dexels.navajo.Navascript.TmlIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalNavascript.g:6293:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    {
                    // InternalNavascript.g:6293:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    // InternalNavascript.g:6294:4: () ( (lv_value_18_0= ruleForAllIdentifier ) )
                    {
                    // InternalNavascript.g:6294:4: ()
                    // InternalNavascript.g:6295:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getForAllLiteralAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6301:4: ( (lv_value_18_0= ruleForAllIdentifier ) )
                    // InternalNavascript.g:6302:5: (lv_value_18_0= ruleForAllIdentifier )
                    {
                    // InternalNavascript.g:6302:5: (lv_value_18_0= ruleForAllIdentifier )
                    // InternalNavascript.g:6303:6: lv_value_18_0= ruleForAllIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueForAllIdentifierParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_18_0=ruleForAllIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_18_0,
                      							"com.dexels.navajo.Navascript.ForAllIdentifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalNavascript.g:6322:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    {
                    // InternalNavascript.g:6322:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    // InternalNavascript.g:6323:4: () ( (lv_value_20_0= RULE_NULL_DEF ) )
                    {
                    // InternalNavascript.g:6323:4: ()
                    // InternalNavascript.g:6324:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNullLiteralAction_8_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6330:4: ( (lv_value_20_0= RULE_NULL_DEF ) )
                    // InternalNavascript.g:6331:5: (lv_value_20_0= RULE_NULL_DEF )
                    {
                    // InternalNavascript.g:6331:5: (lv_value_20_0= RULE_NULL_DEF )
                    // InternalNavascript.g:6332:6: lv_value_20_0= RULE_NULL_DEF
                    {
                    lv_value_20_0=(Token)match(input,RULE_NULL_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_20_0, grammarAccess.getAtomicAccess().getValueNULL_DEFTerminalRuleCall_8_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_20_0,
                      							"com.dexels.navajo.Navascript.NULL_DEF");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleForAllIdentifier"
    // InternalNavascript.g:6353:1: entryRuleForAllIdentifier returns [EObject current=null] : iv_ruleForAllIdentifier= ruleForAllIdentifier EOF ;
    public final EObject entryRuleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllIdentifier = null;


        try {
            // InternalNavascript.g:6353:57: (iv_ruleForAllIdentifier= ruleForAllIdentifier EOF )
            // InternalNavascript.g:6354:2: iv_ruleForAllIdentifier= ruleForAllIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForAllIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForAllIdentifier=ruleForAllIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForAllIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForAllIdentifier"


    // $ANTLR start "ruleForAllIdentifier"
    // InternalNavascript.g:6360:1: ruleForAllIdentifier returns [EObject current=null] : ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END ) ;
    public final EObject ruleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token this_ARGS_START_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_messagedefinition_7_0=null;
        Token this_ARGS_END_8=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6366:2: ( ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END ) )
            // InternalNavascript.g:6367:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END )
            {
            // InternalNavascript.g:6367:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END )
            // InternalNavascript.g:6368:3: () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END
            {
            // InternalNavascript.g:6368:3: ()
            // InternalNavascript.g:6369:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getForAllIdentifierAccess().getForAllIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6375:3: ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) )
            // InternalNavascript.g:6376:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            {
            // InternalNavascript.g:6376:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            // InternalNavascript.g:6377:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            {
            // InternalNavascript.g:6377:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_FORALL) ) {
                alt114=1;
            }
            else if ( (LA114_0==RULE_EXISTS) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // InternalNavascript.g:6378:6: lv_op_1_1= RULE_FORALL
                    {
                    lv_op_1_1=(Token)match(input,RULE_FORALL,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_1, grammarAccess.getForAllIdentifierAccess().getOpFORALLTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForAllIdentifierRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_1_1,
                      							"com.dexels.navajo.Navascript.FORALL");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6393:6: lv_op_1_2= RULE_EXISTS
                    {
                    lv_op_1_2=(Token)match(input,RULE_EXISTS,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_2, grammarAccess.getForAllIdentifierAccess().getOpEXISTSTerminalRuleCall_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getForAllIdentifierRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"op",
                      							lv_op_1_2,
                      							"com.dexels.navajo.Navascript.EXISTS");
                      					
                    }

                    }
                    break;

            }


            }


            }

            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_START_2, grammarAccess.getForAllIdentifierAccess().getARGS_STARTTerminalRuleCall_2());
              		
            }
            otherlv_3=(Token)match(input,91,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_3());
              		
            }
            // InternalNavascript.g:6418:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalNavascript.g:6419:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalNavascript.g:6419:4: (lv_expression_4_0= ruleExpression )
            // InternalNavascript.g:6420:5: lv_expression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForAllIdentifierAccess().getExpressionExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_68);
            lv_expression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForAllIdentifierRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_4_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,91,FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,63,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getForAllIdentifierAccess().getCommaKeyword_6());
              		
            }
            // InternalNavascript.g:6445:3: ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) )
            // InternalNavascript.g:6446:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            {
            // InternalNavascript.g:6446:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            // InternalNavascript.g:6447:5: lv_messagedefinition_7_0= RULE_STRING_LITERAL
            {
            lv_messagedefinition_7_0=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_messagedefinition_7_0, grammarAccess.getForAllIdentifierAccess().getMessagedefinitionSTRING_LITERALTerminalRuleCall_7_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getForAllIdentifierRule());
              					}
              					setWithLastConsumed(
              						current,
              						"messagedefinition",
              						lv_messagedefinition_7_0,
              						"com.dexels.navajo.Navascript.STRING_LITERAL");
              				
            }

            }


            }

            this_ARGS_END_8=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARGS_END_8, grammarAccess.getForAllIdentifierAccess().getARGS_ENDTerminalRuleCall_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAllIdentifier"


    // $ANTLR start "entryRuleFunctionIdentifier"
    // InternalNavascript.g:6471:1: entryRuleFunctionIdentifier returns [EObject current=null] : iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF ;
    public final EObject entryRuleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionIdentifier = null;


        try {
            // InternalNavascript.g:6471:59: (iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF )
            // InternalNavascript.g:6472:2: iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionIdentifier=ruleFunctionIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionIdentifier"


    // $ANTLR start "ruleFunctionIdentifier"
    // InternalNavascript.g:6478:1: ruleFunctionIdentifier returns [EObject current=null] : ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) ) ;
    public final EObject ruleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_func_1_0=null;
        Token this_ARGS_START_2=null;
        Token otherlv_4=null;
        Token this_ARGS_END_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6484:2: ( ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) ) )
            // InternalNavascript.g:6485:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) )
            {
            // InternalNavascript.g:6485:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) )
            // InternalNavascript.g:6486:3: () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )
            {
            // InternalNavascript.g:6486:3: ()
            // InternalNavascript.g:6487:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionIdentifierAccess().getFunctionIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6493:3: ( (lv_func_1_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:6494:4: (lv_func_1_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:6494:4: (lv_func_1_0= RULE_IDENTIFIER )
            // InternalNavascript.g:6495:5: lv_func_1_0= RULE_IDENTIFIER
            {
            lv_func_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_func_1_0, grammarAccess.getFunctionIdentifierAccess().getFuncIDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionIdentifierRule());
              					}
              					setWithLastConsumed(
              						current,
              						"func",
              						lv_func_1_0,
              						"com.dexels.navajo.Navascript.IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:6511:3: (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )
            // InternalNavascript.g:6512:4: this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END
            {
            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_ARGS_START_2, grammarAccess.getFunctionIdentifierAccess().getARGS_STARTTerminalRuleCall_2_0());
              			
            }
            // InternalNavascript.g:6516:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==RULE_ARGS_START||LA116_0==RULE_IDENTIFIER||(LA116_0>=RULE_MAPPABLE_IDENTIFIER && LA116_0<=RULE_TML_LITERAL)||LA116_0==RULE_INTEGER||(LA116_0>=RULE_STRING_LITERAL && LA116_0<=RULE_EXISTS)||LA116_0==86||(LA116_0>=89 && LA116_0<=90)) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalNavascript.g:6517:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalNavascript.g:6517:5: ( (lv_args_3_0= ruleExpression ) )
                    // InternalNavascript.g:6518:6: (lv_args_3_0= ruleExpression )
                    {
                    // InternalNavascript.g:6518:6: (lv_args_3_0= ruleExpression )
                    // InternalNavascript.g:6519:7: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionIdentifierAccess().getArgsExpressionParserRuleCall_2_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_28);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getFunctionIdentifierRule());
                      							}
                      							add(
                      								current,
                      								"args",
                      								lv_args_3_0,
                      								"com.dexels.navajo.Navascript.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalNavascript.g:6536:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==63) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalNavascript.g:6537:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getFunctionIdentifierAccess().getCommaKeyword_2_1_1_0());
                    	      					
                    	    }
                    	    // InternalNavascript.g:6541:6: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalNavascript.g:6542:7: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalNavascript.g:6542:7: (lv_args_5_0= ruleExpression )
                    	    // InternalNavascript.g:6543:8: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getFunctionIdentifierAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_28);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getFunctionIdentifierRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"args",
                    	      									lv_args_5_0,
                    	      									"com.dexels.navajo.Navascript.Expression");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);


                    }
                    break;

            }

            this_ARGS_END_6=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_ARGS_END_6, grammarAccess.getFunctionIdentifierAccess().getARGS_ENDTerminalRuleCall_2_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionIdentifier"


    // $ANTLR start "entryRuleMappableIdentifier"
    // InternalNavascript.g:6571:1: entryRuleMappableIdentifier returns [EObject current=null] : iv_ruleMappableIdentifier= ruleMappableIdentifier EOF ;
    public final EObject entryRuleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappableIdentifier = null;


        try {
            // InternalNavascript.g:6571:59: (iv_ruleMappableIdentifier= ruleMappableIdentifier EOF )
            // InternalNavascript.g:6572:2: iv_ruleMappableIdentifier= ruleMappableIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappableIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMappableIdentifier=ruleMappableIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappableIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappableIdentifier"


    // $ANTLR start "ruleMappableIdentifier"
    // InternalNavascript.g:6578:1: ruleMappableIdentifier returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? ) ;
    public final EObject ruleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token this_ARGS_START_2=null;
        Token otherlv_4=null;
        Token this_ARGS_END_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6584:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? ) )
            // InternalNavascript.g:6585:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? )
            {
            // InternalNavascript.g:6585:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? )
            // InternalNavascript.g:6586:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )?
            {
            // InternalNavascript.g:6586:3: ()
            // InternalNavascript.g:6587:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappableIdentifierAccess().getMappableIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6593:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:6594:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:6594:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:6595:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_field_1_0, grammarAccess.getMappableIdentifierAccess().getFieldMAPPABLE_IDENTIFIERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMappableIdentifierRule());
              					}
              					setWithLastConsumed(
              						current,
              						"field",
              						lv_field_1_0,
              						"com.dexels.navajo.Navascript.MAPPABLE_IDENTIFIER");
              				
            }

            }


            }

            // InternalNavascript.g:6611:3: (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==RULE_ARGS_START) ) {
                int LA119_1 = input.LA(2);

                if ( ((LA119_1>=RULE_ARGS_START && LA119_1<=RULE_ARGS_END)||LA119_1==RULE_IDENTIFIER||(LA119_1>=RULE_MAPPABLE_IDENTIFIER && LA119_1<=RULE_TML_LITERAL)||LA119_1==RULE_INTEGER||(LA119_1>=RULE_STRING_LITERAL && LA119_1<=RULE_EXISTS)||LA119_1==86||(LA119_1>=89 && LA119_1<=90)) ) {
                    alt119=1;
                }
            }
            switch (alt119) {
                case 1 :
                    // InternalNavascript.g:6612:4: this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappableIdentifierAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    // InternalNavascript.g:6616:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==RULE_ARGS_START||LA118_0==RULE_IDENTIFIER||(LA118_0>=RULE_MAPPABLE_IDENTIFIER && LA118_0<=RULE_TML_LITERAL)||LA118_0==RULE_INTEGER||(LA118_0>=RULE_STRING_LITERAL && LA118_0<=RULE_EXISTS)||LA118_0==86||(LA118_0>=89 && LA118_0<=90)) ) {
                        alt118=1;
                    }
                    switch (alt118) {
                        case 1 :
                            // InternalNavascript.g:6617:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // InternalNavascript.g:6617:5: ( (lv_args_3_0= ruleExpression ) )
                            // InternalNavascript.g:6618:6: (lv_args_3_0= ruleExpression )
                            {
                            // InternalNavascript.g:6618:6: (lv_args_3_0= ruleExpression )
                            // InternalNavascript.g:6619:7: lv_args_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMappableIdentifierAccess().getArgsExpressionParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_28);
                            lv_args_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getMappableIdentifierRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_3_0,
                              								"com.dexels.navajo.Navascript.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalNavascript.g:6636:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            loop117:
                            do {
                                int alt117=2;
                                int LA117_0 = input.LA(1);

                                if ( (LA117_0==63) ) {
                                    alt117=1;
                                }


                                switch (alt117) {
                            	case 1 :
                            	    // InternalNavascript.g:6637:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,63,FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getMappableIdentifierAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalNavascript.g:6641:6: ( (lv_args_5_0= ruleExpression ) )
                            	    // InternalNavascript.g:6642:7: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // InternalNavascript.g:6642:7: (lv_args_5_0= ruleExpression )
                            	    // InternalNavascript.g:6643:8: lv_args_5_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getMappableIdentifierAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_28);
                            	    lv_args_5_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getMappableIdentifierRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_5_0,
                            	      									"com.dexels.navajo.Navascript.Expression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop117;
                                }
                            } while (true);


                            }
                            break;

                    }

                    this_ARGS_END_6=(Token)match(input,RULE_ARGS_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_6, grammarAccess.getMappableIdentifierAccess().getARGS_ENDTerminalRuleCall_2_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappableIdentifier"


    // $ANTLR start "entryRuleTmlIdentifier"
    // InternalNavascript.g:6671:1: entryRuleTmlIdentifier returns [EObject current=null] : iv_ruleTmlIdentifier= ruleTmlIdentifier EOF ;
    public final EObject entryRuleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmlIdentifier = null;


        try {
            // InternalNavascript.g:6671:54: (iv_ruleTmlIdentifier= ruleTmlIdentifier EOF )
            // InternalNavascript.g:6672:2: iv_ruleTmlIdentifier= ruleTmlIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTmlIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTmlIdentifier=ruleTmlIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTmlIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTmlIdentifier"


    // $ANTLR start "ruleTmlIdentifier"
    // InternalNavascript.g:6678:1: ruleTmlIdentifier returns [EObject current=null] : ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) ;
    public final EObject ruleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_tml_1_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:6684:2: ( ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) )
            // InternalNavascript.g:6685:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            {
            // InternalNavascript.g:6685:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            // InternalNavascript.g:6686:3: () ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            {
            // InternalNavascript.g:6686:3: ()
            // InternalNavascript.g:6687:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTmlIdentifierAccess().getTmlIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6693:3: ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:6694:4: (lv_tml_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:6694:4: (lv_tml_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:6695:5: lv_tml_1_0= RULE_TML_LITERAL
            {
            lv_tml_1_0=(Token)match(input,RULE_TML_LITERAL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_tml_1_0, grammarAccess.getTmlIdentifierAccess().getTmlTML_LITERALTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTmlIdentifierRule());
              					}
              					setWithLastConsumed(
              						current,
              						"tml",
              						lv_tml_1_0,
              						"com.dexels.navajo.Navascript.TML_LITERAL");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTmlIdentifier"


    // $ANTLR start "entryRulePropertyType"
    // InternalNavascript.g:6715:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // InternalNavascript.g:6715:53: (iv_rulePropertyType= rulePropertyType EOF )
            // InternalNavascript.g:6716:2: iv_rulePropertyType= rulePropertyType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyType=rulePropertyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyType"


    // $ANTLR start "rulePropertyType"
    // InternalNavascript.g:6722:1: rulePropertyType returns [EObject current=null] : ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) ;
    public final EObject rulePropertyType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;


        	enterRule();

        try {
            // InternalNavascript.g:6728:2: ( ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) )
            // InternalNavascript.g:6729:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            {
            // InternalNavascript.g:6729:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            int alt120=11;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt120=1;
                }
                break;
            case 93:
                {
                alt120=2;
                }
                break;
            case 94:
                {
                alt120=3;
                }
                break;
            case 95:
                {
                alt120=4;
                }
                break;
            case 96:
                {
                alt120=5;
                }
                break;
            case 97:
                {
                alt120=6;
                }
                break;
            case 98:
                {
                alt120=7;
                }
                break;
            case 99:
                {
                alt120=8;
                }
                break;
            case 100:
                {
                alt120=9;
                }
                break;
            case 101:
                {
                alt120=10;
                }
                break;
            case 102:
                {
                alt120=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalNavascript.g:6730:3: ( () otherlv_1= 'integer' )
                    {
                    // InternalNavascript.g:6730:3: ( () otherlv_1= 'integer' )
                    // InternalNavascript.g:6731:4: () otherlv_1= 'integer'
                    {
                    // InternalNavascript.g:6731:4: ()
                    // InternalNavascript.g:6732:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getIntTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPropertyTypeAccess().getIntegerKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6744:3: ( () otherlv_3= 'string' )
                    {
                    // InternalNavascript.g:6744:3: ( () otherlv_3= 'string' )
                    // InternalNavascript.g:6745:4: () otherlv_3= 'string'
                    {
                    // InternalNavascript.g:6745:4: ()
                    // InternalNavascript.g:6746:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getStringTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPropertyTypeAccess().getStringKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6758:3: ( () otherlv_5= 'boolean' )
                    {
                    // InternalNavascript.g:6758:3: ( () otherlv_5= 'boolean' )
                    // InternalNavascript.g:6759:4: () otherlv_5= 'boolean'
                    {
                    // InternalNavascript.g:6759:4: ()
                    // InternalNavascript.g:6760:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getBooleanTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPropertyTypeAccess().getBooleanKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:6772:3: ( () otherlv_7= 'date' )
                    {
                    // InternalNavascript.g:6772:3: ( () otherlv_7= 'date' )
                    // InternalNavascript.g:6773:4: () otherlv_7= 'date'
                    {
                    // InternalNavascript.g:6773:4: ()
                    // InternalNavascript.g:6774:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getDateTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPropertyTypeAccess().getDateKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:6786:3: ( () otherlv_9= 'float' )
                    {
                    // InternalNavascript.g:6786:3: ( () otherlv_9= 'float' )
                    // InternalNavascript.g:6787:4: () otherlv_9= 'float'
                    {
                    // InternalNavascript.g:6787:4: ()
                    // InternalNavascript.g:6788:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getFloatTypeAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPropertyTypeAccess().getFloatKeyword_4_1());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalNavascript.g:6800:3: ( () otherlv_11= 'binary' )
                    {
                    // InternalNavascript.g:6800:3: ( () otherlv_11= 'binary' )
                    // InternalNavascript.g:6801:4: () otherlv_11= 'binary'
                    {
                    // InternalNavascript.g:6801:4: ()
                    // InternalNavascript.g:6802:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getBinaryTypeAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPropertyTypeAccess().getBinaryKeyword_5_1());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalNavascript.g:6814:3: ( () otherlv_13= 'clocktime' )
                    {
                    // InternalNavascript.g:6814:3: ( () otherlv_13= 'clocktime' )
                    // InternalNavascript.g:6815:4: () otherlv_13= 'clocktime'
                    {
                    // InternalNavascript.g:6815:4: ()
                    // InternalNavascript.g:6816:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getClockTimeTypeAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getPropertyTypeAccess().getClocktimeKeyword_6_1());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalNavascript.g:6828:3: ( () otherlv_15= 'memo' )
                    {
                    // InternalNavascript.g:6828:3: ( () otherlv_15= 'memo' )
                    // InternalNavascript.g:6829:4: () otherlv_15= 'memo'
                    {
                    // InternalNavascript.g:6829:4: ()
                    // InternalNavascript.g:6830:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getMemoTypeAction_7_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_15=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getPropertyTypeAccess().getMemoKeyword_7_1());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalNavascript.g:6842:3: ( () otherlv_17= 'timestamp' )
                    {
                    // InternalNavascript.g:6842:3: ( () otherlv_17= 'timestamp' )
                    // InternalNavascript.g:6843:4: () otherlv_17= 'timestamp'
                    {
                    // InternalNavascript.g:6843:4: ()
                    // InternalNavascript.g:6844:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getTimestampTypeAction_8_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_17=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getPropertyTypeAccess().getTimestampKeyword_8_1());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalNavascript.g:6856:3: ( () otherlv_19= 'percentage' )
                    {
                    // InternalNavascript.g:6856:3: ( () otherlv_19= 'percentage' )
                    // InternalNavascript.g:6857:4: () otherlv_19= 'percentage'
                    {
                    // InternalNavascript.g:6857:4: ()
                    // InternalNavascript.g:6858:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getPercentageTypeAction_9_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_19=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getPropertyTypeAccess().getPercentageKeyword_9_1());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalNavascript.g:6870:3: ( () otherlv_21= 'selection' )
                    {
                    // InternalNavascript.g:6870:3: ( () otherlv_21= 'selection' )
                    // InternalNavascript.g:6871:4: () otherlv_21= 'selection'
                    {
                    // InternalNavascript.g:6871:4: ()
                    // InternalNavascript.g:6872:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getSelectionTypeAction_10_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_21=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getPropertyTypeAccess().getSelectionKeyword_10_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyType"


    // $ANTLR start "entryRuleOPTION_TYPE"
    // InternalNavascript.g:6887:1: entryRuleOPTION_TYPE returns [String current=null] : iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF ;
    public final String entryRuleOPTION_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOPTION_TYPE = null;


        try {
            // InternalNavascript.g:6887:51: (iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF )
            // InternalNavascript.g:6888:2: iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOPTION_TYPERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOPTION_TYPE=ruleOPTION_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOPTION_TYPE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOPTION_TYPE"


    // $ANTLR start "ruleOPTION_TYPE"
    // InternalNavascript.g:6894:1: ruleOPTION_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'name' | kw= 'value' | kw= 'selected' ) ;
    public final AntlrDatatypeRuleToken ruleOPTION_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:6900:2: ( (kw= 'name' | kw= 'value' | kw= 'selected' ) )
            // InternalNavascript.g:6901:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            {
            // InternalNavascript.g:6901:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            int alt121=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt121=1;
                }
                break;
            case 104:
                {
                alt121=2;
                }
                break;
            case 105:
                {
                alt121=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalNavascript.g:6902:3: kw= 'name'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getNameKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6908:3: kw= 'value'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getValueKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6914:3: kw= 'selected'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getSelectedKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOPTION_TYPE"


    // $ANTLR start "entryRuleMessageType"
    // InternalNavascript.g:6923:1: entryRuleMessageType returns [EObject current=null] : iv_ruleMessageType= ruleMessageType EOF ;
    public final EObject entryRuleMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageType = null;


        try {
            // InternalNavascript.g:6923:52: (iv_ruleMessageType= ruleMessageType EOF )
            // InternalNavascript.g:6924:2: iv_ruleMessageType= ruleMessageType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageType=ruleMessageType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageType"


    // $ANTLR start "ruleMessageType"
    // InternalNavascript.g:6930:1: ruleMessageType returns [EObject current=null] : ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) ;
    public final EObject ruleMessageType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalNavascript.g:6936:2: ( ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) )
            // InternalNavascript.g:6937:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            {
            // InternalNavascript.g:6937:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            int alt122=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt122=1;
                }
                break;
            case 107:
                {
                alt122=2;
                }
                break;
            case 108:
                {
                alt122=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalNavascript.g:6938:3: ( () otherlv_1= 'array' )
                    {
                    // InternalNavascript.g:6938:3: ( () otherlv_1= 'array' )
                    // InternalNavascript.g:6939:4: () otherlv_1= 'array'
                    {
                    // InternalNavascript.g:6939:4: ()
                    // InternalNavascript.g:6940:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getArrayTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageTypeAccess().getArrayKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6952:3: ( () otherlv_3= 'simple' )
                    {
                    // InternalNavascript.g:6952:3: ( () otherlv_3= 'simple' )
                    // InternalNavascript.g:6953:4: () otherlv_3= 'simple'
                    {
                    // InternalNavascript.g:6953:4: ()
                    // InternalNavascript.g:6954:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getSimpleTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageTypeAccess().getSimpleKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6966:3: ( () otherlv_5= 'arrayelement' )
                    {
                    // InternalNavascript.g:6966:3: ( () otherlv_5= 'arrayelement' )
                    // InternalNavascript.g:6967:4: () otherlv_5= 'arrayelement'
                    {
                    // InternalNavascript.g:6967:4: ()
                    // InternalNavascript.g:6968:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getArrayElementTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getMessageTypeAccess().getArrayelementKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageType"


    // $ANTLR start "entryRuleMessageMode"
    // InternalNavascript.g:6983:1: entryRuleMessageMode returns [EObject current=null] : iv_ruleMessageMode= ruleMessageMode EOF ;
    public final EObject entryRuleMessageMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageMode = null;


        try {
            // InternalNavascript.g:6983:52: (iv_ruleMessageMode= ruleMessageMode EOF )
            // InternalNavascript.g:6984:2: iv_ruleMessageMode= ruleMessageMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessageModeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMessageMode=ruleMessageMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessageMode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageMode"


    // $ANTLR start "ruleMessageMode"
    // InternalNavascript.g:6990:1: ruleMessageMode returns [EObject current=null] : ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) ;
    public final EObject ruleMessageMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:6996:2: ( ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) )
            // InternalNavascript.g:6997:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            {
            // InternalNavascript.g:6997:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==109) ) {
                alt123=1;
            }
            else if ( (LA123_0==110) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalNavascript.g:6998:3: ( () otherlv_1= 'ignore' )
                    {
                    // InternalNavascript.g:6998:3: ( () otherlv_1= 'ignore' )
                    // InternalNavascript.g:6999:4: () otherlv_1= 'ignore'
                    {
                    // InternalNavascript.g:6999:4: ()
                    // InternalNavascript.g:7000:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageModeAccess().getIgnoreAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageModeAccess().getIgnoreKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7012:3: ( () otherlv_3= 'overwrite' )
                    {
                    // InternalNavascript.g:7012:3: ( () otherlv_3= 'overwrite' )
                    // InternalNavascript.g:7013:4: () otherlv_3= 'overwrite'
                    {
                    // InternalNavascript.g:7013:4: ()
                    // InternalNavascript.g:7014:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageModeAccess().getOverwriteAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageModeAccess().getOverwriteKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageMode"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x2800000822F10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x2800000822B10812L,0x00000000000004E0L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000FC08610000020L,0x0000000006400000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x2800000822B10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x2800003B22B10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x6800003B22B10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000780L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x6800000822B10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000FC086100A0020L,0x0000000006400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L,0x0000000000000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000007040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x4800000000040000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x8000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4000000000020000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000600000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x2000000000000020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2000000000000020L,0x0000000000000110L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000110L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x6800003F22B10810L,0x00000000000004E0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x00001C0000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000010000040L,0x0000038000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000010000000L,0x0000038000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x2000000200000020L,0x0000000000000003L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x080FC086100A0020L,0x0000000006400000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x2000000000000020L,0x0000000000000103L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000103L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x4800000800000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x00001C7FF0000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x2000000000000020L,0x0000000000000113L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000113L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000314004002000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00000E0000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0800000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x00000000000F0000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400800L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000400000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x000FC08610000060L,0x0000000006400000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000022L});

}