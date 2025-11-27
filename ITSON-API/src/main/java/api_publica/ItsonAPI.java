package api_publica;

import api_publica.control.ControlItson;
import api_publica.interfaz.IItsonAPI;
import itson.org.domain.Estudiante;
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
    public Estudiante obtenerDatosEstudiante(LoginDTOI dto) {
       return controlItson.solicitarDatosEstudiante(dto);
    }
    
   

}
