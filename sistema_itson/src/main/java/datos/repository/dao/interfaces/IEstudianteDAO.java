package datos.repository.dao.interfaces;

import datos.dominio.Estudiante;
import datos.excepciones.DaoException;
import java.util.Optional;

public interface IEstudianteDAO {
    Optional<Estudiante> findByMatricula(Long matricula) throws DaoException;

}
