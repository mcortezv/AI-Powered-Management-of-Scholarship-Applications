package objetosNegocio.adaptadores;
import datos.dominio.Requisitos;
import dto.RequisitosDTO;
import dto.RequisitosInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.RequisitosAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class RequisitosAdaptador {

    public static Requisitos toEntity(RequisitosDTO dto){
        try {

        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Requisitos toEntity(RequisitosInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static RequisitosDTO toDTO(Requisitos requisitos){
        try {

        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static RequisitosInfraestructuraDTO toInfraestructuraDTO(Requisitos  requisitos){
        try {

        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
