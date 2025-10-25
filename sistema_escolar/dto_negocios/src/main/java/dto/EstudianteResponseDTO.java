package dto;

public class EstudianteResponseDTO {
    private int matricula;
    private String nombre;
    private String carrera;
    private String telefono;
    private String direccion;
    private String correo;
    private double promedio;
    private String estatus;

    public EstudianteResponseDTO() {
    }

    public EstudianteResponseDTO(String estatus, double promedio, String correo, String direccion, String telefono, String carrera, String nombre, int matricula) {
        this.estatus = estatus;
        this.promedio = promedio;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
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

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
