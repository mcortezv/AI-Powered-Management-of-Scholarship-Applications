/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.bson.types.ObjectId;
import tutorias.config.MongoClientProvider;
import tutorias.dao.interfaces.ITutorDAO;
import tutorias.excepciones.TutorDAOException;
import tutorias.repository.documents.TutorDocument;

/**
 *
 * @author katia
 */
public class TutorDAO implements ITutorDAO{
    private final MongoCollection<TutorDocument> col;
    private final MongoCollection<Document> colDoc;

    public TutorDAO() {
        MongoDatabase db = MongoClientProvider.INSTANCE.database();
        this.col = db.getCollection("tutores", TutorDocument.class);
        this.colDoc = db.getCollection("tutores", Document.class);
    }

    @Override
    public List<TutorDocument> obtenerTutores() throws TutorDAOException {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new TutorDAOException("Error al consultar tutores");
        }
    }

    @Override
    public TutorDocument obtenerPorId(Long idTutor) throws TutorDAOException {
        try {
            TutorDocument tutor = col.find(eq("idTutor", idTutor)).first();
            if (tutor == null) {
                throw new TutorDAOException("No se encontró el tutor con id " + idTutor);
            }
            return tutor;
        } catch (MongoException ex) {
            throw new TutorDAOException("Error al consultar tutor por id");
        }
    }

    @Override
    public ObjectId create(TutorDocument entity) throws TutorDAOException {
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
            throw new TutorDAOException("Error al insertar Tutor");
        }
    }
}
