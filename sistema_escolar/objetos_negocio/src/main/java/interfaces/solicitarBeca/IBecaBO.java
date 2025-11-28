package interfaces.solicitarBeca;
import solicitarBeca.BecasFiltradasDTO;
import dtoGobierno.RequisitosDTO;
import bo.solicitarBeca.excepciones.BecaInvalidaException;
import solicitarBeca.dominio.Beca;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecaBO {
    Beca obtenerBecaPorCodigo(int codigo) throws BecaInvalidaException;
    BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitos) throws BecaInvalidaException;
}
