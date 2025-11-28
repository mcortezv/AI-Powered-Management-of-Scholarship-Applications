package controles;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.Decision;
import gobierno.ResolucionDTOGobierno;
import gobierno.SolicitudDTOGobierno;
import dtoGobierno.ResolucionDTO;
import dtoGobierno.SolicitudDTO;
import objetosNegocioGobierno.adaptadores.ResolucionAdaptador;
import objetosNegocioGobierno.adaptadores.SolicitudAdaptador;
import objetosNegocioGobierno.bo.interfaces.IResolucionBO;
import objetosNegocioGobierno.bo.interfaces.ISolicitudBO;
import java.time.LocalDate;

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
        return ResolucionAdaptador.toDTO(resolucionBO.obtenerResolucionPorFiltro(nombre, filtro));
    }

    public ResolucionDTO resolverAtomatico(SolicitudDTO solicitudDTO){
        Solicitud solicitud = SolicitudAdaptador.toEntity(solicitudDTO);
        SolicitudDTOGobierno solicitudInfraestructuraDTO = SolicitudAdaptador.toInfraestructuraDTO(solicitud);
        ResolucionDTOGobierno resolucionInfraestructuraDTO = resolucionBO.crearResolucionAutomatica(solicitudInfraestructuraDTO);
        Resolucion resolucion = ResolucionAdaptador.toEntity(resolucionInfraestructuraDTO);
        return ResolucionAdaptador.toDTO(resolucion);
    }

    public boolean resolverManual(ResolucionDTO resolucionDTO){
        Solicitud solicitud = SolicitudAdaptador.toEntity(resolucionDTO.getSolicitud());
        Decision decision = Decision.valueOf(resolucionDTO.getDecision());
        String motivo = resolucionDTO.getMotivo();
        LocalDate fechaEvaluacion =  resolucionDTO.getFechaEvaluacion();
        Resolucion resolucion = resolucionBO.crearResolucion(solicitud, decision, motivo, fechaEvaluacion);
        if (cambiarEstadoSolicitud(resolucion.getSolicitud())){
            return resolucionBO.actualizarResolucion(resolucion);
        }
        return false;
    }

    public boolean modificarResolucion(ResolucionDTO resolucionDTO){
        Resolucion resolucion = ResolucionAdaptador.toEntity(resolucionDTO);
        if (cambiarEstadoSolicitud(resolucion.getSolicitud())){
            return resolucionBO.actualizarResolucion(resolucion);
        }
        return false;
    }

    public boolean cambiarEstadoSolicitud(Solicitud solicitudDTO){
        return solicitudBO.cambiarEstado((int) solicitudDTO.getId(), solicitudDTO.getEstado());
    }
}
