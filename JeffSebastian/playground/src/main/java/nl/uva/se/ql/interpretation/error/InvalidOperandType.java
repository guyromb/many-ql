package nl.uva.se.ql.interpretation.error;

import java.util.List;

import nl.uva.se.ql.ast.type.Type;

public class InvalidOperandType extends Error {

	public InvalidOperandType(int line, int offset, Type expected, Type... actual) {
		super(line, offset, "invalid operand type", "expected " + expected
				+ ", but got " + actual);
	}

}
