package implementacion;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import objetosNegocio.mock.EstudianteMock;

public class ControlInicioSesion {
    private EstudianteMock estudianteMock= EstudianteMock.getInstance();

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }
}
