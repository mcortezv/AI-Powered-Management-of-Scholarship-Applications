/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dto.*;
import excepciones.SolicitudInvalidaException;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitarBeca {

    BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws SolicitudInvalidaException;

    BecaDTO obtenerBecaPorId(Long id) throws SolicitudInvalidaException;

    void iniciarNuevaSolicitud() throws SolicitudInvalidaException;

    void setBecaActual(BecaDTO becaActual) throws SolicitudInvalidaException;

    EstudianteDTO obtenerEstudiante(Long matricula) throws SolicitudInvalidaException;

    void setEstudiante() throws SolicitudInvalidaException;

    void setHistorialAcademico(HistorialAcademicoDTO historialAcademico) throws SolicitudInvalidaException;

    void setDatosTutor(TutorDTO tutor) throws SolicitudInvalidaException;

    void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitudInvalidaException;

    void setDocumentos(List<DocumentoDTO> documentos) throws SolicitudInvalidaException;

    SolicitudDTO obtenerSolicitudActual() throws SolicitudInvalidaException;

    boolean guardarSolicitud() throws SolicitudInvalidaException;

    void cancelarSolicitud() throws SolicitudInvalidaException;
}
