package presentacion.login.panels;
import presentacion.CoordinadorAplicacion;
import presentacion.login.MainFrame;
import presentacion.styles.ImgPanel;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.Style;
import presentacion.styles.Button;
import javax.swing.Box;
import java.awt.*;

/**
 * @author Escalante, Sebastian.
 */
public class HubPanel extends Panel {
    private CoordinadorAplicacion coordinadorAplicacion;
    private Label titulo;
    private ImgPanel img;
    protected Button btnLogOut;

    public HubPanel(MainFrame mainFrame, CoordinadorAplicacion coordinadorAplicacion) {
        super(mainFrame, coordinadorAplicacion);
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    @Override
    public void startComponents() {
        btnBack.setVisible(false);
        btnLogOut = new Button("Cerrar Sesión");

        img = new ImgPanel("/assets/hero.png");
        img.setMaximumSize(new Dimension(1500, 700));
        img.setAlignmentY(CENTER_ALIGNMENT);
        centralPanel.add(img);
        southPanel.add(centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO)));
        southPanel.add(btnLogOut);


        btnLogOut.addActionListener(e -> {
            coordinadorAplicacion.cerrarSesion();
            mainFrame.showPanel("iniciarSesionPanel");
            mainFrame.getNorthPanel().setVisible(false);
        });
    }
}
