package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class TrueExp {

    public Object interprete(Environment environment) throws InterpretationException {
        return true;
    }

}