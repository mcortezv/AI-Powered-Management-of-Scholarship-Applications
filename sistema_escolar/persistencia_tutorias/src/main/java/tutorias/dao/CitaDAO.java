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
import static com.mongodb.client.model.Filters.lte;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import static com.mongodb.client.model.Updates.set;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;
import org.bson.types.ObjectId;
import tutorias.config.MongoClientProvider;
import tutorias.dao.interfaces.ICitaDAO;
import tutorias.dominio.enums.EstadoCita;
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

    @Override
    public int contarCitasPorAlumnoYEstadoEnMes(Long matriculaAlumno, EstadoCita estado, int mes, int anio) throws CitaDAOException {
        try {
            LocalDate inicioMes = LocalDate.of(anio, mes, 1);
            LocalDate finMes = inicioMes.withDayOfMonth(inicioMes.lengthOfMonth());
            long count = col.countDocuments(
                    and(
                            eq("matriculaAlumno", matriculaAlumno),
                            eq("estado", estado),
                            gte("fecha", inicioMes),
                            lte("fecha", finMes)
                    )
            );
            return (int) count;
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al contar citas por alumno y estado en el mes");
        }
        
        
    }

    @Override
    public CitaDocument actualizarEstado(ObjectId idCita, EstadoCita nuevoEstado) {
        try {
            FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
                    .returnDocument(ReturnDocument.AFTER);

            CitaDocument actualizada = col.findOneAndUpdate(
                    eq("_id", idCita),
                    set("estado", nuevoEstado),
                    options
            );
            if (actualizada == null) {
                throw new CitaDAOException("No se encontró la cita con id " + idCita.toHexString());
            }
            return actualizada;
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al actualizar estado de la cita");
        }
    }
    
    @Override
    public List<CitaDocument> obtenerPorTutorYFecha(Long idTutor, LocalDate fecha)
            throws CitaDAOException {
        try {
            return col.find(
                    and(
                            eq("idTutor", idTutor),
                            eq("fecha", fecha)
                    )
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new CitaDAOException("Error al consultar citas por tutor y fecha");
        }
    }

    
}
