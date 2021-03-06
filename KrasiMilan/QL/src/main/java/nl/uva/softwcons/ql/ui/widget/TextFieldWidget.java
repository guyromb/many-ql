package nl.uva.softwcons.ql.ui.widget;

import javafx.scene.control.TextField;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;

public class TextFieldWidget extends Widget {
    private final TextField textField;
    private ValueConverter<String> converter;

    public TextFieldWidget() {
        this.textField = new TextField();
    }

    public TextFieldWidget(final ValueConverter<String> converter) {
        this.textField = new TextField();
        this.converter = converter;
    }

    @Override
    public TextField getWidget() {
        return textField;
    }

    @Override
    public void setValue(final Value value) {
        this.textField.setText(converter.fromValue(value));
    }

    @Override
    public void setEditable(final boolean editable) {
        this.textField.setDisable(!editable);
    }

    @Override
    public void addListener(final ValueChangeListener<Value> listener) {
        this.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue));
        });
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void setConverter(final ValueConverter converter) {
        this.converter = converter;
    }

}
