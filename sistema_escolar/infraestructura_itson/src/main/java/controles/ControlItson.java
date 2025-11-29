package controles;
import apiItson.ItsonAPI;
import apiItson.interfaces.IItsonAPI;
import datos.adaptadores.HistorialAcademicoAdaptador;
import itson.EstudianteDTOItson;
import itson.HistorialAcademicoDTOItson;
import itson.LoginDTOItson;
import datos.adaptadores.EstudianteAdaptador;
import datos.dominio.Estudiante;


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

    public HistorialAcademicoDTOItson verificarHistorialAcademico(Long matricula){
        HistorialAcademicoDTOItson historialAcademicoDTOItson = HistorialAcademicoAdaptador.toDTOItson(api.obtenerHistorialAcademico(matricula));
        return historialAcademicoDTOItson;
    }
}
