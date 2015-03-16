package gui.widget.input;

import gui.widget.InputWidget;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import ql.value.StringValue;

public class TextArea extends InputWidget<StringValue> implements CaretListener {	
	protected JTextArea textArea;
	
	public TextArea() {
		textArea = new JTextArea();
    	textArea.addCaretListener(this);
    	textArea.setFocusable(true);
	}
	
	public TextArea (StringValue stringValue) {
		this();		
    	textArea.setText(stringValue.getValue());	
	}
	
	@Override
	public void disable() {
		textArea.setEditable(false);
	}

	@Override
	public StringValue getValue() {
		return new StringValue(textArea.getText());
	}
	
	public void appendValue(StringValue value) {
		textArea.append(value.getValue());
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	@Override
	public void setValue(StringValue value) {
		textArea.setText(value.getValue());		
	}

	@Override
	public void updateComponent() {
		textArea.revalidate();
		textArea.repaint();
	}
	
	@Override
	public JComponent getComponent() {
		return textArea;
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		handleChange(getValue(), this);
	}
}