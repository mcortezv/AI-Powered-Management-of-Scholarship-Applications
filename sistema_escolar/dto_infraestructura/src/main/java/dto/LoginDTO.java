package dto;

/**
 * @author Escalante, Sebastian.
 */
public class LoginDTO {
    private Long usuario;
    private String contrasenia;

    public LoginDTO() {
    }

    public LoginDTO(Long usuario, String contrasenia) {
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
