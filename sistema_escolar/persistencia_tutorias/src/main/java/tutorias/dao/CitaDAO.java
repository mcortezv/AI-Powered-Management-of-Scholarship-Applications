/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorias.dao;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.bson.types.ObjectId;
import tutorias.config.MongoClientProvider;
import tutorias.dao.interfaces.ICitaDAO;
import tutorias.excepciones.CitaDAOException;
import tutorias.repository.documents.CitaDocument;

/**
 *
 * @author katia
 */
public class CitaDAO implements ICitaDAO {

    private final MongoCollection<CitaDocument> col;
    private final MongoCollection<Document> colDoc;
    
    public CitaDAO() {
        MongoDatabase db = MongoClientProvider.INSTANCE.database();
        this.col = db.getCollection("citas", CitaDocument.class);
        this.colDoc = db.getCollection("citas", Document.class);
    }
    
    @Override
    public ObjectId create(CitaDocument entity) throws CitaDAOException {
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
            throw new CitaDAOException("Error al insertar Cita");
        }
    }

    @Override
    public List<CitaDocument> obtenerHistorialPorFecha(Long matriculaAlumno, LocalDate fecha) throws CitaDAOException {
        try {
            return col.find(
                    and(eq("matriculaAlumno", matriculaAlumno),
                        eq("fecha", fecha))
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar historial por fecha");
        }
    }

    @Override
    public List<CitaDocument> obtenerHistorialPorMateria(Long matriculaAlumno, Long idMateria) throws CitaDAOException {
        try {
            return col.find(
                    and(eq("matriculaAlumno", matriculaAlumno),
                        eq("idMateria", idMateria))
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar historial por materia");
        }
    }

    @Override
    public List<CitaDocument> obtenerHistorialPorFechaYMateria(Long matriculaAlumno, LocalDate fecha, Long idMateria) throws CitaDAOException {
        try {
            return col.find(
                    and(eq("matriculaAlumno", matriculaAlumno),
                        eq("fecha", fecha),
                        eq("idMateria", idMateria))
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar historial por fecha y materia");
        }
    }

    @Override
    public List<CitaDocument> obtenerHistorialCompletoAlumno(Long matriculaAlumno) throws CitaDAOException {
        try {
            return col.find(
                    eq("matriculaAlumno", matriculaAlumno)
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar historial completo del alumno");
        }
    }

    @Override
    public List<CitaDocument> obtenerFuturasPorAlumno(Long matriculaAlumno) throws CitaDAOException {
        try {
            return col.find(
                    and(eq("matriculaAlumno", matriculaAlumno),
                        gte("fecha", LocalDate.now()))
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar citas futuras del alumno");
        }
    }
    
}
