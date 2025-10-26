package presentacion.styles;
import javax.swing.*;

public class ComboBox<T> extends JComboBox<T> {

    public ComboBox(T[] items) {
        super(items);
        setBackground(Style.INPUT_COLOR);
        setFont(Style.LABEL_FONT);

    }
}
