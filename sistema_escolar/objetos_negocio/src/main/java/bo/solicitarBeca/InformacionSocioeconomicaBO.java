package bo.solicitarBeca;
import solicitarBeca.dominio.InformacionSocioeconomica;
import bo.solicitarBeca.excepciones.InformacionSocioeconomicaInvalidaException;
import interfaces.solicitarBeca.IInformacionSocioeconomicaBO;
import solicitarBeca.dominio.enums.TipoVivienda;
import java.math.BigDecimal;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaBO implements IInformacionSocioeconomicaBO {

    @Override
    public InformacionSocioeconomica crearInformacionSocioeconomica(BigDecimal ingresoTotalFamilarMensual, TipoVivienda tipoVivienda, boolean trabajo, boolean deudas) throws InformacionSocioeconomicaInvalidaException {
        if (ingresoTotalFamilarMensual== null || tipoVivienda == null) {
            throw new InformacionSocioeconomicaInvalidaException("Datos socioeconomicos incompletos");
        }
        return new InformacionSocioeconomica(ingresoTotalFamilarMensual, tipoVivienda, trabajo, deudas);
    }
}