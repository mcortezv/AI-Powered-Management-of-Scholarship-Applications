package adaptadores;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.Carrera;
import dto.*;
import solicitarBeca.repository.documents.EstudianteDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteAdaptador {

    public static Estudiante toEntity(EstudianteResponseDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(dto.getMatricula());
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(dto.getCarrera());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setCorreo(dto.getCorreo());
        return estudiante;
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(dto.getMatricula());
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setCorreo(dto.getCorreo());
        return estudiante;
    }

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setMatricula(estudiante.getMatricula());
        dto.setNombre(estudiante.getNombre());
        dto.setTutor(TutorAdaptador.toDTO(estudiante.getTutor()));
        dto.setCarrera(estudiante.getCarrera().toString());
        dto.setTelefono(estudiante.getTelefono());
        dto.setDireccion(estudiante.getDireccion());
        dto.setCorreo(estudiante.getCorreo());
        return dto;
    }

    public static EstudianteDTO toDTO(EstudianteResponseDTO estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setMatricula(estudiante.getMatricula());
        dto.setNombre(estudiante.getNombre());
        dto.setCarrera(estudiante.getCarrera().toString());
        dto.setTelefono(estudiante.getTelefono());
        dto.setDireccion(estudiante.getDireccion());
        dto.setCorreo(estudiante.getCorreo());
        return dto;
    }

    public static EstudianteDocument toDocument(Estudiante estudiante) {
        EstudianteDocument document = new EstudianteDocument();
        document.set_id(new ObjectId());
        document.setMatricula(estudiante.getMatricula());
        document.setNombre(estudiante.getNombre());
        document.setCarrera(estudiante.getCarrera());
        document.setTelefono(estudiante.getTelefono());
        document.setDireccion(estudiante.getDireccion());
        document.setCorreo(estudiante.getCorreo());
        return document;
    }
}
