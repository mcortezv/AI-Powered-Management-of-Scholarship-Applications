package interfaces;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import excepciones.*;
import solicitarBeca.repository.documents.EstudianteDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    boolean iniciarSesion(LoginDTO solicitudLoginDTO);

    EstudianteResponseDTO crearEstudiante(Long matricula) throws EstudianteInvalidoException;

    void guardarEstudiante(EstudianteDocument estudiante) throws EstudianteInvalidoException;
}
