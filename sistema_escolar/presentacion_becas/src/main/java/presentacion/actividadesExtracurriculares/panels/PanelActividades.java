/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.actividadesExtracurriculares.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import presentacion.actividadesExtracurriculares.coordinador.CoordinadorAplicacionActividades;
import presentacion.styles.Button;
import presentacion.styles.Style;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public abstract class PanelActividades extends JPanel{
    
    protected ActividadesExtracurriculares actividades;
    protected CoordinadorAplicacionActividades coordinadorAplicacionActividades;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected Button botonSiguiente;
    
    
    public PanelActividades(ActividadesExtracurriculares actividadesExtracurriculares, CoordinadorAplicacionActividades coordinadorAplicacionActividades){
        actividades= actividadesExtracurriculares;
        this.coordinadorAplicacionActividades= coordinadorAplicacionActividades;
        this.setLayout(new BorderLayout());
        
        
        botonSiguiente= new Button("siguiente");
        centralPanel= new JPanel();
        southPanel= new JPanel();
      //  southPanel.setBackground(Color.red);
        centralPanel.setPreferredSize(new Dimension(1500, 750));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        southPanel.setPreferredSize(new Dimension(1500, 50));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        southPanel.add(botonSiguiente);
        centralPanel.setBackground(Style.PANEL_COLOR);
        southPanel.setBackground(Style.PANEL_COLOR);
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);        
        
        
        
        
        
    }
        
     public abstract void startComponents();
    
}
