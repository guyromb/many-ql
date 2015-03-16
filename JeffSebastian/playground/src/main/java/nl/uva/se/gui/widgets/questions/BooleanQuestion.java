package nl.uva.se.gui.widgets.questions;

import nl.uva.se.gui.listeners.Listener;
import nl.uva.se.gui.validators.BooleanValidator;
import nl.uva.se.ql.ast.statement.Question;
import javafx.scene.control.CheckBox;

public class BooleanQuestion extends CheckBox implements BaseQuestion<Boolean>{

	private final Question question;
	private final BooleanValidator validator;
	private final Listener<Boolean> listener;

	public BooleanQuestion(Question question) {
		super();
		this.question = question;
		this.validator = new BooleanValidator();
		this.listener = new Listener<Boolean>();		
		this.selectedProperty().addListener(listener.addListener(this, validator));
	}

	public Question getQuestion() {
		return this.question;
	}

	public BooleanValidator getValidator() {
		return this.validator;
	}

	public void undoChange(Boolean oldValue) {
		//TODO: FIX BUG THAT LOCKS THE CHECKBOX
		//this.setSelected(oldValue);		
	}
	
	public void reset() {
		this.setSelected(false);		
	}
}
