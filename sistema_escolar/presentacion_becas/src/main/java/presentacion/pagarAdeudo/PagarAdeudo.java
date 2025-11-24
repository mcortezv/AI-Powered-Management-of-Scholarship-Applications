package presentacion.pagarAdeudo;

import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.login.panels.NorthPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PagarAdeudo extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private Map<String, JPanel> panels;
    private CoordinadorAplicacion coordinadorAplicacion;

    public PagarAdeudo(CoordinadorAplicacion coordinadorAplicacion){
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        centralPanel = new JPanel();
        this.coordinadorAplicacion = coordinadorAplicacion;
    }

    public void initializePanels(){

    }
}
