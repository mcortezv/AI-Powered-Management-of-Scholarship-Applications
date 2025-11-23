package interfaces;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.SolicitudLoginDTO;

import java.util.Optional;

public interface IGobierno {
    Optional<SolicitudBecasDisponiblesResponseDTO> solicitarBecas(SolicitudLoginDTO solicitudLoginDTO);
    Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO);
}
