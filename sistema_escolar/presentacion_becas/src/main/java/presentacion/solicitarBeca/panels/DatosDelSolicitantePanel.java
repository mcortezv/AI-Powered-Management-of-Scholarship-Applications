package presentacion.solicitarBeca.panels;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.ApellidoInvalidoException;
import presentacion.solicitarBeca.exceptions.DireccionInvalidaException;
import presentacion.solicitarBeca.exceptions.NombresInvalidosException;
import presentacion.solicitarBeca.exceptions.TelefonoInvalidoException;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.TextField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Escalante, Sebastian.
 */
public class DatosDelSolicitantePanel extends PanelSolicitarBeca {
    private TextField field_nombre;
    private TextField field_apellido_materno;
    private TextField field_apellido_paterno;
    private TextField field_direccion;
    private TextField field_telefono;
    private TextField field_email;
    private final CoordinadorAplicacion coordinadorAplicacion;

    public DatosDelSolicitantePanel(SolicitarBeca mainFrame, CoordinadorAplicacion coordinadorAplicacion) {
        super(mainFrame, coordinadorAplicacion);
        this.coordinadorAplicacion= coordinadorAplicacion;
    }

    private JPanel crearDosColumnas(String labelText, TextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.setBackground(Style.PANEL_COLOR);
        Label label = new Label(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        field.setColumns(20);
        Dimension maxDim = new Dimension(Integer.MAX_VALUE, field.getPreferredSize().height);
        field.setMaximumSize(maxDim);

        panel.add(label);
        panel.add(field);
        panel.setMaximumSize(new Dimension(500, field.getPreferredSize().height));
        return panel;
    }

    @Override
    public void startComponents() {

        centralPanel.setBorder(new EmptyBorder(Style.TOP_ESPACIO, 50, 20, 50));

        Label titulo = new Label("Datos del Solicitante");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);

        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        field_nombre = new TextField(20);
        field_apellido_materno = new TextField(20);
        field_apellido_paterno = new TextField(20);
        field_direccion = new TextField(20);
        field_telefono = new TextField(20);
        field_email = new TextField(20);

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
        fila2.add(crearDosColumnas("Dirección:", field_direccion));
        centralPanel.add(fila2);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 2));

        JPanel fila3 = new JPanel(new GridLayout(1, 2, 40, 0));
        fila3.setBackground(Style.PANEL_COLOR);
        fila3.setMaximumSize(new Dimension(800, 40));

        fila3.add(crearDosColumnas("Teléfono:", field_telefono));
        fila3.add(crearDosColumnas("Email:", field_email));
        centralPanel.add(fila3);

        centralPanel.add(Box.createVerticalStrut(40));
        centralPanel.add(Box.createVerticalGlue());

        Button btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("detalleBecaPanel");
        });

        btn_next.addActionListener(e -> {
            try{
                String nombre= field_nombre.getText();
                String apellidoMaterno= field_apellido_materno.getText();
                String apellidoPaterno= field_apellido_paterno.getText();
                String direccion= field_direccion.getText();
                String telefono= field_telefono.getText();
                String email= field_email.getText();

                coordinadorAplicacion.procesarDatosSolicitante(nombre, apellidoMaterno, apellidoPaterno, direccion, telefono, email);

            } catch(NombresInvalidosException | ApellidoInvalidoException | DireccionInvalidaException | TelefonoInvalidoException | IDInvalidoException ex){
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(mainFrame,"Solo se aceptan números","Error de validación", JOptionPane.ERROR_MESSAGE);
            }

        });
    }
}