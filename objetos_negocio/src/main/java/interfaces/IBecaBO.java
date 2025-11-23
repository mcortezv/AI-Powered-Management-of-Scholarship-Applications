package interfaces;
import dominio.*;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
}
