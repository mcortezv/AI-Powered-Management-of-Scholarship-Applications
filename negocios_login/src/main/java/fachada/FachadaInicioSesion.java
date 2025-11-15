package fachada;

import implementacion.ControlInicioSesion;
import interfaz.IFachadaInicioSesion;
import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
public class FachadaInicioSesion implements IFachadaInicioSesion {
    public ControlInicioSesion controlInicioSesion;

    public FachadaInicioSesion(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
    }

    @Override
    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO) {
        return controlInicioSesion.solicitarLogin(solicitudLoginDTO);
    }
}
