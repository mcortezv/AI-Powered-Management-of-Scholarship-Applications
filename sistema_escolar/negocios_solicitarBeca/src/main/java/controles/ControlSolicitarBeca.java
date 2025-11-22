package controles;
import dominio.*;
import dto.BecaDTO;
import dto.DocumentoDTO;
import dto.HistorialAcademicoDTO;
import dto.InformacionSocioeconomicaDTO;
import dto.SolicitudDTO;
import interfaces.IBecaBO;
import interfaces.IDocumentoBO;
import interfaces.IEstudianteBO;
import interfaces.ISolicitudBO;
import interfaces.ITutorBO;
import java.util.List;
import java.util.Objects;

/**
 * Control que orquesta las operaciones atómicas sobre la Solicitud.
 * No mantiene estado por sesión; recibe la Solicitud (objeto dominio)
 * y delega a los BOs. Esto permite que la Fachada lleve el "estado" de la solicitud.
 */
public class ControlSolicitarBeca {
    private final ISolicitudBO solicitudBO;
    private final IEstudianteBO estudianteBO;
    private final ITutorBO tutorBO;
    private final IBecaBO becaBO;
    private final IDocumentoBO documentoBO;
    private final IHistorialBO historialBO;
    private final ISocioeconomicoBO socioBO;

    public ControlSolicitarBecaBeca(ISolicitudBO solicitudBO,
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
    public SolicitudDTO iniciarSolicitud() throws excepciones.SolicitudInvalidaException {
        return solicitudBO.crearSolicitudVacia();
    }

    /* Asignaciones atómicas delegadas a la BO de solicitud */
    public void asignarEstudiante(SolicitudDTO solicitud, EstudianteDTO estudiante) throws excepciones.SolicitudInvalidaException {
        solicitudBO.asignarEstudiante(solicitud, estudiante);
    }

    public void asignarBeca(SolicitudDTO solicitud, BecaDTO beca) throws excepciones.SolicitudInvalidaException {
        solicitudBO.asignarBeca(solicitud, beca);
    }

    public void asignarDocumentos(SolicitudDTO solicitud, List<DocumentoDTO> docs) throws excepciones.SolicitudInvalidaException {
        solicitudBO.asignarDocumentos(solicitud, docs);
    }

    public void asignarHistorial(SolicitudDTO solicitud, HistorialAcademicoDTO histAcademico) throws excepciones.SolicitudInvalidaException {
        solicitudBO.asignarHistorial(solicitud, histAcademico);
    }

    public void asignarSocioeconomico(SolicitudDTO solicitud, InformacionSocioeconomicaDTO infoSocioeconomica) throws excepciones.SolicitudInvalidaException {
        solicitudBO.asignarSocioeconomico(solicitud, infoSocioeconomica);
    }

    /* Validar toda la solicitud (cambia estado a ENVIADA si todo ok) */
    public void validarYFinalizarSolicitud(SolicitudDTO solicitud) throws excepciones.SolicitudInvalidaException {
        solicitudBO.validarSolicitudCompleta(solicitud);
    }
}
