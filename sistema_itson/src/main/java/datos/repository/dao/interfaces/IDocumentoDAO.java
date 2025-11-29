package datos.repository.dao.interfaces;

import datos.dominio.Documento;
import datos.excepciones.DaoException;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface IDocumentoDAO {
    Optional<Documento> findById(ObjectId _id) throws DaoException;
}
