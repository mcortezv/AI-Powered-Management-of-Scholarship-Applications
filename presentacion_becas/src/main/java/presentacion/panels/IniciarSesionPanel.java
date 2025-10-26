package presentacion.panels;
import presentacion.MainFrame;
import presentacion.panels.uitls.Img;
import presentacion.panels.uitls.NorthPanel;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.Style;
import presentacion.styles.TextField;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class IniciarSesionPanel extends Panel {
    private Label titulo;
    private Img img;
    private Label lblUsuario;
    private TextField txtUsuario;
    private Label lblPassword;
    private TextField txtPassword;
    private Button btnIniciarSesion;

    public IniciarSesionPanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        titulo = new Label("Iniciar Sesión");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        img = new Img("/assets/usuario.png");
        img.setMaximumSize(new Dimension(200, 250));
        img.setAlignmentY(CENTER_ALIGNMENT);
        centralPanel.add(img);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        lblUsuario = new Label("Usuario");
        txtUsuario = new TextField(1);
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblUsuario);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(txtUsuario);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lblPassword = new Label("Contraseña");
        txtPassword = new TextField(1);
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPassword);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(txtPassword);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btnIniciarSesion = new Button("Iniciar Sesión");
        btnIniciarSesion.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnIniciarSesion);

    }
}
