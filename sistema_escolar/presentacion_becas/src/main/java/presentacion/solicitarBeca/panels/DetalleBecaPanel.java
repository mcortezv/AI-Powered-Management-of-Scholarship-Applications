/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;

import java.awt.*;

/**
 *
 * @author katia
 */
public class DetalleBecaPanel extends PanelSolicitarBeca{
    private Button btnSolicitarBeca;

    public DetalleBecaPanel(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
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
