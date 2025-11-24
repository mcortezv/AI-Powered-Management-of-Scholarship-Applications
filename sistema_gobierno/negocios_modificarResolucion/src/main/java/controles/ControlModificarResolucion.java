package controles;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.IResolucionBO;
import objetosNegocio.bo.interfaces.ISolicitudBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class ControlModificarResolucion {
    private final IResolucionBO resolucionBO;
    private final ISolicitudBO solicitudBO;

    public ControlModificarResolucion(IResolucionBO resolucionBO, ISolicitudBO solicitudBO) {
        this.resolucionBO = resolucionBO;
        this.solicitudBO = solicitudBO;
    }

    public boolean validarConvocatoriaDisp(int idConvocatoria){
        return true;
        // Pendiente
    }

    public ResolucionDTO buscarResolucion(String nombre, String filtro){
        return resolucionBO.obtenerResolucionPorFiltro(nombre, filtro);
    }

    public ResolucionDTO resolverAtomatico(SolicitudDTO solicitud){
        return resolucionBO.crearResolucionAutomatica(solicitud);
    }

    public ResolucionDTO resolverManual(ResolucionDTO resolucion){
        return resolucionBO.crearResolucion(resolucion);
    }

    public boolean modificarResolucion(ResolucionDTO resolucionDTO){
        if (cambiarEstadoSolicitud(resolucionDTO.getSolicitud())){
            return resolucionBO.actualizarResolucion(resolucionDTO);
        }
        return false;
    }

    public boolean cambiarEstadoSolicitud(SolicitudDTO solicitudDTO){
        return solicitudBO.cambiarEstado((int) solicitudDTO.getId(), solicitudDTO.getEstado());
    }
}
