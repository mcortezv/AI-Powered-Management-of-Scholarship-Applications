package apiItson.controles;
import datos.dominioItson.HistorialAcademico;
import datos.dominioItson.pagarAdeudo.Clase;
import datos.dominioItson.pagarAdeudo.Prestamo;
import datos.serviceItson.HistorialService;
import datos.serviceItson.pagarAdeudo.ClaseService;
import datos.serviceItson.pagarAdeudo.PrestamoService;
import itson.LoginDTOItson;
import datos.dominioItson.Estudiante;
import datos.serviceItson.EstudianteService;

import java.util.List;


public class ControlItson {
    private final HistorialService historialService;
    private final EstudianteService estudianteService;

    // pagar adeudo
    private final PrestamoService prestamoService;
    private final ClaseService claseService;

    public ControlItson() {
        this.historialService = new HistorialService();
        this.estudianteService = new EstudianteService();

        //pagar adeudo
        this.prestamoService = new PrestamoService();
        this.claseService = new ClaseService();
    }

    public boolean verificarLogin(LoginDTOItson dto){
        return estudianteService.verificarLogin(dto);
    }
    
    public Estudiante solicitarDatosEstudiante(Long matricula){
        return estudianteService.solicitarDatosEstudiante(matricula);
    }

    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        return historialService.obtenerHistorialAcademico(matricula);
    }


    // pagar adeudo
    public List<Prestamo> obtenerListaPrestamosBiblioteca(Long matricula){
        return prestamoService.obtenerListaPrestamos(matricula);
    }

    public List<Clase> obtenerListaClasesColegiatura(Long matricula){
        return claseService.obtenerListaClases(matricula);
    }
}