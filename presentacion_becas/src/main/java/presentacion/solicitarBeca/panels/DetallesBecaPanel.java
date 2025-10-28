/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.solicitarBeca.panels;

import controlNavegacion.ControlNavegacion;
import dto.BecaDTO;
import java.awt.Component;
import static java.awt.Font.BOLD;
import javax.swing.Box;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Style;
import presentacion.styles.TextField;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class DetallesBecaPanel extends PanelSolicitarBeca {
    
    private Label titulo;
    private Label lblTituloDescripcion, lblTituloPromedio, lblTituloPeriodo, lblDescripcion, lblPromedio, lblPeriodo;
    private Button botonSiguiente;
    private BecaDTO becaDTO= new BecaDTO();
    private BecaDTO beca;
    
    
    
    
    public DetallesBecaPanel(SolicitarBeca mainFrame, ControlNavegacion controlNavegacion){
        super(mainFrame, controlNavegacion);
    }
    
    public void startComponents(){
        centralPanel.add(Box.createVerticalStrut(Style.TOP_ESPACIO)); 
        titulo = new Label("Beca seleccionada");
        titulo.setFont(Style.TITLE_FONT);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(titulo);
        centralPanel.add(Box.createVerticalStrut(Style.TITULO_ESPACIO));   
        
        lblTituloDescripcion= new Label("Descripción");
        lblTituloDescripcion.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblTituloDescripcion);
        
        
        lblDescripcion = new Label("Descripcion de beca");
        lblDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblDescripcion);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));

     
        lblTituloPromedio= new Label("Promedio Minimo");
        lblTituloPromedio.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblTituloPromedio);    
        
        
        lblPromedio = new Label("Promedio minimo");       
        lblPromedio.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPromedio);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        
        
        lblTituloPeriodo= new Label("Periodo");
        lblTituloPeriodo.setFont(Style.LABEL_FONT.deriveFont(BOLD));
        lblTituloPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblTituloPeriodo);
        
        lblPeriodo= new Label("Periodo");
        lblPeriodo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centralPanel.add(lblPeriodo);
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO)); 
        centralPanel.add(Box.createVerticalStrut(Style.LBL_ESPACIO));
        centralPanel.add(Box.createVerticalGlue());
        botonSiguiente= new Button("Solicitar");
        botonSiguiente.setAlignmentX(CENTER_ALIGNMENT);
        centralPanel.add(botonSiguiente);     
        
        
        botonSiguiente.addActionListener(e -> {
            mainFrame.showPanel("datosDelSolicitantePanel");
        });
        
        btnBack.addActionListener(e ->{
            mainFrame.showPanel("listadoBecasDisponiblesPanel");
        });
        
    

    
    }
    
    public void cargarBeca(BecaDTO becaDTO){
        
        this.beca= becaDTO;
        titulo.setText(becaDTO.getNombre());
        lblDescripcion.setText(becaDTO.getDescripcion());
        lblPromedio.setText(String.valueOf(becaDTO.getRequisitos().getPromedioMinimo()));
        lblPeriodo.setText(becaDTO.getPeriodo());
        
        
        
    }
    
    
    
    
            
}

