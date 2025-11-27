package itson.org.adaptadores;

import itson.org.domain.Estudiante;
import itson.org.dto.EstudianteResponseDTOI;

public class EstudianteAdaptador {

    public static EstudianteResponseDTOI toResponseDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }
        return new EstudianteResponseDTOI(
                estudiante.getCarrera(),
                estudiante.getCorreo(),
                estudiante.getDireccion(),
                estudiante.getMatricula(),
                estudiante.getNombre(),
                estudiante.getTelefono()
        );
    }
}
