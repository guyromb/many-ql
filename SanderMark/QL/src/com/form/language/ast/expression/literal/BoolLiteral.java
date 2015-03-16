package com.form.language.ast.expression.literal;

import org.antlr.v4.runtime.Token;

import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.BoolValue;
import com.form.language.memory.Context;

public class BoolLiteral extends Literal  {
    private final boolean _value;

    public BoolLiteral(boolean _value, Token tokenInfo) {
	super(tokenInfo);
	this._value = _value;
    }

    @Override
    public BoolValue evaluate(Context context) {
	return new BoolValue(_value);
    }

    @Override
    public Type getType(Context context) {
	return new BoolType();
    }

}
