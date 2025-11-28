package itson.org.adaptadores;
import dto.itson.EstudianteDTOItson;
import itson.org.domain.Estudiante;

public class EstudianteAdaptador {

    public static EstudianteDTOItson toResponseDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }
        return new EstudianteDTOItson(
                estudiante.getCarrera().toString(),
                estudiante.getCorreo(),
                estudiante.getDireccion(),
                estudiante.getMatricula(),
                estudiante.getNombre(),
                estudiante.getTelefono()
        );
    }
}
