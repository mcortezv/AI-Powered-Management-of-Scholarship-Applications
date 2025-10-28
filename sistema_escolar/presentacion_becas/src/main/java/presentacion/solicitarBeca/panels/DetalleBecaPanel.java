/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;

import java.awt.*;

/**
 *
 * @author katia
 */
public class DetalleBecaPanel extends PanelSolicitarBeca{
    private Button btnSolicitarBeca;

    public DetalleBecaPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
    }
    
    
    @Override
    public void startComponents() {

        btnSolicitarBeca = new Button("Solicitar");
        centralPanel.add(btnSolicitarBeca, BorderLayout.CENTER);

        btnSolicitarBeca.addActionListener(e -> {
            mainFrame.showPanel("datosDelSolicitantePanel");
        });

        btnBack.addActionListener(e -> {
           mainFrame.showPanel("listadoBecasDisponiblesPanel");
        });
    }

    
}
