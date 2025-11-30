package interfaces.solicitarBeca;
import bo.solicitarBeca.excepciones.DocumentoInvalidoException;
import solicitarBeca.dominio.Documento;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.TipoDocumento;
import solicitarBeca.repository.documents.DocumentoDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDocumentoBO {

    Documento crearDocumento(Long identificador, TipoDocumento tipo, byte[] contenido, Long estudiante) throws DocumentoInvalidoException;

    void guardarDocumento(DocumentoDocument documento) throws DocumentoInvalidoException;
}
