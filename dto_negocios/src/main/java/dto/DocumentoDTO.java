package dto;

public class DocumentoDTO {
    private String nombreArchivo;
    private String tipoDocumento;
    private byte[] contenido;

    public DocumentoDTO() {
    }

    public DocumentoDTO(String nombreArchivo, String tipoDocumento, byte[] contenido) {
        this.nombreArchivo = nombreArchivo;
        this.tipoDocumento = tipoDocumento;
        this.contenido = contenido;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
