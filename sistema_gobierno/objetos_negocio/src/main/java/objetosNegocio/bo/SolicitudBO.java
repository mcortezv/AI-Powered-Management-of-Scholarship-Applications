package objetosNegocio.bo;
import datos.dao.interfaces.ISolicitudDAO;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import dto.SolicitudDTO;
import objetosNegocio.adaptadores.SolicitudAdaptador;
import objetosNegocio.bo.excepciones.SolicitudBOException;
import objetosNegocio.bo.interfaces.ISolicitudBO;
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
    public boolean cambiarEstado(int id, String nuevoEstado){
        try {
            return solicitudDAO.cambiarEstado(id, EstadoSolicitud.valueOf(nuevoEstado));
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }

    @Override
    public SolicitudDTO obtenerSolicitud(int id){
        try {
            return SolicitudAdaptador.toDTO(solicitudDAO.obtenerPorId(id));
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }

    @Override
    public List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria){
        try {
            List<SolicitudDTO> solicitudes = new ArrayList<>();
            for (Solicitud solicitud: solicitudDAO.obtenerPorConvocatoria(idConvocatoria)){
                solicitudes.add(SolicitudAdaptador.toDTO(solicitud));
            }
            return solicitudes;
        } catch (Exception ex){
            throw new SolicitudBOException(ex.getMessage());
        }
    }
}
