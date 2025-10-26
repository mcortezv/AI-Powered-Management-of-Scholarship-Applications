/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;
import java.awt.BorderLayout;
import javax.swing.*;

import presentacion.panels.*;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private MainPanel mainPanel;
    private InformGeneral panelInformGeneral;
    private FrmHistorialAcademico frmHistorialAcademico;
    private Confirmacion confirmacion;
    
    
    public MainFrame() {
        setTitle("Sistema de Aplicaciones Escolares");
        setSize(1700,956);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        northPanel= new NorthPanel();
        centralPanel = new JPanel();

        mainPanel = new MainPanel();
        panelInformGeneral = new InformGeneral(this, northPanel);
        frmHistorialAcademico= new FrmHistorialAcademico(this, northPanel);
        confirmacion= new Confirmacion(this, northPanel);


        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        showPanel(panelInformGeneral);
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
