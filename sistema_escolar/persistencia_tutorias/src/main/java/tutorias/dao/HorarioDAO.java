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
import tutorias.dao.interfaces.IHorarioDAO;
import tutorias.dominio.enums.EstadoDisponibilidad;
import tutorias.excepciones.HorarioDAOException;
import tutorias.repository.documents.HorarioDocument;

/**
 *
 * @author katia
 */
public class HorarioDAO implements IHorarioDAO{
    private final MongoCollection<HorarioDocument> col;
    private final MongoCollection<Document> colDoc;

    public HorarioDAO() {
        MongoDatabase db = MongoClientProvider.INSTANCE.database();
        this.col = db.getCollection("horarios", HorarioDocument.class);
        this.colDoc = db.getCollection("horarios", Document.class);
    }

    @Override
    public ObjectId create(HorarioDocument entity) throws HorarioDAOException {
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
            throw new HorarioDAOException("Error al insertar Horario");
        }
    }

    @Override
    public List<HorarioDocument> obtenerDisponiblesPorTutorYFecha(Long idTutor, LocalDate fecha) throws HorarioDAOException {
        try {
            return col.find(
                    and(
                            eq("idTutor", idTutor),
                            eq("fecha", fecha),
                            eq("estadoDisponibilidad", EstadoDisponibilidad.DISPONIBLE)
                    )
            ).into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new HorarioDAOException("Error al consultar horarios disponibles por tutor y fecha");
        }
    }

    @Override
    public HorarioDocument actualizarEstado(ObjectId idHorario, EstadoDisponibilidad nuevoEstado) throws HorarioDAOException {
        try {
            FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
                    .returnDocument(ReturnDocument.AFTER);

            HorarioDocument actualizado = col.findOneAndUpdate(
                    eq("_id", idHorario),
                    set("estadoDisponibilidad", nuevoEstado),
                    options
            );

            if (actualizado == null) {
                throw new HorarioDAOException("No se encontró el horario con id " + idHorario.toHexString());
            }
            return actualizado;
        } catch (MongoException ex) {
            throw new HorarioDAOException("Error al actualizar estado de disponibilidad del horario");
        }
    }
}
