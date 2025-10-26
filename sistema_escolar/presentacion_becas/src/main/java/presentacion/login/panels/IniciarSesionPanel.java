package presentacion.login.panels;
import presentacion.login.MainFrame;
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
        centralPanel.add(btnIniciarSesion);


        btnIniciarSesion.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            char[] contraseña = txtPassword.getPassword();
            try{
                //aqui se debe validar
                mainFrame.showPanel(mainFrame.hubPanel);
                mainFrame.setMenuVisible(true);
            } finally{
                java.util.Arrays.fill(contraseña, '\0');
            }
            
        });
    }
}
