package org.fugazi.gui;

import org.fugazi.ast.statement.Question;
import org.fugazi.gui.ui_elements.*;

public class UIQuestionFactory {

    public UIQuestion getUIQuestion(Question _question) {
        
        if (_question.getType().toString().equals("Bool")) {
            return new UIBoolQuestion(_question);

        } else if (_question.getType().toString().equals("Int")) {
            return new UINumQuestion(_question);

        } else if (_question.getType().toString().equals("String")) {
            return new UITextQuestion(_question);
        }

        return null;
    }
}
