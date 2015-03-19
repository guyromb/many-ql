package com.form.language.ast.statement;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.form.language.ast.expression.variable.Reference;
import com.form.language.ast.type.Type;
import com.form.language.error.QLToken;
import com.form.language.gui.components.FormComponent;
import com.form.language.memory.Context;

public class Question extends Statement {
    private String id;
    private String questionLabel;
    private Type questionType;

    public Question(String questionLabel, String id, Type questionType, QLToken tokenInfo) {
	super(tokenInfo);
	this.questionLabel = questionLabel;
	this.id = id;
	this.questionType = questionType;
    }

    //TODO: This is not really 'getType' but rather something like initialization we can't do in the constructor.
    @Override
    public Type getType(Context context) {
	context.addId(new Reference(this.id, this.questionType, tokenInfo));
	return this.questionType;
    }

    public String getText() {
	return this.questionLabel;
    }

    public String getId() {
	// TODO Auto-generated method stub
	return this.id;
    }

    public void initMemory(Context context) {
	context.setValue(id, questionType.defaultValue());
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {
	guiBuilder.createGUIQuestion(this, panel, context);

    }

}
