package nl.uva.se.gui.widgets.questions;

import javafx.scene.control.TextField;
import nl.uva.se.gui.listeners.Listener;
import nl.uva.se.gui.validators.DecimalValidator;
import nl.uva.se.ql.ast.statement.Question;

public class DecimalQuestion extends TextField implements BaseQuestion<String> {
	private final Question question;
	private final DecimalValidator validator;
	private final Listener<String> listener;

	public DecimalQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new DecimalValidator();
		this.listener = new Listener<String>();
		this.textProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public DecimalValidator getValidator() {
		return this.validator;
	}

	@Override
	public void undoChange(String oldValue) {
		
		this.setText(oldValue);
	}

	@Override
	public void reset() {
		this.setText("");
	}
}
