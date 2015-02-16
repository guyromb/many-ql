package org.fugazi.ast.Expression.unary;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Negative '-()'.
 */
public class NegExpression extends UnaryExpression {

    public NegExpression(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "- " + this.expr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitNegExpression(this);
    }
}