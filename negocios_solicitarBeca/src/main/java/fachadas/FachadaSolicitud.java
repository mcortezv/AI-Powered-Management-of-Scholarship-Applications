/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;
import dominio.BecasFiltradas;
import dominio.Solicitud;
import dto.*;
import controles.ControlSolicitud;

/**
 *                          FACHADA
 * @author janethcristinagalvanquinonez
 */
public class FachadaSolicitud  {
    private final ControlSolicitud controlSolicitud;
    private Solicitud solicitudActual;
    
    public FachadaSolicitud(ControlSolicitud gestor){
        this.controlSolicitud= gestor;
    }



    public FachadaSolicitarBeca(ControlSolicitarBeca control) {
        this.control = Objects.requireNonNull(control);
    }

    /** Inicia la construcción de una nueva Solicitud y la devuelve. */
    public Solicitud iniciarNuevaSolicitud() throws SolicitudInvalidaException {
        this.solicitudActual = control.iniciarSolicitud();
        return this.solicitudActual;
    }

    /* Getter de la solicitud en curso (puede ser null si no iniciada) */
    public Solicitud obtenerSolicitudActual() {
        return this.solicitudActual;
    }

    /* Cancela la solicitud en curso (elimina estado local) */
    public void cancelarSolicitud() {
        this.solicitudActual = null;
    }

    /* Paso 1: agregar/crear estudiante */
    public void agregarEstudiante(Estudiante estudiante) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.asignarEstudiante(solicitudActual, estudiante);
    }

    /* Paso 2: agregar/seleccionar beca */
    public void agregarBeca(Beca beca) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.asignarBeca(solicitudActual, beca);
    }

    /* Paso 3: agregar documentos (lista completa) */
    public void agregarDocumentos(List<Documento> documentos) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.asignarDocumentos(solicitudActual, documentos);
    }

    /* Paso 4: agregar historial */
    public void agregarHistorial(HistorialAcademico historial) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.asignarHistorial(solicitudActual, historial);
    }

    /* Paso 5: agregar informacion socioeconomica */
    public void agregarInfoSocioeconomica(InformacionSocioeconomica info) throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.asignarSocioeconomico(solicitudActual, info);
    }

    /**
     * Valida y finaliza la solicitud (cambia estado a ENVIADA).
     * Devuelve la solicitud finalizada.
     */
    public Solicitud validarYEnviarSolicitud() throws SolicitudInvalidaException {
        assertSolicitudIniciada();
        control.validarYFinalizarSolicitud(solicitudActual);
        // opcional: aquí podrías llamar a un adaptador externo para enviar la solicitud a gobierno/itson
        Solicitud finalizada = this.solicitudActual;
        // dejar la fachada lista para una nueva solicitud (opcional)
        this.solicitudActual = null;
        return finalizada;
    }

    /* ---------------- helpers ---------------- */
    private void assertSolicitudIniciada() throws SolicitudInvalidaException {
        if (this.solicitudActual == null) {
            throw new SolicitudInvalidaException("No hay una solicitud en curso. Llama a iniciarNuevaSolicitud() primero.");
        }
    }

    @Override
    public BecasFiltradas obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return controlSolicitud.obtenerBecasDisponibles(solicitudDTO);
    }

    @Override
    public boolean enviarSolicituGobierno(SolicitudDTO solicitudDTO) {
        //return controlSolicitud.
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
        return control.procesarSolicitud(
                estNombre, estCorreo, estTel, estDir,
                tutorNombre, tutorParen, tutorTel,
                becaNom, becaTipo, becaReq, becaFecha,
                carrera, promedio,
                ingreso, tipoVivienda,
                documentos
        );
    }

}
