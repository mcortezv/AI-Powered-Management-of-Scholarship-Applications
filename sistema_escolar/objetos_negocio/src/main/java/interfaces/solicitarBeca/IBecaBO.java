package interfaces.solicitarBeca;
import dto.BecasFiltradasDTO;
import dto_gobierno.RequisitosDTO;
import objetosNegocio.solicitarBeca.excepciones.BecaInvalidaException;
import solicitarBeca.dominio.Beca;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
    BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws BecaInvalidaException;
}
