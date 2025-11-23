package interfaces;
import excepciones.*;
import solicitarBeca.dominio.Beca;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
}
