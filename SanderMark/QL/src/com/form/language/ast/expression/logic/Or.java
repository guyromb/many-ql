package com.form.language.ast.expression.logic;

import com.form.language.ast.expression.BinaryExpression;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;

public class Or extends BinaryExpression implements Expression {

	public Or(Expression left, Expression right) {
		super(left, right);
	}
	
	@Override
	public BoolValue evaluate() {
		return ((BoolLiteral)left).evaluate().Or(((BoolLiteral)right).evaluate());
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
