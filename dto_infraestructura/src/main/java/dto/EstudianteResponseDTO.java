package dto;

/**
 * @author Escalante, Sebastian.
 */
public class EstudianteResponseDTO {
    private int matricula;
    private String nombre;
    private String carrera;
    private String telefono;
    private String direccion;
    private String correo;

    public EstudianteResponseDTO() {
    }

    public EstudianteResponseDTO(String carrera, String correo, String direccion, int matricula, String nombre, String telefono) {
        this.carrera = carrera;
        this.correo = correo;
        this.direccion = direccion;
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
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
