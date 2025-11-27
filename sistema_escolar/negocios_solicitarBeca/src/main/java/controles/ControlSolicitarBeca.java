package controles;
import adaptadores.solicitarBeca.*;
import dto.*;
import excepciones.SolicitarBecaException;
import interfaces.solicitarBeca.*;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.*;
import solicitarBeca.dominio.enums.Carrera;
import solicitarBeca.dominio.enums.Parentesco;
import solicitarBeca.dominio.enums.TipoVivienda;
import solicitarBeca.repository.documents.DocumentoDocument;
import solicitarBeca.repository.documents.EstudianteDocument;
import solicitarBeca.repository.documents.SolicitudDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Cortez, Manuel;
 */
public class ControlSolicitarBeca {
    private final ISolicitudBO solicitudBO;
    private final IEstudianteBO estudianteBO;
    private final ITutorBO tutorBO;
    private final IBecasFiltradasBO becasFiltradasBO;
    private final IDocumentoBO documentoBO;
    private final IHistorialAcademicoBO historialBO;
    private final IInformacionSocioeconomicaBO socioBO;
    private BecasFiltradas becasFiltradas;
    private Beca becaActual;
    private Estudiante estudiante;
    private Solicitud solicitudActual;

    public ControlSolicitarBeca(ISolicitudBO solicitudBO,
                                IEstudianteBO estudianteBO,
                                ITutorBO tutorBO,
                                IBecasFiltradasBO becaBO,
                                IDocumentoBO documentoBO,
                                IHistorialAcademicoBO historialBO,
                                IInformacionSocioeconomicaBO socioBO) {
        this.solicitudBO = Objects.requireNonNull(solicitudBO);
        this.estudianteBO = Objects.requireNonNull(estudianteBO);
        this.tutorBO = Objects.requireNonNull(tutorBO);
        this.becasFiltradasBO = Objects.requireNonNull(becaBO);
        this.documentoBO = Objects.requireNonNull(documentoBO);
        this.historialBO = Objects.requireNonNull(historialBO);
        this.socioBO = Objects.requireNonNull(socioBO);
    }

    public void iniciarSolicitud() throws SolicitarBecaException {
        try {
            this.solicitudActual = solicitudBO.crearSolicitud(becaActual);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitosDTO) throws SolicitarBecaException {
        try {
            this.becasFiltradas = BecasFiltradasAdaptador.toEntity(becasFiltradasBO.obtenerBecasFiltradas(requisitosDTO)) ;
            return BecasFiltradasAdaptador.toDTO(becasFiltradas);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public BecaDTO obtenerBecaPorId(Long id) throws SolicitarBecaException {
        try {
            becaActual = becasFiltradasBO.obtenerBecaPorCodigo(id, becasFiltradas);
            return BecaAdaptador.toDTO(becaActual);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public EstudianteDTO obtenerEstudiante(Long id) throws SolicitarBecaException {
        try {
            EstudianteResponseDTO estudianteResponseDTO = estudianteBO.crearEstudiante(id);
            estudiante = EstudianteAdaptador.toEntity(estudianteResponseDTO);
            return EstudianteAdaptador.toDTO(estudianteResponseDTO);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public void asignarHistorial(HistorialAcademicoDTO historialAcademicoDTO) throws SolicitarBecaException {
        try {
            HistorialAcademico historialAcademico = HistorialAcademicoAdaptador.toEntity(historialBO.crearHistorial(estudiante.getMatricula()));
            historialAcademico.setCarrera(Carrera.valueOf(historialAcademicoDTO.getCarrera()));
            historialAcademico.setCargaAcademica(historialAcademicoDTO.getCargaAcademica());
            historialAcademico.setSemestre(historialAcademicoDTO.getSemestre());
            solicitudActual.setHistorialAcademico(historialAcademico);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public void asignarTutor(TutorDTO tutorDTO) throws SolicitarBecaException {
        try {
            if (tutorDTO.getNombre() == null || tutorDTO.getNombre().equals("")) {}
            Tutor tutor = tutorBO.crearTutor(tutorDTO.getNombre(), Parentesco.valueOf(tutorDTO.getParentesco()), tutorDTO.getTelefono(), tutorDTO.getDireccion(), tutorDTO.getCorreo());
            estudiante.setTutor(tutor);
            solicitudActual.setEstudiante(estudiante);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitarBecaException {
        try {
            if (informacionSocioeconomica == null) {

            }
            InformacionSocioeconomica infoSocio = socioBO.crearInformacionSocioeconomica(informacionSocioeconomica.getIngresoTotalFamilarMensual(), TipoVivienda.valueOf(informacionSocioeconomica.getTipoVivienda()), informacionSocioeconomica.isTrabajo(), informacionSocioeconomica.isDeudas());
            solicitudActual.setInformacionSocioeconomica(infoSocio);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public void asignarDocumentos(List<DocumentoDTO> documentosDTO) throws SolicitarBecaException {
        try {
            List<Documento>  documentos = new ArrayList<>();
            for (DocumentoDTO documentoDTO : documentosDTO) {
                documentos.add(DocumentoAdaptador.toEntity(documentoDTO));
            }
            solicitudActual.setDocumentos(documentos);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public SolicitudDTO obtenerSolicitudActual() throws SolicitarBecaException {
        try {
            return SolicitudAdaptador.toDTO(solicitudActual);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public boolean guardarSolicitud() throws SolicitarBecaException {
        try {
            solicitudBO.validarSolicitudCompleta(solicitudActual);
            solicitudBO.enviarSolicitud(SolicitudAdaptador.toDTO(solicitudActual));
            EstudianteDocument estudianteDocument = EstudianteAdaptador.toDocument(solicitudActual.getEstudiante());
            estudianteBO.guardarEstudiante(estudianteDocument);
            List<ObjectId> documentos = new ArrayList<>();
            for (Documento documento : solicitudActual.getDocumentos()) {
                DocumentoDocument documentoDocument = DocumentoAdaptador.toDocument(documento, estudianteDocument.get_id());
                documentos.add(documentoDocument.get_id());
                documentoBO.guardarDocumento(documentoDocument);
            }
            SolicitudDocument solicitudDocument = SolicitudAdaptador.toDocument(solicitudActual, estudianteDocument.get_id(), documentos);
            solicitudBO.guardarSolicitud(solicitudDocument);
            return true;
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }

    public void cancelarSolicitud() throws SolicitarBecaException {
        try {
            solicitudActual.setBeca(null);
        } catch (Exception ex) {
            throw new SolicitarBecaException(ex.getMessage());
        }
    }
}
