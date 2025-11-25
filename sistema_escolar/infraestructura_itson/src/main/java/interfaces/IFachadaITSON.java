package interfaces;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import dto.pagarAdeudo.ClaseDTOI;
import dto.pagarAdeudo.PrestamoDTOI;
import dto.pagarAdeudo.SolicitudPagoDTOI;
import solicitarBeca.dominio.enums.TipoBeca;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {

    boolean verificarLogin(LoginDTO solicitudLoginDTO);

    EstudianteResponseDTO verificarEstudiante(Long matricula);

    HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula);



    //pagar adeudo
    double solicitarAdeudoBiblioteca(String matriculaEstudiante);
    double solicitarAdeudoColegiatura(String matriculaEstudiante);
    List<PrestamoDTOI> solicitarListaPrestamso(String matriculaEstudiante);
    List<ClaseDTOI> solicitarListaClases(String matriculaEstudiante);
    boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI);
}