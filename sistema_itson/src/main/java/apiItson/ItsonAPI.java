package apiItson;
import apiItson.controles.ControlItson;
import apiItson.interfaces.IItsonAPI;
import banco.SolicitudPagoDTOI;
import datos.dominioItson.actividades.Actividad;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Clase;
import datos.dominioItson.pagarAdeudo.Prestamo;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;
import itson.actividades.GruposResponseDTOItson;
import itson.actividades.InscripcionDTOItson;

import java.util.List;

public class ItsonAPI implements IItsonAPI {
    private final ControlItson controlItson;

    public ItsonAPI(){
        this.controlItson = new ControlItson();
    }

    @Override
    public boolean verificarLogin(LoginDTOItson dto) {
        return controlItson.verificarLogin(dto);
    }

    @Override
    public Estudiante obtenerDatosEstudiante(Long matricula) {
       return controlItson.solicitarDatosEstudiante(matricula);
    }

    @Override
    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        return controlItson.obtenerHistorialAcademico(matricula);
    }

    // pagar adeudo
    @Override
    public double obtenerAdeudoBiblioteca(Long matricula) {
        return controlItson.obtenerAdeudoBiblioteca(matricula);
    }

    @Override
    public double obtenerAdeudoColegiatura(Long matricula) {
        return controlItson.obtenerAdeudoColegiatura(matricula);
    }

    @Override
    public List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula) {
        return controlItson.obtenerListaPrestamosBiblioteca(matricula);
    }

    @Override
    public List<Clase> obtenerListaClaseColegiatura(Long matricula) {
        return controlItson.obtenerListaClasesColegiatura(matricula);
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI) {
        return false;
    }




    //actividades
    @Override
    public ActividadesDTOItson soloicitarActividades() {
        return controlItson.solicitarActividades();
    }


    public GruposResponseDTOItson solicitarGrupos(ActividadDTOItson actividad) {
        return controlItson.obtenerGrupos(actividad);
    }

//    public InscripcionDTOItson inscribirActividad(InscripcionDTOItson inscripcionDTOItson){
//        return controlItson.inscribirActividad(inscripcionDTOItson);
//    }
}
