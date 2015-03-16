package ql.gui.input.expression;

import javafx.scene.layout.VBox;
import ql.ast.expression.Expr;
import ql.gui.ModelVisitor;
import ql.gui.control.Control;
import ql.semantics.ValueTable;
import ql.semantics.values.Value;

/**
 * Created by Nik on 28-02-2015
 */
// TODO
public class DateExprInput extends ExprInput
{
    public DateExprInput(String id, Expr expression)
    {
        this(id, expression, true);
    }

    public DateExprInput(String id, Expr expression, Boolean visible)
    {
        super(id, expression, visible);
    }

    @Override
    public void setValue(Value value)
    {
//        this.control.setValue(value);
    }

    @Override
    public <V> V accept(ModelVisitor<V> visitor)
    {
        return null;
    }

    @Override
    protected VBox createInputNode(Control control)
    {
        return null;
    }
}
