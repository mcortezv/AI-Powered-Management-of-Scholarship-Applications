package objetosNegocio;
import dominio.*;
import excepciones.*;
import interfaces.IBecaBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecaBO implements IBecaBO {

    public BecaBO() {
    }

    @Override
    public Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException {
        Beca b = null;
        if (b == null)
            throw new BecaInvalidaException("No existe beca con código " + codigo);
        return b;
    }
}
