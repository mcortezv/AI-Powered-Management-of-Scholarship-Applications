package interfaces.solicitarBeca;
import dto.itson.EstudianteDTOItson;
import dto.itson.LoginDTOItson;
import objetosNegocio.solicitarBeca.excepciones.EstudianteInvalidoException;
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
