package org.fugazi.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;

public class TextBox implements IWidget<String> {

    private final String label;

    private JTextField input;
    private JPanel panel;

    public TextBox(String _label) {
        this.label = _label;

        this.panel = new JPanel();
        JLabel label = new JLabel(this.label);
        this.input = new JTextField();

        input.setColumns(7);

        panel.add(label);
        panel.add(input);
    }

    @Override
    public JComponent getJComponent() {
        return this.panel;
    }

    @Override
    public void addItemListener(ItemListener _listener) {
        throw new AssertionError();
    }

    @Override
    public void addDocumentListener(DocumentListener _listener) {
        this.input.getDocument().addDocumentListener(_listener);
    }

    @Override
    public String getValue() {
        return this.input.getText();
    }

    @Override
    public void setValue(String _value) {
        this.input.setText(_value);
    }
}