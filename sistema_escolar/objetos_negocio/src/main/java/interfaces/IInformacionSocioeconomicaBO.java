package interfaces;
import dominio.*;
import dominio.enums.TipoVivienda;
import excepciones.*;
import java.math.BigDecimal;

public interface IInformacionSocioeconomicaBO {
    InformacionSocioeconomica crearInfo(BigDecimal ingreso, TipoVivienda tipoVivienda)
            throws InformacionSocioeconomicaInvalidaException;
}
