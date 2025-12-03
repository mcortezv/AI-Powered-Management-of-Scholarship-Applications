/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.actividadesExtracurriculares.panels;

import dto.actividades.ActividadDTO;
import dto.actividades.ActividadesDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import presentacion.actividadesExtracurriculares.coordinador.CoordinadorAplicacionActividades;
import presentacion.styles.Button;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ListaActividades extends PanelActividades {
    JPanel panelContenido;
    
    
    public ListaActividades(ActividadesExtracurriculares actividadesExtracurriculares, CoordinadorAplicacionActividades coordinadorAplicacionActividades) {
        super(actividadesExtracurriculares, coordinadorAplicacionActividades);
        startComponents();
    }

    @Override
    public void startComponents() {
        centralPanel.removeAll();
        centralPanel.setBackground(new Color(240, 240, 240));
        
        JTextField textField= new JTextField();
        textField.setMaximumSize(new Dimension(400, 50));
        textField.setPreferredSize(new Dimension(400, 50));
        centralPanel.add(textField);
        centralPanel.add(Box.createVerticalStrut(40));
        panelContenido= new JPanel();
        panelContenido.setBackground(Color.white);
        panelContenido.setMaximumSize(new Dimension(700,500));
        panelContenido.setPreferredSize(new Dimension(700,500));
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        centralPanel.add(panelContenido);
        cargarElementos();
       
       
    }
    
    public void cargarElementos(){
        ActividadesDTO actividadesDTO= coordinadorAplicacionActividades.obtenerActividades();
        
    //    List<String> inscripciones= coordinadorAplicacionActividades.cargarInscripciones();
        panelContenido.add(Box.createVerticalGlue());
        for(ActividadDTO actividad:actividadesDTO.getActividades()){
            Button boton= new Button(actividad.getNombre());
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            boton.setBackground(new Color(60, 100, 220));
            boton.setOpaque(true);
            boton.setForeground(Color.WHITE);
          
            boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
            boton.setPreferredSize(new Dimension(Integer.MAX_VALUE, 60));
            
            
            panelContenido.add(boton);
            panelContenido.add(Box.createVerticalStrut(10));
            
            boton.addActionListener(e->{
                
            });
        }
        panelContenido.add(Box.createVerticalGlue());
    }
    
    
    
}
