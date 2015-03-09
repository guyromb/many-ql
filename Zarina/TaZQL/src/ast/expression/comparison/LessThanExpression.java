package ast.expression.comparison;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

// <

public class LessThanExpression extends BinaryExpression {
				
	public LessThanExpression (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
									
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.getLeftExpression().toString() + " < " + super.getRightExpression().toString();
	}

	@Override
	public ChoiceType getExpressionType() {
		return new ChoiceType();
	}
}



