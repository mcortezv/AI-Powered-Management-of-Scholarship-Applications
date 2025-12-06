package apiItson.interfaces;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Prestamo;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;
import itson.actividades.GruposResponseDTOItson;
import itson.actividades.InscripcionDTOItson;

import java.util.List;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);

    HistorialAcademico obtenerHistorialAcademico(Long matricula);

    double obtenerAdeudoBiblioteca(Long matricula);

    double obtenerAdeudoColegiatura(Long matricula);

   


    //pagar adeudo
    List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula);
    
    
    //actividades
     ActividadesDTOItson soloicitarActividades();
     GruposResponseDTOItson solicitarGrupos(ActividadDTOItson actividad);
  //   InscripcionDTOItson inscribirActividad(InscripcionDTOItson inscripcionDTOItson);


}
