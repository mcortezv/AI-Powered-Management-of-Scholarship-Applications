/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.panels;
import controlNavegacion.ControlNavegacion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.Box;
import presentacion.MainFrame;
import presentacion.styles.*;
import dto.SolicitudBecasDisponiblesDTO;
import presentacion.styles.ComboBox;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformGeneral extends Panel {
    private SolicitudBecasDisponiblesDTO solicitudDTO;
    private ControlNavegacion control;
    private static final float fontTitulo = 70f;
    private static final float fontLabel = 25f;
    private static final int espacioTitulo = 30;
    private static final int espacioLabelCampo = 20;
    private static final int espacioEntreBloques = 30;
    private static final int espacioFormTop = 100;
    private static final int espacioFormBottom = 50;
    private Button botonSiguiente;
    private TextField campoPromedio;
    private ComboBox<String> campoCarga;
    private TextField campoIngreso;
    private static final Dimension dimensionCampo = new Dimension(700, 60);
    private static final Dimension dimensionCombo = new Dimension(200, 40);


    public InformGeneral(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    public void startComponents() {
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.add(Box.createVerticalStrut(espacioFormBottom));

        Label lblTitulo = new Label("Informacion General");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, fontTitulo));
        centralPanel.add(lblTitulo);
        centralPanel.add(Box.createVerticalStrut(espacioFormTop));

        Label lblPromedio = crearLabel("Qué promedio llevas actualmente?");
        lblPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoPromedio = new TextField(1);
        campoPromedio.setMaximumSize(dimensionCampo);
        campoPromedio.setCaretColor(Color.BLACK);
        campoPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPromedio);
        centralPanel.add(Box.createVerticalStrut(espacioEntreBloques));
        centralPanel.add(campoPromedio);
        centralPanel.add(Box.createVerticalStrut(espacioEntreBloques));


        Label lblCarga = crearLabel("Estás cursando la carga completa?");
        lblCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] opciones = {"Si", "No"};
        campoCarga = new ComboBox<>(opciones);
        campoCarga.setMaximumSize(dimensionCombo);
        campoCarga.setFont(campoCarga.getFont().deriveFont(fontLabel));
        centralPanel.add(lblCarga);
        centralPanel.add(Box.createVerticalStrut(espacioLabelCampo));
        centralPanel.add(campoCarga);
        centralPanel.add(Box.createVerticalStrut(espacioEntreBloques));

        Label lblIngreso = crearLabel("Cuál es el ingreso mensual total de tu familia?");
        campoIngreso = new TextField(1);
        campoIngreso.setMaximumSize(dimensionCampo);
        campoIngreso.setCaretColor(Color.BLACK);
        lblIngreso.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblIngreso);
        centralPanel.add(Box.createVerticalStrut(espacioLabelCampo));
        centralPanel.add(campoIngreso);
        centralPanel.add(Box.createVerticalStrut(espacioEntreBloques));

        botonSiguiente = new Button("Aceptar");
        botonSiguiente.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(botonSiguiente);
        centralPanel.setOpaque(false);
        centralPanel.add(Box.createVerticalStrut(espacioFormBottom));

    }

    private Label crearLabel(String texto) {
        Label label = new Label(texto);
        label.setFont(label.getFont().deriveFont(fontLabel));
        return label;
    }

    private void events() {
        botonSiguiente.addActionListener(e -> {
                Double promedio = Double.parseDouble((campoPromedio.getText()));
                boolean carga;
                if (campoCarga.getSelectedItem().equals("Si")) {
                    carga = true;
                } else {
                    carga = false;
                }
                Double ingreso = Double.parseDouble(campoIngreso.getText());
                solicitudDTO = new SolicitudBecasDisponiblesDTO(promedio, carga, ingreso);
            }
        );
    }
}
