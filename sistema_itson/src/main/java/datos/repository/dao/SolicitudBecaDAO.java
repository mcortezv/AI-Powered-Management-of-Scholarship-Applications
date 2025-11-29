package datos.repository.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.config.MongoClienteProvider;
import datos.dominio.SolicitudBeca;
import datos.excepciones.DaoException;
import datos.repository.dao.interfaces.ISolicitudBecaDAO;
import org.bson.types.ObjectId;

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
