package apiItson.interfaces;
import banco.SolicitudPagoDTOI;
import datos.dominioItson.Actividad;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Clase;
import datos.dominioItson.pagarAdeudo.Prestamo;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;
import datos.dominioItson.Grupo;
import itson.ActividadDTOItson;
import itson.actividades.GruposResponseDTOItson;

import java.util.List;

public interface IItsonAPI {

    boolean verificarLogin(LoginDTOItson dto);

    Estudiante obtenerDatosEstudiante(Long matricula);

    HistorialAcademico obtenerHistorialAcademico(Long matricula);




    //pagar adeudo
    double obtenerAdeudoBiblioteca(Long matricula);
    double obtenerAdeudoColegiatura(Long matricula);
    List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula);
    List<Clase> obtenerListaClaseColegiatura(Long matricula);
    boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI);
    //actividades
     List<Actividad> soloicitarActividades();
     GruposResponseDTOItson solicitarGrupos(ActividadDTOItson actividad);


}
