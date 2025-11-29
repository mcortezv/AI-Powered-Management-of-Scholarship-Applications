package interfaces.solicitarBeca;
import itson.HistorialAcademicoDTOItson;
import bo.solicitarBeca.excepciones.HistorialInvalidoException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IHistorialAcademicoBO {

    HistorialAcademicoDTOItson crearHistorial(Long matricula) throws HistorialInvalidoException;
}
