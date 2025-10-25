/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;
import java.awt.BorderLayout;
import javax.swing.*;
import presentacion.panels.MainPanel;
import presentacion.panels.NorthPanel;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private InformGeneral panelInformGeneral;
    
    
    public MainFrame() {
        
        setTitle("info general");
        setSize(1700,1000);
        setLayout(new BorderLayout());
        
        NorthPanel northPanel= new NorthPanel();
        panelInformGeneral= new InformGeneral(this, northPanel);
        
        

        add(northPanel, BorderLayout.NORTH);
        add(panelInformGeneral, BorderLayout.CENTER);
        
        
    }

    public void showMainPanel() {}
}
