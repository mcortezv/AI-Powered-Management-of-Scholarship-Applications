package controles;
import api_publica.ItsonAPI;
import api_publica.interfaz.IItsonAPI;
import dto.itson.EstudianteDTOItson;
import dto.itson.LoginDTOItson;
import dto_gobierno.EstudianteDTO;
import itson.org.adaptadores.EstudianteAdaptador;
import itson.org.domain.Estudiante;

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

}