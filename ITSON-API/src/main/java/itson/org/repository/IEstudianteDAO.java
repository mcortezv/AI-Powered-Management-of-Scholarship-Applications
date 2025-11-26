package itson.org.repository;

import itson.org.domain.Estudiante;
import itson.org.exception.DaoException;
import java.util.Optional;

public interface IEstudianteDAO {
    Optional<Estudiante> findByMatricula(Long matricula) throws DaoException;

}
