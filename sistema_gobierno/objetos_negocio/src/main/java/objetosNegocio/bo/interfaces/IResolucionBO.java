package objetosNegocio.bo.interfaces;
import dto.ResolucionDTO;
import dto.SolicitudDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IResolucionBO {

    ResolucionDTO crearResolucion(ResolucionDTO resolucionDTO);

    boolean resolver(ResolucionDTO resolucionDTO);

    ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud);

    ResolucionDTO obtenerResolucion(int id);

    ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro);

    boolean actualizarResolucion(ResolucionDTO resolucionDTO);
}
