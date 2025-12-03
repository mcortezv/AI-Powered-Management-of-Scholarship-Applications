package tutorias.repository.documents;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.types.ObjectId;
import tutorias.dominio.enums.EstadoCita;
import tutorias.dominio.enums.Modalidad;

/**
 *
 * @author katia
 */
public class CitaDocument {
    private ObjectId _id;
    private Long id;               
    private Long matriculaAlumno;
    private Long idTutor;
    private Long idMateria;
    private String tema;
    private Modalidad modalidad;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private EstadoCita estado;
    private Instant creadoEn;

    public CitaDocument() {
    }

    public CitaDocument(ObjectId _id, Long id, Long matriculaAlumno, Long idTutor, Long idMateria, String tema, Modalidad modalidad, LocalDate fecha, LocalTime hora, String ubicacion, EstadoCita estado, Instant creadoEn) {
        this._id = _id;
        this.id = id;
        this.matriculaAlumno = matriculaAlumno;
        this.idTutor = idTutor;
        this.idMateria = idMateria;
        this.tema = tema;
        this.modalidad = modalidad;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.creadoEn = creadoEn;
    }

    public ObjectId get_id() {
        return _id;
    }

    public Long getId() {
        return id;
    }

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public String getTema() {
        return tema;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }
    
    
    
}
