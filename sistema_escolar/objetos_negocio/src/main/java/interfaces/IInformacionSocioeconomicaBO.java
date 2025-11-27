package interfaces;
import excepciones.*;
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
