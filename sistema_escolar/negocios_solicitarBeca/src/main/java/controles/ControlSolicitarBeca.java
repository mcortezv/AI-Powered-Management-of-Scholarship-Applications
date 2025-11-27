package controles;
import adaptadores.*;
import dto.*;
import excepciones.*;
import interfaces.*;
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
    private final IHistorialAcademicoBO  historialBO;
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

    public void iniciarSolicitud() throws SolicitudInvalidaException {
        this.solicitudActual = solicitudBO.crearSolicitud(becaActual);
    }

    public BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitosDTO) throws BecaInvalidaException {
        this.becasFiltradas = BecasFiltradasAdaptador.toEntity(becasFiltradasBO.obtenerBecasFiltradas(requisitosDTO)) ;
        return BecasFiltradasAdaptador.toDTO(becasFiltradas);
    }

    public BecaDTO obtenerBecaPorId(Long id) throws BecaInvalidaException {
        becaActual = becasFiltradasBO.obtenerBecaPorCodigo(id, becasFiltradas);
        return BecaAdaptador.toDTO(becaActual);
    }

    public EstudianteDTO obtenerEstudiante(Long id) throws SolicitudInvalidaException {
        EstudianteResponseDTO estudianteResponseDTO = estudianteBO.crearEstudiante(id);
        estudiante = EstudianteAdaptador.toEntity(estudianteResponseDTO);
        return EstudianteAdaptador.toDTO(estudianteResponseDTO);
    }

    public void asignarHistorial(HistorialAcademicoDTO historialAcademicoDTO) throws SolicitudInvalidaException {
        HistorialAcademico historialAcademico = HistorialAcademicoAdaptador.toEntity(historialBO.crearHistorial(estudiante.getMatricula()));
        historialAcademico.setCarrera(Carrera.valueOf(historialAcademicoDTO.getCarrera()));
        historialAcademico.setCargaAcademica(historialAcademicoDTO.getCargaAcademica());
        historialAcademico.setSemestre(historialAcademicoDTO.getSemestre());
        solicitudActual.setHistorialAcademico(historialAcademico);
    }

    public void asignarTutor(TutorDTO tutorDTO) throws SolicitudInvalidaException {
        if (tutorDTO.getNombre() == null || tutorDTO.getNombre().equals("")) {}
        Tutor tutor = tutorBO.crearTutor(tutorDTO.getNombre(), Parentesco.valueOf(tutorDTO.getParentesco()), tutorDTO.getTelefono(), tutorDTO.getDireccion(), tutorDTO.getCorreo());
        estudiante.setTutor(tutor);
        solicitudActual.setEstudiante(estudiante);
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) throws SolicitudInvalidaException {
        if (informacionSocioeconomica == null) {

        }
        InformacionSocioeconomica infoSocio = socioBO.crearInformacionSocioeconomica(informacionSocioeconomica.getIngresoTotalFamilarMensual(), TipoVivienda.valueOf(informacionSocioeconomica.getTipoVivienda()), informacionSocioeconomica.isTrabajo(), informacionSocioeconomica.isDeudas());
        solicitudActual.setInformacionSocioeconomica(infoSocio);
    }

    public void asignarDocumentos(List<DocumentoDTO> documentosDTO) throws SolicitudInvalidaException {
        List<Documento>  documentos = new ArrayList<>();
        for (DocumentoDTO documentoDTO : documentosDTO) {
            documentos.add(DocumentoAdaptador.toEntity(documentoDTO));
        }
        solicitudActual.setDocumentos(documentos);
    }

    public SolicitudDTO obtenerSolicitudActual(){
        return SolicitudAdaptador.toDTO(solicitudActual);
    }

    public boolean guardarSolicitud(){
        solicitudBO.validarSolicitudCompleta(solicitudActual);
        solicitudBO.enviarSolicitud(SolicitudAdaptador.toDTO(solicitudActual));
        SolicitudDocument solicitudDocument = SolicitudAdaptador.toDocument(solicitudActual);
        solicitudBO.guardarSolicitud(solicitudDocument);
        EstudianteDocument estudianteDocument = EstudianteAdaptador.toDocument(solicitudActual.getEstudiante());
        estudianteBO.guardarEstudiante(estudianteDocument);
        for (Documento documento : solicitudActual.getDocumentos()) {
            DocumentoDocument documentoDocument = DocumentoAdaptador.toDocument(documento);
            documentoBO.guardarDocumento(documentoDocument);
        }
        return true;
    }

    public void cancelarSolicitud(){
        solicitudActual.setBeca(null);
    }
}
