package nl.uva.se.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.arithmetical.Addition;
import nl.uva.se.ast.expression.arithmetical.Divide;
import nl.uva.se.ast.expression.arithmetical.Modulo;
import nl.uva.se.ast.expression.arithmetical.Multiply;
import nl.uva.se.ast.expression.arithmetical.Negative;
import nl.uva.se.ast.expression.arithmetical.Positive;
import nl.uva.se.ast.expression.arithmetical.Power;
import nl.uva.se.ast.expression.arithmetical.Substraction;
import nl.uva.se.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ast.expression.literal.StringLiteral;
import nl.uva.se.ast.expression.logical.And;
import nl.uva.se.ast.expression.logical.Equal;
import nl.uva.se.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ast.expression.logical.GreaterThen;
import nl.uva.se.ast.expression.logical.LessOrEqual;
import nl.uva.se.ast.expression.logical.LessThen;
import nl.uva.se.ast.expression.logical.Not;
import nl.uva.se.ast.expression.logical.NotEqual;
import nl.uva.se.ast.expression.logical.Or;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.statement.Statement;
import nl.uva.se.constant.Operator;
import nl.uva.se.constant.Type;
import nl.uva.se.parser.QLParser.ConditionContext;
import nl.uva.se.parser.QLParser.ExpressionContext;
import nl.uva.se.parser.QLParser.FormContext;
import nl.uva.se.parser.QLParser.LiteralContext;
import nl.uva.se.parser.QLParser.QuestionContext;
import nl.uva.se.parser.QLParser.StatementContext;

public class QLVisitorImpl extends QLBaseVisitor<Node> {

	@Override
	public Node visitForm(FormContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		String id = ctx.Identifier().getText();
		List<StatementContext> contexts = ctx.statement();
		List<Statement> statements = new ArrayList<Statement>();

		for (StatementContext context : contexts) {
			statements.add((Statement) visitStatement(context));
		}

		Form form = new Form(id, lineNumber, offset, statements);
		return form;
	}

	@Override
	public Node visitQuestion(QuestionContext ctx) {
		Type type = Type.getByName(ctx.Type().getText());
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		String id = ctx.Identifier().getText();
		String question = ctx.String().getText();

		if (type == null) {
			throw new IllegalArgumentException("Type " + ctx.Type().getText() + " not supported!");
		}
		
		if (ctx.expression() != null) {
			return new CalculatedQuestion(lineNumber, offset, id, type,
					question, (Expression) visitExpression(ctx.expression()));
		}

		return new Question(lineNumber, offset, id, type, question);
	}

	@Override
	public Node visitCondition(ConditionContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		List<Statement> statements = new ArrayList<Statement>();

		for (StatementContext context : ctx.statement()) {
			statements.add((Statement) visitStatement(context));
		}
		
		return new Condition(lineNumber, offset,
				(Expression) visitExpression(ctx.expression()),
				statements);
	}

	@Override
	public Node visitStatement(StatementContext ctx) {
		if (ctx.question() != null) {
			return visitQuestion(ctx.question());
		}
		return visitCondition(ctx.condition());
	}

	@Override
	public Node visitExpression(ExpressionContext ctx) {
		if (ctx.op == null) {
			return visitLiteral(ctx.singleLtr);
		}
		
		Operator operator = Operator.getByName(ctx.op.getText());
		if (operator == null) {
			throw new IllegalArgumentException("Operator " + ctx.op.getText() + " not supported!");
		}
		
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		
		if (ctx.singleExpr != null) {
			switch (operator) {
				case PLUS:
					return new Positive(lineNumber, offset, (Expression) visitExpression(ctx.singleExpr));
				case MINUS:
					return new Negative(lineNumber, offset, (Expression) visitExpression(ctx.singleExpr));
				default:
					throw new IllegalArgumentException("Unsupported unary operator " + ctx.op.getText());
			}
		}
		
		switch (operator) {
			case AND:
				return new And(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case DIVIDE:
				return new Divide(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case EQUAL:
				return new Equal(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case GREATER_OR_EQUAL:
				return new GreaterOrEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case GREATER_THAN:
				return new GreaterThen(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case LESS_OR_EQUAL:
				return new LessOrEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case LESS_THEN:
				return new LessThen(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case MINUS:
				return new Substraction(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case MODULO:
				return new Modulo(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case MULTIPLY:
				return new Multiply(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case NOT:
				return new Not(lineNumber, offset, (Expression) visitExpression(ctx.singleExpr));
			case NOT_EQUAL:
				return new NotEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case OR:
				return new Or(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case PLUS:
				return new Addition(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case POWER:
				return new Power(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			default:
				throw new IllegalStateException("No matching Operator");
		}
	}

	@Override
	public Node visitLiteral(LiteralContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		
		if (ctx.Boolean() != null) {
			return new BooleanLiteral(lineNumber, offset, ctx.getText());
		}
		
		if (ctx.Decimal() != null) {
			return new DecimalLiteral(lineNumber, offset, ctx.getText());
		}
		
		if (ctx.Integer() != null) {
			return new IntegerLiteral(lineNumber, offset, ctx.getText());
		}
		
		return new StringLiteral(lineNumber, offset, ctx.getText());
	}

}