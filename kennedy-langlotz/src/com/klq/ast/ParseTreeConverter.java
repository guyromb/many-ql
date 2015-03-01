package com.klq.ast;
import com.klq.ast.impl.*;
import com.klq.ast.impl.expr.*;
import com.klq.ast.impl.expr.bool.AndNode;
import com.klq.ast.impl.expr.bool.OrNode;
import com.klq.ast.impl.expr.comp.*;
import com.klq.ast.impl.expr.math.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by juriaan on 16-2-15.
 */
public class ParseTreeConverter extends KLQBaseVisitor<ANode>{
    /*==================================================================================================================
    Statements
    ==================================================================================================================*/
    @Override
    public ANode visitQuestionnaire(KLQParser.QuestionnaireContext ctx) {
        QuestionnaireNode ast = new QuestionnaireNode(formatLocation(ctx));

        for(KLQParser.QuestionContext question : ctx.question()){
            ast.getChildren().add(visit(question));
        }
        return ast;
    }

    @Override
    public ANode visitUncondQuestion(KLQParser.UncondQuestionContext ctx) {
        QuestionNode questionNode;

        if(ctx.answerOptions() == null){
            questionNode = new QuestionNode(ctx.id.getText(), ctx.type.getText(), stripQuotes(ctx.text.getText()), formatLocation(ctx));
        }
        else {
            ANode child = visit(ctx.answerOptions());
            questionNode = new ComputedQuestionNode(ctx.id.getText(), ctx.type.getText(), stripQuotes(ctx.text.getText()), child, formatLocation(ctx));
        }
        return questionNode;
    }

    @Override
    public ANode visitCondQuestion(KLQParser.CondQuestionContext ctx) {
        ANode condition = visit(ctx.expr());
        ArrayList<ANode> body = new ArrayList<ANode>();

        for(KLQParser.QuestionContext question : ctx.question()){
            body.add(visit(question));
        }

        return new ConditionalNode(condition, body, formatLocation(ctx));
    }

    /*==================================================================================================================
        Primitives
    ==================================================================================================================*/
    @Override
    public ANode visitDate(KLQParser.DateContext ctx) {
        String dateString = ctx.Date().getText();
        DateTimeFormatter formatter;

        //TODO Move this logic to a better location
        if(dateString.contains(".")){
            formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        }
        else if(dateString.contains("/")){
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        }
        else{
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        }

        DateNode dateNode = new DateNode(LocalDate.parse(dateString, formatter), formatLocation(ctx));
        return dateNode;
    }

    @Override
    public ANode visitNumber(KLQParser.NumberContext ctx) {
        NumberNode numberNode = new NumberNode(Double.valueOf(ctx.Number().getText()), formatLocation(ctx));
        return numberNode;
    }

    @Override
    public ANode visitString(KLQParser.StringContext ctx) {
        StringNode stringNode = new StringNode(stripQuotes(ctx.String().getText()), formatLocation(ctx));
        return stringNode;
    }

    /*==================================================================================================================
    Expressions
    ==================================================================================================================*/
    @Override
    public ANode visitId(KLQParser.IdContext ctx) {
        return new IdentifierNode(ctx.QuestionId().getText(), formatLocation(ctx));
    }

    @Override
    public ANode visitAddSub(KLQParser.AddSubContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));
        ANode node;

        if(ctx.operator.getType() == KLQParser.ADD) {
            node = new AddNode(leftChild, rightChild, formatLocation(ctx));
        }
        else{
            node = new SubtractNode(leftChild, rightChild, formatLocation(ctx));
        }
        return node;
    }

    @Override
    public ANode visitMulDiv(KLQParser.MulDivContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));
        ANode node;

        if(ctx.operator.getType() == KLQParser.MUL) {
            node = new MultiplyNode(leftChild, rightChild, formatLocation(ctx));
        }
        else{
            node = new DivideNode(leftChild, rightChild, formatLocation(ctx));
        }
        return node;
    }

    @Override
    public ANode visitComparators(KLQParser.ComparatorsContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));

        switch(ctx.operator.getType()){
            case KLQParser.GT: return new GreaterThanNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.GE: return new GreaterEqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.LT: return new LessThanNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.LE: return new LessEqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.EQ: return new EqualsNode(leftChild, rightChild, formatLocation(ctx));
            case KLQParser.NEQ: return new NotEqualsNode(leftChild, rightChild, formatLocation(ctx));
            default: return null;
        }
    }

    @Override
    public ANode visitOr(KLQParser.OrContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));

        return new OrNode(leftChild, rightChild, formatLocation(ctx));
    }

    @Override
    public ANode visitAnd(KLQParser.AndContext ctx) {
        ANode leftChild = visit(ctx.expr(0));
        ANode rightChild = visit(ctx.expr(1));

        return new AndNode(leftChild, rightChild, formatLocation(ctx));
    }

    @Override
    public ANode visitParens(KLQParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    private String stripQuotes(String s) {
        if ( s==null || s.charAt(0)!='"' ) return s;
        return s.substring(1, s.length() - 1);
    }

    private String formatLocation(ParserRuleContext ctx){
        return String.format("line number: %d", ctx.getStart().getLine());
    }
}