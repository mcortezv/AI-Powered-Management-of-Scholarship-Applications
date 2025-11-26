package solicitarBeca.repository.dao;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import solicitarBeca.config.MongoClientProvider;
import solicitarBeca.excepciones.DocumentoDAOException;
import solicitarBeca.repository.IEstudianteDAO;
import solicitarBeca.repository.documents.EstudianteDocument;
import java.time.Instant;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteDAO implements IEstudianteDAO {
    private final MongoCollection<EstudianteDocument> col;
    private final MongoCollection<Document> colDoc;

    public EstudianteDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("estudiantes", EstudianteDocument.class);
        this.colDoc = MongoClientProvider.INSTANCE.getCollection("estudiantes", Document.class);
    }

    public ObjectId create(EstudianteDocument entity) throws DocumentoDAOException {
        try {
            if (entity.get_id() == null) {
                entity.set_id(new ObjectId());
            }
            entity.setCreadoEn(Instant.now());
            col.insertOne(entity);
            return entity.get_id();
        } catch (MongoException ex) {
            throw new DocumentoDAOException("Error al insertar Estudiante");
        }
    }
}
