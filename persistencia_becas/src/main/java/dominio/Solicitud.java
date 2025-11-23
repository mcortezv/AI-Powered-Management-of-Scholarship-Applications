/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import dominio.enums.EstadoSolicitud;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class Solicitud {
    private long id;
    private Beca beca;
    private Estudiante estudiante;
    private InformacionSocioeconomica informacionSocioeconomica;
    private HistorialAcademico historialAcademico;
    private List<Documento> documentos;
    private LocalDate fecha;
    private EstadoSolicitud estado;

    public Solicitud() {}

    public Solicitud(Beca beca, List<Documento> documentos, EstadoSolicitud estado, Estudiante estudiante, LocalDate fecha, HistorialAcademico historialAcademico, long id, InformacionSocioeconomica informacionSocioeconomica) {
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.historialAcademico = historialAcademico;
        this.id = id;
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public Beca getBeca() {
        return beca;
    }

    public void setBeca(Beca beca) {
        this.beca = beca;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademico historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformacionSocioeconomica getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomica informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }
}
