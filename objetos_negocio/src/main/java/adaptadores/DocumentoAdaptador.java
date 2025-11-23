package adaptadores;
import dominio.Documento;
import dominio.enums.TipoDocumento;
import dto.DocumentoDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class DocumentoAdaptador {

    public static Documento toEntity(DocumentoDTO dto) {
        Documento documento = new Documento();
        documento.setIdentificador(dto.getIdentificador());
        documento.setTipo(TipoDocumento.valueOf(dto.getTipo()));
        documento.setContenido(dto.getContenido());
        documento.setEstudiante(EstudianteAdaptador.toEntity(dto.getEstudiante()));
        return documento;
    }

    public static DocumentoDTO toDTO(Documento documento) {
        DocumentoDTO dto = new DocumentoDTO();
        dto.setIdentificador(documento.getIdentificador());
        dto.setTipo(documento.getTipo().toString());
        dto.setContenido(documento.getContenido());
        dto.setEstudiante(EstudianteAdaptador.toDTO(documento.getEstudiante()));
        return dto;
    }
}
