package datos.services;
import datos.dao.SolicitudDAO;
import datos.dao.excepciones.SolicitudDAOException;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudService {
    private final SolicitudDAO solicitudDAO;

    public SolicitudService(SolicitudDAO solicitudDAO){
        this.solicitudDAO = solicitudDAO;
    }

    public boolean guardarSolicitud(SolicitudDTO solicitud) throws SolicitudDAOException {

    }
}
