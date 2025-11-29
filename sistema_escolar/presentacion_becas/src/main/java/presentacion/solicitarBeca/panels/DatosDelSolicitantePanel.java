package presentacion.solicitarBeca.panels;
import presentacion.solicitarBeca.PanelSolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.CoordinadorAplicacion;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.ApellidoInvalidoException;
import presentacion.solicitarBeca.exceptions.DireccionInvalidaException;
import presentacion.solicitarBeca.exceptions.NombresInvalidosException;
import presentacion.solicitarBeca.exceptions.TelefonoInvalidoException;
import presentacion.styles.*;
import solicitarBeca.EstudianteDTO;
import javax.swing.*;
import java.awt.*;

public class DatosDelSolicitantePanel extends PanelSolicitarBeca {
    private Label matricula;
    private Label nombre;
    private Label carrera;
    private Label telefono;
    private Label direccion;
    private Label correo;
    private EstudianteDTO estudiante;
    private final CoordinadorAplicacion coordinadorAplicacion;

    public DatosDelSolicitantePanel(SolicitarBeca mainFrame, CoordinadorAplicacion coordinadorAplicacion) {
        super(mainFrame, coordinadorAplicacion);
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    private JPanel crearDosColumnas(String labelText, Label field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Style.PANEL_COLOR);
        panel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));
        Label label = new Label(labelText);
        label.setFont(Style.SUBTITLE_FONT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        panel.add(label);
        panel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(field);
        return panel;
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        Label titulo = new Label("Datos del Solicitante");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        matricula = new Label("");
        nombre = new Label("");
        carrera = new Label("");
        telefono = new Label("");
        direccion = new Label("");
        correo = new Label("");

        JPanel fila1 = new JPanel(new GridLayout(1, 2, 60, 0));
        fila1.setBackground(Style.PANEL_COLOR);
        fila1.setMaximumSize(new Dimension(800, 60));
        fila1.add(crearDosColumnas("Matricula:", matricula));
        fila1.add(crearDosColumnas("Nombre:", nombre));
        centralPanel.add(fila1);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 2));

        JPanel fila2 = new JPanel(new GridLayout(1, 2, 60, 0));
        fila2.setBackground(Style.PANEL_COLOR);
        fila2.setMaximumSize(new Dimension(800, 60));
        fila2.add(crearDosColumnas("Carrera:", carrera));
        fila2.add(crearDosColumnas("Teléfono:", telefono));
        centralPanel.add(fila2);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO * 2));

        JPanel fila3 = new JPanel(new GridLayout(1, 2, 60, 0));
        fila3.setBackground(Style.PANEL_COLOR);
        fila3.setMaximumSize(new Dimension(800, 60));
        fila3.add(crearDosColumnas("Dirección:", direccion));
        fila3.add(crearDosColumnas("Correo:", correo));
        centralPanel.add(fila3);

        centralPanel.add(Box.createVerticalStrut(40));
        centralPanel.add(Box.createVerticalGlue());

        Button btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btnBack.addActionListener(e -> mainFrame.showPanel("detalleBecaPanel"));

        btn_next.addActionListener(e -> {
            try {
                coordinadorAplicacion.procesarDatosSolicitante(estudiante);

            } catch (NombresInvalidosException | ApellidoInvalidoException | DireccionInvalidaException |
                     TelefonoInvalidoException | IDInvalidoException ex) {
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame, "Solo se aceptan números", "Error de validación", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "No se pudo recuperar al estudiante", "Error de datos", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
        matricula.setText(estudiante.getMatricula().toString());
        nombre.setText(estudiante.getNombre());
        carrera.setText(estudiante.getCarrera());
        telefono.setText(estudiante.getTelefono());
        direccion.setText(estudiante.getDireccion());
        correo.setText(estudiante.getCorreo());
    }
}
