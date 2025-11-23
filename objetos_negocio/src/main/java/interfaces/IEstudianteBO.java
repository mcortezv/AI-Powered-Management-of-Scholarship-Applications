package interfaces;
import dominio.*;
import dto.LoginDTO;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteBO {

    public boolean iniciarSesion(LoginDTO solicitudLoginDTO);

    Estudiante crearEstudiante(Long matricula, Tutor tutor) throws EstudianteInvalidoException;
}
