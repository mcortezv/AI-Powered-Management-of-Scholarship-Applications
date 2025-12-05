package presentacion.solicitarBeca;
import solicitarBeca.BecaDTO;
import presentacion.CoordinadorAplicacion;
import presentacion.styles.ImgPanel;
import presentacion.solicitarBeca.panels.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Cortez, Manuel;
 */
public final class SolicitarBeca extends JFrame {
    private JPanel centralPanel;
    private Stack<String> history = new Stack<>();

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
        centralPanel = new JPanel(new BorderLayout());
        this.coordinadorAplicacion = coordinadorAplicacion;
        this.becaDTO= becaDTO;
        panels = new HashMap<>();
        initializePanels();
        add(centralPanel, BorderLayout.CENTER);
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
        if (centralPanel.getComponentCount() > 0) {
            String actual = centralPanel.getComponent(0).getName();
            if (actual != null) history.push(actual);
        }

        centralPanel.removeAll();

        JPanel p = panels.get(nuevoPanel);
        p.setName(nuevoPanel);
        centralPanel.add(p, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    void goBack() {
        if (!history.isEmpty()) {
            String prev = history.pop();
            showPanel(prev);
        }
    }



    public JPanel getPanel(String key){
        return panels.get(key);
    }
}




