/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Cortez, Manuel;
 */
public class Estudiante {
    private Long matricula;
    private String nombre;
    private String carrera;
    private Tutor tutor;
    private String contrasenia;
    private String telefono;
    private String direccion;
    private String correo;

    public Estudiante() {}

    public Estudiante(String nombre, Tutor tutor, String contrasenia, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.tutor = tutor;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Estudiante(Long matricula, String nombre, Tutor tutor, String contrasenia, String telefono, String direccion, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tutor = tutor;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String password) {
        this.contrasenia = password;
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
