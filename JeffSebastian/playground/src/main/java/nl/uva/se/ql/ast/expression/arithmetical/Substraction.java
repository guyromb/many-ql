package nl.uva.se.ql.ast.expression.arithmetical;

import nl.uva.se.ql.ast.expression.Binary;
import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;

public class Substraction extends Binary {

	public Substraction(int lineNumber, int offset, Expression left,
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
