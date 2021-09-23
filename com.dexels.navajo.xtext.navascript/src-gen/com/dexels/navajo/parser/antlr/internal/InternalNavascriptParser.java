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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_IDENTIFIER", "RULE_STRING_CONSTANT", "RULE_IDENTIFIER", "RULE_OBJECT_IDENTIFIER", "RULE_METHOD_IDENTIFIER", "RULE_MAPPABLE_IDENTIFIER", "RULE_TML_LITERAL", "RULE_INTEGER", "RULE_ONE", "RULE_FLOAT", "RULE_STRING_LITERAL", "RULE_TRUE", "RULE_FALSE", "RULE_NULL_DEF", "RULE_FORALL", "RULE_EXISTS", "RULE_MAPPABLE_ID", "RULE_UNDERSCORE", "RULE_LETTER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'if'", "'then'", "'{'", "'}'", "'synchronized'", "'('", "')'", "','", "'context'", "'='", "':'", "'user'", "'service'", "'key'", "'timeout'", "'breakOnNoLock'", "'break'", "';'", "'code'", "'description'", "'error'", "'validations'", "'define'", "'check'", "'print'", "'log'", "'finally'", "'methods'", "'loop'", "'filter'", "'include'", "'antimessage'", "'message'", "'['", "']'", "'type'", "'mode'", "'map.'", "'map'", "'object'", "'var'", "'property'", "'option'", "'length'", "'direction'", "'in'", "'out'", "'inout'", "'cardinality'", "'+'", "'subtype'", "'else'", "'OR'", "'AND'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'-'", "'*'", "'/'", "'!'", "'?'", "'`'", "'integer'", "'string'", "'boolean'", "'date'", "'float'", "'binary'", "'clocktime'", "'memo'", "'timestamp'", "'percentage'", "'selection'", "'name'", "'value'", "'selected'", "'array'", "'simple'", "'arrayelement'", "'ignore'", "'overwrite'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_EXISTS=19;
    public static final int RULE_NULL_DEF=17;
    public static final int RULE_MAPPABLE_IDENTIFIER=9;
    public static final int RULE_METHOD_IDENTIFIER=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=23;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_FALSE=16;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_QUOTED_IDENTIFIER=4;
    public static final int RULE_LETTER=22;
    public static final int T__48=48;
    public static final int RULE_MAPPABLE_ID=20;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=13;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_UNDERSCORE=21;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_STRING_CONSTANT=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int RULE_ONE=12;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_IDENTIFIER=6;
    public static final int RULE_STRING_LITERAL=14;
    public static final int RULE_SL_COMMENT=24;
    public static final int RULE_FORALL=18;
    public static final int RULE_TML_LITERAL=10;
    public static final int T__77=77;
    public static final int RULE_TRUE=15;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=25;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int RULE_OBJECT_IDENTIFIER=7;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=11;
    public static final int T__86=86;
    public static final int T__106=106;
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



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

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
    // InternalNavascript.g:70:1: entryRuleNavascript returns [EObject current=null] : iv_ruleNavascript= ruleNavascript EOF ;
    public final EObject entryRuleNavascript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavascript = null;


        try {
            // InternalNavascript.g:70:51: (iv_ruleNavascript= ruleNavascript EOF )
            // InternalNavascript.g:71:2: iv_ruleNavascript= ruleNavascript EOF
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
    // InternalNavascript.g:77:1: ruleNavascript returns [EObject current=null] : ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? ) ;
    public final EObject ruleNavascript() throws RecognitionException {
        EObject current = null;

        EObject lv_validations_1_0 = null;

        EObject lv_toplevelStatements_2_0 = null;

        EObject lv_finally_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:83:2: ( ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? ) )
            // InternalNavascript.g:84:2: ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? )
            {
            // InternalNavascript.g:84:2: ( () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )? )
            // InternalNavascript.g:85:3: () ( (lv_validations_1_0= ruleValidations ) )? ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) ) ( (lv_finally_3_0= ruleFinally ) )?
            {
            // InternalNavascript.g:85:3: ()
            // InternalNavascript.g:86:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNavascriptAccess().getNavascriptAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:95:3: ( (lv_validations_1_0= ruleValidations ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==47) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNavascript.g:96:4: (lv_validations_1_0= ruleValidations )
                    {
                    // InternalNavascript.g:96:4: (lv_validations_1_0= ruleValidations )
                    // InternalNavascript.g:97:5: lv_validations_1_0= ruleValidations
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

            // InternalNavascript.g:114:3: ( (lv_toplevelStatements_2_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:115:4: (lv_toplevelStatements_2_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:115:4: (lv_toplevelStatements_2_0= ruleTopLevelStatements )
            // InternalNavascript.g:116:5: lv_toplevelStatements_2_0= ruleTopLevelStatements
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

            // InternalNavascript.g:133:3: ( (lv_finally_3_0= ruleFinally ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==52) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalNavascript.g:134:4: (lv_finally_3_0= ruleFinally )
                    {
                    // InternalNavascript.g:134:4: (lv_finally_3_0= ruleFinally )
                    // InternalNavascript.g:135:5: lv_finally_3_0= ruleFinally
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
    // InternalNavascript.g:156:1: entryRuleTopLevelStatements returns [EObject current=null] : iv_ruleTopLevelStatements= ruleTopLevelStatements EOF ;
    public final EObject entryRuleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatements = null;


        try {
            // InternalNavascript.g:156:59: (iv_ruleTopLevelStatements= ruleTopLevelStatements EOF )
            // InternalNavascript.g:157:2: iv_ruleTopLevelStatements= ruleTopLevelStatements EOF
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
    // InternalNavascript.g:163:1: ruleTopLevelStatements returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) ;
    public final EObject ruleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:169:2: ( ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) )
            // InternalNavascript.g:170:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            {
            // InternalNavascript.g:170:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            // InternalNavascript.g:171:3: () ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            {
            // InternalNavascript.g:171:3: ()
            // InternalNavascript.g:172:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTopLevelStatementsAccess().getTopLevelStatementsAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:181:3: ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26||LA3_0==28||LA3_0==30||LA3_0==42||LA3_0==48||(LA3_0>=50 && LA3_0<=51)||(LA3_0>=53 && LA3_0<=54)||(LA3_0>=56 && LA3_0<=58)||(LA3_0>=63 && LA3_0<=64)||LA3_0==66) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalNavascript.g:182:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:182:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:183:5: lv_statements_1_0= ruleTopLevelStatement
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
    // InternalNavascript.g:204:1: entryRuleTopLevelStatement returns [EObject current=null] : iv_ruleTopLevelStatement= ruleTopLevelStatement EOF ;
    public final EObject entryRuleTopLevelStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatement = null;


        try {
            // InternalNavascript.g:204:58: (iv_ruleTopLevelStatement= ruleTopLevelStatement EOF )
            // InternalNavascript.g:205:2: iv_ruleTopLevelStatement= ruleTopLevelStatement EOF
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
    // InternalNavascript.g:211:1: ruleTopLevelStatement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) ;
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
            // InternalNavascript.g:217:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:218:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:218:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:219:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:219:3: ()
            // InternalNavascript.g:220:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTopLevelStatementAccess().getTopLevelStatementAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:229:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==26) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalNavascript.g:230:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTopLevelStatementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:234:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:235:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:235:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:236:6: lv_condition_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTopLevelStatementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:258:3: ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            // InternalNavascript.g:259:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            {
            // InternalNavascript.g:259:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            // InternalNavascript.g:260:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            {
            // InternalNavascript.g:260:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            int alt5=13;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt5=1;
                }
                break;
            case 66:
                {
                alt5=2;
                }
                break;
            case 63:
            case 64:
                {
                alt5=3;
                }
                break;
            case 57:
                {
                alt5=4;
                }
                break;
            case 48:
                {
                alt5=5;
                }
                break;
            case 50:
                {
                alt5=6;
                }
                break;
            case 51:
                {
                alt5=7;
                }
                break;
            case 54:
                {
                alt5=8;
                }
                break;
            case 53:
                {
                alt5=9;
                }
                break;
            case 56:
                {
                alt5=10;
                }
                break;
            case 42:
                {
                alt5=11;
                }
                break;
            case 30:
                {
                alt5=12;
                }
                break;
            case 28:
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
                    // InternalNavascript.g:261:6: lv_statement_4_1= ruleMessage
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
                    // InternalNavascript.g:277:6: lv_statement_4_2= ruleVar
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
                    // InternalNavascript.g:293:6: lv_statement_4_3= ruleMap
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
                    // InternalNavascript.g:309:6: lv_statement_4_4= ruleAntiMessage
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
                    // InternalNavascript.g:325:6: lv_statement_4_5= ruleDefine
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
                    // InternalNavascript.g:341:6: lv_statement_4_6= rulePrint
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
                    // InternalNavascript.g:357:6: lv_statement_4_7= ruleLog
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
                    // InternalNavascript.g:373:6: lv_statement_4_8= ruleLoop
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
                    // InternalNavascript.g:389:6: lv_statement_4_9= ruleMethods
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
                    // InternalNavascript.g:405:6: lv_statement_4_10= ruleInclude
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
                    // InternalNavascript.g:421:6: lv_statement_4_11= ruleBreak
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
                    // InternalNavascript.g:437:6: lv_statement_4_12= ruleSynchronized
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
                    // InternalNavascript.g:453:6: lv_statement_4_13= ruleBlockStatements
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
    // InternalNavascript.g:475:1: entryRuleInnerBody returns [EObject current=null] : iv_ruleInnerBody= ruleInnerBody EOF ;
    public final EObject entryRuleInnerBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInnerBody = null;


        try {
            // InternalNavascript.g:475:50: (iv_ruleInnerBody= ruleInnerBody EOF )
            // InternalNavascript.g:476:2: iv_ruleInnerBody= ruleInnerBody EOF
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
    // InternalNavascript.g:482:1: ruleInnerBody returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) ;
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
            // InternalNavascript.g:488:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:489:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:489:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:490:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:490:3: ()
            // InternalNavascript.g:491:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInnerBodyAccess().getInnerBodyAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:500:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalNavascript.g:501:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInnerBodyAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:505:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:506:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:506:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:507:6: lv_condition_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,27,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getInnerBodyAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:529:3: ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            // InternalNavascript.g:530:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            {
            // InternalNavascript.g:530:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            // InternalNavascript.g:531:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            {
            // InternalNavascript.g:531:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            int alt7=15;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt7=1;
                }
                break;
            case 68:
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
            case 58:
                {
                alt7=4;
                }
                break;
            case 57:
                {
                alt7=5;
                }
                break;
            case 56:
                {
                alt7=6;
                }
                break;
            case 53:
                {
                alt7=7;
                }
                break;
            case 66:
                {
                alt7=8;
                }
                break;
            case 50:
                {
                alt7=9;
                }
                break;
            case 51:
                {
                alt7=10;
                }
                break;
            case 48:
                {
                alt7=11;
                }
                break;
            case 54:
                {
                alt7=12;
                }
                break;
            case 63:
            case 64:
                {
                alt7=13;
                }
                break;
            case 42:
                {
                alt7=14;
                }
                break;
            case 28:
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
                    // InternalNavascript.g:532:6: lv_statement_4_1= ruleProperty
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
                    // InternalNavascript.g:548:6: lv_statement_4_2= ruleOption
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
                    // InternalNavascript.g:564:6: lv_statement_4_3= ruleMethodOrSetter
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
                    // InternalNavascript.g:580:6: lv_statement_4_4= ruleMessage
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
                    // InternalNavascript.g:596:6: lv_statement_4_5= ruleAntiMessage
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
                    // InternalNavascript.g:612:6: lv_statement_4_6= ruleInclude
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
                    // InternalNavascript.g:628:6: lv_statement_4_7= ruleMethods
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
                    // InternalNavascript.g:644:6: lv_statement_4_8= ruleVar
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
                    // InternalNavascript.g:660:6: lv_statement_4_9= rulePrint
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
                    // InternalNavascript.g:676:6: lv_statement_4_10= ruleLog
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
                    // InternalNavascript.g:692:6: lv_statement_4_11= ruleDefine
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
                    // InternalNavascript.g:708:6: lv_statement_4_12= ruleLoop
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
                    // InternalNavascript.g:724:6: lv_statement_4_13= ruleMap
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
                    // InternalNavascript.g:740:6: lv_statement_4_14= ruleBreak
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
                    // InternalNavascript.g:756:6: lv_statement_4_15= ruleBlockStatements
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
    // InternalNavascript.g:778:1: entryRuleBlockStatements returns [EObject current=null] : iv_ruleBlockStatements= ruleBlockStatements EOF ;
    public final EObject entryRuleBlockStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatements = null;


        try {
            // InternalNavascript.g:778:56: (iv_ruleBlockStatements= ruleBlockStatements EOF )
            // InternalNavascript.g:779:2: iv_ruleBlockStatements= ruleBlockStatements EOF
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
    // InternalNavascript.g:785:1: ruleBlockStatements returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockStatements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:791:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:792:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:792:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:793:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:793:3: ()
            // InternalNavascript.g:794:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockStatementsAccess().getBlockStatementsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockStatementsAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:807:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_METHOD_IDENTIFIER && LA8_0<=RULE_MAPPABLE_IDENTIFIER)||LA8_0==26||LA8_0==28||LA8_0==42||LA8_0==48||(LA8_0>=50 && LA8_0<=51)||(LA8_0>=53 && LA8_0<=54)||(LA8_0>=56 && LA8_0<=58)||(LA8_0>=63 && LA8_0<=64)||(LA8_0>=66 && LA8_0<=68)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalNavascript.g:808:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:808:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:809:5: lv_statements_2_0= ruleInnerBody
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

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:834:1: entryRuleSynchronized returns [EObject current=null] : iv_ruleSynchronized= ruleSynchronized EOF ;
    public final EObject entryRuleSynchronized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronized = null;


        try {
            // InternalNavascript.g:834:53: (iv_ruleSynchronized= ruleSynchronized EOF )
            // InternalNavascript.g:835:2: iv_ruleSynchronized= ruleSynchronized EOF
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
    // InternalNavascript.g:841:1: ruleSynchronized returns [EObject current=null] : (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) ;
    public final EObject ruleSynchronized() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_statements_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:847:2: ( (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) )
            // InternalNavascript.g:848:2: (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            {
            // InternalNavascript.g:848:2: (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            // InternalNavascript.g:849:3: otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSynchronizedAccess().getSynchronizedKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSynchronizedAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:857:3: ( (lv_arguments_2_0= ruleSynchronizedArguments ) )
            // InternalNavascript.g:858:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            {
            // InternalNavascript.g:858:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            // InternalNavascript.g:859:5: lv_arguments_2_0= ruleSynchronizedArguments
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

            otherlv_3=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSynchronizedAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,28,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSynchronizedAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:884:3: ( (lv_statements_5_0= ruleTopLevelStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26||LA9_0==28||LA9_0==30||LA9_0==42||LA9_0==48||(LA9_0>=50 && LA9_0<=51)||(LA9_0>=53 && LA9_0<=54)||(LA9_0>=56 && LA9_0<=58)||(LA9_0>=63 && LA9_0<=64)||LA9_0==66) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalNavascript.g:885:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:885:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:886:5: lv_statements_5_0= ruleTopLevelStatement
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

            otherlv_6=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:911:1: entryRuleSynchronizedArguments returns [EObject current=null] : iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF ;
    public final EObject entryRuleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArguments = null;


        try {
            // InternalNavascript.g:911:62: (iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF )
            // InternalNavascript.g:912:2: iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF
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
    // InternalNavascript.g:918:1: ruleSynchronizedArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) ;
    public final EObject ruleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:924:2: ( ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) )
            // InternalNavascript.g:925:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            {
            // InternalNavascript.g:925:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            // InternalNavascript.g:926:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            {
            // InternalNavascript.g:926:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) )
            // InternalNavascript.g:927:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            {
            // InternalNavascript.g:927:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            // InternalNavascript.g:928:5: lv_arguments_0_0= ruleSynchronizedArgument
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

            // InternalNavascript.g:945:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==33) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalNavascript.g:946:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSynchronizedArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:950:4: ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    // InternalNavascript.g:951:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    {
            	    // InternalNavascript.g:951:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    // InternalNavascript.g:952:6: lv_arguments_2_0= ruleSynchronizedArgument
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
    // InternalNavascript.g:974:1: entryRuleSynchronizedArgument returns [EObject current=null] : iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF ;
    public final EObject entryRuleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArgument = null;


        try {
            // InternalNavascript.g:974:61: (iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF )
            // InternalNavascript.g:975:2: iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF
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
    // InternalNavascript.g:981:1: ruleSynchronizedArgument returns [EObject current=null] : ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) ;
    public final EObject ruleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject this_SKey_2 = null;

        EObject this_STimeout_3 = null;

        EObject this_SBreakOnNoLock_4 = null;



        	enterRule();

        try {
            // InternalNavascript.g:987:2: ( ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) )
            // InternalNavascript.g:988:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            {
            // InternalNavascript.g:988:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt11=1;
                }
                break;
            case 39:
                {
                alt11=2;
                }
                break;
            case 40:
                {
                alt11=3;
                }
                break;
            case 41:
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
                    // InternalNavascript.g:989:3: ( () ruleSContext )
                    {
                    // InternalNavascript.g:989:3: ( () ruleSContext )
                    // InternalNavascript.g:990:4: () ruleSContext
                    {
                    // InternalNavascript.g:990:4: ()
                    // InternalNavascript.g:991:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSynchronizedArgumentAccess().getSynchronizedArgumentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				/* */
                      			
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
                    // InternalNavascript.g:1012:3: this_SKey_2= ruleSKey
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:1024:3: this_STimeout_3= ruleSTimeout
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:1036:3: this_SBreakOnNoLock_4= ruleSBreakOnNoLock
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
    // InternalNavascript.g:1051:1: entryRuleSContext returns [String current=null] : iv_ruleSContext= ruleSContext EOF ;
    public final String entryRuleSContext() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSContext = null;


        try {
            // InternalNavascript.g:1051:48: (iv_ruleSContext= ruleSContext EOF )
            // InternalNavascript.g:1052:2: iv_ruleSContext= ruleSContext EOF
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
    // InternalNavascript.g:1058:1: ruleSContext returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) ) ;
    public final AntlrDatatypeRuleToken ruleSContext() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:1064:2: ( (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) ) )
            // InternalNavascript.g:1065:2: (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) )
            {
            // InternalNavascript.g:1065:2: (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) )
            // InternalNavascript.g:1066:3: kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' )
            {
            kw=(Token)match(input,34,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getSContextAccess().getContextKeyword_0());
              		
            }
            // InternalNavascript.g:1071:3: (kw= '=' | kw= ':' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            else if ( (LA12_0==36) ) {
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
                    // InternalNavascript.g:1072:4: kw= '='
                    {
                    kw=(Token)match(input,35,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1078:4: kw= ':'
                    {
                    kw=(Token)match(input,36,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1084:3: (kw= 'user' | kw= 'service' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            else if ( (LA13_0==38) ) {
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
                    // InternalNavascript.g:1085:4: kw= 'user'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getUserKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1091:4: kw= 'service'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getServiceKeyword_2_1());
                      			
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
    // $ANTLR end "ruleSContext"


    // $ANTLR start "entryRuleSKey"
    // InternalNavascript.g:1101:1: entryRuleSKey returns [EObject current=null] : iv_ruleSKey= ruleSKey EOF ;
    public final EObject entryRuleSKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSKey = null;


        try {
            // InternalNavascript.g:1101:45: (iv_ruleSKey= ruleSKey EOF )
            // InternalNavascript.g:1102:2: iv_ruleSKey= ruleSKey EOF
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
    // InternalNavascript.g:1108:1: ruleSKey returns [EObject current=null] : (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression ) ;
    public final EObject ruleSKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_LiteralOrExpression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1114:2: ( (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression ) )
            // InternalNavascript.g:1115:2: (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:1115:2: (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression )
            // InternalNavascript.g:1116:3: otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression
            {
            otherlv_0=(Token)match(input,39,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSKeyAccess().getKeyKeyword_0());
              		
            }
            // InternalNavascript.g:1120:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            else if ( (LA14_0==36) ) {
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
                    // InternalNavascript.g:1121:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSKeyAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1126:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSKeyAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSKeyAccess().getLiteralOrExpressionParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_LiteralOrExpression_3=ruleLiteralOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LiteralOrExpression_3;
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
    // InternalNavascript.g:1146:1: entryRuleSTimeout returns [EObject current=null] : iv_ruleSTimeout= ruleSTimeout EOF ;
    public final EObject entryRuleSTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTimeout = null;


        try {
            // InternalNavascript.g:1146:49: (iv_ruleSTimeout= ruleSTimeout EOF )
            // InternalNavascript.g:1147:2: iv_ruleSTimeout= ruleSTimeout EOF
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
    // InternalNavascript.g:1153:1: ruleSTimeout returns [EObject current=null] : (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSTimeout() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1159:2: ( (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1160:2: (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1160:2: (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1161:3: otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            otherlv_0=(Token)match(input,40,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSTimeoutAccess().getTimeoutKeyword_0());
              		
            }
            // InternalNavascript.g:1165:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            else if ( (LA15_0==36) ) {
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
                    // InternalNavascript.g:1166:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSTimeoutAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1171:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSTimeoutAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			/* */
              		
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
    // InternalNavascript.g:1191:1: entryRuleSBreakOnNoLock returns [EObject current=null] : iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF ;
    public final EObject entryRuleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSBreakOnNoLock = null;


        try {
            // InternalNavascript.g:1191:55: (iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF )
            // InternalNavascript.g:1192:2: iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF
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
    // InternalNavascript.g:1198:1: ruleSBreakOnNoLock returns [EObject current=null] : (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1204:2: ( (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1205:2: (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1205:2: (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1206:3: otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            otherlv_0=(Token)match(input,41,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSBreakOnNoLockAccess().getBreakOnNoLockKeyword_0());
              		
            }
            // InternalNavascript.g:1210:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            else if ( (LA16_0==36) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalNavascript.g:1211:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSBreakOnNoLockAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1216:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSBreakOnNoLockAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			/* */
              		
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


    // $ANTLR start "entryRuleBreak"
    // InternalNavascript.g:1236:1: entryRuleBreak returns [EObject current=null] : iv_ruleBreak= ruleBreak EOF ;
    public final EObject entryRuleBreak() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreak = null;


        try {
            // InternalNavascript.g:1236:46: (iv_ruleBreak= ruleBreak EOF )
            // InternalNavascript.g:1237:2: iv_ruleBreak= ruleBreak EOF
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
    // InternalNavascript.g:1243:1: ruleBreak returns [EObject current=null] : ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' ) ;
    public final EObject ruleBreak() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1249:2: ( ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' ) )
            // InternalNavascript.g:1250:2: ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' )
            {
            // InternalNavascript.g:1250:2: ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' )
            // InternalNavascript.g:1251:3: () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';'
            {
            // InternalNavascript.g:1251:3: ()
            // InternalNavascript.g:1252:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBreakAccess().getBreakAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBreakAccess().getBreakKeyword_1());
              		
            }
            // InternalNavascript.g:1265:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalNavascript.g:1266:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBreakAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:1270:4: ( (lv_parameters_3_0= ruleBreakParameters ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=44 && LA17_0<=46)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalNavascript.g:1271:5: (lv_parameters_3_0= ruleBreakParameters )
                            {
                            // InternalNavascript.g:1271:5: (lv_parameters_3_0= ruleBreakParameters )
                            // InternalNavascript.g:1272:6: lv_parameters_3_0= ruleBreakParameters
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

                    otherlv_4=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBreakAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1302:1: entryRuleBreakParameter returns [EObject current=null] : iv_ruleBreakParameter= ruleBreakParameter EOF ;
    public final EObject entryRuleBreakParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameter = null;


        try {
            // InternalNavascript.g:1302:55: (iv_ruleBreakParameter= ruleBreakParameter EOF )
            // InternalNavascript.g:1303:2: iv_ruleBreakParameter= ruleBreakParameter EOF
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
    // InternalNavascript.g:1309:1: ruleBreakParameter returns [EObject current=null] : ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) ;
    public final EObject ruleBreakParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_code_3_0 = null;

        EObject lv_description_7_0 = null;

        EObject this_LiteralOrExpression_11 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1315:2: ( ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:1316:2: ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:1316:2: ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt22=1;
                }
                break;
            case 45:
                {
                alt22=2;
                }
                break;
            case 46:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalNavascript.g:1317:3: (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1317:3: (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1318:4: otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_0=(Token)match(input,44,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getBreakParameterAccess().getCodeKeyword_0_0());
                      			
                    }
                    // InternalNavascript.g:1322:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==35) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==36) ) {
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
                            // InternalNavascript.g:1323:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1328:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBreakParameterAccess().getColonKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1333:4: ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1334:5: (lv_code_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1334:5: (lv_code_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1335:6: lv_code_3_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1354:3: (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1354:3: (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1355:4: otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_4=(Token)match(input,45,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBreakParameterAccess().getDescriptionKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1359:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==35) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==36) ) {
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
                            // InternalNavascript.g:1360:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1365:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getBreakParameterAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1370:4: ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1371:5: (lv_description_7_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1371:5: (lv_description_7_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1372:6: lv_description_7_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1391:3: (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1391:3: (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    // InternalNavascript.g:1392:4: otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression
                    {
                    otherlv_8=(Token)match(input,46,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getBreakParameterAccess().getErrorKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:1396:4: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==35) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==36) ) {
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
                            // InternalNavascript.g:1397:5: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_2_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1402:5: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_10, grammarAccess.getBreakParameterAccess().getColonKeyword_2_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				/* */
                      			
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
    // InternalNavascript.g:1423:1: entryRuleBreakParameters returns [EObject current=null] : iv_ruleBreakParameters= ruleBreakParameters EOF ;
    public final EObject entryRuleBreakParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameters = null;


        try {
            // InternalNavascript.g:1423:56: (iv_ruleBreakParameters= ruleBreakParameters EOF )
            // InternalNavascript.g:1424:2: iv_ruleBreakParameters= ruleBreakParameters EOF
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
    // InternalNavascript.g:1430:1: ruleBreakParameters returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) ;
    public final EObject ruleBreakParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1436:2: ( ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) )
            // InternalNavascript.g:1437:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            {
            // InternalNavascript.g:1437:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            // InternalNavascript.g:1438:3: ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            {
            // InternalNavascript.g:1438:3: ( (lv_parameters_0_0= ruleBreakParameter ) )
            // InternalNavascript.g:1439:4: (lv_parameters_0_0= ruleBreakParameter )
            {
            // InternalNavascript.g:1439:4: (lv_parameters_0_0= ruleBreakParameter )
            // InternalNavascript.g:1440:5: lv_parameters_0_0= ruleBreakParameter
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

            // InternalNavascript.g:1457:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==33) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalNavascript.g:1458:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBreakParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:1462:4: ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    // InternalNavascript.g:1463:5: (lv_parameters_2_0= ruleBreakParameter )
            	    {
            	    // InternalNavascript.g:1463:5: (lv_parameters_2_0= ruleBreakParameter )
            	    // InternalNavascript.g:1464:6: lv_parameters_2_0= ruleBreakParameter
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
            	    break loop23;
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
    // InternalNavascript.g:1486:1: entryRuleValidations returns [EObject current=null] : iv_ruleValidations= ruleValidations EOF ;
    public final EObject entryRuleValidations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidations = null;


        try {
            // InternalNavascript.g:1486:52: (iv_ruleValidations= ruleValidations EOF )
            // InternalNavascript.g:1487:2: iv_ruleValidations= ruleValidations EOF
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
    // InternalNavascript.g:1493:1: ruleValidations returns [EObject current=null] : ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) ;
    public final EObject ruleValidations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_checks_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1499:2: ( ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:1500:2: ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:1500:2: ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            // InternalNavascript.g:1501:3: () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:1501:3: ()
            // InternalNavascript.g:1502:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValidationsAccess().getValidationsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,47,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getValidationsAccess().getValidationsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getValidationsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:1519:3: ( (lv_checks_3_0= ruleCheck ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26||LA24_0==49) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalNavascript.g:1520:4: (lv_checks_3_0= ruleCheck )
            	    {
            	    // InternalNavascript.g:1520:4: (lv_checks_3_0= ruleCheck )
            	    // InternalNavascript.g:1521:5: lv_checks_3_0= ruleCheck
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
            	    break loop24;
                }
            } while (true);

            otherlv_4=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1546:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // InternalNavascript.g:1546:47: (iv_ruleDefine= ruleDefine EOF )
            // InternalNavascript.g:1547:2: iv_ruleDefine= ruleDefine EOF
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
    // InternalNavascript.g:1553:1: ruleDefine returns [EObject current=null] : ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleDefine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_defineKey_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1559:2: ( ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) )
            // InternalNavascript.g:1560:2: ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            {
            // InternalNavascript.g:1560:2: ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            // InternalNavascript.g:1561:3: () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';'
            {
            // InternalNavascript.g:1561:3: ()
            // InternalNavascript.g:1562:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDefineAccess().getDefineAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDefineAccess().getDefineKeyword_1());
              		
            }
            // InternalNavascript.g:1575:3: ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:1576:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:1576:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:1577:5: lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER
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

            // InternalNavascript.g:1593:3: (otherlv_3= '=' | otherlv_4= ':' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            else if ( (LA25_0==36) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalNavascript.g:1594:4: otherlv_3= '='
                    {
                    otherlv_3=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDefineAccess().getEqualsSignKeyword_3_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1599:4: otherlv_4= ':'
                    {
                    otherlv_4=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDefineAccess().getColonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1604:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalNavascript.g:1605:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalNavascript.g:1605:4: (lv_expression_5_0= ruleExpression )
            // InternalNavascript.g:1606:5: lv_expression_5_0= ruleExpression
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

            otherlv_6=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1631:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalNavascript.g:1631:46: (iv_ruleCheck= ruleCheck EOF )
            // InternalNavascript.g:1632:2: iv_ruleCheck= ruleCheck EOF
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
    // InternalNavascript.g:1638:1: ruleCheck returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_condition_2_0 = null;

        EObject lv_checkAttributes_6_0 = null;

        EObject lv_checkAttributes_8_0 = null;

        EObject lv_expression_12_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1644:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) )
            // InternalNavascript.g:1645:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            {
            // InternalNavascript.g:1645:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            // InternalNavascript.g:1646:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';'
            {
            // InternalNavascript.g:1646:3: ()
            // InternalNavascript.g:1647:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCheckAccess().getCheckAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:1656:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalNavascript.g:1657:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCheckAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1661:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:1662:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1662:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:1663:6: lv_condition_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,27,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCheckAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,49,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCheckAccess().getCheckKeyword_2());
              		
            }
            otherlv_5=(Token)match(input,31,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCheckAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalNavascript.g:1693:3: ( (lv_checkAttributes_6_0= ruleCheckAttribute ) )
            // InternalNavascript.g:1694:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            {
            // InternalNavascript.g:1694:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            // InternalNavascript.g:1695:5: lv_checkAttributes_6_0= ruleCheckAttribute
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

            // InternalNavascript.g:1712:3: (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalNavascript.g:1713:4: otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    {
                    otherlv_7=(Token)match(input,33,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCheckAccess().getCommaKeyword_5_0());
                      			
                    }
                    // InternalNavascript.g:1717:4: ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    // InternalNavascript.g:1718:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    {
                    // InternalNavascript.g:1718:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    // InternalNavascript.g:1719:6: lv_checkAttributes_8_0= ruleCheckAttribute
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

            otherlv_9=(Token)match(input,32,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getCheckAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalNavascript.g:1741:3: (otherlv_10= '=' | otherlv_11= ':' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                alt28=1;
            }
            else if ( (LA28_0==36) ) {
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
                    // InternalNavascript.g:1742:4: otherlv_10= '='
                    {
                    otherlv_10=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCheckAccess().getEqualsSignKeyword_7_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1747:4: otherlv_11= ':'
                    {
                    otherlv_11=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCheckAccess().getColonKeyword_7_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1752:3: ( (lv_expression_12_0= ruleExpression ) )
            // InternalNavascript.g:1753:4: (lv_expression_12_0= ruleExpression )
            {
            // InternalNavascript.g:1753:4: (lv_expression_12_0= ruleExpression )
            // InternalNavascript.g:1754:5: lv_expression_12_0= ruleExpression
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

            otherlv_13=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1779:1: entryRuleCheckAttribute returns [EObject current=null] : iv_ruleCheckAttribute= ruleCheckAttribute EOF ;
    public final EObject entryRuleCheckAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckAttribute = null;


        try {
            // InternalNavascript.g:1779:55: (iv_ruleCheckAttribute= ruleCheckAttribute EOF )
            // InternalNavascript.g:1780:2: iv_ruleCheckAttribute= ruleCheckAttribute EOF
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
    // InternalNavascript.g:1786:1: ruleCheckAttribute returns [EObject current=null] : ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) ;
    public final EObject ruleCheckAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_value_4_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1792:2: ( ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) )
            // InternalNavascript.g:1793:2: ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            {
            // InternalNavascript.g:1793:2: ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            else if ( (LA31_0==45) ) {
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
                    // InternalNavascript.g:1794:3: ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    {
                    // InternalNavascript.g:1794:3: ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    // InternalNavascript.g:1795:4: () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1795:4: ()
                    // InternalNavascript.g:1796:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCheckAttributeAccess().getCheckAttributeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1805:4: (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1806:5: otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getCheckAttributeAccess().getCodeKeyword_0_1_0());
                      				
                    }
                    // InternalNavascript.g:1810:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==35) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==36) ) {
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
                            // InternalNavascript.g:1811:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_0_1_1_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1816:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getCheckAttributeAccess().getColonKeyword_0_1_1_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1821:5: ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1822:6: (lv_value_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1822:6: (lv_value_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1823:7: lv_value_4_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1843:3: (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1843:3: (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1844:4: otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getCheckAttributeAccess().getDescriptionKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1848:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==35) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==36) ) {
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
                            // InternalNavascript.g:1849:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1854:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getCheckAttributeAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1859:4: ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1860:5: (lv_value_8_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1860:5: (lv_value_8_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1861:6: lv_value_8_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:1883:1: entryRuleLiteralOrExpression returns [EObject current=null] : iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF ;
    public final EObject entryRuleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrExpression = null;


        try {
            // InternalNavascript.g:1883:60: (iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF )
            // InternalNavascript.g:1884:2: iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF
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
    // InternalNavascript.g:1890:1: ruleLiteralOrExpression returns [EObject current=null] : ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_1=null;
        Token lv_literal_1_2=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1896:2: ( ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalNavascript.g:1897:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalNavascript.g:1897:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_QUOTED_IDENTIFIER && LA33_0<=RULE_STRING_CONSTANT)) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_IDENTIFIER||(LA33_0>=RULE_MAPPABLE_IDENTIFIER && LA33_0<=RULE_EXISTS)||LA33_0==31||LA33_0==86||(LA33_0>=89 && LA33_0<=90)) ) {
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
                    // InternalNavascript.g:1898:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    {
                    // InternalNavascript.g:1898:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    // InternalNavascript.g:1899:4: () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    {
                    // InternalNavascript.g:1899:4: ()
                    // InternalNavascript.g:1900:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralOrExpressionAccess().getLiteralOrExpressionAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:1909:4: ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    // InternalNavascript.g:1910:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    {
                    // InternalNavascript.g:1910:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    // InternalNavascript.g:1911:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    {
                    // InternalNavascript.g:1911:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==RULE_QUOTED_IDENTIFIER) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==RULE_STRING_CONSTANT) ) {
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
                            // InternalNavascript.g:1912:7: lv_literal_1_1= RULE_QUOTED_IDENTIFIER
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
                            // InternalNavascript.g:1927:7: lv_literal_1_2= RULE_STRING_CONSTANT
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
                    // InternalNavascript.g:1946:3: ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // InternalNavascript.g:1946:3: ( (lv_expression_2_0= ruleExpression ) )
                    // InternalNavascript.g:1947:4: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1947:4: (lv_expression_2_0= ruleExpression )
                    // InternalNavascript.g:1948:5: lv_expression_2_0= ruleExpression
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
    // InternalNavascript.g:1969:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalNavascript.g:1969:46: (iv_rulePrint= rulePrint EOF )
            // InternalNavascript.g:1970:2: iv_rulePrint= rulePrint EOF
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
    // InternalNavascript.g:1976:1: rulePrint returns [EObject current=null] : ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1982:2: ( ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:1983:2: ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:1983:2: ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:1984:3: () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:1984:3: ()
            // InternalNavascript.g:1985:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrintAccess().getPrintAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrintAccess().getPrintKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPrintAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:2002:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:2003:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:2003:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:2004:5: lv_expression_3_0= ruleExpression
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

            otherlv_4=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPrintAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2033:1: entryRuleLog returns [EObject current=null] : iv_ruleLog= ruleLog EOF ;
    public final EObject entryRuleLog() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLog = null;


        try {
            // InternalNavascript.g:2033:44: (iv_ruleLog= ruleLog EOF )
            // InternalNavascript.g:2034:2: iv_ruleLog= ruleLog EOF
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
    // InternalNavascript.g:2040:1: ruleLog returns [EObject current=null] : ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject ruleLog() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2046:2: ( ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:2047:2: ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:2047:2: ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:2048:3: () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:2048:3: ()
            // InternalNavascript.g:2049:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLogAccess().getLogAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,51,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLogAccess().getLogKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLogAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:2066:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:2067:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:2067:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:2068:5: lv_expression_3_0= ruleExpression
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

            otherlv_4=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLogAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2097:1: entryRuleFinally returns [EObject current=null] : iv_ruleFinally= ruleFinally EOF ;
    public final EObject entryRuleFinally() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinally = null;


        try {
            // InternalNavascript.g:2097:48: (iv_ruleFinally= ruleFinally EOF )
            // InternalNavascript.g:2098:2: iv_ruleFinally= ruleFinally EOF
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
    // InternalNavascript.g:2104:1: ruleFinally returns [EObject current=null] : ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) ;
    public final EObject ruleFinally() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_finallyStatements_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2110:2: ( ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) )
            // InternalNavascript.g:2111:2: ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            {
            // InternalNavascript.g:2111:2: ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            // InternalNavascript.g:2112:3: () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}'
            {
            // InternalNavascript.g:2112:3: ()
            // InternalNavascript.g:2113:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFinallyAccess().getFinallyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFinallyAccess().getFinallyKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,28,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFinallyAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2130:3: ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:2131:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:2131:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            // InternalNavascript.g:2132:5: lv_finallyStatements_3_0= ruleTopLevelStatements
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

            otherlv_4=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2157:1: entryRuleMethods returns [EObject current=null] : iv_ruleMethods= ruleMethods EOF ;
    public final EObject entryRuleMethods() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethods = null;


        try {
            // InternalNavascript.g:2157:48: (iv_ruleMethods= ruleMethods EOF )
            // InternalNavascript.g:2158:2: iv_ruleMethods= ruleMethods EOF
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
    // InternalNavascript.g:2164:1: ruleMethods returns [EObject current=null] : ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleMethods() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2170:2: ( ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:2171:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:2171:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // InternalNavascript.g:2172:3: () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:2172:3: ()
            // InternalNavascript.g:2173:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodsAccess().getMethodsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,53,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMethodsAccess().getMethodsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,28,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMethodsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2190:3: ( (lv_methods_3_0= ruleMethod ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_QUOTED_IDENTIFIER) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalNavascript.g:2191:4: (lv_methods_3_0= ruleMethod )
            	    {
            	    // InternalNavascript.g:2191:4: (lv_methods_3_0= ruleMethod )
            	    // InternalNavascript.g:2192:5: lv_methods_3_0= ruleMethod
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
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2217:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalNavascript.g:2217:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalNavascript.g:2218:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalNavascript.g:2224:1: ruleMethod returns [EObject current=null] : ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token lv_methodName_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:2230:2: ( ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) )
            // InternalNavascript.g:2231:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            {
            // InternalNavascript.g:2231:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            // InternalNavascript.g:2232:3: () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';'
            {
            // InternalNavascript.g:2232:3: ()
            // InternalNavascript.g:2233:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodAccess().getMethodAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2242:3: ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2243:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2243:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2244:5: lv_methodName_1_0= RULE_QUOTED_IDENTIFIER
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

            otherlv_2=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2268:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalNavascript.g:2268:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalNavascript.g:2269:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalNavascript.g:2275:1: ruleLoop returns [EObject current=null] : ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_mappable_2_0 = null;

        EObject lv_tml_3_0 = null;

        EObject lv_filter_8_0 = null;

        EObject lv_statements_11_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2281:2: ( ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) )
            // InternalNavascript.g:2282:2: ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            {
            // InternalNavascript.g:2282:2: ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            // InternalNavascript.g:2283:3: () otherlv_1= 'loop' ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}'
            {
            // InternalNavascript.g:2283:3: ()
            // InternalNavascript.g:2284:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLoopAccess().getLoopAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,54,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLoopKeyword_1());
              		
            }
            // InternalNavascript.g:2297:3: ( ( (lv_mappable_2_0= ruleMappableIdentifier ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_TML_LITERAL) ) {
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
                    // InternalNavascript.g:2298:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:2298:4: ( (lv_mappable_2_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:2299:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:2299:5: (lv_mappable_2_0= ruleMappableIdentifier )
                    // InternalNavascript.g:2300:6: lv_mappable_2_0= ruleMappableIdentifier
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
                    // InternalNavascript.g:2318:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:2318:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:2319:5: (lv_tml_3_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:2319:5: (lv_tml_3_0= ruleTmlIdentifier )
                    // InternalNavascript.g:2320:6: lv_tml_3_0= ruleTmlIdentifier
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

            // InternalNavascript.g:2338:3: (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==31) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalNavascript.g:2339:4: otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    otherlv_5=(Token)match(input,55,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getFilterKeyword_3_1());
                      			
                    }
                    // InternalNavascript.g:2347:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==35) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==36) ) {
                        alt36=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalNavascript.g:2348:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getEqualsSignKeyword_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2353:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getColonKeyword_3_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:2358:4: ( (lv_filter_8_0= ruleExpression ) )
                    // InternalNavascript.g:2359:5: (lv_filter_8_0= ruleExpression )
                    {
                    // InternalNavascript.g:2359:5: (lv_filter_8_0= ruleExpression )
                    // InternalNavascript.g:2360:6: lv_filter_8_0= ruleExpression
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

                    otherlv_9=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getRightParenthesisKeyword_3_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:2386:3: ( (lv_statements_11_0= ruleInnerBody ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_METHOD_IDENTIFIER && LA38_0<=RULE_MAPPABLE_IDENTIFIER)||LA38_0==26||LA38_0==28||LA38_0==42||LA38_0==48||(LA38_0>=50 && LA38_0<=51)||(LA38_0>=53 && LA38_0<=54)||(LA38_0>=56 && LA38_0<=58)||(LA38_0>=63 && LA38_0<=64)||(LA38_0>=66 && LA38_0<=68)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalNavascript.g:2387:4: (lv_statements_11_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2387:4: (lv_statements_11_0= ruleInnerBody )
            	    // InternalNavascript.g:2388:5: lv_statements_11_0= ruleInnerBody
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
            	    break loop38;
                }
            } while (true);

            otherlv_12=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2413:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalNavascript.g:2413:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalNavascript.g:2414:2: iv_ruleInclude= ruleInclude EOF
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
    // InternalNavascript.g:2420:1: ruleInclude returns [EObject current=null] : ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_scriptName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2426:2: ( ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2427:2: ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2427:2: ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2428:3: () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2428:3: ()
            // InternalNavascript.g:2429:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIncludeAccess().getIncludeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIncludeAccess().getIncludeKeyword_1());
              		
            }
            // InternalNavascript.g:2442:3: ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2443:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2443:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2444:5: lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER
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

            otherlv_3=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2468:1: entryRuleAntiMessage returns [EObject current=null] : iv_ruleAntiMessage= ruleAntiMessage EOF ;
    public final EObject entryRuleAntiMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntiMessage = null;


        try {
            // InternalNavascript.g:2468:52: (iv_ruleAntiMessage= ruleAntiMessage EOF )
            // InternalNavascript.g:2469:2: iv_ruleAntiMessage= ruleAntiMessage EOF
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
    // InternalNavascript.g:2475:1: ruleAntiMessage returns [EObject current=null] : ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleAntiMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_messageName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2481:2: ( ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2482:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2482:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2483:3: () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2483:3: ()
            // InternalNavascript.g:2484:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAntiMessageAccess().getAntiMessageAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAntiMessageAccess().getAntimessageKeyword_1());
              		
            }
            // InternalNavascript.g:2497:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2498:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2498:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2499:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
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

            otherlv_3=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2523:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalNavascript.g:2523:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalNavascript.g:2524:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalNavascript.g:2530:1: ruleMessage returns [EObject current=null] : ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_messageName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
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
            // InternalNavascript.g:2536:2: ( ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) ) )
            // InternalNavascript.g:2537:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) )
            {
            // InternalNavascript.g:2537:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) )
            // InternalNavascript.g:2538:3: () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) )
            {
            // InternalNavascript.g:2538:3: ()
            // InternalNavascript.g:2539:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageAccess().getMessageAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
              		
            }
            // InternalNavascript.g:2552:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2553:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2553:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2554:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
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

            // InternalNavascript.g:2570:3: (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalNavascript.g:2571:4: otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,31,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalNavascript.g:2575:4: ( (lv_arguments_4_0= ruleMessageArguments ) )
                    // InternalNavascript.g:2576:5: (lv_arguments_4_0= ruleMessageArguments )
                    {
                    // InternalNavascript.g:2576:5: (lv_arguments_4_0= ruleMessageArguments )
                    // InternalNavascript.g:2577:6: lv_arguments_4_0= ruleMessageArguments
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

                    otherlv_5=(Token)match(input,32,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:2599:3: ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt43=1;
                }
                break;
            case 43:
                {
                alt43=2;
                }
                break;
            case 59:
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
                    // InternalNavascript.g:2600:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    {
                    // InternalNavascript.g:2600:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    // InternalNavascript.g:2601:5: otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_4_0_0());
                      				
                    }
                    // InternalNavascript.g:2605:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )
                    int alt41=3;
                    alt41 = dfa41.predict(input);
                    switch (alt41) {
                        case 1 :
                            // InternalNavascript.g:2606:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            {
                            // InternalNavascript.g:2606:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( ((LA40_0>=RULE_METHOD_IDENTIFIER && LA40_0<=RULE_MAPPABLE_IDENTIFIER)||LA40_0==26||LA40_0==28||LA40_0==42||LA40_0==48||(LA40_0>=50 && LA40_0<=51)||(LA40_0>=53 && LA40_0<=54)||(LA40_0>=56 && LA40_0<=58)||(LA40_0>=63 && LA40_0<=64)||(LA40_0>=66 && LA40_0<=68)) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // InternalNavascript.g:2607:7: (lv_statements_7_0= ruleInnerBody )
                            	    {
                            	    // InternalNavascript.g:2607:7: (lv_statements_7_0= ruleInnerBody )
                            	    // InternalNavascript.g:2608:8: lv_statements_7_0= ruleInnerBody
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
                            	    break loop40;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2626:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            {
                            // InternalNavascript.g:2626:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            // InternalNavascript.g:2627:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            {
                            // InternalNavascript.g:2627:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            // InternalNavascript.g:2628:8: lv_arrayField_8_0= ruleMappedArrayField
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
                            // InternalNavascript.g:2646:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            {
                            // InternalNavascript.g:2646:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            // InternalNavascript.g:2647:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            {
                            // InternalNavascript.g:2647:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            // InternalNavascript.g:2648:8: lv_arrayMessage_9_0= ruleMappedArrayMessage
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

                    otherlv_10=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2672:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getMessageAccess().getSemicolonKeyword_4_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:2677:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' )
                    {
                    // InternalNavascript.g:2677:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' )
                    // InternalNavascript.g:2678:5: otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']'
                    {
                    otherlv_12=(Token)match(input,59,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_12, grammarAccess.getMessageAccess().getLeftSquareBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:2682:5: ( (lv_messageArray_13_0= ruleMessageArray ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==28) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalNavascript.g:2683:6: (lv_messageArray_13_0= ruleMessageArray )
                            {
                            // InternalNavascript.g:2683:6: (lv_messageArray_13_0= ruleMessageArray )
                            // InternalNavascript.g:2684:7: lv_messageArray_13_0= ruleMessageArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMessageAccess().getMessageArrayMessageArrayParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_39);
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
                            break;

                    }

                    otherlv_14=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2711:1: entryRuleMessageArray returns [EObject current=null] : iv_ruleMessageArray= ruleMessageArray EOF ;
    public final EObject entryRuleMessageArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArray = null;


        try {
            // InternalNavascript.g:2711:53: (iv_ruleMessageArray= ruleMessageArray EOF )
            // InternalNavascript.g:2712:2: iv_ruleMessageArray= ruleMessageArray EOF
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
    // InternalNavascript.g:2718:1: ruleMessageArray returns [EObject current=null] : ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) ;
    public final EObject ruleMessageArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayMessageElements_0_0 = null;

        EObject lv_arrayMessageElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2724:2: ( ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) )
            // InternalNavascript.g:2725:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            {
            // InternalNavascript.g:2725:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            // InternalNavascript.g:2726:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            {
            // InternalNavascript.g:2726:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) )
            // InternalNavascript.g:2727:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            {
            // InternalNavascript.g:2727:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            // InternalNavascript.g:2728:5: lv_arrayMessageElements_0_0= ruleMessageArrayElement
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

            // InternalNavascript.g:2745:3: (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==33) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalNavascript.g:2746:4: otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2750:4: ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    // InternalNavascript.g:2751:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    {
            	    // InternalNavascript.g:2751:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    // InternalNavascript.g:2752:6: lv_arrayMessageElements_2_0= ruleMessageArrayElement
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
            	    break loop44;
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
    // InternalNavascript.g:2774:1: entryRuleMessageArrayElement returns [EObject current=null] : iv_ruleMessageArrayElement= ruleMessageArrayElement EOF ;
    public final EObject entryRuleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArrayElement = null;


        try {
            // InternalNavascript.g:2774:60: (iv_ruleMessageArrayElement= ruleMessageArrayElement EOF )
            // InternalNavascript.g:2775:2: iv_ruleMessageArrayElement= ruleMessageArrayElement EOF
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
    // InternalNavascript.g:2781:1: ruleMessageArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2787:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:2788:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:2788:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:2789:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:2789:3: ()
            // InternalNavascript.g:2790:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMessageArrayElementAccess().getMessageArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:2803:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_METHOD_IDENTIFIER && LA45_0<=RULE_MAPPABLE_IDENTIFIER)||LA45_0==26||LA45_0==28||LA45_0==42||LA45_0==48||(LA45_0>=50 && LA45_0<=51)||(LA45_0>=53 && LA45_0<=54)||(LA45_0>=56 && LA45_0<=58)||(LA45_0>=63 && LA45_0<=64)||(LA45_0>=66 && LA45_0<=68)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalNavascript.g:2804:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2804:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:2805:5: lv_statements_2_0= ruleInnerBody
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
            	    break loop45;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2830:1: entryRuleMessageArgument returns [EObject current=null] : iv_ruleMessageArgument= ruleMessageArgument EOF ;
    public final EObject entryRuleMessageArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArgument = null;


        try {
            // InternalNavascript.g:2830:56: (iv_ruleMessageArgument= ruleMessageArgument EOF )
            // InternalNavascript.g:2831:2: iv_ruleMessageArgument= ruleMessageArgument EOF
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
    // InternalNavascript.g:2837:1: ruleMessageArgument returns [EObject current=null] : ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) ;
    public final EObject ruleMessageArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject this_MessageType_3 = null;

        EObject this_MessageMode_7 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2843:2: ( ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) )
            // InternalNavascript.g:2844:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            {
            // InternalNavascript.g:2844:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==61) ) {
                alt48=1;
            }
            else if ( (LA48_0==62) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalNavascript.g:2845:3: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    {
                    // InternalNavascript.g:2845:3: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    // InternalNavascript.g:2846:4: otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType
                    {
                    otherlv_0=(Token)match(input,61,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getMessageArgumentAccess().getTypeKeyword_0_0());
                      			
                    }
                    // InternalNavascript.g:2850:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==35) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==36) ) {
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
                            // InternalNavascript.g:2851:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,35,FOLLOW_40); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2856:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,36,FOLLOW_40); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getMessageArgumentAccess().getColonKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				/* */
                      			
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
                    // InternalNavascript.g:2874:3: (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    {
                    // InternalNavascript.g:2874:3: (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    // InternalNavascript.g:2875:4: otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode
                    {
                    otherlv_4=(Token)match(input,62,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getMessageArgumentAccess().getModeKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:2879:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==35) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==36) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalNavascript.g:2880:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,35,FOLLOW_41); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2885:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,36,FOLLOW_41); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getMessageArgumentAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				/* */
                      			
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
    // InternalNavascript.g:2906:1: entryRuleMessageArguments returns [EObject current=null] : iv_ruleMessageArguments= ruleMessageArguments EOF ;
    public final EObject entryRuleMessageArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArguments = null;


        try {
            // InternalNavascript.g:2906:57: (iv_ruleMessageArguments= ruleMessageArguments EOF )
            // InternalNavascript.g:2907:2: iv_ruleMessageArguments= ruleMessageArguments EOF
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
    // InternalNavascript.g:2913:1: ruleMessageArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) ;
    public final EObject ruleMessageArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2919:2: ( ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) )
            // InternalNavascript.g:2920:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            {
            // InternalNavascript.g:2920:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            // InternalNavascript.g:2921:3: ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            {
            // InternalNavascript.g:2921:3: ( (lv_arguments_0_0= ruleMessageArgument ) )
            // InternalNavascript.g:2922:4: (lv_arguments_0_0= ruleMessageArgument )
            {
            // InternalNavascript.g:2922:4: (lv_arguments_0_0= ruleMessageArgument )
            // InternalNavascript.g:2923:5: lv_arguments_0_0= ruleMessageArgument
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

            // InternalNavascript.g:2940:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==33) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalNavascript.g:2941:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2945:4: ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    // InternalNavascript.g:2946:5: (lv_arguments_2_0= ruleMessageArgument )
            	    {
            	    // InternalNavascript.g:2946:5: (lv_arguments_2_0= ruleMessageArgument )
            	    // InternalNavascript.g:2947:6: lv_arguments_2_0= ruleMessageArgument
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
            	    break loop49;
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
    // InternalNavascript.g:2969:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalNavascript.g:2969:44: (iv_ruleMap= ruleMap EOF )
            // InternalNavascript.g:2970:2: iv_ruleMap= ruleMap EOF
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
    // InternalNavascript.g:2976:1: ruleMap returns [EObject current=null] : ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_adapterName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_objectName_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_13_0 = null;

        EObject lv_statements_16_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2982:2: ( ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' ) )
            // InternalNavascript.g:2983:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' )
            {
            // InternalNavascript.g:2983:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}' )
            // InternalNavascript.g:2984:3: () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) otherlv_15= '{' ( (lv_statements_16_0= ruleInnerBody ) )* otherlv_17= '}'
            {
            // InternalNavascript.g:2984:3: ()
            // InternalNavascript.g:2985:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMapAccess().getMapAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:2994:3: ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==63) ) {
                alt54=1;
            }
            else if ( (LA54_0==64) ) {
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
                    // InternalNavascript.g:2995:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? )
                    {
                    // InternalNavascript.g:2995:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? )
                    // InternalNavascript.g:2996:5: otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )?
                    {
                    otherlv_1=(Token)match(input,63,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getMapAccess().getMapKeyword_1_0_0());
                      				
                    }
                    // InternalNavascript.g:3000:5: ( (lv_adapterName_2_0= RULE_IDENTIFIER ) )
                    // InternalNavascript.g:3001:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    {
                    // InternalNavascript.g:3001:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    // InternalNavascript.g:3002:7: lv_adapterName_2_0= RULE_IDENTIFIER
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

                    // InternalNavascript.g:3018:5: (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==31) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalNavascript.g:3019:6: otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')'
                            {
                            otherlv_3=(Token)match(input,31,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1_0_2_0());
                              					
                            }
                            // InternalNavascript.g:3023:6: ( (lv_arguments_4_0= ruleKeyValueArguments ) )?
                            int alt50=2;
                            int LA50_0 = input.LA(1);

                            if ( (LA50_0==RULE_IDENTIFIER||(LA50_0>=103 && LA50_0<=105)) ) {
                                alt50=1;
                            }
                            switch (alt50) {
                                case 1 :
                                    // InternalNavascript.g:3024:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    {
                                    // InternalNavascript.g:3024:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    // InternalNavascript.g:3025:8: lv_arguments_4_0= ruleKeyValueArguments
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

                            otherlv_5=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_5, grammarAccess.getMapAccess().getRightParenthesisKeyword_1_0_2_2());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3049:4: (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' )
                    {
                    // InternalNavascript.g:3049:4: (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' )
                    // InternalNavascript.g:3050:5: otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')'
                    {
                    otherlv_6=(Token)match(input,64,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMapAccess().getMapKeyword_1_1_0());
                      				
                    }
                    otherlv_7=(Token)match(input,31,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1_1_1());
                      				
                    }
                    otherlv_8=(Token)match(input,65,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getMapAccess().getObjectKeyword_1_1_2());
                      				
                    }
                    // InternalNavascript.g:3062:5: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==35) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==36) ) {
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
                            // InternalNavascript.g:3063:6: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,35,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_9, grammarAccess.getMapAccess().getEqualsSignKeyword_1_1_3_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3068:6: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,36,FOLLOW_45); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getMapAccess().getColonKeyword_1_1_3_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3073:5: ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) )
                    // InternalNavascript.g:3074:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    {
                    // InternalNavascript.g:3074:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    // InternalNavascript.g:3075:7: lv_objectName_11_0= RULE_OBJECT_IDENTIFIER
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

                    // InternalNavascript.g:3091:5: (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==33) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalNavascript.g:3092:6: otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            {
                            otherlv_12=(Token)match(input,33,FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_12, grammarAccess.getMapAccess().getCommaKeyword_1_1_5_0());
                              					
                            }
                            // InternalNavascript.g:3096:6: ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3097:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3097:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3098:8: lv_arguments_13_0= ruleKeyValueArguments
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

                    otherlv_14=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getMapAccess().getRightParenthesisKeyword_1_1_6());
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_15, grammarAccess.getMapAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:3126:3: ( (lv_statements_16_0= ruleInnerBody ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_METHOD_IDENTIFIER && LA55_0<=RULE_MAPPABLE_IDENTIFIER)||LA55_0==26||LA55_0==28||LA55_0==42||LA55_0==48||(LA55_0>=50 && LA55_0<=51)||(LA55_0>=53 && LA55_0<=54)||(LA55_0>=56 && LA55_0<=58)||(LA55_0>=63 && LA55_0<=64)||(LA55_0>=66 && LA55_0<=68)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalNavascript.g:3127:4: (lv_statements_16_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3127:4: (lv_statements_16_0= ruleInnerBody )
            	    // InternalNavascript.g:3128:5: lv_statements_16_0= ruleInnerBody
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
            	    break loop55;
                }
            } while (true);

            otherlv_17=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3153:1: entryRuleMethodOrSetter returns [EObject current=null] : iv_ruleMethodOrSetter= ruleMethodOrSetter EOF ;
    public final EObject entryRuleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodOrSetter = null;


        try {
            // InternalNavascript.g:3153:55: (iv_ruleMethodOrSetter= ruleMethodOrSetter EOF )
            // InternalNavascript.g:3154:2: iv_ruleMethodOrSetter= ruleMethodOrSetter EOF
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
    // InternalNavascript.g:3160:1: ruleMethodOrSetter returns [EObject current=null] : (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) ;
    public final EObject ruleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject this_AdapterMethod_0 = null;

        EObject this_SetterField_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3166:2: ( (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) )
            // InternalNavascript.g:3167:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            {
            // InternalNavascript.g:3167:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_METHOD_IDENTIFIER) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_MAPPABLE_IDENTIFIER) ) {
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
                    // InternalNavascript.g:3168:3: this_AdapterMethod_0= ruleAdapterMethod
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:3180:3: this_SetterField_1= ruleSetterField
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
    // InternalNavascript.g:3195:1: entryRuleAdapterMethod returns [EObject current=null] : iv_ruleAdapterMethod= ruleAdapterMethod EOF ;
    public final EObject entryRuleAdapterMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdapterMethod = null;


        try {
            // InternalNavascript.g:3195:54: (iv_ruleAdapterMethod= ruleAdapterMethod EOF )
            // InternalNavascript.g:3196:2: iv_ruleAdapterMethod= ruleAdapterMethod EOF
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
    // InternalNavascript.g:3202:1: ruleAdapterMethod returns [EObject current=null] : ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject ruleAdapterMethod() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_arguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3208:2: ( ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:3209:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:3209:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:3210:3: () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:3210:3: ()
            // InternalNavascript.g:3211:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAdapterMethodAccess().getAdapterMethodAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3220:3: ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) )
            // InternalNavascript.g:3221:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            {
            // InternalNavascript.g:3221:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            // InternalNavascript.g:3222:5: lv_method_1_0= RULE_METHOD_IDENTIFIER
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

            otherlv_2=(Token)match(input,31,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAdapterMethodAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:3242:3: ( (lv_arguments_3_0= ruleKeyValueArguments ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_IDENTIFIER||(LA57_0>=103 && LA57_0<=105)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalNavascript.g:3243:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    {
                    // InternalNavascript.g:3243:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    // InternalNavascript.g:3244:5: lv_arguments_3_0= ruleKeyValueArguments
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

            otherlv_4=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getAdapterMethodAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3273:1: entryRuleSetterField returns [EObject current=null] : iv_ruleSetterField= ruleSetterField EOF ;
    public final EObject entryRuleSetterField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetterField = null;


        try {
            // InternalNavascript.g:3273:52: (iv_ruleSetterField= ruleSetterField EOF )
            // InternalNavascript.g:3274:2: iv_ruleSetterField= ruleSetterField EOF
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
    // InternalNavascript.g:3280:1: ruleSetterField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) ) ;
    public final EObject ruleSetterField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_expressionList_4_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_mappedArray_10_0 = null;

        EObject lv_mappedField_12_0 = null;

        EObject lv_mappedMessage_13_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3286:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) ) )
            // InternalNavascript.g:3287:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) )
            {
            // InternalNavascript.g:3287:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) )
            // InternalNavascript.g:3288:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) )
            {
            // InternalNavascript.g:3288:3: ()
            // InternalNavascript.g:3289:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetterFieldAccess().getSetterFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3298:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3299:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3299:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3300:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_47); if (state.failed) return current;
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

            // InternalNavascript.g:3316:3: ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 35:
            case 36:
                {
                alt60=1;
                }
                break;
            case 31:
                {
                alt60=2;
                }
                break;
            case 28:
                {
                int LA60_3 = input.LA(2);

                if ( (LA60_3==RULE_TML_LITERAL) ) {
                    alt60=2;
                }
                else if ( ((LA60_3>=RULE_METHOD_IDENTIFIER && LA60_3<=RULE_MAPPABLE_IDENTIFIER)||LA60_3==26||(LA60_3>=28 && LA60_3<=29)||LA60_3==42||LA60_3==48||(LA60_3>=50 && LA60_3<=51)||(LA60_3>=53 && LA60_3<=54)||(LA60_3>=56 && LA60_3<=58)||(LA60_3>=63 && LA60_3<=64)||(LA60_3>=66 && LA60_3<=68)) ) {
                    alt60=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalNavascript.g:3317:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    {
                    // InternalNavascript.g:3317:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    // InternalNavascript.g:3318:5: (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
                    {
                    // InternalNavascript.g:3318:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==35) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==36) ) {
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
                            // InternalNavascript.g:3319:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,35,FOLLOW_48); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getSetterFieldAccess().getEqualsSignKeyword_2_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3324:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,36,FOLLOW_48); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getSetterFieldAccess().getColonKeyword_2_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3329:5: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3330:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3330:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3331:7: lv_expressionList_4_0= ruleConditionalExpressions
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

                    otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getSetterFieldAccess().getSemicolonKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3354:4: ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    {
                    // InternalNavascript.g:3354:4: ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    // InternalNavascript.g:3355:5: (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}'
                    {
                    // InternalNavascript.g:3355:5: (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==31) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalNavascript.g:3356:6: otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')'
                            {
                            otherlv_6=(Token)match(input,31,FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_6, grammarAccess.getSetterFieldAccess().getLeftParenthesisKeyword_2_1_0_0());
                              					
                            }
                            // InternalNavascript.g:3360:6: ( (lv_arguments_7_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3361:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3361:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3362:8: lv_arguments_7_0= ruleKeyValueArguments
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

                            otherlv_8=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_8, grammarAccess.getSetterFieldAccess().getRightParenthesisKeyword_2_1_0_2());
                              					
                            }

                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,28,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getSetterFieldAccess().getLeftCurlyBracketKeyword_2_1_1());
                      				
                    }
                    // InternalNavascript.g:3388:5: ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3389:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3389:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3390:7: lv_mappedArray_10_0= ruleMappedArrayMessage
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

                    otherlv_11=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getSetterFieldAccess().getRightCurlyBracketKeyword_2_1_3());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3413:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    {
                    // InternalNavascript.g:3413:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3414:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3414:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:3415:6: lv_mappedField_12_0= ruleMappedArrayField
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
                case 4 :
                    // InternalNavascript.g:3433:4: ( (lv_mappedMessage_13_0= ruleMappedMessage ) )
                    {
                    // InternalNavascript.g:3433:4: ( (lv_mappedMessage_13_0= ruleMappedMessage ) )
                    // InternalNavascript.g:3434:5: (lv_mappedMessage_13_0= ruleMappedMessage )
                    {
                    // InternalNavascript.g:3434:5: (lv_mappedMessage_13_0= ruleMappedMessage )
                    // InternalNavascript.g:3435:6: lv_mappedMessage_13_0= ruleMappedMessage
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedMessageMappedMessageParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_mappedMessage_13_0=ruleMappedMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSetterFieldRule());
                      						}
                      						set(
                      							current,
                      							"mappedMessage",
                      							lv_mappedMessage_13_0,
                      							"com.dexels.navajo.Navascript.MappedMessage");
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


    // $ANTLR start "entryRuleMappedMessage"
    // InternalNavascript.g:3457:1: entryRuleMappedMessage returns [EObject current=null] : iv_ruleMappedMessage= ruleMappedMessage EOF ;
    public final EObject entryRuleMappedMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedMessage = null;


        try {
            // InternalNavascript.g:3457:54: (iv_ruleMappedMessage= ruleMappedMessage EOF )
            // InternalNavascript.g:3458:2: iv_ruleMappedMessage= ruleMappedMessage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappedMessageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMappedMessage=ruleMappedMessage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMappedMessage; 
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
    // $ANTLR end "entryRuleMappedMessage"


    // $ANTLR start "ruleMappedMessage"
    // InternalNavascript.g:3464:1: ruleMappedMessage returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleMappedMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3470:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:3471:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:3471:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:3472:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:3472:3: ()
            // InternalNavascript.g:3473:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedMessageAccess().getMappedMessageAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMappedMessageAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:3486:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=RULE_METHOD_IDENTIFIER && LA61_0<=RULE_MAPPABLE_IDENTIFIER)||LA61_0==26||LA61_0==28||LA61_0==42||LA61_0==48||(LA61_0>=50 && LA61_0<=51)||(LA61_0>=53 && LA61_0<=54)||(LA61_0>=56 && LA61_0<=58)||(LA61_0>=63 && LA61_0<=64)||(LA61_0>=66 && LA61_0<=68)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalNavascript.g:3487:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3487:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:3488:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedMessageAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_statements_2_0=ruleInnerBody();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getMappedMessageRule());
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
            	    break loop61;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getMappedMessageAccess().getRightCurlyBracketKeyword_3());
              		
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
    // $ANTLR end "ruleMappedMessage"


    // $ANTLR start "entryRuleMappedArrayField"
    // InternalNavascript.g:3513:1: entryRuleMappedArrayField returns [EObject current=null] : iv_ruleMappedArrayField= ruleMappedArrayField EOF ;
    public final EObject entryRuleMappedArrayField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayField = null;


        try {
            // InternalNavascript.g:3513:57: (iv_ruleMappedArrayField= ruleMappedArrayField EOF )
            // InternalNavascript.g:3514:2: iv_ruleMappedArrayField= ruleMappedArrayField EOF
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
    // InternalNavascript.g:3520:1: ruleMappedArrayField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
    public final EObject ruleMappedArrayField() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_filter_6_0 = null;

        EObject lv_statements_9_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3526:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3527:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3527:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3528:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3528:3: ()
            // InternalNavascript.g:3529:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayFieldAccess().getMappedArrayFieldAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3538:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3539:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3539:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3540:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
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

            // InternalNavascript.g:3556:3: (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==31) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalNavascript.g:3557:4: otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappedArrayFieldAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,55,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMappedArrayFieldAccess().getFilterKeyword_2_1());
                      			
                    }
                    // InternalNavascript.g:3565:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==35) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==36) ) {
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
                            // InternalNavascript.g:3566:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayFieldAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3571:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayFieldAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3576:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3577:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3577:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3578:6: lv_filter_6_0= ruleExpression
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

                    otherlv_7=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getMappedArrayFieldAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayFieldAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3604:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_METHOD_IDENTIFIER && LA64_0<=RULE_MAPPABLE_IDENTIFIER)||LA64_0==26||LA64_0==28||LA64_0==42||LA64_0==48||(LA64_0>=50 && LA64_0<=51)||(LA64_0>=53 && LA64_0<=54)||(LA64_0>=56 && LA64_0<=58)||(LA64_0>=63 && LA64_0<=64)||(LA64_0>=66 && LA64_0<=68)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalNavascript.g:3605:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3605:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3606:5: lv_statements_9_0= ruleInnerBody
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
            	    break loop64;
                }
            } while (true);

            otherlv_10=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3631:1: entryRuleMappedArrayMessage returns [EObject current=null] : iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF ;
    public final EObject entryRuleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayMessage = null;


        try {
            // InternalNavascript.g:3631:59: (iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF )
            // InternalNavascript.g:3632:2: iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF
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
    // InternalNavascript.g:3638:1: ruleMappedArrayMessage returns [EObject current=null] : ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
    public final EObject ruleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_filter_6_0 = null;

        EObject lv_statements_9_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3644:2: ( ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3645:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3645:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3646:3: () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3646:3: ()
            // InternalNavascript.g:3647:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappedArrayMessageAccess().getMappedArrayMessageAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3656:3: ( (lv_message_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:3657:4: (lv_message_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:3657:4: (lv_message_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:3658:5: lv_message_1_0= RULE_TML_LITERAL
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

            // InternalNavascript.g:3674:3: (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==31) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalNavascript.g:3675:4: otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappedArrayMessageAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,55,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMappedArrayMessageAccess().getFilterKeyword_2_1());
                      			
                    }
                    // InternalNavascript.g:3683:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==35) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==36) ) {
                        alt65=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 0, input);

                        throw nvae;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalNavascript.g:3684:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayMessageAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3689:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,36,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayMessageAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3694:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3695:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3695:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3696:6: lv_filter_6_0= ruleExpression
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

                    otherlv_7=(Token)match(input,32,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getMappedArrayMessageAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayMessageAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3722:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( ((LA67_0>=RULE_METHOD_IDENTIFIER && LA67_0<=RULE_MAPPABLE_IDENTIFIER)||LA67_0==26||LA67_0==28||LA67_0==42||LA67_0==48||(LA67_0>=50 && LA67_0<=51)||(LA67_0>=53 && LA67_0<=54)||(LA67_0>=56 && LA67_0<=58)||(LA67_0>=63 && LA67_0<=64)||(LA67_0>=66 && LA67_0<=68)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalNavascript.g:3723:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3723:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3724:5: lv_statements_9_0= ruleInnerBody
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
            	    break loop67;
                }
            } while (true);

            otherlv_10=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3749:1: entryRuleKeyValueArguments returns [EObject current=null] : iv_ruleKeyValueArguments= ruleKeyValueArguments EOF ;
    public final EObject entryRuleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArguments = null;


        try {
            // InternalNavascript.g:3749:58: (iv_ruleKeyValueArguments= ruleKeyValueArguments EOF )
            // InternalNavascript.g:3750:2: iv_ruleKeyValueArguments= ruleKeyValueArguments EOF
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
    // InternalNavascript.g:3756:1: ruleKeyValueArguments returns [EObject current=null] : ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) ;
    public final EObject ruleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_keyValueArguments_1_0 = null;

        EObject lv_keyValueArguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3762:2: ( ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) )
            // InternalNavascript.g:3763:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            {
            // InternalNavascript.g:3763:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            // InternalNavascript.g:3764:3: () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            {
            // InternalNavascript.g:3764:3: ()
            // InternalNavascript.g:3765:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3774:3: ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) )
            // InternalNavascript.g:3775:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            {
            // InternalNavascript.g:3775:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            // InternalNavascript.g:3776:5: lv_keyValueArguments_1_0= ruleKeyValueArgument
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

            // InternalNavascript.g:3793:3: (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==33) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalNavascript.g:3794:4: otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    {
            	    otherlv_2=(Token)match(input,33,FOLLOW_46); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentsAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:3798:4: ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    // InternalNavascript.g:3799:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    {
            	    // InternalNavascript.g:3799:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    // InternalNavascript.g:3800:6: lv_keyValueArguments_3_0= ruleKeyValueArgument
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
            	    break loop68;
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
    // InternalNavascript.g:3822:1: entryRuleKeyValueArgument returns [EObject current=null] : iv_ruleKeyValueArgument= ruleKeyValueArgument EOF ;
    public final EObject entryRuleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArgument = null;


        try {
            // InternalNavascript.g:3822:57: (iv_ruleKeyValueArgument= ruleKeyValueArgument EOF )
            // InternalNavascript.g:3823:2: iv_ruleKeyValueArgument= ruleKeyValueArgument EOF
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
    // InternalNavascript.g:3829:1: ruleKeyValueArgument returns [EObject current=null] : ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_key_1_2 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3835:2: ( ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:3836:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:3836:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:3837:3: () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:3837:3: ()
            // InternalNavascript.g:3838:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyValueArgumentAccess().getKeyValueArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:3847:3: ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) )
            // InternalNavascript.g:3848:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            {
            // InternalNavascript.g:3848:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            // InternalNavascript.g:3849:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:3849:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_IDENTIFIER) ) {
                alt69=1;
            }
            else if ( ((LA69_0>=103 && LA69_0<=105)) ) {
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
                    // InternalNavascript.g:3850:6: lv_key_1_1= RULE_IDENTIFIER
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
                    // InternalNavascript.g:3865:6: lv_key_1_2= ruleOPTION_TYPE
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

            // InternalNavascript.g:3883:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==35) ) {
                alt70=1;
            }
            else if ( (LA70_0==36) ) {
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
                    // InternalNavascript.g:3884:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3889:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getKeyValueArgumentAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:3894:3: ( (lv_value_4_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:3895:4: (lv_value_4_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:3895:4: (lv_value_4_0= ruleLiteralOrExpression )
            // InternalNavascript.g:3896:5: lv_value_4_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:3917:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalNavascript.g:3917:44: (iv_ruleVar= ruleVar EOF )
            // InternalNavascript.g:3918:2: iv_ruleVar= ruleVar EOF
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
    // InternalNavascript.g:3924:1: ruleVar returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
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
            // InternalNavascript.g:3930:2: ( ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) )
            // InternalNavascript.g:3931:2: ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            {
            // InternalNavascript.g:3931:2: ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            // InternalNavascript.g:3932:3: () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            {
            // InternalNavascript.g:3932:3: ()
            // InternalNavascript.g:3933:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarAccess().getVarAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,66,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarAccess().getVarKeyword_1());
              		
            }
            // InternalNavascript.g:3946:3: ( (lv_varName_2_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:3947:4: (lv_varName_2_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:3947:4: (lv_varName_2_0= RULE_IDENTIFIER )
            // InternalNavascript.g:3948:5: lv_varName_2_0= RULE_IDENTIFIER
            {
            lv_varName_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_49); if (state.failed) return current;
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

            // InternalNavascript.g:3964:3: ( (lv_arguments_3_0= ruleVarArguments ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==31) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalNavascript.g:3965:4: (lv_arguments_3_0= ruleVarArguments )
                    {
                    // InternalNavascript.g:3965:4: (lv_arguments_3_0= ruleVarArguments )
                    // InternalNavascript.g:3966:5: lv_arguments_3_0= ruleVarArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVarAccess().getArgumentsVarArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_50);
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

            // InternalNavascript.g:3983:3: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            int alt75=5;
            switch ( input.LA(1) ) {
            case 35:
            case 36:
                {
                alt75=1;
                }
                break;
            case 59:
                {
                alt75=2;
                }
                break;
            case 28:
                {
                switch ( input.LA(2) ) {
                case RULE_TML_LITERAL:
                    {
                    alt75=5;
                    }
                    break;
                case 26:
                case 29:
                case 66:
                    {
                    alt75=3;
                    }
                    break;
                case RULE_MAPPABLE_IDENTIFIER:
                    {
                    alt75=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // InternalNavascript.g:3984:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    {
                    // InternalNavascript.g:3984:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    // InternalNavascript.g:3985:5: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';'
                    {
                    // InternalNavascript.g:3985:5: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==35) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==36) ) {
                        alt72=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalNavascript.g:3986:6: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_48); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getVarAccess().getEqualsSignKeyword_4_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3991:6: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,36,FOLLOW_48); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_5, grammarAccess.getVarAccess().getColonKeyword_4_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3996:5: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3997:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3997:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3998:7: lv_expressionList_6_0= ruleConditionalExpressions
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

                    otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getVarAccess().getSemicolonKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4021:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    {
                    // InternalNavascript.g:4021:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    // InternalNavascript.g:4022:5: otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,59,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getVarAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4026:5: ( (lv_varArray_9_0= ruleVarArray ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==28) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalNavascript.g:4027:6: (lv_varArray_9_0= ruleVarArray )
                            {
                            // InternalNavascript.g:4027:6: (lv_varArray_9_0= ruleVarArray )
                            // InternalNavascript.g:4028:7: lv_varArray_9_0= ruleVarArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVarAccess().getVarArrayVarArrayParserRuleCall_4_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_39);
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

                    otherlv_10=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getVarAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4051:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    {
                    // InternalNavascript.g:4051:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    // InternalNavascript.g:4052:5: otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,28,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4056:5: ( (lv_varElements_12_0= ruleVarElement ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==26||LA74_0==66) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalNavascript.g:4057:6: (lv_varElements_12_0= ruleVarElement )
                    	    {
                    	    // InternalNavascript.g:4057:6: (lv_varElements_12_0= ruleVarElement )
                    	    // InternalNavascript.g:4058:7: lv_varElements_12_0= ruleVarElement
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
                    	    break loop74;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4081:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:4081:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    // InternalNavascript.g:4082:5: otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4086:5: ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4087:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4087:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    // InternalNavascript.g:4088:7: lv_mappedArrayField_15_0= ruleMappedArrayField
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

                    otherlv_16=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_16, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_3_2());
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:4111:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    {
                    // InternalNavascript.g:4111:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    // InternalNavascript.g:4112:5: otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,28,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_4_0());
                      				
                    }
                    // InternalNavascript.g:4116:5: ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4117:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4117:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4118:7: lv_mappedArrayMessage_18_0= ruleMappedArrayMessage
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

                    otherlv_19=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4145:1: entryRuleVarArray returns [EObject current=null] : iv_ruleVarArray= ruleVarArray EOF ;
    public final EObject entryRuleVarArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArray = null;


        try {
            // InternalNavascript.g:4145:49: (iv_ruleVarArray= ruleVarArray EOF )
            // InternalNavascript.g:4146:2: iv_ruleVarArray= ruleVarArray EOF
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
    // InternalNavascript.g:4152:1: ruleVarArray returns [EObject current=null] : ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) ;
    public final EObject ruleVarArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_vararrayelement_1_0 = null;

        EObject lv_vararrayelement_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4158:2: ( ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) )
            // InternalNavascript.g:4159:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            {
            // InternalNavascript.g:4159:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            // InternalNavascript.g:4160:3: () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            {
            // InternalNavascript.g:4160:3: ()
            // InternalNavascript.g:4161:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayAccess().getVarArrayAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4170:3: ( (lv_vararrayelement_1_0= ruleVarArrayElement ) )
            // InternalNavascript.g:4171:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            {
            // InternalNavascript.g:4171:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            // InternalNavascript.g:4172:5: lv_vararrayelement_1_0= ruleVarArrayElement
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

            // InternalNavascript.g:4189:3: (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==33) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalNavascript.g:4190:4: otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    {
            	    otherlv_2=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getVarArrayAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:4194:4: ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    // InternalNavascript.g:4195:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    {
            	    // InternalNavascript.g:4195:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    // InternalNavascript.g:4196:6: lv_vararrayelement_3_0= ruleVarArrayElement
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
    // $ANTLR end "ruleVarArray"


    // $ANTLR start "entryRuleVarArrayElement"
    // InternalNavascript.g:4218:1: entryRuleVarArrayElement returns [EObject current=null] : iv_ruleVarArrayElement= ruleVarArrayElement EOF ;
    public final EObject entryRuleVarArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArrayElement = null;


        try {
            // InternalNavascript.g:4218:56: (iv_ruleVarArrayElement= ruleVarArrayElement EOF )
            // InternalNavascript.g:4219:2: iv_ruleVarArrayElement= ruleVarArrayElement EOF
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
    // InternalNavascript.g:4225:1: ruleVarArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleVarArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_varElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4231:2: ( ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:4232:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:4232:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            // InternalNavascript.g:4233:3: () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:4233:3: ()
            // InternalNavascript.g:4234:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArrayElementAccess().getVarArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:4247:3: ( (lv_varElements_2_0= ruleVarElement ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==26||LA77_0==66) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalNavascript.g:4248:4: (lv_varElements_2_0= ruleVarElement )
            	    {
            	    // InternalNavascript.g:4248:4: (lv_varElements_2_0= ruleVarElement )
            	    // InternalNavascript.g:4249:5: lv_varElements_2_0= ruleVarElement
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
            	    break loop77;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4274:1: entryRuleVarElement returns [EObject current=null] : iv_ruleVarElement= ruleVarElement EOF ;
    public final EObject entryRuleVarElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarElement = null;


        try {
            // InternalNavascript.g:4274:51: (iv_ruleVarElement= ruleVarElement EOF )
            // InternalNavascript.g:4275:2: iv_ruleVarElement= ruleVarElement EOF
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
    // InternalNavascript.g:4281:1: ruleVarElement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) ;
    public final EObject ruleVarElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_var_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4287:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) )
            // InternalNavascript.g:4288:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            {
            // InternalNavascript.g:4288:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            // InternalNavascript.g:4289:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) )
            {
            // InternalNavascript.g:4289:3: ()
            // InternalNavascript.g:4290:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarElementAccess().getVarElementAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4299:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==26) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalNavascript.g:4300:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVarElementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:4304:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:4305:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:4305:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:4306:6: lv_condition_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,27,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarElementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4328:3: ( (lv_var_4_0= ruleVar ) )
            // InternalNavascript.g:4329:4: (lv_var_4_0= ruleVar )
            {
            // InternalNavascript.g:4329:4: (lv_var_4_0= ruleVar )
            // InternalNavascript.g:4330:5: lv_var_4_0= ruleVar
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
    // InternalNavascript.g:4351:1: entryRuleVarArguments returns [EObject current=null] : iv_ruleVarArguments= ruleVarArguments EOF ;
    public final EObject entryRuleVarArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArguments = null;


        try {
            // InternalNavascript.g:4351:53: (iv_ruleVarArguments= ruleVarArguments EOF )
            // InternalNavascript.g:4352:2: iv_ruleVarArguments= ruleVarArguments EOF
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
    // InternalNavascript.g:4358:1: ruleVarArguments returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleVarArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_varArguments_2_0 = null;

        EObject lv_varArguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4364:2: ( ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' ) )
            // InternalNavascript.g:4365:2: ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' )
            {
            // InternalNavascript.g:4365:2: ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' )
            // InternalNavascript.g:4366:3: () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')'
            {
            // InternalNavascript.g:4366:3: ()
            // InternalNavascript.g:4367:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArgumentsAccess().getVarArgumentsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarArgumentsAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:4380:3: ( (lv_varArguments_2_0= ruleVarArgument ) )
            // InternalNavascript.g:4381:4: (lv_varArguments_2_0= ruleVarArgument )
            {
            // InternalNavascript.g:4381:4: (lv_varArguments_2_0= ruleVarArgument )
            // InternalNavascript.g:4382:5: lv_varArguments_2_0= ruleVarArgument
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

            // InternalNavascript.g:4399:3: (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==33) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalNavascript.g:4400:4: otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getVarArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4404:4: ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    // InternalNavascript.g:4405:5: (lv_varArguments_4_0= ruleVarArgument )
            	    {
            	    // InternalNavascript.g:4405:5: (lv_varArguments_4_0= ruleVarArgument )
            	    // InternalNavascript.g:4406:6: lv_varArguments_4_0= ruleVarArgument
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
            	    break loop79;
                }
            } while (true);

            otherlv_5=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getVarArgumentsAccess().getRightParenthesisKeyword_4());
              		
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
    // InternalNavascript.g:4432:1: entryRuleVarArgument returns [EObject current=null] : iv_ruleVarArgument= ruleVarArgument EOF ;
    public final EObject entryRuleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArgument = null;


        try {
            // InternalNavascript.g:4432:52: (iv_ruleVarArgument= ruleVarArgument EOF )
            // InternalNavascript.g:4433:2: iv_ruleVarArgument= ruleVarArgument EOF
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
    // InternalNavascript.g:4439:1: ruleVarArgument returns [EObject current=null] : ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) ;
    public final EObject ruleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_argument_1_1 = null;

        EObject lv_argument_1_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4445:2: ( ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) )
            // InternalNavascript.g:4446:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            {
            // InternalNavascript.g:4446:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            // InternalNavascript.g:4447:3: () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            {
            // InternalNavascript.g:4447:3: ()
            // InternalNavascript.g:4448:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarArgumentAccess().getVarArgumentAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:4457:3: ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            // InternalNavascript.g:4458:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            {
            // InternalNavascript.g:4458:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            // InternalNavascript.g:4459:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            {
            // InternalNavascript.g:4459:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==61) ) {
                alt80=1;
            }
            else if ( (LA80_0==62) ) {
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
                    // InternalNavascript.g:4460:6: lv_argument_1_1= ruleVarType
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
                    // InternalNavascript.g:4476:6: lv_argument_1_2= ruleVarMode
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
    // InternalNavascript.g:4498:1: entryRuleVarType returns [EObject current=null] : iv_ruleVarType= ruleVarType EOF ;
    public final EObject entryRuleVarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarType = null;


        try {
            // InternalNavascript.g:4498:48: (iv_ruleVarType= ruleVarType EOF )
            // InternalNavascript.g:4499:2: iv_ruleVarType= ruleVarType EOF
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
    // InternalNavascript.g:4505:1: ruleVarType returns [EObject current=null] : ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) ;
    public final EObject ruleVarType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_type_4_1 = null;

        EObject lv_type_4_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4511:2: ( ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) )
            // InternalNavascript.g:4512:2: ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            {
            // InternalNavascript.g:4512:2: ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            // InternalNavascript.g:4513:3: () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            {
            // InternalNavascript.g:4513:3: ()
            // InternalNavascript.g:4514:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarTypeAccess().getVarTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarTypeAccess().getTypeKeyword_1());
              		
            }
            // InternalNavascript.g:4527:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==35) ) {
                alt81=1;
            }
            else if ( (LA81_0==36) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalNavascript.g:4528:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarTypeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4533:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarTypeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4538:3: ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            // InternalNavascript.g:4539:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            {
            // InternalNavascript.g:4539:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            // InternalNavascript.g:4540:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            {
            // InternalNavascript.g:4540:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=106 && LA82_0<=108)) ) {
                alt82=1;
            }
            else if ( ((LA82_0>=92 && LA82_0<=102)) ) {
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
                    // InternalNavascript.g:4541:6: lv_type_4_1= ruleMessageType
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
                    // InternalNavascript.g:4557:6: lv_type_4_2= rulePropertyType
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
    // InternalNavascript.g:4579:1: entryRuleVarMode returns [EObject current=null] : iv_ruleVarMode= ruleVarMode EOF ;
    public final EObject entryRuleVarMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarMode = null;


        try {
            // InternalNavascript.g:4579:48: (iv_ruleVarMode= ruleVarMode EOF )
            // InternalNavascript.g:4580:2: iv_ruleVarMode= ruleVarMode EOF
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
    // InternalNavascript.g:4586:1: ruleVarMode returns [EObject current=null] : ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) ;
    public final EObject ruleVarMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_mode_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4592:2: ( ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) )
            // InternalNavascript.g:4593:2: ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            {
            // InternalNavascript.g:4593:2: ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            // InternalNavascript.g:4594:3: () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) )
            {
            // InternalNavascript.g:4594:3: ()
            // InternalNavascript.g:4595:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVarModeAccess().getVarModeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarModeAccess().getModeKeyword_1());
              		
            }
            // InternalNavascript.g:4608:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==35) ) {
                alt83=1;
            }
            else if ( (LA83_0==36) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // InternalNavascript.g:4609:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarModeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4614:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarModeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4619:3: ( (lv_mode_4_0= ruleMessageMode ) )
            // InternalNavascript.g:4620:4: (lv_mode_4_0= ruleMessageMode )
            {
            // InternalNavascript.g:4620:4: (lv_mode_4_0= ruleMessageMode )
            // InternalNavascript.g:4621:5: lv_mode_4_0= ruleMessageMode
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
    // InternalNavascript.g:4642:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalNavascript.g:4642:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalNavascript.g:4643:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalNavascript.g:4649:1: ruleProperty returns [EObject current=null] : ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
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
            // InternalNavascript.g:4655:2: ( ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) )
            // InternalNavascript.g:4656:2: ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            {
            // InternalNavascript.g:4656:2: ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            // InternalNavascript.g:4657:3: () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            {
            // InternalNavascript.g:4657:3: ()
            // InternalNavascript.g:4658:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyAccess().getPropertyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getPropertyKeyword_1());
              		
            }
            // InternalNavascript.g:4671:3: ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:4672:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:4672:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:4673:5: lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER
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

            // InternalNavascript.g:4689:3: ( (lv_arguments_3_0= rulePropertyArguments ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==31) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalNavascript.g:4690:4: (lv_arguments_3_0= rulePropertyArguments )
                    {
                    // InternalNavascript.g:4690:4: (lv_arguments_3_0= rulePropertyArguments )
                    // InternalNavascript.g:4691:5: lv_arguments_3_0= rulePropertyArguments
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

            // InternalNavascript.g:4708:3: ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            int alt87=4;
            switch ( input.LA(1) ) {
            case 35:
            case 36:
            case 43:
                {
                alt87=1;
                }
                break;
            case 59:
                {
                alt87=2;
                }
                break;
            case 28:
                {
                int LA87_3 = input.LA(2);

                if ( (LA87_3==RULE_MAPPABLE_IDENTIFIER) ) {
                    alt87=3;
                }
                else if ( (LA87_3==RULE_TML_LITERAL) ) {
                    alt87=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalNavascript.g:4709:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    {
                    // InternalNavascript.g:4709:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    // InternalNavascript.g:4710:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';'
                    {
                    // InternalNavascript.g:4710:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( ((LA86_0>=35 && LA86_0<=36)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalNavascript.g:4711:6: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            {
                            // InternalNavascript.g:4711:6: (otherlv_4= '=' | otherlv_5= ':' )
                            int alt85=2;
                            int LA85_0 = input.LA(1);

                            if ( (LA85_0==35) ) {
                                alt85=1;
                            }
                            else if ( (LA85_0==36) ) {
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
                                    // InternalNavascript.g:4712:7: otherlv_4= '='
                                    {
                                    otherlv_4=(Token)match(input,35,FOLLOW_48); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_4, grammarAccess.getPropertyAccess().getEqualsSignKeyword_4_0_0_0_0());
                                      						
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalNavascript.g:4717:7: otherlv_5= ':'
                                    {
                                    otherlv_5=(Token)match(input,36,FOLLOW_48); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonKeyword_4_0_0_0_1());
                                      						
                                    }

                                    }
                                    break;

                            }

                            // InternalNavascript.g:4722:6: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            // InternalNavascript.g:4723:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            {
                            // InternalNavascript.g:4723:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            // InternalNavascript.g:4724:8: lv_expressionList_6_0= ruleConditionalExpressions
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

                    otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getPropertyAccess().getSemicolonKeyword_4_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4748:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    {
                    // InternalNavascript.g:4748:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    // InternalNavascript.g:4749:5: otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,59,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getPropertyAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4753:5: ( (lv_selectionArray_9_0= ruleSelectionArray ) )
                    // InternalNavascript.g:4754:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    {
                    // InternalNavascript.g:4754:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    // InternalNavascript.g:4755:7: lv_selectionArray_9_0= ruleSelectionArray
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getSelectionArraySelectionArrayParserRuleCall_4_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_39);
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

                    otherlv_10=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getPropertyAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4778:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    {
                    // InternalNavascript.g:4778:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    // InternalNavascript.g:4779:5: otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,28,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4783:5: ( (lv_arrayField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4784:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4784:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:4785:7: lv_arrayField_12_0= ruleMappedArrayField
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

                    otherlv_13=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getPropertyAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4808:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:4808:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    // InternalNavascript.g:4809:5: otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4813:5: ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4814:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4814:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4815:7: lv_arrayMessage_15_0= ruleMappedArrayMessage
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

                    otherlv_16=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4842:1: entryRuleSelectionArray returns [EObject current=null] : iv_ruleSelectionArray= ruleSelectionArray EOF ;
    public final EObject entryRuleSelectionArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArray = null;


        try {
            // InternalNavascript.g:4842:55: (iv_ruleSelectionArray= ruleSelectionArray EOF )
            // InternalNavascript.g:4843:2: iv_ruleSelectionArray= ruleSelectionArray EOF
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
    // InternalNavascript.g:4849:1: ruleSelectionArray returns [EObject current=null] : ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) ;
    public final EObject ruleSelectionArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayElements_0_0 = null;

        EObject lv_arrayElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4855:2: ( ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) )
            // InternalNavascript.g:4856:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            {
            // InternalNavascript.g:4856:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            // InternalNavascript.g:4857:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            {
            // InternalNavascript.g:4857:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) )
            // InternalNavascript.g:4858:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            {
            // InternalNavascript.g:4858:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            // InternalNavascript.g:4859:5: lv_arrayElements_0_0= ruleSelectionArrayElement
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

            // InternalNavascript.g:4876:3: (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==33) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalNavascript.g:4877:4: otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSelectionArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:4881:4: ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    // InternalNavascript.g:4882:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    {
            	    // InternalNavascript.g:4882:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    // InternalNavascript.g:4883:6: lv_arrayElements_2_0= ruleSelectionArrayElement
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
            	    break loop88;
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
    // InternalNavascript.g:4905:1: entryRuleSelectionArrayElement returns [EObject current=null] : iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF ;
    public final EObject entryRuleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArrayElement = null;


        try {
            // InternalNavascript.g:4905:62: (iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF )
            // InternalNavascript.g:4906:2: iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF
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
    // InternalNavascript.g:4912:1: ruleSelectionArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_innerBody_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4918:2: ( ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:4919:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:4919:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:4920:3: () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:4920:3: ()
            // InternalNavascript.g:4921:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSelectionArrayElementAccess().getSelectionArrayElementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSelectionArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:4934:3: ( (lv_innerBody_2_0= ruleInnerBody ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( ((LA89_0>=RULE_METHOD_IDENTIFIER && LA89_0<=RULE_MAPPABLE_IDENTIFIER)||LA89_0==26||LA89_0==28||LA89_0==42||LA89_0==48||(LA89_0>=50 && LA89_0<=51)||(LA89_0>=53 && LA89_0<=54)||(LA89_0>=56 && LA89_0<=58)||(LA89_0>=63 && LA89_0<=64)||(LA89_0>=66 && LA89_0<=68)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalNavascript.g:4935:4: (lv_innerBody_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:4935:4: (lv_innerBody_2_0= ruleInnerBody )
            	    // InternalNavascript.g:4936:5: lv_innerBody_2_0= ruleInnerBody
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
            	    break loop89;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4961:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalNavascript.g:4961:47: (iv_ruleOption= ruleOption EOF )
            // InternalNavascript.g:4962:2: iv_ruleOption= ruleOption EOF
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
    // InternalNavascript.g:4968:1: ruleOption returns [EObject current=null] : (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) ;
    public final EObject ruleOption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_option_1_0 = null;

        EObject lv_expressionList_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4974:2: ( (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) )
            // InternalNavascript.g:4975:2: (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            {
            // InternalNavascript.g:4975:2: (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            // InternalNavascript.g:4976:3: otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOptionAccess().getOptionKeyword_0());
              		
            }
            // InternalNavascript.g:4980:3: ( (lv_option_1_0= ruleOPTION_TYPE ) )
            // InternalNavascript.g:4981:4: (lv_option_1_0= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:4981:4: (lv_option_1_0= ruleOPTION_TYPE )
            // InternalNavascript.g:4982:5: lv_option_1_0= ruleOPTION_TYPE
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

            // InternalNavascript.g:4999:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==35) ) {
                alt90=1;
            }
            else if ( (LA90_0==36) ) {
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
                    // InternalNavascript.g:5000:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5005:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5010:3: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
            // InternalNavascript.g:5011:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            {
            // InternalNavascript.g:5011:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            // InternalNavascript.g:5012:5: lv_expressionList_4_0= ruleConditionalExpressions
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

            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:5037:1: entryRulePropertyArguments returns [EObject current=null] : iv_rulePropertyArguments= rulePropertyArguments EOF ;
    public final EObject entryRulePropertyArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArguments = null;


        try {
            // InternalNavascript.g:5037:58: (iv_rulePropertyArguments= rulePropertyArguments EOF )
            // InternalNavascript.g:5038:2: iv_rulePropertyArguments= rulePropertyArguments EOF
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
    // InternalNavascript.g:5044:1: rulePropertyArguments returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' ) ;
    public final EObject rulePropertyArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5050:2: ( ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' ) )
            // InternalNavascript.g:5051:2: ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' )
            {
            // InternalNavascript.g:5051:2: ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' )
            // InternalNavascript.g:5052:3: () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')'
            {
            // InternalNavascript.g:5052:3: ()
            // InternalNavascript.g:5053:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyArgumentsAccess().getPropertyArgumentsAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyArgumentsAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:5066:3: ( (lv_arguments_2_0= rulePropertyArgument ) )
            // InternalNavascript.g:5067:4: (lv_arguments_2_0= rulePropertyArgument )
            {
            // InternalNavascript.g:5067:4: (lv_arguments_2_0= rulePropertyArgument )
            // InternalNavascript.g:5068:5: lv_arguments_2_0= rulePropertyArgument
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

            // InternalNavascript.g:5085:3: (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==33) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalNavascript.g:5086:4: otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getPropertyArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:5090:4: ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    // InternalNavascript.g:5091:5: (lv_arguments_4_0= rulePropertyArgument )
            	    {
            	    // InternalNavascript.g:5091:5: (lv_arguments_4_0= rulePropertyArgument )
            	    // InternalNavascript.g:5092:6: lv_arguments_4_0= rulePropertyArgument
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
            	    break loop91;
                }
            } while (true);

            otherlv_5=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPropertyArgumentsAccess().getRightParenthesisKeyword_4());
              		
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
    // InternalNavascript.g:5118:1: entryRulePropertyArgument returns [EObject current=null] : iv_rulePropertyArgument= rulePropertyArgument EOF ;
    public final EObject entryRulePropertyArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArgument = null;


        try {
            // InternalNavascript.g:5118:57: (iv_rulePropertyArgument= rulePropertyArgument EOF )
            // InternalNavascript.g:5119:2: iv_rulePropertyArgument= rulePropertyArgument EOF
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
    // InternalNavascript.g:5125:1: rulePropertyArgument returns [EObject current=null] : (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) ;
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
            // InternalNavascript.g:5131:2: ( (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) )
            // InternalNavascript.g:5132:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            {
            // InternalNavascript.g:5132:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            int alt92=6;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt92=1;
                }
                break;
            case 61:
                {
                alt92=2;
                }
                break;
            case 76:
                {
                alt92=3;
                }
                break;
            case 45:
                {
                alt92=4;
                }
                break;
            case 74:
                {
                alt92=5;
                }
                break;
            case 69:
                {
                alt92=6;
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
                    // InternalNavascript.g:5133:3: this_DirectionArgument_0= ruleDirectionArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:5145:3: this_TypeArgument_1= ruleTypeArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:5157:3: this_SubTypeArgument_2= ruleSubTypeArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:5169:3: this_DescriptionArgument_3= ruleDescriptionArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:5181:3: this_CardinalityArgument_4= ruleCardinalityArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
                    // InternalNavascript.g:5193:3: this_LengthArgument_5= ruleLengthArgument
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
    // InternalNavascript.g:5208:1: entryRuleLengthArgument returns [EObject current=null] : iv_ruleLengthArgument= ruleLengthArgument EOF ;
    public final EObject entryRuleLengthArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLengthArgument = null;


        try {
            // InternalNavascript.g:5208:55: (iv_ruleLengthArgument= ruleLengthArgument EOF )
            // InternalNavascript.g:5209:2: iv_ruleLengthArgument= ruleLengthArgument EOF
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
    // InternalNavascript.g:5215:1: ruleLengthArgument returns [EObject current=null] : (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleLengthArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5221:2: ( (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) )
            // InternalNavascript.g:5222:2: (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            {
            // InternalNavascript.g:5222:2: (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            // InternalNavascript.g:5223:3: otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLengthArgumentAccess().getLengthKeyword_0());
              		
            }
            // InternalNavascript.g:5227:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==35) ) {
                alt93=1;
            }
            else if ( (LA93_0==36) ) {
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
                    // InternalNavascript.g:5228:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLengthArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5233:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLengthArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5238:3: ( (lv_value_3_0= RULE_INTEGER ) )
            // InternalNavascript.g:5239:4: (lv_value_3_0= RULE_INTEGER )
            {
            // InternalNavascript.g:5239:4: (lv_value_3_0= RULE_INTEGER )
            // InternalNavascript.g:5240:5: lv_value_3_0= RULE_INTEGER
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
    // InternalNavascript.g:5260:1: entryRuleDirectionArgument returns [EObject current=null] : iv_ruleDirectionArgument= ruleDirectionArgument EOF ;
    public final EObject entryRuleDirectionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionArgument = null;


        try {
            // InternalNavascript.g:5260:58: (iv_ruleDirectionArgument= ruleDirectionArgument EOF )
            // InternalNavascript.g:5261:2: iv_ruleDirectionArgument= ruleDirectionArgument EOF
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
    // InternalNavascript.g:5267:1: ruleDirectionArgument returns [EObject current=null] : (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) ) ;
    public final EObject ruleDirectionArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token lv_value_3_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:5273:2: ( (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) ) )
            // InternalNavascript.g:5274:2: (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) )
            {
            // InternalNavascript.g:5274:2: (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) )
            // InternalNavascript.g:5275:3: otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectionArgumentAccess().getDirectionKeyword_0());
              		
            }
            // InternalNavascript.g:5279:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==35) ) {
                alt94=1;
            }
            else if ( (LA94_0==36) ) {
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
                    // InternalNavascript.g:5280:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5285:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDirectionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5290:3: ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) )
            // InternalNavascript.g:5291:4: ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) )
            {
            // InternalNavascript.g:5291:4: ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) )
            // InternalNavascript.g:5292:5: (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' )
            {
            // InternalNavascript.g:5292:5: (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' )
            int alt95=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt95=1;
                }
                break;
            case 72:
                {
                alt95=2;
                }
                break;
            case 73:
                {
                alt95=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // InternalNavascript.g:5293:6: lv_value_3_1= 'in'
                    {
                    lv_value_3_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_1, grammarAccess.getDirectionArgumentAccess().getValueInKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5304:6: lv_value_3_2= 'out'
                    {
                    lv_value_3_2=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_2, grammarAccess.getDirectionArgumentAccess().getValueOutKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:5315:6: lv_value_3_3= 'inout'
                    {
                    lv_value_3_3=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_3, grammarAccess.getDirectionArgumentAccess().getValueInoutKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDirectionArgumentRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_3_3, null);
                      					
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
    // InternalNavascript.g:5332:1: entryRuleDescriptionArgument returns [EObject current=null] : iv_ruleDescriptionArgument= ruleDescriptionArgument EOF ;
    public final EObject entryRuleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionArgument = null;


        try {
            // InternalNavascript.g:5332:60: (iv_ruleDescriptionArgument= ruleDescriptionArgument EOF )
            // InternalNavascript.g:5333:2: iv_ruleDescriptionArgument= ruleDescriptionArgument EOF
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
    // InternalNavascript.g:5339:1: ruleDescriptionArgument returns [EObject current=null] : (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5345:2: ( (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5346:2: (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5346:2: (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5347:3: otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDescriptionArgumentAccess().getDescriptionKeyword_0());
              		
            }
            // InternalNavascript.g:5351:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==35) ) {
                alt96=1;
            }
            else if ( (LA96_0==36) ) {
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
                    // InternalNavascript.g:5352:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDescriptionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5357:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDescriptionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5362:3: ( (lv_value_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5363:4: (lv_value_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5363:4: (lv_value_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5364:5: lv_value_3_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5385:1: entryRuleCardinalityArgument returns [EObject current=null] : iv_ruleCardinalityArgument= ruleCardinalityArgument EOF ;
    public final EObject entryRuleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCardinalityArgument = null;


        try {
            // InternalNavascript.g:5385:60: (iv_ruleCardinalityArgument= ruleCardinalityArgument EOF )
            // InternalNavascript.g:5386:2: iv_ruleCardinalityArgument= ruleCardinalityArgument EOF
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
    // InternalNavascript.g:5392:1: ruleCardinalityArgument returns [EObject current=null] : (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) ) ;
    public final EObject ruleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:5398:2: ( (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) ) )
            // InternalNavascript.g:5399:2: (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) )
            {
            // InternalNavascript.g:5399:2: (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) )
            // InternalNavascript.g:5400:3: otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCardinalityArgumentAccess().getCardinalityKeyword_0());
              		
            }
            // InternalNavascript.g:5404:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==35) ) {
                alt97=1;
            }
            else if ( (LA97_0==36) ) {
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
                    // InternalNavascript.g:5405:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCardinalityArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5410:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_60); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCardinalityArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5415:3: ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) )
            // InternalNavascript.g:5416:4: ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) )
            {
            // InternalNavascript.g:5416:4: ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) )
            // InternalNavascript.g:5417:5: (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE )
            {
            // InternalNavascript.g:5417:5: (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==75) ) {
                alt98=1;
            }
            else if ( (LA98_0==RULE_ONE) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // InternalNavascript.g:5418:6: lv_value_3_1= '+'
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
                    // InternalNavascript.g:5429:6: lv_value_3_2= RULE_ONE
                    {
                    lv_value_3_2=(Token)match(input,RULE_ONE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_2, grammarAccess.getCardinalityArgumentAccess().getValueONETerminalRuleCall_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCardinalityArgumentRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_2,
                      							"com.dexels.navajo.Navascript.ONE");
                      					
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
    // InternalNavascript.g:5450:1: entryRuleTypeArgument returns [EObject current=null] : iv_ruleTypeArgument= ruleTypeArgument EOF ;
    public final EObject entryRuleTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeArgument = null;


        try {
            // InternalNavascript.g:5450:53: (iv_ruleTypeArgument= ruleTypeArgument EOF )
            // InternalNavascript.g:5451:2: iv_ruleTypeArgument= ruleTypeArgument EOF
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
    // InternalNavascript.g:5457:1: ruleTypeArgument returns [EObject current=null] : (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) ;
    public final EObject ruleTypeArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5463:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) )
            // InternalNavascript.g:5464:2: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            {
            // InternalNavascript.g:5464:2: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            // InternalNavascript.g:5465:3: otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) )
            {
            otherlv_0=(Token)match(input,61,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeArgumentAccess().getTypeKeyword_0());
              		
            }
            // InternalNavascript.g:5469:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==35) ) {
                alt99=1;
            }
            else if ( (LA99_0==36) ) {
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
                    // InternalNavascript.g:5470:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5475:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5480:3: ( (lv_value_3_0= rulePropertyType ) )
            // InternalNavascript.g:5481:4: (lv_value_3_0= rulePropertyType )
            {
            // InternalNavascript.g:5481:4: (lv_value_3_0= rulePropertyType )
            // InternalNavascript.g:5482:5: lv_value_3_0= rulePropertyType
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
    // InternalNavascript.g:5503:1: entryRuleSubTypeArgument returns [EObject current=null] : iv_ruleSubTypeArgument= ruleSubTypeArgument EOF ;
    public final EObject entryRuleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeArgument = null;


        try {
            // InternalNavascript.g:5503:56: (iv_ruleSubTypeArgument= ruleSubTypeArgument EOF )
            // InternalNavascript.g:5504:2: iv_ruleSubTypeArgument= ruleSubTypeArgument EOF
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
    // InternalNavascript.g:5510:1: ruleSubTypeArgument returns [EObject current=null] : (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5516:2: ( (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) )
            // InternalNavascript.g:5517:2: (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            {
            // InternalNavascript.g:5517:2: (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            // InternalNavascript.g:5518:3: otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSubTypeArgumentAccess().getSubtypeKeyword_0());
              		
            }
            // InternalNavascript.g:5522:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==35) ) {
                alt100=1;
            }
            else if ( (LA100_0==36) ) {
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
                    // InternalNavascript.g:5523:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSubTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5528:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5533:3: ( (lv_value_3_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:5534:4: (lv_value_3_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:5534:4: (lv_value_3_0= RULE_IDENTIFIER )
            // InternalNavascript.g:5535:5: lv_value_3_0= RULE_IDENTIFIER
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
    // InternalNavascript.g:5555:1: entryRuleConditionalExpressions returns [EObject current=null] : iv_ruleConditionalExpressions= ruleConditionalExpressions EOF ;
    public final EObject entryRuleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressions = null;


        try {
            // InternalNavascript.g:5555:63: (iv_ruleConditionalExpressions= ruleConditionalExpressions EOF )
            // InternalNavascript.g:5556:2: iv_ruleConditionalExpressions= ruleConditionalExpressions EOF
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
    // InternalNavascript.g:5562:1: ruleConditionalExpressions returns [EObject current=null] : ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_conditionalExpressions_1_0 = null;

        EObject lv_elseExpresssion_3_0 = null;

        EObject lv_singleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5568:2: ( ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5569:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5569:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==26) ) {
                alt102=1;
            }
            else if ( ((LA102_0>=RULE_QUOTED_IDENTIFIER && LA102_0<=RULE_IDENTIFIER)||(LA102_0>=RULE_MAPPABLE_IDENTIFIER && LA102_0<=RULE_EXISTS)||LA102_0==31||LA102_0==86||(LA102_0>=89 && LA102_0<=90)) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalNavascript.g:5570:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:5570:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:5571:4: () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5571:4: ()
                    // InternalNavascript.g:5572:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getConditionalExpressionsAccess().getConditionalExpressionsAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:5581:4: ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+
                    int cnt101=0;
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==26) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalNavascript.g:5582:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    {
                    	    // InternalNavascript.g:5582:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    // InternalNavascript.g:5583:6: lv_conditionalExpressions_1_0= ruleConditionalExpression
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
                    	    if ( cnt101 >= 1 ) break loop101;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(101, input);
                                throw eee;
                        }
                        cnt101++;
                    } while (true);

                    otherlv_2=(Token)match(input,77,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionsAccess().getElseKeyword_0_2());
                      			
                    }
                    // InternalNavascript.g:5604:4: ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5605:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5605:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5606:6: lv_elseExpresssion_3_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:5625:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5625:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5626:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5626:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5627:5: lv_singleExpression_4_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5648:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalNavascript.g:5648:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalNavascript.g:5649:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalNavascript.g:5655:1: ruleConditionalExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5661:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5662:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5662:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5663:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConditionalExpressionAccess().getIfKeyword_0());
              		
            }
            // InternalNavascript.g:5667:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalNavascript.g:5668:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalNavascript.g:5668:4: (lv_condition_1_0= ruleExpression )
            // InternalNavascript.g:5669:5: lv_condition_1_0= ruleExpression
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

            otherlv_2=(Token)match(input,27,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getThenKeyword_2());
              		
            }
            // InternalNavascript.g:5690:3: ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5691:4: (lv_expression_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5691:4: (lv_expression_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5692:5: lv_expression_3_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5713:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalNavascript.g:5713:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalNavascript.g:5714:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalNavascript.g:5720:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5726:2: (this_BooleanExpression_0= ruleBooleanExpression )
            // InternalNavascript.g:5727:2: this_BooleanExpression_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
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
    // InternalNavascript.g:5741:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalNavascript.g:5741:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalNavascript.g:5742:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalNavascript.g:5748:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5754:2: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalNavascript.g:5755:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalNavascript.g:5755:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalNavascript.g:5756:3: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
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
            // InternalNavascript.g:5767:3: ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( ((LA104_0>=78 && LA104_0<=79)) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // InternalNavascript.g:5768:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalNavascript.g:5768:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) )
            	    // InternalNavascript.g:5769:5: () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    {
            	    // InternalNavascript.g:5769:5: ()
            	    // InternalNavascript.g:5770:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5779:5: ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    // InternalNavascript.g:5780:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    {
            	    // InternalNavascript.g:5780:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    // InternalNavascript.g:5781:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    {
            	    // InternalNavascript.g:5781:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    int alt103=2;
            	    int LA103_0 = input.LA(1);

            	    if ( (LA103_0==78) ) {
            	        alt103=1;
            	    }
            	    else if ( (LA103_0==79) ) {
            	        alt103=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 103, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt103) {
            	        case 1 :
            	            // InternalNavascript.g:5782:8: lv_op_2_1= 'OR'
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
            	            // InternalNavascript.g:5793:8: lv_op_2_2= 'AND'
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

            	    // InternalNavascript.g:5807:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalNavascript.g:5808:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalNavascript.g:5808:5: (lv_right_3_0= ruleComparison )
            	    // InternalNavascript.g:5809:6: lv_right_3_0= ruleComparison
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
            	    break loop104;
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
    // InternalNavascript.g:5831:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalNavascript.g:5831:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalNavascript.g:5832:2: iv_ruleComparison= ruleComparison EOF
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
    // InternalNavascript.g:5838:1: ruleComparison returns [EObject current=null] : (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) ;
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
            // InternalNavascript.g:5844:2: ( (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) )
            // InternalNavascript.g:5845:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            {
            // InternalNavascript.g:5845:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            // InternalNavascript.g:5846:3: this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
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
            // InternalNavascript.g:5857:3: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( ((LA106_0>=80 && LA106_0<=83)) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // InternalNavascript.g:5858:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) )
            	    {
            	    // InternalNavascript.g:5858:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) )
            	    // InternalNavascript.g:5859:5: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    {
            	    // InternalNavascript.g:5859:5: ()
            	    // InternalNavascript.g:5860:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5869:5: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalNavascript.g:5870:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalNavascript.g:5870:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalNavascript.g:5871:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalNavascript.g:5871:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt105=4;
            	    switch ( input.LA(1) ) {
            	    case 80:
            	        {
            	        alt105=1;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt105=2;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt105=3;
            	        }
            	        break;
            	    case 83:
            	        {
            	        alt105=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 105, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt105) {
            	        case 1 :
            	            // InternalNavascript.g:5872:8: lv_op_2_1= '<'
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
            	            // InternalNavascript.g:5883:8: lv_op_2_2= '>'
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
            	            // InternalNavascript.g:5894:8: lv_op_2_3= '<='
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
            	            // InternalNavascript.g:5905:8: lv_op_2_4= '>='
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

            	    // InternalNavascript.g:5919:4: ( (lv_right_3_0= ruleEquals ) )
            	    // InternalNavascript.g:5920:5: (lv_right_3_0= ruleEquals )
            	    {
            	    // InternalNavascript.g:5920:5: (lv_right_3_0= ruleEquals )
            	    // InternalNavascript.g:5921:6: lv_right_3_0= ruleEquals
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
            	    break loop106;
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
    // InternalNavascript.g:5943:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalNavascript.g:5943:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalNavascript.g:5944:2: iv_ruleEquals= ruleEquals EOF
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
    // InternalNavascript.g:5950:1: ruleEquals returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5956:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalNavascript.g:5957:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalNavascript.g:5957:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalNavascript.g:5958:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
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
            // InternalNavascript.g:5969:3: ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( ((LA108_0>=84 && LA108_0<=85)) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // InternalNavascript.g:5970:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalNavascript.g:5970:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) )
            	    // InternalNavascript.g:5971:5: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    {
            	    // InternalNavascript.g:5971:5: ()
            	    // InternalNavascript.g:5972:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:5981:5: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalNavascript.g:5982:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalNavascript.g:5982:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalNavascript.g:5983:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalNavascript.g:5983:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt107=2;
            	    int LA107_0 = input.LA(1);

            	    if ( (LA107_0==84) ) {
            	        alt107=1;
            	    }
            	    else if ( (LA107_0==85) ) {
            	        alt107=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 107, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt107) {
            	        case 1 :
            	            // InternalNavascript.g:5984:8: lv_op_2_1= '=='
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
            	            // InternalNavascript.g:5995:8: lv_op_2_2= '!='
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

            	    // InternalNavascript.g:6009:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalNavascript.g:6010:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalNavascript.g:6010:5: (lv_right_3_0= ruleAddition )
            	    // InternalNavascript.g:6011:6: lv_right_3_0= ruleAddition
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
            	    break loop108;
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
    // InternalNavascript.g:6033:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalNavascript.g:6033:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalNavascript.g:6034:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalNavascript.g:6040:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6046:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalNavascript.g:6047:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalNavascript.g:6047:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalNavascript.g:6048:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
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
            // InternalNavascript.g:6059:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==75||LA110_0==86) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // InternalNavascript.g:6060:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalNavascript.g:6060:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt109=2;
            	    int LA109_0 = input.LA(1);

            	    if ( (LA109_0==75) ) {
            	        alt109=1;
            	    }
            	    else if ( (LA109_0==86) ) {
            	        alt109=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 109, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt109) {
            	        case 1 :
            	            // InternalNavascript.g:6061:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalNavascript.g:6061:5: ( () otherlv_2= '+' )
            	            // InternalNavascript.g:6062:6: () otherlv_2= '+'
            	            {
            	            // InternalNavascript.g:6062:6: ()
            	            // InternalNavascript.g:6063:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							/* */
            	              						
            	            }
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
            	            // InternalNavascript.g:6078:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalNavascript.g:6078:5: ( () otherlv_4= '-' )
            	            // InternalNavascript.g:6079:6: () otherlv_4= '-'
            	            {
            	            // InternalNavascript.g:6079:6: ()
            	            // InternalNavascript.g:6080:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							/* */
            	              						
            	            }
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

            	    // InternalNavascript.g:6095:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalNavascript.g:6096:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalNavascript.g:6096:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalNavascript.g:6097:6: lv_right_5_0= ruleMultiplication
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
            	    break loop110;
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
    // InternalNavascript.g:6119:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalNavascript.g:6119:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalNavascript.g:6120:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalNavascript.g:6126:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6132:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalNavascript.g:6133:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalNavascript.g:6133:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalNavascript.g:6134:3: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
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
            // InternalNavascript.g:6145:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( ((LA112_0>=87 && LA112_0<=88)) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalNavascript.g:6146:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalNavascript.g:6146:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalNavascript.g:6147:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalNavascript.g:6147:5: ()
            	    // InternalNavascript.g:6148:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalNavascript.g:6157:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalNavascript.g:6158:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalNavascript.g:6158:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalNavascript.g:6159:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalNavascript.g:6159:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt111=2;
            	    int LA111_0 = input.LA(1);

            	    if ( (LA111_0==87) ) {
            	        alt111=1;
            	    }
            	    else if ( (LA111_0==88) ) {
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
            	            // InternalNavascript.g:6160:8: lv_op_2_1= '*'
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
            	            // InternalNavascript.g:6171:8: lv_op_2_2= '/'
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

            	    // InternalNavascript.g:6185:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalNavascript.g:6186:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalNavascript.g:6186:5: (lv_right_3_0= rulePrefixed )
            	    // InternalNavascript.g:6187:6: lv_right_3_0= rulePrefixed
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
            	    break loop112;
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
    // InternalNavascript.g:6209:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalNavascript.g:6209:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalNavascript.g:6210:2: iv_rulePrefixed= rulePrefixed EOF
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
    // InternalNavascript.g:6216:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6222:2: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalNavascript.g:6223:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalNavascript.g:6223:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt113=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt113=1;
                }
                break;
            case 86:
                {
                alt113=2;
                }
                break;
            case RULE_IDENTIFIER:
            case RULE_MAPPABLE_IDENTIFIER:
            case RULE_TML_LITERAL:
            case RULE_INTEGER:
            case RULE_ONE:
            case RULE_FLOAT:
            case RULE_STRING_LITERAL:
            case RULE_TRUE:
            case RULE_FALSE:
            case RULE_NULL_DEF:
            case RULE_FORALL:
            case RULE_EXISTS:
            case 31:
            case 90:
                {
                alt113=3;
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
                    // InternalNavascript.g:6224:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:6224:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalNavascript.g:6225:4: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:6225:4: ()
                    // InternalNavascript.g:6226:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6235:4: ( ( '!' )=>otherlv_1= '!' )
                    // InternalNavascript.g:6236:5: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      				
                    }

                    }

                    // InternalNavascript.g:6242:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalNavascript.g:6243:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalNavascript.g:6243:5: (lv_expression_2_0= ruleAtomic )
                    // InternalNavascript.g:6244:6: lv_expression_2_0= ruleAtomic
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
                    // InternalNavascript.g:6263:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:6263:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalNavascript.g:6264:4: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:6264:4: ()
                    // InternalNavascript.g:6265:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6274:4: ( ( '-' )=>otherlv_4= '-' )
                    // InternalNavascript.g:6275:5: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,86,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      				
                    }

                    }

                    // InternalNavascript.g:6281:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalNavascript.g:6282:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalNavascript.g:6282:5: (lv_expression_5_0= ruleAtomic )
                    // InternalNavascript.g:6283:6: lv_expression_5_0= ruleAtomic
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
                    // InternalNavascript.g:6302:3: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
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
    // InternalNavascript.g:6317:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalNavascript.g:6317:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalNavascript.g:6318:2: iv_ruleAtomic= ruleAtomic EOF
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
    // InternalNavascript.g:6324:1: ruleAtomic returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token lv_value_5_3=null;
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
            // InternalNavascript.g:6330:2: ( ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) ) )
            // InternalNavascript.g:6331:2: ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            {
            // InternalNavascript.g:6331:2: ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) )
            int alt117=9;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt117=1;
                }
                break;
            case RULE_INTEGER:
            case RULE_ONE:
            case RULE_FLOAT:
                {
                alt117=2;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt117=3;
                }
                break;
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt117=4;
                }
                break;
            case RULE_IDENTIFIER:
                {
                alt117=5;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt117=6;
                }
                break;
            case RULE_TML_LITERAL:
            case 90:
                {
                alt117=7;
                }
                break;
            case RULE_FORALL:
            case RULE_EXISTS:
                {
                alt117=8;
                }
                break;
            case RULE_NULL_DEF:
                {
                alt117=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // InternalNavascript.g:6332:3: ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalNavascript.g:6332:3: ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalNavascript.g:6333:4: () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalNavascript.g:6333:4: ()
                    // InternalNavascript.g:6334:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getExpressionLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalNavascript.g:6347:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalNavascript.g:6348:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:6348:5: (lv_value_2_0= ruleExpression )
                    // InternalNavascript.g:6349:6: lv_value_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6372:3: ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) )
                    {
                    // InternalNavascript.g:6372:3: ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) )
                    // InternalNavascript.g:6373:4: () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) )
                    {
                    // InternalNavascript.g:6373:4: ()
                    // InternalNavascript.g:6374:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6383:4: ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) )
                    // InternalNavascript.g:6384:5: ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) )
                    {
                    // InternalNavascript.g:6384:5: ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) )
                    // InternalNavascript.g:6385:6: (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT )
                    {
                    // InternalNavascript.g:6385:6: (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT )
                    int alt114=3;
                    switch ( input.LA(1) ) {
                    case RULE_INTEGER:
                        {
                        alt114=1;
                        }
                        break;
                    case RULE_ONE:
                        {
                        alt114=2;
                        }
                        break;
                    case RULE_FLOAT:
                        {
                        alt114=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 114, 0, input);

                        throw nvae;
                    }

                    switch (alt114) {
                        case 1 :
                            // InternalNavascript.g:6386:7: lv_value_5_1= RULE_INTEGER
                            {
                            lv_value_5_1=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_1, grammarAccess.getAtomicAccess().getValueINTEGERTerminalRuleCall_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"value",
                              								lv_value_5_1,
                              								"com.dexels.navajo.Navascript.INTEGER");
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:6401:7: lv_value_5_2= RULE_ONE
                            {
                            lv_value_5_2=(Token)match(input,RULE_ONE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_2, grammarAccess.getAtomicAccess().getValueONETerminalRuleCall_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"value",
                              								lv_value_5_2,
                              								"com.dexels.navajo.Navascript.ONE");
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalNavascript.g:6416:7: lv_value_5_3= RULE_FLOAT
                            {
                            lv_value_5_3=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_3, grammarAccess.getAtomicAccess().getValueFLOATTerminalRuleCall_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"value",
                              								lv_value_5_3,
                              								"com.dexels.navajo.Navascript.FLOAT");
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:6435:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    {
                    // InternalNavascript.g:6435:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    // InternalNavascript.g:6436:4: () ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    {
                    // InternalNavascript.g:6436:4: ()
                    // InternalNavascript.g:6437:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getStringLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6446:4: ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    // InternalNavascript.g:6447:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    {
                    // InternalNavascript.g:6447:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    // InternalNavascript.g:6448:6: lv_value_7_0= RULE_STRING_LITERAL
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
                    // InternalNavascript.g:6466:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    {
                    // InternalNavascript.g:6466:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    // InternalNavascript.g:6467:4: () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    {
                    // InternalNavascript.g:6467:4: ()
                    // InternalNavascript.g:6468:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6477:4: ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    // InternalNavascript.g:6478:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    {
                    // InternalNavascript.g:6478:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    // InternalNavascript.g:6479:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    {
                    // InternalNavascript.g:6479:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==RULE_TRUE) ) {
                        alt115=1;
                    }
                    else if ( (LA115_0==RULE_FALSE) ) {
                        alt115=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 115, 0, input);

                        throw nvae;
                    }
                    switch (alt115) {
                        case 1 :
                            // InternalNavascript.g:6480:7: lv_value_9_1= RULE_TRUE
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
                            // InternalNavascript.g:6495:7: lv_value_9_2= RULE_FALSE
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
                    // InternalNavascript.g:6514:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    {
                    // InternalNavascript.g:6514:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    // InternalNavascript.g:6515:4: () ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    {
                    // InternalNavascript.g:6515:4: ()
                    // InternalNavascript.g:6516:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getFunctionCallLiteralAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6525:4: ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    // InternalNavascript.g:6526:5: (lv_value_11_0= ruleFunctionIdentifier )
                    {
                    // InternalNavascript.g:6526:5: (lv_value_11_0= ruleFunctionIdentifier )
                    // InternalNavascript.g:6527:6: lv_value_11_0= ruleFunctionIdentifier
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
                    // InternalNavascript.g:6546:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    {
                    // InternalNavascript.g:6546:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    // InternalNavascript.g:6547:4: () ( (lv_value_13_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:6547:4: ()
                    // InternalNavascript.g:6548:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getMappableIdentifierLiteralAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6557:4: ( (lv_value_13_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:6558:5: (lv_value_13_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:6558:5: (lv_value_13_0= ruleMappableIdentifier )
                    // InternalNavascript.g:6559:6: lv_value_13_0= ruleMappableIdentifier
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
                    // InternalNavascript.g:6578:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    {
                    // InternalNavascript.g:6578:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    // InternalNavascript.g:6579:4: () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:6579:4: ()
                    // InternalNavascript.g:6580:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getTmlIdentifierLiteralAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6589:4: ( (lv_hasExists_15_0= '?' ) )?
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==90) ) {
                        alt116=1;
                    }
                    switch (alt116) {
                        case 1 :
                            // InternalNavascript.g:6590:5: (lv_hasExists_15_0= '?' )
                            {
                            // InternalNavascript.g:6590:5: (lv_hasExists_15_0= '?' )
                            // InternalNavascript.g:6591:6: lv_hasExists_15_0= '?'
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

                    // InternalNavascript.g:6603:4: ( (lv_value_16_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:6604:5: (lv_value_16_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:6604:5: (lv_value_16_0= ruleTmlIdentifier )
                    // InternalNavascript.g:6605:6: lv_value_16_0= ruleTmlIdentifier
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
                    // InternalNavascript.g:6624:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    {
                    // InternalNavascript.g:6624:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    // InternalNavascript.g:6625:4: () ( (lv_value_18_0= ruleForAllIdentifier ) )
                    {
                    // InternalNavascript.g:6625:4: ()
                    // InternalNavascript.g:6626:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getForAllLiteralAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6635:4: ( (lv_value_18_0= ruleForAllIdentifier ) )
                    // InternalNavascript.g:6636:5: (lv_value_18_0= ruleForAllIdentifier )
                    {
                    // InternalNavascript.g:6636:5: (lv_value_18_0= ruleForAllIdentifier )
                    // InternalNavascript.g:6637:6: lv_value_18_0= ruleForAllIdentifier
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
                    // InternalNavascript.g:6656:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    {
                    // InternalNavascript.g:6656:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    // InternalNavascript.g:6657:4: () ( (lv_value_20_0= RULE_NULL_DEF ) )
                    {
                    // InternalNavascript.g:6657:4: ()
                    // InternalNavascript.g:6658:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getNullLiteralAction_8_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6667:4: ( (lv_value_20_0= RULE_NULL_DEF ) )
                    // InternalNavascript.g:6668:5: (lv_value_20_0= RULE_NULL_DEF )
                    {
                    // InternalNavascript.g:6668:5: (lv_value_20_0= RULE_NULL_DEF )
                    // InternalNavascript.g:6669:6: lv_value_20_0= RULE_NULL_DEF
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
    // InternalNavascript.g:6690:1: entryRuleForAllIdentifier returns [EObject current=null] : iv_ruleForAllIdentifier= ruleForAllIdentifier EOF ;
    public final EObject entryRuleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllIdentifier = null;


        try {
            // InternalNavascript.g:6690:57: (iv_ruleForAllIdentifier= ruleForAllIdentifier EOF )
            // InternalNavascript.g:6691:2: iv_ruleForAllIdentifier= ruleForAllIdentifier EOF
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
    // InternalNavascript.g:6697:1: ruleForAllIdentifier returns [EObject current=null] : ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' ) ;
    public final EObject ruleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_messagedefinition_7_0=null;
        Token otherlv_8=null;
        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6703:2: ( ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' ) )
            // InternalNavascript.g:6704:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' )
            {
            // InternalNavascript.g:6704:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' )
            // InternalNavascript.g:6705:3: () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')'
            {
            // InternalNavascript.g:6705:3: ()
            // InternalNavascript.g:6706:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getForAllIdentifierAccess().getForAllIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6715:3: ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) )
            // InternalNavascript.g:6716:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            {
            // InternalNavascript.g:6716:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            // InternalNavascript.g:6717:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            {
            // InternalNavascript.g:6717:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==RULE_FORALL) ) {
                alt118=1;
            }
            else if ( (LA118_0==RULE_EXISTS) ) {
                alt118=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalNavascript.g:6718:6: lv_op_1_1= RULE_FORALL
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
                    // InternalNavascript.g:6733:6: lv_op_1_2= RULE_EXISTS
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

            otherlv_2=(Token)match(input,31,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForAllIdentifierAccess().getLeftParenthesisKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,91,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_3());
              		
            }
            // InternalNavascript.g:6758:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalNavascript.g:6759:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalNavascript.g:6759:4: (lv_expression_4_0= ruleExpression )
            // InternalNavascript.g:6760:5: lv_expression_4_0= ruleExpression
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
            otherlv_6=(Token)match(input,33,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getForAllIdentifierAccess().getCommaKeyword_6());
              		
            }
            // InternalNavascript.g:6785:3: ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) )
            // InternalNavascript.g:6786:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            {
            // InternalNavascript.g:6786:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            // InternalNavascript.g:6787:5: lv_messagedefinition_7_0= RULE_STRING_LITERAL
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

            otherlv_8=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getForAllIdentifierAccess().getRightParenthesisKeyword_8());
              		
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
    // InternalNavascript.g:6811:1: entryRuleFunctionIdentifier returns [EObject current=null] : iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF ;
    public final EObject entryRuleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionIdentifier = null;


        try {
            // InternalNavascript.g:6811:59: (iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF )
            // InternalNavascript.g:6812:2: iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF
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
    // InternalNavascript.g:6818:1: ruleFunctionIdentifier returns [EObject current=null] : ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ) ;
    public final EObject ruleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_func_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6824:2: ( ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ) )
            // InternalNavascript.g:6825:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            {
            // InternalNavascript.g:6825:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalNavascript.g:6826:3: () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalNavascript.g:6826:3: ()
            // InternalNavascript.g:6827:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionIdentifierAccess().getFunctionIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6836:3: ( (lv_func_1_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:6837:4: (lv_func_1_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:6837:4: (lv_func_1_0= RULE_IDENTIFIER )
            // InternalNavascript.g:6838:5: lv_func_1_0= RULE_IDENTIFIER
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

            // InternalNavascript.g:6854:3: (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalNavascript.g:6855:4: otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_2=(Token)match(input,31,FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getFunctionIdentifierAccess().getLeftParenthesisKeyword_2_0());
              			
            }
            // InternalNavascript.g:6859:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==RULE_IDENTIFIER||(LA120_0>=RULE_MAPPABLE_IDENTIFIER && LA120_0<=RULE_EXISTS)||LA120_0==31||LA120_0==86||(LA120_0>=89 && LA120_0<=90)) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalNavascript.g:6860:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalNavascript.g:6860:5: ( (lv_args_3_0= ruleExpression ) )
                    // InternalNavascript.g:6861:6: (lv_args_3_0= ruleExpression )
                    {
                    // InternalNavascript.g:6861:6: (lv_args_3_0= ruleExpression )
                    // InternalNavascript.g:6862:7: lv_args_3_0= ruleExpression
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

                    // InternalNavascript.g:6879:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==33) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // InternalNavascript.g:6880:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getFunctionIdentifierAccess().getCommaKeyword_2_1_1_0());
                    	      					
                    	    }
                    	    // InternalNavascript.g:6884:6: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalNavascript.g:6885:7: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalNavascript.g:6885:7: (lv_args_5_0= ruleExpression )
                    	    // InternalNavascript.g:6886:8: lv_args_5_0= ruleExpression
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
                    	    break loop119;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_6, grammarAccess.getFunctionIdentifierAccess().getRightParenthesisKeyword_2_2());
              			
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
    // InternalNavascript.g:6914:1: entryRuleMappableIdentifier returns [EObject current=null] : iv_ruleMappableIdentifier= ruleMappableIdentifier EOF ;
    public final EObject entryRuleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappableIdentifier = null;


        try {
            // InternalNavascript.g:6914:59: (iv_ruleMappableIdentifier= ruleMappableIdentifier EOF )
            // InternalNavascript.g:6915:2: iv_ruleMappableIdentifier= ruleMappableIdentifier EOF
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
    // InternalNavascript.g:6921:1: ruleMappableIdentifier returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) ;
    public final EObject ruleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_field_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6927:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) )
            // InternalNavascript.g:6928:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            {
            // InternalNavascript.g:6928:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            // InternalNavascript.g:6929:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            {
            // InternalNavascript.g:6929:3: ()
            // InternalNavascript.g:6930:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMappableIdentifierAccess().getMappableIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:6939:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:6940:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:6940:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:6941:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
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

            // InternalNavascript.g:6957:3: (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==31) ) {
                int LA123_1 = input.LA(2);

                if ( (LA123_1==RULE_IDENTIFIER||(LA123_1>=RULE_MAPPABLE_IDENTIFIER && LA123_1<=RULE_EXISTS)||(LA123_1>=31 && LA123_1<=32)||LA123_1==86||(LA123_1>=89 && LA123_1<=90)) ) {
                    alt123=1;
                }
            }
            switch (alt123) {
                case 1 :
                    // InternalNavascript.g:6958:4: otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_71); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappableIdentifierAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:6962:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==RULE_IDENTIFIER||(LA122_0>=RULE_MAPPABLE_IDENTIFIER && LA122_0<=RULE_EXISTS)||LA122_0==31||LA122_0==86||(LA122_0>=89 && LA122_0<=90)) ) {
                        alt122=1;
                    }
                    switch (alt122) {
                        case 1 :
                            // InternalNavascript.g:6963:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // InternalNavascript.g:6963:5: ( (lv_args_3_0= ruleExpression ) )
                            // InternalNavascript.g:6964:6: (lv_args_3_0= ruleExpression )
                            {
                            // InternalNavascript.g:6964:6: (lv_args_3_0= ruleExpression )
                            // InternalNavascript.g:6965:7: lv_args_3_0= ruleExpression
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

                            // InternalNavascript.g:6982:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            loop121:
                            do {
                                int alt121=2;
                                int LA121_0 = input.LA(1);

                                if ( (LA121_0==33) ) {
                                    alt121=1;
                                }


                                switch (alt121) {
                            	case 1 :
                            	    // InternalNavascript.g:6983:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,33,FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getMappableIdentifierAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalNavascript.g:6987:6: ( (lv_args_5_0= ruleExpression ) )
                            	    // InternalNavascript.g:6988:7: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // InternalNavascript.g:6988:7: (lv_args_5_0= ruleExpression )
                            	    // InternalNavascript.g:6989:8: lv_args_5_0= ruleExpression
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
                            	    break loop121;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getMappableIdentifierAccess().getRightParenthesisKeyword_2_2());
                      			
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
    // InternalNavascript.g:7017:1: entryRuleTmlIdentifier returns [EObject current=null] : iv_ruleTmlIdentifier= ruleTmlIdentifier EOF ;
    public final EObject entryRuleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmlIdentifier = null;


        try {
            // InternalNavascript.g:7017:54: (iv_ruleTmlIdentifier= ruleTmlIdentifier EOF )
            // InternalNavascript.g:7018:2: iv_ruleTmlIdentifier= ruleTmlIdentifier EOF
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
    // InternalNavascript.g:7024:1: ruleTmlIdentifier returns [EObject current=null] : ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) ;
    public final EObject ruleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_tml_1_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:7030:2: ( ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) )
            // InternalNavascript.g:7031:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            {
            // InternalNavascript.g:7031:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            // InternalNavascript.g:7032:3: () ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            {
            // InternalNavascript.g:7032:3: ()
            // InternalNavascript.g:7033:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTmlIdentifierAccess().getTmlIdentifierAction_0(),
              					current);
              			
            }

            }

            // InternalNavascript.g:7042:3: ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:7043:4: (lv_tml_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:7043:4: (lv_tml_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:7044:5: lv_tml_1_0= RULE_TML_LITERAL
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
    // InternalNavascript.g:7064:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // InternalNavascript.g:7064:53: (iv_rulePropertyType= rulePropertyType EOF )
            // InternalNavascript.g:7065:2: iv_rulePropertyType= rulePropertyType EOF
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
    // InternalNavascript.g:7071:1: rulePropertyType returns [EObject current=null] : ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) ;
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
            // InternalNavascript.g:7077:2: ( ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) )
            // InternalNavascript.g:7078:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            {
            // InternalNavascript.g:7078:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            int alt124=11;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt124=1;
                }
                break;
            case 93:
                {
                alt124=2;
                }
                break;
            case 94:
                {
                alt124=3;
                }
                break;
            case 95:
                {
                alt124=4;
                }
                break;
            case 96:
                {
                alt124=5;
                }
                break;
            case 97:
                {
                alt124=6;
                }
                break;
            case 98:
                {
                alt124=7;
                }
                break;
            case 99:
                {
                alt124=8;
                }
                break;
            case 100:
                {
                alt124=9;
                }
                break;
            case 101:
                {
                alt124=10;
                }
                break;
            case 102:
                {
                alt124=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalNavascript.g:7079:3: ( () otherlv_1= 'integer' )
                    {
                    // InternalNavascript.g:7079:3: ( () otherlv_1= 'integer' )
                    // InternalNavascript.g:7080:4: () otherlv_1= 'integer'
                    {
                    // InternalNavascript.g:7080:4: ()
                    // InternalNavascript.g:7081:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7096:3: ( () otherlv_3= 'string' )
                    {
                    // InternalNavascript.g:7096:3: ( () otherlv_3= 'string' )
                    // InternalNavascript.g:7097:4: () otherlv_3= 'string'
                    {
                    // InternalNavascript.g:7097:4: ()
                    // InternalNavascript.g:7098:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7113:3: ( () otherlv_5= 'boolean' )
                    {
                    // InternalNavascript.g:7113:3: ( () otherlv_5= 'boolean' )
                    // InternalNavascript.g:7114:4: () otherlv_5= 'boolean'
                    {
                    // InternalNavascript.g:7114:4: ()
                    // InternalNavascript.g:7115:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7130:3: ( () otherlv_7= 'date' )
                    {
                    // InternalNavascript.g:7130:3: ( () otherlv_7= 'date' )
                    // InternalNavascript.g:7131:4: () otherlv_7= 'date'
                    {
                    // InternalNavascript.g:7131:4: ()
                    // InternalNavascript.g:7132:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7147:3: ( () otherlv_9= 'float' )
                    {
                    // InternalNavascript.g:7147:3: ( () otherlv_9= 'float' )
                    // InternalNavascript.g:7148:4: () otherlv_9= 'float'
                    {
                    // InternalNavascript.g:7148:4: ()
                    // InternalNavascript.g:7149:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7164:3: ( () otherlv_11= 'binary' )
                    {
                    // InternalNavascript.g:7164:3: ( () otherlv_11= 'binary' )
                    // InternalNavascript.g:7165:4: () otherlv_11= 'binary'
                    {
                    // InternalNavascript.g:7165:4: ()
                    // InternalNavascript.g:7166:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7181:3: ( () otherlv_13= 'clocktime' )
                    {
                    // InternalNavascript.g:7181:3: ( () otherlv_13= 'clocktime' )
                    // InternalNavascript.g:7182:4: () otherlv_13= 'clocktime'
                    {
                    // InternalNavascript.g:7182:4: ()
                    // InternalNavascript.g:7183:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7198:3: ( () otherlv_15= 'memo' )
                    {
                    // InternalNavascript.g:7198:3: ( () otherlv_15= 'memo' )
                    // InternalNavascript.g:7199:4: () otherlv_15= 'memo'
                    {
                    // InternalNavascript.g:7199:4: ()
                    // InternalNavascript.g:7200:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7215:3: ( () otherlv_17= 'timestamp' )
                    {
                    // InternalNavascript.g:7215:3: ( () otherlv_17= 'timestamp' )
                    // InternalNavascript.g:7216:4: () otherlv_17= 'timestamp'
                    {
                    // InternalNavascript.g:7216:4: ()
                    // InternalNavascript.g:7217:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7232:3: ( () otherlv_19= 'percentage' )
                    {
                    // InternalNavascript.g:7232:3: ( () otherlv_19= 'percentage' )
                    // InternalNavascript.g:7233:4: () otherlv_19= 'percentage'
                    {
                    // InternalNavascript.g:7233:4: ()
                    // InternalNavascript.g:7234:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7249:3: ( () otherlv_21= 'selection' )
                    {
                    // InternalNavascript.g:7249:3: ( () otherlv_21= 'selection' )
                    // InternalNavascript.g:7250:4: () otherlv_21= 'selection'
                    {
                    // InternalNavascript.g:7250:4: ()
                    // InternalNavascript.g:7251:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
    // InternalNavascript.g:7269:1: entryRuleOPTION_TYPE returns [String current=null] : iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF ;
    public final String entryRuleOPTION_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOPTION_TYPE = null;


        try {
            // InternalNavascript.g:7269:51: (iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF )
            // InternalNavascript.g:7270:2: iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF
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
    // InternalNavascript.g:7276:1: ruleOPTION_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'name' | kw= 'value' | kw= 'selected' ) ;
    public final AntlrDatatypeRuleToken ruleOPTION_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:7282:2: ( (kw= 'name' | kw= 'value' | kw= 'selected' ) )
            // InternalNavascript.g:7283:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            {
            // InternalNavascript.g:7283:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            int alt125=3;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt125=1;
                }
                break;
            case 104:
                {
                alt125=2;
                }
                break;
            case 105:
                {
                alt125=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalNavascript.g:7284:3: kw= 'name'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getNameKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7290:3: kw= 'value'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getValueKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:7296:3: kw= 'selected'
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
    // InternalNavascript.g:7305:1: entryRuleMessageType returns [EObject current=null] : iv_ruleMessageType= ruleMessageType EOF ;
    public final EObject entryRuleMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageType = null;


        try {
            // InternalNavascript.g:7305:52: (iv_ruleMessageType= ruleMessageType EOF )
            // InternalNavascript.g:7306:2: iv_ruleMessageType= ruleMessageType EOF
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
    // InternalNavascript.g:7312:1: ruleMessageType returns [EObject current=null] : ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) ;
    public final EObject ruleMessageType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalNavascript.g:7318:2: ( ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) )
            // InternalNavascript.g:7319:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            {
            // InternalNavascript.g:7319:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            int alt126=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt126=1;
                }
                break;
            case 107:
                {
                alt126=2;
                }
                break;
            case 108:
                {
                alt126=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // InternalNavascript.g:7320:3: ( () otherlv_1= 'array' )
                    {
                    // InternalNavascript.g:7320:3: ( () otherlv_1= 'array' )
                    // InternalNavascript.g:7321:4: () otherlv_1= 'array'
                    {
                    // InternalNavascript.g:7321:4: ()
                    // InternalNavascript.g:7322:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7337:3: ( () otherlv_3= 'simple' )
                    {
                    // InternalNavascript.g:7337:3: ( () otherlv_3= 'simple' )
                    // InternalNavascript.g:7338:4: () otherlv_3= 'simple'
                    {
                    // InternalNavascript.g:7338:4: ()
                    // InternalNavascript.g:7339:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7354:3: ( () otherlv_5= 'arrayelement' )
                    {
                    // InternalNavascript.g:7354:3: ( () otherlv_5= 'arrayelement' )
                    // InternalNavascript.g:7355:4: () otherlv_5= 'arrayelement'
                    {
                    // InternalNavascript.g:7355:4: ()
                    // InternalNavascript.g:7356:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
    // InternalNavascript.g:7374:1: entryRuleMessageMode returns [EObject current=null] : iv_ruleMessageMode= ruleMessageMode EOF ;
    public final EObject entryRuleMessageMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageMode = null;


        try {
            // InternalNavascript.g:7374:52: (iv_ruleMessageMode= ruleMessageMode EOF )
            // InternalNavascript.g:7375:2: iv_ruleMessageMode= ruleMessageMode EOF
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
    // InternalNavascript.g:7381:1: ruleMessageMode returns [EObject current=null] : ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) ;
    public final EObject ruleMessageMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:7387:2: ( ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) )
            // InternalNavascript.g:7388:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            {
            // InternalNavascript.g:7388:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==109) ) {
                alt127=1;
            }
            else if ( (LA127_0==110) ) {
                alt127=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // InternalNavascript.g:7389:3: ( () otherlv_1= 'ignore' )
                    {
                    // InternalNavascript.g:7389:3: ( () otherlv_1= 'ignore' )
                    // InternalNavascript.g:7390:4: () otherlv_1= 'ignore'
                    {
                    // InternalNavascript.g:7390:4: ()
                    // InternalNavascript.g:7391:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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
                    // InternalNavascript.g:7406:3: ( () otherlv_3= 'overwrite' )
                    {
                    // InternalNavascript.g:7406:3: ( () otherlv_3= 'overwrite' )
                    // InternalNavascript.g:7407:4: () otherlv_3= 'overwrite'
                    {
                    // InternalNavascript.g:7407:4: ()
                    // InternalNavascript.g:7408:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
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

    // $ANTLR start synpred68_InternalNavascript
    public final void synpred68_InternalNavascript_fragment() throws RecognitionException {   
        EObject lv_statements_7_0 = null;


        // InternalNavascript.g:2606:6: ( ( (lv_statements_7_0= ruleInnerBody ) )* )
        // InternalNavascript.g:2606:6: ( (lv_statements_7_0= ruleInnerBody ) )*
        {
        // InternalNavascript.g:2606:6: ( (lv_statements_7_0= ruleInnerBody ) )*
        loop134:
        do {
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( ((LA134_0>=RULE_METHOD_IDENTIFIER && LA134_0<=RULE_MAPPABLE_IDENTIFIER)||LA134_0==26||LA134_0==28||LA134_0==42||LA134_0==48||(LA134_0>=50 && LA134_0<=51)||(LA134_0>=53 && LA134_0<=54)||(LA134_0>=56 && LA134_0<=58)||(LA134_0>=63 && LA134_0<=64)||(LA134_0>=66 && LA134_0<=68)) ) {
                alt134=1;
            }


            switch (alt134) {
        	case 1 :
        	    // InternalNavascript.g:2607:7: (lv_statements_7_0= ruleInnerBody )
        	    {
        	    // InternalNavascript.g:2607:7: (lv_statements_7_0= ruleInnerBody )
        	    // InternalNavascript.g:2608:8: lv_statements_7_0= ruleInnerBody
        	    {
        	    if ( state.backtracking==0 ) {

        	      								newCompositeNode(grammarAccess.getMessageAccess().getStatementsInnerBodyParserRuleCall_4_0_1_0_0());
        	      							
        	    }
        	    pushFollow(FOLLOW_73);
        	    lv_statements_7_0=ruleInnerBody();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop134;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred68_InternalNavascript

    // $ANTLR start synpred69_InternalNavascript
    public final void synpred69_InternalNavascript_fragment() throws RecognitionException {   
        EObject lv_arrayField_8_0 = null;


        // InternalNavascript.g:2626:6: ( ( (lv_arrayField_8_0= ruleMappedArrayField ) ) )
        // InternalNavascript.g:2626:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
        {
        // InternalNavascript.g:2626:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
        // InternalNavascript.g:2627:7: (lv_arrayField_8_0= ruleMappedArrayField )
        {
        // InternalNavascript.g:2627:7: (lv_arrayField_8_0= ruleMappedArrayField )
        // InternalNavascript.g:2628:8: lv_arrayField_8_0= ruleMappedArrayField
        {
        if ( state.backtracking==0 ) {

          								newCompositeNode(grammarAccess.getMessageAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_0_1_1_0());
          							
        }
        pushFollow(FOLLOW_2);
        lv_arrayField_8_0=ruleMappedArrayField();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred69_InternalNavascript

    // Delegated rules

    public final boolean synpred69_InternalNavascript() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalNavascript_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_InternalNavascript() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_InternalNavascript_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA41 dfa41 = new DFA41(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\10\4\uffff\1\0\20\uffff";
    static final String dfa_3s = "\1\104\4\uffff\1\0\20\uffff";
    static final String dfa_4s = "\1\uffff\1\1\22\uffff\1\3\1\2";
    static final String dfa_5s = "\5\uffff\1\0\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\5\1\24\17\uffff\1\1\1\uffff\2\1\14\uffff\1\1\5\uffff\1\1\1\uffff\2\1\1\uffff\2\1\1\uffff\3\1\4\uffff\2\1\1\uffff\3\1",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2605:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_5 = input.LA(1);

                         
                        int index41_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_InternalNavascript()) ) {s = 1;}

                        else if ( (synpred69_InternalNavascript()) ) {s = 21;}

                         
                        input.seek(index41_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x877D040054000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x876D040054000002L,0x0000000000000005L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000800FFE40L,0x0000000006400000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x876D040054000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x876D040054000300L,0x000000000000001DL});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x876D040074000300L,0x000000000000001DL});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000038400000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x876D040074000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000800FFE70L,0x0000000006400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000080080000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000700100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0002000024000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000600L,0x0000000004000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0800080090000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0800080010000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x876D040074000700L,0x000000000000001DL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x1000000010000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x00001C0000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000100000040L,0x0000038000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000040L,0x0000038000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000001890000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000840FFE70L,0x0000000006400000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0800001890000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0800001810000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000024000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x00001C7FF0000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0800081890000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800081810000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x2000200000000000L,0x0000000000001460L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000800L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000004000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x00000000000F0000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400800L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000400L,0x0000000004000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x00000001800FFE40L,0x0000000006400000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x876D040054000302L,0x000000000000001DL});

}