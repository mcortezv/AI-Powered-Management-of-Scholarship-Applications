package dto;

import enums.Parentesco;

/**
 * @author Escalante, Sebastian.
 */
public class TutorDTO {
    private String nombre;
    private Parentesco parentesco;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String telefono;
    private String correo;

    public TutorDTO() {
    }

    public TutorDTO(String nombre, Parentesco parentesco, String apellidoMaterno, String apellidoPaterno, String telefono, String correo) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.telefono = telefono;
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


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    


}
