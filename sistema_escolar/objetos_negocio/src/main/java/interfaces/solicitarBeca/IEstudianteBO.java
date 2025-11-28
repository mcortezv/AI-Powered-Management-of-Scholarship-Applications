package interfaces.solicitarBeca;
import itson.EstudianteDTOItson;
import itson.LoginDTOItson;
import bo.solicitarBeca.excepciones.EstudianteInvalidoException;
import solicitarBeca.repository.documents.EstudianteDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    boolean iniciarSesion(LoginDTOItson solicitudLoginDTO);

    EstudianteDTOItson crearEstudiante(Long matricula) throws EstudianteInvalidoException;

    void guardarEstudiante(EstudianteDocument estudiante) throws EstudianteInvalidoException;

    void cerrarSesion();
}
