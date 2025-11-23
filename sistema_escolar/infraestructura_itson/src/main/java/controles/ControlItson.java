package controles;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import interfaces.IITSON;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public class ControlItson implements IITSON {

    @Override
    public Optional<EstudianteResponseDTO> verificarLogin(LoginDTO solicitudLoginDTO) {
        return Optional.empty();
    }
}