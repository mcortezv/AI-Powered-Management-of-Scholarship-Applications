package fachadas;
import controles.ControlInicioSesion;
import interfaces.IFachadaInicioSesion;
import dto.LoginDTO;

public class FachadaInicioSesion implements IFachadaInicioSesion {
    public ControlInicioSesion controlInicioSesion;

    public FachadaInicioSesion(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
    }

    @Override
    public boolean solicitarLogin(LoginDTO solicitudLoginDTO) {
        System.out.println("llego al FachadaInicioSesion");
        return controlInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public void solicitarLogOut() {
        controlInicioSesion.cerrarSesion();
    }
}
