package presentacion.login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import presentacion.CoordinadorAplicacion;
import presentacion.login.panels.HubPanel;
import presentacion.styles.ImgPanel;
import presentacion.login.panels.IniciarSesionPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.styles.Button;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private static final Logger log = LoggerFactory.getLogger(MainFrame.class);
    private final NorthPanel northPanel;
    private final JPanel centralPanel;
    private Button btnSolicitarBeca;
    private Button btnApelacion;
    private Button btnPagoAdeudo;
    private Button btnExtracurriculares;
    private Button btnTutorias;
    private ImgPanel logo;
    private final Map<String, JPanel> panels;
    private CoordinadorAplicacion coordinadorAplicacion;

    public MainFrame(CoordinadorAplicacion coordinadorAplicacion) {
        setTitle("Sistema de Aplicaciones Escolares");
        setResizable(false);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        this.coordinadorAplicacion = coordinadorAplicacion;
        northPanel = new NorthPanel();
        logo = new ImgPanel("/assets/logo.png");
        logo.setPreferredSize(new Dimension(135, 50));
        btnSolicitarBeca = new Button("Solicitar Beca");
        btnApelacion = new Button("Apelacion");
        btnPagoAdeudo = new Button("Pago Adeudo");
        btnExtracurriculares = new Button("Extracurriculares");
        btnTutorias = new Button("Tutorias");
        northPanel.add(logo);
        northPanel.add(Box.createHorizontalStrut(40));
        northPanel.add(btnSolicitarBeca);
        northPanel.add(btnApelacion);
        northPanel.add(btnPagoAdeudo);
        northPanel.add(btnExtracurriculares);
        northPanel.add(btnTutorias);
        centralPanel = new JPanel(new BorderLayout());
        panels = new HashMap<>();
        panels.put("iniciarSesionPanel", new IniciarSesionPanel(this, coordinadorAplicacion));
        panels.put("hubPanel", new HubPanel(this, coordinadorAplicacion));
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centralPanel, BorderLayout.CENTER);
        northPanel.setVisible(false);
        showPanel("iniciarSesionPanel");
        btnSolicitarBeca.addActionListener(e -> coordinadorAplicacion.solicitarBeca());
        btnPagoAdeudo.addActionListener(e -> coordinadorAplicacion.pagarAdeudo());
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


}
