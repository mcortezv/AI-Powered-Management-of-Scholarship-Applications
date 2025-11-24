package datos.dao.interfaces;
import datos.dominio.Solicitud;
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
}
