package interfaces.solicitarBeca;
import objetosNegocio.solicitarBeca.excepciones.BecaInvalidaException;
import solicitarBeca.dominio.Beca;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
}
