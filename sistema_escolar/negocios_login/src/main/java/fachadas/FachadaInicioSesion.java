package fachadas;
import controles.ControlInicioSesion;
import itson.LoginDTOItson;
import interfaces.IFachadaInicioSesion;

public class FachadaInicioSesion implements IFachadaInicioSesion {
    public ControlInicioSesion controlInicioSesion;

    public FachadaInicioSesion(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
    }

    @Override
    public boolean solicitarLogin(LoginDTOItson solicitudLoginDTO) {
        System.out.println("llego al FachadaInicioSesion");
        return controlInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public void solicitarLogOut() {
        controlInicioSesion.cerrarSesion();
    }
}
