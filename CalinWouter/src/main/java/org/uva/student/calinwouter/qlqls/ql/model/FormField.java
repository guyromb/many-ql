package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQlRenderer;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.Value;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public abstract class FormField {
    private final FormInterpreter formInterpreter;
    private String label, variable;

    public abstract <T> T applyRenderer(IQlRenderer<T> iQlRenderer) throws FieldNotFoundException;

    public Value<?> getValue() {
        return formInterpreter.getField(variable);
    }

    public String getVariable() {
        return variable;
    }

    public String getLabel() {
        return label;
    }

    public void setValue(Value<?> value) {
        formInterpreter.setField(variable, value);
    }

    public FormField(String label, String variable, FormInterpreter formInterpreter) {
        this.label = label;
        this.variable = variable;
        this.formInterpreter = formInterpreter;
    }
}
