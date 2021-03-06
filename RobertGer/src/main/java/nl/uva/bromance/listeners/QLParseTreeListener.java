package nl.uva.bromance.listeners;


import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.range.Between;
import nl.uva.bromance.ast.range.BiggerThan;
import nl.uva.bromance.ast.range.SmallerThan;
import nl.uva.bromance.parsers.QLBaseListener;
import nl.uva.bromance.parsers.QLParser;

import java.util.Optional;
import java.util.Stack;
import java.util.UUID;

public class QLParseTreeListener extends QLBaseListener {

    private Stack<QLNode> nodeStack = new Stack<>();
    private AST<QLNode> ast = null;

    public AST<QLNode> getAst() {
        return ast;
    }

    @Override
    public void enterQuestionnaire(QLParser.QuestionnaireContext ctx) {
        nodeStack.push(new Questionnaire(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitQuestionnaire(QLParser.QuestionnaireContext ctx) {
        ast = new AST(nodeStack.pop());
    }

    @Override
    public void enterForm(QLParser.FormContext ctx) {
        nodeStack.push(new Form(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitForm(QLParser.FormContext ctx) {
        Form f = (Form) nodeStack.pop();
        nodeStack.peek().addChild(f);
    }

    @Override
    public void enterQuestion(QLParser.QuestionContext ctx) {
        nodeStack.push(new Question(ctx.start.getLine(), UUID.randomUUID(), ctx.name.getText()));
    }

    @Override
    public void exitQuestion(QLParser.QuestionContext qtx) {
        Question q = (Question) nodeStack.pop();
        nodeStack.peek().addChild(q);

    }

    @Override
    public void enterQuestionText(QLParser.QuestionTextContext ctx) {
        ((Question) nodeStack.peek()).setQuestionString(ctx.text.getText());
    }

    @Override
    public void enterQuestionAnswerSimple(QLParser.QuestionAnswerSimpleContext ctx) {
        ((Question) nodeStack.peek()).setQuestionType(ctx.type.getText());
    }

    @Override
    public void enterQuestionAnswerCustom(QLParser.QuestionAnswerCustomContext ctx) {
        Question peek = (Question) nodeStack.peek();
        peek.setQuestionType("custom");
        peek.setMultipleChoiceOptions(ctx.STRING());
    }

    @Override
    public void exitQuestionRangeFromTo(QLParser.QuestionRangeFromToContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new Between(Integer.parseInt(ctx.lower.getText()), Integer.parseInt(ctx.higher.getText())));
    }

    @Override
    public void exitQuestionRangeBiggerThan(QLParser.QuestionRangeBiggerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new BiggerThan(Integer.parseInt(ctx.num.getText())));
    }

    @Override
    public void exitQuestionRangeSmallerThan(QLParser.QuestionRangeSmallerThanContext ctx) {
        ((Question) nodeStack.peek()).setQuestionRange(new SmallerThan(Integer.parseInt(ctx.num.getText())));
    }

    @Override
    public void enterCalculation(QLParser.CalculationContext ctx) {
        nodeStack.push(new Calculation(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitCalculation(QLParser.CalculationContext ctx) {
        Calculation c = (Calculation) nodeStack.pop();
        nodeStack.peek().addChild(c);
    }

    @Override
    public void enterLabel(QLParser.LabelContext ctx) {
        nodeStack.push(new Label(ctx.start.getLine(), ctx.name.getText()));
    }

    @Override
    public void exitLabel(QLParser.LabelContext ctx) {
        Label l = (Label) nodeStack.pop();
        nodeStack.peek().addChild(l);
    }

    @Override
    public void exitLabelText(QLParser.LabelTextContext ctx) {
        nodeStack.peek().addChild(new LabelText(ctx.start.getLine(), ctx.text.getText()));
    }
    /*
     * Expression logic
     */

    @Override
    public void enterIfStatement(QLParser.IfStatementContext ctx) {
        nodeStack.push(new IfStatement(ctx.start.getLine()));
    }

    @Override
    public void enterElseStatement(QLParser.ElseStatementContext ctx) {
        nodeStack.push(new ElseStatement(ctx.start.getLine()));
    }

    @Override
    public void enterElseIfStatement(QLParser.ElseIfStatementContext ctx) {
        nodeStack.push(new ElseIfStatement(ctx.start.getLine()));
    }

    @Override
    public void exitIfStatement(QLParser.IfStatementContext ctx) {
        IfStatement ifs = (IfStatement) nodeStack.pop();
        QLNode peek = nodeStack.peek();
        peek.addChild(ifs);
    }

    @Override
    public void exitElseStatement(QLParser.ElseStatementContext ctx) {
        ElseStatement est = (ElseStatement) nodeStack.pop();
        QLNode peek = nodeStack.peek();
        peek.addChild(est);
    }

    @Override
    public void exitElseIfStatement(QLParser.ElseIfStatementContext ctx) {
        ElseIfStatement eis = (ElseIfStatement) nodeStack.pop();
        QLNode peek = nodeStack.peek();
        peek.addChild(eis);
    }

    @Override
    public void enterExpression(QLParser.ExpressionContext ctx) {
        Expression expression = new Expression(ctx.start.getLine(), Optional.ofNullable(ctx.operator));
        nodeStack.push(expression);
    }

    @Override
    public void exitExpression(QLParser.ExpressionContext ctx) {
        Expression expression = (Expression) nodeStack.pop();
        QLNode parent = nodeStack.peek();
        parent.addChild(expression);
        if (parent instanceof Expression) {
            if (((Expression) parent).getLeftHandSide().isPresent()) {
                ((Expression) parent).setRightHandSide(Optional.of(expression));
            } else {
                ((Expression) parent).setLeftHandSide(Optional.of(expression));
            }
        } else if (parent instanceof ContainsExpression) {
            ((ContainsExpression) parent).setExpression(expression);
        }
    }

    @Override
    public void enterId(QLParser.IdContext ctx) {
        nodeStack.push(new Terminal(ctx.start.getLine(), ctx.getText()));
    }

    @Override
    public void exitId(QLParser.IdContext ctx) {
        Terminal terminal = (Terminal) nodeStack.pop();
        nodeStack.peek().addChild(terminal);
    }
}
