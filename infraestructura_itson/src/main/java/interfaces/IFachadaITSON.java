package interfaces;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {
    Optional<EstudianteResponseDTO> verificarLogin(LoginDTO solicitudLoginDTO);
}