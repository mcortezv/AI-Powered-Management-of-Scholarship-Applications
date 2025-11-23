package adaptadores;
import dominio.InformacionSocioeconomica;
import dto.InformacionSocioeconomicaDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaAdaptador {

    public static InformacionSocioeconomica toEntity(InformacionSocioeconomicaDTO dto) {
        InformacionSocioeconomica informacionSocioeconomica = new InformacionSocioeconomica();
        informacionSocioeconomica.setIngresoTotalFamilarMensual(dto.getIngresoTotalFamilarMensual());
        informacionSocioeconomica.setTipoVivienda(dto.getTipoVivienda());
        informacionSocioeconomica.setDeudas(dto.isDeudas());
        informacionSocioeconomica.setTrabajo(dto.isTrabajo());
        return informacionSocioeconomica;
    }

    public static InformacionSocioeconomicaDTO toDTO(InformacionSocioeconomica informacionSocioeconomica) {
        InformacionSocioeconomicaDTO dto = new InformacionSocioeconomicaDTO();
        dto.setIngresoTotalFamilarMensual(informacionSocioeconomica.getIngresoTotalFamilarMensual());
        dto.setTipoVivienda(informacionSocioeconomica.getTipoVivienda());
        dto.setDeudas(informacionSocioeconomica.getDeudas());
        dto.setTrabajo(informacionSocioeconomica.getTrabajo());
        return dto;
    }
}
