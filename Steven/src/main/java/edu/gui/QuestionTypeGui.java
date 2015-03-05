package edu.gui;


import edu.parser.nodes.QuestionType;

import javax.swing.*;

/**
 * Created by Steven Kok on 25/02/2015.
 */
public enum QuestionTypeGui {
    STRING(edu.gui.components.TextBox.class, QuestionType.STRING),
    BOOLEAN(edu.gui.components.CheckBox.class, QuestionType.BOOLEAN);

    private final Class component;
    private final QuestionType questionType;

    private <T> QuestionTypeGui(Class<T> component, QuestionType questionType) {
        this.component = component;
        this.questionType = questionType;
    }

    public static JComponent getComponent(QuestionType questionType) throws IllegalAccessException, InstantiationException {
        for (QuestionTypeGui questionTypeGui : values()) {
            if (questionTypeGui.getQuestionType().equals(questionType)) {
                return (JComponent) questionTypeGui.component.newInstance();
            }
        }
        throw new IllegalArgumentException("Unknown component for argument: " + questionType);
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}