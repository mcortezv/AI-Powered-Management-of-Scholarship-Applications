package apiItson;
import apiItson.controles.ControlItson;
import apiItson.interfaces.IItsonAPI;
import datos.dominio.HistorialAcademico;
import itson.LoginDTOItson;
import datos.dominio.Estudiante;

public class ItsonAPI implements IItsonAPI {
    private final ControlItson controlItson;

    public ItsonAPI(){
        this.controlItson = new ControlItson();
    }

    @Override
    public boolean verificarLogin(LoginDTOItson dto) {
        return controlItson.verificarLogin(dto);
    }

    @Override
    public Estudiante obtenerDatosEstudiante(Long matricula) {
       return controlItson.solicitarDatosEstudiante(matricula);
    }

    @Override
    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        return controlItson.obtenerHistorialAcademico(matricula);
    }
}
