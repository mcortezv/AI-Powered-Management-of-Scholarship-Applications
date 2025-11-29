package apiItson.interfaces;
import datos.dominio.HistorialAcademico;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);

    HistorialAcademico obtenerHistorialAcademico(Long matricula);
}
