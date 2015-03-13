package org.fugazi.qls.ast.widget;

import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.Style;

import java.util.ArrayList;
import java.util.List;

public class UndefinedWidget extends Widget {

    @Override
    public void applyStyle(Style _style) {
        throw new AssertionError();
    }

    @Override
    public boolean isUndefined() {
        return true;
    }

    public List<Type> getSupportedQuestionTypes() {
        return new ArrayList<>();
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitUndefinedWidget(this);
    }
}