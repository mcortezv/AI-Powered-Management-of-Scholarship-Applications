package apiItson.interfaces;
import datos.dominioItson.Actividad;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Prestamo;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;

import java.util.List;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);

    HistorialAcademico obtenerHistorialAcademico(Long matricula);

    double obtenerAdeudoBiblioteca(Long matricula);

    double obtenerAdeudoColegiatura(Long matricula);

    List<Actividad> soloicitarActividades();


    //pagar adeudo
    List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula);


}
