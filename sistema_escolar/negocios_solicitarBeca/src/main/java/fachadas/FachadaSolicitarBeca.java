/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import controles.ControlSolicitarBeca;
import dto.*;
import objetosNegocio.solicitarBeca.excepciones.SolicitudInvalidaException;
import interfaces.IFachadaSolicitarBeca;
import solicitarBeca.dominio.*;
import java.util.List;

/**
 *                          FACHADA
 * @author janethcristinagalvanquinonez
 */
public class FachadaSolicitarBeca implements IFachadaSolicitarBeca {
    private final ControlSolicitarBeca controlSolicitud;
    private Solicitud solicitudActual;
    
    public FachadaSolicitarBeca(ControlSolicitarBeca gestor){
        this.controlSolicitud = gestor;
    }


  
    public BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws SolicitudInvalidaException {
        return controlSolicitud.obtenerBecasFiltradas(requisitos);
    }

    @Override
    public BecaDTO obtenerBecaPorId(Long id) throws SolicitudInvalidaException {
        return controlSolicitud.obtenerBecaPorId(id);
    }

    @Override
    public void iniciarNuevaSolicitud() throws SolicitudInvalidaException {
        controlSolicitud.iniciarSolicitud();
    }

    @Override
    public EstudianteDTO obtenerEstudiante(Long matricula) throws SolicitudInvalidaException {
        return controlSolicitud.obtenerEstudiante(matricula);
    }


    @Override
    public void setHistorialAcademico(HistorialAcademicoDTO historialAcademicoDTO) throws SolicitudInvalidaException {
        controlSolicitud.asignarHistorial(historialAcademicoDTO);
    }

    @Override
    public void setDatosTutor(TutorDTO tutor) throws SolicitudInvalidaException {
        controlSolicitud.asignarTutor(tutor);
    }

    @Override
    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitudInvalidaException {
        controlSolicitud.setInformacionSocioeconomica(informacionSocioeconomica);
    }

    @Override
    public void setDocumentos(List<DocumentoDTO> documentos) throws SolicitudInvalidaException {
        controlSolicitud.asignarDocumentos(documentos);
    }

    @Override
    public SolicitudDTO obtenerSolicitudActual() throws SolicitudInvalidaException {
        return controlSolicitud.obtenerSolicitudActual();
    }

    @Override
    public boolean guardarSolicitud() throws SolicitudInvalidaException {
        return controlSolicitud.guardarSolicitud();
    }

    @Override
    public void cancelarSolicitud() throws SolicitudInvalidaException {
        controlSolicitud.cancelarSolicitud();
    }
}
