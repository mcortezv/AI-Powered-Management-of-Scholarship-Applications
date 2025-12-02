package controles;
import api_publica.ItsonAPI;
import api_publica.interfaz.IItsonAPI;
import dto.itson.ActividadDTOItson;
import dto.itson.ActividadesDTOItson;
import dto.itson.EstudianteDTOItson;
import dto.itson.LoginDTOItson;
import dto_gobierno.EstudianteDTO;
import itson.org.adaptadores.ActividadAdaptador;
import itson.org.adaptadores.EstudianteAdaptador;
import itson.org.domain.Actividad;
import itson.org.domain.Estudiante;
import java.util.List;

public class ControlItson {
    IItsonAPI api;

    public ControlItson(){
        this.api = new ItsonAPI();
    }

    public boolean verificarLogin(LoginDTOItson loginDTO) {
        LoginDTOItson dtoInfra = new LoginDTOItson();
        dtoInfra.setUsuario(loginDTO.getUsuario());
        dtoInfra.setContrasenia(loginDTO.getContrasenia());
        return api.verificarLogin(dtoInfra);
    }

    public EstudianteDTOItson verificarEstudiante(Long matricula){
        Estudiante estudiante = api.obtenerDatosEstudiante(matricula);
        return EstudianteAdaptador.toResponseDTO(estudiante);
    }
    
    public ActividadesDTOItson obtenerActividades(){
        List<Actividad> actividad= api.solicitarActividades();
        return ActividadAdaptador.toResponseDTOListaAct(actividad);
        
        //return api.solicitarActividades();
    }

}