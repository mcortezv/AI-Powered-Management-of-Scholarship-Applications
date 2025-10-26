/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;
import java.awt.BorderLayout;
import javax.swing.*;

import presentacion.panels.*;
import presentacion.panels.uitls.Img;
import presentacion.panels.uitls.NorthPanel;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private Img mainPanel;
    private IniciarSesionPanel iniciarSesionPanel;
    private InformacionGeneralPanel informacionGeneralPanel;
    private HistorialAcademicoPanel historialAcademicoPanel;
    private ConfirmacionPanel confirmacionPanel;
    
    
    public MainFrame() {
        setTitle("Sistema de Aplicaciones Escolares");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel= new NorthPanel();
        centralPanel = new JPanel();


        informacionGeneralPanel = new InformacionGeneralPanel(this, northPanel);
        historialAcademicoPanel= new HistorialAcademicoPanel(this, northPanel);
        confirmacionPanel= new ConfirmacionPanel(this, northPanel);
        iniciarSesionPanel = new IniciarSesionPanel(this, northPanel);

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

        showPanel(iniciarSesionPanel);
    }

    private void showPanel(JPanel nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(nuevoPanel, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }
}
