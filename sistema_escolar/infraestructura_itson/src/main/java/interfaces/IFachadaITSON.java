package interfaces;
import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;
import itson.EstudianteDTOItson;
import itson.HistorialAcademicoDTOItson;
import itson.LoginDTOItson;
import itson.actividades.GruposResponseDTOItson;
import itson.actividades.InscripcionDTOItson;

import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {

    boolean verificarLogin(LoginDTOItson solicitudLoginDTO);

    EstudianteDTOItson verificarEstudiante(Long matricula);

    HistorialAcademicoDTOItson verificarHistorialAcademcio(Long matricula);

    //pagar adeudo
    double solicitarAdeudoBiblioteca(Long matricula);
    double solicitarAdeudoColegiatura(Long matricula);
    List<PrestamoDTOI> solicitarListaPrestamso(Long matricula);
    List<ClaseDTOI> solicitarListaClases(Long matricula);
    boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI);
    //actividades
    public ActividadesDTOItson obtenerActividades();
    public GruposResponseDTOItson otenerGrupos(ActividadDTOItson actividadDTO);
   // public InscripcionDTOItson inscribirActividad(InscripcionDTOItson inscripcionDTOItson);
}