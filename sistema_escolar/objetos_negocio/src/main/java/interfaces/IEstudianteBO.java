package interfaces;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    boolean iniciarSesion(LoginDTO solicitudLoginDTO);

    EstudianteResponseDTO crearEstudiante(Long matricula) throws EstudianteInvalidoException;
}
