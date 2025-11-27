package datos.api_publica;

import datos.api_publica.control.GobiernoItson;
import datos.api_publica.interfaz.IGobiernoAPI;
import datos.dominio.Beca;
import datos.dto.BecasResponseDTOI;
import datos.dto.RequisitosDTOI;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoAPI implements IGobiernoAPI {
    private final GobiernoItson gobiernoITSON;

    public GobiernoAPI(){
        this.gobiernoITSON = new GobiernoItson();
    }

    @Override
    public boolean verificarLogin(LoginDTOI dto) {
        return controlItson.verificarLogin(dto);
    }

    @Override
    public Estudiante obtenerDatosEstudiante(LoginDTOI dto) {
       return controlItson.solicitarDatosEstudiante(dto);
    }

    @Override
    public BecasResponseDTOI solicitarBecas(RequisitosDTOI requisitosDTOI) {
     //   return gobiernoITSON.
    }
}
