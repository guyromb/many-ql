package gui.widgets.listeners;

import gui.widgets.IWidgetComponent;

public abstract class AListener {
	protected final IWidgetComponent widget;
	protected final EvaluateExpression evaluator;
	
	public AListener(IWidgetComponent widget, EvaluateExpression evaluator) { 
		this.widget = widget;
		this.evaluator = evaluator;
	}
	
	public void update() {
		evaluator.setValue(widget.getIdWidget().toString(), widget.getValue());	
		evaluator.setValueInGUI();	
	}
}
