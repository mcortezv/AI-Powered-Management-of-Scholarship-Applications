package gobierno;
import dto.BecasDisponiblesResponseDTO;
import dto.SolicitudDTO;
import dto.LoginDTO;
import interfaces.IGobierno;
import java.util.Optional;

public class Gobierno implements IGobierno {

    @Override
    public Optional<BecasDisponiblesResponseDTO> solicitarBecas(LoginDTO solicitudLoginDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO) {
        return Optional.empty();
    }
}