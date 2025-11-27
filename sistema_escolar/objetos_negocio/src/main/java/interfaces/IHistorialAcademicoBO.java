package interfaces;
import dto.HistorialAcademicoResponseDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IHistorialAcademicoBO {

    HistorialAcademicoResponseDTO crearHistorial(Long matricula);
}
