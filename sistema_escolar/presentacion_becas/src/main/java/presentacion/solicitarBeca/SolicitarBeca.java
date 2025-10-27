/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca;
import dto.BecaDTO;
import presentacion.login.panels.HubPanel;
import presentacion.login.panels.ImgPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.panels.InformacionGeneralPanel;

import javax.swing.*;
import java.awt.*;
import presentacion.solicitarBeca.panels.DetalleBeca;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;

/**
 *
 * @author Cortez, Manuel;
 */
public final class SolicitarBeca extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private ImgPanel mainPanel;
    private InformacionGeneralPanel informacionGeneralPanel;
    private ListadoBecasDisponiblesPanel becasDisponiblesPanel;
    private BecaDTO becaSeleccionada;
    private DetalleBeca detalleBeca;
    public HubPanel hubPanel;



    public SolicitarBeca() {
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel= new NorthPanel();
        centralPanel = new JPanel(new BorderLayout());

        informacionGeneralPanel = new InformacionGeneralPanel(this, northPanel);
        becasDisponiblesPanel = new ListadoBecasDisponiblesPanel(this, northPanel);
        hubPanel = new HubPanel();
        detalleBeca = new DetalleBeca(this, northPanel);

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
    
    public void showBecasDisponibles(java.util.List<BecaDTO> becas) {
        becasDisponiblesPanel.setBecas(becas);
        showPanel(becasDisponiblesPanel);
        northPanel.setVisible(true);
    }
    
    public void setBecaSeleccionada(BecaDTO beca) { 
        this.becaSeleccionada = beca;
    }
    
    public BecaDTO getBecaSeleccionada(){
        return becaSeleccionada;
    }
    
    public void mostrarDetalleBeca(BecaDTO beca){
        
        
        
        
        // ESTO ES NOMAS PARA Q CORRA, YA QUE ESTE LA DE DETALLES BECA SE
        // DEBE DE QUITAR ESTO 
        JOptionPane.showMessageDialog(this,
                "Seleccionaste: " + (beca != null ? beca.getNombre() : "(sin beca)"),
                "Beca seleccionada",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showSiguiente() {
        mostrarDetalleBeca(getBecaSeleccionada());
        showPanel(detalleBeca);
    }
}
