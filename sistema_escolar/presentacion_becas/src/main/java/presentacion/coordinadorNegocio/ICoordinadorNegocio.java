package presentacion.coordinadorNegocio;

import dto.*;

public interface ICoordinadorNegocio {
    EstudianteResponseDTO solicitarInicioSesion(LoginDTO solicitudLoginDTO);
    BecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO);
    void SolicitarCerrarSesion();
    boolean enviarSolicitudAGobierno(SolicitudDTO solicitudDTO);
}
