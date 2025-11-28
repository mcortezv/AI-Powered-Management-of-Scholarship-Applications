package controles;
import api_publica.ItsonAPI;
import api_publica.interfaz.IItsonAPI;
import dto.itson.LoginDTOItson;

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

    public EstudianteResponseDTO verificarEstudiante(Long matricula){
        EstudianteResponseDTOI estudianteResponseDTOI = api.obtenerDatosEstudiante(matricula);
        EstudianteResponseDTO estudianteResponseDTO = new EstudianteResponseDTO();
        estudianteResponseDTO.setMatricula(estudianteResponseDTOI.getMatricula());
        estudianteResponseDTO.setNombre(estudianteResponseDTOI.getNombre());
        return null;
    }
}