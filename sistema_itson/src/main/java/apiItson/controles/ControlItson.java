package apiItson.controles;
import datos.dominio.HistorialAcademico;
import datos.service.HistorialService;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;
import datos.service.EstudianteService;


public class ControlItson {
    private final HistorialService historialService;
    private final EstudianteService estudianteService;

    public ControlItson() {
        this.historialService = new HistorialService();
        this.estudianteService = new EstudianteService();
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
}