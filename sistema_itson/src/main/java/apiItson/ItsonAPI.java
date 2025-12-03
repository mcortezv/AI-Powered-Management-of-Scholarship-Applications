package apiItson;
import apiItson.controles.ControlItson;
import apiItson.interfaces.IItsonAPI;
import datos.dominioItson.Actividad;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Prestamo;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;
import datos.dominioItson.Grupo;

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
        return 0;
    }

    @Override
    public double obtenerAdeudoColegiatura(Long matricula) {
        return 0;
    }



    @Override
    public List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula) {
        return controlItson.obtenerListaPrestamosBiblioteca(matricula);
    }
    
    //actividades
    @Override
    public List<Actividad> soloicitarActividades() {
        return controlItson.solicitarActividades();
    }
    
    public List<Grupo> solicitarGrupos(Actividad actividad){
        return controlItson.obtenerGrupos(actividad);
    }
}
