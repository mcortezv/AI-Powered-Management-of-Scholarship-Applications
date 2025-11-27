package api_publica.interfaz;

import itson.org.dto.EstudianteResponseDTOI;
import itson.org.dto.LoginDTOI;

public interface IItsonAPI {
    boolean verificarLogin(LoginDTOI dto);
    EstudianteResponseDTOI obtenerDatosEstudiante(Long matricula);
}
