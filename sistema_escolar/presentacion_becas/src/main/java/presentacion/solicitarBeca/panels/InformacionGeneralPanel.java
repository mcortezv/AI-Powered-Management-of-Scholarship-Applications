/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import controlNavegacion.ControlNavegacion;
import java.awt.Component;
import javax.swing.Box;

import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.validadores.Validadores;
import presentacion.styles.*;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import presentacion.styles.ComboBox;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformacionGeneralPanel extends PanelSolicitarBeca {
    private SolicitudBecasDisponiblesDTO solicitudDTO;
    private ControlNavegacion control;
    private Button btnContinuar;
    private TextField campoPromedio;
    private ComboBox<String> campoCarga;
    private TextField campoIngreso;


    public InformacionGeneralPanel(SolicitarBeca frame, ControlNavegacion controlNavegacion) {
        super(frame, controlNavegacion);
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
        String[] opciones = {"Si", "No"};
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

        btnContinuar = new Button("Aceptar");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(btnContinuar);

        btnBack.addActionListener(e -> {
            controlNavegacion.main();
        });

//        btnContinuar.addActionListener(e -> {
//            mainFrame.showPanel("listadoBecasDisponiblesPanel");
//        });

        btnContinuar.addActionListener(e -> {
        try {
            double promedio = Double.parseDouble(campoPromedio.getText().trim().replace(',', '.'));
            boolean carga   = "Si".equals(campoCarga.getSelectedItem());
            double ingreso  = Double.parseDouble(campoIngreso.getText().trim().replace(',', '.'));
            Validadores.validarPromedio(promedio);
            Validadores.validarIngreso(ingreso);

            SolicitudBecasDisponiblesDTO solictudDTO  = new SolicitudBecasDisponiblesDTO(promedio, carga, ingreso);
            SolicitudBecasDisponiblesResponseDTO reponseDTO = controlNavegacion.obtenerBecasDisponibles(solictudDTO);

            controlNavegacion.mostrarBecasDisponibles(reponseDTO);

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingresa un número válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al obtener becas: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    });
        //events();
    }



//    private void events() {
//        btnContinuar.addActionListener(e -> {
//                Double promedio = Double.parseDouble((campoPromedio.getText()));
//                boolean carga;
//                if (campoCarga.getSelectedItem().equals("Si")) {
//                    carga = true;
//                } else {
//                    carga = false;
//                }
//                Double ingreso = Double.parseDouble(campoIngreso.getText());
//                solicitudDTO = new SolicitudBecasDisponiblesDTO(promedio, carga, ingreso);
//                
//             //   java.util.List<BecaDTO> becasMock = crearMockBecas();
//                
//              //  mainFrame.showBecasDisponibles(becasMock);
//
//            }
//        );
//    }
    
//    private java.util.List<BecaDTO> crearMockBecas() {
//        java.time.LocalDate ahora = java.time.LocalDate.now();
//        return java.util.List.of(
//            new BecaDTO(1,"Apoyo Económico","Moisés Vázquez Gudiño","2025-2",50,
//                new RequisitosDTO(7.0,12000,30,50,30,false,true), ahora.plusMonths(1)),
//            new BecaDTO(2,"Excelencia","Beca Ara","2025-2",20,
//                new RequisitosDTO(9.0,999999,10,70,10,false,false), ahora.plusMonths(1)),
//            new BecaDTO(3,"Promedio","Fundación Espinoza Rodríguez","2025-2",40,
//                new RequisitosDTO(8.0,15000,20,60,20,false,false), ahora.plusMonths(1)),
//            new BecaDTO(4,"Corporativa","Constellation Brands","2025-2",15,
//                new RequisitosDTO(8.5,20000,15,70,15,true,false), ahora.plusMonths(1))
//        );
//    }
}
    
