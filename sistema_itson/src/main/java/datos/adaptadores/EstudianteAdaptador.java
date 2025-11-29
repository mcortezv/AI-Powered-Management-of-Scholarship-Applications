package datos.adaptadores;
import itson.EstudianteDTOItson;
import datos.dominio.Estudiante;

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
