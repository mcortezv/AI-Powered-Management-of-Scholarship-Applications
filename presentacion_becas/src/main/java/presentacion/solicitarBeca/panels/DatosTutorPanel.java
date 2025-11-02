package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import dto.TutorDTO;
import enums.Parentesco;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.TextField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DatosTutorPanel extends PanelSolicitarBeca {
    private Label lbl_responsable;
    private TextField field_nombre;
    private TextField field_telefono;
    private TextField field_email;
    private Button btnContinuar;
    private TextField field_apellido_materno;
    private TextField field_apellido_paterno;
    private ComboBox<Parentesco> comboParentesco;
    private ControlNavegacion controlNavegacion;


    public DatosTutorPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
        this.controlNavegacion= controlNavegacion;
    }

    private JPanel crearDosColumnas(String labelText, TextField field) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.setBackground(Style.PANEL_COLOR);

        Label label = new Label(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        field.setColumns(20);

        Dimension maxDim = new Dimension(Integer.MAX_VALUE, field.getPreferredSize().height);
        field.setMaximumSize(maxDim);

        panel.add(label, BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);

        panel.setMaximumSize(new Dimension(500, field.getPreferredSize().height));

        return panel;
    }

    @Override
    public void startComponents() {
        centralPanel.setBorder(new EmptyBorder(Style.TOP_ESPACIO, 50, 20, 50));

        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        Label titulo = new Label("Datos del Tutor");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);

        field_nombre = new TextField(20);
        field_apellido_materno = new TextField(20);
        field_apellido_paterno = new TextField(20);
        field_telefono = new TextField(20);
        field_email = new TextField(20);

        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        lbl_responsable = new Label("Quién es el responsable de pagar tus estudios?");
        lbl_responsable.setFont(Style.LABEL_FONT);
        lbl_responsable.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_responsable);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        Parentesco[] opciones= Parentesco.values();
        comboParentesco= new ComboBox<>(opciones);
        comboParentesco.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(comboParentesco);

        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 3));

        JPanel fila1 = new JPanel(new GridLayout(1, 2, 40, 0));
        fila1.setBackground(Style.PANEL_COLOR);
        fila1.setMaximumSize(new Dimension(800, 40));

        fila1.add(crearDosColumnas("Nombres:", field_nombre));
        fila1.add(crearDosColumnas("Apellido Paterno:", field_apellido_paterno));
        centralPanel.add(fila1);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 2));

        JPanel fila2 = new JPanel(new GridLayout(1, 2, 40, 0));
        fila2.setBackground(Style.PANEL_COLOR);
        fila2.setMaximumSize(new Dimension(800, 40));

        fila2.add(crearDosColumnas("Apellido Materno:", field_apellido_materno));
        fila2.add(crearDosColumnas("Teléfono:", field_telefono));
        centralPanel.add(fila2);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 2));

        JPanel fila3 = new JPanel(new GridLayout(1, 2, 40, 0));
        fila3.setBackground(Style.PANEL_COLOR);
        fila3.setMaximumSize(new Dimension(800, 40));

        fila3.add(crearDosColumnas("Email:", field_email));

        JPanel fillerPanel = new JPanel();
        fillerPanel.setBackground(Style.PANEL_COLOR);
        fila3.add(fillerPanel);

        centralPanel.add(fila3);

        centralPanel.add(Box.createVerticalStrut(40));
        centralPanel.add(Box.createVerticalGlue());

        btnContinuar = new Button("Continuar");
        btnContinuar.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnContinuar);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("historialAcademicoPanel");
        });

        btnContinuar.addActionListener(e -> {
            if(algunCampoEstaVacio()){
                JOptionPane.showMessageDialog(this, "Favor de completar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Parentesco parentescoSeleccionado = (Parentesco) comboParentesco.getSelectedItem();
            String nombre= field_nombre.getText();
            String apellidoMaterno= field_apellido_materno.getText();
            String apellidoPaterno= field_apellido_paterno.getText();
            String telefono= field_telefono.getText();
            String correo= field_email.getText();

            TutorDTO tutorDTO= new TutorDTO(nombre, parentescoSeleccionado, apellidoMaterno, apellidoPaterno, telefono, correo);
            controlNavegacion.setTutor(tutorDTO);
            mainFrame.showPanel("informacionSocioeconomicaPanel");
            
        });
    }

    public boolean algunCampoEstaVacio(){
        return field_nombre.getText().trim().isBlank() ||
                field_apellido_materno.getText().trim().isBlank() ||
                field_apellido_paterno.getText().trim().isBlank() ||
                field_telefono.getText().trim().isBlank() ||
                field_email.getText().trim().isBlank();
    }
}