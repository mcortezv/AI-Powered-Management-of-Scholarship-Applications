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

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_BASE_URL = "http://localhost:8081/adeudos/itson";


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
        String tipoAdeudo = "biblioteca";
        String url = String.format("%s/%s/%s", API_BASE_URL, tipoAdeudo, matriculaEstudiante);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                double monto = objectMapper.readTree(response.body()).get("monto").asDouble();
                return monto;
            } else {
                System.err.println("Error HTTP (" + response.statusCode() + ") al solicitar adeudo de " + tipoAdeudo);
                return -1.0;
            }
        } catch (Exception e) {
            System.err.println("Error de conexión con la API de ITSON para " + tipoAdeudo + ": " + e.getMessage());
            return -2.0;
        }
    }

    public double solicitarAdeudoColegiatura(String matriculaEstudiante){

        String tipoAdeudo = "colegiatura";
        String url = String.format("%s/%s/%s", API_BASE_URL, tipoAdeudo, matriculaEstudiante);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                double monto = objectMapper.readTree(response.body()).get("monto").asDouble();
                return monto;
            } else {
                System.err.println("Error HTTP (" + response.statusCode() + ") al solicitar adeudo de " + tipoAdeudo);
                return -1.0;
            }
        } catch (Exception e) {
            System.err.println("Error de conexión con la API de ITSON para " + tipoAdeudo + ": " + e.getMessage());
            return -2.0;
        }
    }

    /**
     * AQUI TERMINA CASO DE USO PAGAR ADEUDO
     */
}