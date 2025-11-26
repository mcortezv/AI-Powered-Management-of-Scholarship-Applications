package controles;

import api_publica.ItsonAPI;
import api_publica.interfaz.IItsonAPI;
import dto.LoginDTO;
import itson.org.dto.LoginDTOI;

public class ControlItson {
    IItsonAPI api;

    public ControlItson(){
        this.api = new ItsonAPI();
    }

    public boolean verificarLogin(LoginDTO loginDTO) {
        LoginDTOI dtoInfra = new itson.org.dto.LoginDTOI();
        dtoInfra.setUsuario(loginDTO.getUsuario());
        dtoInfra.setContrasenia(loginDTO.getContrasenia());
        System.out.println("aqui antes de hacer llamar a la api externa");
        return api.verificarLogin(dtoInfra);
    }
}