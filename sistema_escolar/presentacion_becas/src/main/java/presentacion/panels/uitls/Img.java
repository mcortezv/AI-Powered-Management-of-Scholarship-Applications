/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.panels.uitls;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class Img extends JPanel {
    private final Image imagen;

    public Img() {
        setSize(new Dimension(300, 300));
        setMaximumSize(new Dimension(300, 300));
        this.imagen = new ImageIcon("src/main/java/presentacion/assets/check.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}