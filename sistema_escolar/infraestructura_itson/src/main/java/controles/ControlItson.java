package controles;

import apiItson.ItsonAPI;
import apiItson.interfaces.IItsonAPI;
import datos.adaptadoresItson.EstudianteAdaptador;
import datos.dominioItson.Actividad;
import datos.dominioItson.Estudiante;

import itson.ActividadesDTOItson;
import itson.EstudianteDTOItson;
import itson.LoginDTOItson;
import itson.org.adaptadores.ActividadAdaptador;
import java.util.List;

public class ControlItson {
    IItsonAPI api;

    public ControlItson(){
        this.api = new ItsonAPI();
    }

    public boolean verificarLogin(LoginDTOItson loginDTO) {
        LoginDTOItson dtoInfra = new LoginDTOItson();
        dtoInfra.setUsuario(loginDTO.getUsuario());
        dtoInfra.setContrasenia(loginDTO.getContrasenia());
        return api.verificarLogin(dtoInfra);
    }

    public EstudianteDTOItson verificarEstudiante(Long matricula){
        Estudiante estudiante = api.obtenerDatosEstudiante(matricula);
        return EstudianteAdaptador.toResponseDTO(estudiante);
    }
    
    public ActividadesDTOItson obtenerActividades(){
        List<Actividad> actividad= api.solicitarActividades();
        return ActividadAdaptador.toResponseDTOListaAct(actividad);

        //return api.solicitarActividades();
    }

}