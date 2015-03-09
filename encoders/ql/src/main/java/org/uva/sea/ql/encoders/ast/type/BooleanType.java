package org.uva.sea.ql.encoders.ast.type;

public class BooleanType extends DataType {

	@Override
	public <T> T accept(DataTypeVisitor<T> dataTypeVisitor) {
		return dataTypeVisitor.visit(this);
	}

}