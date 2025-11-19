package gobierno;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.SolicitudLoginDTO;
import interfaces.IGobierno;
import java.util.Optional;

public class Gobierno implements IGobierno {

    @Override
    public Optional<SolicitudBecasDisponiblesResponseDTO> solicitarBecas(SolicitudLoginDTO solicitudLoginDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO) {
        return Optional.empty();
    }
}