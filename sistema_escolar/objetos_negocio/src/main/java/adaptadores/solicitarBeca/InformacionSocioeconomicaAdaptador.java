package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import adaptadores.solicitarBeca.excepciones.InformacionSocioeconomicaAdaptadorException;
import solicitarBeca.InformacionSocioeconomicaDTO;
import gobierno.InformacionSocioeconomicaDTOGobierno;
import solicitarBeca.dominio.InformacionSocioeconomica;
import solicitarBeca.dominio.enums.TipoVivienda;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaAdaptador {

    public static InformacionSocioeconomica toEntity(InformacionSocioeconomicaDTO dto) {
        try {
            InformacionSocioeconomica informacionSocioeconomica = new InformacionSocioeconomica();
            informacionSocioeconomica.setIngresoTotalFamilarMensual(dto.getIngresoTotalFamilarMensual());
            informacionSocioeconomica.setTipoVivienda(TipoVivienda.valueOf(dto.getTipoVivienda()));
            informacionSocioeconomica.setDeudas(dto.isDeudas());
            informacionSocioeconomica.setTrabajo(dto.isTrabajo());
            return informacionSocioeconomica;
        } catch (Exception ex) {
            throw new InformacionSocioeconomicaAdaptadorException("Error al convertir DTO InformacionSocioeconomica a Entidad");
        }
    }

    public static InformacionSocioeconomicaDTO toDTO(InformacionSocioeconomica informacionSocioeconomica) {
        try {
            InformacionSocioeconomicaDTO dto = new InformacionSocioeconomicaDTO();
            dto.setIngresoTotalFamilarMensual(informacionSocioeconomica.getIngresoTotalFamilarMensual());
            dto.setTipoVivienda(informacionSocioeconomica.getTipoVivienda().toString());
            dto.setDeudas(informacionSocioeconomica.getDeudas());
            dto.setTrabajo(informacionSocioeconomica.getTrabajo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad InformacionSocioeconomica a DTO");
        }
    }

    public static InformacionSocioeconomicaDTOGobierno toDTOGobierno(InformacionSocioeconomica informacionSocioeconomica) {
        try {
            InformacionSocioeconomicaDTOGobierno dto = new InformacionSocioeconomicaDTOGobierno();
            dto.setIngresoTotalFamilarMensual(informacionSocioeconomica.getIngresoTotalFamilarMensual());
            dto.setTipoVivienda(informacionSocioeconomica.getTipoVivienda().toString());
            dto.setDeudas(informacionSocioeconomica.getDeudas());
            dto.setTrabajo(informacionSocioeconomica.getTrabajo());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad InformacionSocioeconomica a DTO");
        }
    }
}
