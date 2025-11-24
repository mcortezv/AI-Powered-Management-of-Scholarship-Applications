/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteInfraestructuraDTO {
    private Long matricula;
    private String nombre;
    private String carrera;
    private TutorInfraestructuraDTO tutor;
    private String contrasenia;
    private String telefono;
    private String direccion;
    private String correo;

    public EstudianteInfraestructuraDTO() {}

    public EstudianteInfraestructuraDTO(String carrera, String contrasenia, String correo, String direccion, Long matricula, String nombre, String telefono, TutorInfraestructuraDTO tutor) {
        this.carrera = carrera;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.direccion = direccion;
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tutor = tutor;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
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

    public TutorInfraestructuraDTO getTutor() {
        return tutor;
    }

    public void setTutor(TutorInfraestructuraDTO tutor) {
        this.tutor = tutor;
    }
}
