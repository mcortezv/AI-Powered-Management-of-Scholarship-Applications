/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dominio;
import dominio.enums.Parentesco;

/**
 *
 * @author Cortez, Manuel;
 */
public class Tutor {
    private Long id;
    private String nombre;
    private Parentesco parentesco;
    private String telefono;
    private Direccion direccion;
    private String correo;

    public Tutor() {}

    public Tutor(String nombre, Parentesco parentesco, String telefono, Direccion direccion, String correo) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Tutor(Long id, String nombre, Parentesco parentesco, String telefono, Direccion direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
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
