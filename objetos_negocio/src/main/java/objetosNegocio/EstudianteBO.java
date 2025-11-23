package objetosNegocio;
import dominio.*;
import dto.EstudianteResponseDTO;
import interfaces.IEstudianteBO;
import interfaces.IFachadaITSON;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteBO implements IEstudianteBO {
    private IFachadaITSON fachadaITSON;

    public EstudianteBO(IFachadaITSON fachadaITSON){
        this.fachadaITSON = fachadaITSON;
    }

    @Override
    public Estudiante crearEstudiante(Long matricula, Tutor tutor){
        EstudianteResponseDTO dto = fachadaITSON.verificarEstudiante(matricula);
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(matricula);
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(dto.getCarrera());
        estudiante.setTutor(tutor);
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setDireccion(dto.getDireccion());
        estudiante.setCorreo(dto.getCorreo());
        return estudiante;
    }
}
