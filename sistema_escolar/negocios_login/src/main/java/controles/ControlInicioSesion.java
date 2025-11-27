package controles;
import dto.LoginDTO;
import interfaces.solicitarBeca.IEstudianteBO;


public class ControlInicioSesion {
    private final IEstudianteBO estudianteBO;

    public ControlInicioSesion(IEstudianteBO estudianteBO) {
        this.estudianteBO = estudianteBO;
    }

    public boolean solicitarLogin(LoginDTO solicitudLoginDTO){
        System.out.println("llego al ControlInicioSesion");
        return estudianteBO.iniciarSesion(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        System.out.println("Cerrrando sesion...");
    }
}

