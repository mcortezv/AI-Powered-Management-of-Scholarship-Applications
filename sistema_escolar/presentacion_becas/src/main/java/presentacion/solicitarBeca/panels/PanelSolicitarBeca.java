/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import presentacion.CoordinadorAplicacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Style;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class PanelSolicitarBeca extends JPanel {
    protected SolicitarBeca mainFrame;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected Button btnBack;
    protected CoordinadorAplicacion coordinadorAplicacion;

    public PanelSolicitarBeca(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        mainFrame = frame;
        btnBack = new Button("Volver");
        this.coordinadorAplicacion = coordinadorAplicacion;
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(1500, 750));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(1500, 100));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        centralPanel.setBackground(Style.PANEL_COLOR);
        southPanel.setBackground(Style.PANEL_COLOR);
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);
        btnBack.addActionListener(e -> {

        });
    }

    public abstract void startComponents();
}