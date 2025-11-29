package interfaces.solicitarBeca;
import gobierno.BecasDisponiblesDTOGobierno;
import gobierno.RequisitosDTOGobierno;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import bo.solicitarBeca.excepciones.BecaInvalidaException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecasFiltradasBO {

    BecasDisponiblesDTOGobierno obtenerBecasFiltradas(RequisitosDTOGobierno requisitos) throws BecaInvalidaException;

    Beca obtenerBecaPorCodigo(Long codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException;
}
