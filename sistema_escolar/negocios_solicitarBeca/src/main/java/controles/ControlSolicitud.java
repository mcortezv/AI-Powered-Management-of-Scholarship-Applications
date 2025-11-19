package controles;
import dominio.*;
import java.util.List;
import java.util.Objects;

/**
 * Control que orquesta las operaciones atómicas sobre la Solicitud.
 * No mantiene estado por sesión; recibe la Solicitud (objeto dominio)
 * y delega a los BOs. Esto permite que la Fachada lleve el "estado" de la solicitud.
 */
public class ControlSolicitud {
    private final ISolicitudBO solicitudBO;
    private final IEstudianteBO estudianteBO;
    private final ITutorBO tutorBO;
    private final IBecaBO becaBO;
    private final IDocumentoBO documentoBO;
    private final IHistorialBO historialBO;
    private final ISocioeconomicoBO socioBO;

    public ControlSolicitarBeca(ISolicitudBO solicitudBO,
                                IEstudianteBO estudianteBO,
                                ITutorBO tutorBO,
                                IBecaBO becaBO,
                                IDocumentoBO documentoBO,
                                IHistorialBO historialBO,
                                ISocioeconomicoBO socioBO) {
        this.solicitudBO = Objects.requireNonNull(solicitudBO);
        this.estudianteBO = Objects.requireNonNull(estudianteBO);
        this.tutorBO = Objects.requireNonNull(tutorBO);
        this.becaBO = Objects.requireNonNull(becaBO);
        this.documentoBO = Objects.requireNonNull(documentoBO);
        this.historialBO = Objects.requireNonNull(historialBO);
        this.socioBO = Objects.requireNonNull(socioBO);
    }

    /* Crear solicitud vacía (delegar al BO) */
    public Solicitud iniciarSolicitud() throws negocio.excepciones.SolicitudInvalidaException {
        return solicitudBO.crearSolicitudVacia();
    }

    /* Asignaciones atómicas delegadas a la BO de solicitud */
    public void asignarEstudiante(Solicitud s, Estudiante est) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.asignarEstudiante(s, est);
    }

    public void asignarBeca(Solicitud s, Beca b) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.asignarBeca(s, b);
    }

    public void asignarDocumentos(Solicitud s, List<Documento> docs) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.asignarDocumentos(s, docs);
    }

    public void asignarHistorial(Solicitud s, HistorialAcademico h) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.asignarHistorial(s, h);
    }

    public void asignarSocioeconomico(Solicitud s, InformacionSocioeconomica info) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.asignarSocioeconomico(s, info);
    }

    /* Validar toda la solicitud (cambia estado a ENVIADA si todo ok) */
    public void validarYFinalizarSolicitud(Solicitud s) throws negocio.excepciones.SolicitudInvalidaException {
        solicitudBO.validarSolicitudCompleta(s);
    }
}
