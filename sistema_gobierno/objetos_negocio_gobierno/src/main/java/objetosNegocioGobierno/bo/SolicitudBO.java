package objetosNegocioGobierno.bo;
import datos.repository.dao.interfaces.ISolicitudDAO;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import objetosNegocioGobierno.bo.excepciones.SolicitudBOException;
import objetosNegocioGobierno.bo.interfaces.ISolicitudBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudBO implements ISolicitudBO {
    private final ISolicitudDAO solicitudDAO;

    public SolicitudBO(ISolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

    @Override
    public boolean cambiarEstado(int id, EstadoSolicitud nuevoEstado){
        try {
            return solicitudDAO.cambiarEstado(id, nuevoEstado);
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }

    @Override
    public Solicitud obtenerSolicitud(int id){
        try {
            return solicitudDAO.obtenerPorId(id);
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }

    @Override
    public List<Solicitud> obtenerListadoSolicitudes(int idConvocatoria){
        try {
            List<Solicitud> solicitudes = new ArrayList<>();
            for (Solicitud solicitud: solicitudDAO.obtenerPorConvocatoria(idConvocatoria)){
                solicitudes.add(solicitud);
            }
            return solicitudes;
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }
}
