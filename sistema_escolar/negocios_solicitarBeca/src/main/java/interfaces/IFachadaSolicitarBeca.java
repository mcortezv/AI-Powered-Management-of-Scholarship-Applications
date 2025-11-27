/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dto.*;
import objetosNegocio.solicitarBeca.excepciones.SolicitudInvalidaException;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitarBeca {

    BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws SolicitudInvalidaException;

    BecaDTO obtenerBecaPorId(Long id) throws SolicitudInvalidaException;

    void iniciarNuevaSolicitud() throws SolicitudInvalidaException;

    EstudianteDTO obtenerEstudiante(Long matricula) throws SolicitudInvalidaException;

    void setHistorialAcademico(HistorialAcademicoDTO historialAcademicoDTO) throws SolicitudInvalidaException;

    void setDatosTutor(TutorDTO tutor) throws SolicitudInvalidaException;

    void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitudInvalidaException;

    void setDocumentos(List<DocumentoDTO> documentos) throws SolicitudInvalidaException;

    SolicitudDTO obtenerSolicitudActual() throws SolicitudInvalidaException;

    boolean guardarSolicitud() throws SolicitudInvalidaException;

//    void cancelarSolicitud() throws SolicitudInvalidaException;
}
