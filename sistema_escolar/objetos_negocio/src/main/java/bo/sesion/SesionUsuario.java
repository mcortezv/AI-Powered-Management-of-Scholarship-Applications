package bo.sesion;
import solicitarBeca.EstudianteDTO;
public class SesionUsuario {
    private static SesionUsuario instancia;
    private EstudianteDTO estudianteLogeado;

    private SesionUsuario(){}

    public static SesionUsuario getInstance(){
        if(instancia == null){
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public EstudianteDTO getEstudianteLogeado(){
        return estudianteLogeado;
    }
    public void setEstudianteLogueado(EstudianteDTO estudianteLogueado) {
        this.estudianteLogeado = estudianteLogueado;
    }

    public void limpiarSesion(){
        this.estudianteLogeado = null;
    }
    public boolean haySesionActiva(){
        return this.estudianteLogeado != null;
    }
}
