package objetosNegocio.adaptadores;
import datos.dominio.Estudiante;
import datos.dominio.enums.Carrera;
import dto_gobierno.EstudianteDTO;
import dto.gobierno.EstudianteDTOGobierno;
import objetosNegocio.adaptadores.excepciones.EstudianteAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteAdaptador {

    public static Estudiante toEntity(EstudianteDTO dto){
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(dto.getMatricula());
            estudiante.setNombre(dto.getNombre());
            estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
            estudiante.setTutor(TutorAdaptador.toEntity(dto.getTutor()));
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setDireccion(dto.getDireccion());
            estudiante.setCorreo(dto.getCorreo());
            return estudiante;
        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Estudiante toEntity(EstudianteDTOGobierno dto){
        try {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(dto.getMatricula());
            estudiante.setNombre(dto.getNombre());
            estudiante.setCarrera(Carrera.valueOf(dto.getCarrera()));
            estudiante.setTutor(TutorAdaptador.toEntity(dto.getTutor()));
            estudiante.setTelefono(dto.getTelefono());
            estudiante.setDireccion(dto.getDireccion());
            estudiante.setCorreo(dto.getCorreo());
            return estudiante;
        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static EstudianteDTO toDTO(Estudiante estudiante){
        try {
            EstudianteDTO dto = new EstudianteDTO();
            dto.setMatricula(estudiante.getMatricula());
            dto.setNombre(estudiante.getNombre());
            dto.setCarrera(estudiante.getCarrera().toString());
            dto.setTutor(TutorAdaptador.toDTO(estudiante.getTutor()));
            dto.setTelefono(estudiante.getTelefono());
            dto.setDireccion(estudiante.getDireccion());
            dto.setCorreo(estudiante.getCorreo());
            return dto;
        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static EstudianteDTOGobierno toInfraestructuraDTO(Estudiante  estudiante){
        try {
            EstudianteDTOGobierno dto = new EstudianteDTOGobierno();
            dto.setMatricula(estudiante.getMatricula());
            dto.setNombre(estudiante.getNombre());
            dto.setCarrera(estudiante.getCarrera().toString());
            dto.setTutor(TutorAdaptador.toInfraestructuraDTO(estudiante.getTutor()));
            dto.setTelefono(estudiante.getTelefono());
            dto.setDireccion(estudiante.getDireccion());
            dto.setCorreo(estudiante.getCorreo());
            return dto;
        } catch (Exception sinUso){
            throw new EstudianteAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
