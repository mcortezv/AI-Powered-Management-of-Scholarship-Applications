/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;

import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import gestor.GestorSolicitud;
import implementacion.ManejadorSolicitud;
import interfaz.IManejadorSolicitud;
import presentacion.login.MainFrame;
import presentacion.login.panels.IniciarSesionPanel;
import presentacion.solicitarBeca.panels.*;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    IManejadorSolicitud manejador;
    private SolicitudDTO solicitudEnCurso;
    private static ControlNavegacion instancia;
    private IniciarSesionPanel iniciarSesion;
    private InformacionGeneralPanel infoGeneral;
    private HistorialAcademicoPanel historialAcad;
    private ConfirmacionPanel confirmacionPanel;
    private DatosDelSolicitantePanel datosDelSolicitantePanel;
    private DatosSocioeconomicosPanel datosSocioeconomicosPanel;

    // aquí irá lo de los BOs
    // aaa

    public ControlNavegacion(IManejadorSolicitud manejador){
        this.manejador= manejador;
    }

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return manejador.obtenerBecasDisponibles(solicitudDTO);
    }

    private void inicializarBOs(){
        GestorSolicitud gestorSolicitud = new GestorSolicitud();
        this.subsistemaSolicitud = new ManejadorSolicitud(gestorSolicitud);
        this.solicitudEnCurso = new SolicitudDTO();
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
