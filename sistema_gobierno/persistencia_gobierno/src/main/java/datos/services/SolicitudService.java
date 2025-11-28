package datos.services;
import datos.dao.SolicitudDAO;
import datos.dao.excepciones.SolicitudDAOException;

import dto.gobierno.SolicitudDTOGobierno;
import dto_gobierno.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudService {
    private final SolicitudDAO solicitudDAO;

    public SolicitudService(){
        this.solicitudDAO = new SolicitudDAO();
    }

    public boolean guardarSolicitud(SolicitudDTOGobierno solicitud) throws SolicitudDAOException {
        return solicitudDAO.guardarSolicitud(solicitud);
    }
}
