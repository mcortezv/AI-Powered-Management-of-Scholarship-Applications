/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudInfraestructuraDTO {
    private long id;
    private BecaInfraestructuraDTO beca;
    private EstudianteInfraestructuraDTO estudiante;
    private InformacionSocioeconomicaInfraestructuraDTO informacionSocioeconomica;
    private HistorialAcademicoInfraestructuraDTO historialAcademico;
    private List<DocumentoInfraestructuraDTO> documentos;
    private LocalDate fecha;
    private String estado;

    public SolicitudInfraestructuraDTO() {}

    public SolicitudInfraestructuraDTO(BecaInfraestructuraDTO beca, List<DocumentoInfraestructuraDTO> documentos, String estado, EstudianteInfraestructuraDTO estudiante, LocalDate fecha, HistorialAcademicoInfraestructuraDTO historialAcademico, long id, InformacionSocioeconomicaInfraestructuraDTO informacionSocioeconomica) {
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.historialAcademico = historialAcademico;
        this.id = id;
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public BecaInfraestructuraDTO getBeca() {
        return beca;
    }

    public void setBeca(BecaInfraestructuraDTO beca) {
        this.beca = beca;
    }

    public List<DocumentoInfraestructuraDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoInfraestructuraDTO> documentos) {
        this.documentos = documentos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstudianteInfraestructuraDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteInfraestructuraDTO estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HistorialAcademicoInfraestructuraDTO getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademicoInfraestructuraDTO historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformacionSocioeconomicaInfraestructuraDTO getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaInfraestructuraDTO informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }
}
