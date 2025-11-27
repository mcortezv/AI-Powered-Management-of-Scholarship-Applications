package presentacion.solicitarBeca.panels;
import dto.InformacionSocioeconomicaDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.*;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.TextField;
import javax.swing.*;
import java.awt.*;

/**
 * @author Escalante, Sebastian.
 */
public class InformacionSocioeconomicaPanel extends PanelSolicitarBeca{
    private Label titulo;
    private Label lbl_ingreso;
    private TextField field_ingreso;
    private Label lbl_familia_depende;
    private ComboBox<String> cbx_familia_depende;
    private Label lbl_genera_ingreso;
    private ComboBox<String> cbx_genera_ingreso;
    private Button btn_next;

    public InformacionSocioeconomicaPanel(SolicitarBeca mainFrame, CoordinadorAplicacion coordinadorAplicacion){
        super(mainFrame, coordinadorAplicacion);
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        titulo = new Label("Información Socioeconómica");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        lbl_ingreso = new Label("Ingreso familiar total mensual:");
        lbl_ingreso.setAlignmentX(Component.CENTER_ALIGNMENT);
        field_ingreso = new TextField(1);
        field_ingreso.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lbl_ingreso);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(field_ingreso);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_familia_depende = new Label("Tu familia depende económicamente de una sola persona?");
        lbl_familia_depende.setFont(Style.LABEL_FONT);
        lbl_familia_depende.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_familia_depende);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] opciones_depende = new String[]{"SI", "NO"};
        cbx_familia_depende = new ComboBox<>(opciones_depende);
        cbx_familia_depende.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(cbx_familia_depende);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_genera_ingreso = new Label("Generas algún ingreso?");
        lbl_genera_ingreso.setFont(Style.LABEL_FONT);
        lbl_genera_ingreso.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_genera_ingreso);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] opciones_genera_ingreso = new String[]{"SI", "NO"};
        cbx_genera_ingreso = new ComboBox<>(opciones_genera_ingreso);
        cbx_genera_ingreso.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(cbx_genera_ingreso);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("datosTutorPanel");
        });

        btn_next.addActionListener(e -> {
            try {
                String ingresoStr = field_ingreso.getText().trim();
                String seleccionDependEconomica = (String) cbx_familia_depende.getSelectedItem();
                String seleccionGeneraIngreso = (String) cbx_genera_ingreso.getSelectedItem();
                InformacionSocioeconomicaDTO infoSocioeconomica= new InformacionSocioeconomicaDTO();
                coordinadorAplicacion.procesarInformacionSocioeconomica(ingresoStr, seleccionDependEconomica, seleccionGeneraIngreso);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame, "El ingreso familiar debe ser un valor numérico válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}