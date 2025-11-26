package solicitarBeca.repository.documents;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Carrera;

import java.time.Instant;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteDocument {
    private ObjectId _id;
    private Long matricula;
    private String nombre;
    private Carrera carrera;
    private Tutor tutor;
    private String contrasenia;
    private String telefono;
    private String direccion;
    private String correo;
    private Instant creadoEn;

    public EstudianteDocument() {}

    public EstudianteDocument(ObjectId _id,Carrera carrera, String contrasenia, String correo, String direccion, Long matricula, String nombre, String telefono, Tutor tutor, Instant  creadoEn) {
        this._id = _id;
        this.carrera = carrera;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.direccion = direccion;
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tutor = tutor;
        this.creadoEn = creadoEn;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }
}
