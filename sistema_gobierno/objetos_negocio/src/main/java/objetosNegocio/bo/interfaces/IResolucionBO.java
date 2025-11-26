package objetosNegocio.bo.interfaces;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.Decision;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudInfraestructuraDTO;
import java.time.LocalDate;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IResolucionBO {

    Resolucion crearResolucion(Solicitud solicitud, Decision decision, String motivo, LocalDate fechaEvaluacion);

    boolean resolver(Resolucion resolucion);

    ResolucionInfraestructuraDTO crearResolucionAutomatica(SolicitudInfraestructuraDTO solicitud);

    Resolucion obtenerResolucion(int id);

    Resolucion obtenerResolucionPorFiltro(String tipoFiltro, String filtro);

    boolean actualizarResolucion(Resolucion resolucion);
}
