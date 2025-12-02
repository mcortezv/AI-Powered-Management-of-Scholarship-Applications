package interfaces;
import dto.itson.EstudianteDTOItson;
import dto.itson.HistorialAcademicoDTOItson;
import dto.banco.ClaseDTOI;
import dto.banco.PrestamoDTOI;
import dto.banco.SolicitudPagoDTOI;
import dto.itson.ActividadesDTOItson;
import dto.itson.LoginDTOItson;

import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {

    boolean verificarLogin(LoginDTOItson solicitudLoginDTO);

    EstudianteDTOItson verificarEstudiante(Long matricula);

    HistorialAcademicoDTOItson verificarHistorialAcademcio(Long matricula);

    //pagar adeudo
    double solicitarAdeudoBiblioteca(String matriculaEstudiante);
    double solicitarAdeudoColegiatura(String matriculaEstudiante);
    List<PrestamoDTOI> solicitarListaPrestamso(String matriculaEstudiante);
    List<ClaseDTOI> solicitarListaClases(String matriculaEstudiante);
    boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI);
    
    //actividades
    public ActividadesDTOItson obtenerActividades();
}