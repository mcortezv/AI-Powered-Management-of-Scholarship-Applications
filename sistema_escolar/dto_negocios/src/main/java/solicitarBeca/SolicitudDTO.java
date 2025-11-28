package solicitarBeca;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public class SolicitudDTO {
    private Long id;
    private BecaDTO beca;
    private EstudianteDTO estudiante;
    private InformacionSocioeconomicaDTO informacionSocioeconomica;
    private HistorialAcademicoDTO historialAcademico;
    private List<DocumentoDTO> documentos;
    private LocalDate fecha;
    private String estado;

    public SolicitudDTO() {
    }

    public SolicitudDTO(BecaDTO beca, List<DocumentoDTO> documentos, String estado, EstudianteDTO estudiante, LocalDate fecha, HistorialAcademicoDTO historialAcademico, Long id, InformacionSocioeconomicaDTO informacionSocioeconomica) {
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.historialAcademico = historialAcademico;
        this.id = id;
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public BecaDTO getBeca() {
        return beca;
    }

    public void setBeca(BecaDTO beca) {
        this.beca = beca;
    }

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HistorialAcademicoDTO getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademicoDTO historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacionSocioeconomicaDTO getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }
}
