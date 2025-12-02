package fachadas;
import itson.EstudianteDTOItson;
import itson.HistorialAcademicoDTOItson;
import controles.ControlItson;
import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;
import itson.LoginDTOItson;
import interfaces.IFachadaITSON;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class FachadaItson implements IFachadaITSON{
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
//        return controlItson.verificarEstudiante(matricula);
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
        return 0.0;
//        return controlItson.solicitarAdeudoBiblioteca(matriculaEstudiante);
    }

    @Override
    public double solicitarAdeudoColegiatura(Long matricula) {
        return 0.0;
//        return controlItson.solicitarAdeudoColegiatura(matriculaEstudiante);
    }

    @Override
    public List<PrestamoDTOI> solicitarListaPrestamso(Long matricula) {
        return null;
//        return controlItson.solicitarListaPrestamos(matriculaEstudiante);
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
}
