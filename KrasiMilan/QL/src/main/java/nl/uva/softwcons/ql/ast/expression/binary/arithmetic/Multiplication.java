package nl.uva.softwcons.ql.ast.expression.binary.arithmetic;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class Multiplication extends ArithmeticExpression {

    public Multiplication(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public <T> T accept(final ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
