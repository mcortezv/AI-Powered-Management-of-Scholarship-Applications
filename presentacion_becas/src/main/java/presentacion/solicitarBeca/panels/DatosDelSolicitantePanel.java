package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import dto.DatosSolicitanteDTO;
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
    private Label lbl_apellido_materno;
    private Label lbl_apellido_paterno;
    private TextField field_apellido_materno;
    private TextField field_apellido_paterno;
    private Label lbl_direccion;
    private TextField field_direccion;
    private Label lbl_telefono;
    private TextField field_telefono;
    private Label lbl_email;
    private TextField field_email;
    private Button btn_next;
    private ControlNavegacion control;

    public DatosDelSolicitantePanel(SolicitarBeca mainFrame, ControlNavegacion controlNavegacion) {
        super(mainFrame, controlNavegacion);
        this.control= controlNavegacion;
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

        lbl_apellido_materno = new Label("Apellido Materno:");
        lbl_apellido_materno.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_apellido_materno = new TextField(1);
        field_apellido_materno.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_apellido_materno);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_apellido_materno);
        
        
        lbl_apellido_paterno = new Label("Apellido Paterno:");
        lbl_apellido_paterno.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_apellido_paterno= new TextField(1);
        field_apellido_paterno.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_apellido_paterno);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_apellido_paterno);
       

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
            String nombre= field_nombre.getText();
            String apellidoMaterno= field_apellido_materno.getText();
            String apellidoPaterno= field_apellido_paterno.getText();
            String direccion= field_direccion.getText();
            String telefono= field_telefono.getText();
            String email= field_email.getText();
            DatosSolicitanteDTO datosSolicitanteDTO= new DatosSolicitanteDTO(nombre, apellidoMaterno, apellidoPaterno, direccion, telefono, email);
            control.setDatosSolicitanteDTO(datosSolicitanteDTO);
            mainFrame.showPanel("historialAcademicoPanel");
        });

    }

    public boolean algunCampoEstaVacio(){
        return field_nombre.getText().trim().isBlank() ||
                field_apellido_materno.getText().trim().isBlank() ||
                field_direccion.getText().trim().isBlank() ||
                field_telefono.getText().trim().isBlank() ||
                field_email.getText().trim().isBlank();
    }
    
     

}
