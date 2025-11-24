package datos.dao.interfaces;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ISolicitudDAO {

    List<Solicitud> obtenerPorConvocatoria(int idConvocatoria);

    Solicitud obtenerPorId(int idSolicitud);

    Solicitud obtenerPorFiltro(String tipoFiltro, String filtro);

    boolean actualizar(Solicitud solicitud);

    boolean cambiarEstado(int id, EstadoSolicitud estado);
}
