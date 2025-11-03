package interfaces;

import dto.SolicitudDTO;

import java.util.Optional;

public interface IGobierno {
    Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO);
}
