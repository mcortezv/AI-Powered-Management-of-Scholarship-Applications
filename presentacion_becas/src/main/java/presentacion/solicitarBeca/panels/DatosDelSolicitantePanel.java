package presentacion.solicitarBeca.panels;

import dto.BecaDTO;
import dto.EstudianteSolicitudDTO;
import dto.InformacionSocioeconomicaDTO;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.TextField;

import javax.swing.*;
import java.awt.*;

/**
 * @author Escalante, Sebastian.
 */
public class DatosDelSolicitantePanel extends PanelSolicitarBeca {
    private Label titulo;

    private Label lbl_nombre;
    private TextField field_nombre;

    private Label lbl_apellidos;
    private TextField field_apellidos;

    private Label lbl_direccion;
    private TextField field_direccion;

    private Label lbl_telefono;
    private TextField field_telefono;

    private Label lbl_email;
    private TextField field_email;

    private Button btn_next;

    public DatosDelSolicitantePanel(SolicitarBeca mainFrame, NorthPanel northPanel) {
        super(mainFrame, northPanel);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        titulo = new Label("Datos del Solicitante");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        lbl_nombre = new Label("Nombres:");
        lbl_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_nombre = new TextField(1);
        field_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_nombre);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_nombre);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_apellidos = new Label("Apellidos:");
        lbl_apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_apellidos = new TextField(1);
        field_apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_apellidos);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_apellidos);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_direccion = new Label("Dirección:");
        lbl_direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_direccion = new TextField(1);
        field_direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_direccion);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_direccion);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_telefono = new Label("Teléfono:");
        lbl_telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_telefono = new TextField(1);
        field_telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_telefono);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_telefono);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_email = new Label("Email:");
        lbl_email.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_email = new TextField(1);
        field_email.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_email);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_email);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btn_next.addActionListener(e -> {
            if(algunCampoEstaVacio()){
                JOptionPane.showMessageDialog(this, "Favor de seleccionar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            EstudianteSolicitudDTO estudianteSolicitudDTO = mainFrame.getEstudianteSolicitudDTO();
            estudianteSolicitudDTO.setNombre(field_nombre.getText().trim());
            estudianteSolicitudDTO.setApellidos(field_apellidos.getText().trim());
            estudianteSolicitudDTO.setDireccion(field_direccion.getText().trim());
            estudianteSolicitudDTO.setTelefono(field_telefono.getText().trim());
            estudianteSolicitudDTO.setEmail(field_email.getText().trim());
            mainFrame.setEstudianteSolicitudDTO(estudianteSolicitudDTO);
            mainFrame.showSiguiente();
        });

    }

    public boolean algunCampoEstaVacio(){
        return field_nombre.getText().trim().isBlank() ||
                field_apellidos.getText().trim().isBlank() ||
                field_direccion.getText().trim().isBlank() ||
                field_telefono.getText().trim().isBlank() ||
                field_email.getText().trim().isBlank();
    }

}
