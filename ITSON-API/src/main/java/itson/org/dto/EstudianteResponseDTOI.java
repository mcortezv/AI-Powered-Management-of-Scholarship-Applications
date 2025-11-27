package itson.org.dto;
import itson.org.domain.Carrera;

/**
 * @author Escalante, Sebastian.
 */
public class EstudianteResponseDTOI {
    private Long matricula;
    private String nombre;
    private Carrera carrera;
    private String telefono;
    private String direccion;
    private String correo;

    public EstudianteResponseDTOI() {
    }

    public EstudianteResponseDTOI(Carrera carrera, String correo, String direccion, Long matricula, String nombre, String telefono) {
        this.carrera = carrera;
        this.correo = correo;
        this.direccion = direccion;
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
