package presentacion.solicitarBeca;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
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

        panels = new HashMap<String, JPanel>();
        panels.put("informacionGeneralPanel", new InformacionGeneralPanel(this, coordinadorAplicacion));
        panels.put("listadoBecasDisponiblesPanel", new ListadoBecasDisponiblesPanel(this, coordinadorAplicacion));
        panels.put("detalleBecaPanel", new DetallesBecaPanel(this, coordinadorAplicacion));
        panels.put("datosDelSolicitantePanel", new DatosDelSolicitantePanel(this, coordinadorAplicacion));
        panels.put("historialAcademicoPanel", new HistorialAcademicoPanel(this, coordinadorAplicacion));
        panels.put("datosTutorPanel", new DatosTutorPanel(this, coordinadorAplicacion));
        panels.put("informacionSocioeconomicaPanel", new InformacionSocioeconomicaPanel(this, coordinadorAplicacion));
        panels.put("subirDocumentosPanel", new SubirDocumentosPanel(this, coordinadorAplicacion));
        panels.put("resumenFinalPanel", new ResumenFinalPanel(this, coordinadorAplicacion));
        panels.put("confirmacionPanel", new ConfirmacionPanel(this, coordinadorAplicacion));

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




