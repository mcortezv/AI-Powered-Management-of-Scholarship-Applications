package presentacion.coordinadorNegocio;

import dto.*;

public interface ICoordinadorNegocio {
    EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO);
    SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    void SolicitarCerrarSesion();
    boolean enviarSolicitudAGobierno(SolicitudDTO solicitudDTO);
}
