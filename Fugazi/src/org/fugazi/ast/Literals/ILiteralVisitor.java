package org.fugazi.ast.Literals;

/**
 * Generic Visitor interface for Literals.
 * @param <T>
 */
public interface ILiteralVisitor<T> {

    public T visit(ID idLiteral);
    public T visit(STRING stringLiteral);
    public T visit(NUMBER numberLiteral);
}
