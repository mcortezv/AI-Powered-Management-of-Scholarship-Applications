package dto;
/**
 * @author Escalante, Sebastian.
 */
public class EstudianteResponseDTO {
    private int matricula;
    private String nombre;
    private String carrera;
    private String telefono;
    private DireccionDTO direccion;
    private String correo;
    private double promedio;

    public EstudianteResponseDTO() {
    }

    public EstudianteResponseDTO(int matricula, String nombre, String carrera, String telefono, DireccionDTO direccion, String correo, double promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.promedio = promedio;
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

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

}
