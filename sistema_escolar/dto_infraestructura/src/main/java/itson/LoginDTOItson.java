package itson;

/**
 * @author Escalante, Sebastian.
 */
public class LoginDTOItson {
    private Long usuario;
    private String contrasenia;

    public LoginDTOItson() {
    }

    public LoginDTOItson(Long usuario, String contrasenia) {
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
