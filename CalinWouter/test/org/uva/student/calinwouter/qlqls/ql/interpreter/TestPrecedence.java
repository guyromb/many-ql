package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.junit.Test;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.helper.InterpreterHelper;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.uva.student.calinwouter.qlqls.ql.helper.QLGeneratorHelper.form;
import static org.uva.student.calinwouter.qlqls.ql.helper.QLGeneratorHelper.value;

public class TestPrecedence {

    private Object calcValue(String exp) throws ParserException, IOException, LexerException {
        FormInterpreter formInterpreter =
                InterpreterHelper.interpetStringHeadless(form(value("value", "", "int", exp)));
        return formInterpreter.getField("value").getValue();
    }

    @Test
    public void testNumerical() throws ParserException, IOException, LexerException {
        assertEquals(calcValue("2 * 1 + 2 * 3"), 2 * 1 + 2 * 3);
        assertEquals(calcValue("2 * 1 + 4 / 2"), 2 * 1 + 4 / 2);
        assertEquals(calcValue("15 % 4 * 2 + 1"), 15 % 4 * 2 + 1);
    }

    @Test
    public void testLogical() throws ParserException, IOException, LexerException {
        assertEquals(calcValue("false || true && false"), false || true && false);
        assertEquals(calcValue("false || !false && false"), false || !false && false);
        assertEquals(calcValue("!true || !false && !true"), !true || !false && !true);
        assertEquals(calcValue("!true || !false && !true"), !true || !false && !true);
    }

    @Test
    public void testCmp() throws ParserException, IOException, LexerException {
        assertEquals(calcValue("5 > 6 || 6 > 5 && 5 > 6"), 5 > 6 || 6 > 5 && 5 > 6);
    }

}