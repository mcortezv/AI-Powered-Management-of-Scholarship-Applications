package datos.adaptadoresItson;
import itson.EstudianteDTOItson;
import datos.dominioItson.Estudiante;

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
