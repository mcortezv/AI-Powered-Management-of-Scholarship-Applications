package controles;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;

/**
 * @author Escalante, Sebastian.
 */
public class ControlItson {

    public boolean verificarLogin(LoginDTO solicitudLoginDTO) {
        return true;
    }

    public EstudianteResponseDTO verificarEstudiante(Long matricula) {
        return null;
    }

    public HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula) {
        return null;
    }
}