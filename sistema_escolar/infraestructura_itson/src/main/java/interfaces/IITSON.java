package interfaces;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public interface IITSON {
    Optional<EstudianteResponseDTO> verificarLogin(SolicitudLoginDTO solicitudLoginDTO);
}