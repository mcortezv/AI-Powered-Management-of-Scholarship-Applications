/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.styles;
import presentacion.CoordinadorAplicacion;
import presentacion.login.MainFrame;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class Panel extends JPanel {
    protected MainFrame mainFrame;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected Button btnBack;

    private CoordinadorAplicacion coordinadorAplicacion;

    public Panel(MainFrame frame, CoordinadorAplicacion coordinadorAplicacion) {
        mainFrame = frame;
        this.coordinadorAplicacion = coordinadorAplicacion;
        btnBack = new Button("Volver");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(1500, 700));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(1500, 100));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        southPanel.setBackground(Style.PANEL_COLOR);
        centralPanel.setBackground(Style.PANEL_COLOR);
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        startComponents();
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);
    }

    public abstract void startComponents();
}