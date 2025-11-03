package gobierno;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.SolicitudDTO;
import interfaces.IGobierno;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class Gobierno implements IGobierno {

    private static final String GOBIERNO_BASE_URL = "http://localhost:8081/api/";
    private static final String SOLICITUD_ENDPOINT = "solicitudes/";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public Optional<Boolean> enviarSolicitud(SolicitudDTO solicitudDTO) {
        final String jsonSolicitud;
        try {
            jsonSolicitud = objectMapper.writeValueAsString(solicitudDTO);
        } catch (IOException e) {
            System.err.println("Error al serializar la SolicitudDTO a JSON.");
            e.printStackTrace();
            return Optional.of(false);
        }

        String url = GOBIERNO_BASE_URL + SOLICITUD_ENDPOINT;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonSolicitud))
                .build();
        return ejecutarPeticion(request);
    }

    private Optional<Boolean> ejecutarPeticion(HttpRequest request) {
        try {
            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

            if (response.statusCode() == 200 || response.statusCode() == 201) {
                System.out.println("Solicitud enviada exitosamente. Código: " + response.statusCode());
                return Optional.of(true);

            } else if (response.statusCode() == 400) {
                System.err.println("Error de cliente: Datos de solicitud inválidos. Código: 400.");
                return Optional.of(false);

            } else {
                System.err.println("Error del servidor de Gobierno. Código: " + response.statusCode());
                return Optional.of(false);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error de comunicación con el agente Gobierno: " + e.getMessage());
            e.printStackTrace();
            return Optional.empty();
        }
    }
}