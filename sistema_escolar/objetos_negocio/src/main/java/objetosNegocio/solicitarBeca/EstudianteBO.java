package objetosNegocio.solicitarBeca;
import adaptadores.solicitarBeca.EstudianteAdaptador;
import dto.EstudianteDTO;
import dto.itson.LoginDTOItson;
import objetosNegocio.sesion.SesionUsuario;
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
    public boolean iniciarSesion(LoginDTOItson solicitudLoginDTO) {
        try {
            boolean credencialesCorrectas = fachadaITSON.verificarLogin(solicitudLoginDTO);
            if (credencialesCorrectas) {
                Long matricula = solicitudLoginDTO.getUsuario();
                EstudianteDTOItson estudianteCompleto = fachadaITSON.verificarEstudiante(matricula);
                if (estudianteCompleto == null) {
                    return false;
                }
                SesionUsuario.getInstance().setEstudianteLogueado(EstudianteAdaptador.toDTO(estudianteCompleto));
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EstudianteInvalidoException(ex.getMessage());
        }
    }

//    @Override
//    public boolean iniciarSesion(LoginDTOItson solicitudLoginDTO){
//        try {
//            return fachadaITSON.verificarLogin(solicitudLoginDTO);
//        } catch (EstudianteInvalidoException ex) {
//            throw new EstudianteInvalidoException(ex.getMessage());
//        }
//    }

    @Override
    public void cerrarSesion() {
        SesionUsuario.getInstance().limpiarSesion();
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
