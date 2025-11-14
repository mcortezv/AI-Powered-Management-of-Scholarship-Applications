package interfaz;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;

public interface IFachadaInicioSesion {
    EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO);
}
