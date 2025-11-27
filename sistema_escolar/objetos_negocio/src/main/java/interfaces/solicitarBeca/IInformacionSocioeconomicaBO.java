package interfaces.solicitarBeca;
import objetosNegocio.solicitarBeca.excepciones.InformacionSocioeconomicaInvalidaException;
import solicitarBeca.dominio.InformacionSocioeconomica;
import solicitarBeca.dominio.enums.TipoVivienda;
import java.math.BigDecimal;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IInformacionSocioeconomicaBO {

    InformacionSocioeconomica crearInformacionSocioeconomica(BigDecimal ingresoTotalFamilarMensual, TipoVivienda tipoVivienda, boolean trabajo, boolean deudas) throws InformacionSocioeconomicaInvalidaException;
}
