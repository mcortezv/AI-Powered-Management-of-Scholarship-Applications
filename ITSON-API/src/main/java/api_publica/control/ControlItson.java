package api_publica.control;
import dto.itson.LoginDTOItson;
import itson.org.domain.Actividad;
import itson.org.domain.Estudiante;
import itson.org.service.ActividadService;
import itson.org.service.EstudianteService;
import java.util.List;


public class ControlItson {

    private final EstudianteService estudianteService;
    private final ActividadService actividadService;

    public ControlItson() {
        this.estudianteService = new EstudianteService();
        this.actividadService= new ActividadService();
    }
    

    public boolean verificarLogin(LoginDTOItson dto){
        return estudianteService.verificarLogin(dto);
    }
    
    public Estudiante solicitarDatosEstudiante(Long matricula){
        return estudianteService.solicitarDatosEstudiante(matricula);
    }
    
    public List<Actividad> solicitarActividades(){
        return actividadService.obtenerActividades();
        
    }
}