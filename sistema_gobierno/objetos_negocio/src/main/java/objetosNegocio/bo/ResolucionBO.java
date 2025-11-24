package objetosNegocio.bo;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.IResolucionBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionBO implements IResolucionBO {

    @Override
    public boolean crearResolución(SolicitudDTO solicitud, ResolucionDTO resolucionDTO){
        return true;
    }

    @Override
    public ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud) {
        return null;
    }

    @Override
    public ResolucionDTO obtenerResolucion(int id){
        return null;
    }

    @Override
    public ResolucionDTO obtenerResolucionPorNombre(String nombre){
        return null;
    }

    @Override
    public ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro) {
        return null;
    }
}
