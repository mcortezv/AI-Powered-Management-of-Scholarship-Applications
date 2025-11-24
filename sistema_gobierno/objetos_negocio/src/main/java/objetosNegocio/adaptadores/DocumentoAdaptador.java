package objetosNegocio.adaptadores;
import datos.dominio.Documento;
import datos.dominio.enums.TipoDocumento;
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
            Documento documento = new Documento();
            documento.setIdentificador(dto.getIdentificador());
            documento.setTipo(TipoDocumento.valueOf(dto.getTipo()));
            documento.setContenido(dto.getContenido());
            documento.setEstudiante(EstudianteAdaptador.toEntity(dto.getEstudiante()));
            return documento;
        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Documento toEntity(DocumentoInfraestructuraDTO dto){
        try {
            Documento documento = new Documento();
            documento.setIdentificador(dto.getIdentificador());
            documento.setTipo(TipoDocumento.valueOf(dto.getTipo()));
            documento.setContenido(dto.getContenido());
            documento.setEstudiante(EstudianteAdaptador.toEntity(dto.getEstudiante()));
            return documento;
        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static DocumentoDTO toDTO(Documento documento){
        try {
            DocumentoDTO dto = new DocumentoDTO();
            dto.setIdentificador(documento.getIdentificador());
            dto.setTipo(documento.getTipo().toString());
            dto.setContenido(documento.getContenido());
            dto.setEstudiante(EstudianteAdaptador.toDTO(documento.getEstudiante()));
            return dto;
        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static DocumentoInfraestructuraDTO toInfraestructuraDTO(Documento  documento){
        try {
            DocumentoInfraestructuraDTO dto = new DocumentoInfraestructuraDTO();
            dto.setIdentificador(documento.getIdentificador());
            dto.setTipo(documento.getTipo().toString());
            dto.setContenido(documento.getContenido());
            dto.setEstudiante(EstudianteAdaptador.toInfraestructuraDTO(documento.getEstudiante()));
            return dto;
        } catch (Exception sinUso){
            throw new DocumentoAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
