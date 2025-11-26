package itson.org.repository;

import itson.org.domain.SolicitudBeca;
import itson.org.exception.DaoException;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface ISolicitudBecaDAO {
    Optional<SolicitudBeca> findById(ObjectId _id) throws DaoException;

}
