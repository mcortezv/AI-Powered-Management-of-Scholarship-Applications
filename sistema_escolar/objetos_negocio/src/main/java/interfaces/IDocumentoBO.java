package interfaces;
import dominio.*;
import dominio.enums.TipoDocumento;
import excepciones.*;

public interface IDocumentoBO {
    Documento crearDocumento(TipoDocumento tipo, Estudiante est)
            throws DocumentoInvalidoException;
}
