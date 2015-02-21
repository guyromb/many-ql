package nl.uva.bromance.AST;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nl.uva.bromance.AST.Range.Range;
import nl.uva.bromance.Answer;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Question extends Node {
    private static final String[] parentsAllowed = {"Form", "IfStatement", "ElseStatement", "ElseIfStatement"};
    // TODO: Implement custom question type and remove here
    private static final String[] questionTypes = {"integer", "string", "boolean", "custom"};

    private String identifier;
    private String questionString;
    private String questionType;
    private Range questionRange;

    public Question(int lineNumber, String id) {
        super(lineNumber, "Question");
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1);
        } else {
            System.err.println("Question Error: No identifier specified");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getQuestionString() {
        return questionString;
    }

    public String getQuestionType() {
        return questionType;
    }

    public Range getQuestionRange() {
        return questionRange;
    }

    public void setQuestionString(String qs) {
        if (qs != null) {
            this.questionString = qs;
        } else {
            System.err.println("Question Error: No question asked");
        }
    }

    public void setQuestionType(String qt) {
        qt = qt.toLowerCase();
        boolean valid = false;
        for (String type : questionTypes) {
            if (type.equals(qt)) {
                valid = true;
                break;
            }
        }
        if (valid) {
            this.questionType = qt;
        } else {
            System.err.println("Question Error: Invalid Question type " + qt + ", valid types are :" + Arrays.toString(questionTypes));
        }
    }

    public void setQuestionRange(Range r) {
        this.questionRange = r;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Question] { Name : " + this.identifier + " , QuestionString: " + this.questionString + " , Type: " + this.questionType + " , Range: " + this.questionRange + " }\n");
        for (Node n : children) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Pane visualize(Pane parent) {
        parent.getChildren().add(new Label(questionString));
        if ("integer".equals(getQuestionType())) {
            parent.getChildren().add(new TextField());
        } else if ("string".equals(getQuestionType())) {
            parent.getChildren().add(new TextField());
        } else if ("boolean".equals(getQuestionType())) {
            parent.getChildren().add(new CheckBox());
        }

        return super.visualize(parent);
    }

    @Override
    public void typeCheck(Map<String, Node> references, Node node) {
        Question q = (Question) node;
        if (references.get(q.getIdentifier()) == null) {

        } else {
            Answer a = new Answer(q.getQuestionType());
            references.put(q.getIdentifier(), q);
        }
    }
}
