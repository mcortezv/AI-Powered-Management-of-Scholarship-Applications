package interfaces.solicitarBeca;
import dto.BecasDisponiblesResponseDTO;
import dto.RequisitosDTO;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import objetosNegocio.solicitarBeca.excepciones.BecaInvalidaException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecasFiltradasBO {

    BecasDisponiblesResponseDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws BecaInvalidaException;

    Beca obtenerBecaPorCodigo(Long codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException;
}
