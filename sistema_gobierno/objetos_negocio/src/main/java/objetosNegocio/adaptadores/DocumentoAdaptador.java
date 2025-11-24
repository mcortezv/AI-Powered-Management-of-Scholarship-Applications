package objetosNegocio.adaptadores;
import datos.dominio.Documento;
import dto.DocumentoDTO;
import dto.DocumentoInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.DocumentoAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoAdaptador {

    public static Documento toEntity(DocumentoDTO dto){
        try {

        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Documento toEntity(DocumentoInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static DocumentoDTO toDTO(Documento documento){
        try {

        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static DocumentoInfraestructuraDTO toInfraestructuraDTO(Documento  documento){
        try {

        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
