package nl.uva.bromance.ast;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionnaireASTTest extends ASTTest {

    @Test
    public void correctQuestionnaire() throws IOException {

        Questionnaire ast = (Questionnaire) createAst(CORRECT_QUESTIONNAIRE).getRoot();

        assertThat(ast.getLineNumber()).isEqualTo(1);
        assertThat(ast.hasChildren()).isTrue();
        assertThat(ast.getChildren().size()).isEqualTo(1);
    }

}
