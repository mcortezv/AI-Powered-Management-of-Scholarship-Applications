package interfaces;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;

/**
 * @author Escalante, Sebastian.
 */
public interface IFachadaITSON {

    boolean verificarLogin(LoginDTO solicitudLoginDTO);

    EstudianteResponseDTO verificarEstudiante(Long matricula);

    HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula);
}