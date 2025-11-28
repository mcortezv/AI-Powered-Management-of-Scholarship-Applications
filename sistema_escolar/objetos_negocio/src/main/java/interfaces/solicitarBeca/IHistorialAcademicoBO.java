package interfaces.solicitarBeca;
import dto.itson.HistorialAcademicoDTOItson;
import objetosNegocio.solicitarBeca.excepciones.HistorialInvalidoException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IHistorialAcademicoBO {

    HistorialAcademicoDTOItson crearHistorial(Long matricula) throws HistorialInvalidoException;
}
