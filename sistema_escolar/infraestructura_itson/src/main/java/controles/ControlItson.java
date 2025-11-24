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


    /**
     * TODO ESTO ES PARA EL CASO DE USO PAGAR ADEUDO
     */

    double solicitarAdeudoBiblioteca(String matriculaEstudiante){
        return 0.0;
    }

    /**
     * AQUI TERMINA CASO DE USO PAGAR ADEUDO
     */
}