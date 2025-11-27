package api_publica.control;

import itson.org.dto.EstudianteResponseDTOI;
import itson.org.dto.LoginDTOI;
import itson.org.service.EstudianteService;

public class ControlItson {

    private final EstudianteService estudianteService;

    public ControlItson() {
        this.estudianteService = new EstudianteService();
    }

    public boolean verificarLogin(LoginDTOI dto){
        return estudianteService.verificarLogin(dto);
    }
    
    public EstudianteResponseDTOI solicitarDatosEstudiante(Long matricula){
        return estudianteService.solicitarDatosEstudiante(matricula);
    }


}