package apiItson.controles;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;
import datos.service.EstudianteService;


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