/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dominio.*;
import dto.*;
import excepciones.SolicitudInvalidaException;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IFachadaSolicitarBeca {

    Solicitud iniciarNuevaSolicitud() throws SolicitudInvalidaException;

    Solicitud obtenerSolicitudActual();

    void cancelarSolicitud();

    void agregarEstudiante(Estudiante estudiante) throws SolicitudInvalidaException;

    void agregarBeca(Beca beca) throws SolicitudInvalidaException;

    void agregarDocumentos(List<Documento> documentos) throws SolicitudInvalidaException;

    void agregarHistorial(HistorialAcademico historial) throws SolicitudInvalidaException;

    void agregarInfoSocioeconomica(InformacionSocioeconomica info) throws SolicitudInvalidaException;

    Solicitud validarYEnviarSolicitud() throws SolicitudInvalidaException;

    BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO);

    boolean validarRequisitos(Requisitos requisitos);

    boolean validarSolicitudNoExistente(int idEstudiante, int idSolicitud);

    Beca recuperarBeca(int idBeca);

    Estudiante solicitarDatosEstudiante(int idEstudiante);

    Solicitud crearSolicitud();

    boolean guardarSolicitud(Solicitud solicitud);

    boolean enviarSolicitudGobierno(SolicitudDTO solicitudDTO);
}
