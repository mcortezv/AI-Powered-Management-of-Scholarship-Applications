package api_publica.interfaz;
import dto.itson.LoginDTOItson;
import itson.org.domain.Estudiante;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);
}
