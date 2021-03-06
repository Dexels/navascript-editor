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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IF", "RULE_THEN", "RULE_BLOCK_START", "RULE_BLOCK_END", "RULE_SYNCHRONIZED_DEF", "RULE_ARGS_START", "RULE_ARGS_END", "RULE_ARG_SEP", "RULE_CONTEXT_DEF", "RULE_ASSIGNMENT", "RULE_KEY_DEF", "RULE_TIMEOUT_DEF", "RULE_BREAKONNOLOCK_DEF", "RULE_BREAK_DEF", "RULE_EOL", "RULE_CODE_DEF", "RULE_DESCRIPTION_DEF", "RULE_ERROR_DEF", "RULE_VALIDATIONS_DEF", "RULE_DEFINE_DEF", "RULE_QUOTED_IDENTIFIER", "RULE_CHECK_DEF", "RULE_STRING_CONSTANT", "RULE_PRINT_DEF", "RULE_LOG_DEF", "RULE_FINALLY_DEF", "RULE_METHODS_DEF", "RULE_LOOP_DEF", "RULE_FILTER_DEF", "RULE_INCLUDE_DEF", "RULE_ANTIMESSAGE_DEF", "RULE_MESSAGE_DEF", "RULE_TML_START", "RULE_TML_END", "RULE_TYPE_DEF", "RULE_MODE_DEF", "RULE_MAP_DEF", "RULE_IDENTIFIER", "RULE_MAP_OLDSKOOL_DEF", "RULE_OBJECT_OLDSKOOL_DEF", "RULE_OBJECT_IDENTIFIER", "RULE_METHOD_IDENTIFIER", "RULE_MAPPABLE_IDENTIFIER", "RULE_TML_LITERAL", "RULE_VAR_DEF", "RULE_PROPERTY_DEF", "RULE_OPTION_DEF", "RULE_LENGTH_DEF", "RULE_INTEGER", "RULE_DIRECTION_DEF", "RULE_IN_DEF", "RULE_OUT_DEF", "RULE_INOUT_DEF", "RULE_CARDINALITY_DEF", "RULE_SUBTYPE_DEF", "RULE_ELSE", "RULE_STRING_LITERAL", "RULE_TRUE", "RULE_FALSE", "RULE_NULL_DEF", "RULE_FORALL", "RULE_EXISTS", "RULE_MAPPABLE_ID", "RULE_LETTER", "RULE_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_CHARACTER", "'user'", "'service'", "'+'", "'1'", "'OR'", "'AND'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'-'", "'*'", "'/'", "'!'", "'?'", "'`'", "'integer'", "'string'", "'boolean'", "'date'", "'float'", "'binary'", "'clocktime'", "'memo'", "'timestamp'", "'percentage'", "'selection'", "'name'", "'value'", "'selected'", "'array'", "'simple'", "'arrayelement'", "'ignore'", "'overwrite'"
    };
    public static final int RULE_FINALLY_DEF=29;
    public static final int RULE_CHARACTER=72;
    public static final int RULE_BREAKONNOLOCK_DEF=16;
    public static final int RULE_DIRECTION_DEF=53;
    public static final int RULE_EOL=18;
    public static final int RULE_DIGIT=68;
    public static final int RULE_METHODS_DEF=30;
    public static final int RULE_TYPE_DEF=38;
    public static final int RULE_EXISTS=65;
    public static final int RULE_NULL_DEF=63;
    public static final int RULE_MAPPABLE_IDENTIFIER=46;
    public static final int RULE_METHOD_IDENTIFIER=45;
    public static final int RULE_ML_COMMENT=69;
    public static final int RULE_CARDINALITY_DEF=57;
    public static final int RULE_BREAK_DEF=17;
    public static final int RULE_FALSE=62;
    public static final int RULE_BLOCK_END=7;
    public static final int RULE_FILTER_DEF=32;
    public static final int RULE_INOUT_DEF=56;
    public static final int RULE_ANTIMESSAGE_DEF=34;
    public static final int RULE_KEY_DEF=14;
    public static final int RULE_OPTION_DEF=50;
    public static final int RULE_DEFINE_DEF=23;
    public static final int RULE_ASSIGNMENT=13;
    public static final int RULE_IF=4;
    public static final int RULE_QUOTED_IDENTIFIER=24;
    public static final int RULE_ARG_SEP=11;
    public static final int RULE_CODE_DEF=19;
    public static final int RULE_LETTER=67;
    public static final int RULE_IN_DEF=54;
    public static final int RULE_MAPPABLE_ID=66;
    public static final int RULE_ERROR_DEF=21;
    public static final int RULE_MAP_DEF=40;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_SUBTYPE_DEF=58;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_PRINT_DEF=27;
    public static final int RULE_CHECK_DEF=25;
    public static final int RULE_ARGS_START=9;
    public static final int T__99=99;
    public static final int RULE_OUT_DEF=55;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int RULE_INCLUDE_DEF=33;
    public static final int T__98=98;
    public static final int RULE_CONTEXT_DEF=12;
    public static final int RULE_STRING_CONSTANT=26;
    public static final int RULE_THEN=5;
    public static final int RULE_OBJECT_OLDSKOOL_DEF=43;
    public static final int RULE_DESCRIPTION_DEF=20;
    public static final int RULE_SYNCHRONIZED_DEF=8;
    public static final int RULE_ELSE=59;
    public static final int RULE_IDENTIFIER=41;
    public static final int RULE_STRING_LITERAL=60;
    public static final int RULE_MESSAGE_DEF=35;
    public static final int RULE_SL_COMMENT=70;
    public static final int RULE_PROPERTY_DEF=49;
    public static final int RULE_FORALL=64;
    public static final int RULE_TML_LITERAL=47;
    public static final int T__77=77;
    public static final int RULE_TRUE=61;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int RULE_TML_END=37;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int RULE_MAP_OLDSKOOL_DEF=42;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_LOG_DEF=28;
    public static final int RULE_WS=71;
    public static final int RULE_ARGS_END=10;
    public static final int RULE_TIMEOUT_DEF=15;
    public static final int RULE_BLOCK_START=6;
    public static final int RULE_LENGTH_DEF=51;
    public static final int RULE_VAR_DEF=48;
    public static final int RULE_VALIDATIONS_DEF=22;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_TML_START=36;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int RULE_LOOP_DEF=31;
    public static final int RULE_OBJECT_IDENTIFIER=44;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=52;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int RULE_MODE_DEF=39;
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

                if ( (LA3_0==RULE_IF||LA3_0==RULE_BLOCK_START||LA3_0==RULE_SYNCHRONIZED_DEF||LA3_0==RULE_BREAK_DEF||LA3_0==RULE_DEFINE_DEF||(LA3_0>=RULE_PRINT_DEF && LA3_0<=RULE_LOG_DEF)||(LA3_0>=RULE_METHODS_DEF && LA3_0<=RULE_LOOP_DEF)||(LA3_0>=RULE_INCLUDE_DEF && LA3_0<=RULE_MESSAGE_DEF)||LA3_0==RULE_MAP_DEF||LA3_0==RULE_MAP_OLDSKOOL_DEF||LA3_0==RULE_VAR_DEF) ) {
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
    // InternalNavascript.g:199:1: ruleTopLevelStatement returns [EObject current=null] : ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) ;
    public final EObject ruleTopLevelStatement() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_THEN_3=null;
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
            // InternalNavascript.g:205:2: ( ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:206:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:206:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:207:3: () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
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

            // InternalNavascript.g:214:3: (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_IF) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalNavascript.g:215:4: this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN
                    {
                    this_IF_1=(Token)match(input,RULE_IF,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IF_1, grammarAccess.getTopLevelStatementAccess().getIFTerminalRuleCall_1_0());
                      			
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

                    this_THEN_3=(Token)match(input,RULE_THEN,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_THEN_3, grammarAccess.getTopLevelStatementAccess().getTHENTerminalRuleCall_1_2());
                      			
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
            case RULE_MESSAGE_DEF:
                {
                alt5=1;
                }
                break;
            case RULE_VAR_DEF:
                {
                alt5=2;
                }
                break;
            case RULE_MAP_DEF:
            case RULE_MAP_OLDSKOOL_DEF:
                {
                alt5=3;
                }
                break;
            case RULE_ANTIMESSAGE_DEF:
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
            case RULE_METHODS_DEF:
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
            case RULE_BLOCK_START:
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
    // InternalNavascript.g:467:1: ruleInnerBody returns [EObject current=null] : ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) ;
    public final EObject ruleInnerBody() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_THEN_3=null;
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
            // InternalNavascript.g:473:2: ( ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:474:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:474:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:475:3: () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
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

            // InternalNavascript.g:482:3: (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_IF) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalNavascript.g:483:4: this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN
                    {
                    this_IF_1=(Token)match(input,RULE_IF,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IF_1, grammarAccess.getInnerBodyAccess().getIFTerminalRuleCall_1_0());
                      			
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

                    this_THEN_3=(Token)match(input,RULE_THEN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_THEN_3, grammarAccess.getInnerBodyAccess().getTHENTerminalRuleCall_1_2());
                      			
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
            case RULE_MESSAGE_DEF:
                {
                alt7=4;
                }
                break;
            case RULE_ANTIMESSAGE_DEF:
                {
                alt7=5;
                }
                break;
            case RULE_INCLUDE_DEF:
                {
                alt7=6;
                }
                break;
            case RULE_METHODS_DEF:
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
            case RULE_MAP_DEF:
            case RULE_MAP_OLDSKOOL_DEF:
                {
                alt7=13;
                }
                break;
            case RULE_BREAK_DEF:
                {
                alt7=14;
                }
                break;
            case RULE_BLOCK_START:
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
    // InternalNavascript.g:767:1: ruleBlockStatements returns [EObject current=null] : ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) ;
    public final EObject ruleBlockStatements() throws RecognitionException {
        EObject current = null;

        Token this_BLOCK_START_1=null;
        Token this_BLOCK_END_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:773:2: ( ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) )
            // InternalNavascript.g:774:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            {
            // InternalNavascript.g:774:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            // InternalNavascript.g:775:3: () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END
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

            this_BLOCK_START_1=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_1, grammarAccess.getBlockStatementsAccess().getBLOCK_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:786:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_IF||LA8_0==RULE_BLOCK_START||LA8_0==RULE_BREAK_DEF||LA8_0==RULE_DEFINE_DEF||(LA8_0>=RULE_PRINT_DEF && LA8_0<=RULE_LOG_DEF)||(LA8_0>=RULE_METHODS_DEF && LA8_0<=RULE_LOOP_DEF)||(LA8_0>=RULE_INCLUDE_DEF && LA8_0<=RULE_MESSAGE_DEF)||LA8_0==RULE_MAP_DEF||LA8_0==RULE_MAP_OLDSKOOL_DEF||(LA8_0>=RULE_METHOD_IDENTIFIER && LA8_0<=RULE_MAPPABLE_IDENTIFIER)||(LA8_0>=RULE_VAR_DEF && LA8_0<=RULE_OPTION_DEF)) ) {
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

            this_BLOCK_END_3=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_3, grammarAccess.getBlockStatementsAccess().getBLOCK_ENDTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:820:1: ruleSynchronized returns [EObject current=null] : (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END this_BLOCK_START_4= RULE_BLOCK_START ( (lv_statements_5_0= ruleTopLevelStatement ) )* this_BLOCK_END_6= RULE_BLOCK_END ) ;
    public final EObject ruleSynchronized() throws RecognitionException {
        EObject current = null;

        Token this_SYNCHRONIZED_DEF_0=null;
        Token this_ARGS_START_1=null;
        Token this_ARGS_END_3=null;
        Token this_BLOCK_START_4=null;
        Token this_BLOCK_END_6=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_statements_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:826:2: ( (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END this_BLOCK_START_4= RULE_BLOCK_START ( (lv_statements_5_0= ruleTopLevelStatement ) )* this_BLOCK_END_6= RULE_BLOCK_END ) )
            // InternalNavascript.g:827:2: (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END this_BLOCK_START_4= RULE_BLOCK_START ( (lv_statements_5_0= ruleTopLevelStatement ) )* this_BLOCK_END_6= RULE_BLOCK_END )
            {
            // InternalNavascript.g:827:2: (this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END this_BLOCK_START_4= RULE_BLOCK_START ( (lv_statements_5_0= ruleTopLevelStatement ) )* this_BLOCK_END_6= RULE_BLOCK_END )
            // InternalNavascript.g:828:3: this_SYNCHRONIZED_DEF_0= RULE_SYNCHRONIZED_DEF this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) this_ARGS_END_3= RULE_ARGS_END this_BLOCK_START_4= RULE_BLOCK_START ( (lv_statements_5_0= ruleTopLevelStatement ) )* this_BLOCK_END_6= RULE_BLOCK_END
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
            this_BLOCK_START_4=(Token)match(input,RULE_BLOCK_START,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_4, grammarAccess.getSynchronizedAccess().getBLOCK_STARTTerminalRuleCall_4());
              		
            }
            // InternalNavascript.g:863:3: ( (lv_statements_5_0= ruleTopLevelStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_IF||LA9_0==RULE_BLOCK_START||LA9_0==RULE_SYNCHRONIZED_DEF||LA9_0==RULE_BREAK_DEF||LA9_0==RULE_DEFINE_DEF||(LA9_0>=RULE_PRINT_DEF && LA9_0<=RULE_LOG_DEF)||(LA9_0>=RULE_METHODS_DEF && LA9_0<=RULE_LOOP_DEF)||(LA9_0>=RULE_INCLUDE_DEF && LA9_0<=RULE_MESSAGE_DEF)||LA9_0==RULE_MAP_DEF||LA9_0==RULE_MAP_OLDSKOOL_DEF||LA9_0==RULE_VAR_DEF) ) {
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

            this_BLOCK_END_6=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_6, grammarAccess.getSynchronizedAccess().getBLOCK_ENDTerminalRuleCall_6());
              		
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
    // InternalNavascript.g:897:1: ruleSynchronizedArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) ;
    public final EObject ruleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:903:2: ( ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) )
            // InternalNavascript.g:904:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            {
            // InternalNavascript.g:904:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            // InternalNavascript.g:905:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
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

            // InternalNavascript.g:924:3: (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ARG_SEP) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalNavascript.g:925:4: this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    {
            	    this_ARG_SEP_1=(Token)match(input,RULE_ARG_SEP,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_1, grammarAccess.getSynchronizedArgumentsAccess().getARG_SEPTerminalRuleCall_1_0());
            	      			
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
    // InternalNavascript.g:1022:1: ruleSContext returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_SContextType_2= ruleSContextType ) ;
    public final AntlrDatatypeRuleToken ruleSContext() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_CONTEXT_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        AntlrDatatypeRuleToken this_SContextType_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1028:2: ( (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_SContextType_2= ruleSContextType ) )
            // InternalNavascript.g:1029:2: (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_SContextType_2= ruleSContextType )
            {
            // InternalNavascript.g:1029:2: (this_CONTEXT_DEF_0= RULE_CONTEXT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_SContextType_2= ruleSContextType )
            // InternalNavascript.g:1030:3: this_CONTEXT_DEF_0= RULE_CONTEXT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_SContextType_2= ruleSContextType
            {
            this_CONTEXT_DEF_0=(Token)match(input,RULE_CONTEXT_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_CONTEXT_DEF_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CONTEXT_DEF_0, grammarAccess.getSContextAccess().getCONTEXT_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ASSIGNMENT_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getSContextAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSContextAccess().getSContextTypeParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_SContextType_2=ruleSContextType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_SContextType_2);
              		
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
    // InternalNavascript.g:1058:1: entryRuleSKey returns [EObject current=null] : iv_ruleSKey= ruleSKey EOF ;
    public final EObject entryRuleSKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSKey = null;


        try {
            // InternalNavascript.g:1058:45: (iv_ruleSKey= ruleSKey EOF )
            // InternalNavascript.g:1059:2: iv_ruleSKey= ruleSKey EOF
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
    // InternalNavascript.g:1065:1: ruleSKey returns [EObject current=null] : (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression ) ;
    public final EObject ruleSKey() throws RecognitionException {
        EObject current = null;

        Token this_KEY_DEF_0=null;
        EObject this_LiteralOrExpression_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1071:2: ( (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression ) )
            // InternalNavascript.g:1072:2: (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:1072:2: (this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression )
            // InternalNavascript.g:1073:3: this_KEY_DEF_0= RULE_KEY_DEF this_LiteralOrExpression_1= ruleLiteralOrExpression
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
    // InternalNavascript.g:1089:1: entryRuleSTimeout returns [EObject current=null] : iv_ruleSTimeout= ruleSTimeout EOF ;
    public final EObject entryRuleSTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTimeout = null;


        try {
            // InternalNavascript.g:1089:49: (iv_ruleSTimeout= ruleSTimeout EOF )
            // InternalNavascript.g:1090:2: iv_ruleSTimeout= ruleSTimeout EOF
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
    // InternalNavascript.g:1096:1: ruleSTimeout returns [EObject current=null] : (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression ) ;
    public final EObject ruleSTimeout() throws RecognitionException {
        EObject current = null;

        Token this_TIMEOUT_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        EObject this_Expression_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1102:2: ( (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression ) )
            // InternalNavascript.g:1103:2: (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression )
            {
            // InternalNavascript.g:1103:2: (this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression )
            // InternalNavascript.g:1104:3: this_TIMEOUT_DEF_0= RULE_TIMEOUT_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression
            {
            this_TIMEOUT_DEF_0=(Token)match(input,RULE_TIMEOUT_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TIMEOUT_DEF_0, grammarAccess.getSTimeoutAccess().getTIMEOUT_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getSTimeoutAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSTimeoutAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_Expression_2=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_2;
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
    // InternalNavascript.g:1124:1: entryRuleSBreakOnNoLock returns [EObject current=null] : iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF ;
    public final EObject entryRuleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSBreakOnNoLock = null;


        try {
            // InternalNavascript.g:1124:55: (iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF )
            // InternalNavascript.g:1125:2: iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF
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
    // InternalNavascript.g:1131:1: ruleSBreakOnNoLock returns [EObject current=null] : (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression ) ;
    public final EObject ruleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        Token this_BREAKONNOLOCK_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        EObject this_Expression_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1137:2: ( (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression ) )
            // InternalNavascript.g:1138:2: (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression )
            {
            // InternalNavascript.g:1138:2: (this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression )
            // InternalNavascript.g:1139:3: this_BREAKONNOLOCK_DEF_0= RULE_BREAKONNOLOCK_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_Expression_2= ruleExpression
            {
            this_BREAKONNOLOCK_DEF_0=(Token)match(input,RULE_BREAKONNOLOCK_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BREAKONNOLOCK_DEF_0, grammarAccess.getSBreakOnNoLockAccess().getBREAKONNOLOCK_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getSBreakOnNoLockAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSBreakOnNoLockAccess().getExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_Expression_2=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_2;
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
    // InternalNavascript.g:1159:1: entryRuleSContextType returns [String current=null] : iv_ruleSContextType= ruleSContextType EOF ;
    public final String entryRuleSContextType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSContextType = null;


        try {
            // InternalNavascript.g:1159:52: (iv_ruleSContextType= ruleSContextType EOF )
            // InternalNavascript.g:1160:2: iv_ruleSContextType= ruleSContextType EOF
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
    // InternalNavascript.g:1166:1: ruleSContextType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'user' | kw= 'service' ) ;
    public final AntlrDatatypeRuleToken ruleSContextType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:1172:2: ( (kw= 'user' | kw= 'service' ) )
            // InternalNavascript.g:1173:2: (kw= 'user' | kw= 'service' )
            {
            // InternalNavascript.g:1173:2: (kw= 'user' | kw= 'service' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==73) ) {
                alt12=1;
            }
            else if ( (LA12_0==74) ) {
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
                    // InternalNavascript.g:1174:3: kw= 'user'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSContextTypeAccess().getUserKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1180:3: kw= 'service'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1189:1: entryRuleBreak returns [EObject current=null] : iv_ruleBreak= ruleBreak EOF ;
    public final EObject entryRuleBreak() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreak = null;


        try {
            // InternalNavascript.g:1189:46: (iv_ruleBreak= ruleBreak EOF )
            // InternalNavascript.g:1190:2: iv_ruleBreak= ruleBreak EOF
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
    // InternalNavascript.g:1196:1: ruleBreak returns [EObject current=null] : ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? this_EOL_5= RULE_EOL ) ;
    public final EObject ruleBreak() throws RecognitionException {
        EObject current = null;

        Token this_BREAK_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token this_EOL_5=null;
        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1202:2: ( ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? this_EOL_5= RULE_EOL ) )
            // InternalNavascript.g:1203:2: ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? this_EOL_5= RULE_EOL )
            {
            // InternalNavascript.g:1203:2: ( () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? this_EOL_5= RULE_EOL )
            // InternalNavascript.g:1204:3: () this_BREAK_DEF_1= RULE_BREAK_DEF (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )? this_EOL_5= RULE_EOL
            {
            // InternalNavascript.g:1204:3: ()
            // InternalNavascript.g:1205:4: 
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
            // InternalNavascript.g:1215:3: (this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ARGS_START) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalNavascript.g:1216:4: this_ARGS_START_2= RULE_ARGS_START ( (lv_parameters_3_0= ruleBreakParameters ) )? this_ARGS_END_4= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getBreakAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    // InternalNavascript.g:1220:4: ( (lv_parameters_3_0= ruleBreakParameters ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=RULE_CODE_DEF && LA13_0<=RULE_ERROR_DEF)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalNavascript.g:1221:5: (lv_parameters_3_0= ruleBreakParameters )
                            {
                            // InternalNavascript.g:1221:5: (lv_parameters_3_0= ruleBreakParameters )
                            // InternalNavascript.g:1222:6: lv_parameters_3_0= ruleBreakParameters
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

            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_5, grammarAccess.getBreakAccess().getEOLTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:1252:1: entryRuleBreakParameter returns [EObject current=null] : iv_ruleBreakParameter= ruleBreakParameter EOF ;
    public final EObject entryRuleBreakParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameter = null;


        try {
            // InternalNavascript.g:1252:55: (iv_ruleBreakParameter= ruleBreakParameter EOF )
            // InternalNavascript.g:1253:2: iv_ruleBreakParameter= ruleBreakParameter EOF
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
    // InternalNavascript.g:1259:1: ruleBreakParameter returns [EObject current=null] : ( (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression ) ) ;
    public final EObject ruleBreakParameter() throws RecognitionException {
        EObject current = null;

        Token this_CODE_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token this_DESCRIPTION_DEF_3=null;
        Token this_ASSIGNMENT_4=null;
        Token this_ERROR_DEF_6=null;
        Token this_ASSIGNMENT_7=null;
        EObject lv_code_2_0 = null;

        EObject lv_description_5_0 = null;

        EObject this_LiteralOrExpression_8 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1265:2: ( ( (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:1266:2: ( (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:1266:2: ( (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) ) | (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) ) | (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case RULE_CODE_DEF:
                {
                alt15=1;
                }
                break;
            case RULE_DESCRIPTION_DEF:
                {
                alt15=2;
                }
                break;
            case RULE_ERROR_DEF:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalNavascript.g:1267:3: (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1267:3: (this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1268:4: this_CODE_DEF_0= RULE_CODE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_code_2_0= ruleLiteralOrExpression ) )
                    {
                    this_CODE_DEF_0=(Token)match(input,RULE_CODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_CODE_DEF_0, grammarAccess.getBreakParameterAccess().getCODE_DEFTerminalRuleCall_0_0());
                      			
                    }
                    this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_1, grammarAccess.getBreakParameterAccess().getASSIGNMENTTerminalRuleCall_0_1());
                      			
                    }
                    // InternalNavascript.g:1276:4: ( (lv_code_2_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1277:5: (lv_code_2_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1277:5: (lv_code_2_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1278:6: lv_code_2_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakParameterAccess().getCodeLiteralOrExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_code_2_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakParameterRule());
                      						}
                      						set(
                      							current,
                      							"code",
                      							lv_code_2_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1297:3: (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1297:3: (this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1298:4: this_DESCRIPTION_DEF_3= RULE_DESCRIPTION_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_description_5_0= ruleLiteralOrExpression ) )
                    {
                    this_DESCRIPTION_DEF_3=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DESCRIPTION_DEF_3, grammarAccess.getBreakParameterAccess().getDESCRIPTION_DEFTerminalRuleCall_1_0());
                      			
                    }
                    this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_4, grammarAccess.getBreakParameterAccess().getASSIGNMENTTerminalRuleCall_1_1());
                      			
                    }
                    // InternalNavascript.g:1306:4: ( (lv_description_5_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1307:5: (lv_description_5_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1307:5: (lv_description_5_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1308:6: lv_description_5_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakParameterAccess().getDescriptionLiteralOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_description_5_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakParameterRule());
                      						}
                      						set(
                      							current,
                      							"description",
                      							lv_description_5_0,
                      							"com.dexels.navajo.Navascript.LiteralOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:1327:3: (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1327:3: (this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression )
                    // InternalNavascript.g:1328:4: this_ERROR_DEF_6= RULE_ERROR_DEF this_ASSIGNMENT_7= RULE_ASSIGNMENT this_LiteralOrExpression_8= ruleLiteralOrExpression
                    {
                    this_ERROR_DEF_6=(Token)match(input,RULE_ERROR_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ERROR_DEF_6, grammarAccess.getBreakParameterAccess().getERROR_DEFTerminalRuleCall_2_0());
                      			
                    }
                    this_ASSIGNMENT_7=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_7, grammarAccess.getBreakParameterAccess().getASSIGNMENTTerminalRuleCall_2_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getBreakParameterAccess().getLiteralOrExpressionParserRuleCall_2_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralOrExpression_8=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_LiteralOrExpression_8;
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
    // InternalNavascript.g:1349:1: entryRuleBreakParameters returns [EObject current=null] : iv_ruleBreakParameters= ruleBreakParameters EOF ;
    public final EObject entryRuleBreakParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameters = null;


        try {
            // InternalNavascript.g:1349:56: (iv_ruleBreakParameters= ruleBreakParameters EOF )
            // InternalNavascript.g:1350:2: iv_ruleBreakParameters= ruleBreakParameters EOF
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
    // InternalNavascript.g:1356:1: ruleBreakParameters returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) ;
    public final EObject ruleBreakParameters() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1362:2: ( ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) )
            // InternalNavascript.g:1363:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            {
            // InternalNavascript.g:1363:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            // InternalNavascript.g:1364:3: ( (lv_parameters_0_0= ruleBreakParameter ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            {
            // InternalNavascript.g:1364:3: ( (lv_parameters_0_0= ruleBreakParameter ) )
            // InternalNavascript.g:1365:4: (lv_parameters_0_0= ruleBreakParameter )
            {
            // InternalNavascript.g:1365:4: (lv_parameters_0_0= ruleBreakParameter )
            // InternalNavascript.g:1366:5: lv_parameters_0_0= ruleBreakParameter
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

            // InternalNavascript.g:1383:3: (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ARG_SEP) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalNavascript.g:1384:4: this_ARG_SEP_1= RULE_ARG_SEP ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    {
            	    this_ARG_SEP_1=(Token)match(input,RULE_ARG_SEP,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_1, grammarAccess.getBreakParametersAccess().getARG_SEPTerminalRuleCall_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:1388:4: ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    // InternalNavascript.g:1389:5: (lv_parameters_2_0= ruleBreakParameter )
            	    {
            	    // InternalNavascript.g:1389:5: (lv_parameters_2_0= ruleBreakParameter )
            	    // InternalNavascript.g:1390:6: lv_parameters_2_0= ruleBreakParameter
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
            	    break loop16;
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
    // InternalNavascript.g:1412:1: entryRuleValidations returns [EObject current=null] : iv_ruleValidations= ruleValidations EOF ;
    public final EObject entryRuleValidations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidations = null;


        try {
            // InternalNavascript.g:1412:52: (iv_ruleValidations= ruleValidations EOF )
            // InternalNavascript.g:1413:2: iv_ruleValidations= ruleValidations EOF
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
    // InternalNavascript.g:1419:1: ruleValidations returns [EObject current=null] : ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_checks_3_0= ruleCheck ) )* this_BLOCK_END_4= RULE_BLOCK_END ) ;
    public final EObject ruleValidations() throws RecognitionException {
        EObject current = null;

        Token this_VALIDATIONS_DEF_1=null;
        Token this_BLOCK_START_2=null;
        Token this_BLOCK_END_4=null;
        EObject lv_checks_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1425:2: ( ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_checks_3_0= ruleCheck ) )* this_BLOCK_END_4= RULE_BLOCK_END ) )
            // InternalNavascript.g:1426:2: ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_checks_3_0= ruleCheck ) )* this_BLOCK_END_4= RULE_BLOCK_END )
            {
            // InternalNavascript.g:1426:2: ( () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_checks_3_0= ruleCheck ) )* this_BLOCK_END_4= RULE_BLOCK_END )
            // InternalNavascript.g:1427:3: () this_VALIDATIONS_DEF_1= RULE_VALIDATIONS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_checks_3_0= ruleCheck ) )* this_BLOCK_END_4= RULE_BLOCK_END
            {
            // InternalNavascript.g:1427:3: ()
            // InternalNavascript.g:1428:4: 
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
            this_BLOCK_START_2=(Token)match(input,RULE_BLOCK_START,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_2, grammarAccess.getValidationsAccess().getBLOCK_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:1442:3: ( (lv_checks_3_0= ruleCheck ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_IF||LA17_0==RULE_CHECK_DEF) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalNavascript.g:1443:4: (lv_checks_3_0= ruleCheck )
            	    {
            	    // InternalNavascript.g:1443:4: (lv_checks_3_0= ruleCheck )
            	    // InternalNavascript.g:1444:5: lv_checks_3_0= ruleCheck
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
            	    break loop17;
                }
            } while (true);

            this_BLOCK_END_4=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_4, grammarAccess.getValidationsAccess().getBLOCK_ENDTerminalRuleCall_4());
              		
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
    // InternalNavascript.g:1469:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // InternalNavascript.g:1469:47: (iv_ruleDefine= ruleDefine EOF )
            // InternalNavascript.g:1470:2: iv_ruleDefine= ruleDefine EOF
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
    // InternalNavascript.g:1476:1: ruleDefine returns [EObject current=null] : ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) this_ASSIGNMENT_3= RULE_ASSIGNMENT ( (lv_expression_4_0= ruleExpression ) ) this_EOL_5= RULE_EOL ) ;
    public final EObject ruleDefine() throws RecognitionException {
        EObject current = null;

        Token this_DEFINE_DEF_1=null;
        Token lv_defineKey_2_0=null;
        Token this_ASSIGNMENT_3=null;
        Token this_EOL_5=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1482:2: ( ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) this_ASSIGNMENT_3= RULE_ASSIGNMENT ( (lv_expression_4_0= ruleExpression ) ) this_EOL_5= RULE_EOL ) )
            // InternalNavascript.g:1483:2: ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) this_ASSIGNMENT_3= RULE_ASSIGNMENT ( (lv_expression_4_0= ruleExpression ) ) this_EOL_5= RULE_EOL )
            {
            // InternalNavascript.g:1483:2: ( () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) this_ASSIGNMENT_3= RULE_ASSIGNMENT ( (lv_expression_4_0= ruleExpression ) ) this_EOL_5= RULE_EOL )
            // InternalNavascript.g:1484:3: () this_DEFINE_DEF_1= RULE_DEFINE_DEF ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) this_ASSIGNMENT_3= RULE_ASSIGNMENT ( (lv_expression_4_0= ruleExpression ) ) this_EOL_5= RULE_EOL
            {
            // InternalNavascript.g:1484:3: ()
            // InternalNavascript.g:1485:4: 
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
            // InternalNavascript.g:1495:3: ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:1496:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:1496:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:1497:5: lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER
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

            this_ASSIGNMENT_3=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_3, grammarAccess.getDefineAccess().getASSIGNMENTTerminalRuleCall_3());
              		
            }
            // InternalNavascript.g:1517:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalNavascript.g:1518:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalNavascript.g:1518:4: (lv_expression_4_0= ruleExpression )
            // InternalNavascript.g:1519:5: lv_expression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefineAccess().getExpressionExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefineRule());
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

            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_5, grammarAccess.getDefineAccess().getEOLTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:1544:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalNavascript.g:1544:46: (iv_ruleCheck= ruleCheck EOF )
            // InternalNavascript.g:1545:2: iv_ruleCheck= ruleCheck EOF
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
    // InternalNavascript.g:1551:1: ruleCheck returns [EObject current=null] : ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END this_ASSIGNMENT_10= RULE_ASSIGNMENT ( (lv_expression_11_0= ruleExpression ) ) this_EOL_12= RULE_EOL ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_THEN_3=null;
        Token this_CHECK_DEF_4=null;
        Token this_ARGS_START_5=null;
        Token this_ARG_SEP_7=null;
        Token this_ARGS_END_9=null;
        Token this_ASSIGNMENT_10=null;
        Token this_EOL_12=null;
        EObject lv_condition_2_0 = null;

        EObject lv_checkAttributes_6_0 = null;

        EObject lv_checkAttributes_8_0 = null;

        EObject lv_expression_11_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1557:2: ( ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END this_ASSIGNMENT_10= RULE_ASSIGNMENT ( (lv_expression_11_0= ruleExpression ) ) this_EOL_12= RULE_EOL ) )
            // InternalNavascript.g:1558:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END this_ASSIGNMENT_10= RULE_ASSIGNMENT ( (lv_expression_11_0= ruleExpression ) ) this_EOL_12= RULE_EOL )
            {
            // InternalNavascript.g:1558:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END this_ASSIGNMENT_10= RULE_ASSIGNMENT ( (lv_expression_11_0= ruleExpression ) ) this_EOL_12= RULE_EOL )
            // InternalNavascript.g:1559:3: () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? this_CHECK_DEF_4= RULE_CHECK_DEF this_ARGS_START_5= RULE_ARGS_START ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? this_ARGS_END_9= RULE_ARGS_END this_ASSIGNMENT_10= RULE_ASSIGNMENT ( (lv_expression_11_0= ruleExpression ) ) this_EOL_12= RULE_EOL
            {
            // InternalNavascript.g:1559:3: ()
            // InternalNavascript.g:1560:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCheckAccess().getCheckAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:1566:3: (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_IF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalNavascript.g:1567:4: this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN
                    {
                    this_IF_1=(Token)match(input,RULE_IF,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IF_1, grammarAccess.getCheckAccess().getIFTerminalRuleCall_1_0());
                      			
                    }
                    // InternalNavascript.g:1571:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:1572:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1572:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:1573:6: lv_condition_2_0= ruleExpression
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

                    this_THEN_3=(Token)match(input,RULE_THEN,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_THEN_3, grammarAccess.getCheckAccess().getTHENTerminalRuleCall_1_2());
                      			
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
            // InternalNavascript.g:1603:3: ( (lv_checkAttributes_6_0= ruleCheckAttribute ) )
            // InternalNavascript.g:1604:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            {
            // InternalNavascript.g:1604:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            // InternalNavascript.g:1605:5: lv_checkAttributes_6_0= ruleCheckAttribute
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

            // InternalNavascript.g:1622:3: (this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ARG_SEP) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalNavascript.g:1623:4: this_ARG_SEP_7= RULE_ARG_SEP ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    {
                    this_ARG_SEP_7=(Token)match(input,RULE_ARG_SEP,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARG_SEP_7, grammarAccess.getCheckAccess().getARG_SEPTerminalRuleCall_5_0());
                      			
                    }
                    // InternalNavascript.g:1627:4: ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    // InternalNavascript.g:1628:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    {
                    // InternalNavascript.g:1628:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    // InternalNavascript.g:1629:6: lv_checkAttributes_8_0= ruleCheckAttribute
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
            this_ASSIGNMENT_10=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_10, grammarAccess.getCheckAccess().getASSIGNMENTTerminalRuleCall_7());
              		
            }
            // InternalNavascript.g:1655:3: ( (lv_expression_11_0= ruleExpression ) )
            // InternalNavascript.g:1656:4: (lv_expression_11_0= ruleExpression )
            {
            // InternalNavascript.g:1656:4: (lv_expression_11_0= ruleExpression )
            // InternalNavascript.g:1657:5: lv_expression_11_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckAccess().getExpressionExpressionParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_11_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCheckRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_11_0,
              						"com.dexels.navajo.Navascript.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_EOL_12=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_12, grammarAccess.getCheckAccess().getEOLTerminalRuleCall_9());
              		
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
    // InternalNavascript.g:1682:1: entryRuleCheckAttribute returns [EObject current=null] : iv_ruleCheckAttribute= ruleCheckAttribute EOF ;
    public final EObject entryRuleCheckAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckAttribute = null;


        try {
            // InternalNavascript.g:1682:55: (iv_ruleCheckAttribute= ruleCheckAttribute EOF )
            // InternalNavascript.g:1683:2: iv_ruleCheckAttribute= ruleCheckAttribute EOF
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
    // InternalNavascript.g:1689:1: ruleCheckAttribute returns [EObject current=null] : ( ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) ) ) ;
    public final EObject ruleCheckAttribute() throws RecognitionException {
        EObject current = null;

        Token this_CODE_DEF_1=null;
        Token this_ASSIGNMENT_2=null;
        Token this_DESCRIPTION_DEF_4=null;
        Token this_ASSIGNMENT_5=null;
        EObject lv_value_3_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1695:2: ( ( ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) ) ) )
            // InternalNavascript.g:1696:2: ( ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) ) )
            {
            // InternalNavascript.g:1696:2: ( ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ) | (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_CODE_DEF) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_DESCRIPTION_DEF) ) {
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
                    // InternalNavascript.g:1697:3: ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
                    {
                    // InternalNavascript.g:1697:3: ( () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
                    // InternalNavascript.g:1698:4: () (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1698:4: ()
                    // InternalNavascript.g:1699:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCheckAttributeAccess().getCheckAttributeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1705:4: (this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1706:5: this_CODE_DEF_1= RULE_CODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) )
                    {
                    this_CODE_DEF_1=(Token)match(input,RULE_CODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_CODE_DEF_1, grammarAccess.getCheckAttributeAccess().getCODE_DEFTerminalRuleCall_0_1_0());
                      				
                    }
                    this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ASSIGNMENT_2, grammarAccess.getCheckAttributeAccess().getASSIGNMENTTerminalRuleCall_0_1_1());
                      				
                    }
                    // InternalNavascript.g:1714:5: ( (lv_value_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1715:6: (lv_value_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1715:6: (lv_value_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1716:7: lv_value_3_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getCheckAttributeAccess().getValueLiteralOrExpressionParserRuleCall_0_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getCheckAttributeRule());
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


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1736:3: (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1736:3: (this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1737:4: this_DESCRIPTION_DEF_4= RULE_DESCRIPTION_DEF this_ASSIGNMENT_5= RULE_ASSIGNMENT ( (lv_value_6_0= ruleLiteralOrExpression ) )
                    {
                    this_DESCRIPTION_DEF_4=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DESCRIPTION_DEF_4, grammarAccess.getCheckAttributeAccess().getDESCRIPTION_DEFTerminalRuleCall_1_0());
                      			
                    }
                    this_ASSIGNMENT_5=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_5, grammarAccess.getCheckAttributeAccess().getASSIGNMENTTerminalRuleCall_1_1());
                      			
                    }
                    // InternalNavascript.g:1745:4: ( (lv_value_6_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1746:5: (lv_value_6_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1746:5: (lv_value_6_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1747:6: lv_value_6_0= ruleLiteralOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAttributeAccess().getValueLiteralOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_6_0=ruleLiteralOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCheckAttributeRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_6_0,
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
    // InternalNavascript.g:1769:1: entryRuleLiteralOrExpression returns [EObject current=null] : iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF ;
    public final EObject entryRuleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrExpression = null;


        try {
            // InternalNavascript.g:1769:60: (iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF )
            // InternalNavascript.g:1770:2: iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF
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
    // InternalNavascript.g:1776:1: ruleLiteralOrExpression returns [EObject current=null] : ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_1=null;
        Token lv_literal_1_2=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1782:2: ( ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalNavascript.g:1783:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalNavascript.g:1783:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_QUOTED_IDENTIFIER||LA22_0==RULE_STRING_CONSTANT) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ARGS_START||LA22_0==RULE_IDENTIFIER||(LA22_0>=RULE_MAPPABLE_IDENTIFIER && LA22_0<=RULE_TML_LITERAL)||LA22_0==RULE_INTEGER||(LA22_0>=RULE_STRING_LITERAL && LA22_0<=RULE_EXISTS)||LA22_0==85||(LA22_0>=88 && LA22_0<=89)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalNavascript.g:1784:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    {
                    // InternalNavascript.g:1784:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    // InternalNavascript.g:1785:4: () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    {
                    // InternalNavascript.g:1785:4: ()
                    // InternalNavascript.g:1786:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralOrExpressionAccess().getLiteralOrExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1792:4: ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    // InternalNavascript.g:1793:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    {
                    // InternalNavascript.g:1793:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    // InternalNavascript.g:1794:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    {
                    // InternalNavascript.g:1794:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_QUOTED_IDENTIFIER) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_STRING_CONSTANT) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalNavascript.g:1795:7: lv_literal_1_1= RULE_QUOTED_IDENTIFIER
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
                            // InternalNavascript.g:1810:7: lv_literal_1_2= RULE_STRING_CONSTANT
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
                    // InternalNavascript.g:1829:3: ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // InternalNavascript.g:1829:3: ( (lv_expression_2_0= ruleExpression ) )
                    // InternalNavascript.g:1830:4: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1830:4: (lv_expression_2_0= ruleExpression )
                    // InternalNavascript.g:1831:5: lv_expression_2_0= ruleExpression
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
    // InternalNavascript.g:1852:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalNavascript.g:1852:46: (iv_rulePrint= rulePrint EOF )
            // InternalNavascript.g:1853:2: iv_rulePrint= rulePrint EOF
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
    // InternalNavascript.g:1859:1: rulePrint returns [EObject current=null] : ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token this_PRINT_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token this_EOL_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1865:2: ( ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) )
            // InternalNavascript.g:1866:2: ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            {
            // InternalNavascript.g:1866:2: ( () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            // InternalNavascript.g:1867:3: () this_PRINT_DEF_1= RULE_PRINT_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL
            {
            // InternalNavascript.g:1867:3: ()
            // InternalNavascript.g:1868:4: 
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
            // InternalNavascript.g:1882:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:1883:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:1883:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:1884:5: lv_expression_3_0= ruleExpression
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
            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_5, grammarAccess.getPrintAccess().getEOLTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:1913:1: entryRuleLog returns [EObject current=null] : iv_ruleLog= ruleLog EOF ;
    public final EObject entryRuleLog() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLog = null;


        try {
            // InternalNavascript.g:1913:44: (iv_ruleLog= ruleLog EOF )
            // InternalNavascript.g:1914:2: iv_ruleLog= ruleLog EOF
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
    // InternalNavascript.g:1920:1: ruleLog returns [EObject current=null] : ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) ;
    public final EObject ruleLog() throws RecognitionException {
        EObject current = null;

        Token this_LOG_DEF_1=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token this_EOL_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1926:2: ( ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) )
            // InternalNavascript.g:1927:2: ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            {
            // InternalNavascript.g:1927:2: ( () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            // InternalNavascript.g:1928:3: () this_LOG_DEF_1= RULE_LOG_DEF this_ARGS_START_2= RULE_ARGS_START ( (lv_expression_3_0= ruleExpression ) ) this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL
            {
            // InternalNavascript.g:1928:3: ()
            // InternalNavascript.g:1929:4: 
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
            // InternalNavascript.g:1943:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:1944:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:1944:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:1945:5: lv_expression_3_0= ruleExpression
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
            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_5, grammarAccess.getLogAccess().getEOLTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:1974:1: entryRuleFinally returns [EObject current=null] : iv_ruleFinally= ruleFinally EOF ;
    public final EObject entryRuleFinally() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinally = null;


        try {
            // InternalNavascript.g:1974:48: (iv_ruleFinally= ruleFinally EOF )
            // InternalNavascript.g:1975:2: iv_ruleFinally= ruleFinally EOF
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
    // InternalNavascript.g:1981:1: ruleFinally returns [EObject current=null] : ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) this_BLOCK_END_4= RULE_BLOCK_END ) ;
    public final EObject ruleFinally() throws RecognitionException {
        EObject current = null;

        Token this_FINALLY_DEF_1=null;
        Token this_BLOCK_START_2=null;
        Token this_BLOCK_END_4=null;
        EObject lv_finallyStatements_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1987:2: ( ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) this_BLOCK_END_4= RULE_BLOCK_END ) )
            // InternalNavascript.g:1988:2: ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) this_BLOCK_END_4= RULE_BLOCK_END )
            {
            // InternalNavascript.g:1988:2: ( () this_FINALLY_DEF_1= RULE_FINALLY_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) this_BLOCK_END_4= RULE_BLOCK_END )
            // InternalNavascript.g:1989:3: () this_FINALLY_DEF_1= RULE_FINALLY_DEF this_BLOCK_START_2= RULE_BLOCK_START ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) this_BLOCK_END_4= RULE_BLOCK_END
            {
            // InternalNavascript.g:1989:3: ()
            // InternalNavascript.g:1990:4: 
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
            this_BLOCK_START_2=(Token)match(input,RULE_BLOCK_START,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_2, grammarAccess.getFinallyAccess().getBLOCK_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:2004:3: ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:2005:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:2005:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            // InternalNavascript.g:2006:5: lv_finallyStatements_3_0= ruleTopLevelStatements
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

            this_BLOCK_END_4=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_4, grammarAccess.getFinallyAccess().getBLOCK_ENDTerminalRuleCall_4());
              		
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
    // InternalNavascript.g:2031:1: entryRuleMethods returns [EObject current=null] : iv_ruleMethods= ruleMethods EOF ;
    public final EObject entryRuleMethods() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethods = null;


        try {
            // InternalNavascript.g:2031:48: (iv_ruleMethods= ruleMethods EOF )
            // InternalNavascript.g:2032:2: iv_ruleMethods= ruleMethods EOF
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
    // InternalNavascript.g:2038:1: ruleMethods returns [EObject current=null] : ( () this_METHODS_DEF_1= RULE_METHODS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )* this_BLOCK_END_5= RULE_BLOCK_END ) ;
    public final EObject ruleMethods() throws RecognitionException {
        EObject current = null;

        Token this_METHODS_DEF_1=null;
        Token this_BLOCK_START_2=null;
        Token lv_methods_3_0=null;
        Token this_EOL_4=null;
        Token this_BLOCK_END_5=null;


        	enterRule();

        try {
            // InternalNavascript.g:2044:2: ( ( () this_METHODS_DEF_1= RULE_METHODS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )* this_BLOCK_END_5= RULE_BLOCK_END ) )
            // InternalNavascript.g:2045:2: ( () this_METHODS_DEF_1= RULE_METHODS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )* this_BLOCK_END_5= RULE_BLOCK_END )
            {
            // InternalNavascript.g:2045:2: ( () this_METHODS_DEF_1= RULE_METHODS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )* this_BLOCK_END_5= RULE_BLOCK_END )
            // InternalNavascript.g:2046:3: () this_METHODS_DEF_1= RULE_METHODS_DEF this_BLOCK_START_2= RULE_BLOCK_START ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )* this_BLOCK_END_5= RULE_BLOCK_END
            {
            // InternalNavascript.g:2046:3: ()
            // InternalNavascript.g:2047:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodsAccess().getMethodsAction_0(),
              					current);
              			
            }

            }

            this_METHODS_DEF_1=(Token)match(input,RULE_METHODS_DEF,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_METHODS_DEF_1, grammarAccess.getMethodsAccess().getMETHODS_DEFTerminalRuleCall_1());
              		
            }
            this_BLOCK_START_2=(Token)match(input,RULE_BLOCK_START,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_2, grammarAccess.getMethodsAccess().getBLOCK_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:2061:3: ( ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_QUOTED_IDENTIFIER) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalNavascript.g:2062:4: ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_4= RULE_EOL
            	    {
            	    // InternalNavascript.g:2062:4: ( (lv_methods_3_0= RULE_QUOTED_IDENTIFIER ) )
            	    // InternalNavascript.g:2063:5: (lv_methods_3_0= RULE_QUOTED_IDENTIFIER )
            	    {
            	    // InternalNavascript.g:2063:5: (lv_methods_3_0= RULE_QUOTED_IDENTIFIER )
            	    // InternalNavascript.g:2064:6: lv_methods_3_0= RULE_QUOTED_IDENTIFIER
            	    {
            	    lv_methods_3_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_methods_3_0, grammarAccess.getMethodsAccess().getMethodsQUOTED_IDENTIFIERTerminalRuleCall_3_0_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getMethodsRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"methods",
            	      							lv_methods_3_0,
            	      							"com.dexels.navajo.Navascript.QUOTED_IDENTIFIER");
            	      					
            	    }

            	    }


            	    }

            	    this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_EOL_4, grammarAccess.getMethodsAccess().getEOLTerminalRuleCall_3_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            this_BLOCK_END_5=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_5, grammarAccess.getMethodsAccess().getBLOCK_ENDTerminalRuleCall_4());
              		
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


    // $ANTLR start "entryRuleLoop"
    // InternalNavascript.g:2093:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalNavascript.g:2093:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalNavascript.g:2094:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalNavascript.g:2100:1: ruleLoop returns [EObject current=null] : ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )? this_BLOCK_START_9= RULE_BLOCK_START ( (lv_statements_10_0= ruleInnerBody ) )* this_BLOCK_END_11= RULE_BLOCK_END ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token this_LOOP_DEF_1=null;
        Token this_ARGS_START_4=null;
        Token this_FILTER_DEF_5=null;
        Token this_ASSIGNMENT_6=null;
        Token this_ARGS_END_8=null;
        Token this_BLOCK_START_9=null;
        Token this_BLOCK_END_11=null;
        EObject lv_mappable_2_0 = null;

        EObject lv_tml_3_0 = null;

        EObject lv_filter_7_0 = null;

        EObject lv_statements_10_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2106:2: ( ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )? this_BLOCK_START_9= RULE_BLOCK_START ( (lv_statements_10_0= ruleInnerBody ) )* this_BLOCK_END_11= RULE_BLOCK_END ) )
            // InternalNavascript.g:2107:2: ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )? this_BLOCK_START_9= RULE_BLOCK_START ( (lv_statements_10_0= ruleInnerBody ) )* this_BLOCK_END_11= RULE_BLOCK_END )
            {
            // InternalNavascript.g:2107:2: ( () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )? this_BLOCK_START_9= RULE_BLOCK_START ( (lv_statements_10_0= ruleInnerBody ) )* this_BLOCK_END_11= RULE_BLOCK_END )
            // InternalNavascript.g:2108:3: () this_LOOP_DEF_1= RULE_LOOP_DEF ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )? this_BLOCK_START_9= RULE_BLOCK_START ( (lv_statements_10_0= ruleInnerBody ) )* this_BLOCK_END_11= RULE_BLOCK_END
            {
            // InternalNavascript.g:2108:3: ()
            // InternalNavascript.g:2109:4: 
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
            // InternalNavascript.g:2119:3: ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_TML_LITERAL) ) {
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
                    // InternalNavascript.g:2120:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:2120:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:2121:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:2121:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    // InternalNavascript.g:2122:6: lv_mappable_2_0= ruleMappableIdentifier
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
                    // InternalNavascript.g:2140:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:2140:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:2141:5: (lv_tml_3_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:2141:5: (lv_tml_3_0= ruleTmlIdentifier )
                    // InternalNavascript.g:2142:6: lv_tml_3_0= ruleTmlIdentifier
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

            // InternalNavascript.g:2160:3: (this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ARGS_START) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalNavascript.g:2161:4: this_ARGS_START_4= RULE_ARGS_START this_FILTER_DEF_5= RULE_FILTER_DEF this_ASSIGNMENT_6= RULE_ASSIGNMENT ( (lv_filter_7_0= ruleExpression ) ) this_ARGS_END_8= RULE_ARGS_END
                    {
                    this_ARGS_START_4=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_4, grammarAccess.getLoopAccess().getARGS_STARTTerminalRuleCall_3_0());
                      			
                    }
                    this_FILTER_DEF_5=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_5, grammarAccess.getLoopAccess().getFILTER_DEFTerminalRuleCall_3_1());
                      			
                    }
                    this_ASSIGNMENT_6=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_6, grammarAccess.getLoopAccess().getASSIGNMENTTerminalRuleCall_3_2());
                      			
                    }
                    // InternalNavascript.g:2173:4: ( (lv_filter_7_0= ruleExpression ) )
                    // InternalNavascript.g:2174:5: (lv_filter_7_0= ruleExpression )
                    {
                    // InternalNavascript.g:2174:5: (lv_filter_7_0= ruleExpression )
                    // InternalNavascript.g:2175:6: lv_filter_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getFilterExpressionParserRuleCall_3_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLoopRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_7_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_8=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_8, grammarAccess.getLoopAccess().getARGS_ENDTerminalRuleCall_3_4());
                      			
                    }

                    }
                    break;

            }

            this_BLOCK_START_9=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_9, grammarAccess.getLoopAccess().getBLOCK_STARTTerminalRuleCall_4());
              		
            }
            // InternalNavascript.g:2201:3: ( (lv_statements_10_0= ruleInnerBody ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_IF||LA26_0==RULE_BLOCK_START||LA26_0==RULE_BREAK_DEF||LA26_0==RULE_DEFINE_DEF||(LA26_0>=RULE_PRINT_DEF && LA26_0<=RULE_LOG_DEF)||(LA26_0>=RULE_METHODS_DEF && LA26_0<=RULE_LOOP_DEF)||(LA26_0>=RULE_INCLUDE_DEF && LA26_0<=RULE_MESSAGE_DEF)||LA26_0==RULE_MAP_DEF||LA26_0==RULE_MAP_OLDSKOOL_DEF||(LA26_0>=RULE_METHOD_IDENTIFIER && LA26_0<=RULE_MAPPABLE_IDENTIFIER)||(LA26_0>=RULE_VAR_DEF && LA26_0<=RULE_OPTION_DEF)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalNavascript.g:2202:4: (lv_statements_10_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2202:4: (lv_statements_10_0= ruleInnerBody )
            	    // InternalNavascript.g:2203:5: lv_statements_10_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLoopAccess().getStatementsInnerBodyParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_10_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getLoopRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_10_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            this_BLOCK_END_11=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_11, grammarAccess.getLoopAccess().getBLOCK_ENDTerminalRuleCall_6());
              		
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
    // InternalNavascript.g:2228:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalNavascript.g:2228:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalNavascript.g:2229:2: iv_ruleInclude= ruleInclude EOF
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
    // InternalNavascript.g:2235:1: ruleInclude returns [EObject current=null] : ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token this_INCLUDE_DEF_1=null;
        Token lv_scriptName_2_0=null;
        Token this_EOL_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2241:2: ( ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL ) )
            // InternalNavascript.g:2242:2: ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL )
            {
            // InternalNavascript.g:2242:2: ( () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL )
            // InternalNavascript.g:2243:3: () this_INCLUDE_DEF_1= RULE_INCLUDE_DEF ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL
            {
            // InternalNavascript.g:2243:3: ()
            // InternalNavascript.g:2244:4: 
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
            // InternalNavascript.g:2254:3: ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2255:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2255:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2256:5: lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER
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

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_3, grammarAccess.getIncludeAccess().getEOLTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:2280:1: entryRuleAntiMessage returns [EObject current=null] : iv_ruleAntiMessage= ruleAntiMessage EOF ;
    public final EObject entryRuleAntiMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntiMessage = null;


        try {
            // InternalNavascript.g:2280:52: (iv_ruleAntiMessage= ruleAntiMessage EOF )
            // InternalNavascript.g:2281:2: iv_ruleAntiMessage= ruleAntiMessage EOF
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
    // InternalNavascript.g:2287:1: ruleAntiMessage returns [EObject current=null] : ( () this_ANTIMESSAGE_DEF_1= RULE_ANTIMESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL ) ;
    public final EObject ruleAntiMessage() throws RecognitionException {
        EObject current = null;

        Token this_ANTIMESSAGE_DEF_1=null;
        Token lv_messageName_2_0=null;
        Token this_EOL_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2293:2: ( ( () this_ANTIMESSAGE_DEF_1= RULE_ANTIMESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL ) )
            // InternalNavascript.g:2294:2: ( () this_ANTIMESSAGE_DEF_1= RULE_ANTIMESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL )
            {
            // InternalNavascript.g:2294:2: ( () this_ANTIMESSAGE_DEF_1= RULE_ANTIMESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL )
            // InternalNavascript.g:2295:3: () this_ANTIMESSAGE_DEF_1= RULE_ANTIMESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) this_EOL_3= RULE_EOL
            {
            // InternalNavascript.g:2295:3: ()
            // InternalNavascript.g:2296:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAntiMessageAccess().getAntiMessageAction_0(),
              					current);
              			
            }

            }

            this_ANTIMESSAGE_DEF_1=(Token)match(input,RULE_ANTIMESSAGE_DEF,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ANTIMESSAGE_DEF_1, grammarAccess.getAntiMessageAccess().getANTIMESSAGE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:2306:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2307:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2307:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2308:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
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

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_3, grammarAccess.getAntiMessageAccess().getEOLTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:2332:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalNavascript.g:2332:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalNavascript.g:2333:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalNavascript.g:2339:1: ruleMessage returns [EObject current=null] : ( () this_MESSAGE_DEF_1= RULE_MESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) ) ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token this_MESSAGE_DEF_1=null;
        Token lv_messageName_2_0=null;
        Token this_ARGS_START_3=null;
        Token this_ARGS_END_5=null;
        Token this_BLOCK_START_6=null;
        Token this_BLOCK_END_10=null;
        Token this_EOL_11=null;
        Token this_TML_START_12=null;
        Token this_TML_END_14=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_statements_7_0 = null;

        EObject lv_arrayField_8_0 = null;

        EObject lv_arrayMessage_9_0 = null;

        EObject lv_messageArray_13_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2345:2: ( ( () this_MESSAGE_DEF_1= RULE_MESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) ) ) )
            // InternalNavascript.g:2346:2: ( () this_MESSAGE_DEF_1= RULE_MESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) ) )
            {
            // InternalNavascript.g:2346:2: ( () this_MESSAGE_DEF_1= RULE_MESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) ) )
            // InternalNavascript.g:2347:3: () this_MESSAGE_DEF_1= RULE_MESSAGE_DEF ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )? ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) )
            {
            // InternalNavascript.g:2347:3: ()
            // InternalNavascript.g:2348:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageAccess().getMessageAction_0(),
              					current);
              			
            }

            }

            this_MESSAGE_DEF_1=(Token)match(input,RULE_MESSAGE_DEF,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_MESSAGE_DEF_1, grammarAccess.getMessageAccess().getMESSAGE_DEFTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:2358:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2359:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2359:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2360:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
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

            // InternalNavascript.g:2376:3: (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ARGS_START) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalNavascript.g:2377:4: this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleMessageArguments ) ) this_ARGS_END_5= RULE_ARGS_END
                    {
                    this_ARGS_START_3=(Token)match(input,RULE_ARGS_START,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_3, grammarAccess.getMessageAccess().getARGS_STARTTerminalRuleCall_3_0());
                      			
                    }
                    // InternalNavascript.g:2381:4: ( (lv_arguments_4_0= ruleMessageArguments ) )
                    // InternalNavascript.g:2382:5: (lv_arguments_4_0= ruleMessageArguments )
                    {
                    // InternalNavascript.g:2382:5: (lv_arguments_4_0= ruleMessageArguments )
                    // InternalNavascript.g:2383:6: lv_arguments_4_0= ruleMessageArguments
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

            // InternalNavascript.g:2405:3: ( (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | this_EOL_11= RULE_EOL | (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case RULE_BLOCK_START:
                {
                alt30=1;
                }
                break;
            case RULE_EOL:
                {
                alt30=2;
                }
                break;
            case RULE_TML_START:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalNavascript.g:2406:4: (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:2406:4: (this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END )
                    // InternalNavascript.g:2407:5: this_BLOCK_START_6= RULE_BLOCK_START ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) this_BLOCK_END_10= RULE_BLOCK_END
                    {
                    this_BLOCK_START_6=(Token)match(input,RULE_BLOCK_START,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_6, grammarAccess.getMessageAccess().getBLOCK_STARTTerminalRuleCall_4_0_0());
                      				
                    }
                    // InternalNavascript.g:2411:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )
                    int alt29=3;
                    switch ( input.LA(1) ) {
                    case RULE_IF:
                    case RULE_BLOCK_START:
                    case RULE_BLOCK_END:
                    case RULE_BREAK_DEF:
                    case RULE_DEFINE_DEF:
                    case RULE_PRINT_DEF:
                    case RULE_LOG_DEF:
                    case RULE_METHODS_DEF:
                    case RULE_LOOP_DEF:
                    case RULE_INCLUDE_DEF:
                    case RULE_ANTIMESSAGE_DEF:
                    case RULE_MESSAGE_DEF:
                    case RULE_MAP_DEF:
                    case RULE_MAP_OLDSKOOL_DEF:
                    case RULE_METHOD_IDENTIFIER:
                    case RULE_VAR_DEF:
                    case RULE_PROPERTY_DEF:
                    case RULE_OPTION_DEF:
                        {
                        alt29=1;
                        }
                        break;
                    case RULE_MAPPABLE_IDENTIFIER:
                        {
                        switch ( input.LA(2) ) {
                        case RULE_ARGS_START:
                            {
                            int LA29_4 = input.LA(3);

                            if ( (LA29_4==RULE_IDENTIFIER||(LA29_4>=102 && LA29_4<=104)) ) {
                                alt29=1;
                            }
                            else if ( (LA29_4==RULE_FILTER_DEF) ) {
                                alt29=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 29, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_BLOCK_START:
                            {
                            int LA29_5 = input.LA(3);

                            if ( (LA29_5==RULE_TML_LITERAL) ) {
                                alt29=1;
                            }
                            else if ( (LA29_5==RULE_IF||(LA29_5>=RULE_BLOCK_START && LA29_5<=RULE_BLOCK_END)||LA29_5==RULE_BREAK_DEF||LA29_5==RULE_DEFINE_DEF||(LA29_5>=RULE_PRINT_DEF && LA29_5<=RULE_LOG_DEF)||(LA29_5>=RULE_METHODS_DEF && LA29_5<=RULE_LOOP_DEF)||(LA29_5>=RULE_INCLUDE_DEF && LA29_5<=RULE_MESSAGE_DEF)||LA29_5==RULE_MAP_DEF||LA29_5==RULE_MAP_OLDSKOOL_DEF||(LA29_5>=RULE_METHOD_IDENTIFIER && LA29_5<=RULE_MAPPABLE_IDENTIFIER)||(LA29_5>=RULE_VAR_DEF && LA29_5<=RULE_OPTION_DEF)) ) {
                                alt29=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 29, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ASSIGNMENT:
                        case RULE_MAPPABLE_IDENTIFIER:
                            {
                            alt29=1;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 29, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case RULE_TML_LITERAL:
                        {
                        alt29=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }

                    switch (alt29) {
                        case 1 :
                            // InternalNavascript.g:2412:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            {
                            // InternalNavascript.g:2412:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==RULE_IF||LA28_0==RULE_BLOCK_START||LA28_0==RULE_BREAK_DEF||LA28_0==RULE_DEFINE_DEF||(LA28_0>=RULE_PRINT_DEF && LA28_0<=RULE_LOG_DEF)||(LA28_0>=RULE_METHODS_DEF && LA28_0<=RULE_LOOP_DEF)||(LA28_0>=RULE_INCLUDE_DEF && LA28_0<=RULE_MESSAGE_DEF)||LA28_0==RULE_MAP_DEF||LA28_0==RULE_MAP_OLDSKOOL_DEF||(LA28_0>=RULE_METHOD_IDENTIFIER && LA28_0<=RULE_MAPPABLE_IDENTIFIER)||(LA28_0>=RULE_VAR_DEF && LA28_0<=RULE_OPTION_DEF)) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // InternalNavascript.g:2413:7: (lv_statements_7_0= ruleInnerBody )
                            	    {
                            	    // InternalNavascript.g:2413:7: (lv_statements_7_0= ruleInnerBody )
                            	    // InternalNavascript.g:2414:8: lv_statements_7_0= ruleInnerBody
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
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2432:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            {
                            // InternalNavascript.g:2432:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            // InternalNavascript.g:2433:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            {
                            // InternalNavascript.g:2433:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            // InternalNavascript.g:2434:8: lv_arrayField_8_0= ruleMappedArrayField
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
                            // InternalNavascript.g:2452:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            {
                            // InternalNavascript.g:2452:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            // InternalNavascript.g:2453:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            {
                            // InternalNavascript.g:2453:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            // InternalNavascript.g:2454:8: lv_arrayMessage_9_0= ruleMappedArrayMessage
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

                    this_BLOCK_END_10=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_10, grammarAccess.getMessageAccess().getBLOCK_ENDTerminalRuleCall_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2478:4: this_EOL_11= RULE_EOL
                    {
                    this_EOL_11=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_EOL_11, grammarAccess.getMessageAccess().getEOLTerminalRuleCall_4_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:2483:4: (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END )
                    {
                    // InternalNavascript.g:2483:4: (this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END )
                    // InternalNavascript.g:2484:5: this_TML_START_12= RULE_TML_START ( (lv_messageArray_13_0= ruleMessageArray ) ) this_TML_END_14= RULE_TML_END
                    {
                    this_TML_START_12=(Token)match(input,RULE_TML_START,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_START_12, grammarAccess.getMessageAccess().getTML_STARTTerminalRuleCall_4_2_0());
                      				
                    }
                    // InternalNavascript.g:2488:5: ( (lv_messageArray_13_0= ruleMessageArray ) )
                    // InternalNavascript.g:2489:6: (lv_messageArray_13_0= ruleMessageArray )
                    {
                    // InternalNavascript.g:2489:6: (lv_messageArray_13_0= ruleMessageArray )
                    // InternalNavascript.g:2490:7: lv_messageArray_13_0= ruleMessageArray
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

                    this_TML_END_14=(Token)match(input,RULE_TML_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_END_14, grammarAccess.getMessageAccess().getTML_ENDTerminalRuleCall_4_2_2());
                      				
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
    // InternalNavascript.g:2517:1: entryRuleMessageArray returns [EObject current=null] : iv_ruleMessageArray= ruleMessageArray EOF ;
    public final EObject entryRuleMessageArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArray = null;


        try {
            // InternalNavascript.g:2517:53: (iv_ruleMessageArray= ruleMessageArray EOF )
            // InternalNavascript.g:2518:2: iv_ruleMessageArray= ruleMessageArray EOF
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
    // InternalNavascript.g:2524:1: ruleMessageArray returns [EObject current=null] : ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) ;
    public final EObject ruleMessageArray() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_1=null;
        EObject lv_arrayMessageElements_0_0 = null;

        EObject lv_arrayMessageElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2530:2: ( ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) )
            // InternalNavascript.g:2531:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            {
            // InternalNavascript.g:2531:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            // InternalNavascript.g:2532:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            {
            // InternalNavascript.g:2532:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) )
            // InternalNavascript.g:2533:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            {
            // InternalNavascript.g:2533:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            // InternalNavascript.g:2534:5: lv_arrayMessageElements_0_0= ruleMessageArrayElement
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

            // InternalNavascript.g:2551:3: (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ARG_SEP) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalNavascript.g:2552:4: this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    {
            	    this_ARG_SEP_1=(Token)match(input,RULE_ARG_SEP,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_1, grammarAccess.getMessageArrayAccess().getARG_SEPTerminalRuleCall_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2556:4: ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    // InternalNavascript.g:2557:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    {
            	    // InternalNavascript.g:2557:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    // InternalNavascript.g:2558:6: lv_arrayMessageElements_2_0= ruleMessageArrayElement
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
            	    break loop31;
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
    // InternalNavascript.g:2580:1: entryRuleMessageArrayElement returns [EObject current=null] : iv_ruleMessageArrayElement= ruleMessageArrayElement EOF ;
    public final EObject entryRuleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArrayElement = null;


        try {
            // InternalNavascript.g:2580:60: (iv_ruleMessageArrayElement= ruleMessageArrayElement EOF )
            // InternalNavascript.g:2581:2: iv_ruleMessageArrayElement= ruleMessageArrayElement EOF
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
    // InternalNavascript.g:2587:1: ruleMessageArrayElement returns [EObject current=null] : ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) ;
    public final EObject ruleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        Token this_BLOCK_START_1=null;
        Token this_BLOCK_END_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2593:2: ( ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) )
            // InternalNavascript.g:2594:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            {
            // InternalNavascript.g:2594:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            // InternalNavascript.g:2595:3: () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_statements_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END
            {
            // InternalNavascript.g:2595:3: ()
            // InternalNavascript.g:2596:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageArrayElementAccess().getMessageArrayElementAction_0(),
              					current);
              			
            }

            }

            this_BLOCK_START_1=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_1, grammarAccess.getMessageArrayElementAccess().getBLOCK_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:2606:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_IF||LA32_0==RULE_BLOCK_START||LA32_0==RULE_BREAK_DEF||LA32_0==RULE_DEFINE_DEF||(LA32_0>=RULE_PRINT_DEF && LA32_0<=RULE_LOG_DEF)||(LA32_0>=RULE_METHODS_DEF && LA32_0<=RULE_LOOP_DEF)||(LA32_0>=RULE_INCLUDE_DEF && LA32_0<=RULE_MESSAGE_DEF)||LA32_0==RULE_MAP_DEF||LA32_0==RULE_MAP_OLDSKOOL_DEF||(LA32_0>=RULE_METHOD_IDENTIFIER && LA32_0<=RULE_MAPPABLE_IDENTIFIER)||(LA32_0>=RULE_VAR_DEF && LA32_0<=RULE_OPTION_DEF)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalNavascript.g:2607:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2607:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:2608:5: lv_statements_2_0= ruleInnerBody
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
            	    break loop32;
                }
            } while (true);

            this_BLOCK_END_3=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_3, grammarAccess.getMessageArrayElementAccess().getBLOCK_ENDTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:2633:1: entryRuleMessageArgument returns [EObject current=null] : iv_ruleMessageArgument= ruleMessageArgument EOF ;
    public final EObject entryRuleMessageArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArgument = null;


        try {
            // InternalNavascript.g:2633:56: (iv_ruleMessageArgument= ruleMessageArgument EOF )
            // InternalNavascript.g:2634:2: iv_ruleMessageArgument= ruleMessageArgument EOF
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
    // InternalNavascript.g:2640:1: ruleMessageArgument returns [EObject current=null] : ( (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType ) | (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode ) ) ;
    public final EObject ruleMessageArgument() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token this_MODE_DEF_3=null;
        Token this_ASSIGNMENT_4=null;
        EObject this_MessageType_2 = null;

        EObject this_MessageMode_5 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2646:2: ( ( (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType ) | (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode ) ) )
            // InternalNavascript.g:2647:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType ) | (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode ) )
            {
            // InternalNavascript.g:2647:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType ) | (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_TYPE_DEF) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_MODE_DEF) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalNavascript.g:2648:3: (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType )
                    {
                    // InternalNavascript.g:2648:3: (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType )
                    // InternalNavascript.g:2649:4: this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT this_MessageType_2= ruleMessageType
                    {
                    this_TYPE_DEF_0=(Token)match(input,RULE_TYPE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_TYPE_DEF_0, grammarAccess.getMessageArgumentAccess().getTYPE_DEFTerminalRuleCall_0_0());
                      			
                    }
                    this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_1, grammarAccess.getMessageArgumentAccess().getASSIGNMENTTerminalRuleCall_0_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getMessageArgumentAccess().getMessageTypeParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MessageType_2=ruleMessageType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MessageType_2;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2667:3: (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode )
                    {
                    // InternalNavascript.g:2667:3: (this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode )
                    // InternalNavascript.g:2668:4: this_MODE_DEF_3= RULE_MODE_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT this_MessageMode_5= ruleMessageMode
                    {
                    this_MODE_DEF_3=(Token)match(input,RULE_MODE_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MODE_DEF_3, grammarAccess.getMessageArgumentAccess().getMODE_DEFTerminalRuleCall_1_0());
                      			
                    }
                    this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_4, grammarAccess.getMessageArgumentAccess().getASSIGNMENTTerminalRuleCall_1_1());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getMessageArgumentAccess().getMessageModeParserRuleCall_1_2());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_MessageMode_5=ruleMessageMode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_MessageMode_5;
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
    // InternalNavascript.g:2689:1: entryRuleMessageArguments returns [EObject current=null] : iv_ruleMessageArguments= ruleMessageArguments EOF ;
    public final EObject entryRuleMessageArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArguments = null;


        try {
            // InternalNavascript.g:2689:57: (iv_ruleMessageArguments= ruleMessageArguments EOF )
            // InternalNavascript.g:2690:2: iv_ruleMessageArguments= ruleMessageArguments EOF
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
    // InternalNavascript.g:2696:1: ruleMessageArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) ;
    public final EObject ruleMessageArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2702:2: ( ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) )
            // InternalNavascript.g:2703:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            {
            // InternalNavascript.g:2703:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            // InternalNavascript.g:2704:3: ( (lv_arguments_0_0= ruleMessageArgument ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            {
            // InternalNavascript.g:2704:3: ( (lv_arguments_0_0= ruleMessageArgument ) )
            // InternalNavascript.g:2705:4: (lv_arguments_0_0= ruleMessageArgument )
            {
            // InternalNavascript.g:2705:4: (lv_arguments_0_0= ruleMessageArgument )
            // InternalNavascript.g:2706:5: lv_arguments_0_0= ruleMessageArgument
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

            // InternalNavascript.g:2723:3: (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ARG_SEP) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalNavascript.g:2724:4: this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    {
            	    this_ARG_SEP_1=(Token)match(input,RULE_ARG_SEP,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_1, grammarAccess.getMessageArgumentsAccess().getARG_SEPTerminalRuleCall_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2728:4: ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    // InternalNavascript.g:2729:5: (lv_arguments_2_0= ruleMessageArgument )
            	    {
            	    // InternalNavascript.g:2729:5: (lv_arguments_2_0= ruleMessageArgument )
            	    // InternalNavascript.g:2730:6: lv_arguments_2_0= ruleMessageArgument
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
            	    break loop34;
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
    // InternalNavascript.g:2752:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalNavascript.g:2752:44: (iv_ruleMap= ruleMap EOF )
            // InternalNavascript.g:2753:2: iv_ruleMap= ruleMap EOF
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
    // InternalNavascript.g:2759:1: ruleMap returns [EObject current=null] : ( () ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) ) this_BLOCK_START_14= RULE_BLOCK_START ( (lv_statements_15_0= ruleInnerBody ) )* this_BLOCK_END_16= RULE_BLOCK_END ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token this_MAP_DEF_1=null;
        Token lv_adapterName_2_0=null;
        Token this_ARGS_START_3=null;
        Token this_ARGS_END_5=null;
        Token this_MAP_OLDSKOOL_DEF_6=null;
        Token this_ARGS_START_7=null;
        Token this_OBJECT_OLDSKOOL_DEF_8=null;
        Token this_ASSIGNMENT_9=null;
        Token lv_objectName_10_0=null;
        Token this_ARG_SEP_11=null;
        Token this_ARGS_END_13=null;
        Token this_BLOCK_START_14=null;
        Token this_BLOCK_END_16=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_statements_15_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2765:2: ( ( () ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) ) this_BLOCK_START_14= RULE_BLOCK_START ( (lv_statements_15_0= ruleInnerBody ) )* this_BLOCK_END_16= RULE_BLOCK_END ) )
            // InternalNavascript.g:2766:2: ( () ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) ) this_BLOCK_START_14= RULE_BLOCK_START ( (lv_statements_15_0= ruleInnerBody ) )* this_BLOCK_END_16= RULE_BLOCK_END )
            {
            // InternalNavascript.g:2766:2: ( () ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) ) this_BLOCK_START_14= RULE_BLOCK_START ( (lv_statements_15_0= ruleInnerBody ) )* this_BLOCK_END_16= RULE_BLOCK_END )
            // InternalNavascript.g:2767:3: () ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) ) this_BLOCK_START_14= RULE_BLOCK_START ( (lv_statements_15_0= ruleInnerBody ) )* this_BLOCK_END_16= RULE_BLOCK_END
            {
            // InternalNavascript.g:2767:3: ()
            // InternalNavascript.g:2768:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMapAccess().getMapAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2774:3: ( (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? ) | (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_MAP_DEF) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_MAP_OLDSKOOL_DEF) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalNavascript.g:2775:4: (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? )
                    {
                    // InternalNavascript.g:2775:4: (this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )? )
                    // InternalNavascript.g:2776:5: this_MAP_DEF_1= RULE_MAP_DEF ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )?
                    {
                    this_MAP_DEF_1=(Token)match(input,RULE_MAP_DEF,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_MAP_DEF_1, grammarAccess.getMapAccess().getMAP_DEFTerminalRuleCall_1_0_0());
                      				
                    }
                    // InternalNavascript.g:2780:5: ( (lv_adapterName_2_0= RULE_IDENTIFIER ) )
                    // InternalNavascript.g:2781:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    {
                    // InternalNavascript.g:2781:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    // InternalNavascript.g:2782:7: lv_adapterName_2_0= RULE_IDENTIFIER
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

                    // InternalNavascript.g:2798:5: (this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_ARGS_START) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalNavascript.g:2799:6: this_ARGS_START_3= RULE_ARGS_START ( (lv_arguments_4_0= ruleKeyValueArguments ) )? this_ARGS_END_5= RULE_ARGS_END
                            {
                            this_ARGS_START_3=(Token)match(input,RULE_ARGS_START,FOLLOW_42); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_START_3, grammarAccess.getMapAccess().getARGS_STARTTerminalRuleCall_1_0_2_0());
                              					
                            }
                            // InternalNavascript.g:2803:6: ( (lv_arguments_4_0= ruleKeyValueArguments ) )?
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==RULE_IDENTIFIER||(LA35_0>=102 && LA35_0<=104)) ) {
                                alt35=1;
                            }
                            switch (alt35) {
                                case 1 :
                                    // InternalNavascript.g:2804:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    {
                                    // InternalNavascript.g:2804:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    // InternalNavascript.g:2805:8: lv_arguments_4_0= ruleKeyValueArguments
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
                    // InternalNavascript.g:2829:4: (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END )
                    {
                    // InternalNavascript.g:2829:4: (this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END )
                    // InternalNavascript.g:2830:5: this_MAP_OLDSKOOL_DEF_6= RULE_MAP_OLDSKOOL_DEF this_ARGS_START_7= RULE_ARGS_START this_OBJECT_OLDSKOOL_DEF_8= RULE_OBJECT_OLDSKOOL_DEF this_ASSIGNMENT_9= RULE_ASSIGNMENT ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) ) (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )? this_ARGS_END_13= RULE_ARGS_END
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
                    this_ASSIGNMENT_9=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ASSIGNMENT_9, grammarAccess.getMapAccess().getASSIGNMENTTerminalRuleCall_1_1_3());
                      				
                    }
                    // InternalNavascript.g:2846:5: ( (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER ) )
                    // InternalNavascript.g:2847:6: (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER )
                    {
                    // InternalNavascript.g:2847:6: (lv_objectName_10_0= RULE_OBJECT_IDENTIFIER )
                    // InternalNavascript.g:2848:7: lv_objectName_10_0= RULE_OBJECT_IDENTIFIER
                    {
                    lv_objectName_10_0=(Token)match(input,RULE_OBJECT_IDENTIFIER,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_objectName_10_0, grammarAccess.getMapAccess().getObjectNameOBJECT_IDENTIFIERTerminalRuleCall_1_1_4_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getMapRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"objectName",
                      								lv_objectName_10_0,
                      								"com.dexels.navajo.Navascript.OBJECT_IDENTIFIER");
                      						
                    }

                    }


                    }

                    // InternalNavascript.g:2864:5: (this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_ARG_SEP) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalNavascript.g:2865:6: this_ARG_SEP_11= RULE_ARG_SEP ( (lv_arguments_12_0= ruleKeyValueArguments ) )
                            {
                            this_ARG_SEP_11=(Token)match(input,RULE_ARG_SEP,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARG_SEP_11, grammarAccess.getMapAccess().getARG_SEPTerminalRuleCall_1_1_5_0());
                              					
                            }
                            // InternalNavascript.g:2869:6: ( (lv_arguments_12_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:2870:7: (lv_arguments_12_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:2870:7: (lv_arguments_12_0= ruleKeyValueArguments )
                            // InternalNavascript.g:2871:8: lv_arguments_12_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMapAccess().getArgumentsKeyValueArgumentsParserRuleCall_1_1_5_1_0());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_arguments_12_0=ruleKeyValueArguments();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMapRule());
                              								}
                              								set(
                              									current,
                              									"arguments",
                              									lv_arguments_12_0,
                              									"com.dexels.navajo.Navascript.KeyValueArguments");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_ARGS_END_13=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ARGS_END_13, grammarAccess.getMapAccess().getARGS_ENDTerminalRuleCall_1_1_6());
                      				
                    }

                    }


                    }
                    break;

            }

            this_BLOCK_START_14=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_14, grammarAccess.getMapAccess().getBLOCK_STARTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:2899:3: ( (lv_statements_15_0= ruleInnerBody ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_IF||LA39_0==RULE_BLOCK_START||LA39_0==RULE_BREAK_DEF||LA39_0==RULE_DEFINE_DEF||(LA39_0>=RULE_PRINT_DEF && LA39_0<=RULE_LOG_DEF)||(LA39_0>=RULE_METHODS_DEF && LA39_0<=RULE_LOOP_DEF)||(LA39_0>=RULE_INCLUDE_DEF && LA39_0<=RULE_MESSAGE_DEF)||LA39_0==RULE_MAP_DEF||LA39_0==RULE_MAP_OLDSKOOL_DEF||(LA39_0>=RULE_METHOD_IDENTIFIER && LA39_0<=RULE_MAPPABLE_IDENTIFIER)||(LA39_0>=RULE_VAR_DEF && LA39_0<=RULE_OPTION_DEF)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalNavascript.g:2900:4: (lv_statements_15_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2900:4: (lv_statements_15_0= ruleInnerBody )
            	    // InternalNavascript.g:2901:5: lv_statements_15_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMapAccess().getStatementsInnerBodyParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_15_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMapRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_15_0,
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

            this_BLOCK_END_16=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_16, grammarAccess.getMapAccess().getBLOCK_ENDTerminalRuleCall_4());
              		
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
    // InternalNavascript.g:2926:1: entryRuleMethodOrSetter returns [EObject current=null] : iv_ruleMethodOrSetter= ruleMethodOrSetter EOF ;
    public final EObject entryRuleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodOrSetter = null;


        try {
            // InternalNavascript.g:2926:55: (iv_ruleMethodOrSetter= ruleMethodOrSetter EOF )
            // InternalNavascript.g:2927:2: iv_ruleMethodOrSetter= ruleMethodOrSetter EOF
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
    // InternalNavascript.g:2933:1: ruleMethodOrSetter returns [EObject current=null] : (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) ;
    public final EObject ruleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject this_AdapterMethod_0 = null;

        EObject this_SetterField_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2939:2: ( (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) )
            // InternalNavascript.g:2940:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            {
            // InternalNavascript.g:2940:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_METHOD_IDENTIFIER) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalNavascript.g:2941:3: this_AdapterMethod_0= ruleAdapterMethod
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
                    // InternalNavascript.g:2950:3: this_SetterField_1= ruleSetterField
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
    // InternalNavascript.g:2962:1: entryRuleAdapterMethod returns [EObject current=null] : iv_ruleAdapterMethod= ruleAdapterMethod EOF ;
    public final EObject entryRuleAdapterMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdapterMethod = null;


        try {
            // InternalNavascript.g:2962:54: (iv_ruleAdapterMethod= ruleAdapterMethod EOF )
            // InternalNavascript.g:2963:2: iv_ruleAdapterMethod= ruleAdapterMethod EOF
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
    // InternalNavascript.g:2969:1: ruleAdapterMethod returns [EObject current=null] : ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) ;
    public final EObject ruleAdapterMethod() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_ARGS_END_4=null;
        Token this_EOL_5=null;
        EObject lv_arguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2975:2: ( ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL ) )
            // InternalNavascript.g:2976:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            {
            // InternalNavascript.g:2976:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL )
            // InternalNavascript.g:2977:3: () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) this_ARGS_START_2= RULE_ARGS_START ( (lv_arguments_3_0= ruleKeyValueArguments ) )? this_ARGS_END_4= RULE_ARGS_END this_EOL_5= RULE_EOL
            {
            // InternalNavascript.g:2977:3: ()
            // InternalNavascript.g:2978:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAdapterMethodAccess().getAdapterMethodAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2984:3: ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) )
            // InternalNavascript.g:2985:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            {
            // InternalNavascript.g:2985:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            // InternalNavascript.g:2986:5: lv_method_1_0= RULE_METHOD_IDENTIFIER
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
            // InternalNavascript.g:3006:3: ( (lv_arguments_3_0= ruleKeyValueArguments ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_IDENTIFIER||(LA41_0>=102 && LA41_0<=104)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalNavascript.g:3007:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    {
                    // InternalNavascript.g:3007:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    // InternalNavascript.g:3008:5: lv_arguments_3_0= ruleKeyValueArguments
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
            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_5, grammarAccess.getAdapterMethodAccess().getEOLTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:3037:1: entryRuleSetterField returns [EObject current=null] : iv_ruleSetterField= ruleSetterField EOF ;
    public final EObject entryRuleSetterField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetterField = null;


        try {
            // InternalNavascript.g:3037:52: (iv_ruleSetterField= ruleSetterField EOF )
            // InternalNavascript.g:3038:2: iv_ruleSetterField= ruleSetterField EOF
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
    // InternalNavascript.g:3044:1: ruleSetterField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) ) ) ;
    public final EObject ruleSetterField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token this_ASSIGNMENT_2=null;
        Token this_EOL_4=null;
        Token this_ARGS_START_5=null;
        Token this_ARGS_END_7=null;
        Token this_BLOCK_START_8=null;
        Token this_BLOCK_END_10=null;
        EObject lv_expressionList_3_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_mappedArray_9_0 = null;

        EObject lv_mappedField_11_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3050:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) ) ) )
            // InternalNavascript.g:3051:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) ) )
            {
            // InternalNavascript.g:3051:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) ) )
            // InternalNavascript.g:3052:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) )
            {
            // InternalNavascript.g:3052:3: ()
            // InternalNavascript.g:3053:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetterFieldAccess().getSetterFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3059:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3060:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3060:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3061:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
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

            // InternalNavascript.g:3077:3: ( (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) | ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END ) | ( (lv_mappedField_11_0= ruleMappedArrayField ) ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNMENT:
                {
                alt43=1;
                }
                break;
            case RULE_BLOCK_START:
            case RULE_ARGS_START:
                {
                alt43=2;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalNavascript.g:3078:4: (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL )
                    {
                    // InternalNavascript.g:3078:4: (this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL )
                    // InternalNavascript.g:3079:5: this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL
                    {
                    this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ASSIGNMENT_2, grammarAccess.getSetterFieldAccess().getASSIGNMENTTerminalRuleCall_2_0_0());
                      				
                    }
                    // InternalNavascript.g:3083:5: ( (lv_expressionList_3_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3084:6: (lv_expressionList_3_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3084:6: (lv_expressionList_3_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3085:7: lv_expressionList_3_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getExpressionListConditionalExpressionsParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_22);
                    lv_expressionList_3_0=ruleConditionalExpressions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      							}
                      							set(
                      								current,
                      								"expressionList",
                      								lv_expressionList_3_0,
                      								"com.dexels.navajo.Navascript.ConditionalExpressions");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_EOL_4, grammarAccess.getSetterFieldAccess().getEOLTerminalRuleCall_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3108:4: ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:3108:4: ( (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END )
                    // InternalNavascript.g:3109:5: (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )? this_BLOCK_START_8= RULE_BLOCK_START ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) ) this_BLOCK_END_10= RULE_BLOCK_END
                    {
                    // InternalNavascript.g:3109:5: (this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ARGS_START) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalNavascript.g:3110:6: this_ARGS_START_5= RULE_ARGS_START ( (lv_arguments_6_0= ruleKeyValueArguments ) ) this_ARGS_END_7= RULE_ARGS_END
                            {
                            this_ARGS_START_5=(Token)match(input,RULE_ARGS_START,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_START_5, grammarAccess.getSetterFieldAccess().getARGS_STARTTerminalRuleCall_2_1_0_0());
                              					
                            }
                            // InternalNavascript.g:3114:6: ( (lv_arguments_6_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3115:7: (lv_arguments_6_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3115:7: (lv_arguments_6_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3116:8: lv_arguments_6_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getSetterFieldAccess().getArgumentsKeyValueArgumentsParserRuleCall_2_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_13);
                            lv_arguments_6_0=ruleKeyValueArguments();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                              								}
                              								set(
                              									current,
                              									"arguments",
                              									lv_arguments_6_0,
                              									"com.dexels.navajo.Navascript.KeyValueArguments");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            this_ARGS_END_7=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ARGS_END_7, grammarAccess.getSetterFieldAccess().getARGS_ENDTerminalRuleCall_2_1_0_2());
                              					
                            }

                            }
                            break;

                    }

                    this_BLOCK_START_8=(Token)match(input,RULE_BLOCK_START,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_8, grammarAccess.getSetterFieldAccess().getBLOCK_STARTTerminalRuleCall_2_1_1());
                      				
                    }
                    // InternalNavascript.g:3142:5: ( (lv_mappedArray_9_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3143:6: (lv_mappedArray_9_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3143:6: (lv_mappedArray_9_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3144:7: lv_mappedArray_9_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedArrayMappedArrayMessageParserRuleCall_2_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArray_9_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      							}
                      							set(
                      								current,
                      								"mappedArray",
                      								lv_mappedArray_9_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_BLOCK_END_10=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_10, grammarAccess.getSetterFieldAccess().getBLOCK_ENDTerminalRuleCall_2_1_3());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3167:4: ( (lv_mappedField_11_0= ruleMappedArrayField ) )
                    {
                    // InternalNavascript.g:3167:4: ( (lv_mappedField_11_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3168:5: (lv_mappedField_11_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3168:5: (lv_mappedField_11_0= ruleMappedArrayField )
                    // InternalNavascript.g:3169:6: lv_mappedField_11_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedFieldMappedArrayFieldParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_mappedField_11_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      						}
                      						set(
                      							current,
                      							"mappedField",
                      							lv_mappedField_11_0,
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
    // InternalNavascript.g:3191:1: entryRuleMappedArrayField returns [EObject current=null] : iv_ruleMappedArrayField= ruleMappedArrayField EOF ;
    public final EObject entryRuleMappedArrayField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayField = null;


        try {
            // InternalNavascript.g:3191:57: (iv_ruleMappedArrayField= ruleMappedArrayField EOF )
            // InternalNavascript.g:3192:2: iv_ruleMappedArrayField= ruleMappedArrayField EOF
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
    // InternalNavascript.g:3198:1: ruleMappedArrayField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END ) ;
    public final EObject ruleMappedArrayField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_FILTER_DEF_3=null;
        Token this_ASSIGNMENT_4=null;
        Token this_ARGS_END_6=null;
        Token this_BLOCK_START_7=null;
        Token this_BLOCK_END_9=null;
        EObject lv_filter_5_0 = null;

        EObject lv_statements_8_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3204:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END ) )
            // InternalNavascript.g:3205:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END )
            {
            // InternalNavascript.g:3205:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END )
            // InternalNavascript.g:3206:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END
            {
            // InternalNavascript.g:3206:3: ()
            // InternalNavascript.g:3207:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayFieldAccess().getMappedArrayFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3213:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3214:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3214:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3215:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
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

            // InternalNavascript.g:3231:3: (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ARGS_START) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalNavascript.g:3232:4: this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappedArrayFieldAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    this_FILTER_DEF_3=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_3, grammarAccess.getMappedArrayFieldAccess().getFILTER_DEFTerminalRuleCall_2_1());
                      			
                    }
                    this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_4, grammarAccess.getMappedArrayFieldAccess().getASSIGNMENTTerminalRuleCall_2_2());
                      			
                    }
                    // InternalNavascript.g:3244:4: ( (lv_filter_5_0= ruleExpression ) )
                    // InternalNavascript.g:3245:5: (lv_filter_5_0= ruleExpression )
                    {
                    // InternalNavascript.g:3245:5: (lv_filter_5_0= ruleExpression )
                    // InternalNavascript.g:3246:6: lv_filter_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMappedArrayFieldRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_5_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_6=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_6, grammarAccess.getMappedArrayFieldAccess().getARGS_ENDTerminalRuleCall_2_4());
                      			
                    }

                    }
                    break;

            }

            this_BLOCK_START_7=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_7, grammarAccess.getMappedArrayFieldAccess().getBLOCK_STARTTerminalRuleCall_3());
              		
            }
            // InternalNavascript.g:3272:3: ( (lv_statements_8_0= ruleInnerBody ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_IF||LA45_0==RULE_BLOCK_START||LA45_0==RULE_BREAK_DEF||LA45_0==RULE_DEFINE_DEF||(LA45_0>=RULE_PRINT_DEF && LA45_0<=RULE_LOG_DEF)||(LA45_0>=RULE_METHODS_DEF && LA45_0<=RULE_LOOP_DEF)||(LA45_0>=RULE_INCLUDE_DEF && LA45_0<=RULE_MESSAGE_DEF)||LA45_0==RULE_MAP_DEF||LA45_0==RULE_MAP_OLDSKOOL_DEF||(LA45_0>=RULE_METHOD_IDENTIFIER && LA45_0<=RULE_MAPPABLE_IDENTIFIER)||(LA45_0>=RULE_VAR_DEF && LA45_0<=RULE_OPTION_DEF)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalNavascript.g:3273:4: (lv_statements_8_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3273:4: (lv_statements_8_0= ruleInnerBody )
            	    // InternalNavascript.g:3274:5: lv_statements_8_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_8_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMappedArrayFieldRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_8_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            this_BLOCK_END_9=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_9, grammarAccess.getMappedArrayFieldAccess().getBLOCK_ENDTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:3299:1: entryRuleMappedArrayMessage returns [EObject current=null] : iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF ;
    public final EObject entryRuleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayMessage = null;


        try {
            // InternalNavascript.g:3299:59: (iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF )
            // InternalNavascript.g:3300:2: iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF
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
    // InternalNavascript.g:3306:1: ruleMappedArrayMessage returns [EObject current=null] : ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END ) ;
    public final EObject ruleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_FILTER_DEF_3=null;
        Token this_ASSIGNMENT_4=null;
        Token this_ARGS_END_6=null;
        Token this_BLOCK_START_7=null;
        Token this_BLOCK_END_9=null;
        EObject lv_filter_5_0 = null;

        EObject lv_statements_8_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3312:2: ( ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END ) )
            // InternalNavascript.g:3313:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END )
            {
            // InternalNavascript.g:3313:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END )
            // InternalNavascript.g:3314:3: () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )? this_BLOCK_START_7= RULE_BLOCK_START ( (lv_statements_8_0= ruleInnerBody ) )* this_BLOCK_END_9= RULE_BLOCK_END
            {
            // InternalNavascript.g:3314:3: ()
            // InternalNavascript.g:3315:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayMessageAccess().getMappedArrayMessageAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3321:3: ( (lv_message_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:3322:4: (lv_message_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:3322:4: (lv_message_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:3323:5: lv_message_1_0= RULE_TML_LITERAL
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

            // InternalNavascript.g:3339:3: (this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ARGS_START) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalNavascript.g:3340:4: this_ARGS_START_2= RULE_ARGS_START this_FILTER_DEF_3= RULE_FILTER_DEF this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_filter_5_0= ruleExpression ) ) this_ARGS_END_6= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappedArrayMessageAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    this_FILTER_DEF_3=(Token)match(input,RULE_FILTER_DEF,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FILTER_DEF_3, grammarAccess.getMappedArrayMessageAccess().getFILTER_DEFTerminalRuleCall_2_1());
                      			
                    }
                    this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ASSIGNMENT_4, grammarAccess.getMappedArrayMessageAccess().getASSIGNMENTTerminalRuleCall_2_2());
                      			
                    }
                    // InternalNavascript.g:3352:4: ( (lv_filter_5_0= ruleExpression ) )
                    // InternalNavascript.g:3353:5: (lv_filter_5_0= ruleExpression )
                    {
                    // InternalNavascript.g:3353:5: (lv_filter_5_0= ruleExpression )
                    // InternalNavascript.g:3354:6: lv_filter_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_filter_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMappedArrayMessageRule());
                      						}
                      						set(
                      							current,
                      							"filter",
                      							lv_filter_5_0,
                      							"com.dexels.navajo.Navascript.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_ARGS_END_6=(Token)match(input,RULE_ARGS_END,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_END_6, grammarAccess.getMappedArrayMessageAccess().getARGS_ENDTerminalRuleCall_2_4());
                      			
                    }

                    }
                    break;

            }

            this_BLOCK_START_7=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_7, grammarAccess.getMappedArrayMessageAccess().getBLOCK_STARTTerminalRuleCall_3());
              		
            }
            // InternalNavascript.g:3380:3: ( (lv_statements_8_0= ruleInnerBody ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_IF||LA47_0==RULE_BLOCK_START||LA47_0==RULE_BREAK_DEF||LA47_0==RULE_DEFINE_DEF||(LA47_0>=RULE_PRINT_DEF && LA47_0<=RULE_LOG_DEF)||(LA47_0>=RULE_METHODS_DEF && LA47_0<=RULE_LOOP_DEF)||(LA47_0>=RULE_INCLUDE_DEF && LA47_0<=RULE_MESSAGE_DEF)||LA47_0==RULE_MAP_DEF||LA47_0==RULE_MAP_OLDSKOOL_DEF||(LA47_0>=RULE_METHOD_IDENTIFIER && LA47_0<=RULE_MAPPABLE_IDENTIFIER)||(LA47_0>=RULE_VAR_DEF && LA47_0<=RULE_OPTION_DEF)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalNavascript.g:3381:4: (lv_statements_8_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3381:4: (lv_statements_8_0= ruleInnerBody )
            	    // InternalNavascript.g:3382:5: lv_statements_8_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_8_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMappedArrayMessageRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_8_0,
            	      						"com.dexels.navajo.Navascript.InnerBody");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            this_BLOCK_END_9=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_9, grammarAccess.getMappedArrayMessageAccess().getBLOCK_ENDTerminalRuleCall_5());
              		
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
    // InternalNavascript.g:3407:1: entryRuleKeyValueArguments returns [EObject current=null] : iv_ruleKeyValueArguments= ruleKeyValueArguments EOF ;
    public final EObject entryRuleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArguments = null;


        try {
            // InternalNavascript.g:3407:58: (iv_ruleKeyValueArguments= ruleKeyValueArguments EOF )
            // InternalNavascript.g:3408:2: iv_ruleKeyValueArguments= ruleKeyValueArguments EOF
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
    // InternalNavascript.g:3414:1: ruleKeyValueArguments returns [EObject current=null] : ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) ;
    public final EObject ruleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_2=null;
        EObject lv_keyValueArguments_1_0 = null;

        EObject lv_keyValueArguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3420:2: ( ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) )
            // InternalNavascript.g:3421:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            {
            // InternalNavascript.g:3421:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            // InternalNavascript.g:3422:3: () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            {
            // InternalNavascript.g:3422:3: ()
            // InternalNavascript.g:3423:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3429:3: ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) )
            // InternalNavascript.g:3430:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            {
            // InternalNavascript.g:3430:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            // InternalNavascript.g:3431:5: lv_keyValueArguments_1_0= ruleKeyValueArgument
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

            // InternalNavascript.g:3448:3: (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ARG_SEP) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalNavascript.g:3449:4: this_ARG_SEP_2= RULE_ARG_SEP ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    {
            	    this_ARG_SEP_2=(Token)match(input,RULE_ARG_SEP,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_2, grammarAccess.getKeyValueArgumentsAccess().getARG_SEPTerminalRuleCall_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:3453:4: ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    // InternalNavascript.g:3454:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    {
            	    // InternalNavascript.g:3454:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    // InternalNavascript.g:3455:6: lv_keyValueArguments_3_0= ruleKeyValueArgument
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
            	    break loop48;
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
    // InternalNavascript.g:3477:1: entryRuleKeyValueArgument returns [EObject current=null] : iv_ruleKeyValueArgument= ruleKeyValueArgument EOF ;
    public final EObject entryRuleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArgument = null;


        try {
            // InternalNavascript.g:3477:57: (iv_ruleKeyValueArgument= ruleKeyValueArgument EOF )
            // InternalNavascript.g:3478:2: iv_ruleKeyValueArgument= ruleKeyValueArgument EOF
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
    // InternalNavascript.g:3484:1: ruleKeyValueArgument returns [EObject current=null] : ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_1=null;
        Token this_ASSIGNMENT_2=null;
        AntlrDatatypeRuleToken lv_key_1_2 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3490:2: ( ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:3491:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:3491:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:3492:3: () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_value_3_0= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:3492:3: ()
            // InternalNavascript.g:3493:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentAccess().getKeyValueArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3499:3: ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) )
            // InternalNavascript.g:3500:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            {
            // InternalNavascript.g:3500:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            // InternalNavascript.g:3501:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:3501:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_IDENTIFIER) ) {
                alt49=1;
            }
            else if ( ((LA49_0>=102 && LA49_0<=104)) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalNavascript.g:3502:6: lv_key_1_1= RULE_IDENTIFIER
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
                    // InternalNavascript.g:3517:6: lv_key_1_2= ruleOPTION_TYPE
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

            this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_2, grammarAccess.getKeyValueArgumentAccess().getASSIGNMENTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:3539:3: ( (lv_value_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:3540:4: (lv_value_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:3540:4: (lv_value_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:3541:5: lv_value_3_0= ruleLiteralOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getKeyValueArgumentAccess().getValueLiteralOrExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getKeyValueArgumentRule());
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
    // $ANTLR end "ruleKeyValueArgument"


    // $ANTLR start "entryRuleVar"
    // InternalNavascript.g:3562:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalNavascript.g:3562:44: (iv_ruleVar= ruleVar EOF )
            // InternalNavascript.g:3563:2: iv_ruleVar= ruleVar EOF
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
    // InternalNavascript.g:3569:1: ruleVar returns [EObject current=null] : ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token this_VAR_DEF_1=null;
        Token lv_varName_2_0=null;
        Token this_ASSIGNMENT_4=null;
        Token this_EOL_6=null;
        Token this_TML_START_7=null;
        Token this_TML_END_9=null;
        Token this_BLOCK_START_10=null;
        Token this_BLOCK_END_12=null;
        Token this_BLOCK_START_13=null;
        Token this_BLOCK_END_15=null;
        Token this_BLOCK_START_16=null;
        Token this_BLOCK_END_18=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_expressionList_5_0 = null;

        EObject lv_varArray_8_0 = null;

        EObject lv_varElements_11_0 = null;

        EObject lv_mappedArrayField_14_0 = null;

        EObject lv_mappedArrayMessage_17_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3575:2: ( ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) ) ) )
            // InternalNavascript.g:3576:2: ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) ) )
            {
            // InternalNavascript.g:3576:2: ( () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) ) )
            // InternalNavascript.g:3577:3: () this_VAR_DEF_1= RULE_VAR_DEF ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) )
            {
            // InternalNavascript.g:3577:3: ()
            // InternalNavascript.g:3578:4: 
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
            // InternalNavascript.g:3588:3: ( (lv_varName_2_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:3589:4: (lv_varName_2_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:3589:4: (lv_varName_2_0= RULE_IDENTIFIER )
            // InternalNavascript.g:3590:5: lv_varName_2_0= RULE_IDENTIFIER
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

            // InternalNavascript.g:3606:3: ( (lv_arguments_3_0= ruleVarArguments ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ARGS_START) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalNavascript.g:3607:4: (lv_arguments_3_0= ruleVarArguments )
                    {
                    // InternalNavascript.g:3607:4: (lv_arguments_3_0= ruleVarArguments )
                    // InternalNavascript.g:3608:5: lv_arguments_3_0= ruleVarArguments
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

            // InternalNavascript.g:3625:3: ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END ) | (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END ) )
            int alt53=5;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNMENT:
                {
                alt53=1;
                }
                break;
            case RULE_TML_START:
                {
                alt53=2;
                }
                break;
            case RULE_BLOCK_START:
                {
                switch ( input.LA(2) ) {
                case RULE_MAPPABLE_IDENTIFIER:
                    {
                    alt53=4;
                    }
                    break;
                case RULE_TML_LITERAL:
                    {
                    alt53=5;
                    }
                    break;
                case RULE_IF:
                case RULE_BLOCK_END:
                case RULE_VAR_DEF:
                    {
                    alt53=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalNavascript.g:3626:4: (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL )
                    {
                    // InternalNavascript.g:3626:4: (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL )
                    // InternalNavascript.g:3627:5: this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) this_EOL_6= RULE_EOL
                    {
                    this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_ASSIGNMENT_4, grammarAccess.getVarAccess().getASSIGNMENTTerminalRuleCall_4_0_0());
                      				
                    }
                    // InternalNavascript.g:3631:5: ( (lv_expressionList_5_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3632:6: (lv_expressionList_5_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3632:6: (lv_expressionList_5_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3633:7: lv_expressionList_5_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_22);
                    lv_expressionList_5_0=ruleConditionalExpressions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"expressionList",
                      								lv_expressionList_5_0,
                      								"com.dexels.navajo.Navascript.ConditionalExpressions");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_EOL_6=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_EOL_6, grammarAccess.getVarAccess().getEOLTerminalRuleCall_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3656:4: (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END )
                    {
                    // InternalNavascript.g:3656:4: (this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END )
                    // InternalNavascript.g:3657:5: this_TML_START_7= RULE_TML_START ( (lv_varArray_8_0= ruleVarArray ) )? this_TML_END_9= RULE_TML_END
                    {
                    this_TML_START_7=(Token)match(input,RULE_TML_START,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_START_7, grammarAccess.getVarAccess().getTML_STARTTerminalRuleCall_4_1_0());
                      				
                    }
                    // InternalNavascript.g:3661:5: ( (lv_varArray_8_0= ruleVarArray ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_BLOCK_START) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalNavascript.g:3662:6: (lv_varArray_8_0= ruleVarArray )
                            {
                            // InternalNavascript.g:3662:6: (lv_varArray_8_0= ruleVarArray )
                            // InternalNavascript.g:3663:7: lv_varArray_8_0= ruleVarArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVarAccess().getVarArrayVarArrayParserRuleCall_4_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_38);
                            lv_varArray_8_0=ruleVarArray();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getVarRule());
                              							}
                              							set(
                              								current,
                              								"varArray",
                              								lv_varArray_8_0,
                              								"com.dexels.navajo.Navascript.VarArray");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    this_TML_END_9=(Token)match(input,RULE_TML_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_END_9, grammarAccess.getVarAccess().getTML_ENDTerminalRuleCall_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3686:4: (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:3686:4: (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END )
                    // InternalNavascript.g:3687:5: this_BLOCK_START_10= RULE_BLOCK_START ( (lv_varElements_11_0= ruleVarElement ) )* this_BLOCK_END_12= RULE_BLOCK_END
                    {
                    this_BLOCK_START_10=(Token)match(input,RULE_BLOCK_START,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_10, grammarAccess.getVarAccess().getBLOCK_STARTTerminalRuleCall_4_2_0());
                      				
                    }
                    // InternalNavascript.g:3691:5: ( (lv_varElements_11_0= ruleVarElement ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==RULE_IF||LA52_0==RULE_VAR_DEF) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalNavascript.g:3692:6: (lv_varElements_11_0= ruleVarElement )
                    	    {
                    	    // InternalNavascript.g:3692:6: (lv_varElements_11_0= ruleVarElement )
                    	    // InternalNavascript.g:3693:7: lv_varElements_11_0= ruleVarElement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getVarAccess().getVarElementsVarElementParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_51);
                    	    lv_varElements_11_0=ruleVarElement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getVarRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"varElements",
                    	      								lv_varElements_11_0,
                    	      								"com.dexels.navajo.Navascript.VarElement");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    this_BLOCK_END_12=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_12, grammarAccess.getVarAccess().getBLOCK_ENDTerminalRuleCall_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:3716:4: (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:3716:4: (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END )
                    // InternalNavascript.g:3717:5: this_BLOCK_START_13= RULE_BLOCK_START ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) ) this_BLOCK_END_15= RULE_BLOCK_END
                    {
                    this_BLOCK_START_13=(Token)match(input,RULE_BLOCK_START,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_13, grammarAccess.getVarAccess().getBLOCK_STARTTerminalRuleCall_4_3_0());
                      				
                    }
                    // InternalNavascript.g:3721:5: ( (lv_mappedArrayField_14_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3722:6: (lv_mappedArrayField_14_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3722:6: (lv_mappedArrayField_14_0= ruleMappedArrayField )
                    // InternalNavascript.g:3723:7: lv_mappedArrayField_14_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayFieldMappedArrayFieldParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArrayField_14_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"mappedArrayField",
                      								lv_mappedArrayField_14_0,
                      								"com.dexels.navajo.Navascript.MappedArrayField");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_BLOCK_END_15=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_15, grammarAccess.getVarAccess().getBLOCK_ENDTerminalRuleCall_4_3_2());
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:3746:4: (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:3746:4: (this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END )
                    // InternalNavascript.g:3747:5: this_BLOCK_START_16= RULE_BLOCK_START ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) ) this_BLOCK_END_18= RULE_BLOCK_END
                    {
                    this_BLOCK_START_16=(Token)match(input,RULE_BLOCK_START,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_16, grammarAccess.getVarAccess().getBLOCK_STARTTerminalRuleCall_4_4_0());
                      				
                    }
                    // InternalNavascript.g:3751:5: ( (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3752:6: (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3752:6: (lv_mappedArrayMessage_17_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3753:7: lv_mappedArrayMessage_17_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayMessageMappedArrayMessageParserRuleCall_4_4_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_mappedArrayMessage_17_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getVarRule());
                      							}
                      							set(
                      								current,
                      								"mappedArrayMessage",
                      								lv_mappedArrayMessage_17_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_BLOCK_END_18=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_18, grammarAccess.getVarAccess().getBLOCK_ENDTerminalRuleCall_4_4_2());
                      				
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
    // InternalNavascript.g:3780:1: entryRuleVarArray returns [EObject current=null] : iv_ruleVarArray= ruleVarArray EOF ;
    public final EObject entryRuleVarArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArray = null;


        try {
            // InternalNavascript.g:3780:49: (iv_ruleVarArray= ruleVarArray EOF )
            // InternalNavascript.g:3781:2: iv_ruleVarArray= ruleVarArray EOF
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
    // InternalNavascript.g:3787:1: ruleVarArray returns [EObject current=null] : ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) ;
    public final EObject ruleVarArray() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_2=null;
        EObject lv_vararrayelement_1_0 = null;

        EObject lv_vararrayelement_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3793:2: ( ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) )
            // InternalNavascript.g:3794:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            {
            // InternalNavascript.g:3794:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            // InternalNavascript.g:3795:3: () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            {
            // InternalNavascript.g:3795:3: ()
            // InternalNavascript.g:3796:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayAccess().getVarArrayAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3802:3: ( (lv_vararrayelement_1_0= ruleVarArrayElement ) )
            // InternalNavascript.g:3803:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            {
            // InternalNavascript.g:3803:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            // InternalNavascript.g:3804:5: lv_vararrayelement_1_0= ruleVarArrayElement
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

            // InternalNavascript.g:3821:3: (this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ARG_SEP) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalNavascript.g:3822:4: this_ARG_SEP_2= RULE_ARG_SEP ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    {
            	    this_ARG_SEP_2=(Token)match(input,RULE_ARG_SEP,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_2, grammarAccess.getVarArrayAccess().getARG_SEPTerminalRuleCall_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:3826:4: ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    // InternalNavascript.g:3827:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    {
            	    // InternalNavascript.g:3827:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    // InternalNavascript.g:3828:6: lv_vararrayelement_3_0= ruleVarArrayElement
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
            	    break loop54;
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
    // InternalNavascript.g:3850:1: entryRuleVarArrayElement returns [EObject current=null] : iv_ruleVarArrayElement= ruleVarArrayElement EOF ;
    public final EObject entryRuleVarArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArrayElement = null;


        try {
            // InternalNavascript.g:3850:56: (iv_ruleVarArrayElement= ruleVarArrayElement EOF )
            // InternalNavascript.g:3851:2: iv_ruleVarArrayElement= ruleVarArrayElement EOF
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
    // InternalNavascript.g:3857:1: ruleVarArrayElement returns [EObject current=null] : ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_varElements_2_0= ruleVarElement ) )* this_BLOCK_END_3= RULE_BLOCK_END ) ;
    public final EObject ruleVarArrayElement() throws RecognitionException {
        EObject current = null;

        Token this_BLOCK_START_1=null;
        Token this_BLOCK_END_3=null;
        EObject lv_varElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3863:2: ( ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_varElements_2_0= ruleVarElement ) )* this_BLOCK_END_3= RULE_BLOCK_END ) )
            // InternalNavascript.g:3864:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_varElements_2_0= ruleVarElement ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            {
            // InternalNavascript.g:3864:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_varElements_2_0= ruleVarElement ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            // InternalNavascript.g:3865:3: () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_varElements_2_0= ruleVarElement ) )* this_BLOCK_END_3= RULE_BLOCK_END
            {
            // InternalNavascript.g:3865:3: ()
            // InternalNavascript.g:3866:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayElementAccess().getVarArrayElementAction_0(),
              					current);
              			
            }

            }

            this_BLOCK_START_1=(Token)match(input,RULE_BLOCK_START,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_1, grammarAccess.getVarArrayElementAccess().getBLOCK_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:3876:3: ( (lv_varElements_2_0= ruleVarElement ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_IF||LA55_0==RULE_VAR_DEF) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalNavascript.g:3877:4: (lv_varElements_2_0= ruleVarElement )
            	    {
            	    // InternalNavascript.g:3877:4: (lv_varElements_2_0= ruleVarElement )
            	    // InternalNavascript.g:3878:5: lv_varElements_2_0= ruleVarElement
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
            	    break loop55;
                }
            } while (true);

            this_BLOCK_END_3=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_3, grammarAccess.getVarArrayElementAccess().getBLOCK_ENDTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:3903:1: entryRuleVarElement returns [EObject current=null] : iv_ruleVarElement= ruleVarElement EOF ;
    public final EObject entryRuleVarElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarElement = null;


        try {
            // InternalNavascript.g:3903:51: (iv_ruleVarElement= ruleVarElement EOF )
            // InternalNavascript.g:3904:2: iv_ruleVarElement= ruleVarElement EOF
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
    // InternalNavascript.g:3910:1: ruleVarElement returns [EObject current=null] : ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( (lv_var_4_0= ruleVar ) ) ) ;
    public final EObject ruleVarElement() throws RecognitionException {
        EObject current = null;

        Token this_IF_1=null;
        Token this_THEN_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_var_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3916:2: ( ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( (lv_var_4_0= ruleVar ) ) ) )
            // InternalNavascript.g:3917:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( (lv_var_4_0= ruleVar ) ) )
            {
            // InternalNavascript.g:3917:2: ( () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( (lv_var_4_0= ruleVar ) ) )
            // InternalNavascript.g:3918:3: () (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )? ( (lv_var_4_0= ruleVar ) )
            {
            // InternalNavascript.g:3918:3: ()
            // InternalNavascript.g:3919:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarElementAccess().getVarElementAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3925:3: (this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_IF) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalNavascript.g:3926:4: this_IF_1= RULE_IF ( (lv_condition_2_0= ruleExpression ) ) this_THEN_3= RULE_THEN
                    {
                    this_IF_1=(Token)match(input,RULE_IF,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_IF_1, grammarAccess.getVarElementAccess().getIFTerminalRuleCall_1_0());
                      			
                    }
                    // InternalNavascript.g:3930:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:3931:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:3931:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:3932:6: lv_condition_2_0= ruleExpression
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

                    this_THEN_3=(Token)match(input,RULE_THEN,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_THEN_3, grammarAccess.getVarElementAccess().getTHENTerminalRuleCall_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:3954:3: ( (lv_var_4_0= ruleVar ) )
            // InternalNavascript.g:3955:4: (lv_var_4_0= ruleVar )
            {
            // InternalNavascript.g:3955:4: (lv_var_4_0= ruleVar )
            // InternalNavascript.g:3956:5: lv_var_4_0= ruleVar
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
    // InternalNavascript.g:3977:1: entryRuleVarArguments returns [EObject current=null] : iv_ruleVarArguments= ruleVarArguments EOF ;
    public final EObject entryRuleVarArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArguments = null;


        try {
            // InternalNavascript.g:3977:53: (iv_ruleVarArguments= ruleVarArguments EOF )
            // InternalNavascript.g:3978:2: iv_ruleVarArguments= ruleVarArguments EOF
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
    // InternalNavascript.g:3984:1: ruleVarArguments returns [EObject current=null] : ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) ;
    public final EObject ruleVarArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARGS_START_1=null;
        Token this_ARG_SEP_3=null;
        Token this_ARGS_END_5=null;
        EObject lv_varArguments_2_0 = null;

        EObject lv_varArguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3990:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) )
            // InternalNavascript.g:3991:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            {
            // InternalNavascript.g:3991:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            // InternalNavascript.g:3992:3: () this_ARGS_START_1= RULE_ARGS_START ( (lv_varArguments_2_0= ruleVarArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END
            {
            // InternalNavascript.g:3992:3: ()
            // InternalNavascript.g:3993:4: 
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
            // InternalNavascript.g:4003:3: ( (lv_varArguments_2_0= ruleVarArgument ) )
            // InternalNavascript.g:4004:4: (lv_varArguments_2_0= ruleVarArgument )
            {
            // InternalNavascript.g:4004:4: (lv_varArguments_2_0= ruleVarArgument )
            // InternalNavascript.g:4005:5: lv_varArguments_2_0= ruleVarArgument
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

            // InternalNavascript.g:4022:3: (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ARG_SEP) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalNavascript.g:4023:4: this_ARG_SEP_3= RULE_ARG_SEP ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    {
            	    this_ARG_SEP_3=(Token)match(input,RULE_ARG_SEP,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_3, grammarAccess.getVarArgumentsAccess().getARG_SEPTerminalRuleCall_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4027:4: ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    // InternalNavascript.g:4028:5: (lv_varArguments_4_0= ruleVarArgument )
            	    {
            	    // InternalNavascript.g:4028:5: (lv_varArguments_4_0= ruleVarArgument )
            	    // InternalNavascript.g:4029:6: lv_varArguments_4_0= ruleVarArgument
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
            	    break loop57;
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
    // InternalNavascript.g:4055:1: entryRuleVarArgument returns [EObject current=null] : iv_ruleVarArgument= ruleVarArgument EOF ;
    public final EObject entryRuleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArgument = null;


        try {
            // InternalNavascript.g:4055:52: (iv_ruleVarArgument= ruleVarArgument EOF )
            // InternalNavascript.g:4056:2: iv_ruleVarArgument= ruleVarArgument EOF
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
    // InternalNavascript.g:4062:1: ruleVarArgument returns [EObject current=null] : ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) ;
    public final EObject ruleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_argument_1_1 = null;

        EObject lv_argument_1_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4068:2: ( ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) )
            // InternalNavascript.g:4069:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            {
            // InternalNavascript.g:4069:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            // InternalNavascript.g:4070:3: () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            {
            // InternalNavascript.g:4070:3: ()
            // InternalNavascript.g:4071:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArgumentAccess().getVarArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4077:3: ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            // InternalNavascript.g:4078:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            {
            // InternalNavascript.g:4078:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            // InternalNavascript.g:4079:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            {
            // InternalNavascript.g:4079:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_TYPE_DEF) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_MODE_DEF) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalNavascript.g:4080:6: lv_argument_1_1= ruleVarType
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
                    // InternalNavascript.g:4096:6: lv_argument_1_2= ruleVarMode
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
    // InternalNavascript.g:4118:1: entryRuleVarType returns [EObject current=null] : iv_ruleVarType= ruleVarType EOF ;
    public final EObject entryRuleVarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarType = null;


        try {
            // InternalNavascript.g:4118:48: (iv_ruleVarType= ruleVarType EOF )
            // InternalNavascript.g:4119:2: iv_ruleVarType= ruleVarType EOF
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
    // InternalNavascript.g:4125:1: ruleVarType returns [EObject current=null] : ( () this_TYPE_DEF_1= RULE_TYPE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) ) ) ;
    public final EObject ruleVarType() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_1=null;
        Token this_ASSIGNMENT_2=null;
        EObject lv_type_3_1 = null;

        EObject lv_type_3_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4131:2: ( ( () this_TYPE_DEF_1= RULE_TYPE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) ) ) )
            // InternalNavascript.g:4132:2: ( () this_TYPE_DEF_1= RULE_TYPE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) ) )
            {
            // InternalNavascript.g:4132:2: ( () this_TYPE_DEF_1= RULE_TYPE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) ) )
            // InternalNavascript.g:4133:3: () this_TYPE_DEF_1= RULE_TYPE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) )
            {
            // InternalNavascript.g:4133:3: ()
            // InternalNavascript.g:4134:4: 
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
            this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_2, grammarAccess.getVarTypeAccess().getASSIGNMENTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:4148:3: ( ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) ) )
            // InternalNavascript.g:4149:4: ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) )
            {
            // InternalNavascript.g:4149:4: ( (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType ) )
            // InternalNavascript.g:4150:5: (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType )
            {
            // InternalNavascript.g:4150:5: (lv_type_3_1= ruleMessageType | lv_type_3_2= rulePropertyType )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=105 && LA59_0<=107)) ) {
                alt59=1;
            }
            else if ( ((LA59_0>=91 && LA59_0<=101)) ) {
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
                    // InternalNavascript.g:4151:6: lv_type_3_1= ruleMessageType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarTypeAccess().getTypeMessageTypeParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_3_1=ruleMessageType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarTypeRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_1,
                      							"com.dexels.navajo.Navascript.MessageType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4167:6: lv_type_3_2= rulePropertyType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarTypeAccess().getTypePropertyTypeParserRuleCall_3_0_1());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_3_2=rulePropertyType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVarTypeRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_2,
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
    // InternalNavascript.g:4189:1: entryRuleVarMode returns [EObject current=null] : iv_ruleVarMode= ruleVarMode EOF ;
    public final EObject entryRuleVarMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarMode = null;


        try {
            // InternalNavascript.g:4189:48: (iv_ruleVarMode= ruleVarMode EOF )
            // InternalNavascript.g:4190:2: iv_ruleVarMode= ruleVarMode EOF
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
    // InternalNavascript.g:4196:1: ruleVarMode returns [EObject current=null] : ( () this_MODE_DEF_1= RULE_MODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_mode_3_0= ruleMessageMode ) ) ) ;
    public final EObject ruleVarMode() throws RecognitionException {
        EObject current = null;

        Token this_MODE_DEF_1=null;
        Token this_ASSIGNMENT_2=null;
        EObject lv_mode_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4202:2: ( ( () this_MODE_DEF_1= RULE_MODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_mode_3_0= ruleMessageMode ) ) ) )
            // InternalNavascript.g:4203:2: ( () this_MODE_DEF_1= RULE_MODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_mode_3_0= ruleMessageMode ) ) )
            {
            // InternalNavascript.g:4203:2: ( () this_MODE_DEF_1= RULE_MODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_mode_3_0= ruleMessageMode ) ) )
            // InternalNavascript.g:4204:3: () this_MODE_DEF_1= RULE_MODE_DEF this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_mode_3_0= ruleMessageMode ) )
            {
            // InternalNavascript.g:4204:3: ()
            // InternalNavascript.g:4205:4: 
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
            this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_2, grammarAccess.getVarModeAccess().getASSIGNMENTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:4219:3: ( (lv_mode_3_0= ruleMessageMode ) )
            // InternalNavascript.g:4220:4: (lv_mode_3_0= ruleMessageMode )
            {
            // InternalNavascript.g:4220:4: (lv_mode_3_0= ruleMessageMode )
            // InternalNavascript.g:4221:5: lv_mode_3_0= ruleMessageMode
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarModeAccess().getModeMessageModeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_mode_3_0=ruleMessageMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVarModeRule());
              					}
              					set(
              						current,
              						"mode",
              						lv_mode_3_0,
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
    // InternalNavascript.g:4242:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalNavascript.g:4242:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalNavascript.g:4243:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalNavascript.g:4249:1: ruleProperty returns [EObject current=null] : ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token this_PROPERTY_DEF_1=null;
        Token lv_propertyName_2_0=null;
        Token this_ASSIGNMENT_4=null;
        Token this_EOL_6=null;
        Token this_TML_START_7=null;
        Token this_TML_END_9=null;
        Token this_BLOCK_START_10=null;
        Token this_BLOCK_END_12=null;
        Token this_BLOCK_START_13=null;
        Token this_BLOCK_END_15=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_expressionList_5_0 = null;

        EObject lv_selectionArray_8_0 = null;

        EObject lv_arrayField_11_0 = null;

        EObject lv_arrayMessage_14_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4255:2: ( ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) ) ) )
            // InternalNavascript.g:4256:2: ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) ) )
            {
            // InternalNavascript.g:4256:2: ( () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) ) )
            // InternalNavascript.g:4257:3: () this_PROPERTY_DEF_1= RULE_PROPERTY_DEF ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) )
            {
            // InternalNavascript.g:4257:3: ()
            // InternalNavascript.g:4258:4: 
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
            // InternalNavascript.g:4268:3: ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:4269:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:4269:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:4270:5: lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER
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

            // InternalNavascript.g:4286:3: ( (lv_arguments_3_0= rulePropertyArguments ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ARGS_START) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalNavascript.g:4287:4: (lv_arguments_3_0= rulePropertyArguments )
                    {
                    // InternalNavascript.g:4287:4: (lv_arguments_3_0= rulePropertyArguments )
                    // InternalNavascript.g:4288:5: lv_arguments_3_0= rulePropertyArguments
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

            // InternalNavascript.g:4305:3: ( ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL ) | (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END ) | (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END ) | (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END ) )
            int alt62=4;
            switch ( input.LA(1) ) {
            case RULE_ASSIGNMENT:
            case RULE_EOL:
                {
                alt62=1;
                }
                break;
            case RULE_TML_START:
                {
                alt62=2;
                }
                break;
            case RULE_BLOCK_START:
                {
                int LA62_3 = input.LA(2);

                if ( (LA62_3==RULE_MAPPABLE_IDENTIFIER) ) {
                    alt62=3;
                }
                else if ( (LA62_3==RULE_TML_LITERAL) ) {
                    alt62=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalNavascript.g:4306:4: ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL )
                    {
                    // InternalNavascript.g:4306:4: ( (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL )
                    // InternalNavascript.g:4307:5: (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )? this_EOL_6= RULE_EOL
                    {
                    // InternalNavascript.g:4307:5: (this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==RULE_ASSIGNMENT) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalNavascript.g:4308:6: this_ASSIGNMENT_4= RULE_ASSIGNMENT ( (lv_expressionList_5_0= ruleConditionalExpressions ) )
                            {
                            this_ASSIGNMENT_4=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_47); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(this_ASSIGNMENT_4, grammarAccess.getPropertyAccess().getASSIGNMENTTerminalRuleCall_4_0_0_0());
                              					
                            }
                            // InternalNavascript.g:4312:6: ( (lv_expressionList_5_0= ruleConditionalExpressions ) )
                            // InternalNavascript.g:4313:7: (lv_expressionList_5_0= ruleConditionalExpressions )
                            {
                            // InternalNavascript.g:4313:7: (lv_expressionList_5_0= ruleConditionalExpressions )
                            // InternalNavascript.g:4314:8: lv_expressionList_5_0= ruleConditionalExpressions
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getPropertyAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_22);
                            lv_expressionList_5_0=ruleConditionalExpressions();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getPropertyRule());
                              								}
                              								set(
                              									current,
                              									"expressionList",
                              									lv_expressionList_5_0,
                              									"com.dexels.navajo.Navascript.ConditionalExpressions");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_EOL_6=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_EOL_6, grammarAccess.getPropertyAccess().getEOLTerminalRuleCall_4_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4338:4: (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END )
                    {
                    // InternalNavascript.g:4338:4: (this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END )
                    // InternalNavascript.g:4339:5: this_TML_START_7= RULE_TML_START ( (lv_selectionArray_8_0= ruleSelectionArray ) ) this_TML_END_9= RULE_TML_END
                    {
                    this_TML_START_7=(Token)match(input,RULE_TML_START,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_START_7, grammarAccess.getPropertyAccess().getTML_STARTTerminalRuleCall_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4343:5: ( (lv_selectionArray_8_0= ruleSelectionArray ) )
                    // InternalNavascript.g:4344:6: (lv_selectionArray_8_0= ruleSelectionArray )
                    {
                    // InternalNavascript.g:4344:6: (lv_selectionArray_8_0= ruleSelectionArray )
                    // InternalNavascript.g:4345:7: lv_selectionArray_8_0= ruleSelectionArray
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getSelectionArraySelectionArrayParserRuleCall_4_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_38);
                    lv_selectionArray_8_0=ruleSelectionArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"selectionArray",
                      								lv_selectionArray_8_0,
                      								"com.dexels.navajo.Navascript.SelectionArray");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_TML_END_9=(Token)match(input,RULE_TML_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_TML_END_9, grammarAccess.getPropertyAccess().getTML_ENDTerminalRuleCall_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4368:4: (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:4368:4: (this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END )
                    // InternalNavascript.g:4369:5: this_BLOCK_START_10= RULE_BLOCK_START ( (lv_arrayField_11_0= ruleMappedArrayField ) ) this_BLOCK_END_12= RULE_BLOCK_END
                    {
                    this_BLOCK_START_10=(Token)match(input,RULE_BLOCK_START,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_10, grammarAccess.getPropertyAccess().getBLOCK_STARTTerminalRuleCall_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4373:5: ( (lv_arrayField_11_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4374:6: (lv_arrayField_11_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4374:6: (lv_arrayField_11_0= ruleMappedArrayField )
                    // InternalNavascript.g:4375:7: lv_arrayField_11_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_2_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_arrayField_11_0=ruleMappedArrayField();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"arrayField",
                      								lv_arrayField_11_0,
                      								"com.dexels.navajo.Navascript.MappedArrayField");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_BLOCK_END_12=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_12, grammarAccess.getPropertyAccess().getBLOCK_ENDTerminalRuleCall_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4398:4: (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END )
                    {
                    // InternalNavascript.g:4398:4: (this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END )
                    // InternalNavascript.g:4399:5: this_BLOCK_START_13= RULE_BLOCK_START ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) ) this_BLOCK_END_15= RULE_BLOCK_END
                    {
                    this_BLOCK_START_13=(Token)match(input,RULE_BLOCK_START,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_START_13, grammarAccess.getPropertyAccess().getBLOCK_STARTTerminalRuleCall_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4403:5: ( (lv_arrayMessage_14_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4404:6: (lv_arrayMessage_14_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4404:6: (lv_arrayMessage_14_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4405:7: lv_arrayMessage_14_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayMessageMappedArrayMessageParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_29);
                    lv_arrayMessage_14_0=ruleMappedArrayMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyRule());
                      							}
                      							set(
                      								current,
                      								"arrayMessage",
                      								lv_arrayMessage_14_0,
                      								"com.dexels.navajo.Navascript.MappedArrayMessage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    this_BLOCK_END_15=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BLOCK_END_15, grammarAccess.getPropertyAccess().getBLOCK_ENDTerminalRuleCall_4_3_2());
                      				
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
    // InternalNavascript.g:4432:1: entryRuleSelectionArray returns [EObject current=null] : iv_ruleSelectionArray= ruleSelectionArray EOF ;
    public final EObject entryRuleSelectionArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArray = null;


        try {
            // InternalNavascript.g:4432:55: (iv_ruleSelectionArray= ruleSelectionArray EOF )
            // InternalNavascript.g:4433:2: iv_ruleSelectionArray= ruleSelectionArray EOF
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
    // InternalNavascript.g:4439:1: ruleSelectionArray returns [EObject current=null] : ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) ;
    public final EObject ruleSelectionArray() throws RecognitionException {
        EObject current = null;

        Token this_ARG_SEP_1=null;
        EObject lv_arrayElements_0_0 = null;

        EObject lv_arrayElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4445:2: ( ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) )
            // InternalNavascript.g:4446:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            {
            // InternalNavascript.g:4446:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            // InternalNavascript.g:4447:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            {
            // InternalNavascript.g:4447:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) )
            // InternalNavascript.g:4448:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            {
            // InternalNavascript.g:4448:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            // InternalNavascript.g:4449:5: lv_arrayElements_0_0= ruleSelectionArrayElement
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

            // InternalNavascript.g:4466:3: (this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ARG_SEP) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalNavascript.g:4467:4: this_ARG_SEP_1= RULE_ARG_SEP ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    {
            	    this_ARG_SEP_1=(Token)match(input,RULE_ARG_SEP,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_1, grammarAccess.getSelectionArrayAccess().getARG_SEPTerminalRuleCall_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:4471:4: ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    // InternalNavascript.g:4472:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    {
            	    // InternalNavascript.g:4472:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    // InternalNavascript.g:4473:6: lv_arrayElements_2_0= ruleSelectionArrayElement
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
            	    break loop63;
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
    // InternalNavascript.g:4495:1: entryRuleSelectionArrayElement returns [EObject current=null] : iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF ;
    public final EObject entryRuleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArrayElement = null;


        try {
            // InternalNavascript.g:4495:62: (iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF )
            // InternalNavascript.g:4496:2: iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF
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
    // InternalNavascript.g:4502:1: ruleSelectionArrayElement returns [EObject current=null] : ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_innerBody_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) ;
    public final EObject ruleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        Token this_BLOCK_START_1=null;
        Token this_BLOCK_END_3=null;
        EObject lv_innerBody_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4508:2: ( ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_innerBody_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END ) )
            // InternalNavascript.g:4509:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_innerBody_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            {
            // InternalNavascript.g:4509:2: ( () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_innerBody_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END )
            // InternalNavascript.g:4510:3: () this_BLOCK_START_1= RULE_BLOCK_START ( (lv_innerBody_2_0= ruleInnerBody ) )* this_BLOCK_END_3= RULE_BLOCK_END
            {
            // InternalNavascript.g:4510:3: ()
            // InternalNavascript.g:4511:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSelectionArrayElementAccess().getSelectionArrayElementAction_0(),
              					current);
              			
            }

            }

            this_BLOCK_START_1=(Token)match(input,RULE_BLOCK_START,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_START_1, grammarAccess.getSelectionArrayElementAccess().getBLOCK_STARTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4521:3: ( (lv_innerBody_2_0= ruleInnerBody ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_IF||LA64_0==RULE_BLOCK_START||LA64_0==RULE_BREAK_DEF||LA64_0==RULE_DEFINE_DEF||(LA64_0>=RULE_PRINT_DEF && LA64_0<=RULE_LOG_DEF)||(LA64_0>=RULE_METHODS_DEF && LA64_0<=RULE_LOOP_DEF)||(LA64_0>=RULE_INCLUDE_DEF && LA64_0<=RULE_MESSAGE_DEF)||LA64_0==RULE_MAP_DEF||LA64_0==RULE_MAP_OLDSKOOL_DEF||(LA64_0>=RULE_METHOD_IDENTIFIER && LA64_0<=RULE_MAPPABLE_IDENTIFIER)||(LA64_0>=RULE_VAR_DEF && LA64_0<=RULE_OPTION_DEF)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalNavascript.g:4522:4: (lv_innerBody_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:4522:4: (lv_innerBody_2_0= ruleInnerBody )
            	    // InternalNavascript.g:4523:5: lv_innerBody_2_0= ruleInnerBody
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
            	    break loop64;
                }
            } while (true);

            this_BLOCK_END_3=(Token)match(input,RULE_BLOCK_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BLOCK_END_3, grammarAccess.getSelectionArrayElementAccess().getBLOCK_ENDTerminalRuleCall_3());
              		
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
    // InternalNavascript.g:4548:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalNavascript.g:4548:47: (iv_ruleOption= ruleOption EOF )
            // InternalNavascript.g:4549:2: iv_ruleOption= ruleOption EOF
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
    // InternalNavascript.g:4555:1: ruleOption returns [EObject current=null] : (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) ;
    public final EObject ruleOption() throws RecognitionException {
        EObject current = null;

        Token this_OPTION_DEF_0=null;
        Token this_ASSIGNMENT_2=null;
        Token this_EOL_4=null;
        AntlrDatatypeRuleToken lv_option_1_0 = null;

        EObject lv_expressionList_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4561:2: ( (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL ) )
            // InternalNavascript.g:4562:2: (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL )
            {
            // InternalNavascript.g:4562:2: (this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL )
            // InternalNavascript.g:4563:3: this_OPTION_DEF_0= RULE_OPTION_DEF ( (lv_option_1_0= ruleOPTION_TYPE ) ) this_ASSIGNMENT_2= RULE_ASSIGNMENT ( (lv_expressionList_3_0= ruleConditionalExpressions ) ) this_EOL_4= RULE_EOL
            {
            this_OPTION_DEF_0=(Token)match(input,RULE_OPTION_DEF,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_OPTION_DEF_0, grammarAccess.getOptionAccess().getOPTION_DEFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:4567:3: ( (lv_option_1_0= ruleOPTION_TYPE ) )
            // InternalNavascript.g:4568:4: (lv_option_1_0= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:4568:4: (lv_option_1_0= ruleOPTION_TYPE )
            // InternalNavascript.g:4569:5: lv_option_1_0= ruleOPTION_TYPE
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

            this_ASSIGNMENT_2=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_2, grammarAccess.getOptionAccess().getASSIGNMENTTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:4590:3: ( (lv_expressionList_3_0= ruleConditionalExpressions ) )
            // InternalNavascript.g:4591:4: (lv_expressionList_3_0= ruleConditionalExpressions )
            {
            // InternalNavascript.g:4591:4: (lv_expressionList_3_0= ruleConditionalExpressions )
            // InternalNavascript.g:4592:5: lv_expressionList_3_0= ruleConditionalExpressions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionAccess().getExpressionListConditionalExpressionsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expressionList_3_0=ruleConditionalExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOptionRule());
              					}
              					set(
              						current,
              						"expressionList",
              						lv_expressionList_3_0,
              						"com.dexels.navajo.Navascript.ConditionalExpressions");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_EOL_4, grammarAccess.getOptionAccess().getEOLTerminalRuleCall_4());
              		
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
    // InternalNavascript.g:4617:1: entryRulePropertyArguments returns [EObject current=null] : iv_rulePropertyArguments= rulePropertyArguments EOF ;
    public final EObject entryRulePropertyArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArguments = null;


        try {
            // InternalNavascript.g:4617:58: (iv_rulePropertyArguments= rulePropertyArguments EOF )
            // InternalNavascript.g:4618:2: iv_rulePropertyArguments= rulePropertyArguments EOF
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
    // InternalNavascript.g:4624:1: rulePropertyArguments returns [EObject current=null] : ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) ;
    public final EObject rulePropertyArguments() throws RecognitionException {
        EObject current = null;

        Token this_ARGS_START_1=null;
        Token this_ARG_SEP_3=null;
        Token this_ARGS_END_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4630:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END ) )
            // InternalNavascript.g:4631:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            {
            // InternalNavascript.g:4631:2: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END )
            // InternalNavascript.g:4632:3: () this_ARGS_START_1= RULE_ARGS_START ( (lv_arguments_2_0= rulePropertyArgument ) ) (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )* this_ARGS_END_5= RULE_ARGS_END
            {
            // InternalNavascript.g:4632:3: ()
            // InternalNavascript.g:4633:4: 
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
            // InternalNavascript.g:4643:3: ( (lv_arguments_2_0= rulePropertyArgument ) )
            // InternalNavascript.g:4644:4: (lv_arguments_2_0= rulePropertyArgument )
            {
            // InternalNavascript.g:4644:4: (lv_arguments_2_0= rulePropertyArgument )
            // InternalNavascript.g:4645:5: lv_arguments_2_0= rulePropertyArgument
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

            // InternalNavascript.g:4662:3: (this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ARG_SEP) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalNavascript.g:4663:4: this_ARG_SEP_3= RULE_ARG_SEP ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    {
            	    this_ARG_SEP_3=(Token)match(input,RULE_ARG_SEP,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ARG_SEP_3, grammarAccess.getPropertyArgumentsAccess().getARG_SEPTerminalRuleCall_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4667:4: ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    // InternalNavascript.g:4668:5: (lv_arguments_4_0= rulePropertyArgument )
            	    {
            	    // InternalNavascript.g:4668:5: (lv_arguments_4_0= rulePropertyArgument )
            	    // InternalNavascript.g:4669:6: lv_arguments_4_0= rulePropertyArgument
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
            	    break loop65;
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
    // InternalNavascript.g:4695:1: entryRulePropertyArgument returns [EObject current=null] : iv_rulePropertyArgument= rulePropertyArgument EOF ;
    public final EObject entryRulePropertyArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArgument = null;


        try {
            // InternalNavascript.g:4695:57: (iv_rulePropertyArgument= rulePropertyArgument EOF )
            // InternalNavascript.g:4696:2: iv_rulePropertyArgument= rulePropertyArgument EOF
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
    // InternalNavascript.g:4702:1: rulePropertyArgument returns [EObject current=null] : (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) ;
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
            // InternalNavascript.g:4708:2: ( (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) )
            // InternalNavascript.g:4709:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            {
            // InternalNavascript.g:4709:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            int alt66=6;
            switch ( input.LA(1) ) {
            case RULE_DIRECTION_DEF:
                {
                alt66=1;
                }
                break;
            case RULE_TYPE_DEF:
                {
                alt66=2;
                }
                break;
            case RULE_SUBTYPE_DEF:
                {
                alt66=3;
                }
                break;
            case RULE_DESCRIPTION_DEF:
                {
                alt66=4;
                }
                break;
            case RULE_CARDINALITY_DEF:
                {
                alt66=5;
                }
                break;
            case RULE_LENGTH_DEF:
                {
                alt66=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalNavascript.g:4710:3: this_DirectionArgument_0= ruleDirectionArgument
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
                    // InternalNavascript.g:4719:3: this_TypeArgument_1= ruleTypeArgument
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
                    // InternalNavascript.g:4728:3: this_SubTypeArgument_2= ruleSubTypeArgument
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
                    // InternalNavascript.g:4737:3: this_DescriptionArgument_3= ruleDescriptionArgument
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
                    // InternalNavascript.g:4746:3: this_CardinalityArgument_4= ruleCardinalityArgument
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
                    // InternalNavascript.g:4755:3: this_LengthArgument_5= ruleLengthArgument
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
    // InternalNavascript.g:4767:1: entryRuleLengthArgument returns [EObject current=null] : iv_ruleLengthArgument= ruleLengthArgument EOF ;
    public final EObject entryRuleLengthArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLengthArgument = null;


        try {
            // InternalNavascript.g:4767:55: (iv_ruleLengthArgument= ruleLengthArgument EOF )
            // InternalNavascript.g:4768:2: iv_ruleLengthArgument= ruleLengthArgument EOF
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
    // InternalNavascript.g:4774:1: ruleLengthArgument returns [EObject current=null] : (this_LENGTH_DEF_0= RULE_LENGTH_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleLengthArgument() throws RecognitionException {
        EObject current = null;

        Token this_LENGTH_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:4780:2: ( (this_LENGTH_DEF_0= RULE_LENGTH_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_INTEGER ) ) ) )
            // InternalNavascript.g:4781:2: (this_LENGTH_DEF_0= RULE_LENGTH_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_INTEGER ) ) )
            {
            // InternalNavascript.g:4781:2: (this_LENGTH_DEF_0= RULE_LENGTH_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_INTEGER ) ) )
            // InternalNavascript.g:4782:3: this_LENGTH_DEF_0= RULE_LENGTH_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_INTEGER ) )
            {
            this_LENGTH_DEF_0=(Token)match(input,RULE_LENGTH_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_LENGTH_DEF_0, grammarAccess.getLengthArgumentAccess().getLENGTH_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getLengthArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4790:3: ( (lv_value_2_0= RULE_INTEGER ) )
            // InternalNavascript.g:4791:4: (lv_value_2_0= RULE_INTEGER )
            {
            // InternalNavascript.g:4791:4: (lv_value_2_0= RULE_INTEGER )
            // InternalNavascript.g:4792:5: lv_value_2_0= RULE_INTEGER
            {
            lv_value_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_2_0, grammarAccess.getLengthArgumentAccess().getValueINTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getLengthArgumentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_2_0,
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
    // InternalNavascript.g:4812:1: entryRuleDirectionArgument returns [EObject current=null] : iv_ruleDirectionArgument= ruleDirectionArgument EOF ;
    public final EObject entryRuleDirectionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionArgument = null;


        try {
            // InternalNavascript.g:4812:58: (iv_ruleDirectionArgument= ruleDirectionArgument EOF )
            // InternalNavascript.g:4813:2: iv_ruleDirectionArgument= ruleDirectionArgument EOF
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
    // InternalNavascript.g:4819:1: ruleDirectionArgument returns [EObject current=null] : (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) ) ) ;
    public final EObject ruleDirectionArgument() throws RecognitionException {
        EObject current = null;

        Token this_DIRECTION_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:4825:2: ( (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) ) ) )
            // InternalNavascript.g:4826:2: (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) ) )
            {
            // InternalNavascript.g:4826:2: (this_DIRECTION_DEF_0= RULE_DIRECTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) ) )
            // InternalNavascript.g:4827:3: this_DIRECTION_DEF_0= RULE_DIRECTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) )
            {
            this_DIRECTION_DEF_0=(Token)match(input,RULE_DIRECTION_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_DIRECTION_DEF_0, grammarAccess.getDirectionArgumentAccess().getDIRECTION_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getDirectionArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4835:3: ( ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) ) )
            // InternalNavascript.g:4836:4: ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) )
            {
            // InternalNavascript.g:4836:4: ( (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF ) )
            // InternalNavascript.g:4837:5: (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF )
            {
            // InternalNavascript.g:4837:5: (lv_value_2_1= RULE_IN_DEF | lv_value_2_2= RULE_OUT_DEF | lv_value_2_3= RULE_INOUT_DEF )
            int alt67=3;
            switch ( input.LA(1) ) {
            case RULE_IN_DEF:
                {
                alt67=1;
                }
                break;
            case RULE_OUT_DEF:
                {
                alt67=2;
                }
                break;
            case RULE_INOUT_DEF:
                {
                alt67=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalNavascript.g:4838:6: lv_value_2_1= RULE_IN_DEF
                    {
                    lv_value_2_1=(Token)match(input,RULE_IN_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_1, grammarAccess.getDirectionArgumentAccess().getValueIN_DEFTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_1,
                      							"com.dexels.navajo.Navascript.IN_DEF");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4853:6: lv_value_2_2= RULE_OUT_DEF
                    {
                    lv_value_2_2=(Token)match(input,RULE_OUT_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_2, grammarAccess.getDirectionArgumentAccess().getValueOUT_DEFTerminalRuleCall_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_2,
                      							"com.dexels.navajo.Navascript.OUT_DEF");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4868:6: lv_value_2_3= RULE_INOUT_DEF
                    {
                    lv_value_2_3=(Token)match(input,RULE_INOUT_DEF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_3, grammarAccess.getDirectionArgumentAccess().getValueINOUT_DEFTerminalRuleCall_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_3,
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
    // InternalNavascript.g:4889:1: entryRuleDescriptionArgument returns [EObject current=null] : iv_ruleDescriptionArgument= ruleDescriptionArgument EOF ;
    public final EObject entryRuleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionArgument = null;


        try {
            // InternalNavascript.g:4889:60: (iv_ruleDescriptionArgument= ruleDescriptionArgument EOF )
            // InternalNavascript.g:4890:2: iv_ruleDescriptionArgument= ruleDescriptionArgument EOF
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
    // InternalNavascript.g:4896:1: ruleDescriptionArgument returns [EObject current=null] : (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        Token this_DESCRIPTION_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4902:2: ( (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:4903:2: (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:4903:2: (this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:4904:3: this_DESCRIPTION_DEF_0= RULE_DESCRIPTION_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= ruleLiteralOrExpression ) )
            {
            this_DESCRIPTION_DEF_0=(Token)match(input,RULE_DESCRIPTION_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_DESCRIPTION_DEF_0, grammarAccess.getDescriptionArgumentAccess().getDESCRIPTION_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getDescriptionArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4912:3: ( (lv_value_2_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:4913:4: (lv_value_2_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:4913:4: (lv_value_2_0= ruleLiteralOrExpression )
            // InternalNavascript.g:4914:5: lv_value_2_0= ruleLiteralOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDescriptionArgumentAccess().getValueLiteralOrExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDescriptionArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
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
    // InternalNavascript.g:4935:1: entryRuleCardinalityArgument returns [EObject current=null] : iv_ruleCardinalityArgument= ruleCardinalityArgument EOF ;
    public final EObject entryRuleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCardinalityArgument = null;


        try {
            // InternalNavascript.g:4935:60: (iv_ruleCardinalityArgument= ruleCardinalityArgument EOF )
            // InternalNavascript.g:4936:2: iv_ruleCardinalityArgument= ruleCardinalityArgument EOF
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
    // InternalNavascript.g:4942:1: ruleCardinalityArgument returns [EObject current=null] : (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) ) ) ;
    public final EObject ruleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        Token this_CARDINALITY_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:4948:2: ( (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) ) ) )
            // InternalNavascript.g:4949:2: (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) ) )
            {
            // InternalNavascript.g:4949:2: (this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) ) )
            // InternalNavascript.g:4950:3: this_CARDINALITY_DEF_0= RULE_CARDINALITY_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) )
            {
            this_CARDINALITY_DEF_0=(Token)match(input,RULE_CARDINALITY_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_CARDINALITY_DEF_0, grammarAccess.getCardinalityArgumentAccess().getCARDINALITY_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getCardinalityArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:4958:3: ( ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) ) )
            // InternalNavascript.g:4959:4: ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) )
            {
            // InternalNavascript.g:4959:4: ( (lv_value_2_1= '+' | lv_value_2_2= '1' ) )
            // InternalNavascript.g:4960:5: (lv_value_2_1= '+' | lv_value_2_2= '1' )
            {
            // InternalNavascript.g:4960:5: (lv_value_2_1= '+' | lv_value_2_2= '1' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==75) ) {
                alt68=1;
            }
            else if ( (LA68_0==76) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalNavascript.g:4961:6: lv_value_2_1= '+'
                    {
                    lv_value_2_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_1, grammarAccess.getCardinalityArgumentAccess().getValuePlusSignKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCardinalityArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4972:6: lv_value_2_2= '1'
                    {
                    lv_value_2_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_2, grammarAccess.getCardinalityArgumentAccess().getValue1Keyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCardinalityArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_2_2, null);
                      					
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
    // InternalNavascript.g:4989:1: entryRuleTypeArgument returns [EObject current=null] : iv_ruleTypeArgument= ruleTypeArgument EOF ;
    public final EObject entryRuleTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeArgument = null;


        try {
            // InternalNavascript.g:4989:53: (iv_ruleTypeArgument= ruleTypeArgument EOF )
            // InternalNavascript.g:4990:2: iv_ruleTypeArgument= ruleTypeArgument EOF
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
    // InternalNavascript.g:4996:1: ruleTypeArgument returns [EObject current=null] : (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= rulePropertyType ) ) ) ;
    public final EObject ruleTypeArgument() throws RecognitionException {
        EObject current = null;

        Token this_TYPE_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5002:2: ( (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= rulePropertyType ) ) ) )
            // InternalNavascript.g:5003:2: (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= rulePropertyType ) ) )
            {
            // InternalNavascript.g:5003:2: (this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= rulePropertyType ) ) )
            // InternalNavascript.g:5004:3: this_TYPE_DEF_0= RULE_TYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= rulePropertyType ) )
            {
            this_TYPE_DEF_0=(Token)match(input,RULE_TYPE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_TYPE_DEF_0, grammarAccess.getTypeArgumentAccess().getTYPE_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getTypeArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:5012:3: ( (lv_value_2_0= rulePropertyType ) )
            // InternalNavascript.g:5013:4: (lv_value_2_0= rulePropertyType )
            {
            // InternalNavascript.g:5013:4: (lv_value_2_0= rulePropertyType )
            // InternalNavascript.g:5014:5: lv_value_2_0= rulePropertyType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeArgumentAccess().getValuePropertyTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=rulePropertyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
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
    // InternalNavascript.g:5035:1: entryRuleSubTypeArgument returns [EObject current=null] : iv_ruleSubTypeArgument= ruleSubTypeArgument EOF ;
    public final EObject entryRuleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeArgument = null;


        try {
            // InternalNavascript.g:5035:56: (iv_ruleSubTypeArgument= ruleSubTypeArgument EOF )
            // InternalNavascript.g:5036:2: iv_ruleSubTypeArgument= ruleSubTypeArgument EOF
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
    // InternalNavascript.g:5042:1: ruleSubTypeArgument returns [EObject current=null] : (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        Token this_SUBTYPE_DEF_0=null;
        Token this_ASSIGNMENT_1=null;
        Token lv_value_2_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5048:2: ( (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_IDENTIFIER ) ) ) )
            // InternalNavascript.g:5049:2: (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_IDENTIFIER ) ) )
            {
            // InternalNavascript.g:5049:2: (this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_IDENTIFIER ) ) )
            // InternalNavascript.g:5050:3: this_SUBTYPE_DEF_0= RULE_SUBTYPE_DEF this_ASSIGNMENT_1= RULE_ASSIGNMENT ( (lv_value_2_0= RULE_IDENTIFIER ) )
            {
            this_SUBTYPE_DEF_0=(Token)match(input,RULE_SUBTYPE_DEF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_SUBTYPE_DEF_0, grammarAccess.getSubTypeArgumentAccess().getSUBTYPE_DEFTerminalRuleCall_0());
              		
            }
            this_ASSIGNMENT_1=(Token)match(input,RULE_ASSIGNMENT,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ASSIGNMENT_1, grammarAccess.getSubTypeArgumentAccess().getASSIGNMENTTerminalRuleCall_1());
              		
            }
            // InternalNavascript.g:5058:3: ( (lv_value_2_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:5059:4: (lv_value_2_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:5059:4: (lv_value_2_0= RULE_IDENTIFIER )
            // InternalNavascript.g:5060:5: lv_value_2_0= RULE_IDENTIFIER
            {
            lv_value_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_2_0, grammarAccess.getSubTypeArgumentAccess().getValueIDENTIFIERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSubTypeArgumentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_2_0,
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
    // InternalNavascript.g:5080:1: entryRuleConditionalExpressions returns [EObject current=null] : iv_ruleConditionalExpressions= ruleConditionalExpressions EOF ;
    public final EObject entryRuleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressions = null;


        try {
            // InternalNavascript.g:5080:63: (iv_ruleConditionalExpressions= ruleConditionalExpressions EOF )
            // InternalNavascript.g:5081:2: iv_ruleConditionalExpressions= ruleConditionalExpressions EOF
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
    // InternalNavascript.g:5087:1: ruleConditionalExpressions returns [EObject current=null] : ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        Token this_ELSE_2=null;
        EObject lv_conditionalExpressions_1_0 = null;

        EObject lv_elseExpresssion_3_0 = null;

        EObject lv_singleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5093:2: ( ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5094:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5094:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_IF) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_ARGS_START||LA70_0==RULE_QUOTED_IDENTIFIER||LA70_0==RULE_STRING_CONSTANT||LA70_0==RULE_IDENTIFIER||(LA70_0>=RULE_MAPPABLE_IDENTIFIER && LA70_0<=RULE_TML_LITERAL)||LA70_0==RULE_INTEGER||(LA70_0>=RULE_STRING_LITERAL && LA70_0<=RULE_EXISTS)||LA70_0==85||(LA70_0>=88 && LA70_0<=89)) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalNavascript.g:5095:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:5095:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:5096:4: () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ this_ELSE_2= RULE_ELSE ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5096:4: ()
                    // InternalNavascript.g:5097:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getConditionalExpressionsAccess().getConditionalExpressionsAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5103:4: ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==RULE_IF) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalNavascript.g:5104:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    {
                    	    // InternalNavascript.g:5104:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    // InternalNavascript.g:5105:6: lv_conditionalExpressions_1_0= ruleConditionalExpression
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
                    	    if ( cnt69 >= 1 ) break loop69;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);

                    this_ELSE_2=(Token)match(input,RULE_ELSE,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ELSE_2, grammarAccess.getConditionalExpressionsAccess().getELSETerminalRuleCall_0_2());
                      			
                    }
                    // InternalNavascript.g:5126:4: ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5127:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5127:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5128:6: lv_elseExpresssion_3_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:5147:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5147:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5148:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5148:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5149:5: lv_singleExpression_4_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5170:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalNavascript.g:5170:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalNavascript.g:5171:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalNavascript.g:5177:1: ruleConditionalExpression returns [EObject current=null] : (this_IF_0= RULE_IF ( (lv_condition_1_0= ruleExpression ) ) this_THEN_2= RULE_THEN ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token this_IF_0=null;
        Token this_THEN_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5183:2: ( (this_IF_0= RULE_IF ( (lv_condition_1_0= ruleExpression ) ) this_THEN_2= RULE_THEN ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5184:2: (this_IF_0= RULE_IF ( (lv_condition_1_0= ruleExpression ) ) this_THEN_2= RULE_THEN ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5184:2: (this_IF_0= RULE_IF ( (lv_condition_1_0= ruleExpression ) ) this_THEN_2= RULE_THEN ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5185:3: this_IF_0= RULE_IF ( (lv_condition_1_0= ruleExpression ) ) this_THEN_2= RULE_THEN ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            {
            this_IF_0=(Token)match(input,RULE_IF,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_IF_0, grammarAccess.getConditionalExpressionAccess().getIFTerminalRuleCall_0());
              		
            }
            // InternalNavascript.g:5189:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalNavascript.g:5190:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalNavascript.g:5190:4: (lv_condition_1_0= ruleExpression )
            // InternalNavascript.g:5191:5: lv_condition_1_0= ruleExpression
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

            this_THEN_2=(Token)match(input,RULE_THEN,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_THEN_2, grammarAccess.getConditionalExpressionAccess().getTHENTerminalRuleCall_2());
              		
            }
            // InternalNavascript.g:5212:3: ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5213:4: (lv_expression_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5213:4: (lv_expression_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5214:5: lv_expression_3_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5235:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalNavascript.g:5235:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalNavascript.g:5236:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalNavascript.g:5242:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5248:2: (this_BooleanExpression_0= ruleBooleanExpression )
            // InternalNavascript.g:5249:2: this_BooleanExpression_0= ruleBooleanExpression
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
    // InternalNavascript.g:5260:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalNavascript.g:5260:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalNavascript.g:5261:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalNavascript.g:5267:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5273:2: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalNavascript.g:5274:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalNavascript.g:5274:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalNavascript.g:5275:3: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
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
            // InternalNavascript.g:5283:3: ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=77 && LA72_0<=78)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalNavascript.g:5284:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalNavascript.g:5284:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) )
            	    // InternalNavascript.g:5285:5: () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    {
            	    // InternalNavascript.g:5285:5: ()
            	    // InternalNavascript.g:5286:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5292:5: ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    // InternalNavascript.g:5293:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    {
            	    // InternalNavascript.g:5293:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    // InternalNavascript.g:5294:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    {
            	    // InternalNavascript.g:5294:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==77) ) {
            	        alt71=1;
            	    }
            	    else if ( (LA71_0==78) ) {
            	        alt71=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 71, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // InternalNavascript.g:5295:8: lv_op_2_1= 'OR'
            	            {
            	            lv_op_2_1=(Token)match(input,77,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5306:8: lv_op_2_2= 'AND'
            	            {
            	            lv_op_2_2=(Token)match(input,78,FOLLOW_6); if (state.failed) return current;
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

            	    // InternalNavascript.g:5320:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalNavascript.g:5321:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalNavascript.g:5321:5: (lv_right_3_0= ruleComparison )
            	    // InternalNavascript.g:5322:6: lv_right_3_0= ruleComparison
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
            	    break loop72;
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
    // InternalNavascript.g:5344:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalNavascript.g:5344:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalNavascript.g:5345:2: iv_ruleComparison= ruleComparison EOF
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
    // InternalNavascript.g:5351:1: ruleComparison returns [EObject current=null] : (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) ;
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
            // InternalNavascript.g:5357:2: ( (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) )
            // InternalNavascript.g:5358:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            {
            // InternalNavascript.g:5358:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            // InternalNavascript.g:5359:3: this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
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
            // InternalNavascript.g:5367:3: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=79 && LA74_0<=82)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalNavascript.g:5368:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) )
            	    {
            	    // InternalNavascript.g:5368:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) )
            	    // InternalNavascript.g:5369:5: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    {
            	    // InternalNavascript.g:5369:5: ()
            	    // InternalNavascript.g:5370:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5376:5: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalNavascript.g:5377:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalNavascript.g:5377:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalNavascript.g:5378:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalNavascript.g:5378:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt73=4;
            	    switch ( input.LA(1) ) {
            	    case 79:
            	        {
            	        alt73=1;
            	        }
            	        break;
            	    case 80:
            	        {
            	        alt73=2;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt73=3;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt73=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 73, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt73) {
            	        case 1 :
            	            // InternalNavascript.g:5379:8: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,79,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5390:8: lv_op_2_2= '>'
            	            {
            	            lv_op_2_2=(Token)match(input,80,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5401:8: lv_op_2_3= '<='
            	            {
            	            lv_op_2_3=(Token)match(input,81,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5412:8: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,82,FOLLOW_6); if (state.failed) return current;
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

            	    // InternalNavascript.g:5426:4: ( (lv_right_3_0= ruleEquals ) )
            	    // InternalNavascript.g:5427:5: (lv_right_3_0= ruleEquals )
            	    {
            	    // InternalNavascript.g:5427:5: (lv_right_3_0= ruleEquals )
            	    // InternalNavascript.g:5428:6: lv_right_3_0= ruleEquals
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
            	    break loop74;
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
    // InternalNavascript.g:5450:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalNavascript.g:5450:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalNavascript.g:5451:2: iv_ruleEquals= ruleEquals EOF
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
    // InternalNavascript.g:5457:1: ruleEquals returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5463:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalNavascript.g:5464:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalNavascript.g:5464:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalNavascript.g:5465:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
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
            // InternalNavascript.g:5473:3: ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0>=83 && LA76_0<=84)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalNavascript.g:5474:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalNavascript.g:5474:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) )
            	    // InternalNavascript.g:5475:5: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    {
            	    // InternalNavascript.g:5475:5: ()
            	    // InternalNavascript.g:5476:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5482:5: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalNavascript.g:5483:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalNavascript.g:5483:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalNavascript.g:5484:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalNavascript.g:5484:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt75=2;
            	    int LA75_0 = input.LA(1);

            	    if ( (LA75_0==83) ) {
            	        alt75=1;
            	    }
            	    else if ( (LA75_0==84) ) {
            	        alt75=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 75, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt75) {
            	        case 1 :
            	            // InternalNavascript.g:5485:8: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,83,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5496:8: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,84,FOLLOW_6); if (state.failed) return current;
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

            	    // InternalNavascript.g:5510:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalNavascript.g:5511:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalNavascript.g:5511:5: (lv_right_3_0= ruleAddition )
            	    // InternalNavascript.g:5512:6: lv_right_3_0= ruleAddition
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
            	    break loop76;
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
    // InternalNavascript.g:5534:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalNavascript.g:5534:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalNavascript.g:5535:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalNavascript.g:5541:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5547:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalNavascript.g:5548:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalNavascript.g:5548:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalNavascript.g:5549:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
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
            // InternalNavascript.g:5557:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==75||LA78_0==85) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalNavascript.g:5558:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalNavascript.g:5558:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt77=2;
            	    int LA77_0 = input.LA(1);

            	    if ( (LA77_0==75) ) {
            	        alt77=1;
            	    }
            	    else if ( (LA77_0==85) ) {
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
            	            // InternalNavascript.g:5559:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalNavascript.g:5559:5: ( () otherlv_2= '+' )
            	            // InternalNavascript.g:5560:6: () otherlv_2= '+'
            	            {
            	            // InternalNavascript.g:5560:6: ()
            	            // InternalNavascript.g:5561:7: 
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
            	            // InternalNavascript.g:5573:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalNavascript.g:5573:5: ( () otherlv_4= '-' )
            	            // InternalNavascript.g:5574:6: () otherlv_4= '-'
            	            {
            	            // InternalNavascript.g:5574:6: ()
            	            // InternalNavascript.g:5575:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_4=(Token)match(input,85,FOLLOW_6); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // InternalNavascript.g:5587:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalNavascript.g:5588:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalNavascript.g:5588:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalNavascript.g:5589:6: lv_right_5_0= ruleMultiplication
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
            	    break loop78;
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
    // InternalNavascript.g:5611:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalNavascript.g:5611:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalNavascript.g:5612:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalNavascript.g:5618:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5624:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalNavascript.g:5625:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalNavascript.g:5625:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalNavascript.g:5626:3: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
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
            // InternalNavascript.g:5634:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( ((LA80_0>=86 && LA80_0<=87)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalNavascript.g:5635:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalNavascript.g:5635:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalNavascript.g:5636:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalNavascript.g:5636:5: ()
            	    // InternalNavascript.g:5637:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5643:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalNavascript.g:5644:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalNavascript.g:5644:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalNavascript.g:5645:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalNavascript.g:5645:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt79=2;
            	    int LA79_0 = input.LA(1);

            	    if ( (LA79_0==86) ) {
            	        alt79=1;
            	    }
            	    else if ( (LA79_0==87) ) {
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
            	            // InternalNavascript.g:5646:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,86,FOLLOW_6); if (state.failed) return current;
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
            	            // InternalNavascript.g:5657:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,87,FOLLOW_6); if (state.failed) return current;
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

            	    // InternalNavascript.g:5671:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalNavascript.g:5672:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalNavascript.g:5672:5: (lv_right_3_0= rulePrefixed )
            	    // InternalNavascript.g:5673:6: lv_right_3_0= rulePrefixed
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
            	    break loop80;
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
    // InternalNavascript.g:5695:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalNavascript.g:5695:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalNavascript.g:5696:2: iv_rulePrefixed= rulePrefixed EOF
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
    // InternalNavascript.g:5702:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5708:2: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalNavascript.g:5709:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalNavascript.g:5709:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt81=3;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt81=1;
                }
                break;
            case 85:
                {
                alt81=2;
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
            case 89:
                {
                alt81=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalNavascript.g:5710:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:5710:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalNavascript.g:5711:4: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:5711:4: ()
                    // InternalNavascript.g:5712:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5718:4: ( ( '!' )=>otherlv_1= '!' )
                    // InternalNavascript.g:5719:5: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,88,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      				
                    }

                    }

                    // InternalNavascript.g:5725:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalNavascript.g:5726:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalNavascript.g:5726:5: (lv_expression_2_0= ruleAtomic )
                    // InternalNavascript.g:5727:6: lv_expression_2_0= ruleAtomic
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
                    // InternalNavascript.g:5746:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:5746:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalNavascript.g:5747:4: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:5747:4: ()
                    // InternalNavascript.g:5748:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5754:4: ( ( '-' )=>otherlv_4= '-' )
                    // InternalNavascript.g:5755:5: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,85,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      				
                    }

                    }

                    // InternalNavascript.g:5761:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalNavascript.g:5762:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalNavascript.g:5762:5: (lv_expression_5_0= ruleAtomic )
                    // InternalNavascript.g:5763:6: lv_expression_5_0= ruleAtomic
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
                    // InternalNavascript.g:5782:3: this_Atomic_6= ruleAtomic
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
    // InternalNavascript.g:5794:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalNavascript.g:5794:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalNavascript.g:5795:2: iv_ruleAtomic= ruleAtomic EOF
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
    // InternalNavascript.g:5801:1: ruleAtomic returns [EObject current=null] : ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) ;
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
            // InternalNavascript.g:5807:2: ( ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) )
            // InternalNavascript.g:5808:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            {
            // InternalNavascript.g:5808:2: ( ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            int alt84=9;
            switch ( input.LA(1) ) {
            case RULE_ARGS_START:
                {
                alt84=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt84=2;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt84=3;
                }
                break;
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt84=4;
                }
                break;
            case RULE_IDENTIFIER:
                {
                alt84=5;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt84=6;
                }
                break;
            case RULE_TML_LITERAL:
            case 89:
                {
                alt84=7;
                }
                break;
            case RULE_FORALL:
            case RULE_EXISTS:
                {
                alt84=8;
                }
                break;
            case RULE_NULL_DEF:
                {
                alt84=9;
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
                    // InternalNavascript.g:5809:3: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END )
                    {
                    // InternalNavascript.g:5809:3: ( () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END )
                    // InternalNavascript.g:5810:4: () this_ARGS_START_1= RULE_ARGS_START ( (lv_value_2_0= ruleExpression ) ) this_ARGS_END_3= RULE_ARGS_END
                    {
                    // InternalNavascript.g:5810:4: ()
                    // InternalNavascript.g:5811:5: 
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
                    // InternalNavascript.g:5821:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalNavascript.g:5822:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:5822:5: (lv_value_2_0= ruleExpression )
                    // InternalNavascript.g:5823:6: lv_value_2_0= ruleExpression
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
                    // InternalNavascript.g:5846:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    {
                    // InternalNavascript.g:5846:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    // InternalNavascript.g:5847:4: () ( (lv_value_5_0= RULE_INTEGER ) )
                    {
                    // InternalNavascript.g:5847:4: ()
                    // InternalNavascript.g:5848:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5854:4: ( (lv_value_5_0= RULE_INTEGER ) )
                    // InternalNavascript.g:5855:5: (lv_value_5_0= RULE_INTEGER )
                    {
                    // InternalNavascript.g:5855:5: (lv_value_5_0= RULE_INTEGER )
                    // InternalNavascript.g:5856:6: lv_value_5_0= RULE_INTEGER
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
                    // InternalNavascript.g:5874:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    {
                    // InternalNavascript.g:5874:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    // InternalNavascript.g:5875:4: () ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    {
                    // InternalNavascript.g:5875:4: ()
                    // InternalNavascript.g:5876:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getStringLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5882:4: ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    // InternalNavascript.g:5883:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    {
                    // InternalNavascript.g:5883:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    // InternalNavascript.g:5884:6: lv_value_7_0= RULE_STRING_LITERAL
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
                    // InternalNavascript.g:5902:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    {
                    // InternalNavascript.g:5902:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    // InternalNavascript.g:5903:4: () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    {
                    // InternalNavascript.g:5903:4: ()
                    // InternalNavascript.g:5904:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5910:4: ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    // InternalNavascript.g:5911:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    {
                    // InternalNavascript.g:5911:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    // InternalNavascript.g:5912:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    {
                    // InternalNavascript.g:5912:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==RULE_TRUE) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==RULE_FALSE) ) {
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
                            // InternalNavascript.g:5913:7: lv_value_9_1= RULE_TRUE
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
                            // InternalNavascript.g:5928:7: lv_value_9_2= RULE_FALSE
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
                    // InternalNavascript.g:5947:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    {
                    // InternalNavascript.g:5947:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    // InternalNavascript.g:5948:4: () ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    {
                    // InternalNavascript.g:5948:4: ()
                    // InternalNavascript.g:5949:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getFunctionCallLiteralAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5955:4: ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    // InternalNavascript.g:5956:5: (lv_value_11_0= ruleFunctionIdentifier )
                    {
                    // InternalNavascript.g:5956:5: (lv_value_11_0= ruleFunctionIdentifier )
                    // InternalNavascript.g:5957:6: lv_value_11_0= ruleFunctionIdentifier
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
                    // InternalNavascript.g:5976:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    {
                    // InternalNavascript.g:5976:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    // InternalNavascript.g:5977:4: () ( (lv_value_13_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:5977:4: ()
                    // InternalNavascript.g:5978:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getMappableIdentifierLiteralAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5984:4: ( (lv_value_13_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:5985:5: (lv_value_13_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:5985:5: (lv_value_13_0= ruleMappableIdentifier )
                    // InternalNavascript.g:5986:6: lv_value_13_0= ruleMappableIdentifier
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
                    // InternalNavascript.g:6005:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    {
                    // InternalNavascript.g:6005:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    // InternalNavascript.g:6006:4: () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:6006:4: ()
                    // InternalNavascript.g:6007:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getTmlIdentifierLiteralAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6013:4: ( (lv_hasExists_15_0= '?' ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==89) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalNavascript.g:6014:5: (lv_hasExists_15_0= '?' )
                            {
                            // InternalNavascript.g:6014:5: (lv_hasExists_15_0= '?' )
                            // InternalNavascript.g:6015:6: lv_hasExists_15_0= '?'
                            {
                            lv_hasExists_15_0=(Token)match(input,89,FOLLOW_67); if (state.failed) return current;
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

                    // InternalNavascript.g:6027:4: ( (lv_value_16_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:6028:5: (lv_value_16_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:6028:5: (lv_value_16_0= ruleTmlIdentifier )
                    // InternalNavascript.g:6029:6: lv_value_16_0= ruleTmlIdentifier
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
                    // InternalNavascript.g:6048:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    {
                    // InternalNavascript.g:6048:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    // InternalNavascript.g:6049:4: () ( (lv_value_18_0= ruleForAllIdentifier ) )
                    {
                    // InternalNavascript.g:6049:4: ()
                    // InternalNavascript.g:6050:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getForAllLiteralAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6056:4: ( (lv_value_18_0= ruleForAllIdentifier ) )
                    // InternalNavascript.g:6057:5: (lv_value_18_0= ruleForAllIdentifier )
                    {
                    // InternalNavascript.g:6057:5: (lv_value_18_0= ruleForAllIdentifier )
                    // InternalNavascript.g:6058:6: lv_value_18_0= ruleForAllIdentifier
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
                    // InternalNavascript.g:6077:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    {
                    // InternalNavascript.g:6077:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    // InternalNavascript.g:6078:4: () ( (lv_value_20_0= RULE_NULL_DEF ) )
                    {
                    // InternalNavascript.g:6078:4: ()
                    // InternalNavascript.g:6079:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNullLiteralAction_8_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6085:4: ( (lv_value_20_0= RULE_NULL_DEF ) )
                    // InternalNavascript.g:6086:5: (lv_value_20_0= RULE_NULL_DEF )
                    {
                    // InternalNavascript.g:6086:5: (lv_value_20_0= RULE_NULL_DEF )
                    // InternalNavascript.g:6087:6: lv_value_20_0= RULE_NULL_DEF
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
    // InternalNavascript.g:6108:1: entryRuleForAllIdentifier returns [EObject current=null] : iv_ruleForAllIdentifier= ruleForAllIdentifier EOF ;
    public final EObject entryRuleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllIdentifier = null;


        try {
            // InternalNavascript.g:6108:57: (iv_ruleForAllIdentifier= ruleForAllIdentifier EOF )
            // InternalNavascript.g:6109:2: iv_ruleForAllIdentifier= ruleForAllIdentifier EOF
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
    // InternalNavascript.g:6115:1: ruleForAllIdentifier returns [EObject current=null] : ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' this_ARG_SEP_6= RULE_ARG_SEP ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END ) ;
    public final EObject ruleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token this_ARGS_START_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token this_ARG_SEP_6=null;
        Token lv_messagedefinition_7_0=null;
        Token this_ARGS_END_8=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6121:2: ( ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' this_ARG_SEP_6= RULE_ARG_SEP ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END ) )
            // InternalNavascript.g:6122:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' this_ARG_SEP_6= RULE_ARG_SEP ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END )
            {
            // InternalNavascript.g:6122:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' this_ARG_SEP_6= RULE_ARG_SEP ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END )
            // InternalNavascript.g:6123:3: () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) this_ARGS_START_2= RULE_ARGS_START otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' this_ARG_SEP_6= RULE_ARG_SEP ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) this_ARGS_END_8= RULE_ARGS_END
            {
            // InternalNavascript.g:6123:3: ()
            // InternalNavascript.g:6124:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getForAllIdentifierAccess().getForAllIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6130:3: ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) )
            // InternalNavascript.g:6131:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            {
            // InternalNavascript.g:6131:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            // InternalNavascript.g:6132:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            {
            // InternalNavascript.g:6132:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_FORALL) ) {
                alt85=1;
            }
            else if ( (LA85_0==RULE_EXISTS) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalNavascript.g:6133:6: lv_op_1_1= RULE_FORALL
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
                    // InternalNavascript.g:6148:6: lv_op_1_2= RULE_EXISTS
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
            otherlv_3=(Token)match(input,90,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_3());
              		
            }
            // InternalNavascript.g:6173:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalNavascript.g:6174:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalNavascript.g:6174:4: (lv_expression_4_0= ruleExpression )
            // InternalNavascript.g:6175:5: lv_expression_4_0= ruleExpression
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

            otherlv_5=(Token)match(input,90,FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_5());
              		
            }
            this_ARG_SEP_6=(Token)match(input,RULE_ARG_SEP,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ARG_SEP_6, grammarAccess.getForAllIdentifierAccess().getARG_SEPTerminalRuleCall_6());
              		
            }
            // InternalNavascript.g:6200:3: ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) )
            // InternalNavascript.g:6201:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            {
            // InternalNavascript.g:6201:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            // InternalNavascript.g:6202:5: lv_messagedefinition_7_0= RULE_STRING_LITERAL
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
    // InternalNavascript.g:6226:1: entryRuleFunctionIdentifier returns [EObject current=null] : iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF ;
    public final EObject entryRuleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionIdentifier = null;


        try {
            // InternalNavascript.g:6226:59: (iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF )
            // InternalNavascript.g:6227:2: iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF
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
    // InternalNavascript.g:6233:1: ruleFunctionIdentifier returns [EObject current=null] : ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) ) ;
    public final EObject ruleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_func_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_ARG_SEP_4=null;
        Token this_ARGS_END_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6239:2: ( ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) ) )
            // InternalNavascript.g:6240:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) )
            {
            // InternalNavascript.g:6240:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END ) )
            // InternalNavascript.g:6241:3: () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )
            {
            // InternalNavascript.g:6241:3: ()
            // InternalNavascript.g:6242:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionIdentifierAccess().getFunctionIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6248:3: ( (lv_func_1_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:6249:4: (lv_func_1_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:6249:4: (lv_func_1_0= RULE_IDENTIFIER )
            // InternalNavascript.g:6250:5: lv_func_1_0= RULE_IDENTIFIER
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

            // InternalNavascript.g:6266:3: (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )
            // InternalNavascript.g:6267:4: this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END
            {
            this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(this_ARGS_START_2, grammarAccess.getFunctionIdentifierAccess().getARGS_STARTTerminalRuleCall_2_0());
              			
            }
            // InternalNavascript.g:6271:4: ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ARGS_START||LA87_0==RULE_IDENTIFIER||(LA87_0>=RULE_MAPPABLE_IDENTIFIER && LA87_0<=RULE_TML_LITERAL)||LA87_0==RULE_INTEGER||(LA87_0>=RULE_STRING_LITERAL && LA87_0<=RULE_EXISTS)||LA87_0==85||(LA87_0>=88 && LA87_0<=89)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalNavascript.g:6272:5: ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalNavascript.g:6272:5: ( (lv_args_3_0= ruleExpression ) )
                    // InternalNavascript.g:6273:6: (lv_args_3_0= ruleExpression )
                    {
                    // InternalNavascript.g:6273:6: (lv_args_3_0= ruleExpression )
                    // InternalNavascript.g:6274:7: lv_args_3_0= ruleExpression
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

                    // InternalNavascript.g:6291:5: (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==RULE_ARG_SEP) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalNavascript.g:6292:6: this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    this_ARG_SEP_4=(Token)match(input,RULE_ARG_SEP,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_ARG_SEP_4, grammarAccess.getFunctionIdentifierAccess().getARG_SEPTerminalRuleCall_2_1_1_0());
                    	      					
                    	    }
                    	    // InternalNavascript.g:6296:6: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalNavascript.g:6297:7: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalNavascript.g:6297:7: (lv_args_5_0= ruleExpression )
                    	    // InternalNavascript.g:6298:8: lv_args_5_0= ruleExpression
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
                    	    break loop86;
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
    // InternalNavascript.g:6326:1: entryRuleMappableIdentifier returns [EObject current=null] : iv_ruleMappableIdentifier= ruleMappableIdentifier EOF ;
    public final EObject entryRuleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappableIdentifier = null;


        try {
            // InternalNavascript.g:6326:59: (iv_ruleMappableIdentifier= ruleMappableIdentifier EOF )
            // InternalNavascript.g:6327:2: iv_ruleMappableIdentifier= ruleMappableIdentifier EOF
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
    // InternalNavascript.g:6333:1: ruleMappableIdentifier returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? ) ;
    public final EObject ruleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token this_ARGS_START_2=null;
        Token this_ARG_SEP_4=null;
        Token this_ARGS_END_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6339:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? ) )
            // InternalNavascript.g:6340:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? )
            {
            // InternalNavascript.g:6340:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )? )
            // InternalNavascript.g:6341:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )?
            {
            // InternalNavascript.g:6341:3: ()
            // InternalNavascript.g:6342:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappableIdentifierAccess().getMappableIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6348:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:6349:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:6349:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:6350:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
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

            // InternalNavascript.g:6366:3: (this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ARGS_START) ) {
                int LA90_1 = input.LA(2);

                if ( ((LA90_1>=RULE_ARGS_START && LA90_1<=RULE_ARGS_END)||LA90_1==RULE_IDENTIFIER||(LA90_1>=RULE_MAPPABLE_IDENTIFIER && LA90_1<=RULE_TML_LITERAL)||LA90_1==RULE_INTEGER||(LA90_1>=RULE_STRING_LITERAL && LA90_1<=RULE_EXISTS)||LA90_1==85||(LA90_1>=88 && LA90_1<=89)) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // InternalNavascript.g:6367:4: this_ARGS_START_2= RULE_ARGS_START ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )? this_ARGS_END_6= RULE_ARGS_END
                    {
                    this_ARGS_START_2=(Token)match(input,RULE_ARGS_START,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ARGS_START_2, grammarAccess.getMappableIdentifierAccess().getARGS_STARTTerminalRuleCall_2_0());
                      			
                    }
                    // InternalNavascript.g:6371:4: ( ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==RULE_ARGS_START||LA89_0==RULE_IDENTIFIER||(LA89_0>=RULE_MAPPABLE_IDENTIFIER && LA89_0<=RULE_TML_LITERAL)||LA89_0==RULE_INTEGER||(LA89_0>=RULE_STRING_LITERAL && LA89_0<=RULE_EXISTS)||LA89_0==85||(LA89_0>=88 && LA89_0<=89)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalNavascript.g:6372:5: ( (lv_args_3_0= ruleExpression ) ) (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // InternalNavascript.g:6372:5: ( (lv_args_3_0= ruleExpression ) )
                            // InternalNavascript.g:6373:6: (lv_args_3_0= ruleExpression )
                            {
                            // InternalNavascript.g:6373:6: (lv_args_3_0= ruleExpression )
                            // InternalNavascript.g:6374:7: lv_args_3_0= ruleExpression
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

                            // InternalNavascript.g:6391:5: (this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) ) )*
                            loop88:
                            do {
                                int alt88=2;
                                int LA88_0 = input.LA(1);

                                if ( (LA88_0==RULE_ARG_SEP) ) {
                                    alt88=1;
                                }


                                switch (alt88) {
                            	case 1 :
                            	    // InternalNavascript.g:6392:6: this_ARG_SEP_4= RULE_ARG_SEP ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    this_ARG_SEP_4=(Token)match(input,RULE_ARG_SEP,FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(this_ARG_SEP_4, grammarAccess.getMappableIdentifierAccess().getARG_SEPTerminalRuleCall_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalNavascript.g:6396:6: ( (lv_args_5_0= ruleExpression ) )
                            	    // InternalNavascript.g:6397:7: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // InternalNavascript.g:6397:7: (lv_args_5_0= ruleExpression )
                            	    // InternalNavascript.g:6398:8: lv_args_5_0= ruleExpression
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
                            	    break loop88;
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
    // InternalNavascript.g:6426:1: entryRuleTmlIdentifier returns [EObject current=null] : iv_ruleTmlIdentifier= ruleTmlIdentifier EOF ;
    public final EObject entryRuleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmlIdentifier = null;


        try {
            // InternalNavascript.g:6426:54: (iv_ruleTmlIdentifier= ruleTmlIdentifier EOF )
            // InternalNavascript.g:6427:2: iv_ruleTmlIdentifier= ruleTmlIdentifier EOF
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
    // InternalNavascript.g:6433:1: ruleTmlIdentifier returns [EObject current=null] : ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) ;
    public final EObject ruleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_tml_1_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:6439:2: ( ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) )
            // InternalNavascript.g:6440:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            {
            // InternalNavascript.g:6440:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            // InternalNavascript.g:6441:3: () ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            {
            // InternalNavascript.g:6441:3: ()
            // InternalNavascript.g:6442:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTmlIdentifierAccess().getTmlIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6448:3: ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:6449:4: (lv_tml_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:6449:4: (lv_tml_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:6450:5: lv_tml_1_0= RULE_TML_LITERAL
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
    // InternalNavascript.g:6470:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // InternalNavascript.g:6470:53: (iv_rulePropertyType= rulePropertyType EOF )
            // InternalNavascript.g:6471:2: iv_rulePropertyType= rulePropertyType EOF
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
    // InternalNavascript.g:6477:1: rulePropertyType returns [EObject current=null] : ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) ;
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
            // InternalNavascript.g:6483:2: ( ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) )
            // InternalNavascript.g:6484:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            {
            // InternalNavascript.g:6484:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            int alt91=11;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt91=1;
                }
                break;
            case 92:
                {
                alt91=2;
                }
                break;
            case 93:
                {
                alt91=3;
                }
                break;
            case 94:
                {
                alt91=4;
                }
                break;
            case 95:
                {
                alt91=5;
                }
                break;
            case 96:
                {
                alt91=6;
                }
                break;
            case 97:
                {
                alt91=7;
                }
                break;
            case 98:
                {
                alt91=8;
                }
                break;
            case 99:
                {
                alt91=9;
                }
                break;
            case 100:
                {
                alt91=10;
                }
                break;
            case 101:
                {
                alt91=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalNavascript.g:6485:3: ( () otherlv_1= 'integer' )
                    {
                    // InternalNavascript.g:6485:3: ( () otherlv_1= 'integer' )
                    // InternalNavascript.g:6486:4: () otherlv_1= 'integer'
                    {
                    // InternalNavascript.g:6486:4: ()
                    // InternalNavascript.g:6487:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getIntTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPropertyTypeAccess().getIntegerKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6499:3: ( () otherlv_3= 'string' )
                    {
                    // InternalNavascript.g:6499:3: ( () otherlv_3= 'string' )
                    // InternalNavascript.g:6500:4: () otherlv_3= 'string'
                    {
                    // InternalNavascript.g:6500:4: ()
                    // InternalNavascript.g:6501:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getStringTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPropertyTypeAccess().getStringKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6513:3: ( () otherlv_5= 'boolean' )
                    {
                    // InternalNavascript.g:6513:3: ( () otherlv_5= 'boolean' )
                    // InternalNavascript.g:6514:4: () otherlv_5= 'boolean'
                    {
                    // InternalNavascript.g:6514:4: ()
                    // InternalNavascript.g:6515:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getBooleanTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPropertyTypeAccess().getBooleanKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:6527:3: ( () otherlv_7= 'date' )
                    {
                    // InternalNavascript.g:6527:3: ( () otherlv_7= 'date' )
                    // InternalNavascript.g:6528:4: () otherlv_7= 'date'
                    {
                    // InternalNavascript.g:6528:4: ()
                    // InternalNavascript.g:6529:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getDateTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPropertyTypeAccess().getDateKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:6541:3: ( () otherlv_9= 'float' )
                    {
                    // InternalNavascript.g:6541:3: ( () otherlv_9= 'float' )
                    // InternalNavascript.g:6542:4: () otherlv_9= 'float'
                    {
                    // InternalNavascript.g:6542:4: ()
                    // InternalNavascript.g:6543:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getFloatTypeAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPropertyTypeAccess().getFloatKeyword_4_1());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalNavascript.g:6555:3: ( () otherlv_11= 'binary' )
                    {
                    // InternalNavascript.g:6555:3: ( () otherlv_11= 'binary' )
                    // InternalNavascript.g:6556:4: () otherlv_11= 'binary'
                    {
                    // InternalNavascript.g:6556:4: ()
                    // InternalNavascript.g:6557:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getBinaryTypeAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPropertyTypeAccess().getBinaryKeyword_5_1());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalNavascript.g:6569:3: ( () otherlv_13= 'clocktime' )
                    {
                    // InternalNavascript.g:6569:3: ( () otherlv_13= 'clocktime' )
                    // InternalNavascript.g:6570:4: () otherlv_13= 'clocktime'
                    {
                    // InternalNavascript.g:6570:4: ()
                    // InternalNavascript.g:6571:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getClockTimeTypeAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getPropertyTypeAccess().getClocktimeKeyword_6_1());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalNavascript.g:6583:3: ( () otherlv_15= 'memo' )
                    {
                    // InternalNavascript.g:6583:3: ( () otherlv_15= 'memo' )
                    // InternalNavascript.g:6584:4: () otherlv_15= 'memo'
                    {
                    // InternalNavascript.g:6584:4: ()
                    // InternalNavascript.g:6585:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getMemoTypeAction_7_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_15=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getPropertyTypeAccess().getMemoKeyword_7_1());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalNavascript.g:6597:3: ( () otherlv_17= 'timestamp' )
                    {
                    // InternalNavascript.g:6597:3: ( () otherlv_17= 'timestamp' )
                    // InternalNavascript.g:6598:4: () otherlv_17= 'timestamp'
                    {
                    // InternalNavascript.g:6598:4: ()
                    // InternalNavascript.g:6599:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getTimestampTypeAction_8_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_17=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getPropertyTypeAccess().getTimestampKeyword_8_1());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalNavascript.g:6611:3: ( () otherlv_19= 'percentage' )
                    {
                    // InternalNavascript.g:6611:3: ( () otherlv_19= 'percentage' )
                    // InternalNavascript.g:6612:4: () otherlv_19= 'percentage'
                    {
                    // InternalNavascript.g:6612:4: ()
                    // InternalNavascript.g:6613:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getPercentageTypeAction_9_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_19=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getPropertyTypeAccess().getPercentageKeyword_9_1());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalNavascript.g:6625:3: ( () otherlv_21= 'selection' )
                    {
                    // InternalNavascript.g:6625:3: ( () otherlv_21= 'selection' )
                    // InternalNavascript.g:6626:4: () otherlv_21= 'selection'
                    {
                    // InternalNavascript.g:6626:4: ()
                    // InternalNavascript.g:6627:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPropertyTypeAccess().getSelectionTypeAction_10_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_21=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:6642:1: entryRuleOPTION_TYPE returns [String current=null] : iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF ;
    public final String entryRuleOPTION_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOPTION_TYPE = null;


        try {
            // InternalNavascript.g:6642:51: (iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF )
            // InternalNavascript.g:6643:2: iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF
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
    // InternalNavascript.g:6649:1: ruleOPTION_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'name' | kw= 'value' | kw= 'selected' ) ;
    public final AntlrDatatypeRuleToken ruleOPTION_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:6655:2: ( (kw= 'name' | kw= 'value' | kw= 'selected' ) )
            // InternalNavascript.g:6656:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            {
            // InternalNavascript.g:6656:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            int alt92=3;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt92=1;
                }
                break;
            case 103:
                {
                alt92=2;
                }
                break;
            case 104:
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
                    // InternalNavascript.g:6657:3: kw= 'name'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getNameKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6663:3: kw= 'value'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getValueKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6669:3: kw= 'selected'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:6678:1: entryRuleMessageType returns [EObject current=null] : iv_ruleMessageType= ruleMessageType EOF ;
    public final EObject entryRuleMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageType = null;


        try {
            // InternalNavascript.g:6678:52: (iv_ruleMessageType= ruleMessageType EOF )
            // InternalNavascript.g:6679:2: iv_ruleMessageType= ruleMessageType EOF
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
    // InternalNavascript.g:6685:1: ruleMessageType returns [EObject current=null] : ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) ;
    public final EObject ruleMessageType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalNavascript.g:6691:2: ( ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) )
            // InternalNavascript.g:6692:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            {
            // InternalNavascript.g:6692:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            int alt93=3;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt93=1;
                }
                break;
            case 106:
                {
                alt93=2;
                }
                break;
            case 107:
                {
                alt93=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalNavascript.g:6693:3: ( () otherlv_1= 'array' )
                    {
                    // InternalNavascript.g:6693:3: ( () otherlv_1= 'array' )
                    // InternalNavascript.g:6694:4: () otherlv_1= 'array'
                    {
                    // InternalNavascript.g:6694:4: ()
                    // InternalNavascript.g:6695:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getArrayTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageTypeAccess().getArrayKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6707:3: ( () otherlv_3= 'simple' )
                    {
                    // InternalNavascript.g:6707:3: ( () otherlv_3= 'simple' )
                    // InternalNavascript.g:6708:4: () otherlv_3= 'simple'
                    {
                    // InternalNavascript.g:6708:4: ()
                    // InternalNavascript.g:6709:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getSimpleTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageTypeAccess().getSimpleKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6721:3: ( () otherlv_5= 'arrayelement' )
                    {
                    // InternalNavascript.g:6721:3: ( () otherlv_5= 'arrayelement' )
                    // InternalNavascript.g:6722:4: () otherlv_5= 'arrayelement'
                    {
                    // InternalNavascript.g:6722:4: ()
                    // InternalNavascript.g:6723:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageTypeAccess().getArrayElementTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:6738:1: entryRuleMessageMode returns [EObject current=null] : iv_ruleMessageMode= ruleMessageMode EOF ;
    public final EObject entryRuleMessageMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageMode = null;


        try {
            // InternalNavascript.g:6738:52: (iv_ruleMessageMode= ruleMessageMode EOF )
            // InternalNavascript.g:6739:2: iv_ruleMessageMode= ruleMessageMode EOF
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
    // InternalNavascript.g:6745:1: ruleMessageMode returns [EObject current=null] : ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) ;
    public final EObject ruleMessageMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:6751:2: ( ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) )
            // InternalNavascript.g:6752:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            {
            // InternalNavascript.g:6752:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==108) ) {
                alt94=1;
            }
            else if ( (LA94_0==109) ) {
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
                    // InternalNavascript.g:6753:3: ( () otherlv_1= 'ignore' )
                    {
                    // InternalNavascript.g:6753:3: ( () otherlv_1= 'ignore' )
                    // InternalNavascript.g:6754:4: () otherlv_1= 'ignore'
                    {
                    // InternalNavascript.g:6754:4: ()
                    // InternalNavascript.g:6755:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageModeAccess().getIgnoreAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageModeAccess().getIgnoreKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6767:3: ( () otherlv_3= 'overwrite' )
                    {
                    // InternalNavascript.g:6767:3: ( () otherlv_3= 'overwrite' )
                    // InternalNavascript.g:6768:4: () otherlv_3= 'overwrite'
                    {
                    // InternalNavascript.g:6768:4: ()
                    // InternalNavascript.g:6769:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getMessageModeAccess().getOverwriteAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0001050EF8820150L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0001050ED8820152L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xF010C20000000200L,0x0000000003200003L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0001050ED8820150L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0007650ED8820150L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0007650ED88201D0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000000001D000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0001050ED88201D0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0xF010C20005000200L,0x0000000003200003L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000040200L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000380400L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000090L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000C00000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001000040240L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000040040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0007E50ED88201D0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x00000E0000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000000400L,0x000001C000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000000000L,0x000001C000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000400000002240L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xF010C20005000210L,0x0000000003200003L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000001000002240L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000001000002040L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000000000090L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x00000E3FF8000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000001000042240L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000001000042040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0628004000100000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x01C0000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0800000000000010L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000078000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200800L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000800000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xF010C20000000600L,0x0000000003200003L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000202L});

}