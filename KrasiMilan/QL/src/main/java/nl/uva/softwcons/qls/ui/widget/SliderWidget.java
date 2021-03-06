package nl.uva.softwcons.qls.ui.widget;

import static nl.uva.softwcons.ql.eval.value.UndefinedValue.UNDEFINED;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import nl.uva.softwcons.ql.eval.ValueChangeListener;
import nl.uva.softwcons.ql.eval.value.Value;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class SliderWidget extends Widget {
    private final Slider slider;

    private ValueConverter<Number> converter;

    public SliderWidget(final double start, final double end, final double step) {
        this.slider = new Slider(start, end, start);
        slider.setBlockIncrement(step);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMinorTickCount(1);
        slider.setMajorTickUnit(1f);
        slider.setSnapToTicks(true);
    }

    public SliderWidget(final double start, final double end, final double step, final ValueConverter<Number> converter) {
        this(start, end, step);
        this.converter = converter;
    }

    @Override
    public void addListener(final ValueChangeListener<Value> listener) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            listener.processValueChange(converter.toValue(newValue));
        });
    }

    @Override
    public void setValue(final Value value) {
        if (value == UNDEFINED) {
            slider.setValue(slider.minProperty().get());
            return;
        }

        slider.setValue(value.getNumber().doubleValue());
    }

    @Override
    public void setEditable(final boolean editable) {
        this.slider.setDisable(!editable);
    }

    @Override
    public Node getWidget() {
        return slider;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setConverter(final ValueConverter converter) {
        this.converter = converter;
    }

}
