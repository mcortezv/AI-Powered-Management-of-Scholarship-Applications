package objetosNegocio;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.TipoDocumento;
import solicitarBeca.repository.IDocumentoDAO;
import solicitarBeca.dominio.Documento;
import excepciones.DocumentoInvalidoException;
import interfaces.IDocumentoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoBO implements IDocumentoBO {
    private final IDocumentoDAO documentoDAO;

    public DocumentoBO(IDocumentoDAO documentoDAO) {
        this.documentoDAO = documentoDAO;
    }

    @Override
    public Documento crearDocumento(Long identificador, TipoDocumento tipo, byte[] contenido, Estudiante estudiante) throws DocumentoInvalidoException {
        if (identificador == null || tipo == null || estudiante == null || contenido == null) {
            throw new DocumentoInvalidoException("Documento inválido");
        }
        return new Documento(contenido, estudiante, identificador, tipo);
    }
}