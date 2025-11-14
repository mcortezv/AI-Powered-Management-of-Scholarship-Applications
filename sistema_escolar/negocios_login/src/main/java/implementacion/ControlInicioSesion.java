package implementacion;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import objetosNegocio.mock.EstudianteMock;

public class ControlInicioSesion {
    public EstudianteMock estudianteMock;

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return estudianteMock.getEstudianteResponseDTO(solicitudLoginDTO);
    }
}
