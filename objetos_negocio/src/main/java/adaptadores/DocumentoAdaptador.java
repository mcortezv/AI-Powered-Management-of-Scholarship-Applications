package adaptadores;
import dominio.Documento;
import dto.DocumentoDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoAdaptador {

    public static Documento toEntity(DocumentoDTO dto) {
        Documento documento = new Documento();
        documento.setIdentificador(dto.getIdentificador());
        documento.setTipo(dto.getTipo());
        documento.setContenido(dto.getContenido());
        documento.setEstudiante(dto.getEstudiante());
        return documento;
    }

    public static DocumentoDTO toDTO(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setIdentificador(documento.getIdentificador());
        dto.setTipo(documento.getTipo());
        dto.setContenido(documento.getContenido());
        dto.setEstudiante(documento.getEstudiante());
        return dto;
    }
}
