package objetosNegocio;
import excepciones.*;
import interfaces.ITutorBO;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Parentesco;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorBO implements ITutorBO {

    @Override
    public Tutor crearTutor(Long id, String nombre, Parentesco parentesco, String telefono, String direccion, String correo) throws TutorInvalidoException {
        if (nombre == null || correo == null  || direccion == null  || parentesco == null
                || telefono == null) {
            throw new TutorInvalidoException("Datos de tutor incompletos.");
        }
        return new Tutor(id, nombre, parentesco, telefono, correo, direccion);
    }
}
