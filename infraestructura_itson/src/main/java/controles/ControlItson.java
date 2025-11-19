package controles;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import interfaces.IITSON;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * @author Escalante, Sebastian.
 */
public class ControlItson implements IITSON {

    private static final String ITSON_BASE_URL = "http://localhost:8080/api/";
    private static final String LOGIN_ENDPOINT = "login/";

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public Optional<EstudianteResponseDTO> verificarLogin(SolicitudLoginDTO solicitudLoginDTO) {

        final String jsonCredenciales;
        try {
            jsonCredenciales = objectMapper.writeValueAsString(solicitudLoginDTO);
        } catch (IOException e) {
            System.err.println("Error al serializar las credenciales a JSON.");
            return Optional.empty();
        }

        String url = ITSON_BASE_URL + LOGIN_ENDPOINT;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonCredenciales))
                .build();

        return ejecutarPeticionYMapeo(request);
    }

    private Optional<EstudianteResponseDTO> ejecutarPeticionYMapeo(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonBody = response.body();
                EstudianteResponseDTO dto = objectMapper.readValue(jsonBody, EstudianteResponseDTO.class);
                return Optional.of(dto);

            } else if (response.statusCode() == 401) {
                System.out.println("Login fallido. Código: 401 Unauthorized (Credenciales incorrectas).");
                return Optional.empty();

            } else {
                System.err.println("Error del servidor o cliente al intentar login. Código: " + response.statusCode());
                return Optional.empty();
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error de comunicación con el agente ITSON: " + e.getMessage());
            e.printStackTrace();
            return Optional.empty();
        }
    }
}