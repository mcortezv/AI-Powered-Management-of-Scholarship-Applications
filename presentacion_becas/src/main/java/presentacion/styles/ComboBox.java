package presentacion.styles;
import javax.swing.*;
import java.awt.*;

public class ComboBox<T> extends JComboBox<T> {

    public ComboBox(T[] items) {
        super(items);
        setBackground(Style.INPUT_COLOR);
        setFont(Style.LABEL_FONT);
        setMaximumSize(new Dimension(200, 40));
    }
}
