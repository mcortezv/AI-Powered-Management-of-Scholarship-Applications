package objetosNegocio.bo;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.ISolicitudBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionBO implements ISolicitudBO {

    public boolean crearResolución(SolicitudDTO solicitud, ResolucionDTO resolucionDTO){
        return true;
    }

    public ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud) {
        return null;
    }

    public ResolucionDTO obtenerResolucion(int id){
        return null;
    }

    public ResolucionDTO obtenerResolucionPorNombre(String nombre){
        return null;
    }

    public ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro) {
        return null;
    }
}
