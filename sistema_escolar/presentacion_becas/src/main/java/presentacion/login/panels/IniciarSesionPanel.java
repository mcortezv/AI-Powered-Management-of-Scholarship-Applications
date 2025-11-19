package presentacion.login.panels;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import dto.EstudianteResponseDTO;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.Style;
import presentacion.styles.TextField;
import javax.swing.*;
import java.awt.*;

import presentacion.styles.PasswordField;

/**
 *
 * @author Cortez, Manuel;
 */
public class IniciarSesionPanel extends Panel {
    private Label titulo;
    private ImgPanel img;
    private Label lblUsuario;
    private TextField txtUsuario;
    private Label lblPassword;
    private PasswordField txtPassword;
    private Button btnIniciarSesion;
    private final CoordinadorAplicacion coordinadorAplicacion;

    public IniciarSesionPanel(MainFrame frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    @Override
    public void startComponents() {
        btnLogOut.setVisible(false);
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        btnBack.setVisible(false);

        titulo = new Label("Iniciar Sesión");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        img = new ImgPanel("/assets/usuario.png");
        img.setMaximumSize(new Dimension(215, 300));
        img.setAlignmentY(CENTER_ALIGNMENT);
        centralPanel.add(img);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        lblUsuario = new Label("Usuario");
        txtUsuario = new TextField(1);
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblUsuario);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        txtUsuario.setMaximumSize(new Dimension(400, 60));
        centralPanel.add(txtUsuario);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        lblPassword = new Label("Contraseña");
        txtPassword = new PasswordField(1);
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPassword);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        txtPassword.setMaximumSize(new Dimension(400, 60));
        centralPanel.add(txtPassword);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        btnIniciarSesion = new Button("Iniciar Sesión");
        btnIniciarSesion.setAlignmentX(CENTER_ALIGNMENT);
        btnIniciarSesion.setEnabled(false);
        centralPanel.add(btnIniciarSesion);
        
        Runnable toggle = () -> btnIniciarSesion.setEnabled(
            !txtUsuario.getText().trim().isEmpty() &&
            txtPassword.getPassword().length > 0
        );
        
        javax.swing.event.DocumentListener dl = new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { toggle.run(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { toggle.run(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { toggle.run(); }
        };
        txtUsuario.getDocument().addDocumentListener(dl);
        txtPassword.getDocument().addDocumentListener(dl);
        txtPassword.addActionListener(e -> btnIniciarSesion.doClick());
        toggle.run();

        btnIniciarSesion.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String contrasenia = new String(txtPassword.getPassword());
            try {
               EstudianteResponseDTO estudianteResponseDTo = coordinadorAplicacion.intentarIniciarSesion(usuario,contrasenia);

            } catch (IDInvalidoException | ContraseniaInvalidaException ex) {
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFrame, "Error intentando iniciar sesión.", "Inicio de sesión", JOptionPane.ERROR_MESSAGE
                );
                ex.printStackTrace();
            }
        });
    }
}
