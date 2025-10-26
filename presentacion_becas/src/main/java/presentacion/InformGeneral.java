/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import controlNavegacion.ControlNavegacion;
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
import dto.SolicitudBecasDisponiblesDTO;
import javax.swing.JComboBox;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformGeneral extends Panel {
    
    SolicitudBecasDisponiblesDTO solicitudDTO;
    ControlNavegacion control;

    private static final float fontTitulo = 70f;
    private static final float fontLabel = 25f;
    private static final int espacioTitulo = 30;
    private static final int espacioLabelCampo = 20;
    private static final int espacioEntreBloques = 30;
    private static final int espacioFormTop = 100;
    private static final int espacioFormBottom = 100;
    Button botonSiguiente;
    TextField campoPromedio;
    JComboBox<String> campoCarga;
    TextField campoIngreso;
    private static final Dimension dimensionCampo = new Dimension(2000, 60);
    private static final Dimension dimensionCombo= new Dimension(200,40);

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
        agregarAlPanel(panel, lblPromedio, campoPromedio, espacioEntreBloques);
        Label lblCarga = crearLabel("Estás cursando la carga completa?");
        String[] opciones= {"Si", "No"};
        campoCarga= new JComboBox<>(opciones);
        campoCarga.setMaximumSize(dimensionCombo);
        campoCarga.setFont(campoCarga.getFont().deriveFont(fontLabel));
        panel.add(lblCarga);
        panel.add(Box.createVerticalStrut(espacioLabelCampo));
        panel.add(campoCarga);
        panel.add(Box.createVerticalStrut(espacioEntreBloques));
        
        
                
        Label lblIngreso = crearLabel("Cuál es el ingreso mensual total de tu familia?");
        campoIngreso = crearCampo();
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
            Double promedio= Double.parseDouble((campoPromedio.getText()));
            boolean carga;
            if(campoCarga.getSelectedItem().equals("Si")){
                carga= true;
            }
            else{
                carga= false;
            }
            Double ingreso= Double.parseDouble(campoIngreso.getText());
            solicitudDTO= new SolicitudBecasDisponiblesDTO(promedio, carga, ingreso);
           
       
            
        }
        );

    }

}
