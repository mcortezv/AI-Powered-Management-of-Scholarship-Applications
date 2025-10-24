/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;

/**
 *
 * @author Cortez, Manuel;
 */
public class Estudiante {
    
    
    private Long matricula;
    private String nombre;
    private Tutor tutor;
    private String password;
    private String telefono;
    private Direccion direccion;
    private String correo;

    public Estudiante() {}

    public Estudiante(String nombre, Tutor tutor, String password, String telefono, Direccion direccion, String correo) {
        this.nombre = nombre;
        this.tutor = tutor;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Estudiante(Long matricula, String nombre, Tutor tutor, String password, String telefono, Direccion direccion, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tutor = tutor;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
