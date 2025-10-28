package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.TextField;
import javax.swing.*;
import java.awt.*;

public class DatosTutorPanel extends PanelSolicitarBeca {
    private Label titulo;
    private Label lbl_responsable;
    private ComboBox<String> comboResponsable;
    private Label lbl_nombre;
    private TextField field_nombre;
    private Label lbl_apellidos;
    private TextField field_apellidos;
    private Label lbl_telefono;
    private TextField field_telefono;
    private Label lbl_email;
    private TextField field_email;
    private Button btnContinuar;

    public DatosTutorPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        titulo = new Label("Datos del Tutor");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);

        lbl_responsable = new Label("Que carrera estas cursando?");
        lbl_responsable.setFont(Style.LABEL_FONT);
        lbl_responsable.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_responsable);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] responsable = new String[]{"PADRE", "MADRE", "ABUELO/A","HERMANO/A","TIO", "TIA", "PADRASTRO/A","TUTOR_OFICIAL"};
        comboResponsable = new ComboBox<>(responsable);
        comboResponsable.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(comboResponsable);

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
        btnContinuar = new Button("Continuar");
        centralPanel.add(btnContinuar, BorderLayout.CENTER);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("historialAcademicoPanel");
        });

        btnContinuar.addActionListener(e -> {
            mainFrame.showPanel("informacionSocioeconomicaPanel");
        });
    }
}