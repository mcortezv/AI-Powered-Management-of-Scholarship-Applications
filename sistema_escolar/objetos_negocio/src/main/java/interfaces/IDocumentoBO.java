package interfaces;
import dto.DocumentoDTO;
import excepciones.*;
import solicitarBeca.dominio.Documento;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDocumentoBO {

    Documento crearDocumento(DocumentoDTO documentoDTO) throws DocumentoInvalidoException;
}
