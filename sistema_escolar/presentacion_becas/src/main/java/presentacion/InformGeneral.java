/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import presentacion.panels.NorthPanel;
import presentacion.styles.Button;
import presentacion.styles.Label;
import presentacion.styles.Panel;
import presentacion.styles.TextField;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class InformGeneral extends Panel{
    
    Button botonSiguiente;
    public InformGeneral(MainFrame frame, NorthPanel northPanel){
        super(frame, northPanel);

    }
            
    
    public void startComponents(){
        central();
        south();       
   
        
    }
    
    private void central(){
        Label lblPromedio= new Label("Que promedio llevas actualmente?");
        TextField campoTexto= new TextField(1);
        Label lblCarga= new Label("Estas cursando la carga completa?");
        TextField campoCarga= new TextField(1);
        Label lblIngreso= new Label("Cual es el ingreso mensual total de tu familia?");
        TextField campoIngreso= new TextField(1);
        centralPanel.add(lblPromedio);
        centralPanel.add(campoTexto);
        centralPanel.add(lblCarga);
        centralPanel.add(campoCarga);
        centralPanel.add(lblIngreso);
        centralPanel.add(campoIngreso);
        
    }
    
    private void south(){
        botonSiguiente= new Button("Aceptar");
        southPanel.add(botonSiguiente);
        
    }
    
    private void events(){
       
    }
    
}
