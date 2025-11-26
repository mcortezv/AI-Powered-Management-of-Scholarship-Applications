package solicitarBeca.repository.documents;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.*;
import solicitarBeca.dominio.enums.EstadoSolicitud;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDocument {
    private ObjectId _id;
    private Long id;
    private Beca beca;
    private ObjectId estudiante;
    private InformacionSocioeconomica informacionSocioeconomica;
    private HistorialAcademico historialAcademico;
    private List<ObjectId> documentos;
    private LocalDate fecha;
    private EstadoSolicitud estado;
    private Instant creadoEn;

    public SolicitudDocument() {}

    public SolicitudDocument(ObjectId _id, Beca beca, List<ObjectId> documentos, EstadoSolicitud estado, ObjectId estudiante, LocalDate fecha, HistorialAcademico historialAcademico, Long id, InformacionSocioeconomica informacionSocioeconomica, Instant  creadoEn) {
        this._id = _id;
        this.beca = beca;
        this.documentos = documentos;
        this.estado = estado;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.historialAcademico = historialAcademico;
        this.id = id;
        this.informacionSocioeconomica = informacionSocioeconomica;
        this.creadoEn = creadoEn;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Beca getBeca() {
        return beca;
    }

    public void setBeca(Beca beca) {
        this.beca = beca;
    }

    public List<ObjectId> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<ObjectId> documentos) {
        this.documentos = documentos;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public ObjectId getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ObjectId estudiante) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformacionSocioeconomica getInformacionSocioeconomica() {
        return informacionSocioeconomica;
    }

    public void setInformacionSocioeconomica(InformacionSocioeconomica informacionSocioeconomica) {
        this.informacionSocioeconomica = informacionSocioeconomica;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }
}
