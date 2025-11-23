package interfaces;
import dominio.*;
import dto.InformacionSocioeconomicaDTO;
import excepciones.*;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IInformacionSocioeconomicaBO {

    InformacionSocioeconomica crearInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) throws InformacionSocioeconomicaInvalidaException;
}
