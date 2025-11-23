package interfaces;
import dominio.*;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorBO {

    Tutor crearTutor(String nombre, String correo, String telefono, String direccion) throws TutorInvalidoException;
}
