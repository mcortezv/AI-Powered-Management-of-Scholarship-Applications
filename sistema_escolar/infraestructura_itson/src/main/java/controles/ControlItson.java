package controles;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;

/**
 *  FASE DE PRUEBAS PARA HACER LA COMUNICACION CON LA API EXTERNA DE ITSON
 *  LA COMUNICACON CON LA API EXTERNA DE ITSON SERÁ MEDIANTE MONGO DB ATLAS,
 *  "CONTROLITSON" FUNCIONARÁ COMO UNA "DAO" QUE REALICE CONSULTAS
 *  A LAS DIFERENTES COLECCIONES YA ESTABLECIDAS EN MONGO
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

    public double solicitarAdeudoBiblioteca(String matriculaEstudiante){
      return 0.0;
    }

    public double solicitarAdeudoColegiatura(String matriculaEstudiante){
        return 0.0;
    }

    /**
     * AQUI TERMINA CASO DE USO PAGAR ADEUDO
     */
}