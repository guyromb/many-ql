/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.uva.student.calinwouter.qlqls.generated.analysis;

import org.uva.student.calinwouter.qlqls.generated.node.*;

public interface Analysis extends Switch {
    Object getIn(Node node);

    void setIn(Node node, Object o);

    Object getOut(Node node);

    void setOut(Node node, Object o);

    void caseStart(Start node);

    void caseAFormBegin(AFormBegin node);

    void caseAStylesheetBegin(AStylesheetBegin node);

    void caseAForm(AForm node);

    void caseAQuestionStmt(AQuestionStmt node);

    void caseAValueStmt(AValueStmt node);

    void caseAIfelseStmt(AIfelseStmt node);

    void caseAIfStmt(AIfStmt node);

    void caseABoolType(ABoolType node);

    void caseAStringType(AStringType node);

    void caseAIntType(AIntType node);

    void caseAAddExp(AAddExp node);

    void caseASubExp(ASubExp node);

    void caseATrueExp(ATrueExp node);

    void caseAFalseExp(AFalseExp node);

    void caseAOrExp(AOrExp node);

    void caseAAndExp(AAndExp node);

    void caseAEqExp(AEqExp node);

    void caseANeqExp(ANeqExp node);

    void caseALtExp(ALtExp node);

    void caseAGtExp(AGtExp node);

    void caseALteExp(ALteExp node);

    void caseAGteExp(AGteExp node);

    void caseAMulExp(AMulExp node);

    void caseADivExp(ADivExp node);

    void caseAModExp(AModExp node);

    void caseANotExp(ANotExp node);

    void caseANumberExp(ANumberExp node);

    void caseAIdentExp(AIdentExp node);

    void caseAEmptyIdentList(AEmptyIdentList node);

    void caseAFilledIdentList(AFilledIdentList node);

    void caseATypeElement(ATypeElement node);

    void caseAIdentElement(AIdentElement node);

    void caseAHexElement(AHexElement node);

    void caseAStringElement(AStringElement node);

    void caseANumberElement(ANumberElement node);

    void caseAObjectElement(AObjectElement node);

    void caseAListElement(AListElement node);

    void caseAObjectEl(AObjectEl node);

    void caseTComment(TComment node);

    void caseTTnot(TTnot node);

    void caseTNumber(TNumber node);

    void caseTOr(TOr node);

    void caseTAnd(TAnd node);

    void caseTAdd(TAdd node);

    void caseTSub(TSub node);

    void caseTMul(TMul node);

    void caseTDiv(TDiv node);

    void caseTMod(TMod node);

    void caseTLparen(TLparen node);

    void caseTRparen(TRparen node);

    void caseTTform(TTform node);

    void caseTLbrace(TLbrace node);

    void caseTRbrace(TRbrace node);

    void caseTColon(TColon node);

    void caseTIf(TIf node);

    void caseTElse(TElse node);

    void caseTTbool(TTbool node);

    void caseTTtrue(TTtrue node);

    void caseTTfalse(TTfalse node);

    void caseTTstring(TTstring node);

    void caseTTint(TTint node);

    void caseTString(TString node);

    void caseTTeq(TTeq node);

    void caseTTneq(TTneq node);

    void caseTTlt(TTlt node);

    void caseTTgt(TTgt node);

    void caseTTlte(TTlte node);

    void caseTTgte(TTgte node);

    void caseTBlank(TBlank node);

    void caseTIdent(TIdent node);

    void caseTHex(THex node);

    void caseTComma(TComma node);

    void caseEOF(EOF node);

    void caseInvalidToken(InvalidToken node);
}
