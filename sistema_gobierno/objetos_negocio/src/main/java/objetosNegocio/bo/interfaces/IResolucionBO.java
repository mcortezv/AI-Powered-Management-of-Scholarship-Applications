package objetosNegocio.bo.interfaces;
import dto.ResolucionDTO;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IResolucionBO {

    boolean crearResolución(SolicitudDTO solicitud, ResolucionDTO resolucionDTO);

    ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud);

    ResolucionDTO obtenerResolucion(int id);

    ResolucionDTO obtenerResolucionPorNombre(String nombre);

    ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro);
}
