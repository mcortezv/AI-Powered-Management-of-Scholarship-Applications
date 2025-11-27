package objetosNegocio;
import excepciones.*;
import interfaces.ITutorBO;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Parentesco;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorBO implements ITutorBO {

    @Override
    public Tutor crearTutor(String nombre, Parentesco parentesco, String telefono, String direccion, String correo) throws TutorInvalidoException {
        if (nombre == null || correo == null  || direccion == null  || parentesco == null
                || telefono == null) {
            throw new TutorInvalidoException("Datos de tutor incompletos.");
        }
        return new Tutor(ThreadLocalRandom.current().nextLong(), nombre, parentesco, telefono, correo, direccion);
    }
}
