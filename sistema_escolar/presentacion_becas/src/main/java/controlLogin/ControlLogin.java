package controlLogin;

import dto.EstudianteResponseDTO;
import dto.SolicitudLoginDTO;
import gestor.ControlSolicitud;
import implementacion.FachadaSolicitud;
import interfaz.IFachadaSolicitud;

public class ControlLogin {
    private IFachadaSolicitud manejador;
    public ControlLogin(){
        this.manejador = new FachadaSolicitud(new ControlSolicitud());
    }

    public EstudianteResponseDTO solicitarLogin(SolicitudLoginDTO solicitudLoginDTO){
        return manejador.validarInicioSesion(solicitudLoginDTO);
    }
}
