package objetosNegocio;
import solicitarBeca.repository.IEstudianteDAO;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import interfaces.IEstudianteBO;
import interfaces.IFachadaITSON;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.Tutor;

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
        System.out.println("Llego al EstudianteBO");
        return fachadaITSON.verificarLogin(solicitudLoginDTO);
    }

    @Override
    public Estudiante crearEstudiante(String matricula, Tutor tutor){
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
