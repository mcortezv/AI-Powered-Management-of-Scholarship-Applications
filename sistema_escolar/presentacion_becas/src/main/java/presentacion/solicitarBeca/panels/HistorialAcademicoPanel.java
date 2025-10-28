/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import javax.swing.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoPanel extends PanelSolicitarBeca {
    private Label titulo;
    private Label carrera;
    private ComboBox<String> comboCarrera;
    private Label cargaAcademica;
    private ComboBox<String> comboCargaAcademica;
    private Label semestre;
    private ComboBox<Integer> comboSemestre;
    private Button botonSiguiente;

    public HistorialAcademicoPanel(SolicitarBeca mainFrame, ControlNavegacion controlNavegacion) {
        super(mainFrame, controlNavegacion);
    }

    @Override
    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        titulo = new Label("Historial Academico");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        carrera = new Label("Que carrera estas cursando?");
        carrera.setFont(Style.LABEL_FONT);
        carrera.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(carrera);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] carreras = new String[]{"ISW", "LPS"};
        comboCarrera = new ComboBox<>(carreras);
        comboCarrera.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(comboCarrera);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        carrera = new Label("Carga Academica");
        carrera.setFont(Style.LABEL_FONT);
        carrera.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(carrera);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] carga = new String[]{"25%", "50%", "75%", "100%"};
        comboCargaAcademica = new ComboBox<>(carga);
        comboCargaAcademica.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(comboCargaAcademica);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        semestre = new Label("Semestre");
        semestre.setFont(Style.LABEL_FONT);
        semestre.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(semestre);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        Integer[] semestres = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        comboSemestre = new ComboBox<>(semestres);
        comboSemestre.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(comboSemestre);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        botonSiguiente = new Button("Continuar");
        botonSiguiente.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(botonSiguiente);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("datosDelSolicitantePanel");
        });

        botonSiguiente.addActionListener(e -> {
            mainFrame.showPanel("datosTutorPanel");
        });
    }
}
