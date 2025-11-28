package datos.repository.dao.interfaces;

import datos.dominio.SolicitudBeca;
import datos.excepciones.DaoException;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface ISolicitudBecaDAO {
    Optional<SolicitudBeca> findById(ObjectId _id) throws DaoException;

}
