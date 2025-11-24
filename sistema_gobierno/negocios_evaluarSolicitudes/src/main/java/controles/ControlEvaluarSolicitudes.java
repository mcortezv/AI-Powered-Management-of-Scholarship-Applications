package controles;
import dto.ResolucionDTO;
import dto.SolicitudDTO;
import objetosNegocio.bo.interfaces.IResolucionBO;
import objetosNegocio.bo.interfaces.ISolicitudBO;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class ControlEvaluarSolicitudes {
    private final IResolucionBO resolucionBO;
    private final ISolicitudBO solicitudBO;

    public ControlEvaluarSolicitudes(IResolucionBO resolucionBO, ISolicitudBO solicitudBO) {
        this.resolucionBO = resolucionBO;
        this.solicitudBO = solicitudBO;
    }

    public void evaluarConvocatoria(int idConvocatoria){
        // No recuerdo para que lo cree
    }

    public List<SolicitudDTO> obtenerListadoSolicitudes(int idConvocatoria){
        return solicitudBO.obtenerListadoSolicitudes(idConvocatoria);
    }

    public ResolucionDTO evaluacionAutomatica(SolicitudDTO solicitud){
        return resolucionBO.crearResolucionAutomatica(solicitud);
    }

    public boolean resolverSolicitudManual(ResolucionDTO resolucionDTO){
        if (cambiarEstadoSolicitud((int) resolucionDTO.getSolicitud().getId(), resolucionDTO.getSolicitud().getEstado())){
            return resolucionBO.crearResolucion(resolucionDTO);
        }
        return false;
    }

    public boolean resolver(ResolucionDTO resolucionDTO){
        if (cambiarEstadoSolicitud((int) resolucionDTO.getSolicitud().getId(), resolucionDTO.getSolicitud().getEstado())){
            return resolucionBO.crearResolucion(resolucionDTO);
        }
        return false;
    }

    public boolean cambiarEstadoSolicitud(int id, String nuevoEstado){
        return solicitudBO.cambiarEstado(id, nuevoEstado);
    }
}
