package apiItson;
import apiItson.controles.ControlItson;
import apiItson.interfaces.IItsonAPI;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;

public class ItsonAPI implements IItsonAPI {
    private final ControlItson controlItson;

    public ItsonAPI(){
        this.controlItson = new ControlItson();
    }

    @Override
    public boolean verificarLogin(LoginDTOItson dto) {
        return controlItson.verificarLogin(dto);
    }

    @Override
    public Estudiante obtenerDatosEstudiante(Long matricula) {
       return controlItson.solicitarDatosEstudiante(matricula);
    }
}
