/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import controles.ControlSolicitarBeca;
import dto.*;
import excepciones.SolicitudInvalidaException;
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
        this.controlSolicitud= gestor;
    }


    @Override
    public BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws SolicitudInvalidaException {
        return null;
    }

    @Override
    public BecaDTO obtenerBecaPorId(Long id) throws SolicitudInvalidaException {
        return null;
    }

    @Override
    public void iniciarNuevaSolicitud() throws SolicitudInvalidaException {

    }

    @Override
    public void setBecaActual(BecaDTO becaActual) throws SolicitudInvalidaException {

    }

    @Override
    public EstudianteDTO obtenerEstudiante(Long matricula) throws SolicitudInvalidaException {
        return null;
    }

    @Override
    public void setEstudiante() throws SolicitudInvalidaException {

    }

    @Override
    public void setHistorialAcademico(HistorialAcademicoDTO historialAcademico) throws SolicitudInvalidaException {

    }

    @Override
    public void setDatosTutor(TutorDTO tutor) throws SolicitudInvalidaException {

    }

    @Override
    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitudInvalidaException {

    }

    @Override
    public void setDocumentos(List<DocumentoDTO> documentos) throws SolicitudInvalidaException {

    }

    @Override
    public SolicitudDTO obtenerSolicitudActual() throws SolicitudInvalidaException {
        return null;
    }

    @Override
    public boolean guardarSolicitud() throws SolicitudInvalidaException {
        return false;
    }

    @Override
    public void cancelarSolicitud() throws SolicitudInvalidaException {
        
    }
}
