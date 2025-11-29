package interfaces;
import itson.EstudianteDTOItson;
import itson.HistorialAcademicoDTOItson;
import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import itson.LoginDTOItson;

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
}