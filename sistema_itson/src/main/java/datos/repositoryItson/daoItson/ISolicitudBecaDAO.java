package datos.repositoryItson.daoItson;

import datos.dominioItson.SolicitudBeca;
import datos.excepciones.DaoException;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface ISolicitudBecaDAO {
    Optional<SolicitudBeca> findById(ObjectId _id) throws DaoException;

}
