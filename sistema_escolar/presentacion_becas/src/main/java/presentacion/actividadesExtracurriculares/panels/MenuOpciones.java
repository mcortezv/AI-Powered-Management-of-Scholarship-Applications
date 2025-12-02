/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.actividadesExtracurriculares.panels;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.actividadesExtracurriculares.coordinador.CoordinadorAplicacionActividades;
import presentacion.styles.Button;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MenuOpciones extends PanelActividades{

    
    public MenuOpciones(ActividadesExtracurriculares actividades, CoordinadorAplicacionActividades coordinadorAplicacionActividades) {
        super(actividades, coordinadorAplicacionActividades);
        startComponents();
    }

    @Override
    public void startComponents() {
         this.southPanel.setVisible(false);
         centralPanel.removeAll();
         centralPanel.setAlignmentY(CENTER_ALIGNMENT);
         Button botonInscribir= new Button("inscribir");
         Button botonBaja= new Button("baja");
         
         botonInscribir.setAlignmentX(Button.CENTER_ALIGNMENT);
         botonBaja.setAlignmentX(Button.CENTER_ALIGNMENT);
         
         centralPanel.add(Box.createVerticalGlue());
         
         centralPanel.add(botonInscribir);
         centralPanel.add(Box.createVerticalStrut(20));
         centralPanel.add(botonBaja);
         
         centralPanel.add(Box.createVerticalGlue());
         
         botonInscribir.addActionListener(e->{
             coordinadorAplicacionActividades.inscribirActividad();
         });
         
      
      
      
    }
    
}
