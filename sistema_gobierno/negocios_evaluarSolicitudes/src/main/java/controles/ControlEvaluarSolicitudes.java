package controles;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.EstadoSolicitud;
import gobierno.ResolucionDTOGobierno;
import gobierno.SolicitudDTOGobierno;
import dtoGobierno.ResolucionDTO;
import dtoGobierno.SolicitudDTO;
import objetosNegocioGobierno.adaptadores.ResolucionAdaptador;
import objetosNegocioGobierno.adaptadores.SolicitudAdaptador;
import objetosNegocioGobierno.bo.interfaces.IResolucionBO;
import objetosNegocioGobierno.bo.interfaces.ISolicitudBO;
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
        SolicitudDTOGobierno solicitudInfraestructuraDTO = SolicitudAdaptador.toInfraestructuraDTO(solicitud);
        ResolucionDTOGobierno resolucionInfraestructuraDTO = resolucionBO.crearResolucionAutomatica(solicitudInfraestructuraDTO);
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
