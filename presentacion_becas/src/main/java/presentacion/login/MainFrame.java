/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.login;

import presentacion.login.panels.HubPanel;
import presentacion.login.panels.IniciarSesionPanel;
import presentacion.login.panels.ImgPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;

import javax.swing.*;
import java.awt.*;

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
    private ImgPanel mainPanel;
    private IniciarSesionPanel iniciarSesionPanel;
    public HubPanel hubPanel;

    
    
    public MainFrame() {
        setTitle("Sistema de Aplicaciones Escolares");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel= new NorthPanel();
        centralPanel = new JPanel();

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

        iniciarSesionPanel = new IniciarSesionPanel(this, northPanel);
        hubPanel = new HubPanel();

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

        showPanel(iniciarSesionPanel);
        northPanel.setVisible(false);

        btnSolicitarBeca.addActionListener(e -> {
            this.setVisible(false);
            new SolicitarBeca().setVisible(true);
        });
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
