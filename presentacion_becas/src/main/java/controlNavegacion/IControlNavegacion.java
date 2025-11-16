package controlNavegacion;

import dto.EstudianteResponseDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudLoginDTO;

public interface IControlNavegacion {
    EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO);
    SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    void SolicitarCerrarSesion();
}
