package itson.org.dto;

/**
 * @author Escalante, Sebastian.
 */
public class LoginDTOI {
    private Long usuario;
    private String contrasenia;

    public LoginDTOI() {
    }

    public LoginDTOI(Long usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
