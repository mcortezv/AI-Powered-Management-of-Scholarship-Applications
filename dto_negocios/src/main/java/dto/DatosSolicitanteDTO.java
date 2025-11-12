package dto;
/**
 * @author Escalante, Sebastian.
 */
public class DatosSolicitanteDTO {
    private String nombreField;
    private String primerApellidoField;
    private String segundoApellidoField;
    private String direccionField;
    private String telefonoField;
    private String emailField;

    public DatosSolicitanteDTO(){}

    public DatosSolicitanteDTO(String nombreField, String primerApellidoField, String segundoApellidoField, String direccionField, String telefonoField, String emailField) {
        this.nombreField = nombreField;
        this.primerApellidoField = primerApellidoField;
        this.segundoApellidoField = segundoApellidoField;
        this.direccionField = direccionField;
        this.telefonoField = telefonoField;
        this.emailField = emailField;
    }

    public String getNombreField() {
        return nombreField;
    }

    public void setNombreField(String nombreField) {
        this.nombreField = nombreField;
    }

    public String getPrimerApellidoField() {
        return primerApellidoField;
    }

    public void setPrimerApellidoField(String primerApellidoField) {
        this.primerApellidoField = primerApellidoField;
    }

    public String getSegundoApellidoField() {
        return segundoApellidoField;
    }

    public void setSegundoApellidoField(String segundoApellidoField) {
        this.segundoApellidoField = segundoApellidoField;
    }

    public String getDireccionField() {
        return direccionField;
    }

    public void setDireccionField(String direccionField) {
        this.direccionField = direccionField;
    }

    public String getTelefonoField() {
        return telefonoField;
    }

    public void setTelefonoField(String telefonoField) {
        this.telefonoField = telefonoField;
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }
}
