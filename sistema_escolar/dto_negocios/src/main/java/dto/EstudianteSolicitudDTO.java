package dto;

/**
 * @author Escalante, Sebastian.
 */
public class EstudianteSolicitudDTO {
    private int matricula;
    private String nombre;
    private TutorDTO tutor;
    private String telefono;
    private String direccion;
    private String correo;

    public EstudianteSolicitudDTO(){}

    public EstudianteSolicitudDTO(int matricula, String nombre, TutorDTO tutor, String telefono, String direccion, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tutor = tutor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TutorDTO getTutor() {
        return tutor;
    }

    public void setTutor(TutorDTO tutor) {
        this.tutor = tutor;
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
