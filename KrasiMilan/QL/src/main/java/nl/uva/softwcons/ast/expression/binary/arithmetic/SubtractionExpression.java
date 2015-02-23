package nl.uva.softwcons.ast.expression.binary.arithmetic;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class SubtractionExpression extends ArithmeticExpression {

    public SubtractionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
