package interfaces;
import dominio.*;
import excepciones.*;

public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
}
