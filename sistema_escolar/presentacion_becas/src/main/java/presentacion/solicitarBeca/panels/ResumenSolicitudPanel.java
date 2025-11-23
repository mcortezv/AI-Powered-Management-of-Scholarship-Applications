package presentacion.solicitarBeca.panels;

import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import dto.SolicitudDTO;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Style;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Escalante, Sebastian.
 */
public class ResumenSolicitudPanel extends PanelSolicitarBeca{
    private Label lbl_beca_response;
    private Label lbl_info_2;
    private Label lbl_info_3;
    private CoordinadorAplicacion control;

    public ResumenSolicitudPanel(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
        this.southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 50));
    }

    @Override
    public void startComponents() {
        Label titulo = new Label("Resumen Final");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        centralPanel.setBorder(new EmptyBorder(0, 50, 0, 50));

        Font sectionFont = new Font("Segoe UI", Font.BOLD, 26);
        Font dataFont = new Font("Segoe UI", Font.PLAIN, 20);

        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 80, 0));
        contentPanel.setBackground(Style.PANEL_COLOR);
        contentPanel.setAlignmentX(CENTER_ALIGNMENT);

        JPanel leftColumn = new JPanel();
        leftColumn.setLayout(new BoxLayout(leftColumn, BoxLayout.Y_AXIS));
        leftColumn.setBackground(Style.PANEL_COLOR);

        Label lbl_beca_solicitada = new Label("Beca solicitada:");
        lbl_beca_solicitada.setFont(sectionFont);
        lbl_beca_solicitada.setAlignmentX(Component.LEFT_ALIGNMENT);

         lbl_beca_response = new Label("Moisés Vázquez Gudiño");
        lbl_beca_response.setFont(dataFont);
        lbl_beca_response.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftColumn.add(lbl_beca_solicitada);
        leftColumn.add(Box.createVerticalStrut(10));
        leftColumn.add(lbl_beca_response);
        leftColumn.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lbl_datos_solicitante = new Label("Datos del Solicitante:");
        lbl_datos_solicitante.setFont(sectionFont);
        lbl_datos_solicitante.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_solicitante_1 = new Label("Katia Ximena Álvarez Espinoza");
        lbl_solicitante_1.setFont(dataFont);
        lbl_solicitante_1.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_solicitante_2 = new Label("21 años");
        lbl_solicitante_2.setFont(dataFont);
        lbl_solicitante_2.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftColumn.add(lbl_datos_solicitante);
        leftColumn.add(Box.createVerticalStrut(10));
        leftColumn.add(lbl_solicitante_1);
        leftColumn.add(lbl_solicitante_2);
        leftColumn.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lbl_datos_tutor = new Label("Datos del Tutor:");
        lbl_datos_tutor.setFont(sectionFont);
        lbl_datos_tutor.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_tutor_1 = new Label("Juan López Vázquez");
        lbl_tutor_1.setFont(dataFont);
        lbl_tutor_1.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_tutor_2 = new Label("Padre");
        lbl_tutor_2.setFont(dataFont);
        lbl_tutor_2.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_tutor_3 = new Label("53 años");
        lbl_tutor_3.setFont(dataFont);
        lbl_tutor_3.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftColumn.add(lbl_datos_tutor);
        leftColumn.add(Box.createVerticalStrut(10));
        leftColumn.add(lbl_tutor_1);
        leftColumn.add(lbl_tutor_2);
        leftColumn.add(lbl_tutor_3);
        leftColumn.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        leftColumn.add(Box.createVerticalGlue());

        JPanel rightColumn = new JPanel();
        rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
        rightColumn.setBackground(Style.PANEL_COLOR);

        Label lbl_info_socioeconomica = new Label("Informacion Socioeconómica:");
        lbl_info_socioeconomica.setFont(sectionFont);
        lbl_info_socioeconomica.setAlignmentX(Component.LEFT_ALIGNMENT);

        Label lbl_info_1 = new Label("Personas en tu familia: 5");
        lbl_info_1.setFont(dataFont);
        lbl_info_1.setAlignmentX(Component.LEFT_ALIGNMENT);

         lbl_info_2 = new Label("Ingreso mensual familiar: Entre 8000 y 10000");
        lbl_info_2.setFont(dataFont);
        lbl_info_2.setAlignmentX(Component.LEFT_ALIGNMENT);

         lbl_info_3 = new Label("Generas ingreso: No");
        lbl_info_3.setFont(dataFont);
        lbl_info_3.setAlignmentX(Component.LEFT_ALIGNMENT);

        rightColumn.add(lbl_info_socioeconomica);
        rightColumn.add(Box.createVerticalStrut(10));
        rightColumn.add(lbl_info_1);
        rightColumn.add(lbl_info_2);
        rightColumn.add(lbl_info_3);
        rightColumn.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lbl_documentos = new Label("Documentos:");
        lbl_documentos.setFont(sectionFont);
        lbl_documentos.setAlignmentX(Component.LEFT_ALIGNMENT);

        rightColumn.add(lbl_documentos);
        rightColumn.add(Box.createVerticalStrut(10));

        rightColumn.add(createDocumentLabel("CURP", dataFont));
        rightColumn.add(createDocumentLabel("IDENTIFICACIÓN OFICIAL", dataFont));
        rightColumn.add(createDocumentLabel("COMPROBANTE DE INSCRIPCIÓN", dataFont));
        rightColumn.add(createDocumentLabel("KÁRDEX", dataFont));
        rightColumn.add(createDocumentLabel("COMPROBANTE INGRESOS PADRE", dataFont));

        rightColumn.add(Box.createVerticalGlue());

        contentPanel.add(leftColumn);
        contentPanel.add(rightColumn);

        centralPanel.add(contentPanel);
        centralPanel.add(Box.createVerticalGlue());
        Button btnAceptar = new Button("Aceptar");
        btnAceptar.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btnAceptar);
    }
    
    private void cargarResumen(SolicitudDTO solicitudDTO, TutorDTO tutorDTO){
        lbl_beca_response.setText(solicitudDTO.getBeca().getNombre());
     
      lbl_info_2.setText(String.valueOf(solicitudDTO.getInformacionSocioeconomica().getIngresoTotalFamilarMensual()));
      if(solicitudDTO.getInformacionSocioeconomica().isTrabajo()){
          lbl_info_3.setText("Si");
          
      } else{
          lbl_info_3.setText("No");
      }

    }
    private Label createDocumentLabel(String text, Font font) {
        String checkMark = "\u2713  ";
        Label label = new Label(checkMark + text);
        label.setFont(font);
        label.setForeground(new Color(34, 139, 34));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
}
