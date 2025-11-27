package datos.api_publica;

/**
 *
 * @author Cortez, Manuel;
 */
public class GobiernoAPI implements IItsonAPI {
    private final ControlItson controlItson;

    public GobiernoAPI(){
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
