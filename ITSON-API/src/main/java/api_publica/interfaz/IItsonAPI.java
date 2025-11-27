package api_publica.interfaz;

import itson.org.domain.Estudiante;
import itson.org.dto.LoginDTOI;

public interface IItsonAPI {
    boolean verificarLogin(LoginDTOI dto);
    Estudiante obtenerDatosEstudiante(LoginDTOI dto);
}
