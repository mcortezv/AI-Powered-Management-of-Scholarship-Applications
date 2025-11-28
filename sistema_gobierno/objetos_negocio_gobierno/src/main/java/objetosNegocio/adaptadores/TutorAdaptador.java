package objetosNegocio.adaptadores;
import datos.dominio.Tutor;
import datos.dominio.enums.Parentesco;
import dto_gobierno.TutorDTO;
import dto.gobierno.TutorDTOGobierno;
import objetosNegocio.adaptadores.excepciones.TutorAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorAdaptador {

    public static Tutor toEntity(TutorDTO dto){
        try {
            Tutor tutor = new Tutor();
            tutor.setId(dto.getId());
            tutor.setNombre(dto.getNombre());
            tutor.setParentesco(Parentesco.valueOf(dto.getParentesco()));
            tutor.setTelefono(dto.getTelefono());
            tutor.setDireccion(dto.getDireccion());
            tutor.setCorreo(dto.getCorreo());
            return tutor;
        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Tutor toEntity(TutorDTOGobierno dto){
        try {
            Tutor tutor = new Tutor();
            tutor.setId(dto.getId());
            tutor.setNombre(dto.getNombre());
            tutor.setParentesco(Parentesco.valueOf(dto.getParentesco()));
            tutor.setTelefono(dto.getTelefono());
            tutor.setDireccion(dto.getDireccion());
            tutor.setCorreo(dto.getCorreo());
            return tutor;
        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static TutorDTO toDTO(Tutor tutor){
        try {
            TutorDTO dto = new TutorDTO();
            dto.setId(tutor.getId());
            dto.setNombre(tutor.getNombre());
            dto.setParentesco(tutor.getParentesco().toString());
            dto.setTelefono(tutor.getTelefono());
            dto.setDireccion(tutor.getDireccion());
            dto.setCorreo(tutor.getCorreo());
            return dto;
        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static TutorDTOGobierno toInfraestructuraDTO(Tutor  tutor){
        try {
            TutorDTOGobierno dto = new TutorDTOGobierno();
            dto.setId(tutor.getId());
            dto.setNombre(tutor.getNombre());
            dto.setParentesco(tutor.getParentesco().toString());
            dto.setTelefono(tutor.getTelefono());
            dto.setDireccion(tutor.getDireccion());
            dto.setCorreo(tutor.getCorreo());
            return dto;
        } catch (Exception sinUso){
            throw new TutorAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
