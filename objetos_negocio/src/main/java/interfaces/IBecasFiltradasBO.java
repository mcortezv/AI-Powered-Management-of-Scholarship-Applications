package interfaces;
import dominio.BecasFiltradas;
import dto.BecaDTO;
import dto.BecasFiltradasDTO;
import dto.RequisitosDTO;
import excepciones.BecaInvalidaException;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IBecasFiltradasBO {

    BecasFiltradasDTO obtenerBecasFiltradas(RequisitosDTO requisitosDTO) throws BecaInvalidaException;

    BecaDTO obtenerBecaPorCodigo(int codigo, BecasFiltradas becasFiltradas) throws BecaInvalidaException;
}
