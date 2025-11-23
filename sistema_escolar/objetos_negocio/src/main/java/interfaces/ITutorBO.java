package interfaces;
import dto.TutorDTO;
import excepciones.*;
import solicitarBeca.dominio.Tutor;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorBO {

    Tutor crearTutor(TutorDTO tutorDTO) throws TutorInvalidoException;
}
