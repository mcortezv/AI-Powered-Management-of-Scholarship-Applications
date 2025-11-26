package objetosNegocio.bo.interfaces;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ISolicitudBO {

    boolean cambiarEstado(int id, EstadoSolicitud nuevoEstado);

    Solicitud obtenerSolicitud(int id);

    List<Solicitud> obtenerListadoSolicitudes(int idConvocatoria);
}
