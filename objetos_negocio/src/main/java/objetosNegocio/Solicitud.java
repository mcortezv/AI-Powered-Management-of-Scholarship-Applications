/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;
import objetosNegocio.enums.EstadoSolicitud;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class Solicitud {
    private long id;
    private Beca beca;
    private Estudiante estudiante;
    private EstadoSolicitud estado;
    private List<Documento> documentos;
    private InformacionSocioeconomica informacionSocioeconomica;
    private HistorialAcademico historialAcademico;

    public Solicitud() {}

    public Solicitud(Beca beca, Estudiante estudiante, EstadoSolicitud estado, List<Documento> documentos, InformacionSocioeconomica informacionSocioeconomica, HistorialAcademico historialAcademico) {
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.historialAcademico = historialAcademico;
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

    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademico historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public InformacionSocioeconomica getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomica informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }
}
