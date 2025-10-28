/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;

import presentacion.login.MainFrame;
import presentacion.login.panels.IniciarSesionPanel;
import presentacion.login.panels.NorthPanel;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.panels.*;


/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    private MainFrame mainFrame;
    private NorthPanel northPanel;
    private SolicitarBeca solicitarBeca;

    private static ControlNavegacion instancia;
    private IniciarSesionPanel iniciarSesion;
    private InformacionGeneralPanel infoGeneral;
    private HistorialAcademicoPanel historialAcad;
    private ConfirmacionPanel confirmacionPanel;
    private DatosDelSolicitantePanel datosDelSolicitantePanel;
    private DatosSocioeconomicosPanel datosSocioeconomicosPanel;

    // aquí irá lo de los BOs
    // aaa

    private ControlNavegacion(MainFrame mainFrame, NorthPanel northPanel, SolicitarBeca solicitarBeca){
        // inicializarBOs();
        this.mainFrame = mainFrame;
        this.northPanel = northPanel;
        this.solicitarBeca = solicitarBeca;
        inicializarPantallas();
    }

    public static ControlNavegacion getInstancia(MainFrame mainFrame, NorthPanel northPanel, SolicitarBeca solicitarBeca) {
        if (instancia == null){
            instancia = new ControlNavegacion(mainFrame,northPanel,solicitarBeca);
        }
        return instancia;
    }

    private void inicializarPantallas() {
        this.iniciarSesion = new IniciarSesionPanel(mainFrame,northPanel);
        this.infoGeneral = new InformacionGeneralPanel(solicitarBeca,northPanel);
        this.historialAcad = new HistorialAcademicoPanel(solicitarBeca,northPanel);
        this.confirmacionPanel = new ConfirmacionPanel(solicitarBeca,northPanel);
        this.datosDelSolicitantePanel = new DatosDelSolicitantePanel(solicitarBeca,northPanel);
        this.datosSocioeconomicosPanel = new DatosSocioeconomicosPanel(solicitarBeca,northPanel);
    }

    public void iniciar() {
        mostrarIniciarSesion();
    }

    public void mostrarIniciarSesion() {
        ocultarTodas();
        iniciarSesion.setVisible(true);
    }

    public void mostrarInformacionGeneral() {
        ocultarTodas();
        infoGeneral.setVisible(true);
    }

    public void mostrarHistorialAcademico() {
        ocultarTodas();
        historialAcad.setVisible(true);
    }

    public void mostrarConfirmacion() {
        ocultarTodas();
        confirmacionPanel.setVisible(true);
    }

    public void mostrarDatosDelSolicitante(){
        ocultarTodas();
        datosDelSolicitantePanel.setVisible(true);
    }

    public void mostrarDatosSocioeconomicos(){
        ocultarTodas();
        datosSocioeconomicosPanel.setVisible(true);
    }

    private void ocultarTodas() {
        iniciarSesion.setVisible(false);
        infoGeneral.setVisible(false);
        historialAcad.setVisible(false);
        confirmacionPanel.setVisible(false);
        datosDelSolicitantePanel.setVisible(false);
        datosSocioeconomicosPanel.setVisible(false);
    }

}
