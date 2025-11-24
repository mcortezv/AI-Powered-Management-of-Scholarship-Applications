package objetosNegocio.adaptadores;
import datos.dominio.InformacionSocioeconomica;
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

        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static InformacionSocioeconomica toEntity(InformacionSocioeconomicaInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static InformacionSocioeconomicaDTO toDTO(InformacionSocioeconomica informacionSocioeconomica){
        try {

        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static InformacionSocioeconomicaInfraestructuraDTO toInfraestructuraDTO(InformacionSocioeconomica  informacionSocioeconomica){
        try {

        } catch (Exception sinUso){
            throw new InformacionSocioeconomicaAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
