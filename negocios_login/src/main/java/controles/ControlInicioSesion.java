package controles;
import dto.LoginDTO;
import objetosNegocio.EstudianteBO;


public class ControlInicioSesion {
    private final EstudianteBO estudianteBO;

    public ControlInicioSesion(EstudianteBO estudianteBO) {
        this.estudianteBO = estudianteBO;
    }

    public boolean solicitarLogin(LoginDTO solicitudLoginDTO){
        return estudianteBO.iniciarSesion(solicitudLoginDTO);
    }

    public void cerrarSesion(){
        System.out.println("Cerrrando sesion...");
    }
}

