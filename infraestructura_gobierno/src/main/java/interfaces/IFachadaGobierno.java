package interfaces;

import dto.*;

import java.util.Optional;

public interface IFachadaGobierno {
    Optional<BecasDisponiblesResponseDTO> obtenerBecas(SolicitudDTO solicitudDTO);
    Optional<Boolean> validarDocumento(DocumentoDTO documentoDTO);
    Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO);
}
