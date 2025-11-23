package interfaces;
import dto.BecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.LoginDTO;

import java.util.Optional;

public interface IGobierno {
    Optional<BecasDisponiblesResponseDTO> solicitarBecas(LoginDTO solicitudLoginDTO);
    Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO);
}
