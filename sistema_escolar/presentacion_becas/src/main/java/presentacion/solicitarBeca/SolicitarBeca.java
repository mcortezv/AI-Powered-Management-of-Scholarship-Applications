/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca;
import controlNavegacion.ControlNavegacion;
import dto.BecaDTO;
import presentacion.login.panels.ImgPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.panels.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cortez, Manuel;
 */
public final class SolicitarBeca extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private ImgPanel mainPanel;
    private Map<String, JPanel> panels;
    private ControlNavegacion controlNavegacion;
    private BecaDTO becaDTO;

    public SolicitarBeca(ControlNavegacion controlNavegacion, BecaDTO becaDTO) {
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        centralPanel = new JPanel();
        this.controlNavegacion = controlNavegacion;
        this.becaDTO= becaDTO;

        panels = new HashMap<String, JPanel>();
        panels.put("informacionGeneralPanel", new InformacionGeneralPanel(this, controlNavegacion));
        panels.put("listadoBecasDisponiblesPanel", new ListadoBecasDisponiblesPanel(this, controlNavegacion));
        panels.put("detalleBecaPanel", new DetallesBecaPanel(this, controlNavegacion));
        panels.put("datosDelSolicitantePanel", new DatosDelSolicitantePanel(this, controlNavegacion));
        panels.put("historialAcademicoPanel", new HistorialAcademicoPanel(this, controlNavegacion));
        panels.put("datosTutorPanel", new DatosTutorPanel(this, controlNavegacion));
        panels.put("informacionSocioeconomicaPanel", new InformacionSocioeconomicaPanel(this, controlNavegacion));
        panels.put("subirDocumentosPanel", new SubirDocumentosPanel(this, controlNavegacion));
        panels.put("resumenFinalPanel", new ResumenFinalPanel(this, controlNavegacion));
        panels.put("confirmacionPanel", new ConfirmacionPanel(this, controlNavegacion));

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
            northPanel.setVisible(false);
        showPanel("informacionGeneralPanel");

    }

    public void showPanel(String nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(panels.get(nuevoPanel), BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public NorthPanel getNorthPanel() {
        return northPanel;
    }
    
    public JPanel getPanel(String key){
        return panels.get(key);
    }
}




