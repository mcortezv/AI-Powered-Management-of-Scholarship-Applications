package objetosNegocio.adaptadores;
import datos.dominio.Beca;
import dto.BecaDTO;
import dto.BecaInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.BecaAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecaAdaptador {

    public static Beca toEntity(BecaDTO dto){
        try {

        } catch (Exception sinUso){
            throw new BecaAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Beca toEntity(BecaInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new BecaAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static BecaDTO toDTO(Beca beca){
        try {

        } catch (Exception sinUso){
            throw new BecaAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static BecaInfraestructuraDTO toInfraestructuraDTO(Beca  beca){
        try {

        } catch (Exception sinUso){
            throw new BecaAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
