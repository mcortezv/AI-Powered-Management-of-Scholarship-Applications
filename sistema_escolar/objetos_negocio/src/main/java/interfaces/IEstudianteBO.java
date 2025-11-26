package interfaces;
import dto.LoginDTO;
import excepciones.*;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.Tutor;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    public boolean iniciarSesion(LoginDTO solicitudLoginDTO);

    Estudiante crearEstudiante(Long matricula, Tutor tutor) throws EstudianteInvalidoException;
}
