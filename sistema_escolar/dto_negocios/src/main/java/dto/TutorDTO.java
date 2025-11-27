package dto;

/**
 * @author Escalante, Sebastian.
 */
public class TutorDTO {
    private String nombre;
    private String parentesco;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String telefono;
    private String correo;
    private String direccion;

    public TutorDTO() {
    }

    public TutorDTO(String nombre, String parentesco, String apellidoMaterno, String apellidoPaterno, String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
