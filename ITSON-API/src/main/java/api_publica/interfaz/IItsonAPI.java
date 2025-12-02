package api_publica.interfaz;
import dto.itson.EstudianteDTOItson;
import dto.itson.LoginDTOItson;
import itson.org.domain.Actividad;
import itson.org.domain.Estudiante;
import java.util.List;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);
    
    public List<Actividad> solicitarActividades();
}
