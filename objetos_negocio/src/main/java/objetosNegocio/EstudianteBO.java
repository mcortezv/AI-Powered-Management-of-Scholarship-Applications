package objetosNegocio;
import dao.interfaces.IEstudianteDAO;
import dominio.*;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import interfaces.IEstudianteBO;
import interfaces.IFachadaITSON;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteBO implements IEstudianteBO {
    private final IFachadaITSON fachadaITSON;
    private final IEstudianteDAO estudianteDAO;

    public EstudianteBO(IFachadaITSON fachadaITSON, IEstudianteDAO estudianteDAO){
        this.fachadaITSON = fachadaITSON;
        this.estudianteDAO = estudianteDAO;
    }

    @Override
    public boolean iniciarSesion(LoginDTO solicitudLoginDTO){
        return fachadaITSON.verificarLogin(solicitudLoginDTO);
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
