package objetosNegocioGobierno.adaptadores;
import datos.dominio.Resolucion;
import datos.dominio.enums.Decision;
import gobierno.ResolucionDTOGobierno;
import dtoGobierno.ResolucionDTO;
import objetosNegocioGobierno.adaptadores.excepciones.ResolucionAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionAdaptador {

    public static Resolucion toEntity(ResolucionDTO dto){
        try {
            Resolucion resolucion = new Resolucion();
            resolucion.setSolicitud(SolicitudAdaptador.toEntity(dto.getSolicitud()));
            resolucion.setDecision(Decision.valueOf(dto.getDecision()));
            resolucion.setMotivo(dto.getMotivo());
            resolucion.setFechaEvaluacion(dto.getFechaEvaluacion());
            return resolucion;
        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Resolucion toEntity(ResolucionDTOGobierno dto){
        try {
            Resolucion resolucion = new Resolucion();
            resolucion.setSolicitud(SolicitudAdaptador.toEntity(dto.getSolicitud()));
            resolucion.setDecision(Decision.valueOf(dto.getDecision()));
            resolucion.setMotivo(dto.getMotivo());
            resolucion.setFechaEvaluacion(dto.getFechaEvaluacion());
            return resolucion;
        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static ResolucionDTO toDTO(Resolucion resolucion){
        try {
            ResolucionDTO dto = new ResolucionDTO();
            dto.setSolicitud(SolicitudAdaptador.toDTO(resolucion.getSolicitud()));
            dto.setDecision(resolucion.getDecision().toString());
            dto.setMotivo(resolucion.getMotivo());
            dto.setFechaEvaluacion(resolucion.getFechaEvaluacion());
            return dto;
        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static ResolucionDTOGobierno toInfraestructuraDTO(Resolucion  resolucion){
        try {
            ResolucionDTOGobierno dto = new ResolucionDTOGobierno();
            dto.setSolicitud(SolicitudAdaptador.toInfraestructuraDTO(resolucion.getSolicitud()));
            dto.setDecision(resolucion.getDecision().toString());
            dto.setMotivo(resolucion.getMotivo());
            dto.setFechaEvaluacion(resolucion.getFechaEvaluacion());
            return dto;
        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
