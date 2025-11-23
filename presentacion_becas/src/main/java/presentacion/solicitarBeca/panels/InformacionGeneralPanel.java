package presentacion.solicitarBeca.panels;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import java.awt.Component;
import javax.swing.*;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.exceptions.IngresoInvalidoException;
import presentacion.solicitarBeca.exceptions.PromedioInvalidoException;
import presentacion.styles.*;
import presentacion.styles.ComboBox;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformacionGeneralPanel extends PanelSolicitarBeca {
    private Button btnContinuar;
    private TextField campoPromedio;
    private ComboBox<String> campoCarga;
    private TextField campoIngreso;
    private ComboBox<String> campoTrabajo;
    private ComboBox<String> campoDeudas;


    public InformacionGeneralPanel(SolicitarBeca frame, CoordinadorAplicacion coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    public void startComponents() {
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO));

        Label lblTitulo = new Label("Informacion General");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setFont(Style.TITLE_FONT);
        centralPanel.add(lblTitulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));

        Label lblPromedio = new Label("Qué promedio llevas actualmente?");
        lblPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoPromedio = new TextField(1);
        campoPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPromedio);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(campoPromedio);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));


        Label lblCarga = new Label("Estás cursando la carga completa?");
        lblCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] opciones = new String[]{"25%", "50%", "75%", "100%"};
        campoCarga = new ComboBox<>(opciones);
        centralPanel.add(lblCarga);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(campoCarga);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lblIngreso = new Label("Cuál es el ingreso mensual total de tu familia?");
        campoIngreso = new TextField(1);
        lblIngreso.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblIngreso);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(campoIngreso);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lblTrabajo = new Label("Trabajas?");
        lblTrabajo.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] opcionesTrabajo = new String[]{"Si", "No"};
        campoTrabajo = new ComboBox<>(opcionesTrabajo);
        centralPanel.add(lblTrabajo);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(campoTrabajo);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        Label lblDeudas = new Label("Estás cursando la carga completa?");
        lblCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] opcionesDeudas = new String[]{"Si", "No"};
        campoDeudas = new ComboBox<>(opcionesDeudas);
        centralPanel.add(lblDeudas);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(campoDeudas);
        centralPanel.add(Box.createVerticalStrut(Style.BLOQUE_ESPACIO));

        btnContinuar = new Button("Aceptar");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(btnContinuar);

        btnBack.addActionListener(e -> {
            coordinadorAplicacion.main();
        });


        btnContinuar.addActionListener(e -> {
            try {
                double promedio = Double.parseDouble(campoPromedio.getText().trim().replace(',', '.'));
                double ingreso  = Double.parseDouble(campoIngreso.getText().trim().replace(',', '.'));
                String cargaStr = (String) campoCarga.getSelectedItem();
                double carga = Double.parseDouble(cargaStr.replace("%", ""));
                boolean trabajo   = "Si".equals(campoTrabajo.getSelectedItem());
                boolean deudas   = "Si".equals(campoDeudas.getSelectedItem());
                coordinadorAplicacion.procesarInformacionGeneral(promedio, carga, ingreso, deudas, trabajo);

            } catch (PromedioInvalidoException | IngresoInvalidoException ex) {
                JOptionPane.showMessageDialog(mainFrame, ex.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(mainFrame,"Solo se aceptan números","Error de validación", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}