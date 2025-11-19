package objetosNegocio;

import dominio.InformacionSocioeconomica;
import dominio.enums.TipoVivienda;
import excepciones.InformacionSocioeconomicaInvalidaException;

import java.math.BigDecimal;

public class InformacionSocioeconomicaBO {
    public InformacionSocioeconomica crearInfo(BigDecimal ingreso, TipoVivienda tipoVivienda) {
        if (ingreso == null || tipoVivienda == null)
            throw new InformacionSocioeconomicaInvalidaException("Datos socioeconómicos incompletos");
        return new InformacionSocioeconomica(ingreso, tipoVivienda, true, true); //Hardcode
    }
}