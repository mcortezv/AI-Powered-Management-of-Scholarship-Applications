package objetosNegocio.bo;
import datos.dao.interfaces.IResolucionDAO;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import interfaces.IFachadaModeloML;
import objetosNegocio.bo.interfaces.IResolucionBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionBO implements IResolucionBO {
    private final IResolucionDAO resolucionDAO;
    private final IFachadaModeloML fachadaModeloML;

    public ResolucionBO(IResolucionDAO resolucionDAO, IFachadaModeloML fachadaModeloML) {
        this.resolucionDAO = resolucionDAO;
        this.fachadaModeloML = fachadaModeloML;
    }

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
