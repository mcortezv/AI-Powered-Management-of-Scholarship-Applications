package solicitarBeca.repository.dao;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import solicitarBeca.config.MongoClientProvider;
import solicitarBeca.excepciones.DocumentoDAOException;
import solicitarBeca.repository.ISolicitudDAO;
import solicitarBeca.repository.documents.SolicitudDocument;
import java.time.Instant;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudDAO implements ISolicitudDAO {
    private final MongoCollection<SolicitudDocument> col;
    private final MongoCollection<Document> colDoc;

    public SolicitudDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("solicitudes", SolicitudDocument.class);
        this.colDoc = MongoClientProvider.INSTANCE.getCollection("solicitudes", Document.class);
    }

    public ObjectId create(SolicitudDocument entity) throws DocumentoDAOException {
        try {
            if (entity.get_id() == null) {
                entity.set_id(new ObjectId());
            }
            entity.setCreadoEn(Instant.now());
            col.insertOne(entity);
            return entity.get_id();
        } catch (MongoException ex) {
            throw new DocumentoDAOException("Error al insertar Solicitud");
        }
    }
}
