package presentacion.login.panels;
import controlNavegacion.ControlNavegacion;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import presentacion.login.MainFrame;
import presentacion.login.exceptions.ContraseniaInvalidaException;
import presentacion.login.exceptions.IDInvalidoException;
import presentacion.login.validadores.Validadores;
import presentacion.styles.Button;
import presentacion.styles.Panel;

import javax.swing.*;
import java.awt.*;


public class HubPanel extends Panel {

    public HubPanel(MainFrame mainFrame, ControlNavegacion controlNavegacion) {
        super(mainFrame, controlNavegacion);
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
