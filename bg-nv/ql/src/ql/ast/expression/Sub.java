package ql.ast.expression;

import ql.ast.type.Type;

/**
 * Created by bore on 09/02/15.
 */
public class Sub extends BinaryExpr
{
    public Sub(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    @Override
    public boolean isTypeCompatibleWithExpr(Type t)
    {
        return t.isNumerical();
    }

    @Override
    public Type getReturnType(Type childType)
    {
        return childType;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
