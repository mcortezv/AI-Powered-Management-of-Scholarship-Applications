package datos.api_publica.control;
import datos.services.SolicitudService;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoItson {
    private final SolicitudService solicitudService;

    public GobiernoItson() {
        this.solicitudService = new SolicitudService();
    }

    public boolean guardarSolicitud(SolicitudDTO dto){
        return solicitudService.guardarSolicitud(dto);
    }
}