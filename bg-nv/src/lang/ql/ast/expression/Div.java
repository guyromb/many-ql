package lang.ql.ast.expression;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 17/02/15.
 */
public class Div extends BinaryExpr
{
    public Div(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public Type getComputedType(Type childType)
    {
        return childType;
    }

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
