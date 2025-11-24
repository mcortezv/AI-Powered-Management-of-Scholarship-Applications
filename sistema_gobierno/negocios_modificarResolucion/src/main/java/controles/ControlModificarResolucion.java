package controles;
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

    validarConvocatoriaDisp(in idConvocatoria:int): boolean

    buscarResolucion(in nombre:String, in filtro:String): Resolucion

    resolverAtomatico(in solicitud:Solicitud): Resolucion

    resolverManual(in solicitud:Solicitud, in decision:String, in motivo:String): Resolucion

    modificarResolucion(in idResolucion:int, in nuevaResolucion:Resolucion): boolean

    cambiarEstadoSolicitud(in id:int, in nuevoEstado:String): boolean
}
