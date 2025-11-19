package controles;
import dominio.*;
import excepciones.*;
import interfaces.*;
import java.util.List;
import java.util.Objects;


public class ControlSolicitud {
    private final ISolicitudBO solicitudBO;
    private final IEstudianteBO estudianteBO;
    private final ITutorBO tutorBO;
    private final IBecaBO becaBO;
    private final IDocumentoBO documentoBO;
    private final IHistorialAcademicoBO  historialBO;
    private final IInformacionSocioeconomicaBO socioBO;

    public ControlSolicitud(ISolicitudBO solicitudBO,
                                IEstudianteBO estudianteBO,
                                ITutorBO tutorBO,
                                IBecaBO becaBO,
                                IDocumentoBO documentoBO,
                                IHistorialAcademicoBO historialBO,
                                IInformacionSocioeconomicaBO socioBO) {
        this.solicitudBO = Objects.requireNonNull(solicitudBO);
        this.estudianteBO = Objects.requireNonNull(estudianteBO);
        this.tutorBO = Objects.requireNonNull(tutorBO);
        this.becaBO = Objects.requireNonNull(becaBO);
        this.documentoBO = Objects.requireNonNull(documentoBO);
        this.historialBO = Objects.requireNonNull(historialBO);
        this.socioBO = Objects.requireNonNull(socioBO);
    }

    public Solicitud iniciarSolicitud() throws SolicitudInvalidaException {
        return solicitudBO.crearSolicitudVacia();
    }

    public void asignarEstudiante(Solicitud solicitud, Estudiante estudiante) throws SolicitudInvalidaException {
        solicitudBO.asignarEstudiante(solicitud, estudiante);
    }

    public void asignarBeca(Solicitud solicitud, Beca beca) throws SolicitudInvalidaException {
        solicitudBO.asignarBeca(solicitud, beca);
    }

    public void asignarDocumentos(Solicitud solicitud, List<Documento> documentos) throws SolicitudInvalidaException {
        solicitudBO.asignarDocumentos(solicitud, documentos);
    }

    public void asignarHistorial(Solicitud solicitud, HistorialAcademico historialAcademico) throws SolicitudInvalidaException {
        solicitudBO.asignarHistorial(solicitud, historialAcademico);
    }

    public void asignarSocioeconomico(Solicitud solicitud, InformacionSocioeconomica informacionSocioeconomica) throws SolicitudInvalidaException {
        solicitudBO.asignarSocioeconomico(solicitud, informacionSocioeconomica);
    }

    public void validarYFinalizarSolicitud(Solicitud solicitud) throws SolicitudInvalidaException {
        solicitudBO.validarSolicitudCompleta(solicitud);
    }
}
