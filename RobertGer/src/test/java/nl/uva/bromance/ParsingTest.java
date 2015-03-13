package nl.uva.bromance;

/**
 * Created by Robert on 3/2/2015.
 */
public class ParsingTest {

    protected static final String CORRECT_FORM = "    Form: \"default\" {\n" +
            "       Label: \"something\"{\n" +
            "           Text: \"something\"\n" +
            "      }}\n";

    protected static final String CORRECT_QUESTIONNAIRE = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}\n";
    protected static final String CORRECT_QUESTION = "\n     Question: \"identifier\"{" +
            "           Text: \"text\"" +
            "           Answer: integer" +
            "       }";

    protected static final String CORRECT_ELSE = "  Else:{ Text: \"something\"}\n";
    protected static final String CORRECT_IF = "   If: something{  Text: \"something\" }\n";
    protected static final String CORRECT_ELSE_IF = "Else If: something{ Text: \"something\" }\n";

    protected static final String CORRECT_CALCULATION = "Calculation: \"calculation\"{\n" +
            CORRECT_IF +
            "    }\n";

    public static final String CORRECT_FORM_SETUP = "Name: \"Tax\" {\n" +
            CORRECT_FORM +
            "}";
}