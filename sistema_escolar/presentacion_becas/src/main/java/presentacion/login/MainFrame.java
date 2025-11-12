/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.login;
import controlLogin.ControlLogin;
import controlNavegacion.ControlNavegacion;
import presentacion.login.panels.HubPanel;
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
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private Button btnSolicitarBeca;
    private Button btnEvaluarSolicitudes;
    private Button btnApelacion;
    private Button btnPagoAdeudo;
    private Button btnExtracurriculares;
    private Button btnTutorias;
    private Button btnCarteras;
    private Map<String, JPanel> panels;
    private ControlNavegacion controlNavegacion;
    
    
    public MainFrame(ControlNavegacion controlNavegacion) {
        setTitle("Sistema de Aplicaciones Escolares");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        centralPanel = new JPanel();
        this.controlNavegacion = controlNavegacion;

        btnSolicitarBeca = new Button("Solicitar Beca");
        btnEvaluarSolicitudes = new Button("Evaluar Solicitudes");
        btnApelacion = new Button("Apelacion");
        btnPagoAdeudo = new Button("Pago Adeudo");
        btnExtracurriculares = new Button("Extracurriculares");
        btnTutorias = new Button("Tutorias");
        btnCarteras = new Button("Carteras");

        northPanel.add(btnSolicitarBeca);
        northPanel.add(btnEvaluarSolicitudes);
        northPanel.add(btnApelacion);
        northPanel.add(btnPagoAdeudo);
        northPanel.add(btnExtracurriculares);
        northPanel.add(btnTutorias);
        northPanel.add(btnCarteras);

        panels = new HashMap<String, JPanel>();
        panels.put("iniciarSesionPanel", new IniciarSesionPanel(this, controlNavegacion,new ControlLogin()));
        panels.put("hubPanel", new HubPanel(this, controlNavegacion));

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        northPanel.setVisible(false);
        showPanel("iniciarSesionPanel");

        btnSolicitarBeca.addActionListener(e -> {
            controlNavegacion.solicitarBeca();
        });
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
