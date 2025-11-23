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

    public BecasFiltradasDTO obtenerBecasDisponibles(RequisitosDTO requisitosDTO) {
        return controlSolicitud.obtenerBecasFiltradas(requisitosDTO);
    }

    public boolean validarRequisitos(Requisitos requisitos) {
        return false;
    }

    public boolean validarSolicitudNoExistente(int idEstudiante, int idSolicitud) {
        return false;
    }


    public Beca recuperarBeca(int idBeca) {
        return null;
    }


    public Estudiante solicitarDatosEstudiante(int idEstudiante) {
        return null;
    }


    public Solicitud crearSolicitud() {
        return null;
    }


    public boolean guardarSolicitud(Solicitud solicitud) {
        return false;
    }


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
