package objetosNegocio;
import adaptadores.InformacionSocioeconomicaAdaptador;
import solicitarBeca.dominio.InformacionSocioeconomica;
import dto.InformacionSocioeconomicaDTO;
import excepciones.InformacionSocioeconomicaInvalidaException;
import interfaces.IInformacionSocioeconomicaBO;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaBO implements IInformacionSocioeconomicaBO {

    @Override
    public InformacionSocioeconomica crearInformacionSocioeconomica(InformacionSocioeconomicaDTO informacionSocioeconomicaDTO) {
        if (informacionSocioeconomicaDTO.getIngresoTotalFamilarMensual() == null || informacionSocioeconomicaDTO.getTipoVivienda() == null) {
            throw new InformacionSocioeconomicaInvalidaException("Datos socioeconómicos incompletos");
        }
        return InformacionSocioeconomicaAdaptador.toEntity(informacionSocioeconomicaDTO);
    }
}