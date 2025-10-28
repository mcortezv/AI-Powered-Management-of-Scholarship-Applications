package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import dto.EstudianteSolicitudDTO;
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

    public DatosDelSolicitantePanel(SolicitarBeca mainFrame, ControlNavegacion controlNavegacion) {
        super(mainFrame, controlNavegacion);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        titulo = new Label("Datos del Solicitante");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);


        lbl_nombre = new Label("Nombres:");
        lbl_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_nombre = new TextField(1);
        field_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_nombre);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_nombre);

        lbl_apellidos = new Label("Apellidos:");
        lbl_apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_apellidos = new TextField(1);
        field_apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_apellidos);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_apellidos);


        lbl_direccion = new Label("Dirección:");
        lbl_direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_direccion = new TextField(1);
        field_direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_direccion);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_direccion);


        lbl_telefono = new Label("Teléfono:");
        lbl_telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_telefono = new TextField(1);
        field_telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_telefono);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_telefono);


        lbl_email = new Label("Email:");
        lbl_email.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_email = new TextField(1);
        field_email.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_email);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_email);


        btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("detalleBecaPanel");
        });

        btn_next.addActionListener(e -> {
            if(algunCampoEstaVacio()){
                JOptionPane.showMessageDialog(this, "Favor de seleccionar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            mainFrame.showPanel("historialAcademicoPanel");
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
