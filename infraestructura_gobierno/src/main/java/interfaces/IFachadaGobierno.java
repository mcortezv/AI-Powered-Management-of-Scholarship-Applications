package interfaces;

import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.SolicitudLoginDTO;

import java.util.Optional;

public interface IFachadaGobierno {
    Optional<SolicitudBecasDisponiblesResponseDTO> solicitarBecas(SolicitudDTO solicitudDTO);
    Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO);
}
