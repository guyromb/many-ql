package org.fugazi.ast.Expression.logical;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The OR '||'.
 */
public class OrExpression extends LogicalExpression {

    public OrExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " || " + this.rightExpr.toString();
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitOrExpression(this);
    }
}