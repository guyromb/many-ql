package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

public class PStmtTypeChecker extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PExpTypeChecker pExpTypeChecker;

    private void typeCheckExpressionIsBoolean(PExp ifExpression) {
        ifExpression.apply(pExpTypeChecker);
        pExpTypeChecker.checkLastEntryIsOfType(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    private void typeCheckIfExpression(AIfStmt node) {
        final PExp ifExpression = node.getExp();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    private void typeCheckIfExpression(AIfelseStmt node) {
        final PExp ifExpression = node.getExp();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
    }

    private void typeCheckStatement(PStmt node) {
        node.apply(this);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
        typeCheckElseStatements(node);
    }

    private void typeCheckThenStatements(AIfStmt node) {
        for (PStmt thenStatement : node.getThenStmtList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckThenStatements(AIfelseStmt node) {
        for (PStmt thenStatement : node.getThenStmtList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckElseStatements(AIfelseStmt node) {
        for (PStmt elseStatement : node.getElseStmtList()) {
            typeCheckStatement(elseStatement);
        }
    }

    private TypeDescriptor getTypeOfField(AValueStmt node) {
        String identifier = node.getIdent().getText();
        return staticFields.getTypeOfField(identifier);
    }

    private void processExpressionOf(AValueStmt node) {
        final PExp expression = node.getExp();
        expression.apply(pExpTypeChecker);
    }

    private void checkExpressionIsOfType(AValueStmt node, TypeDescriptor typeDescriptor) {
        processExpressionOf(node);
        pExpTypeChecker.checkLastEntryIsOfType(typeDescriptor);
    }

    @Override
    public void caseAValueStmt(AValueStmt node) {
        final TypeDescriptor typeDescriptor = getTypeOfField(node);
        checkExpressionIsOfType(node, typeDescriptor);
    }

    public PStmtTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.pExpTypeChecker = new PExpTypeChecker(staticFields, typeCheckResults);
    }

}
