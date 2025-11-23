package adaptadores;
import dominio.*;
import dominio.enums.Carrera;
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

    public static Estudiante toEntity(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(Long.valueOf(dto.getMatricula()));
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setCorreo(dto.getCorreo());
        return estudiante;
    }

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setMatricula(Long.valueOf(estudiante.getMatricula()));
        dto.setNombre(estudiante.getNombre());
        dto.setTutor(TutorAdaptador.toDTO(estudiante.getTutor()));
        dto.setCarrera(estudiante.getCarrera().toString());
        dto.setTelefono(estudiante.getTelefono());
        dto.setDireccion(estudiante.getDireccion());
        dto.setCorreo(estudiante.getCorreo());
        return dto;
    }
}
