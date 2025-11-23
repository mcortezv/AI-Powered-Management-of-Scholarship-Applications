package presentacion.login.panels;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.login.MainFrame;
import presentacion.styles.Panel;


public class HubPanel extends Panel {

    public HubPanel(MainFrame mainFrame, CoordinadorAplicacion coordinadorAplicacion) {
        super(mainFrame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {
        btnBack.setVisible(false);
        btnLogOut.setVisible(true);
        btnLogOut.addActionListener(e -> {
            mainFrame.showPanel("iniciarSesionPanel");
            mainFrame.getNorthPanel().setVisible(false);
        });
    }

}
