package api_publica.control;
import dto.itson.LoginDTOItson;
import itson.org.domain.Estudiante;
import itson.org.service.EstudianteService;


public class ControlItson {

    private final EstudianteService estudianteService;

    public ControlItson() {
        this.estudianteService = new EstudianteService();
    }

    public boolean verificarLogin(LoginDTOItson dto){
        return estudianteService.verificarLogin(dto);
    }
    
    public Estudiante solicitarDatosEstudiante(Long matricula){
        return estudianteService.solicitarDatosEstudiante(matricula);
    }
}