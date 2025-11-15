package implementacion;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import objetosNegocio.mock.EstudianteMock;

// todos los metodos para llevar a cabo las acciones

public class ControlInicioSesion {
    private EstudianteMock estudianteMock= EstudianteMock.getInstance();

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }

    // cerrrar sesion
}
