package presentacion.pagarAdeudo.mainFraimePagarAdeudo;

import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.pagarAdeudo.panels.ConsultaAdeudoMenu;
import presentacion.styles.Button;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFramePagarAdeudo extends JFrame {
    private final JPanel centralPanel;
    private Button btnBiblioteca;
    private Button btnColegiatura;
    private CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo;
    private final Map<String, JPanel> panels;
    private PagarAdeudo pagarAdeudo;

    public MainFramePagarAdeudo(CoordinadorAplicacionPagarAdeudo coordinadorAplicacionPagarAdeudo){
        setResizable(false);
        setSize(1500,900);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        this.coordinadorAplicacionPagarAdeudo = coordinadorAplicacionPagarAdeudo;
        btnBiblioteca = new Button("Bibloteca");
        btnColegiatura = new Button("Colegiatura");
        centralPanel.add(btnBiblioteca);
        centralPanel.add(btnColegiatura);
        add(centralPanel, BorderLayout.CENTER);

        panels = new HashMap<String, JPanel>();
        pagarAdeudo = new PagarAdeudo(coordinadorAplicacionPagarAdeudo);

        panels.put("consultaAdeudoMenu", new ConsultaAdeudoMenu(pagarAdeudo, coordinadorAplicacionPagarAdeudo));
    }

}
