// Generated from Grammar.g4 by ANTLR 4.4
package uva.sc.parser;
 package uva.sc.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, BOOLEAN=15, TRUE=16, FALSE=17, 
		IF=18, ELSE=19, WHILE=20, LOG=21, MULT=22, DIV=23, MOD=24, ADD=25, SUB=26, 
		LTE=27, GTE=28, LT=29, GT=30, EQ=31, NEQ=32, ID=33, NUMBER=34, STRING=35, 
		COMMENT=36, WS=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "':'", "'||'", "'{'", "'&&'", "'='", "'}'", 
		"'^'", "'!'", "'string'", "'number'", "'('", "')'", "'form'", "BOOLEAN", 
		"TRUE", "FALSE", "'if'", "'else'", "'while'", "'log'", "'*'", "'/'", "'%'", 
		"'+'", "'-'", "'<='", "'>='", "'<'", "'>'", "'=='", "'!='", "ID", "NUMBER", 
		"STRING", "COMMENT", "WS"
	};
	public static final int
		RULE_form = 0, RULE_stat = 1, RULE_question = 2, RULE_type = 3, RULE_if_stat = 4, 
		RULE_expr = 5, RULE_atom = 6;
	public static final String[] ruleNames = {
		"form", "stat", "question", "type", "if_stat", "expr", "atom"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormContext extends ParserRuleContext {
		public StatContext stat;
		public List<StatContext> sts = new ArrayList<StatContext>();
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public FormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForm(this);
		}
	}

	public final FormContext form() throws RecognitionException {
		FormContext _localctx = new FormContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_form);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); match(T__0);
			setState(15); match(ID);
			setState(16); match(T__10);
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF || _la==STRING) {
				{
				{
				setState(17); ((FormContext)_localctx).stat = stat();
				((FormContext)_localctx).sts.add(((FormContext)_localctx).stat);
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23); match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(27);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(25); question();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(26); if_stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(STRING);
			setState(30); match(ID);
			setState(31); match(T__12);
			setState(32); type();
			setState(35);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(33); match(T__8);
				setState(34); expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__4) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statContext extends ParserRuleContext {
		public QuestionContext question;
		public List<QuestionContext> qs = new ArrayList<QuestionContext>();
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIf_stat(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(IF);
			setState(40); match(T__2);
			setState(41); expr(0);
			setState(42); match(T__1);
			setState(43); match(T__10);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(44); ((If_statContext)_localctx).question = question();
				((If_statContext)_localctx).qs.add(((If_statContext)_localctx).question);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50); match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNot(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOr(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAnd(this);
		}
	}
	public static class UnaryMinusContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUnaryMinus(this);
		}
	}
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GTE() { return getToken(GrammarParser.GTE, 0); }
		public TerminalNode LT() { return getToken(GrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(GrammarParser.GT, 0); }
		public TerminalNode LTE() { return getToken(GrammarParser.LTE, 0); }
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRelational(this);
		}
	}
	public static class PowerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitPower(this);
		}
	}
	public static class MultiplicationContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(GrammarParser.MULT, 0); }
		public TerminalNode MOD() { return getToken(GrammarParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(GrammarParser.DIV, 0); }
		public MultiplicationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMultiplication(this);
		}
	}
	public static class AtomiumContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomiumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAtomium(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAtomium(this);
		}
	}
	public static class EqualityContext extends ExprContext {
		public Token op;
		public TerminalNode NEQ() { return getToken(GrammarParser.NEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(GrammarParser.EQ, 0); }
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEquality(this);
		}
	}
	public static class AdditiveContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(GrammarParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(GrammarParser.ADD, 0); }
		public AdditiveContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAdditive(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			switch (_input.LA(1)) {
			case SUB:
				{
				_localctx = new UnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(53); match(SUB);
				setState(54); expr(9);
				}
				break;
			case T__5:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55); match(T__5);
				setState(56); expr(8);
				}
				break;
			case T__2:
			case BOOLEAN:
			case ID:
			case NUMBER:
			case STRING:
				{
				_localctx = new AtomiumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(61); match(T__6);
						setState(62); expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(64);
						((MultiplicationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MultiplicationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(65); expr(8);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(67);
						((AdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(68); expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(70);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTE) | (1L << GTE) | (1L << LT) | (1L << GT))) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(71); expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(73);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(74); expr(5);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(76); match(T__9);
						setState(77); expr(4);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(79); match(T__11);
						setState(80); expr(3);
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(GrammarParser.NUMBER, 0); }
		public NumberContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNumber(this);
		}
	}
	public static class BooleanContext extends AtomContext {
		public TerminalNode BOOLEAN() { return getToken(GrammarParser.BOOLEAN, 0); }
		public BooleanContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoolean(this);
		}
	}
	public static class StringContext extends AtomContext {
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public StringContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitString(this);
		}
	}
	public static class IdContext extends AtomContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public IdContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitId(this);
		}
	}
	public static class ParenthesisContext extends AtomContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParenthesis(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(94);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new ParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86); match(T__2);
				setState(87); expr(0);
				setState(88); match(T__1);
				}
				break;
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90); match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(91); match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92); match(ID);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93); match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 10);
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 6);
		case 3: return precpred(_ctx, 5);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 3);
		case 6: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'c\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\7\2\25\n\2"+
		"\f\2\16\2\30\13\2\3\2\3\2\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4&\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6\60\n\6\f\6\16\6\63\13\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7=\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7T\n\7\f\7\16"+
		"\7W\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\ba\n\b\3\b\2\3\f\t\2\4\6\b"+
		"\n\f\16\2\7\4\2\3\3\f\r\3\2\30\32\3\2\33\34\3\2\35 \3\2!\"l\2\20\3\2\2"+
		"\2\4\35\3\2\2\2\6\37\3\2\2\2\b\'\3\2\2\2\n)\3\2\2\2\f<\3\2\2\2\16`\3\2"+
		"\2\2\20\21\7\20\2\2\21\22\7#\2\2\22\26\7\6\2\2\23\25\5\4\3\2\24\23\3\2"+
		"\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2"+
		"\2\2\31\32\7\t\2\2\32\3\3\2\2\2\33\36\5\6\4\2\34\36\5\n\6\2\35\33\3\2"+
		"\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7%\2\2 !\7#\2\2!\"\7\4\2\2\"%\5\b"+
		"\5\2#$\7\b\2\2$&\5\f\7\2%#\3\2\2\2%&\3\2\2\2&\7\3\2\2\2\'(\t\2\2\2(\t"+
		"\3\2\2\2)*\7\24\2\2*+\7\16\2\2+,\5\f\7\2,-\7\17\2\2-\61\7\6\2\2.\60\5"+
		"\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2"+
		"\63\61\3\2\2\2\64\65\7\t\2\2\65\13\3\2\2\2\66\67\b\7\1\2\678\7\34\2\2"+
		"8=\5\f\7\139:\7\13\2\2:=\5\f\7\n;=\5\16\b\2<\66\3\2\2\2<9\3\2\2\2<;\3"+
		"\2\2\2=U\3\2\2\2>?\f\f\2\2?@\7\n\2\2@T\5\f\7\rAB\f\t\2\2BC\t\3\2\2CT\5"+
		"\f\7\nDE\f\b\2\2EF\t\4\2\2FT\5\f\7\tGH\f\7\2\2HI\t\5\2\2IT\5\f\7\bJK\f"+
		"\6\2\2KL\t\6\2\2LT\5\f\7\7MN\f\5\2\2NO\7\7\2\2OT\5\f\7\6PQ\f\4\2\2QR\7"+
		"\5\2\2RT\5\f\7\5S>\3\2\2\2SA\3\2\2\2SD\3\2\2\2SG\3\2\2\2SJ\3\2\2\2SM\3"+
		"\2\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\r\3\2\2\2WU\3\2\2\2XY"+
		"\7\16\2\2YZ\5\f\7\2Z[\7\17\2\2[a\3\2\2\2\\a\7$\2\2]a\7\21\2\2^a\7#\2\2"+
		"_a\7%\2\2`X\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\17\3\2\2"+
		"\2\n\26\35%\61<SU`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}