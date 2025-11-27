package controles;

import api_publica.ItsonAPI;
import api_publica.interfaz.IItsonAPI;
import dto.EstudianteResponseDTO;
import dto.LoginDTO;
import itson.org.dto.EstudianteResponseDTOI;
import itson.org.dto.LoginDTOI;

public class ControlItson {
    IItsonAPI api;

    public ControlItson(){
        this.api = new ItsonAPI();
    }

    public boolean verificarLogin(LoginDTO loginDTO) {
        LoginDTOI dtoInfra = new LoginDTOI();
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