package fachadas;
import controles.ControlInicioSesion;
import itson.LoginDTOItson;
import interfaces.IFachadaInicioSesion;
import solicitarBeca.EstudianteDTO;

public class FachadaInicioSesion implements IFachadaInicioSesion {
    public ControlInicioSesion controlInicioSesion;

    public FachadaInicioSesion(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
    }

    @Override
    public boolean solicitarLogin(LoginDTOItson solicitudLoginDTO) {
        return controlInicioSesion.solicitarLogin(solicitudLoginDTO);
    }

    @Override
    public void solicitarLogOut() {
        controlInicioSesion.cerrarSesion();
    }

    public EstudianteDTO getEstudianteLogueado() {
        return controlInicioSesion.getEstudianteLogueado();
    }
}
