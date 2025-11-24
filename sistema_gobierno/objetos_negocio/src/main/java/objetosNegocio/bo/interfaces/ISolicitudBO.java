package objetosNegocio.bo.interfaces;
import dto.SolicitudDTO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ISolicitudBO {

    boolean cambiarEstado(int id, String nuevoEstado);

    SolicitudDTO obtenerSolicitud(int id);

    List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria);
}
