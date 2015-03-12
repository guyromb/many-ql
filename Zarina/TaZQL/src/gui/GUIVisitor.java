package gui;

import evaluator.ValueRepository;
import gui.questions.ComputedQuestionUI;
import gui.questions.IQuestionUI;
import gui.questions.IfQuestionUI;
import gui.questions.SimpleQuestionUI;
import gui.widgets.IWidgetComponent;
import gui.widgets.WidgetVisitor;
import gui.widgets.listeners.Updater;

import javax.swing.JLabel;

import ast.expression.Expression;
import ast.question.ComputationQuestion;
import ast.question.IQuestionVisitor;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;

public class GUIVisitor implements IQuestionVisitor<IQuestionUI>{
	private final GUIRender gui;
	private final ValueRepository valueRepository;
	
	public GUIVisitor(GUIRender gui, ValueRepository valueRepository) {
		this.gui = gui;
		this.valueRepository = valueRepository;
	} 
	

	public IWidgetComponent widget(SimpleQuestion simpleQuestion) {
		return simpleQuestion.getQuestionType().accept(
				new WidgetVisitor( 
						simpleQuestion.getQuestionId().getID(), 
						simpleQuestion.getQuestionText(), 
						simpleQuestion.getQuestionType(), 
						this.valueRepository
				)
		);
		
	}
	
	public Updater sendToUpdater(Expression expression) {
		return new Updater(expression, gui, valueRepository);
	}
	
	@Override
	public IQuestionUI visit(Question question) {
		return null;
	}
	

	@Override
	public IQuestionUI visit(SimpleQuestion simpleQuestion) {
		SimpleQuestionUI sq = new SimpleQuestionUI(simpleQuestion.getQuestionId().getID(),
												   new JLabel(simpleQuestion.getQuestionText()), 
												   this.widget(simpleQuestion));
		
		gui.putWidgetRepository(simpleQuestion.getQuestionId().getID(), sq);
		return sq;
	}

	@Override
	public IQuestionUI visit(ComputationQuestion calQuestion) {
		ComputedQuestionUI sq = new ComputedQuestionUI(calQuestion.getQuestionId().getID(),
													new JLabel(calQuestion.getQuestionText()), 
													this.widget(calQuestion),
													this.valueRepository,
													this.sendToUpdater(calQuestion.getExpression()));
		
		gui.putWidgetRepository(calQuestion.getQuestionId().getID(), sq);
		sq.updateGUI();
		return sq;
	}
	
	@Override
	public IQuestionUI visit(IfStatement ifStatement) {
		IfQuestionUI ifq = new IfQuestionUI(this.sendToUpdater(ifStatement.getExpression()));
	
			for(Question q : ifStatement.getIfStatement()) {
				ifq.showIfBody(q.accept(this));
			}
			
		ifq.updateGUI();
		return ifq;
	}

	@Override
	public IQuestionUI visit(IfElseStatement ifElseStatement) {
//		System.out.println("visited "+q.getClass());
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
