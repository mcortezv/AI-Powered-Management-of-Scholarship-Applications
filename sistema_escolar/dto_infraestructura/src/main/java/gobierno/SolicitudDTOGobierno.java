/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gobierno;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDTOGobierno {
    private long id;
    private BecaDTOGobierno beca;
    private EstudianteDTOGobierno estudiante;
    private InformacionSocioeconomicaDTOGobierno informacionSocioeconomica;
    private HistorialAcademicoDTOGobierno historialAcademico;
    private List<DocumentoDTOGobierno> documentos;
    private LocalDate fecha;
    private String estado;

    public SolicitudDTOGobierno() {}

    public SolicitudDTOGobierno(BecaDTOGobierno beca, List<DocumentoDTOGobierno> documentos, String estado, EstudianteDTOGobierno estudiante, LocalDate fecha, HistorialAcademicoDTOGobierno historialAcademico, long id, InformacionSocioeconomicaDTOGobierno informacionSocioeconomica) {
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.historialAcademico = historialAcademico;
        this.id = id;
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public BecaDTOGobierno getBeca() {
        return beca;
    }

    public void setBeca(BecaDTOGobierno beca) {
        this.beca = beca;
    }

    public List<DocumentoDTOGobierno> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTOGobierno> documentos) {
        this.documentos = documentos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstudianteDTOGobierno getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTOGobierno estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HistorialAcademicoDTOGobierno getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademicoDTOGobierno historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformacionSocioeconomicaDTOGobierno getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomicaDTOGobierno informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }
}
