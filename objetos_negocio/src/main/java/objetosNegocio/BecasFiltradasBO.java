package objetosNegocio;
import dominio.Beca;
import excepciones.BecaInvalidaException;
import interfaces.IBecasFiltradasBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecasFiltradasBO implements IBecasFiltradasBO {

    public BecasFiltradasBO() {}

    public Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException {
        Beca b = null;
        if (b == null)
            throw new BecaInvalidaException("No existe beca con código " + codigo);
        return b;
    }
}