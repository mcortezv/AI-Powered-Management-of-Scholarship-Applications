package interfaz;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {
    Optional<EstudianteResponseDTO> verificarLogin(SolicitudLoginDTO solicitudLoginDTO);
}