package objetosNegocio.adaptadores;
import datos.dominio.InformacionSocioeconomica;
import datos.dominio.enums.TipoVivienda;
import dto.InformacionSocioeconomicaDTO;
import dto.InformacionSocioeconomicaInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.InformacionSocioeconomicaAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaAdaptador {

    public static InformacionSocioeconomica toEntity(InformacionSocioeconomicaDTO dto){
        try {
            InformacionSocioeconomica informacionSocioeconomica = new InformacionSocioeconomica();
            informacionSocioeconomica.setIngresoTotalFamilarMensual(dto.getIngresoTotalFamilarMensual());
            informacionSocioeconomica.setTipoVivienda(TipoVivienda.valueOf(dto.getTipoVivienda()));
            informacionSocioeconomica.setTrabajo(dto.getTrabajo());
            informacionSocioeconomica.setDeudas(dto.getDeudas());
            return informacionSocioeconomica;
        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static InformacionSocioeconomica toEntity(InformacionSocioeconomicaInfraestructuraDTO dto){
        try {
            InformacionSocioeconomica informacionSocioeconomica = new InformacionSocioeconomica();
            informacionSocioeconomica.setIngresoTotalFamilarMensual(dto.getIngresoTotalFamilarMensual());
            informacionSocioeconomica.setTipoVivienda(TipoVivienda.valueOf(dto.getTipoVivienda()));
            informacionSocioeconomica.setTrabajo(dto.getTrabajo());
            informacionSocioeconomica.setDeudas(dto.getDeudas());
            return informacionSocioeconomica;
        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static InformacionSocioeconomicaDTO toDTO(InformacionSocioeconomica informacionSocioeconomica){
        try {
            InformacionSocioeconomicaDTO dto = new InformacionSocioeconomicaDTO();
            dto.setIngresoTotalFamilarMensual(informacionSocioeconomica.getIngresoTotalFamilarMensual());
            dto.setTipoVivienda(informacionSocioeconomica.getTipoVivienda().toString());
            dto.setTrabajo(informacionSocioeconomica.getTrabajo());
            dto.setDeudas(informacionSocioeconomica.getDeudas());
            return dto;
        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static InformacionSocioeconomicaInfraestructuraDTO toInfraestructuraDTO(InformacionSocioeconomica  informacionSocioeconomica){
        try {
            InformacionSocioeconomicaInfraestructuraDTO dto = new InformacionSocioeconomicaInfraestructuraDTO();
            dto.setIngresoTotalFamilarMensual(informacionSocioeconomica.getIngresoTotalFamilarMensual());
            dto.setTipoVivienda(informacionSocioeconomica.getTipoVivienda().toString());
            dto.setTrabajo(informacionSocioeconomica.getTrabajo());
            dto.setDeudas(informacionSocioeconomica.getDeudas());
            return dto;
        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
