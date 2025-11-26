package solicitarBeca.repository.documents;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.enums.TipoDocumento;
import java.time.Instant;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoDocument {
    private ObjectId _id;
    private Long identificador;
    private TipoDocumento tipo;
    private byte[] contenido;
    private ObjectId estudiante;
    private Instant creadoEn;

    public DocumentoDocument() {}

    public DocumentoDocument(byte[] contenido, ObjectId estudiante, Long identificador, TipoDocumento tipo, Instant  creadoEn) {
        this.contenido = contenido;
        this.estudiante = estudiante;
        this.identificador = identificador;
        this.tipo = tipo;
        this.creadoEn = creadoEn;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public ObjectId getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ObjectId estudiante) {
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

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }
}
