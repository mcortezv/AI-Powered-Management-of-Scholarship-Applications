package solicitarBeca.repository;
import org.bson.types.ObjectId;
import solicitarBeca.excepciones.SolicitudDAOException;
import solicitarBeca.repository.documents.SolicitudDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ISolicitudDAO {

    ObjectId create(SolicitudDocument entity) throws SolicitudDAOException;

}
