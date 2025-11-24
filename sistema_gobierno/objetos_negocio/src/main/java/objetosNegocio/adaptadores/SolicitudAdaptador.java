package objetosNegocio.adaptadores;
import datos.dominio.Solicitud;
import dto.SolicitudDTO;
import dto.SolicitudInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.SolicitudAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class SolicitudAdaptador {

    public static Solicitud toEntity(SolicitudDTO dto){
        try {

        } catch (Exception sinUso){
            throw new SolicitudAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Solicitud toEntity(SolicitudInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new SolicitudAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static SolicitudDTO toDTO(Solicitud solicitud){
        try {

        } catch (Exception sinUso){
            throw new SolicitudAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static SolicitudInfraestructuraDTO toInfraestructuraDTO(Solicitud  solicitud){
        try {

        } catch (Exception sinUso){
            throw new SolicitudAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
