package objetosNegocio.adaptadores;
import datos.dominio.Estudiante;
import dto.EstudianteDTO;
import dto.EstudianteInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.EstudianteAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteAdaptador {

    public static Estudiante toEntity(EstudianteDTO dto){
        try {

        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Estudiante toEntity(EstudianteInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static EstudianteDTO toDTO(Estudiante estudiante){
        try {

        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static EstudianteInfraestructuraDTO toInfraestructuraDTO(Estudiante  estudiante){
        try {

        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
