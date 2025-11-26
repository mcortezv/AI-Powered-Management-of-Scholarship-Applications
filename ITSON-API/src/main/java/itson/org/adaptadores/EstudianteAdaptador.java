package itson.org.adaptadores;

import itson.org.domain.Estudiante;
import itson.org.dto.EstudianteResponseDTO;

public class EstudianteAdaptador {

    public static EstudianteResponseDTO toResponseDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }
        return new EstudianteResponseDTO(
                estudiante.getCarrera(),
                estudiante.getCorreo(),
                estudiante.getDireccion(),
                estudiante.getMatricula(),
                estudiante.getNombre(),
                estudiante.getTelefono()
        );
    }
}
