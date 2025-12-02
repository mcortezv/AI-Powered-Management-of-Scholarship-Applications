package api_publica;
import api_publica.control.ControlItson;
import api_publica.interfaz.IItsonAPI;
import dto.itson.LoginDTOItson;
import itson.org.domain.Actividad;
import itson.org.domain.Estudiante;
import java.util.List;

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
    
    public List<Actividad> solicitarActividades(){
        return controlItson.solicitarActividades();
    }
}
