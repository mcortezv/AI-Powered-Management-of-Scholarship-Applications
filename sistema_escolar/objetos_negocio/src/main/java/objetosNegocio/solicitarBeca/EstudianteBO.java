package objetosNegocio.solicitarBeca;
import dto.itson.LoginDTOItson;
import objetosNegocio.solicitarBeca.excepciones.EstudianteInvalidoException;
import solicitarBeca.repository.IEstudianteDAO;
import dto.itson.EstudianteDTOItson;
import interfaces.solicitarBeca.IEstudianteBO;
import interfaces.IFachadaITSON;
import solicitarBeca.repository.documents.EstudianteDocument;

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
    public boolean iniciarSesion(LoginDTOItson solicitudLoginDTO){
        try {
            return fachadaITSON.verificarLogin(solicitudLoginDTO);
        } catch (EstudianteInvalidoException ex) {
            throw new EstudianteInvalidoException("Error en las credenciales del estudiante");
        }
    }

    @Override
    public EstudianteDTOItson crearEstudiante(Long matricula){
        return fachadaITSON.verificarEstudiante(matricula);
    }

    @Override
    public void guardarEstudiante(EstudianteDocument estudiante) throws EstudianteInvalidoException {
        try {
            estudianteDAO.create(estudiante);
        } catch (Exception ex) {
            throw new EstudianteInvalidoException(ex.getMessage());
        }
    }
}
