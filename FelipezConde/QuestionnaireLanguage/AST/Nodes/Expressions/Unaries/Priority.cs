﻿
namespace AST.Nodes.Expressions.Unaries
{
    public class Priority : Unary
    {
        public Priority(Expression child, PositionInText position)
            : base(child ,position)
        { }

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "()";
        }
    }
}
