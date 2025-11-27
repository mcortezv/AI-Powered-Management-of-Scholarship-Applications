package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import adaptadores.solicitarBeca.excepciones.TutorAdaptadorException;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Parentesco;
import dto.TutorDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorAdaptador {

    public static Tutor toEntity(TutorDTO dto) {

        try {
            Tutor tutor = new Tutor();
            tutor.setNombre(dto.getNombre());
            tutor.setParentesco(Parentesco.valueOf(dto.getParentesco()));
            tutor.setTelefono(dto.getTelefono());
            tutor.setDireccion(dto.getDireccion());
            tutor.setCorreo(dto.getCorreo());
            return tutor;
        } catch (Exception ex) {
            throw new TutorAdaptadorException("Error al convertir DTO Tutor a entidad");
        }
    }

    public static TutorDTO toDTO(Tutor tutor) {
        try {
            TutorDTO dto = new TutorDTO();
            dto.setNombre(tutor.getNombre());
            dto.setParentesco(tutor.getParentesco().toString());
            dto.setTelefono(tutor.getTelefono());
            dto.setDireccion(tutor.getDireccion());
            dto.setCorreo(tutor.getCorreo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad Tutor a DTO");
        }
    }
}
