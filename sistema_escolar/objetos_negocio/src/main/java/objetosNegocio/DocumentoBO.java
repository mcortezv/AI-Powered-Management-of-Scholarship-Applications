package objetosNegocio;
import dominio.Documento;
import dominio.Estudiante;
import dominio.enums.TipoDocumento;
import excepciones.DocumentoInvalidoException;
import interfaces.IDocumentoBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoBO implements IDocumentoBO {

    public DocumentoBO() {}

    public Documento crearDocumento(TipoDocumento tipo, Estudiante est) {
        if (tipo == null || est == null)
            throw new DocumentoInvalidoException("Documento inválido");
        return new Documento(tipo, est);
    }
}