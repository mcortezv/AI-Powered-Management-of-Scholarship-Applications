/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;
import dto.BecaDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import java.awt.Component;
import java.awt.Dimension;
import static java.awt.Font.BOLD;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Style;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class DetallesBecaPanel extends PanelSolicitarBeca {
    
    private Label titulo;
    private Label lblTituloDescripcion, lblTituloPromedio, lblTituloPeriodo, lblDescripcion, lblPromedio, lblPeriodo, lblTituloTipo, lblTipo;
    private Button botonSiguiente;
    private BecaDTO beca;
    private JPanel lista;
    private JScrollPane scroll;

    public DetallesBecaPanel(SolicitarBeca mainFrame, CoordinadorAplicacion coordinadorAplicacion){
        super(mainFrame, coordinadorAplicacion);
    }
    
    public void startComponents(){
        //centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO)); 
        titulo = new Label("Beca seleccionada");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        
        lista = new JPanel();
        lista.setOpaque(false);
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));
        
        lista.add(Box.createVerticalStrut(Style.TOP_ESPACIO));
        lista.add(titulo);
        lista.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));   

        lblTituloTipo= new Label("TIPO");
        lblTituloTipo.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblTituloTipo);

        lblTipo = new Label("Tipo Beca");
        lblTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblTipo);
        lista.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
      
        lblTituloDescripcion= new Label("DESCRIPCIÓN");
        lblTituloDescripcion.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblTituloDescripcion);        
        
        lblDescripcion = new Label("Descripcion de beca");
        lblDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lista.add(lblDescripcion);
        lista.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

        lblTituloPromedio= new Label("PROMEDIO MINIMO");
        lblTituloPromedio.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblTituloPromedio);
        
        lblPromedio = new Label("Promedio minimo");       
        lblPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblPromedio);
        lista.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        
        lblTituloPeriodo= new Label("PERIODO");
        lblTituloPeriodo.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblTituloPeriodo);
        
        lblPeriodo= new Label("Periodo");
        lblPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lista.add(lblPeriodo);
        //lista.add(Box.createVerticalStrut(Style.LBL_ESPACIO)); 
        //lista.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        //lista.add(Box.createVerticalGlue());
        botonSiguiente= new Button("Solicitar");
        botonSiguiente.setAlignmentX(CENTER_ALIGNMENT);
        lista.add(botonSiguiente);     

        scroll = new JScrollPane(lista);
        scroll.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        scroll.setAlignmentX(CENTER_ALIGNMENT);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setMaximumSize(new Dimension(800, Integer.MAX_VALUE));    
        
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centralPanel.add(scroll);
        centralPanel.add(Box.createVerticalGlue());
        
        lista.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1500));
        lista.add(Box.createVerticalGlue());
        botonSiguiente.addActionListener(e -> {
            coordinadorAplicacion.setBecaSeleccionadaDTO(beca);
            coordinadorAplicacion.iniciarSolicitud();
            mainFrame.showPanel("datosDelSolicitantePanel");
        });
        
        btnBack.addActionListener(e ->{
            mainFrame.showPanel("listadoBecasDisponiblesPanel");
        });

    }
    
    public void cargarBeca(BecaDTO becaDTO){
        this.beca= becaDTO;
        titulo.setText(becaDTO.getNombre());
        //lblDescripcion.setText(becaDTO.getDescripcion());
        lblDescripcion.setText(
            "<html>"
            + "<div style='text-align:center; width:900px; margin-left:auto; margin-right:auto;'>"
            + becaDTO.getDescripcion().replace("\n", "<br>")
            + "</div>"
            + "</html>"
        );
        lblPromedio.setText(String.valueOf(becaDTO.getRequisitos().getPromedioMinimo()));
        lblPeriodo.setText(becaDTO.getFechaInicio().toString() + "->" + becaDTO.getFechaFin().toString());
        lblTipo.setText(becaDTO.getTipo());

    }


}

