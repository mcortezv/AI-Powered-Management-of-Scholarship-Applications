/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.styles;
import controlNavegacion.ControlNavegacion;
import presentacion.login.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class Panel extends JPanel {
    protected MainFrame mainFrame;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected Button btnBack;
    protected Button btnLogOut;
    private ControlNavegacion controlNavegacion;

    public Panel(MainFrame frame, ControlNavegacion controlNavegacion) {
        mainFrame = frame;
        this.controlNavegacion = controlNavegacion;
        btnBack = new Button("Volver");
        btnLogOut = new Button("Cerrar Sesión");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(1500, 700));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(1500, 100));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        centralPanel.setBackground(Style.PANEL_COLOR);
        southPanel.setBackground(Style.PANEL_COLOR);
        startComponents();
        southPanel.add(btnLogOut);
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);
    }

    public abstract void startComponents();
}