/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.styles;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class TextField extends JTextField {

    public TextField(int columns) {
        super(columns);
        setFont(Style.INPUT_FONT);
        setBackground(Style.INPUT_COLOR);
        setForeground(Style.TEXT_COLOR);
        setCaretColor(Color.BLACK);
        setCaretColor(Color.WHITE);
        setMaximumSize(new Dimension(700, 60));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(90, 90, 90)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
    }
}