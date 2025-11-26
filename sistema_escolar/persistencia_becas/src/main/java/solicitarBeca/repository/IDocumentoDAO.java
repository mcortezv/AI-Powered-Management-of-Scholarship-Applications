package solicitarBeca.repository;
import org.bson.types.ObjectId;
import solicitarBeca.excepciones.DocumentoDAOException;
import solicitarBeca.repository.documents.DocumentoDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IDocumentoDAO {

    ObjectId create(DocumentoDocument entity) throws DocumentoDAOException;
}
