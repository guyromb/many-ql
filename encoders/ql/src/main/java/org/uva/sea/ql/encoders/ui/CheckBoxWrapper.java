package org.uva.sea.ql.encoders.ui;

import java.beans.PropertyChangeEvent;

import javafx.scene.control.CheckBox;

public class CheckBoxWrapper extends CheckBox implements ControlWrapper {

	private final CheckBox checkBox;

	public CheckBoxWrapper(CheckBox checkBox) {
		this.checkBox = checkBox;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		checkBox.setSelected((boolean) evt.getNewValue());
	}

	@Override
	public CheckBox getControl() {
		return checkBox;
	}
}
