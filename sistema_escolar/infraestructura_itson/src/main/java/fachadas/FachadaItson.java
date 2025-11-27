package fachadas;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import controles.ControlItson;
import dto.pagarAdeudo.ClaseDTOI;
import dto.pagarAdeudo.PrestamoDTOI;
import dto.pagarAdeudo.SolicitudPagoDTOI;
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
    public boolean verificarLogin(LoginDTO solicitudLoginDTO) {
        return controlItson.verificarLogin(solicitudLoginDTO);
    }

    @Override
    public EstudianteResponseDTO verificarEstudiante(Long matricula) {
        return controlItson.verificarEstudiante(matricula);
//        return controlItson.verificarEstudiante(matricula);
    }

    @Override
    public HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula) {
        return null;
    }

    /**
     *  TODO ESTO ES DEL CASO PAGAR ADEUDO
     * @param matriculaEstudiante
     * // SEBASTIAN ESCALANTE RAMIREZ
     * @return
     */
    @Override
    public double solicitarAdeudoBiblioteca(String matriculaEstudiante) {
        return 0.0;
//        return controlItson.solicitarAdeudoBiblioteca(matriculaEstudiante);
    }

    @Override
    public double solicitarAdeudoColegiatura(String matriculaEstudiante) {
        return 0.0;
//        return controlItson.solicitarAdeudoColegiatura(matriculaEstudiante);
    }

    @Override
    public List<PrestamoDTOI> solicitarListaPrestamso(String matriculaEstudiante) {
        return null;
//        return controlItson.solicitarListaPrestamos(matriculaEstudiante);
    }

    @Override
    public List<ClaseDTOI> solicitarListaClases(String matriculaEstudiante) {
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
