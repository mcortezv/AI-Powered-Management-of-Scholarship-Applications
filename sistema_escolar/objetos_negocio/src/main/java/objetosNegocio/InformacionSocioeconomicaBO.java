package objetosNegocio;
import solicitarBeca.dominio.InformacionSocioeconomica;
import excepciones.InformacionSocioeconomicaInvalidaException;
import interfaces.IInformacionSocioeconomicaBO;
import solicitarBeca.dominio.enums.TipoVivienda;
import java.math.BigDecimal;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaBO implements IInformacionSocioeconomicaBO {

    @Override
    public InformacionSocioeconomica crearInformacionSocioeconomica(BigDecimal ingresoTotalFamilarMensual, TipoVivienda tipoVivienda, boolean trabajo, boolean deudas) {
        if (ingresoTotalFamilarMensual== null || tipoVivienda == null) {
            throw new InformacionSocioeconomicaInvalidaException("Datos socioeconómicos incompletos");
        }
        return new InformacionSocioeconomica(ingresoTotalFamilarMensual, tipoVivienda, trabajo, deudas);
    }
}