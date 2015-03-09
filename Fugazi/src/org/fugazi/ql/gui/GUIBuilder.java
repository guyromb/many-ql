package org.fugazi.ql.gui;

import org.fugazi.ql.ast.expression.Expression;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.Evaluator;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.mediator.Colleague;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.ql.gui.ui_elements.UIQuestion;
import org.fugazi.ql.gui.visitor.UITypeVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIBuilder implements IMediator {

    private final ValueStorage valueStorage;
    private final Evaluator evaluator;
    private final UIForm uiForm;
    private final Form astForm;

    private Map<UIQuestion, List<IfStatement>> questionsWithState = new HashMap<>();
    private List<UIQuestion> questionsInForm = new ArrayList<>();

    private List<UIComputedQuestion> computedQuestions = new ArrayList<>();

    public GUIBuilder(Form _form) {
        this.astForm = _form;
        this.valueStorage = new ValueStorage();
        this.evaluator = new Evaluator(valueStorage);
        this.uiForm = new UIForm(_form.getName());

        this.addIfStatementsToQuestion(astForm);
    }

    public void renderUI() {
        setupForm();
        uiForm.showForm();
    }

    // Manage Form
    private void setupForm() {
        for (UIQuestion uiQuestion : questionsWithState.keySet()) {
            if (isQuestionStateTrue(uiQuestion)) {
                addQuestionToForm(uiQuestion);
            } else {
                removeQuestionFromForm(uiQuestion);
            }
        }
    }

    private void addQuestionToForm(UIQuestion _uiQuestion) {
        if (!questionsInForm.contains(_uiQuestion)) {
            questionsInForm.add(_uiQuestion);
            uiForm.addQuestion(_uiQuestion);
        }
    }

    private void removeQuestionFromForm(UIQuestion _uiQuestion) {
        if (questionsInForm.contains(_uiQuestion)) {
            questionsInForm.remove(_uiQuestion);
            uiForm.removeQuestion(_uiQuestion);
        }
    }

    private void addIfStatementsToQuestion(Form _form) {
        QLFormDataStorage formDataStorage = new QLFormDataStorage(_form);
        List<Question> questionsList = formDataStorage.getAllQuestions();
        List<IfStatement> ifStatementsList = formDataStorage.getIfStatements();

        // Get all the questions of the form.
        for (Question question : questionsList) {
            UIQuestion uiQuestion = createUiQuestion(question);
            valueStorage.saveValue(uiQuestion.getId(), uiQuestion.getState()); // save defaults
            questionsWithState.put(uiQuestion, new ArrayList<IfStatement>());

            // get if statements which the questionsInForm are included.
            for (IfStatement ifStatement : ifStatementsList) {
                if (ifStatement.getBody().contains(question)) {
                    questionsWithState.get(uiQuestion).add(ifStatement);
                }
            }
        }
    }

    private boolean isQuestionStateTrue(UIQuestion _question) {
        boolean isTrue = true;
        for (IfStatement ifStatement : questionsWithState.get(_question)) {
            if (!evaluateIfStatement(ifStatement)) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    private UIQuestion createUiQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        return _question.getType().accept(typeVisitor);
    }

    // Colleagues changes.
    public void getChangeFromColleagues(Colleague _origin) {
        valueStorage.saveValue(_origin.getId(), _origin.getState());
        renderUI();
    }

    // Evaluation
    private boolean evaluateIfStatement(IfStatement _ifStatement) {
        Expression condition = _ifStatement.getCondition();
        ExpressionValue expressionValue = this.evaluator.evaluateExpression(condition);

        BoolValue result;
        if (!expressionValue.isUndefined()) {
            result = (BoolValue) this.evaluator.evaluateExpression(condition);
        }else {
            result = new BoolValue(false);
        }
        return result.getValue();
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        return evaluator.evaluateExpression(expression);
    }

    private ExpressionValue evaluateComputedExpression(ComputedQuestion _computedQuest) {
        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        valueStorage.saveValue(_computedQuest.getIdName(), result);
        return result;
    }
}