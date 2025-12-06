package fachadas;


import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import controles.ControlItson;
import interfaces.IFachadaITSON;
import itson.ActividadDTOItson;
import itson.ActividadesDTOItson;
import itson.EstudianteDTOItson;
import itson.HistorialAcademicoDTOItson;
import itson.LoginDTOItson;
import itson.actividades.GruposResponseDTOItson;
import itson.actividades.InscripcionDTOItson;

import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaItson implements IFachadaITSON {
    private final ControlItson controlItson;

    public FachadaItson(ControlItson controlItson) {
        this.controlItson = controlItson;
    }

    @Override
    public boolean verificarLogin(LoginDTOItson solicitudLoginDTO) {
        return controlItson.verificarLogin(solicitudLoginDTO);
    }

    @Override
    public EstudianteDTOItson verificarEstudiante(Long matricula) {
        return controlItson.verificarEstudiante(matricula);
    }

    @Override
    public HistorialAcademicoDTOItson verificarHistorialAcademcio(Long matricula) {
        return controlItson.verificarHistorialAcademico(matricula);
    }

    /**
     *  TODO ESTO ES DEL CASO PAGAR ADEUDO
     * @param matricula
     * // SEBASTIAN ESCALANTE RAMIREZ
     * @return
     */
    @Override
    public double solicitarAdeudoBiblioteca(Long matricula) {
        return controlItson.obtenerAdeudoBiblioteca(matricula);
    }

    @Override
    public double solicitarAdeudoColegiatura(Long matricula) {
        return controlItson.obtenerAdeudoColegiatura(matricula);
    }

    @Override
    public List<PrestamoDTOI> solicitarListaPrestamso(Long matricula) {
        return null;

    }

    @Override
    public List<ClaseDTOI> solicitarListaClases(Long matricula) {
        return null;
//        return controlItson.solicitarListaClases(matriculaEstudiante);
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI) {
        return false;
//        return controlItson.solicitarLiquidacion(solicitudPagoDTOI);
    }

    /**
     * AQUI TERMINA CASO DE USO PAGAR ADEUDO
     */
    
    /**
     * ESTO ES DEL CASO ACTIVIDADES 
     */
    
    public ActividadesDTOItson obtenerActividades(){
        return controlItson.obtenerActividades();
    }

    @Override
    public GruposResponseDTOItson otenerGrupos(ActividadDTOItson actividadDTO) {
        return controlItson.obtenerGrupos(actividadDTO);
    }
    
//    public InscripcionDTOItson inscribirActividad(InscripcionDTOItson inscripcionDTOItson){
//        return controlItson.inscribirActividad(inscripcionDTOItson);
//    }
}
