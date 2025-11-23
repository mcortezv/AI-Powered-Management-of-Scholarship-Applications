package controles;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import interfaces.IITSON;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public class ControlItson implements IITSON {

    @Override
    public Optional<EstudianteResponseDTO> verificarLogin(SolicitudLoginDTO solicitudLoginDTO) {
        return Optional.empty();
    }
}