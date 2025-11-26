package itson.org.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import itson.org.config.MongoClienteProvider;
import itson.org.domain.SolicitudBeca;
import itson.org.exception.DaoException;
import org.bson.types.ObjectId;
import itson.org.repository.ISolicitudBecaDAO;

import java.util.Optional;

public class SolicitudBecaDAO implements ISolicitudBecaDAO {
    private final MongoCollection<SolicitudBeca> col;

    public SolicitudBecaDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("solicitudesBeca", SolicitudBeca.class);
    }

    @Override
    public Optional<SolicitudBeca> findById(ObjectId _id) throws DaoException {
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id",_id)).first());
        }catch (DaoException ex){
            throw new DaoException("Error al encontrar solicitudBeca con el id: " + _id);
        }
    }
}
