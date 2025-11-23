package adaptadores;
import dominio.Tutor;
import dominio.enums.Parentesco;
import dto.TutorDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorAdaptador {

    public static Tutor toEntity(TutorDTO dto) {
        Tutor tutor = new Tutor();
        tutor.setNombre(dto.getNombre());
        tutor.setParentesco(Parentesco.valueOf(dto.getParentesco()));
        tutor.setTelefono(dto.getTelefono());
        tutor.setDireccion(dto.getDireccion());
        tutor.setCorreo(dto.getCorreo());
        return tutor;
    }

    public static TutorDTO toDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setNombre(tutor.getNombre());
        dto.setParentesco(tutor.getParentesco().toString());
        dto.setTelefono(tutor.getTelefono());
        dto.setDireccion(tutor.getDireccion());
        dto.setCorreo(tutor.getCorreo());
        return dto;
    }
}
