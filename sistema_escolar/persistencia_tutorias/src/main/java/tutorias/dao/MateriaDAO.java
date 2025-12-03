package tutorias.dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.bson.types.ObjectId;
import tutorias.config.MongoClientProvider;
import tutorias.dao.interfaces.IMateriaDAO;
import tutorias.excepciones.MateriaDAOException;
import tutorias.repository.documents.MateriaDocument;

/**
 *
 * @author katia
 */
public class MateriaDAO implements IMateriaDAO{
    private final MongoCollection<MateriaDocument> col;
    private final MongoCollection<Document> colDoc;
    
    public MateriaDAO() {
        MongoDatabase db = MongoClientProvider.INSTANCE.database();
        this.col = db.getCollection("materias", MateriaDocument.class);
        this.colDoc = db.getCollection("materias", Document.class);
    }

    @Override
    public ObjectId create(MateriaDocument entity) throws MateriaDAOException {
        try {
            if (entity.get_id() == null) {
                entity.set_id(new ObjectId());
            }
            if (entity.getCreadoEn() == null) {
                entity.setCreadoEn(Instant.now());
            }
            col.insertOne(entity);
            return entity.get_id();
        } catch (MongoException ex) {
            throw new MateriaDAOException("Error al insertar Materia");
        }
    }

    @Override
    public List<MateriaDocument> obtenerMaterias() throws MateriaDAOException {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new MateriaDAOException("Error al consultar Materias");
        }
    }
    
}
