package interfaces;
import excepciones.*;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Parentesco;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorBO {

    Tutor crearTutor(Long id, String nombre, Parentesco parentesco, String telefono, String direccion, String correo) throws TutorInvalidoException;
}
