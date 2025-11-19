package presentacion.coordinadorNegocio;

import dto.EstudianteResponseDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudLoginDTO;

public interface ICoordinadorNegocio {
    EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO);
    SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    void SolicitarCerrarSesion();
}
