package controlLogin;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import gestor.ControlSolicitud;
import implementacion.FachadaSolicitud;
import interfaz.IFachadaSolicitud;

public class ControlLogin {

    private final IFachadaSolicitud fachadaSolicitud;
    public ControlLogin(){
        this.fachadaSolicitud = new FachadaSolicitud(new ControlSolicitud());
    }

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return fachadaSolicitud.validarInicioSesion(solicitudLoginDTO);
    }
}
