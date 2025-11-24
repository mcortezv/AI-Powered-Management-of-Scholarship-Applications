package objetosNegocio.bo;
import datos.dao.interfaces.IResolucionDAO;
import dto.ResolucionDTO;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudDTO;
import dto.SolicitudInfraestructuraDTO;
import interfaces.IFachadaModeloML;
import objetosNegocio.adaptadores.ResolucionAdaptador;
import objetosNegocio.adaptadores.SolicitudAdaptador;
import objetosNegocio.bo.excepciones.ResolucionBOException;
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
    public boolean crearResolucion(ResolucionDTO resolucionDTO){
        try {
            return resolucionDAO.guardar(ResolucionAdaptador.toEntity(resolucionDTO));
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public ResolucionDTO crearResolucionAutomatica(SolicitudDTO solicitud) {
        try {
            SolicitudInfraestructuraDTO solicitudInfraestructuraDTO = SolicitudAdaptador.toInfraestructuraDTO(SolicitudAdaptador.toEntity(solicitud));
            ResolucionInfraestructuraDTO resolucionInfraestructuraDTO = fachadaModeloML.generarPrediccion(solicitudInfraestructuraDTO);
            return ResolucionAdaptador.toDTO(ResolucionAdaptador.toEntity(resolucionInfraestructuraDTO));
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public ResolucionDTO obtenerResolucion(int id){
        try {
            return ResolucionAdaptador.toDTO(resolucionDAO.obtenerPorId(id));
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }

    @Override
    public ResolucionDTO obtenerResolucionPorFiltro(String tipoFiltro, String filtro) {
        try {
            return ResolucionAdaptador.toDTO(resolucionDAO.obtenerPorFiltro(tipoFiltro, filtro));
        } catch (Exception ex) {
            throw new ResolucionBOException(ex.getMessage());
        }
    }
}
