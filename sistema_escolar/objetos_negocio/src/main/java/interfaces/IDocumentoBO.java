package interfaces;
import excepciones.*;
import solicitarBeca.dominio.Documento;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.TipoDocumento;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDocumentoBO {

    Documento crearDocumento(Long identificador, TipoDocumento tipo, byte[] contenido, Estudiante estudiante) throws DocumentoInvalidoException;
}
