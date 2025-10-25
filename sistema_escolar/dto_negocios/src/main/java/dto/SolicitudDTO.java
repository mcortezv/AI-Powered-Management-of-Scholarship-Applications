package dto;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public class SolicitudDTO {
    private long id;
    private String estado;
    private LocalDate fechaSolicitud;
    private EstudianteResponseDTO estudiante;
    private BecaDTO beca;
    private InformacionSocioeconomicaDTO informacionSocioeconomica;
    private HistorialAcademicoDTO historialAcademico;
    private List<DocumentoDTO> documentos;

    public SolicitudDTO() {
    }

    public SolicitudDTO(long id, String estado, LocalDate fechaSolicitud, EstudianteResponseDTO estudiante, BecaDTO beca, InformacionSocioeconomicaDTO informacionSocioeconomica, HistorialAcademicoDTO historialAcademico, List<DocumentoDTO> documentos) {
        this.id = id;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.estudiante = estudiante;
        this.beca = beca;
        this.informacionSocioeconomica = informacionSocioeconomica;
        this.historialAcademico = historialAcademico;
        this.documentos = documentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstudianteResponseDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteResponseDTO estudiante) {
        this.estudiante = estudiante;
    }

    public BecaDTO getBeca() {
        return beca;
    }

    public void setBeca(BecaDTO beca) {
        this.beca = beca;
    }

    public InformacionSocioeconomicaDTO getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public HistorialAcademicoDTO getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademicoDTO historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }
}
