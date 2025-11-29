package controles;
import bo.sesion.SesionUsuario;
import itson.LoginDTOItson;
import interfaces.solicitarBeca.IEstudianteBO;
import solicitarBeca.EstudianteDTO;


public class ControlInicioSesion {
    private final IEstudianteBO estudianteBO;
    private final SesionUsuario sesionUsuario = SesionUsuario.getInstance();

    public ControlInicioSesion(IEstudianteBO estudianteBO) {
        this.estudianteBO = estudianteBO;
    }

    public boolean solicitarLogin(LoginDTOItson solicitudLoginDTO){
        return estudianteBO.iniciarSesion(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        estudianteBO.cerrarSesion();
    }

    public EstudianteDTO getEstudianteLogueado() {
        return sesionUsuario.getEstudianteLogeado();
    }
}

