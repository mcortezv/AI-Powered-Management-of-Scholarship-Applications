/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package presentacion.panels;
import presentacion.MainFrame;
import presentacion.panels.uitls.Img;
import presentacion.panels.uitls.NorthPanel;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ConfirmacionPanel extends Panel {
    private Label titulo;
    private Img img;
    private Label subTitulo;
    private Button btnAceptar;

    public ConfirmacionPanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        titulo = new Label("Historial Academico");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        img = new Img("/assets/check.png");
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
    }
}
