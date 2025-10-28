/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;
import gestor.GestorSolicitud;
import implementacion.ManejadorSolicitud;
import presentacion.login.MainFrame;
import presentacion.solicitarBeca.SolicitarBeca;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    private MainFrame mainFrame;
    private SolicitarBeca solicitarBeca;
    private ManejadorSolicitud manejadorSolicitud;


    public ControlNavegacion(){
        manejadorSolicitud = new ManejadorSolicitud(new GestorSolicitud());
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
    }

    public void solicitarBeca() {
        mainFrame.setVisible(false);
        solicitarBeca = new SolicitarBeca(this);
        solicitarBeca.setVisible(true);
    }

    public void main() {
        solicitarBeca.setVisible(false);
        mainFrame.setVisible(true);
    }
    
    public ManejadorSolicitud getGestorSolicitud() {
        return manejadorSolicitud;
    }
}
