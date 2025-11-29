package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import adaptadores.solicitarBeca.excepciones.EstudianteAdaptadorException;
import solicitarBeca.EstudianteDTO;
import gobierno.EstudianteDTOGobierno;
import itson.EstudianteDTOItson;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.Carrera;
import solicitarBeca.repository.documents.EstudianteDocument;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteAdaptador {

    public static Estudiante toEntity(EstudianteDTOItson dto) {
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(dto.getMatricula());
            estudiante.setNombre(dto.getNombre());
            estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setDireccion(dto.getDireccion());
            estudiante.setCorreo(dto.getCorreo());
            return estudiante;
        } catch (Exception ex) {
            throw new EstudianteAdaptadorException("Error al convertir DTO Estudiante a Entidad");
        }
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(dto.getMatricula());
            estudiante.setNombre(dto.getNombre());
            estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setDireccion(dto.getDireccion());
            estudiante.setCorreo(dto.getCorreo());
            return estudiante;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir DTO Estudiante a Entidad");
        }
    }

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        try {
            EstudianteDTO dto = new EstudianteDTO();
            dto.setMatricula(estudiante.getMatricula());
            dto.setNombre(estudiante.getNombre());
            dto.setTutor(TutorAdaptador.toDTO(estudiante.getTutor()));
            dto.setCarrera(estudiante.getCarrera().toString());
            dto.setTelefono(estudiante.getTelefono());
            dto.setDireccion(estudiante.getDireccion());
            dto.setCorreo(estudiante.getCorreo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad Estudiante a DTO");
        }
    }

    public static EstudianteDTO toDTO(EstudianteDTOItson estudiante) {
        try {
            EstudianteDTO dto = new EstudianteDTO();
            dto.setMatricula(estudiante.getMatricula());
            dto.setNombre(estudiante.getNombre());
            dto.setCarrera(estudiante.getCarrera().toString());
            dto.setTelefono(estudiante.getTelefono());
            dto.setDireccion(estudiante.getDireccion());
            dto.setCorreo(estudiante.getCorreo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir ResponseDTO Estudiante a DTO");
        }
    }

    public static EstudianteDTOGobierno toDTOGobierno(Estudiante estudiante) {
        try {
            EstudianteDTOGobierno dto = new EstudianteDTOGobierno();
            dto.setMatricula(estudiante.getMatricula());
            dto.setNombre(estudiante.getNombre());
            dto.setCarrera(estudiante.getCarrera().toString());
            dto.setTelefono(estudiante.getTelefono());
            dto.setDireccion(estudiante.getDireccion());
            dto.setCorreo(estudiante.getCorreo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir ResponseDTO Estudiante a DTO");
        }
    }

    public static EstudianteDocument toDocument(Estudiante estudiante) {
        try {
            EstudianteDocument document = new EstudianteDocument();
            document.set_id(new ObjectId());
            document.setMatricula(estudiante.getMatricula());
            document.setNombre(estudiante.getNombre());
            document.setCarrera(estudiante.getCarrera());
            document.setTelefono(estudiante.getTelefono());
            document.setDireccion(estudiante.getDireccion());
            document.setCorreo(estudiante.getCorreo());
            return document;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad Estudiante a Document");
        }
    }
}
