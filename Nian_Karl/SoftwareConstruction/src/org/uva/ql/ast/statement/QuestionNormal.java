package org.uva.ql.ast.statement;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.type.Type;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.utility.CodePosition;

public class QuestionNormal extends Statement {
	private final Identifier identifier;
	private final StrLiteral label;
	private final Type type;

	public QuestionNormal(Identifier identifier, StrLiteral label, Type type, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
		this.label = label;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public StrLiteral getLabel() {
		return label;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "[Question] " + "\n\tIdentifier = " + identifier.toString() + "\n\tLabel = " + label.toString()
				+ "\n\tType = " + type.toString();
	}
	
	@Override
	public String getText() {
		return label.getValue();
	}
}
