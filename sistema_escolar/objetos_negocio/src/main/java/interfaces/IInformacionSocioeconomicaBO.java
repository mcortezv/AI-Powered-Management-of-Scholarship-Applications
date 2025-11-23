package interfaces;
import dto.InformacionSocioeconomicaDTO;
import excepciones.*;
import solicitarBeca.dominio.InformacionSocioeconomica;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IInformacionSocioeconomicaBO {

    InformacionSocioeconomica crearInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) throws InformacionSocioeconomicaInvalidaException;
}
