package presentacion.pagarAdeudo;

import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.login.panels.NorthPanel;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PagarAdeudo extends JFrame {
    private NorthPanel northPanel;
    private JPanel centralPanel;
    private Map<String, JPanel> panels;
    private CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo;

    public PagarAdeudo(CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo){
        setTitle("Solicitar Beca");
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        northPanel = new NorthPanel();
        centralPanel = new JPanel();
        this.coordinadorAplicacionPagarAdeudo = coordinadorAplicacionPagarAdeudo;
    }

    public void initializePanels(){

    }
}
