package controles;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import dto.ResolucionDTO;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudDTO;
import dto.SolicitudInfraestructuraDTO;
import objetosNegocio.adaptadores.ResolucionAdaptador;
import objetosNegocio.adaptadores.SolicitudAdaptador;
import objetosNegocio.bo.interfaces.IResolucionBO;
import objetosNegocio.bo.interfaces.ISolicitudBO;
import java.util.ArrayList;
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
        List<SolicitudDTO> solicitudes = new ArrayList<>();
        for (Solicitud solicitud: solicitudBO.obtenerListadoSolicitudes(idConvocatoria)){
            solicitudes.add(SolicitudAdaptador.toDTO(solicitud));
        }
        return solicitudes;
    }

    public ResolucionDTO evaluacionAutomatica(SolicitudDTO solicitudDTO){
        Solicitud solicitud = SolicitudAdaptador.toEntity(solicitudDTO);
        SolicitudInfraestructuraDTO solicitudInfraestructuraDTO = SolicitudAdaptador.toInfraestructuraDTO(solicitud);
        ResolucionInfraestructuraDTO resolucionInfraestructuraDTO = resolucionBO.crearResolucionAutomatica(solicitudInfraestructuraDTO);
        Resolucion resolucion = ResolucionAdaptador.toEntity(resolucionInfraestructuraDTO);
        return ResolucionAdaptador.toDTO(resolucion);
    }

    public boolean resolverSolicitudManual(ResolucionDTO resolucionDTO){
        if (cambiarEstadoSolicitud((int) resolucionDTO.getSolicitud().getId(), resolucionDTO.getSolicitud().getEstado())){
            return resolucionBO.resolver(ResolucionAdaptador.toEntity(resolucionDTO));
        }
        return false;
    }

    public boolean resolver(ResolucionDTO resolucionDTO){
        if (cambiarEstadoSolicitud((int) resolucionDTO.getSolicitud().getId(), resolucionDTO.getSolicitud().getEstado())){
            return resolucionBO.resolver(ResolucionAdaptador.toEntity(resolucionDTO));
        }
        return false;
    }

    public boolean cambiarEstadoSolicitud(int id, String nuevoEstado){
        return solicitudBO.cambiarEstado(id, EstadoSolicitud.valueOf(nuevoEstado));
    }
}
