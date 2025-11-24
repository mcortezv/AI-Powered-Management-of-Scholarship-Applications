package objetosNegocio.adaptadores;
import datos.dominio.Tutor;
import dto.TutorDTO;
import dto.TutorInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.TutorAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorAdaptador {

    public static Tutor toEntity(TutorDTO dto){
        try {

        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Tutor toEntity(TutorInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static TutorDTO toDTO(Tutor tutor){
        try {

        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static TutorInfraestructuraDTO toInfraestructuraDTO(Tutor  tutor){
        try {

        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
