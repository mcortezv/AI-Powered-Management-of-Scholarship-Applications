package presentacion.login.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.login.MainFrame;
import presentacion.styles.Panel;

import java.awt.*;


public class HubPanel extends Panel {

    public HubPanel(MainFrame mainFrame, ControlNavegacion controlNavegacion) {
        super(mainFrame, controlNavegacion);
    }

    @Override
    public void startComponents() {
        btnBack.setVisible(false);
        btnLogOut.setVisible(true);
    }
}
