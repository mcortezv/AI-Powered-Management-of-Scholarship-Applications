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
    private EstudianteSolicitudDTO estudiante;
    private BecaDTO beca;
    private InformacionSocioeconomicaDTO informacionSocioeconomica;
    private HistAcademicoDTO historialAcademico;
    private List<DocumentoDTO> documentos;

    public SolicitudDTO() {
    }
    
    public SolicitudDTO(BecaDTO beca, InformacionSocioeconomicaDTO informacionSocioeconomica, HistAcademicoDTO historialAcademico) {
        this.beca = beca;
        this.informacionSocioeconomica = informacionSocioeconomica;
        this.historialAcademico = historialAcademico;
    }    

    public SolicitudDTO(long id, String estado, LocalDate fechaSolicitud, EstudianteSolicitudDTO estudiante, BecaDTO beca, InformacionSocioeconomicaDTO informacionSocioeconomica, HistAcademicoDTO historialAcademico, List<DocumentoDTO> documentos) {
        this.id = id;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.estudiante = estudiante;
        this.beca = beca;
        this.informacionSocioeconomica = informacionSocioeconomica;
        this.historialAcademico = historialAcademico;
        this.documentos = documentos;
    }



    public SolicitudDTO(LocalDate fechaSolicitud, EstudianteSolicitudDTO estudiante, BecaDTO beca, InformacionSocioeconomicaDTO informacionSocioeconomica, HistAcademicoDTO historialAcademico) {
        this.fechaSolicitud = fechaSolicitud;
        this.estudiante = estudiante;
        this.beca = beca;
        this.informacionSocioeconomica = informacionSocioeconomica;
        this.historialAcademico = historialAcademico;
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

    public EstudianteSolicitudDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteSolicitudDTO estudiante) {
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

    public HistAcademicoDTO getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistAcademicoDTO historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }
}
