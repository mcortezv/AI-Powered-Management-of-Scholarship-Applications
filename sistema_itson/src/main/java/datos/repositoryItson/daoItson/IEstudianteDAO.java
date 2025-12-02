package datos.repositoryItson.daoItson;

import datos.dominioItson.Estudiante;
import datos.excepciones.DaoException;
import java.util.Optional;

public interface IEstudianteDAO {
    Optional<Estudiante> findByMatricula(Long matricula) throws DaoException;

}
