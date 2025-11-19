package presentacion.coordinadorNegocio;

import dto.*;
import fachada.FachadaInicioSesion;
import fachada.FachadaSolicitud;
import implementacion.ControlInicioSesion;
import implementacion.ControlSolicitud;
import interfaz.IFachadaInicioSesion;
import interfaz.IFachadaSolicitud;
import presentacion.login.MainFrame;

public class CoordinadorNegocio implements ICoordinadorNegocio{

    private final IFachadaInicioSesion iFachadaInicioSesion;
    private final IFachadaSolicitud iFachadaSolicitud;

    public CoordinadorNegocio() {
        ControlInicioSesion controlInicioSesion = new ControlInicioSesion();
        this.iFachadaInicioSesion = new FachadaInicioSesion(controlInicioSesion);
        ControlSolicitud controlSolicitud = new ControlSolicitud();
        this.iFachadaSolicitud = new FachadaSolicitud(controlSolicitud);
    }


    @Override
    public EstudianteResponseDTO solicitarInicioSesion(SolicitudLoginDTO solicitudLoginDTO) {
        return iFachadaInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public SolicitudBecasDisponiblesResponseDTO obtenerBecasDisponibles(SolicitudBecasDisponiblesDTO solicitudDTO) {
        return iFachadaSolicitud.obtenerBecasDisponibles(solicitudDTO);
    }

    @Override
    public void SolicitarCerrarSesion() {
        iFachadaInicioSesion.solicitarCerrarSesion();
    }

    @Override
    public boolean enviarSolicitudAGobierno(SolicitudDTO solicitudDTO) {
        return iFachadaSolicitud.enviarSolicitudBeca(solicitudDTO);
    }

}
