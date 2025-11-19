package objetosNegocio;
import dominio.*;
import excepciones.*;
import interfaces.IBecaBO;
import objetosNegocio.mock.*;

public class BecaBO implements IBecaBO {

    @Override
    public Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException {
        Beca b = BecaMock.get(codigo); // Pendiente
        if (b == null)
            throw new BecaInvalidaException("No existe beca con código " + codigo);
        return b;
    }
}
