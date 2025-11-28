package presentacion.solicitarBeca.panels;
import presentacion.CoordinadorAplicacion;
import presentacion.login.panels.ImgPanel;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ConfirmacionPanel extends PanelSolicitarBeca {
    private Label titulo;
    private ImgPanel img;
    private Label subTitulo;
    private Button btnAceptar;

    public ConfirmacionPanel(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        titulo = new Label("Solicitud Completada");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        img = new ImgPanel("/assets/check.png");
        img.setMaximumSize(new Dimension(300, 300));
        img.setAlignmentY(CENTER_ALIGNMENT);
        centralPanel.add(img);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        subTitulo = new Label("Se ha registrado tu solicitud exitosamente.");
        subTitulo.setFont(Style.LABEL_FONT);
        subTitulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(subTitulo);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btnAceptar = new Button("Aceptar");
        btnAceptar.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnAceptar);

        btnBack.setVisible(false);

        btnAceptar.addActionListener(e -> {
            coordinadorAplicacion.main();
        });
    }
}