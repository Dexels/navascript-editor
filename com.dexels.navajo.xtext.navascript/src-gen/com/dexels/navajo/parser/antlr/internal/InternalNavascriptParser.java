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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_QUOTED_IDENTIFIER", "RULE_STRING_CONSTANT", "RULE_MAPPABLE_IDENTIFIER", "RULE_IDENTIFIER", "RULE_OBJECT_IDENTIFIER", "RULE_METHOD_IDENTIFIER", "RULE_TML_LITERAL", "RULE_INTEGER", "RULE_ONE", "RULE_FLOAT", "RULE_STRING_LITERAL", "RULE_TRUE", "RULE_FALSE", "RULE_NULL_DEF", "RULE_TODAY", "RULE_FORALL", "RULE_EXISTS", "RULE_MAPPABLE_ID", "RULE_UNDERSCORE", "RULE_LETTER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'if'", "'then'", "'{'", "'}'", "'@debug='", "'all'", "'request'", "'response'", "'synchronized'", "'('", "')'", "','", "'context'", "'='", "':'", "'user'", "'service'", "'key'", "'timeout'", "'breakOnNoLock'", "'break'", "';'", "'code'", "'description'", "'error'", "'validations'", "'define'", "'check'", "'print'", "'log'", "'finally'", "'methods'", "'loop'", "'filter'", "'include'", "'antimessage'", "'message'", "'['", "']'", "'type'", "'mode'", "'map.'", "'map'", "'object'", "'var'", "'property'", "'option'", "'length'", "'direction'", "'in'", "'out'", "'inout'", "'cardinality'", "'+'", "'subtype'", "'else'", "'OR'", "'AND'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'-'", "'*'", "'/'", "'!'", "'?'", "'`'", "'integer'", "'string'", "'boolean'", "'date'", "'float'", "'binary'", "'clocktime'", "'memo'", "'timestamp'", "'percentage'", "'selection'", "'name'", "'value'", "'selected'", "'array'", "'simple'", "'arrayelement'", "'ignore'", "'overwrite'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_TODAY=18;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_EXISTS=20;
    public static final int RULE_NULL_DEF=17;
    public static final int RULE_MAPPABLE_IDENTIFIER=6;
    public static final int RULE_METHOD_IDENTIFIER=9;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=24;
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
    public static final int RULE_LETTER=23;
    public static final int T__48=48;
    public static final int RULE_MAPPABLE_ID=21;
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
    public static final int RULE_UNDERSCORE=22;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_STRING_CONSTANT=5;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int RULE_ONE=12;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_IDENTIFIER=7;
    public static final int RULE_STRING_LITERAL=14;
    public static final int RULE_SL_COMMENT=25;
    public static final int RULE_FORALL=19;
    public static final int RULE_TML_LITERAL=10;
    public static final int T__77=77;
    public static final int RULE_TRUE=15;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=26;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int RULE_OBJECT_IDENTIFIER=8;
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
    // InternalNavascript.g:77:1: ruleNavascript returns [EObject current=null] : ( () ( (lv_debug_1_0= ruleDebugStatement ) )? ( (lv_validations_2_0= ruleValidations ) )? ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) ) ( (lv_finally_4_0= ruleFinally ) )? ) ;
    public final EObject ruleNavascript() throws RecognitionException {
        EObject current = null;

        EObject lv_debug_1_0 = null;

        EObject lv_validations_2_0 = null;

        EObject lv_toplevelStatements_3_0 = null;

        EObject lv_finally_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:83:2: ( ( () ( (lv_debug_1_0= ruleDebugStatement ) )? ( (lv_validations_2_0= ruleValidations ) )? ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) ) ( (lv_finally_4_0= ruleFinally ) )? ) )
            // InternalNavascript.g:84:2: ( () ( (lv_debug_1_0= ruleDebugStatement ) )? ( (lv_validations_2_0= ruleValidations ) )? ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) ) ( (lv_finally_4_0= ruleFinally ) )? )
            {
            // InternalNavascript.g:84:2: ( () ( (lv_debug_1_0= ruleDebugStatement ) )? ( (lv_validations_2_0= ruleValidations ) )? ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) ) ( (lv_finally_4_0= ruleFinally ) )? )
            // InternalNavascript.g:85:3: () ( (lv_debug_1_0= ruleDebugStatement ) )? ( (lv_validations_2_0= ruleValidations ) )? ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) ) ( (lv_finally_4_0= ruleFinally ) )?
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

            // InternalNavascript.g:95:3: ( (lv_debug_1_0= ruleDebugStatement ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==31) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalNavascript.g:96:4: (lv_debug_1_0= ruleDebugStatement )
                    {
                    // InternalNavascript.g:96:4: (lv_debug_1_0= ruleDebugStatement )
                    // InternalNavascript.g:97:5: lv_debug_1_0= ruleDebugStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNavascriptAccess().getDebugDebugStatementParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_3);
                    lv_debug_1_0=ruleDebugStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNavascriptRule());
                      					}
                      					set(
                      						current,
                      						"debug",
                      						lv_debug_1_0,
                      						"com.dexels.navajo.Navascript.DebugStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:114:3: ( (lv_validations_2_0= ruleValidations ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==52) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalNavascript.g:115:4: (lv_validations_2_0= ruleValidations )
                    {
                    // InternalNavascript.g:115:4: (lv_validations_2_0= ruleValidations )
                    // InternalNavascript.g:116:5: lv_validations_2_0= ruleValidations
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNavascriptAccess().getValidationsValidationsParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_4);
                    lv_validations_2_0=ruleValidations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNavascriptRule());
                      					}
                      					set(
                      						current,
                      						"validations",
                      						lv_validations_2_0,
                      						"com.dexels.navajo.Navascript.Validations");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:133:3: ( (lv_toplevelStatements_3_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:134:4: (lv_toplevelStatements_3_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:134:4: (lv_toplevelStatements_3_0= ruleTopLevelStatements )
            // InternalNavascript.g:135:5: lv_toplevelStatements_3_0= ruleTopLevelStatements
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNavascriptAccess().getToplevelStatementsTopLevelStatementsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_toplevelStatements_3_0=ruleTopLevelStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNavascriptRule());
              					}
              					set(
              						current,
              						"toplevelStatements",
              						lv_toplevelStatements_3_0,
              						"com.dexels.navajo.Navascript.TopLevelStatements");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalNavascript.g:152:3: ( (lv_finally_4_0= ruleFinally ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==57) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalNavascript.g:153:4: (lv_finally_4_0= ruleFinally )
                    {
                    // InternalNavascript.g:153:4: (lv_finally_4_0= ruleFinally )
                    // InternalNavascript.g:154:5: lv_finally_4_0= ruleFinally
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getNavascriptAccess().getFinallyFinallyParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_finally_4_0=ruleFinally();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getNavascriptRule());
                      					}
                      					set(
                      						current,
                      						"finally",
                      						lv_finally_4_0,
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
    // InternalNavascript.g:175:1: entryRuleTopLevelStatements returns [EObject current=null] : iv_ruleTopLevelStatements= ruleTopLevelStatements EOF ;
    public final EObject entryRuleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatements = null;


        try {
            // InternalNavascript.g:175:59: (iv_ruleTopLevelStatements= ruleTopLevelStatements EOF )
            // InternalNavascript.g:176:2: iv_ruleTopLevelStatements= ruleTopLevelStatements EOF
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
    // InternalNavascript.g:182:1: ruleTopLevelStatements returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) ;
    public final EObject ruleTopLevelStatements() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:188:2: ( ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* ) )
            // InternalNavascript.g:189:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            {
            // InternalNavascript.g:189:2: ( () ( (lv_statements_1_0= ruleTopLevelStatement ) )* )
            // InternalNavascript.g:190:3: () ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            {
            // InternalNavascript.g:190:3: ()
            // InternalNavascript.g:191:4: 
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

            // InternalNavascript.g:200:3: ( (lv_statements_1_0= ruleTopLevelStatement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==27||LA4_0==29||LA4_0==35||LA4_0==47||LA4_0==53||(LA4_0>=55 && LA4_0<=56)||(LA4_0>=58 && LA4_0<=59)||(LA4_0>=61 && LA4_0<=63)||(LA4_0>=68 && LA4_0<=69)||LA4_0==71) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalNavascript.g:201:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:201:4: (lv_statements_1_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:202:5: lv_statements_1_0= ruleTopLevelStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTopLevelStatementsAccess().getStatementsTopLevelStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
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
            	    break loop4;
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
    // InternalNavascript.g:223:1: entryRuleTopLevelStatement returns [EObject current=null] : iv_ruleTopLevelStatement= ruleTopLevelStatement EOF ;
    public final EObject entryRuleTopLevelStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelStatement = null;


        try {
            // InternalNavascript.g:223:58: (iv_ruleTopLevelStatement= ruleTopLevelStatement EOF )
            // InternalNavascript.g:224:2: iv_ruleTopLevelStatement= ruleTopLevelStatement EOF
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
    // InternalNavascript.g:230:1: ruleTopLevelStatement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) ;
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
            // InternalNavascript.g:236:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:237:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:237:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:238:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:238:3: ()
            // InternalNavascript.g:239:4: 
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

            // InternalNavascript.g:248:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalNavascript.g:249:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTopLevelStatementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:253:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:254:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:254:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:255:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTopLevelStatementAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_3=(Token)match(input,28,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTopLevelStatementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:277:3: ( ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) ) )
            // InternalNavascript.g:278:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            {
            // InternalNavascript.g:278:4: ( (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements ) )
            // InternalNavascript.g:279:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            {
            // InternalNavascript.g:279:5: (lv_statement_4_1= ruleMessage | lv_statement_4_2= ruleVar | lv_statement_4_3= ruleMap | lv_statement_4_4= ruleAntiMessage | lv_statement_4_5= ruleDefine | lv_statement_4_6= rulePrint | lv_statement_4_7= ruleLog | lv_statement_4_8= ruleLoop | lv_statement_4_9= ruleMethods | lv_statement_4_10= ruleInclude | lv_statement_4_11= ruleBreak | lv_statement_4_12= ruleSynchronized | lv_statement_4_13= ruleBlockStatements )
            int alt6=13;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt6=1;
                }
                break;
            case 71:
                {
                alt6=2;
                }
                break;
            case 68:
            case 69:
                {
                alt6=3;
                }
                break;
            case 62:
                {
                alt6=4;
                }
                break;
            case 53:
                {
                alt6=5;
                }
                break;
            case 55:
                {
                alt6=6;
                }
                break;
            case 56:
                {
                alt6=7;
                }
                break;
            case 59:
                {
                alt6=8;
                }
                break;
            case 58:
                {
                alt6=9;
                }
                break;
            case 61:
                {
                alt6=10;
                }
                break;
            case 47:
                {
                alt6=11;
                }
                break;
            case 35:
                {
                alt6=12;
                }
                break;
            case 29:
                {
                alt6=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalNavascript.g:280:6: lv_statement_4_1= ruleMessage
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
                    // InternalNavascript.g:296:6: lv_statement_4_2= ruleVar
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
                    // InternalNavascript.g:312:6: lv_statement_4_3= ruleMap
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
                    // InternalNavascript.g:328:6: lv_statement_4_4= ruleAntiMessage
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
                    // InternalNavascript.g:344:6: lv_statement_4_5= ruleDefine
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
                    // InternalNavascript.g:360:6: lv_statement_4_6= rulePrint
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
                    // InternalNavascript.g:376:6: lv_statement_4_7= ruleLog
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
                    // InternalNavascript.g:392:6: lv_statement_4_8= ruleLoop
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
                    // InternalNavascript.g:408:6: lv_statement_4_9= ruleMethods
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
                    // InternalNavascript.g:424:6: lv_statement_4_10= ruleInclude
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
                    // InternalNavascript.g:440:6: lv_statement_4_11= ruleBreak
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
                    // InternalNavascript.g:456:6: lv_statement_4_12= ruleSynchronized
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
                    // InternalNavascript.g:472:6: lv_statement_4_13= ruleBlockStatements
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
    // InternalNavascript.g:494:1: entryRuleInnerBody returns [EObject current=null] : iv_ruleInnerBody= ruleInnerBody EOF ;
    public final EObject entryRuleInnerBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInnerBody = null;


        try {
            // InternalNavascript.g:494:50: (iv_ruleInnerBody= ruleInnerBody EOF )
            // InternalNavascript.g:495:2: iv_ruleInnerBody= ruleInnerBody EOF
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
    // InternalNavascript.g:501:1: ruleInnerBody returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) ;
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
            // InternalNavascript.g:507:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) ) )
            // InternalNavascript.g:508:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            {
            // InternalNavascript.g:508:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) ) )
            // InternalNavascript.g:509:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            {
            // InternalNavascript.g:509:3: ()
            // InternalNavascript.g:510:4: 
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

            // InternalNavascript.g:519:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalNavascript.g:520:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInnerBodyAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:524:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:525:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:525:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:526:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInnerBodyAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_3=(Token)match(input,28,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getInnerBodyAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:548:3: ( ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) ) )
            // InternalNavascript.g:549:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            {
            // InternalNavascript.g:549:4: ( (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements ) )
            // InternalNavascript.g:550:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            {
            // InternalNavascript.g:550:5: (lv_statement_4_1= ruleProperty | lv_statement_4_2= ruleOption | lv_statement_4_3= ruleMethodOrSetter | lv_statement_4_4= ruleMessage | lv_statement_4_5= ruleAntiMessage | lv_statement_4_6= ruleInclude | lv_statement_4_7= ruleMethods | lv_statement_4_8= ruleVar | lv_statement_4_9= rulePrint | lv_statement_4_10= ruleLog | lv_statement_4_11= ruleDefine | lv_statement_4_12= ruleLoop | lv_statement_4_13= ruleMap | lv_statement_4_14= ruleBreak | lv_statement_4_15= ruleBlockStatements )
            int alt8=15;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt8=1;
                }
                break;
            case 73:
                {
                alt8=2;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
            case RULE_METHOD_IDENTIFIER:
                {
                alt8=3;
                }
                break;
            case 63:
                {
                alt8=4;
                }
                break;
            case 62:
                {
                alt8=5;
                }
                break;
            case 61:
                {
                alt8=6;
                }
                break;
            case 58:
                {
                alt8=7;
                }
                break;
            case 71:
                {
                alt8=8;
                }
                break;
            case 55:
                {
                alt8=9;
                }
                break;
            case 56:
                {
                alt8=10;
                }
                break;
            case 53:
                {
                alt8=11;
                }
                break;
            case 59:
                {
                alt8=12;
                }
                break;
            case 68:
            case 69:
                {
                alt8=13;
                }
                break;
            case 47:
                {
                alt8=14;
                }
                break;
            case 29:
                {
                alt8=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalNavascript.g:551:6: lv_statement_4_1= ruleProperty
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
                    // InternalNavascript.g:567:6: lv_statement_4_2= ruleOption
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
                    // InternalNavascript.g:583:6: lv_statement_4_3= ruleMethodOrSetter
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
                    // InternalNavascript.g:599:6: lv_statement_4_4= ruleMessage
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
                    // InternalNavascript.g:615:6: lv_statement_4_5= ruleAntiMessage
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
                    // InternalNavascript.g:631:6: lv_statement_4_6= ruleInclude
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
                    // InternalNavascript.g:647:6: lv_statement_4_7= ruleMethods
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
                    // InternalNavascript.g:663:6: lv_statement_4_8= ruleVar
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
                    // InternalNavascript.g:679:6: lv_statement_4_9= rulePrint
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
                    // InternalNavascript.g:695:6: lv_statement_4_10= ruleLog
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
                    // InternalNavascript.g:711:6: lv_statement_4_11= ruleDefine
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
                    // InternalNavascript.g:727:6: lv_statement_4_12= ruleLoop
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
                    // InternalNavascript.g:743:6: lv_statement_4_13= ruleMap
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
                    // InternalNavascript.g:759:6: lv_statement_4_14= ruleBreak
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
                    // InternalNavascript.g:775:6: lv_statement_4_15= ruleBlockStatements
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
    // InternalNavascript.g:797:1: entryRuleBlockStatements returns [EObject current=null] : iv_ruleBlockStatements= ruleBlockStatements EOF ;
    public final EObject entryRuleBlockStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatements = null;


        try {
            // InternalNavascript.g:797:56: (iv_ruleBlockStatements= ruleBlockStatements EOF )
            // InternalNavascript.g:798:2: iv_ruleBlockStatements= ruleBlockStatements EOF
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
    // InternalNavascript.g:804:1: ruleBlockStatements returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlockStatements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:810:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:811:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:811:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:812:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:812:3: ()
            // InternalNavascript.g:813:4: 
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

            otherlv_1=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockStatementsAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:826:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_MAPPABLE_IDENTIFIER||LA9_0==RULE_METHOD_IDENTIFIER||LA9_0==27||LA9_0==29||LA9_0==47||LA9_0==53||(LA9_0>=55 && LA9_0<=56)||(LA9_0>=58 && LA9_0<=59)||(LA9_0>=61 && LA9_0<=63)||(LA9_0>=68 && LA9_0<=69)||(LA9_0>=71 && LA9_0<=73)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalNavascript.g:827:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:827:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:828:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockStatementsAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop9;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDebugStatement"
    // InternalNavascript.g:853:1: entryRuleDebugStatement returns [EObject current=null] : iv_ruleDebugStatement= ruleDebugStatement EOF ;
    public final EObject entryRuleDebugStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDebugStatement = null;


        try {
            // InternalNavascript.g:853:55: (iv_ruleDebugStatement= ruleDebugStatement EOF )
            // InternalNavascript.g:854:2: iv_ruleDebugStatement= ruleDebugStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDebugStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDebugStatement=ruleDebugStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDebugStatement; 
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
    // $ANTLR end "entryRuleDebugStatement"


    // $ANTLR start "ruleDebugStatement"
    // InternalNavascript.g:860:1: ruleDebugStatement returns [EObject current=null] : ( () otherlv_1= '@debug=' ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) ) ) ;
    public final EObject ruleDebugStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:866:2: ( ( () otherlv_1= '@debug=' ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) ) ) )
            // InternalNavascript.g:867:2: ( () otherlv_1= '@debug=' ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) ) )
            {
            // InternalNavascript.g:867:2: ( () otherlv_1= '@debug=' ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) ) )
            // InternalNavascript.g:868:3: () otherlv_1= '@debug=' ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) )
            {
            // InternalNavascript.g:868:3: ()
            // InternalNavascript.g:869:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDebugStatementAccess().getDebugStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDebugStatementAccess().getDebugKeyword_1());
              		
            }
            // InternalNavascript.g:882:3: ( ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) ) )
            // InternalNavascript.g:883:4: ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) )
            {
            // InternalNavascript.g:883:4: ( (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' ) )
            // InternalNavascript.g:884:5: (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' )
            {
            // InternalNavascript.g:884:5: (lv_value_2_1= 'all' | lv_value_2_2= 'request' | lv_value_2_3= 'response' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt10=1;
                }
                break;
            case 33:
                {
                alt10=2;
                }
                break;
            case 34:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalNavascript.g:885:6: lv_value_2_1= 'all'
                    {
                    lv_value_2_1=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_1, grammarAccess.getDebugStatementAccess().getValueAllKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDebugStatementRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:896:6: lv_value_2_2= 'request'
                    {
                    lv_value_2_2=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_2, grammarAccess.getDebugStatementAccess().getValueRequestKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDebugStatementRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_2_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:907:6: lv_value_2_3= 'response'
                    {
                    lv_value_2_3=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_3, grammarAccess.getDebugStatementAccess().getValueResponseKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDebugStatementRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_2_3, null);
                      					
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
    // $ANTLR end "ruleDebugStatement"


    // $ANTLR start "entryRuleSynchronized"
    // InternalNavascript.g:924:1: entryRuleSynchronized returns [EObject current=null] : iv_ruleSynchronized= ruleSynchronized EOF ;
    public final EObject entryRuleSynchronized() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronized = null;


        try {
            // InternalNavascript.g:924:53: (iv_ruleSynchronized= ruleSynchronized EOF )
            // InternalNavascript.g:925:2: iv_ruleSynchronized= ruleSynchronized EOF
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
    // InternalNavascript.g:931:1: ruleSynchronized returns [EObject current=null] : (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) ;
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
            // InternalNavascript.g:937:2: ( (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' ) )
            // InternalNavascript.g:938:2: (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            {
            // InternalNavascript.g:938:2: (otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}' )
            // InternalNavascript.g:939:3: otherlv_0= 'synchronized' otherlv_1= '(' ( (lv_arguments_2_0= ruleSynchronizedArguments ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_statements_5_0= ruleTopLevelStatement ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSynchronizedAccess().getSynchronizedKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,36,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSynchronizedAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:947:3: ( (lv_arguments_2_0= ruleSynchronizedArguments ) )
            // InternalNavascript.g:948:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            {
            // InternalNavascript.g:948:4: (lv_arguments_2_0= ruleSynchronizedArguments )
            // InternalNavascript.g:949:5: lv_arguments_2_0= ruleSynchronizedArguments
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSynchronizedAccess().getArgumentsSynchronizedArgumentsParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_3=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSynchronizedAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSynchronizedAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:974:3: ( (lv_statements_5_0= ruleTopLevelStatement ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27||LA11_0==29||LA11_0==35||LA11_0==47||LA11_0==53||(LA11_0>=55 && LA11_0<=56)||(LA11_0>=58 && LA11_0<=59)||(LA11_0>=61 && LA11_0<=63)||(LA11_0>=68 && LA11_0<=69)||LA11_0==71) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalNavascript.g:975:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    {
            	    // InternalNavascript.g:975:4: (lv_statements_5_0= ruleTopLevelStatement )
            	    // InternalNavascript.g:976:5: lv_statements_5_0= ruleTopLevelStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSynchronizedAccess().getStatementsTopLevelStatementParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_17);
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
            	    break loop11;
                }
            } while (true);

            otherlv_6=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1001:1: entryRuleSynchronizedArguments returns [EObject current=null] : iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF ;
    public final EObject entryRuleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArguments = null;


        try {
            // InternalNavascript.g:1001:62: (iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF )
            // InternalNavascript.g:1002:2: iv_ruleSynchronizedArguments= ruleSynchronizedArguments EOF
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
    // InternalNavascript.g:1008:1: ruleSynchronizedArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) ;
    public final EObject ruleSynchronizedArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1014:2: ( ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* ) )
            // InternalNavascript.g:1015:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            {
            // InternalNavascript.g:1015:2: ( ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )* )
            // InternalNavascript.g:1016:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            {
            // InternalNavascript.g:1016:3: ( (lv_arguments_0_0= ruleSynchronizedArgument ) )
            // InternalNavascript.g:1017:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            {
            // InternalNavascript.g:1017:4: (lv_arguments_0_0= ruleSynchronizedArgument )
            // InternalNavascript.g:1018:5: lv_arguments_0_0= ruleSynchronizedArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSynchronizedArgumentsAccess().getArgumentsSynchronizedArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:1035:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==38) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalNavascript.g:1036:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSynchronizedArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:1040:4: ( (lv_arguments_2_0= ruleSynchronizedArgument ) )
            	    // InternalNavascript.g:1041:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    {
            	    // InternalNavascript.g:1041:5: (lv_arguments_2_0= ruleSynchronizedArgument )
            	    // InternalNavascript.g:1042:6: lv_arguments_2_0= ruleSynchronizedArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSynchronizedArgumentsAccess().getArgumentsSynchronizedArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop12;
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
    // InternalNavascript.g:1064:1: entryRuleSynchronizedArgument returns [EObject current=null] : iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF ;
    public final EObject entryRuleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynchronizedArgument = null;


        try {
            // InternalNavascript.g:1064:61: (iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF )
            // InternalNavascript.g:1065:2: iv_ruleSynchronizedArgument= ruleSynchronizedArgument EOF
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
    // InternalNavascript.g:1071:1: ruleSynchronizedArgument returns [EObject current=null] : ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) ;
    public final EObject ruleSynchronizedArgument() throws RecognitionException {
        EObject current = null;

        EObject this_SKey_2 = null;

        EObject this_STimeout_3 = null;

        EObject this_SBreakOnNoLock_4 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1077:2: ( ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock ) )
            // InternalNavascript.g:1078:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            {
            // InternalNavascript.g:1078:2: ( ( () ruleSContext ) | this_SKey_2= ruleSKey | this_STimeout_3= ruleSTimeout | this_SBreakOnNoLock_4= ruleSBreakOnNoLock )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt13=1;
                }
                break;
            case 44:
                {
                alt13=2;
                }
                break;
            case 45:
                {
                alt13=3;
                }
                break;
            case 46:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalNavascript.g:1079:3: ( () ruleSContext )
                    {
                    // InternalNavascript.g:1079:3: ( () ruleSContext )
                    // InternalNavascript.g:1080:4: () ruleSContext
                    {
                    // InternalNavascript.g:1080:4: ()
                    // InternalNavascript.g:1081:5: 
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
                    // InternalNavascript.g:1102:3: this_SKey_2= ruleSKey
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
                    // InternalNavascript.g:1114:3: this_STimeout_3= ruleSTimeout
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
                    // InternalNavascript.g:1126:3: this_SBreakOnNoLock_4= ruleSBreakOnNoLock
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
    // InternalNavascript.g:1141:1: entryRuleSContext returns [String current=null] : iv_ruleSContext= ruleSContext EOF ;
    public final String entryRuleSContext() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSContext = null;


        try {
            // InternalNavascript.g:1141:48: (iv_ruleSContext= ruleSContext EOF )
            // InternalNavascript.g:1142:2: iv_ruleSContext= ruleSContext EOF
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
    // InternalNavascript.g:1148:1: ruleSContext returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) ) ;
    public final AntlrDatatypeRuleToken ruleSContext() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:1154:2: ( (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) ) )
            // InternalNavascript.g:1155:2: (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) )
            {
            // InternalNavascript.g:1155:2: (kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' ) )
            // InternalNavascript.g:1156:3: kw= 'context' (kw= '=' | kw= ':' ) (kw= 'user' | kw= 'service' )
            {
            kw=(Token)match(input,39,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getSContextAccess().getContextKeyword_0());
              		
            }
            // InternalNavascript.g:1161:3: (kw= '=' | kw= ':' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==40) ) {
                alt14=1;
            }
            else if ( (LA14_0==41) ) {
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
                    // InternalNavascript.g:1162:4: kw= '='
                    {
                    kw=(Token)match(input,40,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1168:4: kw= ':'
                    {
                    kw=(Token)match(input,41,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1174:3: (kw= 'user' | kw= 'service' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==42) ) {
                alt15=1;
            }
            else if ( (LA15_0==43) ) {
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
                    // InternalNavascript.g:1175:4: kw= 'user'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getSContextAccess().getUserKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1181:4: kw= 'service'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1191:1: entryRuleSKey returns [EObject current=null] : iv_ruleSKey= ruleSKey EOF ;
    public final EObject entryRuleSKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSKey = null;


        try {
            // InternalNavascript.g:1191:45: (iv_ruleSKey= ruleSKey EOF )
            // InternalNavascript.g:1192:2: iv_ruleSKey= ruleSKey EOF
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
    // InternalNavascript.g:1198:1: ruleSKey returns [EObject current=null] : (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression ) ;
    public final EObject ruleSKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_LiteralOrExpression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1204:2: ( (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression ) )
            // InternalNavascript.g:1205:2: (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:1205:2: (otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression )
            // InternalNavascript.g:1206:3: otherlv_0= 'key' (otherlv_1= '=' | otherlv_2= ':' ) this_LiteralOrExpression_3= ruleLiteralOrExpression
            {
            otherlv_0=(Token)match(input,44,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSKeyAccess().getKeyKeyword_0());
              		
            }
            // InternalNavascript.g:1210:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==40) ) {
                alt16=1;
            }
            else if ( (LA16_0==41) ) {
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
                    otherlv_1=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSKeyAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1216:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
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
    // InternalNavascript.g:1236:1: entryRuleSTimeout returns [EObject current=null] : iv_ruleSTimeout= ruleSTimeout EOF ;
    public final EObject entryRuleSTimeout() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTimeout = null;


        try {
            // InternalNavascript.g:1236:49: (iv_ruleSTimeout= ruleSTimeout EOF )
            // InternalNavascript.g:1237:2: iv_ruleSTimeout= ruleSTimeout EOF
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
    // InternalNavascript.g:1243:1: ruleSTimeout returns [EObject current=null] : (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSTimeout() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1249:2: ( (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1250:2: (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1250:2: (otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1251:3: otherlv_0= 'timeout' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            otherlv_0=(Token)match(input,45,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSTimeoutAccess().getTimeoutKeyword_0());
              		
            }
            // InternalNavascript.g:1255:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==40) ) {
                alt17=1;
            }
            else if ( (LA17_0==41) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalNavascript.g:1256:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSTimeoutAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1261:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
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
    // InternalNavascript.g:1281:1: entryRuleSBreakOnNoLock returns [EObject current=null] : iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF ;
    public final EObject entryRuleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSBreakOnNoLock = null;


        try {
            // InternalNavascript.g:1281:55: (iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF )
            // InternalNavascript.g:1282:2: iv_ruleSBreakOnNoLock= ruleSBreakOnNoLock EOF
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
    // InternalNavascript.g:1288:1: ruleSBreakOnNoLock returns [EObject current=null] : (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) ;
    public final EObject ruleSBreakOnNoLock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_Expression_3 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1294:2: ( (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression ) )
            // InternalNavascript.g:1295:2: (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            {
            // InternalNavascript.g:1295:2: (otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression )
            // InternalNavascript.g:1296:3: otherlv_0= 'breakOnNoLock' (otherlv_1= '=' | otherlv_2= ':' ) this_Expression_3= ruleExpression
            {
            otherlv_0=(Token)match(input,46,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSBreakOnNoLockAccess().getBreakOnNoLockKeyword_0());
              		
            }
            // InternalNavascript.g:1300:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            else if ( (LA18_0==41) ) {
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
                    // InternalNavascript.g:1301:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSBreakOnNoLockAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1306:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
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
    // InternalNavascript.g:1326:1: entryRuleBreak returns [EObject current=null] : iv_ruleBreak= ruleBreak EOF ;
    public final EObject entryRuleBreak() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreak = null;


        try {
            // InternalNavascript.g:1326:46: (iv_ruleBreak= ruleBreak EOF )
            // InternalNavascript.g:1327:2: iv_ruleBreak= ruleBreak EOF
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
    // InternalNavascript.g:1333:1: ruleBreak returns [EObject current=null] : ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' ) ;
    public final EObject ruleBreak() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_parameters_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1339:2: ( ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' ) )
            // InternalNavascript.g:1340:2: ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' )
            {
            // InternalNavascript.g:1340:2: ( () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';' )
            // InternalNavascript.g:1341:3: () otherlv_1= 'break' (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )? otherlv_5= ';'
            {
            // InternalNavascript.g:1341:3: ()
            // InternalNavascript.g:1342:4: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBreakAccess().getBreakKeyword_1());
              		
            }
            // InternalNavascript.g:1355:3: (otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalNavascript.g:1356:4: otherlv_2= '(' ( (lv_parameters_3_0= ruleBreakParameters ) )? otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBreakAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:1360:4: ( (lv_parameters_3_0= ruleBreakParameters ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=49 && LA19_0<=51)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalNavascript.g:1361:5: (lv_parameters_3_0= ruleBreakParameters )
                            {
                            // InternalNavascript.g:1361:5: (lv_parameters_3_0= ruleBreakParameters )
                            // InternalNavascript.g:1362:6: lv_parameters_3_0= ruleBreakParameters
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getBreakAccess().getParametersBreakParametersParserRuleCall_2_1_0());
                              					
                            }
                            pushFollow(FOLLOW_15);
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

                    otherlv_4=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBreakAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1392:1: entryRuleBreakParameter returns [EObject current=null] : iv_ruleBreakParameter= ruleBreakParameter EOF ;
    public final EObject entryRuleBreakParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameter = null;


        try {
            // InternalNavascript.g:1392:55: (iv_ruleBreakParameter= ruleBreakParameter EOF )
            // InternalNavascript.g:1393:2: iv_ruleBreakParameter= ruleBreakParameter EOF
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
    // InternalNavascript.g:1399:1: ruleBreakParameter returns [EObject current=null] : ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) ;
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
            // InternalNavascript.g:1405:2: ( ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:1406:2: ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:1406:2: ( (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) ) | (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) ) | (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt24=1;
                }
                break;
            case 50:
                {
                alt24=2;
                }
                break;
            case 51:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalNavascript.g:1407:3: (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1407:3: (otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1408:4: otherlv_0= 'code' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getBreakParameterAccess().getCodeKeyword_0_0());
                      			
                    }
                    // InternalNavascript.g:1412:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==40) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==41) ) {
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
                            // InternalNavascript.g:1413:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1418:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getBreakParameterAccess().getColonKeyword_0_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1423:4: ( (lv_code_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1424:5: (lv_code_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1424:5: (lv_code_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1425:6: lv_code_3_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1444:3: (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1444:3: (otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1445:4: otherlv_4= 'description' (otherlv_5= '=' | otherlv_6= ':' ) ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_4=(Token)match(input,50,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBreakParameterAccess().getDescriptionKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1449:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==40) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==41) ) {
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
                            // InternalNavascript.g:1450:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1455:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getBreakParameterAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1460:4: ( (lv_description_7_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1461:5: (lv_description_7_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1461:5: (lv_description_7_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1462:6: lv_description_7_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1481:3: (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1481:3: (otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression )
                    // InternalNavascript.g:1482:4: otherlv_8= 'error' (otherlv_9= '=' | otherlv_10= ':' ) this_LiteralOrExpression_11= ruleLiteralOrExpression
                    {
                    otherlv_8=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getBreakParameterAccess().getErrorKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:1486:4: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==40) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==41) ) {
                        alt23=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalNavascript.g:1487:5: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getBreakParameterAccess().getEqualsSignKeyword_2_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1492:5: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
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
    // InternalNavascript.g:1513:1: entryRuleBreakParameters returns [EObject current=null] : iv_ruleBreakParameters= ruleBreakParameters EOF ;
    public final EObject entryRuleBreakParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakParameters = null;


        try {
            // InternalNavascript.g:1513:56: (iv_ruleBreakParameters= ruleBreakParameters EOF )
            // InternalNavascript.g:1514:2: iv_ruleBreakParameters= ruleBreakParameters EOF
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
    // InternalNavascript.g:1520:1: ruleBreakParameters returns [EObject current=null] : ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) ;
    public final EObject ruleBreakParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_parameters_0_0 = null;

        EObject lv_parameters_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1526:2: ( ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* ) )
            // InternalNavascript.g:1527:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            {
            // InternalNavascript.g:1527:2: ( ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )* )
            // InternalNavascript.g:1528:3: ( (lv_parameters_0_0= ruleBreakParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            {
            // InternalNavascript.g:1528:3: ( (lv_parameters_0_0= ruleBreakParameter ) )
            // InternalNavascript.g:1529:4: (lv_parameters_0_0= ruleBreakParameter )
            {
            // InternalNavascript.g:1529:4: (lv_parameters_0_0= ruleBreakParameter )
            // InternalNavascript.g:1530:5: lv_parameters_0_0= ruleBreakParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBreakParametersAccess().getParametersBreakParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:1547:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalNavascript.g:1548:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getBreakParametersAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:1552:4: ( (lv_parameters_2_0= ruleBreakParameter ) )
            	    // InternalNavascript.g:1553:5: (lv_parameters_2_0= ruleBreakParameter )
            	    {
            	    // InternalNavascript.g:1553:5: (lv_parameters_2_0= ruleBreakParameter )
            	    // InternalNavascript.g:1554:6: lv_parameters_2_0= ruleBreakParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBreakParametersAccess().getParametersBreakParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop25;
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
    // InternalNavascript.g:1576:1: entryRuleValidations returns [EObject current=null] : iv_ruleValidations= ruleValidations EOF ;
    public final EObject entryRuleValidations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidations = null;


        try {
            // InternalNavascript.g:1576:52: (iv_ruleValidations= ruleValidations EOF )
            // InternalNavascript.g:1577:2: iv_ruleValidations= ruleValidations EOF
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
    // InternalNavascript.g:1583:1: ruleValidations returns [EObject current=null] : ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) ;
    public final EObject ruleValidations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_checks_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1589:2: ( ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:1590:2: ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:1590:2: ( () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}' )
            // InternalNavascript.g:1591:3: () otherlv_1= 'validations' otherlv_2= '{' ( (lv_checks_3_0= ruleCheck ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:1591:3: ()
            // InternalNavascript.g:1592:4: 
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

            otherlv_1=(Token)match(input,52,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getValidationsAccess().getValidationsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,29,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getValidationsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:1609:3: ( (lv_checks_3_0= ruleCheck ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==27||LA26_0==54) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalNavascript.g:1610:4: (lv_checks_3_0= ruleCheck )
            	    {
            	    // InternalNavascript.g:1610:4: (lv_checks_3_0= ruleCheck )
            	    // InternalNavascript.g:1611:5: lv_checks_3_0= ruleCheck
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getValidationsAccess().getChecksCheckParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_26);
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
            	    break loop26;
                }
            } while (true);

            otherlv_4=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1636:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // InternalNavascript.g:1636:47: (iv_ruleDefine= ruleDefine EOF )
            // InternalNavascript.g:1637:2: iv_ruleDefine= ruleDefine EOF
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
    // InternalNavascript.g:1643:1: ruleDefine returns [EObject current=null] : ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) ;
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
            // InternalNavascript.g:1649:2: ( ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' ) )
            // InternalNavascript.g:1650:2: ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            {
            // InternalNavascript.g:1650:2: ( () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';' )
            // InternalNavascript.g:1651:3: () otherlv_1= 'define' ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '=' | otherlv_4= ':' ) ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= ';'
            {
            // InternalNavascript.g:1651:3: ()
            // InternalNavascript.g:1652:4: 
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

            otherlv_1=(Token)match(input,53,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDefineAccess().getDefineKeyword_1());
              		
            }
            // InternalNavascript.g:1665:3: ( (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:1666:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:1666:4: (lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:1667:5: lv_defineKey_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_defineKey_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_19); if (state.failed) return current;
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

            // InternalNavascript.g:1683:3: (otherlv_3= '=' | otherlv_4= ':' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            else if ( (LA27_0==41) ) {
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
                    // InternalNavascript.g:1684:4: otherlv_3= '='
                    {
                    otherlv_3=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDefineAccess().getEqualsSignKeyword_3_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1689:4: otherlv_4= ':'
                    {
                    otherlv_4=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getDefineAccess().getColonKeyword_3_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1694:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalNavascript.g:1695:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalNavascript.g:1695:4: (lv_expression_5_0= ruleExpression )
            // InternalNavascript.g:1696:5: lv_expression_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefineAccess().getExpressionExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            otherlv_6=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1721:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // InternalNavascript.g:1721:46: (iv_ruleCheck= ruleCheck EOF )
            // InternalNavascript.g:1722:2: iv_ruleCheck= ruleCheck EOF
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
    // InternalNavascript.g:1728:1: ruleCheck returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) ;
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
            // InternalNavascript.g:1734:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' ) )
            // InternalNavascript.g:1735:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            {
            // InternalNavascript.g:1735:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';' )
            // InternalNavascript.g:1736:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? otherlv_4= 'check' otherlv_5= '(' ( (lv_checkAttributes_6_0= ruleCheckAttribute ) ) (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )? otherlv_9= ')' (otherlv_10= '=' | otherlv_11= ':' ) ( (lv_expression_12_0= ruleExpression ) ) otherlv_13= ';'
            {
            // InternalNavascript.g:1736:3: ()
            // InternalNavascript.g:1737:4: 
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

            // InternalNavascript.g:1746:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==27) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalNavascript.g:1747:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCheckAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1751:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:1752:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:1752:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:1753:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_3=(Token)match(input,28,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCheckAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,54,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getCheckAccess().getCheckKeyword_2());
              		
            }
            otherlv_5=(Token)match(input,36,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCheckAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalNavascript.g:1783:3: ( (lv_checkAttributes_6_0= ruleCheckAttribute ) )
            // InternalNavascript.g:1784:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            {
            // InternalNavascript.g:1784:4: (lv_checkAttributes_6_0= ruleCheckAttribute )
            // InternalNavascript.g:1785:5: lv_checkAttributes_6_0= ruleCheckAttribute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckAccess().getCheckAttributesCheckAttributeParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalNavascript.g:1802:3: (otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalNavascript.g:1803:4: otherlv_7= ',' ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getCheckAccess().getCommaKeyword_5_0());
                      			
                    }
                    // InternalNavascript.g:1807:4: ( (lv_checkAttributes_8_0= ruleCheckAttribute ) )
                    // InternalNavascript.g:1808:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    {
                    // InternalNavascript.g:1808:5: (lv_checkAttributes_8_0= ruleCheckAttribute )
                    // InternalNavascript.g:1809:6: lv_checkAttributes_8_0= ruleCheckAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCheckAccess().getCheckAttributesCheckAttributeParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

            otherlv_9=(Token)match(input,37,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getCheckAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalNavascript.g:1831:3: (otherlv_10= '=' | otherlv_11= ':' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==40) ) {
                alt30=1;
            }
            else if ( (LA30_0==41) ) {
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
                    // InternalNavascript.g:1832:4: otherlv_10= '='
                    {
                    otherlv_10=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getCheckAccess().getEqualsSignKeyword_7_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:1837:4: otherlv_11= ':'
                    {
                    otherlv_11=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCheckAccess().getColonKeyword_7_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:1842:3: ( (lv_expression_12_0= ruleExpression ) )
            // InternalNavascript.g:1843:4: (lv_expression_12_0= ruleExpression )
            {
            // InternalNavascript.g:1843:4: (lv_expression_12_0= ruleExpression )
            // InternalNavascript.g:1844:5: lv_expression_12_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckAccess().getExpressionExpressionParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            otherlv_13=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:1869:1: entryRuleCheckAttribute returns [EObject current=null] : iv_ruleCheckAttribute= ruleCheckAttribute EOF ;
    public final EObject entryRuleCheckAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckAttribute = null;


        try {
            // InternalNavascript.g:1869:55: (iv_ruleCheckAttribute= ruleCheckAttribute EOF )
            // InternalNavascript.g:1870:2: iv_ruleCheckAttribute= ruleCheckAttribute EOF
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
    // InternalNavascript.g:1876:1: ruleCheckAttribute returns [EObject current=null] : ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) ;
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
            // InternalNavascript.g:1882:2: ( ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) ) )
            // InternalNavascript.g:1883:2: ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            {
            // InternalNavascript.g:1883:2: ( ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ) | (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==49) ) {
                alt33=1;
            }
            else if ( (LA33_0==50) ) {
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
                    // InternalNavascript.g:1884:3: ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    {
                    // InternalNavascript.g:1884:3: ( () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
                    // InternalNavascript.g:1885:4: () (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1885:4: ()
                    // InternalNavascript.g:1886:5: 
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

                    // InternalNavascript.g:1895:4: (otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1896:5: otherlv_1= 'code' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getCheckAttributeAccess().getCodeKeyword_0_1_0());
                      				
                    }
                    // InternalNavascript.g:1900:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==40) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==41) ) {
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
                            // InternalNavascript.g:1901:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_0_1_1_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1906:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getCheckAttributeAccess().getColonKeyword_0_1_1_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1911:5: ( (lv_value_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1912:6: (lv_value_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1912:6: (lv_value_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1913:7: lv_value_4_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:1933:3: (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:1933:3: (otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:1934:4: otherlv_5= 'description' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getCheckAttributeAccess().getDescriptionKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:1938:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==40) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==41) ) {
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
                            // InternalNavascript.g:1939:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getCheckAttributeAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:1944:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getCheckAttributeAccess().getColonKeyword_1_1_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:1949:4: ( (lv_value_8_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:1950:5: (lv_value_8_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:1950:5: (lv_value_8_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:1951:6: lv_value_8_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:1973:1: entryRuleLiteralOrExpression returns [EObject current=null] : iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF ;
    public final EObject entryRuleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralOrExpression = null;


        try {
            // InternalNavascript.g:1973:60: (iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF )
            // InternalNavascript.g:1974:2: iv_ruleLiteralOrExpression= ruleLiteralOrExpression EOF
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
    // InternalNavascript.g:1980:1: ruleLiteralOrExpression returns [EObject current=null] : ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLiteralOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_literal_1_1=null;
        Token lv_literal_1_2=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:1986:2: ( ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalNavascript.g:1987:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalNavascript.g:1987:2: ( ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) ) | ( (lv_expression_2_0= ruleExpression ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_QUOTED_IDENTIFIER && LA35_0<=RULE_STRING_CONSTANT)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=RULE_MAPPABLE_IDENTIFIER && LA35_0<=RULE_IDENTIFIER)||(LA35_0>=RULE_TML_LITERAL && LA35_0<=RULE_EXISTS)||LA35_0==36||LA35_0==91||(LA35_0>=94 && LA35_0<=95)) ) {
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
                    // InternalNavascript.g:1988:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    {
                    // InternalNavascript.g:1988:3: ( () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) ) )
                    // InternalNavascript.g:1989:4: () ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    {
                    // InternalNavascript.g:1989:4: ()
                    // InternalNavascript.g:1990:5: 
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

                    // InternalNavascript.g:1999:4: ( ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) ) )
                    // InternalNavascript.g:2000:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    {
                    // InternalNavascript.g:2000:5: ( (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT ) )
                    // InternalNavascript.g:2001:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    {
                    // InternalNavascript.g:2001:6: (lv_literal_1_1= RULE_QUOTED_IDENTIFIER | lv_literal_1_2= RULE_STRING_CONSTANT )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==RULE_QUOTED_IDENTIFIER) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==RULE_STRING_CONSTANT) ) {
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
                            // InternalNavascript.g:2002:7: lv_literal_1_1= RULE_QUOTED_IDENTIFIER
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
                            // InternalNavascript.g:2017:7: lv_literal_1_2= RULE_STRING_CONSTANT
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
                    // InternalNavascript.g:2036:3: ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // InternalNavascript.g:2036:3: ( (lv_expression_2_0= ruleExpression ) )
                    // InternalNavascript.g:2037:4: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:2037:4: (lv_expression_2_0= ruleExpression )
                    // InternalNavascript.g:2038:5: lv_expression_2_0= ruleExpression
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
    // InternalNavascript.g:2059:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalNavascript.g:2059:46: (iv_rulePrint= rulePrint EOF )
            // InternalNavascript.g:2060:2: iv_rulePrint= rulePrint EOF
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
    // InternalNavascript.g:2066:1: rulePrint returns [EObject current=null] : ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2072:2: ( ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:2073:2: ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:2073:2: ( () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:2074:3: () otherlv_1= 'print' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:2074:3: ()
            // InternalNavascript.g:2075:4: 
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

            otherlv_1=(Token)match(input,55,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrintAccess().getPrintKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPrintAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:2092:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:2093:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:2093:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:2094:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrintAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_4=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPrintAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2123:1: entryRuleLog returns [EObject current=null] : iv_ruleLog= ruleLog EOF ;
    public final EObject entryRuleLog() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLog = null;


        try {
            // InternalNavascript.g:2123:44: (iv_ruleLog= ruleLog EOF )
            // InternalNavascript.g:2124:2: iv_ruleLog= ruleLog EOF
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
    // InternalNavascript.g:2130:1: ruleLog returns [EObject current=null] : ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject ruleLog() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2136:2: ( ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:2137:2: ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:2137:2: ( () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:2138:3: () otherlv_1= 'log' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:2138:3: ()
            // InternalNavascript.g:2139:4: 
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

            otherlv_1=(Token)match(input,56,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLogAccess().getLogKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLogAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:2156:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalNavascript.g:2157:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalNavascript.g:2157:4: (lv_expression_3_0= ruleExpression )
            // InternalNavascript.g:2158:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
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

            otherlv_4=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLogAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2187:1: entryRuleFinally returns [EObject current=null] : iv_ruleFinally= ruleFinally EOF ;
    public final EObject entryRuleFinally() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinally = null;


        try {
            // InternalNavascript.g:2187:48: (iv_ruleFinally= ruleFinally EOF )
            // InternalNavascript.g:2188:2: iv_ruleFinally= ruleFinally EOF
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
    // InternalNavascript.g:2194:1: ruleFinally returns [EObject current=null] : ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) ;
    public final EObject ruleFinally() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_finallyStatements_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2200:2: ( ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' ) )
            // InternalNavascript.g:2201:2: ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            {
            // InternalNavascript.g:2201:2: ( () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}' )
            // InternalNavascript.g:2202:3: () otherlv_1= 'finally' otherlv_2= '{' ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) ) otherlv_4= '}'
            {
            // InternalNavascript.g:2202:3: ()
            // InternalNavascript.g:2203:4: 
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

            otherlv_1=(Token)match(input,57,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFinallyAccess().getFinallyKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,29,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFinallyAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2220:3: ( (lv_finallyStatements_3_0= ruleTopLevelStatements ) )
            // InternalNavascript.g:2221:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            {
            // InternalNavascript.g:2221:4: (lv_finallyStatements_3_0= ruleTopLevelStatements )
            // InternalNavascript.g:2222:5: lv_finallyStatements_3_0= ruleTopLevelStatements
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFinallyAccess().getFinallyStatementsTopLevelStatementsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            otherlv_4=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2247:1: entryRuleMethods returns [EObject current=null] : iv_ruleMethods= ruleMethods EOF ;
    public final EObject entryRuleMethods() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethods = null;


        try {
            // InternalNavascript.g:2247:48: (iv_ruleMethods= ruleMethods EOF )
            // InternalNavascript.g:2248:2: iv_ruleMethods= ruleMethods EOF
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
    // InternalNavascript.g:2254:1: ruleMethods returns [EObject current=null] : ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) ;
    public final EObject ruleMethods() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_methods_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2260:2: ( ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' ) )
            // InternalNavascript.g:2261:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            {
            // InternalNavascript.g:2261:2: ( () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}' )
            // InternalNavascript.g:2262:3: () otherlv_1= 'methods' otherlv_2= '{' ( (lv_methods_3_0= ruleMethod ) )* otherlv_4= '}'
            {
            // InternalNavascript.g:2262:3: ()
            // InternalNavascript.g:2263:4: 
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

            otherlv_1=(Token)match(input,58,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMethodsAccess().getMethodsKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getMethodsAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalNavascript.g:2280:3: ( (lv_methods_3_0= ruleMethod ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_QUOTED_IDENTIFIER) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalNavascript.g:2281:4: (lv_methods_3_0= ruleMethod )
            	    {
            	    // InternalNavascript.g:2281:4: (lv_methods_3_0= ruleMethod )
            	    // InternalNavascript.g:2282:5: lv_methods_3_0= ruleMethod
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMethodsAccess().getMethodsMethodParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop36;
                }
            } while (true);

            otherlv_4=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2307:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalNavascript.g:2307:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalNavascript.g:2308:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalNavascript.g:2314:1: ruleMethod returns [EObject current=null] : ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token lv_methodName_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:2320:2: ( ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' ) )
            // InternalNavascript.g:2321:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            {
            // InternalNavascript.g:2321:2: ( () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';' )
            // InternalNavascript.g:2322:3: () ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_2= ';'
            {
            // InternalNavascript.g:2322:3: ()
            // InternalNavascript.g:2323:4: 
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

            // InternalNavascript.g:2332:3: ( (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2333:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2333:4: (lv_methodName_1_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2334:5: lv_methodName_1_0= RULE_QUOTED_IDENTIFIER
            {
            lv_methodName_1_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_24); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2358:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalNavascript.g:2358:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalNavascript.g:2359:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalNavascript.g:2365:1: ruleLoop returns [EObject current=null] : ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_mappable_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_tml_3_0 = null;

        EObject lv_filter_8_0 = null;

        EObject lv_statements_11_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2371:2: ( ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' ) )
            // InternalNavascript.g:2372:2: ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            {
            // InternalNavascript.g:2372:2: ( () otherlv_1= 'loop' ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}' )
            // InternalNavascript.g:2373:3: () otherlv_1= 'loop' ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) ) (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )? otherlv_10= '{' ( (lv_statements_11_0= ruleInnerBody ) )* otherlv_12= '}'
            {
            // InternalNavascript.g:2373:3: ()
            // InternalNavascript.g:2374:4: 
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

            otherlv_1=(Token)match(input,59,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLoopKeyword_1());
              		
            }
            // InternalNavascript.g:2387:3: ( ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) ) | ( (lv_tml_3_0= ruleTmlIdentifier ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_MAPPABLE_IDENTIFIER) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_TML_LITERAL) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalNavascript.g:2388:4: ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) )
                    {
                    // InternalNavascript.g:2388:4: ( (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER ) )
                    // InternalNavascript.g:2389:5: (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER )
                    {
                    // InternalNavascript.g:2389:5: (lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER )
                    // InternalNavascript.g:2390:6: lv_mappable_2_0= RULE_MAPPABLE_IDENTIFIER
                    {
                    lv_mappable_2_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_mappable_2_0, grammarAccess.getLoopAccess().getMappableMAPPABLE_IDENTIFIERTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLoopRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"mappable",
                      							lv_mappable_2_0,
                      							"com.dexels.navajo.Navascript.MAPPABLE_IDENTIFIER");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2407:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:2407:4: ( (lv_tml_3_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:2408:5: (lv_tml_3_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:2408:5: (lv_tml_3_0= ruleTmlIdentifier )
                    // InternalNavascript.g:2409:6: lv_tml_3_0= ruleTmlIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getTmlTmlIdentifierParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
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

            // InternalNavascript.g:2427:3: (otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==36) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalNavascript.g:2428:4: otherlv_4= '(' otherlv_5= 'filter' (otherlv_6= '=' | otherlv_7= ':' ) ( (lv_filter_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    otherlv_5=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getFilterKeyword_3_1());
                      			
                    }
                    // InternalNavascript.g:2436:4: (otherlv_6= '=' | otherlv_7= ':' )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==40) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==41) ) {
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
                            // InternalNavascript.g:2437:5: otherlv_6= '='
                            {
                            otherlv_6=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getEqualsSignKeyword_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2442:5: otherlv_7= ':'
                            {
                            otherlv_7=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getColonKeyword_3_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:2447:4: ( (lv_filter_8_0= ruleExpression ) )
                    // InternalNavascript.g:2448:5: (lv_filter_8_0= ruleExpression )
                    {
                    // InternalNavascript.g:2448:5: (lv_filter_8_0= ruleExpression )
                    // InternalNavascript.g:2449:6: lv_filter_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getFilterExpressionParserRuleCall_3_3_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    otherlv_9=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getRightParenthesisKeyword_3_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalNavascript.g:2475:3: ( (lv_statements_11_0= ruleInnerBody ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_MAPPABLE_IDENTIFIER||LA40_0==RULE_METHOD_IDENTIFIER||LA40_0==27||LA40_0==29||LA40_0==47||LA40_0==53||(LA40_0>=55 && LA40_0<=56)||(LA40_0>=58 && LA40_0<=59)||(LA40_0>=61 && LA40_0<=63)||(LA40_0>=68 && LA40_0<=69)||(LA40_0>=71 && LA40_0<=73)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalNavascript.g:2476:4: (lv_statements_11_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2476:4: (lv_statements_11_0= ruleInnerBody )
            	    // InternalNavascript.g:2477:5: lv_statements_11_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLoopAccess().getStatementsInnerBodyParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop40;
                }
            } while (true);

            otherlv_12=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2502:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalNavascript.g:2502:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalNavascript.g:2503:2: iv_ruleInclude= ruleInclude EOF
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
    // InternalNavascript.g:2509:1: ruleInclude returns [EObject current=null] : ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_scriptName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2515:2: ( ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2516:2: ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2516:2: ( () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2517:3: () otherlv_1= 'include' ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2517:3: ()
            // InternalNavascript.g:2518:4: 
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

            otherlv_1=(Token)match(input,61,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIncludeAccess().getIncludeKeyword_1());
              		
            }
            // InternalNavascript.g:2531:3: ( (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2532:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2532:4: (lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2533:5: lv_scriptName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_scriptName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_24); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2557:1: entryRuleAntiMessage returns [EObject current=null] : iv_ruleAntiMessage= ruleAntiMessage EOF ;
    public final EObject entryRuleAntiMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntiMessage = null;


        try {
            // InternalNavascript.g:2557:52: (iv_ruleAntiMessage= ruleAntiMessage EOF )
            // InternalNavascript.g:2558:2: iv_ruleAntiMessage= ruleAntiMessage EOF
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
    // InternalNavascript.g:2564:1: ruleAntiMessage returns [EObject current=null] : ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) ;
    public final EObject ruleAntiMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_messageName_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:2570:2: ( ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' ) )
            // InternalNavascript.g:2571:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            {
            // InternalNavascript.g:2571:2: ( () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';' )
            // InternalNavascript.g:2572:3: () otherlv_1= 'antimessage' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) otherlv_3= ';'
            {
            // InternalNavascript.g:2572:3: ()
            // InternalNavascript.g:2573:4: 
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

            otherlv_1=(Token)match(input,62,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAntiMessageAccess().getAntimessageKeyword_1());
              		
            }
            // InternalNavascript.g:2586:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2587:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2587:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2588:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_messageName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_24); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2612:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalNavascript.g:2612:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalNavascript.g:2613:2: iv_ruleMessage= ruleMessage EOF
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
    // InternalNavascript.g:2619:1: ruleMessage returns [EObject current=null] : ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) ) ;
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
            // InternalNavascript.g:2625:2: ( ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) ) )
            // InternalNavascript.g:2626:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) )
            {
            // InternalNavascript.g:2626:2: ( () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) ) )
            // InternalNavascript.g:2627:3: () otherlv_1= 'message' ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )? ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) )
            {
            // InternalNavascript.g:2627:3: ()
            // InternalNavascript.g:2628:4: 
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

            otherlv_1=(Token)match(input,63,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getMessageKeyword_1());
              		
            }
            // InternalNavascript.g:2641:3: ( (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:2642:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:2642:4: (lv_messageName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:2643:5: lv_messageName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_messageName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_36); if (state.failed) return current;
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

            // InternalNavascript.g:2659:3: (otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==36) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalNavascript.g:2660:4: otherlv_3= '(' ( (lv_arguments_4_0= ruleMessageArguments ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalNavascript.g:2664:4: ( (lv_arguments_4_0= ruleMessageArguments ) )
                    // InternalNavascript.g:2665:5: (lv_arguments_4_0= ruleMessageArguments )
                    {
                    // InternalNavascript.g:2665:5: (lv_arguments_4_0= ruleMessageArguments )
                    // InternalNavascript.g:2666:6: lv_arguments_4_0= ruleMessageArguments
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMessageAccess().getArgumentsMessageArgumentsParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    otherlv_5=(Token)match(input,37,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getMessageAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:2688:3: ( (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' ) | otherlv_11= ';' | (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' ) )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt45=1;
                }
                break;
            case 48:
                {
                alt45=2;
                }
                break;
            case 64:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalNavascript.g:2689:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    {
                    // InternalNavascript.g:2689:4: (otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}' )
                    // InternalNavascript.g:2690:5: otherlv_6= '{' ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) ) otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMessageAccess().getLeftCurlyBracketKeyword_4_0_0());
                      				
                    }
                    // InternalNavascript.g:2694:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )
                    int alt43=3;
                    alt43 = dfa43.predict(input);
                    switch (alt43) {
                        case 1 :
                            // InternalNavascript.g:2695:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            {
                            // InternalNavascript.g:2695:6: ( (lv_statements_7_0= ruleInnerBody ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==RULE_MAPPABLE_IDENTIFIER||LA42_0==RULE_METHOD_IDENTIFIER||LA42_0==27||LA42_0==29||LA42_0==47||LA42_0==53||(LA42_0>=55 && LA42_0<=56)||(LA42_0>=58 && LA42_0<=59)||(LA42_0>=61 && LA42_0<=63)||(LA42_0>=68 && LA42_0<=69)||(LA42_0>=71 && LA42_0<=73)) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // InternalNavascript.g:2696:7: (lv_statements_7_0= ruleInnerBody )
                            	    {
                            	    // InternalNavascript.g:2696:7: (lv_statements_7_0= ruleInnerBody )
                            	    // InternalNavascript.g:2697:8: lv_statements_7_0= ruleInnerBody
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getMessageAccess().getStatementsInnerBodyParserRuleCall_4_0_1_0_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_11);
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
                            	    break loop42;
                                }
                            } while (true);


                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2715:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            {
                            // InternalNavascript.g:2715:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
                            // InternalNavascript.g:2716:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            {
                            // InternalNavascript.g:2716:7: (lv_arrayField_8_0= ruleMappedArrayField )
                            // InternalNavascript.g:2717:8: lv_arrayField_8_0= ruleMappedArrayField
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMessageAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_0_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_31);
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
                            // InternalNavascript.g:2735:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            {
                            // InternalNavascript.g:2735:6: ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) )
                            // InternalNavascript.g:2736:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            {
                            // InternalNavascript.g:2736:7: (lv_arrayMessage_9_0= ruleMappedArrayMessage )
                            // InternalNavascript.g:2737:8: lv_arrayMessage_9_0= ruleMappedArrayMessage
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMessageAccess().getArrayMessageMappedArrayMessageParserRuleCall_4_0_1_2_0());
                              							
                            }
                            pushFollow(FOLLOW_31);
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

                    otherlv_10=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getMessageAccess().getRightCurlyBracketKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:2761:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getMessageAccess().getSemicolonKeyword_4_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:2766:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' )
                    {
                    // InternalNavascript.g:2766:4: (otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']' )
                    // InternalNavascript.g:2767:5: otherlv_12= '[' ( (lv_messageArray_13_0= ruleMessageArray ) )? otherlv_14= ']'
                    {
                    otherlv_12=(Token)match(input,64,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_12, grammarAccess.getMessageAccess().getLeftSquareBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:2771:5: ( (lv_messageArray_13_0= ruleMessageArray ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==29) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalNavascript.g:2772:6: (lv_messageArray_13_0= ruleMessageArray )
                            {
                            // InternalNavascript.g:2772:6: (lv_messageArray_13_0= ruleMessageArray )
                            // InternalNavascript.g:2773:7: lv_messageArray_13_0= ruleMessageArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMessageAccess().getMessageArrayMessageArrayParserRuleCall_4_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_41);
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

                    otherlv_14=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2800:1: entryRuleMessageArray returns [EObject current=null] : iv_ruleMessageArray= ruleMessageArray EOF ;
    public final EObject entryRuleMessageArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArray = null;


        try {
            // InternalNavascript.g:2800:53: (iv_ruleMessageArray= ruleMessageArray EOF )
            // InternalNavascript.g:2801:2: iv_ruleMessageArray= ruleMessageArray EOF
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
    // InternalNavascript.g:2807:1: ruleMessageArray returns [EObject current=null] : ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) ;
    public final EObject ruleMessageArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayMessageElements_0_0 = null;

        EObject lv_arrayMessageElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2813:2: ( ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* ) )
            // InternalNavascript.g:2814:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            {
            // InternalNavascript.g:2814:2: ( ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )* )
            // InternalNavascript.g:2815:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) ) (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            {
            // InternalNavascript.g:2815:3: ( (lv_arrayMessageElements_0_0= ruleMessageArrayElement ) )
            // InternalNavascript.g:2816:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            {
            // InternalNavascript.g:2816:4: (lv_arrayMessageElements_0_0= ruleMessageArrayElement )
            // InternalNavascript.g:2817:5: lv_arrayMessageElements_0_0= ruleMessageArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMessageArrayAccess().getArrayMessageElementsMessageArrayElementParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:2834:3: (otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==38) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalNavascript.g:2835:4: otherlv_1= ',' ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:2839:4: ( (lv_arrayMessageElements_2_0= ruleMessageArrayElement ) )
            	    // InternalNavascript.g:2840:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    {
            	    // InternalNavascript.g:2840:5: (lv_arrayMessageElements_2_0= ruleMessageArrayElement )
            	    // InternalNavascript.g:2841:6: lv_arrayMessageElements_2_0= ruleMessageArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMessageArrayAccess().getArrayMessageElementsMessageArrayElementParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop46;
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
    // InternalNavascript.g:2863:1: entryRuleMessageArrayElement returns [EObject current=null] : iv_ruleMessageArrayElement= ruleMessageArrayElement EOF ;
    public final EObject entryRuleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArrayElement = null;


        try {
            // InternalNavascript.g:2863:60: (iv_ruleMessageArrayElement= ruleMessageArrayElement EOF )
            // InternalNavascript.g:2864:2: iv_ruleMessageArrayElement= ruleMessageArrayElement EOF
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
    // InternalNavascript.g:2870:1: ruleMessageArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleMessageArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:2876:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:2877:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:2877:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:2878:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:2878:3: ()
            // InternalNavascript.g:2879:4: 
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

            otherlv_1=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMessageArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:2892:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_MAPPABLE_IDENTIFIER||LA47_0==RULE_METHOD_IDENTIFIER||LA47_0==27||LA47_0==29||LA47_0==47||LA47_0==53||(LA47_0>=55 && LA47_0<=56)||(LA47_0>=58 && LA47_0<=59)||(LA47_0>=61 && LA47_0<=63)||(LA47_0>=68 && LA47_0<=69)||(LA47_0>=71 && LA47_0<=73)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalNavascript.g:2893:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:2893:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:2894:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMessageArrayElementAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop47;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:2919:1: entryRuleMessageArgument returns [EObject current=null] : iv_ruleMessageArgument= ruleMessageArgument EOF ;
    public final EObject entryRuleMessageArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArgument = null;


        try {
            // InternalNavascript.g:2919:56: (iv_ruleMessageArgument= ruleMessageArgument EOF )
            // InternalNavascript.g:2920:2: iv_ruleMessageArgument= ruleMessageArgument EOF
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
    // InternalNavascript.g:2926:1: ruleMessageArgument returns [EObject current=null] : ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) ;
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
            // InternalNavascript.g:2932:2: ( ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) ) )
            // InternalNavascript.g:2933:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            {
            // InternalNavascript.g:2933:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType ) | (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==66) ) {
                alt50=1;
            }
            else if ( (LA50_0==67) ) {
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
                    // InternalNavascript.g:2934:3: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    {
                    // InternalNavascript.g:2934:3: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType )
                    // InternalNavascript.g:2935:4: otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) this_MessageType_3= ruleMessageType
                    {
                    otherlv_0=(Token)match(input,66,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getMessageArgumentAccess().getTypeKeyword_0_0());
                      			
                    }
                    // InternalNavascript.g:2939:4: (otherlv_1= '=' | otherlv_2= ':' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==40) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==41) ) {
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
                            // InternalNavascript.g:2940:5: otherlv_1= '='
                            {
                            otherlv_1=(Token)match(input,40,FOLLOW_42); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2945:5: otherlv_2= ':'
                            {
                            otherlv_2=(Token)match(input,41,FOLLOW_42); if (state.failed) return current;
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
                    // InternalNavascript.g:2963:3: (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    {
                    // InternalNavascript.g:2963:3: (otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode )
                    // InternalNavascript.g:2964:4: otherlv_4= 'mode' (otherlv_5= '=' | otherlv_6= ':' ) this_MessageMode_7= ruleMessageMode
                    {
                    otherlv_4=(Token)match(input,67,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getMessageArgumentAccess().getModeKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:2968:4: (otherlv_5= '=' | otherlv_6= ':' )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==40) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==41) ) {
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
                            // InternalNavascript.g:2969:5: otherlv_5= '='
                            {
                            otherlv_5=(Token)match(input,40,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMessageArgumentAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:2974:5: otherlv_6= ':'
                            {
                            otherlv_6=(Token)match(input,41,FOLLOW_43); if (state.failed) return current;
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
    // InternalNavascript.g:2995:1: entryRuleMessageArguments returns [EObject current=null] : iv_ruleMessageArguments= ruleMessageArguments EOF ;
    public final EObject entryRuleMessageArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageArguments = null;


        try {
            // InternalNavascript.g:2995:57: (iv_ruleMessageArguments= ruleMessageArguments EOF )
            // InternalNavascript.g:2996:2: iv_ruleMessageArguments= ruleMessageArguments EOF
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
    // InternalNavascript.g:3002:1: ruleMessageArguments returns [EObject current=null] : ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) ;
    public final EObject ruleMessageArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arguments_0_0 = null;

        EObject lv_arguments_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3008:2: ( ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* ) )
            // InternalNavascript.g:3009:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            {
            // InternalNavascript.g:3009:2: ( ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )* )
            // InternalNavascript.g:3010:3: ( (lv_arguments_0_0= ruleMessageArgument ) ) (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            {
            // InternalNavascript.g:3010:3: ( (lv_arguments_0_0= ruleMessageArgument ) )
            // InternalNavascript.g:3011:4: (lv_arguments_0_0= ruleMessageArgument )
            {
            // InternalNavascript.g:3011:4: (lv_arguments_0_0= ruleMessageArgument )
            // InternalNavascript.g:3012:5: lv_arguments_0_0= ruleMessageArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMessageArgumentsAccess().getArgumentsMessageArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:3029:3: (otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==38) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalNavascript.g:3030:4: otherlv_1= ',' ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMessageArgumentsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:3034:4: ( (lv_arguments_2_0= ruleMessageArgument ) )
            	    // InternalNavascript.g:3035:5: (lv_arguments_2_0= ruleMessageArgument )
            	    {
            	    // InternalNavascript.g:3035:5: (lv_arguments_2_0= ruleMessageArgument )
            	    // InternalNavascript.g:3036:6: lv_arguments_2_0= ruleMessageArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMessageArgumentsAccess().getArgumentsMessageArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop51;
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
    // InternalNavascript.g:3058:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalNavascript.g:3058:44: (iv_ruleMap= ruleMap EOF )
            // InternalNavascript.g:3059:2: iv_ruleMap= ruleMap EOF
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
    // InternalNavascript.g:3065:1: ruleMap returns [EObject current=null] : ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) ) ) ;
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_13_0 = null;

        EObject lv_statements_17_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3071:2: ( ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) ) ) )
            // InternalNavascript.g:3072:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) ) )
            {
            // InternalNavascript.g:3072:2: ( () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) ) )
            // InternalNavascript.g:3073:3: () ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) ) (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) )
            {
            // InternalNavascript.g:3073:3: ()
            // InternalNavascript.g:3074:4: 
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

            // InternalNavascript.g:3083:3: ( (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? ) | (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==68) ) {
                alt56=1;
            }
            else if ( (LA56_0==69) ) {
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
                    // InternalNavascript.g:3084:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? )
                    {
                    // InternalNavascript.g:3084:4: (otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )? )
                    // InternalNavascript.g:3085:5: otherlv_1= 'map.' ( (lv_adapterName_2_0= RULE_IDENTIFIER ) ) (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )?
                    {
                    otherlv_1=(Token)match(input,68,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getMapAccess().getMapKeyword_1_0_0());
                      				
                    }
                    // InternalNavascript.g:3089:5: ( (lv_adapterName_2_0= RULE_IDENTIFIER ) )
                    // InternalNavascript.g:3090:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    {
                    // InternalNavascript.g:3090:6: (lv_adapterName_2_0= RULE_IDENTIFIER )
                    // InternalNavascript.g:3091:7: lv_adapterName_2_0= RULE_IDENTIFIER
                    {
                    lv_adapterName_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_45); if (state.failed) return current;
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

                    // InternalNavascript.g:3107:5: (otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')' )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==36) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // InternalNavascript.g:3108:6: otherlv_3= '(' ( (lv_arguments_4_0= ruleKeyValueArguments ) )? otherlv_5= ')'
                            {
                            otherlv_3=(Token)match(input,36,FOLLOW_46); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1_0_2_0());
                              					
                            }
                            // InternalNavascript.g:3112:6: ( (lv_arguments_4_0= ruleKeyValueArguments ) )?
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==RULE_IDENTIFIER||(LA52_0>=108 && LA52_0<=110)) ) {
                                alt52=1;
                            }
                            switch (alt52) {
                                case 1 :
                                    // InternalNavascript.g:3113:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    {
                                    // InternalNavascript.g:3113:7: (lv_arguments_4_0= ruleKeyValueArguments )
                                    // InternalNavascript.g:3114:8: lv_arguments_4_0= ruleKeyValueArguments
                                    {
                                    if ( state.backtracking==0 ) {

                                      								newCompositeNode(grammarAccess.getMapAccess().getArgumentsKeyValueArgumentsParserRuleCall_1_0_2_1_0());
                                      							
                                    }
                                    pushFollow(FOLLOW_15);
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

                            otherlv_5=(Token)match(input,37,FOLLOW_47); if (state.failed) return current;
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
                    // InternalNavascript.g:3138:4: (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' )
                    {
                    // InternalNavascript.g:3138:4: (otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')' )
                    // InternalNavascript.g:3139:5: otherlv_6= 'map' otherlv_7= '(' otherlv_8= 'object' (otherlv_9= '=' | otherlv_10= ':' ) ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) ) (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )? otherlv_14= ')'
                    {
                    otherlv_6=(Token)match(input,69,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMapAccess().getMapKeyword_1_1_0());
                      				
                    }
                    otherlv_7=(Token)match(input,36,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1_1_1());
                      				
                    }
                    otherlv_8=(Token)match(input,70,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getMapAccess().getObjectKeyword_1_1_2());
                      				
                    }
                    // InternalNavascript.g:3151:5: (otherlv_9= '=' | otherlv_10= ':' )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==40) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==41) ) {
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
                            // InternalNavascript.g:3152:6: otherlv_9= '='
                            {
                            otherlv_9=(Token)match(input,40,FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_9, grammarAccess.getMapAccess().getEqualsSignKeyword_1_1_3_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3157:6: otherlv_10= ':'
                            {
                            otherlv_10=(Token)match(input,41,FOLLOW_49); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_10, grammarAccess.getMapAccess().getColonKeyword_1_1_3_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3162:5: ( (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER ) )
                    // InternalNavascript.g:3163:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    {
                    // InternalNavascript.g:3163:6: (lv_objectName_11_0= RULE_OBJECT_IDENTIFIER )
                    // InternalNavascript.g:3164:7: lv_objectName_11_0= RULE_OBJECT_IDENTIFIER
                    {
                    lv_objectName_11_0=(Token)match(input,RULE_OBJECT_IDENTIFIER,FOLLOW_30); if (state.failed) return current;
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

                    // InternalNavascript.g:3180:5: (otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==38) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalNavascript.g:3181:6: otherlv_12= ',' ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            {
                            otherlv_12=(Token)match(input,38,FOLLOW_50); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_12, grammarAccess.getMapAccess().getCommaKeyword_1_1_5_0());
                              					
                            }
                            // InternalNavascript.g:3185:6: ( (lv_arguments_13_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3186:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3186:7: (lv_arguments_13_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3187:8: lv_arguments_13_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMapAccess().getArgumentsKeyValueArgumentsParserRuleCall_1_1_5_1_0());
                              							
                            }
                            pushFollow(FOLLOW_15);
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

                    otherlv_14=(Token)match(input,37,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getMapAccess().getRightParenthesisKeyword_1_1_6());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalNavascript.g:3211:3: (otherlv_15= ';' | (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            else if ( (LA58_0==29) ) {
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
                    // InternalNavascript.g:3212:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getMapAccess().getSemicolonKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3217:4: (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' )
                    {
                    // InternalNavascript.g:3217:4: (otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}' )
                    // InternalNavascript.g:3218:5: otherlv_16= '{' ( (lv_statements_17_0= ruleInnerBody ) )* otherlv_18= '}'
                    {
                    otherlv_16=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_16, grammarAccess.getMapAccess().getLeftCurlyBracketKeyword_2_1_0());
                      				
                    }
                    // InternalNavascript.g:3222:5: ( (lv_statements_17_0= ruleInnerBody ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_MAPPABLE_IDENTIFIER||LA57_0==RULE_METHOD_IDENTIFIER||LA57_0==27||LA57_0==29||LA57_0==47||LA57_0==53||(LA57_0>=55 && LA57_0<=56)||(LA57_0>=58 && LA57_0<=59)||(LA57_0>=61 && LA57_0<=63)||(LA57_0>=68 && LA57_0<=69)||(LA57_0>=71 && LA57_0<=73)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalNavascript.g:3223:6: (lv_statements_17_0= ruleInnerBody )
                    	    {
                    	    // InternalNavascript.g:3223:6: (lv_statements_17_0= ruleInnerBody )
                    	    // InternalNavascript.g:3224:7: lv_statements_17_0= ruleInnerBody
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getMapAccess().getStatementsInnerBodyParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_statements_17_0=ruleInnerBody();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getMapRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"statements",
                    	      								lv_statements_17_0,
                    	      								"com.dexels.navajo.Navascript.InnerBody");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_18, grammarAccess.getMapAccess().getRightCurlyBracketKeyword_2_1_2());
                      				
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
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRuleMethodOrSetter"
    // InternalNavascript.g:3251:1: entryRuleMethodOrSetter returns [EObject current=null] : iv_ruleMethodOrSetter= ruleMethodOrSetter EOF ;
    public final EObject entryRuleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodOrSetter = null;


        try {
            // InternalNavascript.g:3251:55: (iv_ruleMethodOrSetter= ruleMethodOrSetter EOF )
            // InternalNavascript.g:3252:2: iv_ruleMethodOrSetter= ruleMethodOrSetter EOF
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
    // InternalNavascript.g:3258:1: ruleMethodOrSetter returns [EObject current=null] : (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) ;
    public final EObject ruleMethodOrSetter() throws RecognitionException {
        EObject current = null;

        EObject this_AdapterMethod_0 = null;

        EObject this_SetterField_1 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3264:2: ( (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField ) )
            // InternalNavascript.g:3265:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            {
            // InternalNavascript.g:3265:2: (this_AdapterMethod_0= ruleAdapterMethod | this_SetterField_1= ruleSetterField )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_METHOD_IDENTIFIER) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_MAPPABLE_IDENTIFIER) ) {
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
                    // InternalNavascript.g:3266:3: this_AdapterMethod_0= ruleAdapterMethod
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
                    // InternalNavascript.g:3278:3: this_SetterField_1= ruleSetterField
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
    // InternalNavascript.g:3293:1: entryRuleAdapterMethod returns [EObject current=null] : iv_ruleAdapterMethod= ruleAdapterMethod EOF ;
    public final EObject entryRuleAdapterMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdapterMethod = null;


        try {
            // InternalNavascript.g:3293:54: (iv_ruleAdapterMethod= ruleAdapterMethod EOF )
            // InternalNavascript.g:3294:2: iv_ruleAdapterMethod= ruleAdapterMethod EOF
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
    // InternalNavascript.g:3300:1: ruleAdapterMethod returns [EObject current=null] : ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' ) ;
    public final EObject ruleAdapterMethod() throws RecognitionException {
        EObject current = null;

        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_arguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3306:2: ( ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' ) )
            // InternalNavascript.g:3307:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' )
            {
            // InternalNavascript.g:3307:2: ( () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';' )
            // InternalNavascript.g:3308:3: () ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleKeyValueArguments ) )? otherlv_4= ')' otherlv_5= ';'
            {
            // InternalNavascript.g:3308:3: ()
            // InternalNavascript.g:3309:4: 
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

            // InternalNavascript.g:3318:3: ( (lv_method_1_0= RULE_METHOD_IDENTIFIER ) )
            // InternalNavascript.g:3319:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            {
            // InternalNavascript.g:3319:4: (lv_method_1_0= RULE_METHOD_IDENTIFIER )
            // InternalNavascript.g:3320:5: lv_method_1_0= RULE_METHOD_IDENTIFIER
            {
            lv_method_1_0=(Token)match(input,RULE_METHOD_IDENTIFIER,FOLLOW_13); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,36,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAdapterMethodAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalNavascript.g:3340:3: ( (lv_arguments_3_0= ruleKeyValueArguments ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_IDENTIFIER||(LA60_0>=108 && LA60_0<=110)) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalNavascript.g:3341:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    {
                    // InternalNavascript.g:3341:4: (lv_arguments_3_0= ruleKeyValueArguments )
                    // InternalNavascript.g:3342:5: lv_arguments_3_0= ruleKeyValueArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAdapterMethodAccess().getArgumentsKeyValueArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_15);
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

            otherlv_4=(Token)match(input,37,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getAdapterMethodAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3371:1: entryRuleSetterField returns [EObject current=null] : iv_ruleSetterField= ruleSetterField EOF ;
    public final EObject entryRuleSetterField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetterField = null;


        try {
            // InternalNavascript.g:3371:52: (iv_ruleSetterField= ruleSetterField EOF )
            // InternalNavascript.g:3372:2: iv_ruleSetterField= ruleSetterField EOF
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
    // InternalNavascript.g:3378:1: ruleSetterField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) ) ;
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
            // InternalNavascript.g:3384:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) ) )
            // InternalNavascript.g:3385:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) )
            {
            // InternalNavascript.g:3385:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) ) )
            // InternalNavascript.g:3386:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) )
            {
            // InternalNavascript.g:3386:3: ()
            // InternalNavascript.g:3387:4: 
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

            // InternalNavascript.g:3396:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3397:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3397:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3398:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_51); if (state.failed) return current;
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

            // InternalNavascript.g:3414:3: ( ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) | ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' ) | ( (lv_mappedField_12_0= ruleMappedArrayField ) ) | ( (lv_mappedMessage_13_0= ruleMappedMessage ) ) )
            int alt63=4;
            switch ( input.LA(1) ) {
            case 40:
            case 41:
                {
                alt63=1;
                }
                break;
            case 36:
                {
                alt63=2;
                }
                break;
            case 29:
                {
                int LA63_3 = input.LA(2);

                if ( (LA63_3==RULE_MAPPABLE_IDENTIFIER||LA63_3==RULE_METHOD_IDENTIFIER||LA63_3==27||(LA63_3>=29 && LA63_3<=30)||LA63_3==47||LA63_3==53||(LA63_3>=55 && LA63_3<=56)||(LA63_3>=58 && LA63_3<=59)||(LA63_3>=61 && LA63_3<=63)||(LA63_3>=68 && LA63_3<=69)||(LA63_3>=71 && LA63_3<=73)) ) {
                    alt63=4;
                }
                else if ( (LA63_3==RULE_TML_LITERAL) ) {
                    alt63=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalNavascript.g:3415:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    {
                    // InternalNavascript.g:3415:4: ( (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
                    // InternalNavascript.g:3416:5: (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
                    {
                    // InternalNavascript.g:3416:5: (otherlv_2= '=' | otherlv_3= ':' )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==40) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==41) ) {
                        alt61=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalNavascript.g:3417:6: otherlv_2= '='
                            {
                            otherlv_2=(Token)match(input,40,FOLLOW_52); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getSetterFieldAccess().getEqualsSignKeyword_2_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3422:6: otherlv_3= ':'
                            {
                            otherlv_3=(Token)match(input,41,FOLLOW_52); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getSetterFieldAccess().getColonKeyword_2_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3427:5: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:3428:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:3428:6: (lv_expressionList_4_0= ruleConditionalExpressions )
                    // InternalNavascript.g:3429:7: lv_expressionList_4_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getExpressionListConditionalExpressionsParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
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

                    otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getSetterFieldAccess().getSemicolonKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3452:4: ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    {
                    // InternalNavascript.g:3452:4: ( (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}' )
                    // InternalNavascript.g:3453:5: (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )? otherlv_9= '{' ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) ) otherlv_11= '}'
                    {
                    // InternalNavascript.g:3453:5: (otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')' )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==36) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalNavascript.g:3454:6: otherlv_6= '(' ( (lv_arguments_7_0= ruleKeyValueArguments ) ) otherlv_8= ')'
                            {
                            otherlv_6=(Token)match(input,36,FOLLOW_50); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_6, grammarAccess.getSetterFieldAccess().getLeftParenthesisKeyword_2_1_0_0());
                              					
                            }
                            // InternalNavascript.g:3458:6: ( (lv_arguments_7_0= ruleKeyValueArguments ) )
                            // InternalNavascript.g:3459:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            {
                            // InternalNavascript.g:3459:7: (lv_arguments_7_0= ruleKeyValueArguments )
                            // InternalNavascript.g:3460:8: lv_arguments_7_0= ruleKeyValueArguments
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getSetterFieldAccess().getArgumentsKeyValueArgumentsParserRuleCall_2_1_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_15);
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

                            otherlv_8=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_8, grammarAccess.getSetterFieldAccess().getRightParenthesisKeyword_2_1_0_2());
                              					
                            }

                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,29,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getSetterFieldAccess().getLeftCurlyBracketKeyword_2_1_1());
                      				
                    }
                    // InternalNavascript.g:3486:5: ( (lv_mappedArray_10_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:3487:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:3487:6: (lv_mappedArray_10_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:3488:7: lv_mappedArray_10_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSetterFieldAccess().getMappedArrayMappedArrayMessageParserRuleCall_2_1_2_0());
                      						
                    }
                    pushFollow(FOLLOW_31);
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

                    otherlv_11=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getSetterFieldAccess().getRightCurlyBracketKeyword_2_1_3());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:3511:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    {
                    // InternalNavascript.g:3511:4: ( (lv_mappedField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:3512:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:3512:5: (lv_mappedField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:3513:6: lv_mappedField_12_0= ruleMappedArrayField
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
                    // InternalNavascript.g:3531:4: ( (lv_mappedMessage_13_0= ruleMappedMessage ) )
                    {
                    // InternalNavascript.g:3531:4: ( (lv_mappedMessage_13_0= ruleMappedMessage ) )
                    // InternalNavascript.g:3532:5: (lv_mappedMessage_13_0= ruleMappedMessage )
                    {
                    // InternalNavascript.g:3532:5: (lv_mappedMessage_13_0= ruleMappedMessage )
                    // InternalNavascript.g:3533:6: lv_mappedMessage_13_0= ruleMappedMessage
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
    // InternalNavascript.g:3555:1: entryRuleMappedMessage returns [EObject current=null] : iv_ruleMappedMessage= ruleMappedMessage EOF ;
    public final EObject entryRuleMappedMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedMessage = null;


        try {
            // InternalNavascript.g:3555:54: (iv_ruleMappedMessage= ruleMappedMessage EOF )
            // InternalNavascript.g:3556:2: iv_ruleMappedMessage= ruleMappedMessage EOF
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
    // InternalNavascript.g:3562:1: ruleMappedMessage returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleMappedMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3568:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:3569:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:3569:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:3570:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:3570:3: ()
            // InternalNavascript.g:3571:4: 
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

            otherlv_1=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMappedMessageAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:3584:3: ( (lv_statements_2_0= ruleInnerBody ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_MAPPABLE_IDENTIFIER||LA64_0==RULE_METHOD_IDENTIFIER||LA64_0==27||LA64_0==29||LA64_0==47||LA64_0==53||(LA64_0>=55 && LA64_0<=56)||(LA64_0>=58 && LA64_0<=59)||(LA64_0>=61 && LA64_0<=63)||(LA64_0>=68 && LA64_0<=69)||(LA64_0>=71 && LA64_0<=73)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalNavascript.g:3585:4: (lv_statements_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3585:4: (lv_statements_2_0= ruleInnerBody )
            	    // InternalNavascript.g:3586:5: lv_statements_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedMessageAccess().getStatementsInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop64;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3611:1: entryRuleMappedArrayField returns [EObject current=null] : iv_ruleMappedArrayField= ruleMappedArrayField EOF ;
    public final EObject entryRuleMappedArrayField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayField = null;


        try {
            // InternalNavascript.g:3611:57: (iv_ruleMappedArrayField= ruleMappedArrayField EOF )
            // InternalNavascript.g:3612:2: iv_ruleMappedArrayField= ruleMappedArrayField EOF
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
    // InternalNavascript.g:3618:1: ruleMappedArrayField returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
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
            // InternalNavascript.g:3624:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3625:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3625:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3626:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3626:3: ()
            // InternalNavascript.g:3627:4: 
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

            // InternalNavascript.g:3636:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:3637:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:3637:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:3638:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_34); if (state.failed) return current;
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

            // InternalNavascript.g:3654:3: (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==36) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalNavascript.g:3655:4: otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappedArrayFieldAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMappedArrayFieldAccess().getFilterKeyword_2_1());
                      			
                    }
                    // InternalNavascript.g:3663:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==40) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==41) ) {
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
                            // InternalNavascript.g:3664:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayFieldAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3669:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayFieldAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3674:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3675:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3675:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3676:6: lv_filter_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    otherlv_7=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getMappedArrayFieldAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayFieldAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3702:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_MAPPABLE_IDENTIFIER||LA67_0==RULE_METHOD_IDENTIFIER||LA67_0==27||LA67_0==29||LA67_0==47||LA67_0==53||(LA67_0>=55 && LA67_0<=56)||(LA67_0>=58 && LA67_0<=59)||(LA67_0>=61 && LA67_0<=63)||(LA67_0>=68 && LA67_0<=69)||(LA67_0>=71 && LA67_0<=73)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalNavascript.g:3703:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3703:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3704:5: lv_statements_9_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayFieldAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop67;
                }
            } while (true);

            otherlv_10=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3729:1: entryRuleMappedArrayMessage returns [EObject current=null] : iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF ;
    public final EObject entryRuleMappedArrayMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappedArrayMessage = null;


        try {
            // InternalNavascript.g:3729:59: (iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF )
            // InternalNavascript.g:3730:2: iv_ruleMappedArrayMessage= ruleMappedArrayMessage EOF
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
    // InternalNavascript.g:3736:1: ruleMappedArrayMessage returns [EObject current=null] : ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) ;
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
            // InternalNavascript.g:3742:2: ( ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' ) )
            // InternalNavascript.g:3743:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            {
            // InternalNavascript.g:3743:2: ( () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}' )
            // InternalNavascript.g:3744:3: () ( (lv_message_1_0= RULE_TML_LITERAL ) ) (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )? otherlv_8= '{' ( (lv_statements_9_0= ruleInnerBody ) )* otherlv_10= '}'
            {
            // InternalNavascript.g:3744:3: ()
            // InternalNavascript.g:3745:4: 
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

            // InternalNavascript.g:3754:3: ( (lv_message_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:3755:4: (lv_message_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:3755:4: (lv_message_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:3756:5: lv_message_1_0= RULE_TML_LITERAL
            {
            lv_message_1_0=(Token)match(input,RULE_TML_LITERAL,FOLLOW_34); if (state.failed) return current;
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

            // InternalNavascript.g:3772:3: (otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==36) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalNavascript.g:3773:4: otherlv_2= '(' otherlv_3= 'filter' (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_filter_6_0= ruleExpression ) ) otherlv_7= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappedArrayMessageAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    otherlv_3=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMappedArrayMessageAccess().getFilterKeyword_2_1());
                      			
                    }
                    // InternalNavascript.g:3781:4: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==40) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==41) ) {
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
                            // InternalNavascript.g:3782:5: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,40,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getMappedArrayMessageAccess().getEqualsSignKeyword_2_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:3787:5: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,41,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getMappedArrayMessageAccess().getColonKeyword_2_2_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:3792:4: ( (lv_filter_6_0= ruleExpression ) )
                    // InternalNavascript.g:3793:5: (lv_filter_6_0= ruleExpression )
                    {
                    // InternalNavascript.g:3793:5: (lv_filter_6_0= ruleExpression )
                    // InternalNavascript.g:3794:6: lv_filter_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getFilterExpressionParserRuleCall_2_3_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    otherlv_7=(Token)match(input,37,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getMappedArrayMessageAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getMappedArrayMessageAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalNavascript.g:3820:3: ( (lv_statements_9_0= ruleInnerBody ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_MAPPABLE_IDENTIFIER||LA70_0==RULE_METHOD_IDENTIFIER||LA70_0==27||LA70_0==29||LA70_0==47||LA70_0==53||(LA70_0>=55 && LA70_0<=56)||(LA70_0>=58 && LA70_0<=59)||(LA70_0>=61 && LA70_0<=63)||(LA70_0>=68 && LA70_0<=69)||(LA70_0>=71 && LA70_0<=73)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalNavascript.g:3821:4: (lv_statements_9_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:3821:4: (lv_statements_9_0= ruleInnerBody )
            	    // InternalNavascript.g:3822:5: lv_statements_9_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getMappedArrayMessageAccess().getStatementsInnerBodyParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop70;
                }
            } while (true);

            otherlv_10=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:3847:1: entryRuleKeyValueArguments returns [EObject current=null] : iv_ruleKeyValueArguments= ruleKeyValueArguments EOF ;
    public final EObject entryRuleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArguments = null;


        try {
            // InternalNavascript.g:3847:58: (iv_ruleKeyValueArguments= ruleKeyValueArguments EOF )
            // InternalNavascript.g:3848:2: iv_ruleKeyValueArguments= ruleKeyValueArguments EOF
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
    // InternalNavascript.g:3854:1: ruleKeyValueArguments returns [EObject current=null] : ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) ;
    public final EObject ruleKeyValueArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_keyValueArguments_1_0 = null;

        EObject lv_keyValueArguments_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3860:2: ( ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* ) )
            // InternalNavascript.g:3861:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            {
            // InternalNavascript.g:3861:2: ( () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )* )
            // InternalNavascript.g:3862:3: () ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) ) (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            {
            // InternalNavascript.g:3862:3: ()
            // InternalNavascript.g:3863:4: 
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

            // InternalNavascript.g:3872:3: ( (lv_keyValueArguments_1_0= ruleKeyValueArgument ) )
            // InternalNavascript.g:3873:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            {
            // InternalNavascript.g:3873:4: (lv_keyValueArguments_1_0= ruleKeyValueArgument )
            // InternalNavascript.g:3874:5: lv_keyValueArguments_1_0= ruleKeyValueArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsKeyValueArgumentParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:3891:3: (otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==38) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalNavascript.g:3892:4: otherlv_2= ',' ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    {
            	    otherlv_2=(Token)match(input,38,FOLLOW_50); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentsAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:3896:4: ( (lv_keyValueArguments_3_0= ruleKeyValueArgument ) )
            	    // InternalNavascript.g:3897:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    {
            	    // InternalNavascript.g:3897:5: (lv_keyValueArguments_3_0= ruleKeyValueArgument )
            	    // InternalNavascript.g:3898:6: lv_keyValueArguments_3_0= ruleKeyValueArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getKeyValueArgumentsAccess().getKeyValueArgumentsKeyValueArgumentParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop71;
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
    // InternalNavascript.g:3920:1: entryRuleKeyValueArgument returns [EObject current=null] : iv_ruleKeyValueArgument= ruleKeyValueArgument EOF ;
    public final EObject entryRuleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValueArgument = null;


        try {
            // InternalNavascript.g:3920:57: (iv_ruleKeyValueArgument= ruleKeyValueArgument EOF )
            // InternalNavascript.g:3921:2: iv_ruleKeyValueArgument= ruleKeyValueArgument EOF
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
    // InternalNavascript.g:3927:1: ruleKeyValueArgument returns [EObject current=null] : ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleKeyValueArgument() throws RecognitionException {
        EObject current = null;

        Token lv_key_1_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_key_1_2 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:3933:2: ( ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:3934:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:3934:2: ( () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:3935:3: () ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_value_4_0= ruleLiteralOrExpression ) )
            {
            // InternalNavascript.g:3935:3: ()
            // InternalNavascript.g:3936:4: 
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

            // InternalNavascript.g:3945:3: ( ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) ) )
            // InternalNavascript.g:3946:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            {
            // InternalNavascript.g:3946:4: ( (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE ) )
            // InternalNavascript.g:3947:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:3947:5: (lv_key_1_1= RULE_IDENTIFIER | lv_key_1_2= ruleOPTION_TYPE )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_IDENTIFIER) ) {
                alt72=1;
            }
            else if ( ((LA72_0>=108 && LA72_0<=110)) ) {
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
                    // InternalNavascript.g:3948:6: lv_key_1_1= RULE_IDENTIFIER
                    {
                    lv_key_1_1=(Token)match(input,RULE_IDENTIFIER,FOLLOW_19); if (state.failed) return current;
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
                    // InternalNavascript.g:3963:6: lv_key_1_2= ruleOPTION_TYPE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getKeyValueArgumentAccess().getKeyOPTION_TYPEParserRuleCall_1_0_1());
                      					
                    }
                    pushFollow(FOLLOW_19);
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

            // InternalNavascript.g:3981:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==40) ) {
                alt73=1;
            }
            else if ( (LA73_0==41) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalNavascript.g:3982:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getKeyValueArgumentAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:3987:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getKeyValueArgumentAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:3992:3: ( (lv_value_4_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:3993:4: (lv_value_4_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:3993:4: (lv_value_4_0= ruleLiteralOrExpression )
            // InternalNavascript.g:3994:5: lv_value_4_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:4015:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // InternalNavascript.g:4015:44: (iv_ruleVar= ruleVar EOF )
            // InternalNavascript.g:4016:2: iv_ruleVar= ruleVar EOF
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
    // InternalNavascript.g:4022:1: ruleVar returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) ;
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
            // InternalNavascript.g:4028:2: ( ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) ) )
            // InternalNavascript.g:4029:2: ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            {
            // InternalNavascript.g:4029:2: ( () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) ) )
            // InternalNavascript.g:4030:3: () otherlv_1= 'var' ( (lv_varName_2_0= RULE_IDENTIFIER ) ) ( (lv_arguments_3_0= ruleVarArguments ) )? ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            {
            // InternalNavascript.g:4030:3: ()
            // InternalNavascript.g:4031:4: 
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

            otherlv_1=(Token)match(input,71,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarAccess().getVarKeyword_1());
              		
            }
            // InternalNavascript.g:4044:3: ( (lv_varName_2_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:4045:4: (lv_varName_2_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:4045:4: (lv_varName_2_0= RULE_IDENTIFIER )
            // InternalNavascript.g:4046:5: lv_varName_2_0= RULE_IDENTIFIER
            {
            lv_varName_2_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_53); if (state.failed) return current;
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

            // InternalNavascript.g:4062:3: ( (lv_arguments_3_0= ruleVarArguments ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==36) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalNavascript.g:4063:4: (lv_arguments_3_0= ruleVarArguments )
                    {
                    // InternalNavascript.g:4063:4: (lv_arguments_3_0= ruleVarArguments )
                    // InternalNavascript.g:4064:5: lv_arguments_3_0= ruleVarArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVarAccess().getArgumentsVarArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_54);
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

            // InternalNavascript.g:4081:3: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' ) | (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' ) )
            int alt78=5;
            switch ( input.LA(1) ) {
            case 40:
            case 41:
                {
                alt78=1;
                }
                break;
            case 64:
                {
                alt78=2;
                }
                break;
            case 29:
                {
                switch ( input.LA(2) ) {
                case RULE_MAPPABLE_IDENTIFIER:
                    {
                    alt78=4;
                    }
                    break;
                case RULE_TML_LITERAL:
                    {
                    alt78=5;
                    }
                    break;
                case 27:
                case 30:
                case 71:
                    {
                    alt78=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalNavascript.g:4082:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    {
                    // InternalNavascript.g:4082:4: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';' )
                    // InternalNavascript.g:4083:5: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) otherlv_7= ';'
                    {
                    // InternalNavascript.g:4083:5: (otherlv_4= '=' | otherlv_5= ':' )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==40) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==41) ) {
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
                            // InternalNavascript.g:4084:6: otherlv_4= '='
                            {
                            otherlv_4=(Token)match(input,40,FOLLOW_52); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_4, grammarAccess.getVarAccess().getEqualsSignKeyword_4_0_0_0());
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalNavascript.g:4089:6: otherlv_5= ':'
                            {
                            otherlv_5=(Token)match(input,41,FOLLOW_52); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_5, grammarAccess.getVarAccess().getColonKeyword_4_0_0_1());
                              					
                            }

                            }
                            break;

                    }

                    // InternalNavascript.g:4094:5: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                    // InternalNavascript.g:4095:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    {
                    // InternalNavascript.g:4095:6: (lv_expressionList_6_0= ruleConditionalExpressions )
                    // InternalNavascript.g:4096:7: lv_expressionList_6_0= ruleConditionalExpressions
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_24);
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

                    otherlv_7=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getVarAccess().getSemicolonKeyword_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4119:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    {
                    // InternalNavascript.g:4119:4: (otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']' )
                    // InternalNavascript.g:4120:5: otherlv_8= '[' ( (lv_varArray_9_0= ruleVarArray ) )? otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,64,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getVarAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4124:5: ( (lv_varArray_9_0= ruleVarArray ) )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==29) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalNavascript.g:4125:6: (lv_varArray_9_0= ruleVarArray )
                            {
                            // InternalNavascript.g:4125:6: (lv_varArray_9_0= ruleVarArray )
                            // InternalNavascript.g:4126:7: lv_varArray_9_0= ruleVarArray
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVarAccess().getVarArrayVarArrayParserRuleCall_4_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_41);
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

                    otherlv_10=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getVarAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4149:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    {
                    // InternalNavascript.g:4149:4: (otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}' )
                    // InternalNavascript.g:4150:5: otherlv_11= '{' ( (lv_varElements_12_0= ruleVarElement ) )* otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,29,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4154:5: ( (lv_varElements_12_0= ruleVarElement ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==27||LA77_0==71) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalNavascript.g:4155:6: (lv_varElements_12_0= ruleVarElement )
                    	    {
                    	    // InternalNavascript.g:4155:6: (lv_varElements_12_0= ruleVarElement )
                    	    // InternalNavascript.g:4156:7: lv_varElements_12_0= ruleVarElement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getVarAccess().getVarElementsVarElementParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_55);
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
                    	    break loop77;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4179:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:4179:4: (otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}' )
                    // InternalNavascript.g:4180:5: otherlv_14= '{' ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,29,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4184:5: ( (lv_mappedArrayField_15_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4185:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4185:6: (lv_mappedArrayField_15_0= ruleMappedArrayField )
                    // InternalNavascript.g:4186:7: lv_mappedArrayField_15_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayFieldMappedArrayFieldParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_31);
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

                    otherlv_16=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_16, grammarAccess.getVarAccess().getRightCurlyBracketKeyword_4_3_2());
                      				
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:4209:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    {
                    // InternalNavascript.g:4209:4: (otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}' )
                    // InternalNavascript.g:4210:5: otherlv_17= '{' ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,29,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_17, grammarAccess.getVarAccess().getLeftCurlyBracketKeyword_4_4_0());
                      				
                    }
                    // InternalNavascript.g:4214:5: ( (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4215:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4215:6: (lv_mappedArrayMessage_18_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4216:7: lv_mappedArrayMessage_18_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getVarAccess().getMappedArrayMessageMappedArrayMessageParserRuleCall_4_4_1_0());
                      						
                    }
                    pushFollow(FOLLOW_31);
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

                    otherlv_19=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4243:1: entryRuleVarArray returns [EObject current=null] : iv_ruleVarArray= ruleVarArray EOF ;
    public final EObject entryRuleVarArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArray = null;


        try {
            // InternalNavascript.g:4243:49: (iv_ruleVarArray= ruleVarArray EOF )
            // InternalNavascript.g:4244:2: iv_ruleVarArray= ruleVarArray EOF
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
    // InternalNavascript.g:4250:1: ruleVarArray returns [EObject current=null] : ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) ;
    public final EObject ruleVarArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_vararrayelement_1_0 = null;

        EObject lv_vararrayelement_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4256:2: ( ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* ) )
            // InternalNavascript.g:4257:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            {
            // InternalNavascript.g:4257:2: ( () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )* )
            // InternalNavascript.g:4258:3: () ( (lv_vararrayelement_1_0= ruleVarArrayElement ) ) (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            {
            // InternalNavascript.g:4258:3: ()
            // InternalNavascript.g:4259:4: 
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

            // InternalNavascript.g:4268:3: ( (lv_vararrayelement_1_0= ruleVarArrayElement ) )
            // InternalNavascript.g:4269:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            {
            // InternalNavascript.g:4269:4: (lv_vararrayelement_1_0= ruleVarArrayElement )
            // InternalNavascript.g:4270:5: lv_vararrayelement_1_0= ruleVarArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarArrayAccess().getVararrayelementVarArrayElementParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:4287:3: (otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==38) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalNavascript.g:4288:4: otherlv_2= ',' ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    {
            	    otherlv_2=(Token)match(input,38,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getVarArrayAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalNavascript.g:4292:4: ( (lv_vararrayelement_3_0= ruleVarArrayElement ) )
            	    // InternalNavascript.g:4293:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    {
            	    // InternalNavascript.g:4293:5: (lv_vararrayelement_3_0= ruleVarArrayElement )
            	    // InternalNavascript.g:4294:6: lv_vararrayelement_3_0= ruleVarArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarArrayAccess().getVararrayelementVarArrayElementParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop79;
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
    // InternalNavascript.g:4316:1: entryRuleVarArrayElement returns [EObject current=null] : iv_ruleVarArrayElement= ruleVarArrayElement EOF ;
    public final EObject entryRuleVarArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArrayElement = null;


        try {
            // InternalNavascript.g:4316:56: (iv_ruleVarArrayElement= ruleVarArrayElement EOF )
            // InternalNavascript.g:4317:2: iv_ruleVarArrayElement= ruleVarArrayElement EOF
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
    // InternalNavascript.g:4323:1: ruleVarArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleVarArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_varElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4329:2: ( ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:4330:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:4330:2: ( () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}' )
            // InternalNavascript.g:4331:3: () otherlv_1= '{' ( (lv_varElements_2_0= ruleVarElement ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:4331:3: ()
            // InternalNavascript.g:4332:4: 
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

            otherlv_1=(Token)match(input,29,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:4345:3: ( (lv_varElements_2_0= ruleVarElement ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==27||LA80_0==71) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalNavascript.g:4346:4: (lv_varElements_2_0= ruleVarElement )
            	    {
            	    // InternalNavascript.g:4346:4: (lv_varElements_2_0= ruleVarElement )
            	    // InternalNavascript.g:4347:5: lv_varElements_2_0= ruleVarElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getVarArrayElementAccess().getVarElementsVarElementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop80;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4372:1: entryRuleVarElement returns [EObject current=null] : iv_ruleVarElement= ruleVarElement EOF ;
    public final EObject entryRuleVarElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarElement = null;


        try {
            // InternalNavascript.g:4372:51: (iv_ruleVarElement= ruleVarElement EOF )
            // InternalNavascript.g:4373:2: iv_ruleVarElement= ruleVarElement EOF
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
    // InternalNavascript.g:4379:1: ruleVarElement returns [EObject current=null] : ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) ;
    public final EObject ruleVarElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_var_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4385:2: ( ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) ) )
            // InternalNavascript.g:4386:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            {
            // InternalNavascript.g:4386:2: ( () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) ) )
            // InternalNavascript.g:4387:3: () (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )? ( (lv_var_4_0= ruleVar ) )
            {
            // InternalNavascript.g:4387:3: ()
            // InternalNavascript.g:4388:4: 
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

            // InternalNavascript.g:4397:3: (otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==27) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalNavascript.g:4398:4: otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getVarElementAccess().getIfKeyword_1_0());
                      			
                    }
                    // InternalNavascript.g:4402:4: ( (lv_condition_2_0= ruleExpression ) )
                    // InternalNavascript.g:4403:5: (lv_condition_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:4403:5: (lv_condition_2_0= ruleExpression )
                    // InternalNavascript.g:4404:6: lv_condition_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVarElementAccess().getConditionExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_3=(Token)match(input,28,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarElementAccess().getThenKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4426:3: ( (lv_var_4_0= ruleVar ) )
            // InternalNavascript.g:4427:4: (lv_var_4_0= ruleVar )
            {
            // InternalNavascript.g:4427:4: (lv_var_4_0= ruleVar )
            // InternalNavascript.g:4428:5: lv_var_4_0= ruleVar
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
    // InternalNavascript.g:4449:1: entryRuleVarArguments returns [EObject current=null] : iv_ruleVarArguments= ruleVarArguments EOF ;
    public final EObject entryRuleVarArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArguments = null;


        try {
            // InternalNavascript.g:4449:53: (iv_ruleVarArguments= ruleVarArguments EOF )
            // InternalNavascript.g:4450:2: iv_ruleVarArguments= ruleVarArguments EOF
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
    // InternalNavascript.g:4456:1: ruleVarArguments returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleVarArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_varArguments_2_0 = null;

        EObject lv_varArguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4462:2: ( ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' ) )
            // InternalNavascript.g:4463:2: ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' )
            {
            // InternalNavascript.g:4463:2: ( () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')' )
            // InternalNavascript.g:4464:3: () otherlv_1= '(' ( (lv_varArguments_2_0= ruleVarArgument ) ) (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )* otherlv_5= ')'
            {
            // InternalNavascript.g:4464:3: ()
            // InternalNavascript.g:4465:4: 
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

            otherlv_1=(Token)match(input,36,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarArgumentsAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:4478:3: ( (lv_varArguments_2_0= ruleVarArgument ) )
            // InternalNavascript.g:4479:4: (lv_varArguments_2_0= ruleVarArgument )
            {
            // InternalNavascript.g:4479:4: (lv_varArguments_2_0= ruleVarArgument )
            // InternalNavascript.g:4480:5: lv_varArguments_2_0= ruleVarArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVarArgumentsAccess().getVarArgumentsVarArgumentParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalNavascript.g:4497:3: (otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==38) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalNavascript.g:4498:4: otherlv_3= ',' ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,38,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getVarArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:4502:4: ( (lv_varArguments_4_0= ruleVarArgument ) )
            	    // InternalNavascript.g:4503:5: (lv_varArguments_4_0= ruleVarArgument )
            	    {
            	    // InternalNavascript.g:4503:5: (lv_varArguments_4_0= ruleVarArgument )
            	    // InternalNavascript.g:4504:6: lv_varArguments_4_0= ruleVarArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getVarArgumentsAccess().getVarArgumentsVarArgumentParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop82;
                }
            } while (true);

            otherlv_5=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4530:1: entryRuleVarArgument returns [EObject current=null] : iv_ruleVarArgument= ruleVarArgument EOF ;
    public final EObject entryRuleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarArgument = null;


        try {
            // InternalNavascript.g:4530:52: (iv_ruleVarArgument= ruleVarArgument EOF )
            // InternalNavascript.g:4531:2: iv_ruleVarArgument= ruleVarArgument EOF
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
    // InternalNavascript.g:4537:1: ruleVarArgument returns [EObject current=null] : ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) ;
    public final EObject ruleVarArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_argument_1_1 = null;

        EObject lv_argument_1_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4543:2: ( ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) ) )
            // InternalNavascript.g:4544:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            {
            // InternalNavascript.g:4544:2: ( () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) ) )
            // InternalNavascript.g:4545:3: () ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            {
            // InternalNavascript.g:4545:3: ()
            // InternalNavascript.g:4546:4: 
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

            // InternalNavascript.g:4555:3: ( ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) ) )
            // InternalNavascript.g:4556:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            {
            // InternalNavascript.g:4556:4: ( (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode ) )
            // InternalNavascript.g:4557:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            {
            // InternalNavascript.g:4557:5: (lv_argument_1_1= ruleVarType | lv_argument_1_2= ruleVarMode )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==66) ) {
                alt83=1;
            }
            else if ( (LA83_0==67) ) {
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
                    // InternalNavascript.g:4558:6: lv_argument_1_1= ruleVarType
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
                    // InternalNavascript.g:4574:6: lv_argument_1_2= ruleVarMode
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
    // InternalNavascript.g:4596:1: entryRuleVarType returns [EObject current=null] : iv_ruleVarType= ruleVarType EOF ;
    public final EObject entryRuleVarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarType = null;


        try {
            // InternalNavascript.g:4596:48: (iv_ruleVarType= ruleVarType EOF )
            // InternalNavascript.g:4597:2: iv_ruleVarType= ruleVarType EOF
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
    // InternalNavascript.g:4603:1: ruleVarType returns [EObject current=null] : ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) ;
    public final EObject ruleVarType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_type_4_1 = null;

        EObject lv_type_4_2 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4609:2: ( ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) ) )
            // InternalNavascript.g:4610:2: ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            {
            // InternalNavascript.g:4610:2: ( () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) ) )
            // InternalNavascript.g:4611:3: () otherlv_1= 'type' (otherlv_2= '=' | otherlv_3= ':' ) ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            {
            // InternalNavascript.g:4611:3: ()
            // InternalNavascript.g:4612:4: 
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

            otherlv_1=(Token)match(input,66,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarTypeAccess().getTypeKeyword_1());
              		
            }
            // InternalNavascript.g:4625:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==40) ) {
                alt84=1;
            }
            else if ( (LA84_0==41) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalNavascript.g:4626:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarTypeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4631:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarTypeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4636:3: ( ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) ) )
            // InternalNavascript.g:4637:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            {
            // InternalNavascript.g:4637:4: ( (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType ) )
            // InternalNavascript.g:4638:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            {
            // InternalNavascript.g:4638:5: (lv_type_4_1= ruleMessageType | lv_type_4_2= rulePropertyType )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=111 && LA85_0<=113)) ) {
                alt85=1;
            }
            else if ( ((LA85_0>=97 && LA85_0<=107)) ) {
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
                    // InternalNavascript.g:4639:6: lv_type_4_1= ruleMessageType
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
                    // InternalNavascript.g:4655:6: lv_type_4_2= rulePropertyType
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
    // InternalNavascript.g:4677:1: entryRuleVarMode returns [EObject current=null] : iv_ruleVarMode= ruleVarMode EOF ;
    public final EObject entryRuleVarMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarMode = null;


        try {
            // InternalNavascript.g:4677:48: (iv_ruleVarMode= ruleVarMode EOF )
            // InternalNavascript.g:4678:2: iv_ruleVarMode= ruleVarMode EOF
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
    // InternalNavascript.g:4684:1: ruleVarMode returns [EObject current=null] : ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) ;
    public final EObject ruleVarMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_mode_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4690:2: ( ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) ) )
            // InternalNavascript.g:4691:2: ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            {
            // InternalNavascript.g:4691:2: ( () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) ) )
            // InternalNavascript.g:4692:3: () otherlv_1= 'mode' (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_mode_4_0= ruleMessageMode ) )
            {
            // InternalNavascript.g:4692:3: ()
            // InternalNavascript.g:4693:4: 
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

            otherlv_1=(Token)match(input,67,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getVarModeAccess().getModeKeyword_1());
              		
            }
            // InternalNavascript.g:4706:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==40) ) {
                alt86=1;
            }
            else if ( (LA86_0==41) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalNavascript.g:4707:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVarModeAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4712:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVarModeAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:4717:3: ( (lv_mode_4_0= ruleMessageMode ) )
            // InternalNavascript.g:4718:4: (lv_mode_4_0= ruleMessageMode )
            {
            // InternalNavascript.g:4718:4: (lv_mode_4_0= ruleMessageMode )
            // InternalNavascript.g:4719:5: lv_mode_4_0= ruleMessageMode
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
    // InternalNavascript.g:4740:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalNavascript.g:4740:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalNavascript.g:4741:2: iv_ruleProperty= ruleProperty EOF
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
    // InternalNavascript.g:4747:1: ruleProperty returns [EObject current=null] : ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) ;
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
            // InternalNavascript.g:4753:2: ( ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) ) )
            // InternalNavascript.g:4754:2: ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            {
            // InternalNavascript.g:4754:2: ( () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) ) )
            // InternalNavascript.g:4755:3: () otherlv_1= 'property' ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) ) ( (lv_arguments_3_0= rulePropertyArguments ) )? ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            {
            // InternalNavascript.g:4755:3: ()
            // InternalNavascript.g:4756:4: 
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

            otherlv_1=(Token)match(input,72,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getPropertyKeyword_1());
              		
            }
            // InternalNavascript.g:4769:3: ( (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER ) )
            // InternalNavascript.g:4770:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            {
            // InternalNavascript.g:4770:4: (lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER )
            // InternalNavascript.g:4771:5: lv_propertyName_2_0= RULE_QUOTED_IDENTIFIER
            {
            lv_propertyName_2_0=(Token)match(input,RULE_QUOTED_IDENTIFIER,FOLLOW_59); if (state.failed) return current;
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

            // InternalNavascript.g:4787:3: ( (lv_arguments_3_0= rulePropertyArguments ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==36) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalNavascript.g:4788:4: (lv_arguments_3_0= rulePropertyArguments )
                    {
                    // InternalNavascript.g:4788:4: (lv_arguments_3_0= rulePropertyArguments )
                    // InternalNavascript.g:4789:5: lv_arguments_3_0= rulePropertyArguments
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyAccess().getArgumentsPropertyArgumentsParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_60);
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

            // InternalNavascript.g:4806:3: ( ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' ) | (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' ) | (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' ) | (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' ) )
            int alt90=4;
            switch ( input.LA(1) ) {
            case 40:
            case 41:
            case 48:
                {
                alt90=1;
                }
                break;
            case 64:
                {
                alt90=2;
                }
                break;
            case 29:
                {
                int LA90_3 = input.LA(2);

                if ( (LA90_3==RULE_MAPPABLE_IDENTIFIER) ) {
                    alt90=3;
                }
                else if ( (LA90_3==RULE_TML_LITERAL) ) {
                    alt90=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalNavascript.g:4807:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    {
                    // InternalNavascript.g:4807:4: ( ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';' )
                    // InternalNavascript.g:4808:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )? otherlv_7= ';'
                    {
                    // InternalNavascript.g:4808:5: ( (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( ((LA89_0>=40 && LA89_0<=41)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalNavascript.g:4809:6: (otherlv_4= '=' | otherlv_5= ':' ) ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            {
                            // InternalNavascript.g:4809:6: (otherlv_4= '=' | otherlv_5= ':' )
                            int alt88=2;
                            int LA88_0 = input.LA(1);

                            if ( (LA88_0==40) ) {
                                alt88=1;
                            }
                            else if ( (LA88_0==41) ) {
                                alt88=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 88, 0, input);

                                throw nvae;
                            }
                            switch (alt88) {
                                case 1 :
                                    // InternalNavascript.g:4810:7: otherlv_4= '='
                                    {
                                    otherlv_4=(Token)match(input,40,FOLLOW_52); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_4, grammarAccess.getPropertyAccess().getEqualsSignKeyword_4_0_0_0_0());
                                      						
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalNavascript.g:4815:7: otherlv_5= ':'
                                    {
                                    otherlv_5=(Token)match(input,41,FOLLOW_52); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonKeyword_4_0_0_0_1());
                                      						
                                    }

                                    }
                                    break;

                            }

                            // InternalNavascript.g:4820:6: ( (lv_expressionList_6_0= ruleConditionalExpressions ) )
                            // InternalNavascript.g:4821:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            {
                            // InternalNavascript.g:4821:7: (lv_expressionList_6_0= ruleConditionalExpressions )
                            // InternalNavascript.g:4822:8: lv_expressionList_6_0= ruleConditionalExpressions
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getPropertyAccess().getExpressionListConditionalExpressionsParserRuleCall_4_0_0_1_0());
                              							
                            }
                            pushFollow(FOLLOW_24);
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

                    otherlv_7=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getPropertyAccess().getSemicolonKeyword_4_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:4846:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    {
                    // InternalNavascript.g:4846:4: (otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']' )
                    // InternalNavascript.g:4847:5: otherlv_8= '[' ( (lv_selectionArray_9_0= ruleSelectionArray ) ) otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,64,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getPropertyAccess().getLeftSquareBracketKeyword_4_1_0());
                      				
                    }
                    // InternalNavascript.g:4851:5: ( (lv_selectionArray_9_0= ruleSelectionArray ) )
                    // InternalNavascript.g:4852:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    {
                    // InternalNavascript.g:4852:6: (lv_selectionArray_9_0= ruleSelectionArray )
                    // InternalNavascript.g:4853:7: lv_selectionArray_9_0= ruleSelectionArray
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getSelectionArraySelectionArrayParserRuleCall_4_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_41);
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

                    otherlv_10=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getPropertyAccess().getRightSquareBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:4876:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    {
                    // InternalNavascript.g:4876:4: (otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}' )
                    // InternalNavascript.g:4877:5: otherlv_11= '{' ( (lv_arrayField_12_0= ruleMappedArrayField ) ) otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,29,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_2_0());
                      				
                    }
                    // InternalNavascript.g:4881:5: ( (lv_arrayField_12_0= ruleMappedArrayField ) )
                    // InternalNavascript.g:4882:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    {
                    // InternalNavascript.g:4882:6: (lv_arrayField_12_0= ruleMappedArrayField )
                    // InternalNavascript.g:4883:7: lv_arrayField_12_0= ruleMappedArrayField
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayFieldMappedArrayFieldParserRuleCall_4_2_1_0());
                      						
                    }
                    pushFollow(FOLLOW_31);
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

                    otherlv_13=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_13, grammarAccess.getPropertyAccess().getRightCurlyBracketKeyword_4_2_2());
                      				
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:4906:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    {
                    // InternalNavascript.g:4906:4: (otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}' )
                    // InternalNavascript.g:4907:5: otherlv_14= '{' ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) ) otherlv_16= '}'
                    {
                    otherlv_14=(Token)match(input,29,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_14, grammarAccess.getPropertyAccess().getLeftCurlyBracketKeyword_4_3_0());
                      				
                    }
                    // InternalNavascript.g:4911:5: ( (lv_arrayMessage_15_0= ruleMappedArrayMessage ) )
                    // InternalNavascript.g:4912:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    {
                    // InternalNavascript.g:4912:6: (lv_arrayMessage_15_0= ruleMappedArrayMessage )
                    // InternalNavascript.g:4913:7: lv_arrayMessage_15_0= ruleMappedArrayMessage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyAccess().getArrayMessageMappedArrayMessageParserRuleCall_4_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_31);
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

                    otherlv_16=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:4940:1: entryRuleSelectionArray returns [EObject current=null] : iv_ruleSelectionArray= ruleSelectionArray EOF ;
    public final EObject entryRuleSelectionArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArray = null;


        try {
            // InternalNavascript.g:4940:55: (iv_ruleSelectionArray= ruleSelectionArray EOF )
            // InternalNavascript.g:4941:2: iv_ruleSelectionArray= ruleSelectionArray EOF
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
    // InternalNavascript.g:4947:1: ruleSelectionArray returns [EObject current=null] : ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) ;
    public final EObject ruleSelectionArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_arrayElements_0_0 = null;

        EObject lv_arrayElements_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:4953:2: ( ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* ) )
            // InternalNavascript.g:4954:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            {
            // InternalNavascript.g:4954:2: ( ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )* )
            // InternalNavascript.g:4955:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) ) (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            {
            // InternalNavascript.g:4955:3: ( (lv_arrayElements_0_0= ruleSelectionArrayElement ) )
            // InternalNavascript.g:4956:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            {
            // InternalNavascript.g:4956:4: (lv_arrayElements_0_0= ruleSelectionArrayElement )
            // InternalNavascript.g:4957:5: lv_arrayElements_0_0= ruleSelectionArrayElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSelectionArrayAccess().getArrayElementsSelectionArrayElementParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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

            // InternalNavascript.g:4974:3: (otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==38) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalNavascript.g:4975:4: otherlv_1= ',' ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    {
            	    otherlv_1=(Token)match(input,38,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getSelectionArrayAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalNavascript.g:4979:4: ( (lv_arrayElements_2_0= ruleSelectionArrayElement ) )
            	    // InternalNavascript.g:4980:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    {
            	    // InternalNavascript.g:4980:5: (lv_arrayElements_2_0= ruleSelectionArrayElement )
            	    // InternalNavascript.g:4981:6: lv_arrayElements_2_0= ruleSelectionArrayElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSelectionArrayAccess().getArrayElementsSelectionArrayElementParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
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
            	    break loop91;
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
    // InternalNavascript.g:5003:1: entryRuleSelectionArrayElement returns [EObject current=null] : iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF ;
    public final EObject entryRuleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionArrayElement = null;


        try {
            // InternalNavascript.g:5003:62: (iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF )
            // InternalNavascript.g:5004:2: iv_ruleSelectionArrayElement= ruleSelectionArrayElement EOF
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
    // InternalNavascript.g:5010:1: ruleSelectionArrayElement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) ;
    public final EObject ruleSelectionArrayElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_innerBody_2_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5016:2: ( ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' ) )
            // InternalNavascript.g:5017:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            {
            // InternalNavascript.g:5017:2: ( () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}' )
            // InternalNavascript.g:5018:3: () otherlv_1= '{' ( (lv_innerBody_2_0= ruleInnerBody ) )* otherlv_3= '}'
            {
            // InternalNavascript.g:5018:3: ()
            // InternalNavascript.g:5019:4: 
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

            otherlv_1=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSelectionArrayElementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalNavascript.g:5032:3: ( (lv_innerBody_2_0= ruleInnerBody ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==RULE_MAPPABLE_IDENTIFIER||LA92_0==RULE_METHOD_IDENTIFIER||LA92_0==27||LA92_0==29||LA92_0==47||LA92_0==53||(LA92_0>=55 && LA92_0<=56)||(LA92_0>=58 && LA92_0<=59)||(LA92_0>=61 && LA92_0<=63)||(LA92_0>=68 && LA92_0<=69)||(LA92_0>=71 && LA92_0<=73)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalNavascript.g:5033:4: (lv_innerBody_2_0= ruleInnerBody )
            	    {
            	    // InternalNavascript.g:5033:4: (lv_innerBody_2_0= ruleInnerBody )
            	    // InternalNavascript.g:5034:5: lv_innerBody_2_0= ruleInnerBody
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSelectionArrayElementAccess().getInnerBodyInnerBodyParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_11);
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
            	    break loop92;
                }
            } while (true);

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:5059:1: entryRuleOption returns [EObject current=null] : iv_ruleOption= ruleOption EOF ;
    public final EObject entryRuleOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOption = null;


        try {
            // InternalNavascript.g:5059:47: (iv_ruleOption= ruleOption EOF )
            // InternalNavascript.g:5060:2: iv_ruleOption= ruleOption EOF
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
    // InternalNavascript.g:5066:1: ruleOption returns [EObject current=null] : (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) ;
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
            // InternalNavascript.g:5072:2: ( (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' ) )
            // InternalNavascript.g:5073:2: (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            {
            // InternalNavascript.g:5073:2: (otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';' )
            // InternalNavascript.g:5074:3: otherlv_0= 'option' ( (lv_option_1_0= ruleOPTION_TYPE ) ) (otherlv_2= '=' | otherlv_3= ':' ) ( (lv_expressionList_4_0= ruleConditionalExpressions ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOptionAccess().getOptionKeyword_0());
              		
            }
            // InternalNavascript.g:5078:3: ( (lv_option_1_0= ruleOPTION_TYPE ) )
            // InternalNavascript.g:5079:4: (lv_option_1_0= ruleOPTION_TYPE )
            {
            // InternalNavascript.g:5079:4: (lv_option_1_0= ruleOPTION_TYPE )
            // InternalNavascript.g:5080:5: lv_option_1_0= ruleOPTION_TYPE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionAccess().getOptionOPTION_TYPEParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
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

            // InternalNavascript.g:5097:3: (otherlv_2= '=' | otherlv_3= ':' )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==40) ) {
                alt93=1;
            }
            else if ( (LA93_0==41) ) {
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
                    // InternalNavascript.g:5098:4: otherlv_2= '='
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionAccess().getEqualsSignKeyword_2_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5103:4: otherlv_3= ':'
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getColonKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5108:3: ( (lv_expressionList_4_0= ruleConditionalExpressions ) )
            // InternalNavascript.g:5109:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            {
            // InternalNavascript.g:5109:4: (lv_expressionList_4_0= ruleConditionalExpressions )
            // InternalNavascript.g:5110:5: lv_expressionList_4_0= ruleConditionalExpressions
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionAccess().getExpressionListConditionalExpressionsParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_24);
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

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:5135:1: entryRulePropertyArguments returns [EObject current=null] : iv_rulePropertyArguments= rulePropertyArguments EOF ;
    public final EObject entryRulePropertyArguments() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArguments = null;


        try {
            // InternalNavascript.g:5135:58: (iv_rulePropertyArguments= rulePropertyArguments EOF )
            // InternalNavascript.g:5136:2: iv_rulePropertyArguments= rulePropertyArguments EOF
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
    // InternalNavascript.g:5142:1: rulePropertyArguments returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' ) ;
    public final EObject rulePropertyArguments() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5148:2: ( ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' ) )
            // InternalNavascript.g:5149:2: ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' )
            {
            // InternalNavascript.g:5149:2: ( () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')' )
            // InternalNavascript.g:5150:3: () otherlv_1= '(' ( (lv_arguments_2_0= rulePropertyArgument ) ) (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )* otherlv_5= ')'
            {
            // InternalNavascript.g:5150:3: ()
            // InternalNavascript.g:5151:4: 
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

            otherlv_1=(Token)match(input,36,FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyArgumentsAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalNavascript.g:5164:3: ( (lv_arguments_2_0= rulePropertyArgument ) )
            // InternalNavascript.g:5165:4: (lv_arguments_2_0= rulePropertyArgument )
            {
            // InternalNavascript.g:5165:4: (lv_arguments_2_0= rulePropertyArgument )
            // InternalNavascript.g:5166:5: lv_arguments_2_0= rulePropertyArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyArgumentsAccess().getArgumentsPropertyArgumentParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            // InternalNavascript.g:5183:3: (otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==38) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalNavascript.g:5184:4: otherlv_3= ',' ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    {
            	    otherlv_3=(Token)match(input,38,FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getPropertyArgumentsAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalNavascript.g:5188:4: ( (lv_arguments_4_0= rulePropertyArgument ) )
            	    // InternalNavascript.g:5189:5: (lv_arguments_4_0= rulePropertyArgument )
            	    {
            	    // InternalNavascript.g:5189:5: (lv_arguments_4_0= rulePropertyArgument )
            	    // InternalNavascript.g:5190:6: lv_arguments_4_0= rulePropertyArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPropertyArgumentsAccess().getArgumentsPropertyArgumentParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
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
            	    break loop94;
                }
            } while (true);

            otherlv_5=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:5216:1: entryRulePropertyArgument returns [EObject current=null] : iv_rulePropertyArgument= rulePropertyArgument EOF ;
    public final EObject entryRulePropertyArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyArgument = null;


        try {
            // InternalNavascript.g:5216:57: (iv_rulePropertyArgument= rulePropertyArgument EOF )
            // InternalNavascript.g:5217:2: iv_rulePropertyArgument= rulePropertyArgument EOF
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
    // InternalNavascript.g:5223:1: rulePropertyArgument returns [EObject current=null] : (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) ;
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
            // InternalNavascript.g:5229:2: ( (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument ) )
            // InternalNavascript.g:5230:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            {
            // InternalNavascript.g:5230:2: (this_DirectionArgument_0= ruleDirectionArgument | this_TypeArgument_1= ruleTypeArgument | this_SubTypeArgument_2= ruleSubTypeArgument | this_DescriptionArgument_3= ruleDescriptionArgument | this_CardinalityArgument_4= ruleCardinalityArgument | this_LengthArgument_5= ruleLengthArgument )
            int alt95=6;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt95=1;
                }
                break;
            case 66:
                {
                alt95=2;
                }
                break;
            case 81:
                {
                alt95=3;
                }
                break;
            case 50:
                {
                alt95=4;
                }
                break;
            case 79:
                {
                alt95=5;
                }
                break;
            case 74:
                {
                alt95=6;
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
                    // InternalNavascript.g:5231:3: this_DirectionArgument_0= ruleDirectionArgument
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
                    // InternalNavascript.g:5243:3: this_TypeArgument_1= ruleTypeArgument
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
                    // InternalNavascript.g:5255:3: this_SubTypeArgument_2= ruleSubTypeArgument
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
                    // InternalNavascript.g:5267:3: this_DescriptionArgument_3= ruleDescriptionArgument
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
                    // InternalNavascript.g:5279:3: this_CardinalityArgument_4= ruleCardinalityArgument
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
                    // InternalNavascript.g:5291:3: this_LengthArgument_5= ruleLengthArgument
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
    // InternalNavascript.g:5306:1: entryRuleLengthArgument returns [EObject current=null] : iv_ruleLengthArgument= ruleLengthArgument EOF ;
    public final EObject entryRuleLengthArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLengthArgument = null;


        try {
            // InternalNavascript.g:5306:55: (iv_ruleLengthArgument= ruleLengthArgument EOF )
            // InternalNavascript.g:5307:2: iv_ruleLengthArgument= ruleLengthArgument EOF
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
    // InternalNavascript.g:5313:1: ruleLengthArgument returns [EObject current=null] : (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleLengthArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5319:2: ( (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) ) )
            // InternalNavascript.g:5320:2: (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            {
            // InternalNavascript.g:5320:2: (otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) ) )
            // InternalNavascript.g:5321:3: otherlv_0= 'length' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_INTEGER ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLengthArgumentAccess().getLengthKeyword_0());
              		
            }
            // InternalNavascript.g:5325:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==40) ) {
                alt96=1;
            }
            else if ( (LA96_0==41) ) {
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
                    // InternalNavascript.g:5326:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_62); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLengthArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5331:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_62); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getLengthArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5336:3: ( (lv_value_3_0= RULE_INTEGER ) )
            // InternalNavascript.g:5337:4: (lv_value_3_0= RULE_INTEGER )
            {
            // InternalNavascript.g:5337:4: (lv_value_3_0= RULE_INTEGER )
            // InternalNavascript.g:5338:5: lv_value_3_0= RULE_INTEGER
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
    // InternalNavascript.g:5358:1: entryRuleDirectionArgument returns [EObject current=null] : iv_ruleDirectionArgument= ruleDirectionArgument EOF ;
    public final EObject entryRuleDirectionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectionArgument = null;


        try {
            // InternalNavascript.g:5358:58: (iv_ruleDirectionArgument= ruleDirectionArgument EOF )
            // InternalNavascript.g:5359:2: iv_ruleDirectionArgument= ruleDirectionArgument EOF
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
    // InternalNavascript.g:5365:1: ruleDirectionArgument returns [EObject current=null] : (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) ) ;
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
            // InternalNavascript.g:5371:2: ( (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) ) )
            // InternalNavascript.g:5372:2: (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) )
            {
            // InternalNavascript.g:5372:2: (otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) ) )
            // InternalNavascript.g:5373:3: otherlv_0= 'direction' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDirectionArgumentAccess().getDirectionKeyword_0());
              		
            }
            // InternalNavascript.g:5377:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==40) ) {
                alt97=1;
            }
            else if ( (LA97_0==41) ) {
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
                    // InternalNavascript.g:5378:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDirectionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5383:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDirectionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5388:3: ( ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) ) )
            // InternalNavascript.g:5389:4: ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) )
            {
            // InternalNavascript.g:5389:4: ( (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' ) )
            // InternalNavascript.g:5390:5: (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' )
            {
            // InternalNavascript.g:5390:5: (lv_value_3_1= 'in' | lv_value_3_2= 'out' | lv_value_3_3= 'inout' )
            int alt98=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt98=1;
                }
                break;
            case 77:
                {
                alt98=2;
                }
                break;
            case 78:
                {
                alt98=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // InternalNavascript.g:5391:6: lv_value_3_1= 'in'
                    {
                    lv_value_3_1=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
                    // InternalNavascript.g:5402:6: lv_value_3_2= 'out'
                    {
                    lv_value_3_2=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
                    // InternalNavascript.g:5413:6: lv_value_3_3= 'inout'
                    {
                    lv_value_3_3=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:5430:1: entryRuleDescriptionArgument returns [EObject current=null] : iv_ruleDescriptionArgument= ruleDescriptionArgument EOF ;
    public final EObject entryRuleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionArgument = null;


        try {
            // InternalNavascript.g:5430:60: (iv_ruleDescriptionArgument= ruleDescriptionArgument EOF )
            // InternalNavascript.g:5431:2: iv_ruleDescriptionArgument= ruleDescriptionArgument EOF
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
    // InternalNavascript.g:5437:1: ruleDescriptionArgument returns [EObject current=null] : (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleDescriptionArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5443:2: ( (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5444:2: (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5444:2: (otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5445:3: otherlv_0= 'description' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= ruleLiteralOrExpression ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDescriptionArgumentAccess().getDescriptionKeyword_0());
              		
            }
            // InternalNavascript.g:5449:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==40) ) {
                alt99=1;
            }
            else if ( (LA99_0==41) ) {
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
                    // InternalNavascript.g:5450:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDescriptionArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5455:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDescriptionArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5460:3: ( (lv_value_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5461:4: (lv_value_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5461:4: (lv_value_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5462:5: lv_value_3_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5483:1: entryRuleCardinalityArgument returns [EObject current=null] : iv_ruleCardinalityArgument= ruleCardinalityArgument EOF ;
    public final EObject entryRuleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCardinalityArgument = null;


        try {
            // InternalNavascript.g:5483:60: (iv_ruleCardinalityArgument= ruleCardinalityArgument EOF )
            // InternalNavascript.g:5484:2: iv_ruleCardinalityArgument= ruleCardinalityArgument EOF
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
    // InternalNavascript.g:5490:1: ruleCardinalityArgument returns [EObject current=null] : (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) ) ;
    public final EObject ruleCardinalityArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;


        	enterRule();

        try {
            // InternalNavascript.g:5496:2: ( (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) ) )
            // InternalNavascript.g:5497:2: (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) )
            {
            // InternalNavascript.g:5497:2: (otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) ) )
            // InternalNavascript.g:5498:3: otherlv_0= 'cardinality' (otherlv_1= '=' | otherlv_2= ':' ) ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) )
            {
            otherlv_0=(Token)match(input,79,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCardinalityArgumentAccess().getCardinalityKeyword_0());
              		
            }
            // InternalNavascript.g:5502:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==40) ) {
                alt100=1;
            }
            else if ( (LA100_0==41) ) {
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
                    // InternalNavascript.g:5503:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCardinalityArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5508:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getCardinalityArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5513:3: ( ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) ) )
            // InternalNavascript.g:5514:4: ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) )
            {
            // InternalNavascript.g:5514:4: ( (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE ) )
            // InternalNavascript.g:5515:5: (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE )
            {
            // InternalNavascript.g:5515:5: (lv_value_3_1= '+' | lv_value_3_2= RULE_ONE )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==80) ) {
                alt101=1;
            }
            else if ( (LA101_0==RULE_ONE) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // InternalNavascript.g:5516:6: lv_value_3_1= '+'
                    {
                    lv_value_3_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
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
                    // InternalNavascript.g:5527:6: lv_value_3_2= RULE_ONE
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
    // InternalNavascript.g:5548:1: entryRuleTypeArgument returns [EObject current=null] : iv_ruleTypeArgument= ruleTypeArgument EOF ;
    public final EObject entryRuleTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeArgument = null;


        try {
            // InternalNavascript.g:5548:53: (iv_ruleTypeArgument= ruleTypeArgument EOF )
            // InternalNavascript.g:5549:2: iv_ruleTypeArgument= ruleTypeArgument EOF
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
    // InternalNavascript.g:5555:1: ruleTypeArgument returns [EObject current=null] : (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) ;
    public final EObject ruleTypeArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5561:2: ( (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) ) )
            // InternalNavascript.g:5562:2: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            {
            // InternalNavascript.g:5562:2: (otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) ) )
            // InternalNavascript.g:5563:3: otherlv_0= 'type' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= rulePropertyType ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeArgumentAccess().getTypeKeyword_0());
              		
            }
            // InternalNavascript.g:5567:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==40) ) {
                alt102=1;
            }
            else if ( (LA102_0==41) ) {
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
                    // InternalNavascript.g:5568:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5573:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5578:3: ( (lv_value_3_0= rulePropertyType ) )
            // InternalNavascript.g:5579:4: (lv_value_3_0= rulePropertyType )
            {
            // InternalNavascript.g:5579:4: (lv_value_3_0= rulePropertyType )
            // InternalNavascript.g:5580:5: lv_value_3_0= rulePropertyType
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
    // InternalNavascript.g:5601:1: entryRuleSubTypeArgument returns [EObject current=null] : iv_ruleSubTypeArgument= ruleSubTypeArgument EOF ;
    public final EObject entryRuleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubTypeArgument = null;


        try {
            // InternalNavascript.g:5601:56: (iv_ruleSubTypeArgument= ruleSubTypeArgument EOF )
            // InternalNavascript.g:5602:2: iv_ruleSubTypeArgument= ruleSubTypeArgument EOF
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
    // InternalNavascript.g:5608:1: ruleSubTypeArgument returns [EObject current=null] : (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) ;
    public final EObject ruleSubTypeArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:5614:2: ( (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) ) )
            // InternalNavascript.g:5615:2: (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            {
            // InternalNavascript.g:5615:2: (otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) ) )
            // InternalNavascript.g:5616:3: otherlv_0= 'subtype' (otherlv_1= '=' | otherlv_2= ':' ) ( (lv_value_3_0= RULE_IDENTIFIER ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSubTypeArgumentAccess().getSubtypeKeyword_0());
              		
            }
            // InternalNavascript.g:5620:3: (otherlv_1= '=' | otherlv_2= ':' )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==40) ) {
                alt103=1;
            }
            else if ( (LA103_0==41) ) {
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
                    // InternalNavascript.g:5621:4: otherlv_1= '='
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSubTypeArgumentAccess().getEqualsSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:5626:4: otherlv_2= ':'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubTypeArgumentAccess().getColonKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalNavascript.g:5631:3: ( (lv_value_3_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:5632:4: (lv_value_3_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:5632:4: (lv_value_3_0= RULE_IDENTIFIER )
            // InternalNavascript.g:5633:5: lv_value_3_0= RULE_IDENTIFIER
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
    // InternalNavascript.g:5653:1: entryRuleConditionalExpressions returns [EObject current=null] : iv_ruleConditionalExpressions= ruleConditionalExpressions EOF ;
    public final EObject entryRuleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpressions = null;


        try {
            // InternalNavascript.g:5653:63: (iv_ruleConditionalExpressions= ruleConditionalExpressions EOF )
            // InternalNavascript.g:5654:2: iv_ruleConditionalExpressions= ruleConditionalExpressions EOF
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
    // InternalNavascript.g:5660:1: ruleConditionalExpressions returns [EObject current=null] : ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpressions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_conditionalExpressions_1_0 = null;

        EObject lv_elseExpresssion_3_0 = null;

        EObject lv_singleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5666:2: ( ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5667:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5667:2: ( ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) ) | ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==27) ) {
                alt105=1;
            }
            else if ( ((LA105_0>=RULE_QUOTED_IDENTIFIER && LA105_0<=RULE_IDENTIFIER)||(LA105_0>=RULE_TML_LITERAL && LA105_0<=RULE_EXISTS)||LA105_0==36||LA105_0==91||(LA105_0>=94 && LA105_0<=95)) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalNavascript.g:5668:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    {
                    // InternalNavascript.g:5668:3: ( () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) ) )
                    // InternalNavascript.g:5669:4: () ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+ otherlv_2= 'else' ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5669:4: ()
                    // InternalNavascript.g:5670:5: 
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

                    // InternalNavascript.g:5679:4: ( (lv_conditionalExpressions_1_0= ruleConditionalExpression ) )+
                    int cnt104=0;
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==27) ) {
                            alt104=1;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalNavascript.g:5680:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    {
                    	    // InternalNavascript.g:5680:5: (lv_conditionalExpressions_1_0= ruleConditionalExpression )
                    	    // InternalNavascript.g:5681:6: lv_conditionalExpressions_1_0= ruleConditionalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getConditionalExpressionsAccess().getConditionalExpressionsConditionalExpressionParserRuleCall_0_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_65);
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
                    	    if ( cnt104 >= 1 ) break loop104;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(104, input);
                                throw eee;
                        }
                        cnt104++;
                    } while (true);

                    otherlv_2=(Token)match(input,82,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionsAccess().getElseKeyword_0_2());
                      			
                    }
                    // InternalNavascript.g:5702:4: ( (lv_elseExpresssion_3_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5703:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5703:5: (lv_elseExpresssion_3_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5704:6: lv_elseExpresssion_3_0= ruleLiteralOrExpression
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
                    // InternalNavascript.g:5723:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    {
                    // InternalNavascript.g:5723:3: ( (lv_singleExpression_4_0= ruleLiteralOrExpression ) )
                    // InternalNavascript.g:5724:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    {
                    // InternalNavascript.g:5724:4: (lv_singleExpression_4_0= ruleLiteralOrExpression )
                    // InternalNavascript.g:5725:5: lv_singleExpression_4_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5746:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalNavascript.g:5746:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalNavascript.g:5747:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalNavascript.g:5753:1: ruleConditionalExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5759:2: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) ) )
            // InternalNavascript.g:5760:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            {
            // InternalNavascript.g:5760:2: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) ) )
            // InternalNavascript.g:5761:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConditionalExpressionAccess().getIfKeyword_0());
              		
            }
            // InternalNavascript.g:5765:3: ( (lv_condition_1_0= ruleExpression ) )
            // InternalNavascript.g:5766:4: (lv_condition_1_0= ruleExpression )
            {
            // InternalNavascript.g:5766:4: (lv_condition_1_0= ruleExpression )
            // InternalNavascript.g:5767:5: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_2=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getThenKeyword_2());
              		
            }
            // InternalNavascript.g:5788:3: ( (lv_expression_3_0= ruleLiteralOrExpression ) )
            // InternalNavascript.g:5789:4: (lv_expression_3_0= ruleLiteralOrExpression )
            {
            // InternalNavascript.g:5789:4: (lv_expression_3_0= ruleLiteralOrExpression )
            // InternalNavascript.g:5790:5: lv_expression_3_0= ruleLiteralOrExpression
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
    // InternalNavascript.g:5811:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalNavascript.g:5811:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalNavascript.g:5812:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalNavascript.g:5818:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5824:2: (this_BooleanExpression_0= ruleBooleanExpression )
            // InternalNavascript.g:5825:2: this_BooleanExpression_0= ruleBooleanExpression
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
    // InternalNavascript.g:5839:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalNavascript.g:5839:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalNavascript.g:5840:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalNavascript.g:5846:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:5852:2: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalNavascript.g:5853:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalNavascript.g:5853:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalNavascript.g:5854:3: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_66);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5865:3: ( ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( ((LA107_0>=83 && LA107_0<=84)) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalNavascript.g:5866:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalNavascript.g:5866:4: ( () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) ) )
            	    // InternalNavascript.g:5867:5: () ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    {
            	    // InternalNavascript.g:5867:5: ()
            	    // InternalNavascript.g:5868:6: 
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

            	    // InternalNavascript.g:5877:5: ( ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) ) )
            	    // InternalNavascript.g:5878:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    {
            	    // InternalNavascript.g:5878:6: ( (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' ) )
            	    // InternalNavascript.g:5879:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    {
            	    // InternalNavascript.g:5879:7: (lv_op_2_1= 'OR' | lv_op_2_2= 'AND' )
            	    int alt106=2;
            	    int LA106_0 = input.LA(1);

            	    if ( (LA106_0==83) ) {
            	        alt106=1;
            	    }
            	    else if ( (LA106_0==84) ) {
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
            	            // InternalNavascript.g:5880:8: lv_op_2_1= 'OR'
            	            {
            	            lv_op_2_1=(Token)match(input,83,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:5891:8: lv_op_2_2= 'AND'
            	            {
            	            lv_op_2_2=(Token)match(input,84,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalNavascript.g:5905:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalNavascript.g:5906:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalNavascript.g:5906:5: (lv_right_3_0= ruleComparison )
            	    // InternalNavascript.g:5907:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_66);
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
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleComparison"
    // InternalNavascript.g:5929:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalNavascript.g:5929:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalNavascript.g:5930:2: iv_ruleComparison= ruleComparison EOF
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
    // InternalNavascript.g:5936:1: ruleComparison returns [EObject current=null] : (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) ;
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
            // InternalNavascript.g:5942:2: ( (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* ) )
            // InternalNavascript.g:5943:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            {
            // InternalNavascript.g:5943:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )* )
            // InternalNavascript.g:5944:3: this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getEqualsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_67);
            this_Equals_0=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Equals_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:5955:3: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( ((LA109_0>=85 && LA109_0<=88)) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalNavascript.g:5956:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleEquals ) )
            	    {
            	    // InternalNavascript.g:5956:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) )
            	    // InternalNavascript.g:5957:5: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    {
            	    // InternalNavascript.g:5957:5: ()
            	    // InternalNavascript.g:5958:6: 
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

            	    // InternalNavascript.g:5967:5: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalNavascript.g:5968:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalNavascript.g:5968:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalNavascript.g:5969:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalNavascript.g:5969:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt108=4;
            	    switch ( input.LA(1) ) {
            	    case 85:
            	        {
            	        alt108=1;
            	        }
            	        break;
            	    case 86:
            	        {
            	        alt108=2;
            	        }
            	        break;
            	    case 87:
            	        {
            	        alt108=3;
            	        }
            	        break;
            	    case 88:
            	        {
            	        alt108=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 108, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt108) {
            	        case 1 :
            	            // InternalNavascript.g:5970:8: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,85,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:5981:8: lv_op_2_2= '>'
            	            {
            	            lv_op_2_2=(Token)match(input,86,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:5992:8: lv_op_2_3= '<='
            	            {
            	            lv_op_2_3=(Token)match(input,87,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:6003:8: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,88,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalNavascript.g:6017:4: ( (lv_right_3_0= ruleEquals ) )
            	    // InternalNavascript.g:6018:5: (lv_right_3_0= ruleEquals )
            	    {
            	    // InternalNavascript.g:6018:5: (lv_right_3_0= ruleEquals )
            	    // InternalNavascript.g:6019:6: lv_right_3_0= ruleEquals
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightEqualsParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_67);
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleEquals"
    // InternalNavascript.g:6041:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalNavascript.g:6041:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalNavascript.g:6042:2: iv_ruleEquals= ruleEquals EOF
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
    // InternalNavascript.g:6048:1: ruleEquals returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6054:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalNavascript.g:6055:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalNavascript.g:6055:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalNavascript.g:6056:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualsAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_68);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:6067:3: ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( ((LA111_0>=89 && LA111_0<=90)) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalNavascript.g:6068:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalNavascript.g:6068:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) )
            	    // InternalNavascript.g:6069:5: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    {
            	    // InternalNavascript.g:6069:5: ()
            	    // InternalNavascript.g:6070:6: 
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

            	    // InternalNavascript.g:6079:5: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalNavascript.g:6080:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalNavascript.g:6080:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalNavascript.g:6081:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalNavascript.g:6081:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt110=2;
            	    int LA110_0 = input.LA(1);

            	    if ( (LA110_0==89) ) {
            	        alt110=1;
            	    }
            	    else if ( (LA110_0==90) ) {
            	        alt110=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 110, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt110) {
            	        case 1 :
            	            // InternalNavascript.g:6082:8: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,89,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:6093:8: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,90,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalNavascript.g:6107:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalNavascript.g:6108:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalNavascript.g:6108:5: (lv_right_3_0= ruleAddition )
            	    // InternalNavascript.g:6109:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualsAccess().getRightAdditionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_68);
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
            	    break loop111;
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
    // InternalNavascript.g:6131:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalNavascript.g:6131:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalNavascript.g:6132:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalNavascript.g:6138:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6144:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalNavascript.g:6145:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalNavascript.g:6145:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalNavascript.g:6146:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_69);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:6157:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==80||LA113_0==91) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalNavascript.g:6158:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalNavascript.g:6158:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt112=2;
            	    int LA112_0 = input.LA(1);

            	    if ( (LA112_0==80) ) {
            	        alt112=1;
            	    }
            	    else if ( (LA112_0==91) ) {
            	        alt112=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 112, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt112) {
            	        case 1 :
            	            // InternalNavascript.g:6159:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalNavascript.g:6159:5: ( () otherlv_2= '+' )
            	            // InternalNavascript.g:6160:6: () otherlv_2= '+'
            	            {
            	            // InternalNavascript.g:6160:6: ()
            	            // InternalNavascript.g:6161:7: 
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

            	            otherlv_2=(Token)match(input,80,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalNavascript.g:6176:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalNavascript.g:6176:5: ( () otherlv_4= '-' )
            	            // InternalNavascript.g:6177:6: () otherlv_4= '-'
            	            {
            	            // InternalNavascript.g:6177:6: ()
            	            // InternalNavascript.g:6178:7: 
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

            	            otherlv_4=(Token)match(input,91,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // InternalNavascript.g:6193:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalNavascript.g:6194:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalNavascript.g:6194:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalNavascript.g:6195:6: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_69);
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
            	    break loop113;
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
    // InternalNavascript.g:6217:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalNavascript.g:6217:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalNavascript.g:6218:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalNavascript.g:6224:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6230:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalNavascript.g:6231:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalNavascript.g:6231:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalNavascript.g:6232:3: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_70);
            this_Prefixed_0=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prefixed_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalNavascript.g:6243:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( ((LA115_0>=92 && LA115_0<=93)) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalNavascript.g:6244:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalNavascript.g:6244:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalNavascript.g:6245:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalNavascript.g:6245:5: ()
            	    // InternalNavascript.g:6246:6: 
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

            	    // InternalNavascript.g:6255:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalNavascript.g:6256:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalNavascript.g:6256:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalNavascript.g:6257:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalNavascript.g:6257:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt114=2;
            	    int LA114_0 = input.LA(1);

            	    if ( (LA114_0==92) ) {
            	        alt114=1;
            	    }
            	    else if ( (LA114_0==93) ) {
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
            	            // InternalNavascript.g:6258:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,92,FOLLOW_7); if (state.failed) return current;
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
            	            // InternalNavascript.g:6269:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,93,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalNavascript.g:6283:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalNavascript.g:6284:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalNavascript.g:6284:5: (lv_right_3_0= rulePrefixed )
            	    // InternalNavascript.g:6285:6: lv_right_3_0= rulePrefixed
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_70);
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
            	    break loop115;
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
    // InternalNavascript.g:6307:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalNavascript.g:6307:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalNavascript.g:6308:2: iv_rulePrefixed= rulePrefixed EOF
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
    // InternalNavascript.g:6314:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6320:2: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalNavascript.g:6321:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalNavascript.g:6321:2: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt116=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt116=1;
                }
                break;
            case 91:
                {
                alt116=2;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
            case RULE_IDENTIFIER:
            case RULE_TML_LITERAL:
            case RULE_INTEGER:
            case RULE_ONE:
            case RULE_FLOAT:
            case RULE_STRING_LITERAL:
            case RULE_TRUE:
            case RULE_FALSE:
            case RULE_NULL_DEF:
            case RULE_TODAY:
            case RULE_FORALL:
            case RULE_EXISTS:
            case 36:
            case 95:
                {
                alt116=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalNavascript.g:6322:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:6322:3: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalNavascript.g:6323:4: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:6323:4: ()
                    // InternalNavascript.g:6324:5: 
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

                    // InternalNavascript.g:6333:4: ( ( '!' )=>otherlv_1= '!' )
                    // InternalNavascript.g:6334:5: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,94,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      				
                    }

                    }

                    // InternalNavascript.g:6340:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalNavascript.g:6341:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalNavascript.g:6341:5: (lv_expression_2_0= ruleAtomic )
                    // InternalNavascript.g:6342:6: lv_expression_2_0= ruleAtomic
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
                    // InternalNavascript.g:6361:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalNavascript.g:6361:3: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalNavascript.g:6362:4: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalNavascript.g:6362:4: ()
                    // InternalNavascript.g:6363:5: 
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

                    // InternalNavascript.g:6372:4: ( ( '-' )=>otherlv_4= '-' )
                    // InternalNavascript.g:6373:5: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,91,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      				
                    }

                    }

                    // InternalNavascript.g:6379:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalNavascript.g:6380:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalNavascript.g:6380:5: (lv_expression_5_0= ruleAtomic )
                    // InternalNavascript.g:6381:6: lv_expression_5_0= ruleAtomic
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
                    // InternalNavascript.g:6400:3: this_Atomic_6= ruleAtomic
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
    // InternalNavascript.g:6415:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalNavascript.g:6415:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalNavascript.g:6416:2: iv_ruleAtomic= ruleAtomic EOF
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
    // InternalNavascript.g:6422:1: ruleAtomic returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) | ( () ( (lv_value_22_0= RULE_TODAY ) ) ) ) ;
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
        Token lv_value_22_0=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_11_0 = null;

        EObject lv_value_13_0 = null;

        EObject lv_value_16_0 = null;

        EObject lv_value_18_0 = null;



        	enterRule();

        try {
            // InternalNavascript.g:6428:2: ( ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) | ( () ( (lv_value_22_0= RULE_TODAY ) ) ) ) )
            // InternalNavascript.g:6429:2: ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) | ( () ( (lv_value_22_0= RULE_TODAY ) ) ) )
            {
            // InternalNavascript.g:6429:2: ( ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) ) | ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) ) | ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) ) | ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) ) | ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) ) | ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) ) | ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) ) | ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) ) | ( () ( (lv_value_22_0= RULE_TODAY ) ) ) )
            int alt120=10;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt120=1;
                }
                break;
            case RULE_INTEGER:
            case RULE_ONE:
            case RULE_FLOAT:
                {
                alt120=2;
                }
                break;
            case RULE_STRING_LITERAL:
                {
                alt120=3;
                }
                break;
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt120=4;
                }
                break;
            case RULE_IDENTIFIER:
                {
                alt120=5;
                }
                break;
            case RULE_MAPPABLE_IDENTIFIER:
                {
                alt120=6;
                }
                break;
            case RULE_TML_LITERAL:
            case 95:
                {
                alt120=7;
                }
                break;
            case RULE_FORALL:
            case RULE_EXISTS:
                {
                alt120=8;
                }
                break;
            case RULE_NULL_DEF:
                {
                alt120=9;
                }
                break;
            case RULE_TODAY:
                {
                alt120=10;
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
                    // InternalNavascript.g:6430:3: ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalNavascript.g:6430:3: ( () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalNavascript.g:6431:4: () otherlv_1= '(' ( (lv_value_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalNavascript.g:6431:4: ()
                    // InternalNavascript.g:6432:5: 
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

                    otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalNavascript.g:6445:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalNavascript.g:6446:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalNavascript.g:6446:5: (lv_value_2_0= ruleExpression )
                    // InternalNavascript.g:6447:6: lv_value_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getValueExpressionParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    otherlv_3=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:6470:3: ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) )
                    {
                    // InternalNavascript.g:6470:3: ( () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) ) )
                    // InternalNavascript.g:6471:4: () ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) )
                    {
                    // InternalNavascript.g:6471:4: ()
                    // InternalNavascript.g:6472:5: 
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

                    // InternalNavascript.g:6481:4: ( ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) ) )
                    // InternalNavascript.g:6482:5: ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) )
                    {
                    // InternalNavascript.g:6482:5: ( (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT ) )
                    // InternalNavascript.g:6483:6: (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT )
                    {
                    // InternalNavascript.g:6483:6: (lv_value_5_1= RULE_INTEGER | lv_value_5_2= RULE_ONE | lv_value_5_3= RULE_FLOAT )
                    int alt117=3;
                    switch ( input.LA(1) ) {
                    case RULE_INTEGER:
                        {
                        alt117=1;
                        }
                        break;
                    case RULE_ONE:
                        {
                        alt117=2;
                        }
                        break;
                    case RULE_FLOAT:
                        {
                        alt117=3;
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
                            // InternalNavascript.g:6484:7: lv_value_5_1= RULE_INTEGER
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
                            // InternalNavascript.g:6499:7: lv_value_5_2= RULE_ONE
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
                            // InternalNavascript.g:6514:7: lv_value_5_3= RULE_FLOAT
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
                    // InternalNavascript.g:6533:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    {
                    // InternalNavascript.g:6533:3: ( () ( (lv_value_7_0= RULE_STRING_LITERAL ) ) )
                    // InternalNavascript.g:6534:4: () ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    {
                    // InternalNavascript.g:6534:4: ()
                    // InternalNavascript.g:6535:5: 
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

                    // InternalNavascript.g:6544:4: ( (lv_value_7_0= RULE_STRING_LITERAL ) )
                    // InternalNavascript.g:6545:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    {
                    // InternalNavascript.g:6545:5: (lv_value_7_0= RULE_STRING_LITERAL )
                    // InternalNavascript.g:6546:6: lv_value_7_0= RULE_STRING_LITERAL
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
                    // InternalNavascript.g:6564:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    {
                    // InternalNavascript.g:6564:3: ( () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) ) )
                    // InternalNavascript.g:6565:4: () ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    {
                    // InternalNavascript.g:6565:4: ()
                    // InternalNavascript.g:6566:5: 
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

                    // InternalNavascript.g:6575:4: ( ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) ) )
                    // InternalNavascript.g:6576:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    {
                    // InternalNavascript.g:6576:5: ( (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE ) )
                    // InternalNavascript.g:6577:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    {
                    // InternalNavascript.g:6577:6: (lv_value_9_1= RULE_TRUE | lv_value_9_2= RULE_FALSE )
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==RULE_TRUE) ) {
                        alt118=1;
                    }
                    else if ( (LA118_0==RULE_FALSE) ) {
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
                            // InternalNavascript.g:6578:7: lv_value_9_1= RULE_TRUE
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
                            // InternalNavascript.g:6593:7: lv_value_9_2= RULE_FALSE
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
                    // InternalNavascript.g:6612:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    {
                    // InternalNavascript.g:6612:3: ( () ( (lv_value_11_0= ruleFunctionIdentifier ) ) )
                    // InternalNavascript.g:6613:4: () ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    {
                    // InternalNavascript.g:6613:4: ()
                    // InternalNavascript.g:6614:5: 
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

                    // InternalNavascript.g:6623:4: ( (lv_value_11_0= ruleFunctionIdentifier ) )
                    // InternalNavascript.g:6624:5: (lv_value_11_0= ruleFunctionIdentifier )
                    {
                    // InternalNavascript.g:6624:5: (lv_value_11_0= ruleFunctionIdentifier )
                    // InternalNavascript.g:6625:6: lv_value_11_0= ruleFunctionIdentifier
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
                    // InternalNavascript.g:6644:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    {
                    // InternalNavascript.g:6644:3: ( () ( (lv_value_13_0= ruleMappableIdentifier ) ) )
                    // InternalNavascript.g:6645:4: () ( (lv_value_13_0= ruleMappableIdentifier ) )
                    {
                    // InternalNavascript.g:6645:4: ()
                    // InternalNavascript.g:6646:5: 
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

                    // InternalNavascript.g:6655:4: ( (lv_value_13_0= ruleMappableIdentifier ) )
                    // InternalNavascript.g:6656:5: (lv_value_13_0= ruleMappableIdentifier )
                    {
                    // InternalNavascript.g:6656:5: (lv_value_13_0= ruleMappableIdentifier )
                    // InternalNavascript.g:6657:6: lv_value_13_0= ruleMappableIdentifier
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
                    // InternalNavascript.g:6676:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    {
                    // InternalNavascript.g:6676:3: ( () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) ) )
                    // InternalNavascript.g:6677:4: () ( (lv_hasExists_15_0= '?' ) )? ( (lv_value_16_0= ruleTmlIdentifier ) )
                    {
                    // InternalNavascript.g:6677:4: ()
                    // InternalNavascript.g:6678:5: 
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

                    // InternalNavascript.g:6687:4: ( (lv_hasExists_15_0= '?' ) )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==95) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // InternalNavascript.g:6688:5: (lv_hasExists_15_0= '?' )
                            {
                            // InternalNavascript.g:6688:5: (lv_hasExists_15_0= '?' )
                            // InternalNavascript.g:6689:6: lv_hasExists_15_0= '?'
                            {
                            lv_hasExists_15_0=(Token)match(input,95,FOLLOW_71); if (state.failed) return current;
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

                    // InternalNavascript.g:6701:4: ( (lv_value_16_0= ruleTmlIdentifier ) )
                    // InternalNavascript.g:6702:5: (lv_value_16_0= ruleTmlIdentifier )
                    {
                    // InternalNavascript.g:6702:5: (lv_value_16_0= ruleTmlIdentifier )
                    // InternalNavascript.g:6703:6: lv_value_16_0= ruleTmlIdentifier
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
                    // InternalNavascript.g:6722:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    {
                    // InternalNavascript.g:6722:3: ( () ( (lv_value_18_0= ruleForAllIdentifier ) ) )
                    // InternalNavascript.g:6723:4: () ( (lv_value_18_0= ruleForAllIdentifier ) )
                    {
                    // InternalNavascript.g:6723:4: ()
                    // InternalNavascript.g:6724:5: 
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

                    // InternalNavascript.g:6733:4: ( (lv_value_18_0= ruleForAllIdentifier ) )
                    // InternalNavascript.g:6734:5: (lv_value_18_0= ruleForAllIdentifier )
                    {
                    // InternalNavascript.g:6734:5: (lv_value_18_0= ruleForAllIdentifier )
                    // InternalNavascript.g:6735:6: lv_value_18_0= ruleForAllIdentifier
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
                    // InternalNavascript.g:6754:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    {
                    // InternalNavascript.g:6754:3: ( () ( (lv_value_20_0= RULE_NULL_DEF ) ) )
                    // InternalNavascript.g:6755:4: () ( (lv_value_20_0= RULE_NULL_DEF ) )
                    {
                    // InternalNavascript.g:6755:4: ()
                    // InternalNavascript.g:6756:5: 
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

                    // InternalNavascript.g:6765:4: ( (lv_value_20_0= RULE_NULL_DEF ) )
                    // InternalNavascript.g:6766:5: (lv_value_20_0= RULE_NULL_DEF )
                    {
                    // InternalNavascript.g:6766:5: (lv_value_20_0= RULE_NULL_DEF )
                    // InternalNavascript.g:6767:6: lv_value_20_0= RULE_NULL_DEF
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
                case 10 :
                    // InternalNavascript.g:6785:3: ( () ( (lv_value_22_0= RULE_TODAY ) ) )
                    {
                    // InternalNavascript.g:6785:3: ( () ( (lv_value_22_0= RULE_TODAY ) ) )
                    // InternalNavascript.g:6786:4: () ( (lv_value_22_0= RULE_TODAY ) )
                    {
                    // InternalNavascript.g:6786:4: ()
                    // InternalNavascript.g:6787:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getTodayLiteralAction_9_0(),
                      						current);
                      				
                    }

                    }

                    // InternalNavascript.g:6796:4: ( (lv_value_22_0= RULE_TODAY ) )
                    // InternalNavascript.g:6797:5: (lv_value_22_0= RULE_TODAY )
                    {
                    // InternalNavascript.g:6797:5: (lv_value_22_0= RULE_TODAY )
                    // InternalNavascript.g:6798:6: lv_value_22_0= RULE_TODAY
                    {
                    lv_value_22_0=(Token)match(input,RULE_TODAY,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_22_0, grammarAccess.getAtomicAccess().getValueTODAYTerminalRuleCall_9_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_22_0,
                      							"com.dexels.navajo.Navascript.TODAY");
                      					
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
    // InternalNavascript.g:6819:1: entryRuleForAllIdentifier returns [EObject current=null] : iv_ruleForAllIdentifier= ruleForAllIdentifier EOF ;
    public final EObject entryRuleForAllIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllIdentifier = null;


        try {
            // InternalNavascript.g:6819:57: (iv_ruleForAllIdentifier= ruleForAllIdentifier EOF )
            // InternalNavascript.g:6820:2: iv_ruleForAllIdentifier= ruleForAllIdentifier EOF
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
    // InternalNavascript.g:6826:1: ruleForAllIdentifier returns [EObject current=null] : ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' ) ;
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
            // InternalNavascript.g:6832:2: ( ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' ) )
            // InternalNavascript.g:6833:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' )
            {
            // InternalNavascript.g:6833:2: ( () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')' )
            // InternalNavascript.g:6834:3: () ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) ) otherlv_2= '(' otherlv_3= '`' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '`' otherlv_6= ',' ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) ) otherlv_8= ')'
            {
            // InternalNavascript.g:6834:3: ()
            // InternalNavascript.g:6835:4: 
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

            // InternalNavascript.g:6844:3: ( ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) ) )
            // InternalNavascript.g:6845:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            {
            // InternalNavascript.g:6845:4: ( (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS ) )
            // InternalNavascript.g:6846:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            {
            // InternalNavascript.g:6846:5: (lv_op_1_1= RULE_FORALL | lv_op_1_2= RULE_EXISTS )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==RULE_FORALL) ) {
                alt121=1;
            }
            else if ( (LA121_0==RULE_EXISTS) ) {
                alt121=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // InternalNavascript.g:6847:6: lv_op_1_1= RULE_FORALL
                    {
                    lv_op_1_1=(Token)match(input,RULE_FORALL,FOLLOW_13); if (state.failed) return current;
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
                    // InternalNavascript.g:6862:6: lv_op_1_2= RULE_EXISTS
                    {
                    lv_op_1_2=(Token)match(input,RULE_EXISTS,FOLLOW_13); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,36,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getForAllIdentifierAccess().getLeftParenthesisKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,96,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_3());
              		
            }
            // InternalNavascript.g:6887:3: ( (lv_expression_4_0= ruleExpression ) )
            // InternalNavascript.g:6888:4: (lv_expression_4_0= ruleExpression )
            {
            // InternalNavascript.g:6888:4: (lv_expression_4_0= ruleExpression )
            // InternalNavascript.g:6889:5: lv_expression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForAllIdentifierAccess().getExpressionExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_72);
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

            otherlv_5=(Token)match(input,96,FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getForAllIdentifierAccess().getGraveAccentKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,38,FOLLOW_74); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getForAllIdentifierAccess().getCommaKeyword_6());
              		
            }
            // InternalNavascript.g:6914:3: ( (lv_messagedefinition_7_0= RULE_STRING_LITERAL ) )
            // InternalNavascript.g:6915:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            {
            // InternalNavascript.g:6915:4: (lv_messagedefinition_7_0= RULE_STRING_LITERAL )
            // InternalNavascript.g:6916:5: lv_messagedefinition_7_0= RULE_STRING_LITERAL
            {
            lv_messagedefinition_7_0=(Token)match(input,RULE_STRING_LITERAL,FOLLOW_15); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:6940:1: entryRuleFunctionIdentifier returns [EObject current=null] : iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF ;
    public final EObject entryRuleFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionIdentifier = null;


        try {
            // InternalNavascript.g:6940:59: (iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF )
            // InternalNavascript.g:6941:2: iv_ruleFunctionIdentifier= ruleFunctionIdentifier EOF
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
    // InternalNavascript.g:6947:1: ruleFunctionIdentifier returns [EObject current=null] : ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ) ;
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
            // InternalNavascript.g:6953:2: ( ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ) )
            // InternalNavascript.g:6954:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            {
            // InternalNavascript.g:6954:2: ( () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalNavascript.g:6955:3: () ( (lv_func_1_0= RULE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalNavascript.g:6955:3: ()
            // InternalNavascript.g:6956:4: 
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

            // InternalNavascript.g:6965:3: ( (lv_func_1_0= RULE_IDENTIFIER ) )
            // InternalNavascript.g:6966:4: (lv_func_1_0= RULE_IDENTIFIER )
            {
            // InternalNavascript.g:6966:4: (lv_func_1_0= RULE_IDENTIFIER )
            // InternalNavascript.g:6967:5: lv_func_1_0= RULE_IDENTIFIER
            {
            lv_func_1_0=(Token)match(input,RULE_IDENTIFIER,FOLLOW_13); if (state.failed) return current;
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

            // InternalNavascript.g:6983:3: (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalNavascript.g:6984:4: otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            otherlv_2=(Token)match(input,36,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getFunctionIdentifierAccess().getLeftParenthesisKeyword_2_0());
              			
            }
            // InternalNavascript.g:6988:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( ((LA123_0>=RULE_MAPPABLE_IDENTIFIER && LA123_0<=RULE_IDENTIFIER)||(LA123_0>=RULE_TML_LITERAL && LA123_0<=RULE_EXISTS)||LA123_0==36||LA123_0==91||(LA123_0>=94 && LA123_0<=95)) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalNavascript.g:6989:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalNavascript.g:6989:5: ( (lv_args_3_0= ruleExpression ) )
                    // InternalNavascript.g:6990:6: (lv_args_3_0= ruleExpression )
                    {
                    // InternalNavascript.g:6990:6: (lv_args_3_0= ruleExpression )
                    // InternalNavascript.g:6991:7: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getFunctionIdentifierAccess().getArgsExpressionParserRuleCall_2_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_30);
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

                    // InternalNavascript.g:7008:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop122:
                    do {
                        int alt122=2;
                        int LA122_0 = input.LA(1);

                        if ( (LA122_0==38) ) {
                            alt122=1;
                        }


                        switch (alt122) {
                    	case 1 :
                    	    // InternalNavascript.g:7009:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,38,FOLLOW_7); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_4, grammarAccess.getFunctionIdentifierAccess().getCommaKeyword_2_1_1_0());
                    	      					
                    	    }
                    	    // InternalNavascript.g:7013:6: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalNavascript.g:7014:7: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalNavascript.g:7014:7: (lv_args_5_0= ruleExpression )
                    	    // InternalNavascript.g:7015:8: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getFunctionIdentifierAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_30);
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
                    	    break loop122;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:7043:1: entryRuleMappableIdentifier returns [EObject current=null] : iv_ruleMappableIdentifier= ruleMappableIdentifier EOF ;
    public final EObject entryRuleMappableIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappableIdentifier = null;


        try {
            // InternalNavascript.g:7043:59: (iv_ruleMappableIdentifier= ruleMappableIdentifier EOF )
            // InternalNavascript.g:7044:2: iv_ruleMappableIdentifier= ruleMappableIdentifier EOF
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
    // InternalNavascript.g:7050:1: ruleMappableIdentifier returns [EObject current=null] : ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) ;
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
            // InternalNavascript.g:7056:2: ( ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? ) )
            // InternalNavascript.g:7057:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            {
            // InternalNavascript.g:7057:2: ( () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )? )
            // InternalNavascript.g:7058:3: () ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) ) (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            {
            // InternalNavascript.g:7058:3: ()
            // InternalNavascript.g:7059:4: 
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

            // InternalNavascript.g:7068:3: ( (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER ) )
            // InternalNavascript.g:7069:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            {
            // InternalNavascript.g:7069:4: (lv_field_1_0= RULE_MAPPABLE_IDENTIFIER )
            // InternalNavascript.g:7070:5: lv_field_1_0= RULE_MAPPABLE_IDENTIFIER
            {
            lv_field_1_0=(Token)match(input,RULE_MAPPABLE_IDENTIFIER,FOLLOW_76); if (state.failed) return current;
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

            // InternalNavascript.g:7086:3: (otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==36) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalNavascript.g:7087:4: otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,36,FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMappableIdentifierAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalNavascript.g:7091:4: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( ((LA125_0>=RULE_MAPPABLE_IDENTIFIER && LA125_0<=RULE_IDENTIFIER)||(LA125_0>=RULE_TML_LITERAL && LA125_0<=RULE_EXISTS)||LA125_0==36||LA125_0==91||(LA125_0>=94 && LA125_0<=95)) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // InternalNavascript.g:7092:5: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            {
                            // InternalNavascript.g:7092:5: ( (lv_args_3_0= ruleExpression ) )
                            // InternalNavascript.g:7093:6: (lv_args_3_0= ruleExpression )
                            {
                            // InternalNavascript.g:7093:6: (lv_args_3_0= ruleExpression )
                            // InternalNavascript.g:7094:7: lv_args_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getMappableIdentifierAccess().getArgsExpressionParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_30);
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

                            // InternalNavascript.g:7111:5: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                            loop124:
                            do {
                                int alt124=2;
                                int LA124_0 = input.LA(1);

                                if ( (LA124_0==38) ) {
                                    alt124=1;
                                }


                                switch (alt124) {
                            	case 1 :
                            	    // InternalNavascript.g:7112:6: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                            	    {
                            	    otherlv_4=(Token)match(input,38,FOLLOW_7); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_4, grammarAccess.getMappableIdentifierAccess().getCommaKeyword_2_1_1_0());
                            	      					
                            	    }
                            	    // InternalNavascript.g:7116:6: ( (lv_args_5_0= ruleExpression ) )
                            	    // InternalNavascript.g:7117:7: (lv_args_5_0= ruleExpression )
                            	    {
                            	    // InternalNavascript.g:7117:7: (lv_args_5_0= ruleExpression )
                            	    // InternalNavascript.g:7118:8: lv_args_5_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getMappableIdentifierAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_30);
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
                            	    break loop124;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:7146:1: entryRuleTmlIdentifier returns [EObject current=null] : iv_ruleTmlIdentifier= ruleTmlIdentifier EOF ;
    public final EObject entryRuleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTmlIdentifier = null;


        try {
            // InternalNavascript.g:7146:54: (iv_ruleTmlIdentifier= ruleTmlIdentifier EOF )
            // InternalNavascript.g:7147:2: iv_ruleTmlIdentifier= ruleTmlIdentifier EOF
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
    // InternalNavascript.g:7153:1: ruleTmlIdentifier returns [EObject current=null] : ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) ;
    public final EObject ruleTmlIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_tml_1_0=null;


        	enterRule();

        try {
            // InternalNavascript.g:7159:2: ( ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) ) )
            // InternalNavascript.g:7160:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            {
            // InternalNavascript.g:7160:2: ( () ( (lv_tml_1_0= RULE_TML_LITERAL ) ) )
            // InternalNavascript.g:7161:3: () ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            {
            // InternalNavascript.g:7161:3: ()
            // InternalNavascript.g:7162:4: 
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

            // InternalNavascript.g:7171:3: ( (lv_tml_1_0= RULE_TML_LITERAL ) )
            // InternalNavascript.g:7172:4: (lv_tml_1_0= RULE_TML_LITERAL )
            {
            // InternalNavascript.g:7172:4: (lv_tml_1_0= RULE_TML_LITERAL )
            // InternalNavascript.g:7173:5: lv_tml_1_0= RULE_TML_LITERAL
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
    // InternalNavascript.g:7193:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // InternalNavascript.g:7193:53: (iv_rulePropertyType= rulePropertyType EOF )
            // InternalNavascript.g:7194:2: iv_rulePropertyType= rulePropertyType EOF
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
    // InternalNavascript.g:7200:1: rulePropertyType returns [EObject current=null] : ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) ;
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
            // InternalNavascript.g:7206:2: ( ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) ) )
            // InternalNavascript.g:7207:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            {
            // InternalNavascript.g:7207:2: ( ( () otherlv_1= 'integer' ) | ( () otherlv_3= 'string' ) | ( () otherlv_5= 'boolean' ) | ( () otherlv_7= 'date' ) | ( () otherlv_9= 'float' ) | ( () otherlv_11= 'binary' ) | ( () otherlv_13= 'clocktime' ) | ( () otherlv_15= 'memo' ) | ( () otherlv_17= 'timestamp' ) | ( () otherlv_19= 'percentage' ) | ( () otherlv_21= 'selection' ) )
            int alt127=11;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt127=1;
                }
                break;
            case 98:
                {
                alt127=2;
                }
                break;
            case 99:
                {
                alt127=3;
                }
                break;
            case 100:
                {
                alt127=4;
                }
                break;
            case 101:
                {
                alt127=5;
                }
                break;
            case 102:
                {
                alt127=6;
                }
                break;
            case 103:
                {
                alt127=7;
                }
                break;
            case 104:
                {
                alt127=8;
                }
                break;
            case 105:
                {
                alt127=9;
                }
                break;
            case 106:
                {
                alt127=10;
                }
                break;
            case 107:
                {
                alt127=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // InternalNavascript.g:7208:3: ( () otherlv_1= 'integer' )
                    {
                    // InternalNavascript.g:7208:3: ( () otherlv_1= 'integer' )
                    // InternalNavascript.g:7209:4: () otherlv_1= 'integer'
                    {
                    // InternalNavascript.g:7209:4: ()
                    // InternalNavascript.g:7210:5: 
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

                    otherlv_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPropertyTypeAccess().getIntegerKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7225:3: ( () otherlv_3= 'string' )
                    {
                    // InternalNavascript.g:7225:3: ( () otherlv_3= 'string' )
                    // InternalNavascript.g:7226:4: () otherlv_3= 'string'
                    {
                    // InternalNavascript.g:7226:4: ()
                    // InternalNavascript.g:7227:5: 
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

                    otherlv_3=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPropertyTypeAccess().getStringKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:7242:3: ( () otherlv_5= 'boolean' )
                    {
                    // InternalNavascript.g:7242:3: ( () otherlv_5= 'boolean' )
                    // InternalNavascript.g:7243:4: () otherlv_5= 'boolean'
                    {
                    // InternalNavascript.g:7243:4: ()
                    // InternalNavascript.g:7244:5: 
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

                    otherlv_5=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPropertyTypeAccess().getBooleanKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalNavascript.g:7259:3: ( () otherlv_7= 'date' )
                    {
                    // InternalNavascript.g:7259:3: ( () otherlv_7= 'date' )
                    // InternalNavascript.g:7260:4: () otherlv_7= 'date'
                    {
                    // InternalNavascript.g:7260:4: ()
                    // InternalNavascript.g:7261:5: 
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

                    otherlv_7=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPropertyTypeAccess().getDateKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalNavascript.g:7276:3: ( () otherlv_9= 'float' )
                    {
                    // InternalNavascript.g:7276:3: ( () otherlv_9= 'float' )
                    // InternalNavascript.g:7277:4: () otherlv_9= 'float'
                    {
                    // InternalNavascript.g:7277:4: ()
                    // InternalNavascript.g:7278:5: 
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

                    otherlv_9=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPropertyTypeAccess().getFloatKeyword_4_1());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalNavascript.g:7293:3: ( () otherlv_11= 'binary' )
                    {
                    // InternalNavascript.g:7293:3: ( () otherlv_11= 'binary' )
                    // InternalNavascript.g:7294:4: () otherlv_11= 'binary'
                    {
                    // InternalNavascript.g:7294:4: ()
                    // InternalNavascript.g:7295:5: 
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

                    otherlv_11=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPropertyTypeAccess().getBinaryKeyword_5_1());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalNavascript.g:7310:3: ( () otherlv_13= 'clocktime' )
                    {
                    // InternalNavascript.g:7310:3: ( () otherlv_13= 'clocktime' )
                    // InternalNavascript.g:7311:4: () otherlv_13= 'clocktime'
                    {
                    // InternalNavascript.g:7311:4: ()
                    // InternalNavascript.g:7312:5: 
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

                    otherlv_13=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getPropertyTypeAccess().getClocktimeKeyword_6_1());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalNavascript.g:7327:3: ( () otherlv_15= 'memo' )
                    {
                    // InternalNavascript.g:7327:3: ( () otherlv_15= 'memo' )
                    // InternalNavascript.g:7328:4: () otherlv_15= 'memo'
                    {
                    // InternalNavascript.g:7328:4: ()
                    // InternalNavascript.g:7329:5: 
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

                    otherlv_15=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getPropertyTypeAccess().getMemoKeyword_7_1());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalNavascript.g:7344:3: ( () otherlv_17= 'timestamp' )
                    {
                    // InternalNavascript.g:7344:3: ( () otherlv_17= 'timestamp' )
                    // InternalNavascript.g:7345:4: () otherlv_17= 'timestamp'
                    {
                    // InternalNavascript.g:7345:4: ()
                    // InternalNavascript.g:7346:5: 
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

                    otherlv_17=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getPropertyTypeAccess().getTimestampKeyword_8_1());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalNavascript.g:7361:3: ( () otherlv_19= 'percentage' )
                    {
                    // InternalNavascript.g:7361:3: ( () otherlv_19= 'percentage' )
                    // InternalNavascript.g:7362:4: () otherlv_19= 'percentage'
                    {
                    // InternalNavascript.g:7362:4: ()
                    // InternalNavascript.g:7363:5: 
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

                    otherlv_19=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getPropertyTypeAccess().getPercentageKeyword_9_1());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalNavascript.g:7378:3: ( () otherlv_21= 'selection' )
                    {
                    // InternalNavascript.g:7378:3: ( () otherlv_21= 'selection' )
                    // InternalNavascript.g:7379:4: () otherlv_21= 'selection'
                    {
                    // InternalNavascript.g:7379:4: ()
                    // InternalNavascript.g:7380:5: 
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

                    otherlv_21=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:7398:1: entryRuleOPTION_TYPE returns [String current=null] : iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF ;
    public final String entryRuleOPTION_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOPTION_TYPE = null;


        try {
            // InternalNavascript.g:7398:51: (iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF )
            // InternalNavascript.g:7399:2: iv_ruleOPTION_TYPE= ruleOPTION_TYPE EOF
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
    // InternalNavascript.g:7405:1: ruleOPTION_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'name' | kw= 'value' | kw= 'selected' ) ;
    public final AntlrDatatypeRuleToken ruleOPTION_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalNavascript.g:7411:2: ( (kw= 'name' | kw= 'value' | kw= 'selected' ) )
            // InternalNavascript.g:7412:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            {
            // InternalNavascript.g:7412:2: (kw= 'name' | kw= 'value' | kw= 'selected' )
            int alt128=3;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt128=1;
                }
                break;
            case 109:
                {
                alt128=2;
                }
                break;
            case 110:
                {
                alt128=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // InternalNavascript.g:7413:3: kw= 'name'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getNameKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7419:3: kw= 'value'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOPTION_TYPEAccess().getValueKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalNavascript.g:7425:3: kw= 'selected'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:7434:1: entryRuleMessageType returns [EObject current=null] : iv_ruleMessageType= ruleMessageType EOF ;
    public final EObject entryRuleMessageType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageType = null;


        try {
            // InternalNavascript.g:7434:52: (iv_ruleMessageType= ruleMessageType EOF )
            // InternalNavascript.g:7435:2: iv_ruleMessageType= ruleMessageType EOF
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
    // InternalNavascript.g:7441:1: ruleMessageType returns [EObject current=null] : ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) ;
    public final EObject ruleMessageType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalNavascript.g:7447:2: ( ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) ) )
            // InternalNavascript.g:7448:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            {
            // InternalNavascript.g:7448:2: ( ( () otherlv_1= 'array' ) | ( () otherlv_3= 'simple' ) | ( () otherlv_5= 'arrayelement' ) )
            int alt129=3;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt129=1;
                }
                break;
            case 112:
                {
                alt129=2;
                }
                break;
            case 113:
                {
                alt129=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }

            switch (alt129) {
                case 1 :
                    // InternalNavascript.g:7449:3: ( () otherlv_1= 'array' )
                    {
                    // InternalNavascript.g:7449:3: ( () otherlv_1= 'array' )
                    // InternalNavascript.g:7450:4: () otherlv_1= 'array'
                    {
                    // InternalNavascript.g:7450:4: ()
                    // InternalNavascript.g:7451:5: 
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

                    otherlv_1=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageTypeAccess().getArrayKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7466:3: ( () otherlv_3= 'simple' )
                    {
                    // InternalNavascript.g:7466:3: ( () otherlv_3= 'simple' )
                    // InternalNavascript.g:7467:4: () otherlv_3= 'simple'
                    {
                    // InternalNavascript.g:7467:4: ()
                    // InternalNavascript.g:7468:5: 
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

                    otherlv_3=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getMessageTypeAccess().getSimpleKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalNavascript.g:7483:3: ( () otherlv_5= 'arrayelement' )
                    {
                    // InternalNavascript.g:7483:3: ( () otherlv_5= 'arrayelement' )
                    // InternalNavascript.g:7484:4: () otherlv_5= 'arrayelement'
                    {
                    // InternalNavascript.g:7484:4: ()
                    // InternalNavascript.g:7485:5: 
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

                    otherlv_5=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
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
    // InternalNavascript.g:7503:1: entryRuleMessageMode returns [EObject current=null] : iv_ruleMessageMode= ruleMessageMode EOF ;
    public final EObject entryRuleMessageMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageMode = null;


        try {
            // InternalNavascript.g:7503:52: (iv_ruleMessageMode= ruleMessageMode EOF )
            // InternalNavascript.g:7504:2: iv_ruleMessageMode= ruleMessageMode EOF
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
    // InternalNavascript.g:7510:1: ruleMessageMode returns [EObject current=null] : ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) ;
    public final EObject ruleMessageMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalNavascript.g:7516:2: ( ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) ) )
            // InternalNavascript.g:7517:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            {
            // InternalNavascript.g:7517:2: ( ( () otherlv_1= 'ignore' ) | ( () otherlv_3= 'overwrite' ) )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==114) ) {
                alt130=1;
            }
            else if ( (LA130_0==115) ) {
                alt130=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // InternalNavascript.g:7518:3: ( () otherlv_1= 'ignore' )
                    {
                    // InternalNavascript.g:7518:3: ( () otherlv_1= 'ignore' )
                    // InternalNavascript.g:7519:4: () otherlv_1= 'ignore'
                    {
                    // InternalNavascript.g:7519:4: ()
                    // InternalNavascript.g:7520:5: 
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

                    otherlv_1=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getMessageModeAccess().getIgnoreKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalNavascript.g:7535:3: ( () otherlv_3= 'overwrite' )
                    {
                    // InternalNavascript.g:7535:3: ( () otherlv_3= 'overwrite' )
                    // InternalNavascript.g:7536:4: () otherlv_3= 'overwrite'
                    {
                    // InternalNavascript.g:7536:4: ()
                    // InternalNavascript.g:7537:5: 
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

                    otherlv_3=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
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

    // $ANTLR start synpred71_InternalNavascript
    public final void synpred71_InternalNavascript_fragment() throws RecognitionException {   
        EObject lv_statements_7_0 = null;


        // InternalNavascript.g:2695:6: ( ( (lv_statements_7_0= ruleInnerBody ) )* )
        // InternalNavascript.g:2695:6: ( (lv_statements_7_0= ruleInnerBody ) )*
        {
        // InternalNavascript.g:2695:6: ( (lv_statements_7_0= ruleInnerBody ) )*
        loop137:
        do {
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==RULE_MAPPABLE_IDENTIFIER||LA137_0==RULE_METHOD_IDENTIFIER||LA137_0==27||LA137_0==29||LA137_0==47||LA137_0==53||(LA137_0>=55 && LA137_0<=56)||(LA137_0>=58 && LA137_0<=59)||(LA137_0>=61 && LA137_0<=63)||(LA137_0>=68 && LA137_0<=69)||(LA137_0>=71 && LA137_0<=73)) ) {
                alt137=1;
            }


            switch (alt137) {
        	case 1 :
        	    // InternalNavascript.g:2696:7: (lv_statements_7_0= ruleInnerBody )
        	    {
        	    // InternalNavascript.g:2696:7: (lv_statements_7_0= ruleInnerBody )
        	    // InternalNavascript.g:2697:8: lv_statements_7_0= ruleInnerBody
        	    {
        	    if ( state.backtracking==0 ) {

        	      								newCompositeNode(grammarAccess.getMessageAccess().getStatementsInnerBodyParserRuleCall_4_0_1_0_0());
        	      							
        	    }
        	    pushFollow(FOLLOW_77);
        	    lv_statements_7_0=ruleInnerBody();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop137;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred71_InternalNavascript

    // $ANTLR start synpred72_InternalNavascript
    public final void synpred72_InternalNavascript_fragment() throws RecognitionException {   
        EObject lv_arrayField_8_0 = null;


        // InternalNavascript.g:2715:6: ( ( (lv_arrayField_8_0= ruleMappedArrayField ) ) )
        // InternalNavascript.g:2715:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
        {
        // InternalNavascript.g:2715:6: ( (lv_arrayField_8_0= ruleMappedArrayField ) )
        // InternalNavascript.g:2716:7: (lv_arrayField_8_0= ruleMappedArrayField )
        {
        // InternalNavascript.g:2716:7: (lv_arrayField_8_0= ruleMappedArrayField )
        // InternalNavascript.g:2717:8: lv_arrayField_8_0= ruleMappedArrayField
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
    // $ANTLR end synpred72_InternalNavascript

    // Delegated rules

    public final boolean synpred71_InternalNavascript() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_InternalNavascript_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalNavascript() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalNavascript_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA43 dfa43 = new DFA43(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\6\4\uffff\1\0\20\uffff";
    static final String dfa_3s = "\1\111\4\uffff\1\0\20\uffff";
    static final String dfa_4s = "\1\uffff\1\1\22\uffff\1\3\1\2";
    static final String dfa_5s = "\5\uffff\1\0\20\uffff}>";
    static final String[] dfa_6s = {
            "\1\5\2\uffff\1\1\1\24\20\uffff\1\1\1\uffff\2\1\20\uffff\1\1\5\uffff\1\1\1\uffff\2\1\1\uffff\2\1\1\uffff\3\1\4\uffff\2\1\1\uffff\3\1",
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

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2694:5: ( ( (lv_statements_7_0= ruleInnerBody ) )* | ( (lv_arrayField_8_0= ruleMappedArrayField ) ) | ( (lv_arrayMessage_9_0= ruleMappedArrayMessage ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_5 = input.LA(1);

                         
                        int index43_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred71_InternalNavascript()) ) {s = 1;}

                        else if ( (synpred72_InternalNavascript()) ) {s = 21;}

                         
                        input.seek(index43_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xEFB0800828000000L,0x00000000000000B0L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0xEFA0800828000000L,0x00000000000000B0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xEDA0800828000002L,0x00000000000000B0L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000010001FFCC0L,0x00000000C8000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xEDA0800828000000L,0x00000000000000B0L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0xEDA0800828000240L,0x00000000000003B0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xEDA0800868000240L,0x00000000000003B0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000700000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000708000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xEDA0800868000000L,0x00000000000000B0L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000010001FFCF0L,0x00000000C8000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0001001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000E002000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0040000048000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000440L,0x0000000080000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001020000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0001001020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0001000020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xEDA0800868000640L,0x00000000000003B0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0003800000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x000C000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001001020000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000002000000080L,0x0000700000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001000020000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000080L,0x0000700000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000031020000040L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000010081FFCF0L,0x00000000C8000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000031020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000030020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000048000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x00038FFE00000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0001031020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0001030020000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0004000000000000L,0x0000000000028C04L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000001000L,0x0000000000010000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000008000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000001E00000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000008010000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000030000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000400L,0x0000000080000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x00000030001FFCC0L,0x00000000C8000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xEDA0800828000242L,0x00000000000003B0L});

}