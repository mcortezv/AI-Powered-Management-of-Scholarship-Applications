package objetosNegocio.adaptadores;
import datos.dominio.Resolucion;
import dto.ResolucionDTO;
import dto.ResolucionInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.ResolucionAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class ResolucionAdaptador {

    public static Resolucion toEntity(ResolucionDTO dto){
        try {

        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Resolucion toEntity(ResolucionInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static ResolucionDTO toDTO(Resolucion resolucion){
        try {

        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static ResolucionInfraestructuraDTO toInfraestructuraDTO(Resolucion  resolucion){
        try {

        } catch (Exception sinUso){
            throw new ResolucionAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
