package nl.uva.se.ql.ast.expression.logical;

import nl.uva.se.ql.ast.expression.Binary;
import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;

public class NotEqual extends Binary {

	public NotEqual(int lineNumber, int offset, Expression left,
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
