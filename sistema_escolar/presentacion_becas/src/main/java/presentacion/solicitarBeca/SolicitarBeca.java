package presentacion.solicitarBeca;
import solicitarBeca.BecaDTO;
import presentacion.CoordinadorAplicacion;
import presentacion.styles.ImgPanel;
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
    private CoordinadorAplicacion coordinadorAplicacion;
    private BecaDTO becaDTO;

    public SolicitarBeca(CoordinadorAplicacion coordinadorAplicacion, BecaDTO becaDTO) {
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        centralPanel = new JPanel();
        this.coordinadorAplicacion = coordinadorAplicacion;
        this.becaDTO= becaDTO;
        panels = new HashMap<>();
        initializePanels();
        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        northPanel.setVisible(false);
        showPanel("informacionGeneralPanel");
    }

    private void initializePanels() {
        PanelSolicitarBeca panel;

        panel = new InformacionGeneralPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("informacionGeneralPanel", panel);

        panel = new ListadoBecasDisponiblesPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("listadoBecasDisponiblesPanel", panel);

        panel = new DetallesBecaPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("detalleBecaPanel", panel);

        panel = new DatosDelSolicitantePanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("datosDelSolicitantePanel", panel);

        panel = new HistorialAcademicoPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("historialAcademicoPanel", panel);

        panel = new DatosTutorPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("datosTutorPanel", panel);

        panel = new InformacionSocioeconomicaPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("informacionSocioeconomicaPanel", panel);

        panel = new SubirDocumentosPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("subirDocumentosPanel", panel);

        panel = new ResumenFinalPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("resumenFinalPanel", panel);

        panel = new ConfirmacionPanel(this, coordinadorAplicacion);
        panel.startComponents();
        panels.put("confirmacionPanel", panel);
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




