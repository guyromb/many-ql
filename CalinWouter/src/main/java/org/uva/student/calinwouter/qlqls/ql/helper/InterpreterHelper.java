package org.uva.student.calinwouter.qlqls.ql.helper;

import org.uva.student.calinwouter.qlqls.generated.lexer.Lexer;
import org.uva.student.calinwouter.qlqls.generated.lexer.LexerException;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.generated.parser.Parser;
import org.uva.student.calinwouter.qlqls.generated.parser.ParserException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.components.StyleSheet;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class InterpreterHelper {

    /*private static void applyInterpreterUsing(String input, FormInterpreter formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }*/
    //TODO this two methods must be merged - the only difference is in the type of parameters they get
    private static void applyInterpreterUsing(String input, FormInterpreter formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }

    private static void applyInterpreterUsing(String input, FormTypeChecker formInterpreter) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        AForm form = (AForm) ((AFormBegin) ast.getPBegin()).getForm();
        form.apply(formInterpreter);
    }

    public static FormTypeChecker typeCheckString(String input) throws ParserException, IOException, LexerException {
        FormTypeChecker formInterpreter = new FormTypeChecker();
        applyInterpreterUsing(input, formInterpreter);
        return formInterpreter;
    }

    public static StyleSheet interpetStylesheetString(String input) throws ParserException, IOException, LexerException {
        Lexer lexer = new Lexer(new PushbackReader(new StringReader(input)));
        Parser parser = new Parser(lexer);
        Start ast = parser.parse();
        QLSInterpreter qlsInterpreter = new QLSInterpreter();
        return qlsInterpreter.interpret((AStylesheetBegin) ast.getPBegin());
    }

    public static FormInterpreter initializeHeadlessInterpreter(String input) throws ParserException, IOException, LexerException {
        FormInterpreter formInterpreter = new FormInterpreter();
        applyInterpreterUsing(input, formInterpreter);
        return formInterpreter;
    }

    public static FormInterpreter interpetStringHeadless(String input) throws ParserException, IOException, LexerException {
        FormInterpreter formInterpreter = initializeHeadlessInterpreter(input);
        formInterpreter.interpret();
        return formInterpreter;
    }

    private InterpreterHelper() {
    }

}