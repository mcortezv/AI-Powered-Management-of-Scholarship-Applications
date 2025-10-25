/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentacion.panels.NorthPanel;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.TextField;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformGeneral extends Panel {

    private static final float fontTitulo = 70f;
    private static final float fontLabel = 25f;
    private static final int espacioTitulo = 30;
    private static final int espacioLabelCampo = 20;
    private static final int espacioEntreBloques = 30;
    private static final int espacioFormTop = 100;
    private static final int espacioFormBottom = 100;
    Button botonSiguiente;
    TextField campoPromedio;
    TextField campoCarga;
    TextField campoIngreso;
    private static final Dimension dimensionCampo = new Dimension(2000, 60);

    public InformGeneral(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    public void startComponents() {
        central();
        south();
    }

    private void central() {

        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        Label lblTitulo = new Label("Informacion General");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, fontTitulo));

        centralPanel.add(lblTitulo);
        centralPanel.add(Box.createVerticalStrut(espacioTitulo));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Label lblPromedio = crearLabel("Qué promedio llevas actualmente?");
        campoPromedio = crearCampo();
        Label lblCarga = crearLabel("Estás cursando la carga completa?");
        campoCarga = crearCampo();
        Label lblIngreso = crearLabel("Cuál es el ingreso mensual total de tu familia?");
        campoIngreso = crearCampo();

        agregarAlPanel(panel, lblPromedio, campoPromedio, espacioEntreBloques);
        agregarAlPanel(panel, lblCarga, campoCarga, espacioEntreBloques);
        agregarAlPanel(panel, lblIngreso, campoIngreso, espacioFormBottom);
        panel.setOpaque(false);
        centralPanel.add(Box.createVerticalStrut(espacioFormTop));
        centralPanel.add(panel);

    }

    private Label crearLabel(String texto) {
        Label label = new Label(texto);
        label.setFont(label.getFont().deriveFont(fontLabel));
        return label;
    }

    private TextField crearCampo() {
        TextField campoTexto = new TextField(1);
        campoTexto.setMaximumSize(dimensionCampo);
        campoTexto.setCaretColor(Color.BLACK);
        return campoTexto;
    }

    private void agregarAlPanel(JPanel panel, Label label, TextField textField, int espacio) {
        panel.add(label);
        panel.add(Box.createVerticalStrut(espacioLabelCampo));
        panel.add(textField);
        panel.add(Box.createVerticalStrut(espacio));
    }

    private void south() {
        botonSiguiente = new Button("Aceptar");
        southPanel.add(botonSiguiente);
    }

    private void events() {
        botonSiguiente.addActionListener(e ->{
            String promedio= campoPromedio.getText();
            String carga= campoCarga.getText();
            String ingreso= campoIngreso.getText();
            
        }
        );

    }

}
