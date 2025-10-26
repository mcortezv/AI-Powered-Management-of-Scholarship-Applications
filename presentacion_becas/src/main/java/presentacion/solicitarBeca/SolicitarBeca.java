/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca;
import presentacion.login.panels.HubPanel;
import presentacion.login.panels.ImgPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.panels.InformacionGeneralPanel;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public final class SolicitarBeca extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private ImgPanel mainPanel;
    private InformacionGeneralPanel informacionGeneralPanel;
    public HubPanel hubPanel;



    public SolicitarBeca() {
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel= new NorthPanel();
        centralPanel = new JPanel();

        informacionGeneralPanel = new InformacionGeneralPanel(this, northPanel);
        hubPanel = new HubPanel();

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

        showPanel(informacionGeneralPanel);
        northPanel.setVisible(false);
    }

    public void showPanel(JPanel nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(nuevoPanel, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }

    public void setMenuVisible(boolean visible) {
        northPanel.setVisible(visible);
    }
}
