package objetosNegocio;
import adaptadores.DocumentoAdaptador;
import dominio.Documento;
import dto.DocumentoDTO;
import excepciones.DocumentoInvalidoException;
import interfaces.IDocumentoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoBO implements IDocumentoBO {

    public DocumentoBO() {}

    @Override
    public Documento crearDocumento(DocumentoDTO dto) throws DocumentoInvalidoException {
        if (dto.getIdentificador() == null || dto.getTipo() == null || dto.getEstudiante() == null || dto.getContenido() == null) {
            throw new DocumentoInvalidoException("Documento inválido");
        }
        return DocumentoAdaptador.toEntity(dto);
    }
}