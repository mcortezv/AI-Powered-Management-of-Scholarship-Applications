package interfaces.solicitarBeca;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.gobierno.RequisitosDTOGobierno;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import objetosNegocio.solicitarBeca.excepciones.BecaInvalidaException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecasFiltradasBO {

    BecasDisponiblesDTOGobierno obtenerBecasFiltradas(RequisitosDTOGobierno requisitos) throws BecaInvalidaException;

    Beca obtenerBecaPorCodigo(Long codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException;
}
