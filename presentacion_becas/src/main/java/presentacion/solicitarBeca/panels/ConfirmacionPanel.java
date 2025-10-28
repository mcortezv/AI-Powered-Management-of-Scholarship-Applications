/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.login.panels.ImgPanel;
import presentacion.login.panels.NorthPanel;
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

    public ConfirmacionPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        titulo = new Label("Historial Academico");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        img = new ImgPanel("/assets/check.png");
        img.setMaximumSize(new Dimension(300, 300));
        img.setAlignmentY(CENTER_ALIGNMENT);
        centralPanel.add(img);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        subTitulo = new Label("Se ha registrado tu solicitud");
        subTitulo.setFont(Style.LABEL_FONT);
        subTitulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(subTitulo);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btnAceptar = new Button("Aceptar");
        btnAceptar.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnAceptar);

        btnAceptar.addActionListener(e -> {
            controlNavegacion.main();
        });
    }
}
