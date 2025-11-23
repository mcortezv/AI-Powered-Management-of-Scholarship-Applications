package fachadas;
import controles.ControlInicioSesion;
import interfaces.IFachadaInicioSesion;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;

public class FachadaInicioSesion implements IFachadaInicioSesion {
    public ControlInicioSesion controlInicioSesion;

    public FachadaInicioSesion(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
    }

    @Override
    public EstudianteResponseDTO solicitarLogin(LoginDTO solicitudLoginDTO) {
        return controlInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public void solicitarLogOut() {
        controlInicioSesion.cerrarSesion();
    }
}
