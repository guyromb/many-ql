package com.klq;

import com.klq.ast.IVisitor;
import com.klq.ast.ANode;
import com.klq.ast.impl.*;
import com.klq.logic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 17-2-15.
 */
public class Visitor implements IVisitor {
    List<com.klq.logic.Question> questList = new ArrayList<com.klq.logic.Question>();

    @Override
    public void visit(QuestionnaireNode node) {
        for(ANode child : node.getChildren()){
            visit(child);
        }
    }

    public void visit(ANode node){

    }

    @Override
    public void visit(MulDivNode node) {

    }

    @Override
    public void visit(QuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = Type.STRING;
        Text text = new Text(node.getText());

        com.klq.logic.Question question = new com.klq.logic.Question(id, type, null, text, null, null);
        questList.add(question);

    }

    @Override
    public void visit(ComputedQuestionNode node) {
        Id id = new Id(node.getQuestionID());
        Type type = Type.NUMERAL;
        Text text = new Text(node.getText());
        AnswerSet answers = new AnswerSet();
        answers.add(new Answer("24"));//done with children

        com.klq.logic.Question question = new com.klq.logic.Question(id, type, null, text, null, null);
        questList.add(question);

    }

    @Override
    public void visit(StringNode node) {

    }

    @Override
    public void visit(NumberNode node) {

    }

    @Override
    public void visit(DateNode node) {

    }

    public List<com.klq.logic.Question> getQuestList() {
        return questList;
    }
}
