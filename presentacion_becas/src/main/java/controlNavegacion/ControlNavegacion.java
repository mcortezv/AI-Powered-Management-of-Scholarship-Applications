/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlNavegacion;
import dto.*;
import gestor.ControlSolicitud;
import implementacion.FachadaSolicitud;
import interfaz.IManejadorSolicitud;
import presentacion.login.MainFrame;
import presentacion.solicitarBeca.SolicitarBeca;
import presentacion.solicitarBeca.panels.DetallesBecaPanel;
import presentacion.solicitarBeca.panels.ListadoBecasDisponiblesPanel;
import presentacion.solicitarBeca.panels.ResumenFinalPanel;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ControlNavegacion {
    private MainFrame mainFrame;
    private SolicitarBeca solicitarBeca;
    private IManejadorSolicitud manejador;
    private BecaDTO becaDTO;
    private BecaDTO becaSeleccionadaDTO;
    private DatosSolicitanteDTO datosSolicitanteDTO;
    private HistAcademicoDTO historialAcademicoDTO;
    private TutorDTO tutorDTO;
    private InformacionSocioeconomicaDTO infoSocioeconomicaDTO;
    private SolicitudDTO solicitudDTO;
  


    public ControlNavegacion(){
        this.manejador = new FachadaSolicitud(new ControlSolicitud());
        this.becaDTO= becaDTO;
       
        mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
        
    }

    public void solicitarBeca() {
        mainFrame.setVisible(false);
        solicitarBeca = new SolicitarBeca(this, becaDTO);
        solicitarBeca.setVisible(true);
    }

    public void main() {
        solicitarBeca.setVisible(false);
        mainFrame.setVisible(true);
    }
    
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO){
        return manejador.obtenerBecasDisponibles(solicitudDTO);
    }
    
    public void mostrarBecasDisponibles(SolicitudBecasDisponiblesResponseDTO responseDTO) {
        ListadoBecasDisponiblesPanel pnl = (ListadoBecasDisponiblesPanel) solicitarBeca.getPanel("listadoBecasDisponiblesPanel");
        pnl.setBecas(responseDTO.getBecas());
        solicitarBeca.showPanel("listadoBecasDisponiblesPanel");
        solicitarBeca.getNorthPanel().setVisible(true);
    }
    
    public void mostrarBecaSeleccionada(){
        BecaDTO becaSeleccionada= obtenerBecaSeleccionadaDTO();
        DetallesBecaPanel detallesBeca= (DetallesBecaPanel) solicitarBeca.getPanel("detalleBecaPanel");
        detallesBeca.cargarBeca(becaSeleccionada);
        solicitarBeca.showPanel("detalleBecaPanel");
    }
    public void mostrarResumen(){
        SolicitudDTO solicitudDTO= obtenerSolicitud();
        
        TutorDTO tutorDTO= obtenerTutor();
       DatosSolicitanteDTO solicitanteDTO= obtenerDatosSolicitanteDTO();
        ResumenFinalPanel resumenFinal= (ResumenFinalPanel) solicitarBeca.getPanel("resumenFinalPanel");
        resumenFinal.cargarResumen(solicitudDTO, tutorDTO, solicitanteDTO);
        solicitarBeca.showPanel("resumenFinalPanel");
        
    }
   

    public BecaDTO obtenerBecaSeleccionadaDTO() {
        return becaSeleccionadaDTO;
    }
    
    public DatosSolicitanteDTO obtenerDatosSolicitanteDTO(){
        return datosSolicitanteDTO;
    }
    
    public void setDatosSolicitanteDTO(DatosSolicitanteDTO datosSolicitante){
        this.datosSolicitanteDTO= datosSolicitante;
    }

    public void setBecaSeleccionadaDTO(BecaDTO becaSeleccionadaDTO) {
        this.becaSeleccionadaDTO = becaSeleccionadaDTO;
    }
    public void setHistorialAcademicoDTO(HistAcademicoDTO historialAcademicoDTO){
       this.historialAcademicoDTO= historialAcademicoDTO;
    }
    
    public void setTutor(TutorDTO tutor){
        this.tutorDTO= tutor;
    }
    public TutorDTO obtenerTutor(){
        return tutorDTO;
    }
    
    public InformacionSocioeconomicaDTO obtenerInfoSocioeconomicaDTO(){
        return infoSocioeconomicaDTO;
    }    
    
    public void setInfoSocioeconomica(InformacionSocioeconomicaDTO infoSocioeconomicaDTO){
        this.infoSocioeconomicaDTO= infoSocioeconomicaDTO;
    }
    
    public HistAcademicoDTO obtenerHistAcademico(){
        return historialAcademicoDTO;
    }
    
    public void setSolicitud(SolicitudDTO solicitudDTO){
       this.solicitudDTO= solicitudDTO;
    }
    
    public SolicitudDTO obtenerSolicitud(){
        return solicitudDTO;
    }

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return manejador.validarInicioSesion(solicitudLoginDTO);
    }

    
}
