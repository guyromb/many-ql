package org.fugazi.ql.ast.statement;

import org.fugazi.ql.ast.expression.Expression;

import java.util.List;

public class IfStatement extends Statement {

    private final Expression condition;
    private final List<Statement> body;

    public IfStatement(Expression _condition, List<Statement> _body) {
        this.condition = _condition;
        this.body = _body;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public List<Statement> getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        String string = "\n if (" + this.condition.toString() + ") {\n";

        for (Statement statement : this.body)
            string += statement.toString();
        string += "\n}";
        
        return string;
    }

    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visitIfStatement(this);
    }
}