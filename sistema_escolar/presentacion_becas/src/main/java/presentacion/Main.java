/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package presentacion;
import controlNavegacion.ControlNavegacion;
import presentacion.login.MainFrame;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.SolicitarBeca;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame= new MainFrame();
        NorthPanel northPanel = new NorthPanel();
        SolicitarBeca solicitarBeca = new SolicitarBeca();
        ControlNavegacion navegador = ControlNavegacion.getInstancia(mainFrame,northPanel,solicitarBeca);
        navegador.iniciar();
        mainFrame.setVisible(true);
        
    }
}
