package solicitarBeca.repository;
import org.bson.types.ObjectId;
import solicitarBeca.excepciones.EstudianteDAOException;
import solicitarBeca.repository.documents.EstudianteDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteDAO {

    ObjectId create(EstudianteDocument entity) throws EstudianteDAOException;
}
