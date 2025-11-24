package controles;
import datos.dominio.Resolucion;
import datos.dominio.Solicitud;
import datos.dominio.enums.Decision;
import dto.ResolucionDTO;
import dto.ResolucionInfraestructuraDTO;
import dto.SolicitudDTO;
import dto.SolicitudInfraestructuraDTO;
import objetosNegocio.adaptadores.ResolucionAdaptador;
import objetosNegocio.adaptadores.SolicitudAdaptador;
import objetosNegocio.bo.interfaces.IResolucionBO;
import objetosNegocio.bo.interfaces.ISolicitudBO;
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
        SolicitudInfraestructuraDTO solicitudInfraestructuraDTO = SolicitudAdaptador.toInfraestructuraDTO(solicitud);
        ResolucionInfraestructuraDTO resolucionInfraestructuraDTO = resolucionBO.crearResolucionAutomatica(solicitudInfraestructuraDTO);
        Resolucion resolucion = ResolucionAdaptador.toEntity(resolucionInfraestructuraDTO);
        return ResolucionAdaptador.toDTO(resolucion);
    }

    public boolean resolverManual(Solicitud solicitud, Decision decision, String motivo, LocalDate fechaEvaluacion){
        Resolucion resolucion = resolucionBO.crearResolucion(solicitud, decision, motivo, fechaEvaluacion);
        return modificarResolucion(resolucion);
    }

    public boolean modificarResolucion(Resolucion resolucion){
        if (cambiarEstadoSolicitud(resolucion.getSolicitud())){
            return resolucionBO.actualizarResolucion(resolucion);
        }
        return false;
    }

    public boolean cambiarEstadoSolicitud(Solicitud solicitudDTO){
        return solicitudBO.cambiarEstado((int) solicitudDTO.getId(), solicitudDTO.getEstado());
    }
}
