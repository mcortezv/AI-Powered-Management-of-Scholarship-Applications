package interfaces;
import dominio.*;
import dto.InformacionSocioeconomicaDTO;
import excepciones.*;

public interface IInformacionSocioeconomicaBO {

    InformacionSocioeconomica crearInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) throws InformacionSocioeconomicaInvalidaException;
}
