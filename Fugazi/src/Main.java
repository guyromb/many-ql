import org.fugazi.ql.ast.QLASTBuilder;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.gui.UIBuilder;
import org.fugazi.ql.type_checker.TypeChecker;
import org.fugazi.ql.type_checker.error.ASTErrorPrinter;
import org.fugazi.qls.ast.QLSASTBuilder;
import org.fugazi.qls.ast.stylesheet.StyleSheet;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0)
            inputFile = args[0];

        InputStream input = System.in;

        if (inputFile != null)
            input = new FileInputStream(inputFile);

        /** ---------------------
          * QL
          * --------------------- */
        // Create The AST Builder.
        QLASTBuilder QLAstBuilder = new QLASTBuilder(input);

        // Build the AST.
        Form form = QLAstBuilder.buildForm();

        // Perform type checking.
        TypeChecker typeChecker = new TypeChecker();
        boolean isFormTypesCorrect = typeChecker.checkForm(form);

        // display warnings and errors and if form is not type-correct, exit
        ASTErrorPrinter printer = new ASTErrorPrinter(
                typeChecker.getErrors(), typeChecker.getWarnings()
        );
        printer.displayWarningsAndErrors();

        if (!isFormTypesCorrect) {
            System.err.println("Form is not type correct. Cannot evaluate and render. Please fix the errors.");
            System.exit(-1);
        }

        /** ---------------------
         * QLS
         * --------------------- */
        // Create The AST Builder.
        //QLSASTBuilder qlsAstBuilder = new QLSASTBuilder(input);

        // Build the AST.
        //StyleSheet styleSheet = qlsAstBuilder.buildStyleSheet();

         // Render GUI.
        UIBuilder guiBuilder = new UIBuilder(form);
        guiBuilder.renderGUI();
    }
}