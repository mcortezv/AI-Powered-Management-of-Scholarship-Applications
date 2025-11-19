package presentacion.coordinadorNegocio;

import dto.EstudianteResponseDTO;
import dto.SolicitudBecasDisponiblesDTO;
import dto.SolicitudBecasDisponiblesResponseDTO;
import dto.SolicitudLoginDTO;
import presentacion.login.MainFrame;

public class CoordinadorNegocio implements ICoordinadorNegocio{

    @Override
    public EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        return null;
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return null;
    }

    @Override
    public void SolicitarCerrarSesion() {

    }
}
