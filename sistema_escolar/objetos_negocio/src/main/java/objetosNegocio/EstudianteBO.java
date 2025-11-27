package objetosNegocio;
import solicitarBeca.repository.IEstudianteDAO;
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
    public EstudianteResponseDTO crearEstudiante(Long matricula){
        return fachadaITSON.verificarEstudiante(matricula);
    }
}
