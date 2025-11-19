package objetosNegocio;
import dominio.InformacionSocioeconomica;
import dominio.enums.TipoVivienda;
import excepciones.InformacionSocioeconomicaInvalidaException;
import interfaces.IInformacionSocioeconomicaBO;

import java.math.BigDecimal;

public class InformacionSocioeconomicaBO implements IInformacionSocioeconomicaBO {
    public InformacionSocioeconomica crearInfo(BigDecimal ingreso, TipoVivienda tipoVivienda) {
        if (ingreso == null || tipoVivienda == null)
            throw new InformacionSocioeconomicaInvalidaException("Datos socioeconómicos incompletos");
        return new InformacionSocioeconomica(ingreso, tipoVivienda, true, true); //Hardcode
    }
}