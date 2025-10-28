package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;

import java.awt.*;


public class ResumenFinalPanel extends PanelSolicitarBeca {
    private Button btnContinuar;

    public ResumenFinalPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
    }

    @Override
    public void startComponents() {

        btnContinuar = new Button("Continuar");
        centralPanel.add(btnContinuar, BorderLayout.CENTER);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("subirDocumentosPanel");
        });


        btnContinuar.addActionListener(e -> {
            mainFrame.showPanel("confirmacionPanel");
        });
    }
}
