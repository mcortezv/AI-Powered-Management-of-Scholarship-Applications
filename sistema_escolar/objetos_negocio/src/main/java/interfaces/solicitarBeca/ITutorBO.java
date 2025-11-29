package interfaces.solicitarBeca;
import bo.solicitarBeca.excepciones.TutorInvalidoException;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Parentesco;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorBO {

    Tutor crearTutor(String nombre, Parentesco parentesco, String telefono, String direccion, String correo) throws TutorInvalidoException;
}
