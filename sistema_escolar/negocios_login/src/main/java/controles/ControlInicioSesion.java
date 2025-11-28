package controles;
import itson.LoginDTOItson;
import interfaces.solicitarBeca.IEstudianteBO;


public class ControlInicioSesion {
    private final IEstudianteBO estudianteBO;

    public ControlInicioSesion(IEstudianteBO estudianteBO) {
        this.estudianteBO = estudianteBO;
    }

    public boolean solicitarLogin(LoginDTOItson solicitudLoginDTO){
        System.out.println("llego al ControlInicioSesion");
        return estudianteBO.iniciarSesion(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        estudianteBO.cerrarSesion();
    }
}

