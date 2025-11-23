package dto;
import dominio.Estudiante;
import dominio.enums.TipoDocumento;

/**
 * @author Escalante, Sebastian.
 */
public class DocumentoDTO {
    private Long identificador;
    private TipoDocumento tipo;
    private byte[] contenido;
    private Estudiante estudiante;

    public DocumentoDTO() {
    }

    public DocumentoDTO(byte[] contenido, Estudiante estudiante, Long identificador, TipoDocumento tipo) {
        this.contenido = contenido;
        this.estudiante = estudiante;
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
}
