package nl.uva.se.ql.gui.widgets.boxes;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.gui.builders.QuestionBuilder;

public class QuestionBox extends VBox {
	
	private final Question question;

	public QuestionBox(Question question) {
		this.question = question;
		addQuestion(question);
	}

	public void addQuestion(Question question) {		
		//Add label to the QuestionBox
		Label title = new Label(question.getLabel());
		this.getChildren().add(title);
		
		//Add the widget to the QuestionBox
		Node widget = question.getType().accept(new QuestionBuilder(question));
		this.getChildren().add(widget);
	}
	
	public Question getQuestion(){
		return this.question;
	}	
}