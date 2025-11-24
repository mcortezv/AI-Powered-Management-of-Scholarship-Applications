package controles;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import dto.pagarAdeudo.PrestamoDTOI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 *  FASE DE PRUEBAS PARA HACER LA COMUNICACION CON LA API EXTERNA DE ITSON POR MEDIO DE HTTP
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