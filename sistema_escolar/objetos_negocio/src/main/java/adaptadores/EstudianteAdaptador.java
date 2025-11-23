package adaptadores;
import dominio.*;
import dto.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteAdaptador {

    public static Estudiante toEntity(EstudianteResponseDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(Long.valueOf(dto.getMatricula()));
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(dto.getCarrera());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setCorreo(dto.getCorreo());
        return estudiante;
    }
}
