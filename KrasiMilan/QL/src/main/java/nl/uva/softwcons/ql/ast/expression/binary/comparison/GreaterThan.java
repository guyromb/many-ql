package nl.uva.softwcons.ql.ast.expression.binary.comparison;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;

public class GreaterThan extends ComparisonExpression {

    public GreaterThan(final Expression left, final Expression right, final LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public <T> T accept(final ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
