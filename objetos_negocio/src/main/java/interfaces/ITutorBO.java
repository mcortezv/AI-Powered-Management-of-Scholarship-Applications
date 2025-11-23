package interfaces;
import dominio.*;
import dto.TutorDTO;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorBO {

    Tutor crearTutor(TutorDTO tutorDTO) throws TutorInvalidoException;
}
