package api_publica.control;

import itson.org.domain.Estudiante;
import itson.org.dto.EstudianteResponseDTO;
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
    
    public Estudiante solicitarDatosEstudiante(LoginDTOI dto){
        return estudianteService.solicitarDatosEstudiante(dto);
    }


}