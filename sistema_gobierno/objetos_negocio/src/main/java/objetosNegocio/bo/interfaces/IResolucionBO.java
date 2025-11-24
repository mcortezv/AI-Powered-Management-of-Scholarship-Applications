package objetosNegocio.bo.interfaces;
import dto.ResolucionDTO;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IResolucionBO {

    boolean crearResolucion(ResolucionDTO resolucionDTO);

    ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud);

    ResolucionDTO obtenerResolucion(int id);

    ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro);
}
