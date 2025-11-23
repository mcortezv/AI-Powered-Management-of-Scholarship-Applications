package interfaces;
import dominio.*;
import dto.DocumentoDTO;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDocumentoBO {

    Documento crearDocumento(DocumentoDTO documentoDTO) throws DocumentoInvalidoException;
}
