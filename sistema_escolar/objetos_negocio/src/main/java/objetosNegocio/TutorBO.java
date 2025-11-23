package objetosNegocio;
import adaptadores.TutorAdaptador;
import dto.TutorDTO;
import excepciones.*;
import interfaces.ITutorBO;
import solicitarBeca.dominio.Tutor;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorBO implements ITutorBO {

    @Override
    public Tutor crearTutor(TutorDTO tutorDTO) throws TutorInvalidoException {
        if (tutorDTO.getNombre() == null || tutorDTO.getApellidoPaterno() == null || tutorDTO.getApellidoMaterno() == null
                || tutorDTO.getCorreo() == null  || tutorDTO.getDireccion() == null  || tutorDTO.getParentesco() == null
                || tutorDTO.getTelefono() == null) {
            throw new TutorInvalidoException("Datos de tutor incompletos.");
        }
        return TutorAdaptador.toEntity(tutorDTO);
    }
}
