/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import dominio.*;
import dto.*;
import controles.ControlSolicitud;
import excepciones.SolicitudInvalidaException;
import interfaces.IFachadaSolicitud;
import java.util.List;

/**
 *                          FACHADA
 * @author janethcristinagalvanquinonez
 */
public class FachadaSolicitud implements IFachadaSolicitud {
    private final ControlSolicitud controlSolicitud;
    private Solicitud solicitudActual;
    
    public FachadaSolicitud(ControlSolicitud gestor){
        this.controlSolicitud= gestor;
    }

    public Solicitud iniciarNuevaSolicitud() throws SolicitudInvalidaException {
        this.solicitudActual = controlSolicitud.iniciarSolicitud();
        return this.solicitudActual;
    }

    public Solicitud obtenerSolicitudActual() {
        return this.solicitudActual;
    }

    public void cancelarSolicitud() {
        this.solicitudActual = null;
    }

    public void agregarEstudiante(Estudiante estudiante) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.asignarEstudiante(solicitudActual, estudiante);
    }

    public void agregarBeca(Beca beca) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.asignarBeca(solicitudActual, beca);
    }

    public void agregarDocumentos(List<Documento> documentos) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.asignarDocumentos(solicitudActual, documentos);
    }

    public void agregarHistorial(HistorialAcademico historial) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.asignarHistorial(solicitudActual, historial);
    }

    public void agregarInfoSocioeconomica(InformacionSocioeconomica info) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.asignarSocioeconomico(solicitudActual, info);
    }

    public Solicitud validarYEnviarSolicitud() throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        controlSolicitud.validarYFinalizarSolicitud(solicitudActual);
        Solicitud finalizada = this.solicitudActual;
        this.solicitudActual = null;
        return finalizada;
    }

    private void assertSolicitudIniciada() throws SolicitudInvalidaException {
        if (this.solicitudActual == null) {
            throw new SolicitudInvalidaException("No hay una solicitud en curso. Llama a iniciarNuevaSolicitud() primero.");
        }
    }

    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return null;
    }

    @Override
    public boolean validarRequisitos(Requisitos requisitos) {
        return false;
    }

    @Override
    public boolean validarSolicitudNoExistente(int idEstudiante, int idSolicitud) {
        return false;
    }

    @Override
    public Beca recuperarBeca(int idBeca) {
        return null;
    }

    @Override
    public Estudiante solicitarDatosEstudiante(int idEstudiante) {
        return null;
    }

    @Override
    public Solicitud crearSolicitud() {
        return null;
    }

    @Override
    public boolean guardarSolicitud(Solicitud solicitud) {
        return false;
    }

    @Override
    public boolean enviarSolicitudGobierno(SolicitudDTO solicitudDTO) {
        return false;
    }

    public boolean enviarSolicituGobierno(SolicitudDTO solicitudDTO) {
        return true;
    }

    public Solicitud solicitarBeca(
            String estNombre, String estCorreo, String estTel, String estDir,
            String tutorNombre, String tutorParen, String tutorTel,
            String becaNom, String becaTipo, String becaReq, String becaFecha,
            String carrera, Double promedio,
            Double ingreso, String tipoVivienda,
            List<String> documentos
    ) {
        return null;
    }

}
