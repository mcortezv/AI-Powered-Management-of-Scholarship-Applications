package apiItson.interfaces;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);
}
