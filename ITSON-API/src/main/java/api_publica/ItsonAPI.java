package api_publica;

import api_publica.control.ControlItson;
import api_publica.interfaz.IItsonAPI;
import itson.org.dto.EstudianteResponseDTOI;
import itson.org.dto.LoginDTOI;

public class ItsonAPI implements IItsonAPI {
    private final ControlItson controlItson;

    public ItsonAPI(){
        this.controlItson = new ControlItson();
    }

    @Override
    public boolean verificarLogin(LoginDTOI dto) {
        return controlItson.verificarLogin(dto);
    }

    @Override
    public EstudianteResponseDTOI obtenerDatosEstudiante(Long matricula) {
       return controlItson.solicitarDatosEstudiante(matricula);
    }
    
   

}
