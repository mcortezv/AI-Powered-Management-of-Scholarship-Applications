package interfaces;
import dominio.*;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    Estudiante crearEstudiante(Long matricula, Tutor tutor) throws EstudianteInvalidoException;
}
