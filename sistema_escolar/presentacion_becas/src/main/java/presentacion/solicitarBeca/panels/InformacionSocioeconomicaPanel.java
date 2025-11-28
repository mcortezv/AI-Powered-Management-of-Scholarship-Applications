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
import java.math.BigDecimal;

/**
 * @author Escalante, Sebastian.
 */
public class InformacionSocioeconomicaPanel extends PanelSolicitarBeca{
    private Label titulo;
    private Label lbl_ingreso;
    private TextField field_ingreso;
    private Label lbl_tipo_vivienda;
    private ComboBox<String> cbx_tipo_vivienda;
    private Label lbl_deudas;
    private ComboBox<String> cbx_deudas;
    private Label lbl_tabajo;
    private ComboBox<String> cbx_tabajo;
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

        lbl_tipo_vivienda = new Label("Tipo de vivienda:");
        lbl_tipo_vivienda.setFont(Style.LABEL_FONT);
        lbl_tipo_vivienda.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_tipo_vivienda);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] opciones_vivienda = new String[]{"CASA_PROPIA", "DEPARTAMENTO", "RESIDENCIA", "VIVIENDA_IMPROVISADA"};
        cbx_tipo_vivienda = new ComboBox<>(opciones_vivienda);
        cbx_tipo_vivienda.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(cbx_tipo_vivienda);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_deudas = new Label("Tienes deudas?");
        lbl_deudas.setFont(Style.LABEL_FONT);
        lbl_deudas.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_deudas);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] opciones_deudas = new String[]{"SI", "NO"};
        cbx_deudas = new ComboBox<>(opciones_deudas);
        cbx_deudas.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(cbx_deudas);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        lbl_tabajo = new Label("Trabajas?");
        lbl_tabajo.setFont(Style.LABEL_FONT);
        lbl_tabajo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(lbl_tabajo);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        String[] opciones_trabajas = new String[]{"SI", "NO"};
        cbx_tabajo = new ComboBox<>(opciones_trabajas);
        cbx_tabajo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(cbx_tabajo);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btn_next = new Button("Continuar");
        btn_next.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(btn_next);

        btnBack.addActionListener(e -> {
            mainFrame.showPanel("datosTutorPanel");
        });

        btn_next.addActionListener(e -> {
            
                BigDecimal ingreso = BigDecimal.valueOf(Double.parseDouble(field_ingreso.getText()));
                String tipoVivienda = (String) cbx_tipo_vivienda.getSelectedItem();
                String valorDeudas = (String) cbx_deudas.getSelectedItem();
                boolean seleccionDeudas = valorDeudas.equalsIgnoreCase("SI");
                String valorTrabajo = (String) cbx_tabajo.getSelectedItem();
                boolean seleccionTrabajo = valorTrabajo.equalsIgnoreCase("SI");
                InformacionSocioeconomicaDTO infoSocioeconomica = new InformacionSocioeconomicaDTO();
                infoSocioeconomica.setIngresoTotalFamilarMensual(ingreso);
                infoSocioeconomica.setTipoVivienda(tipoVivienda);
                infoSocioeconomica.setTrabajo(seleccionTrabajo);
                infoSocioeconomica.setDeudas(seleccionDeudas);
                coordinadorAplicacion.procesarInformacionSocioeconomica(infoSocioeconomica);
            
        });
    }
}