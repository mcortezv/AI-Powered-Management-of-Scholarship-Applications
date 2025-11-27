package interfaces.solicitarBeca;
import dto.HistorialAcademicoResponseDTO;
import objetosNegocio.solicitarBeca.excepciones.HistorialInvalidoException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IHistorialAcademicoBO {

    HistorialAcademicoResponseDTO crearHistorial(Long matricula) throws HistorialInvalidoException;
}
