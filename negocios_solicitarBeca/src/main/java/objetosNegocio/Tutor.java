/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;

import objetosNegocio.enums.Parentesco;

/**
 *
 * @author Cortez, Manuel;
 */
public class Tutor {
    private String nombre;
    private Parentesco parentesco;
    private String telefono;
    private String direccion;
    private String correo;

    public Tutor() {}

    public Tutor(String nombre, Parentesco parentesco, String telefono, String direccion, String correo) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
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
