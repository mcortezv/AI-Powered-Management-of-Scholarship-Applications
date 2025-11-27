package adaptadores;
import org.bson.types.ObjectId;
import solicitarBeca.dominio.Documento;
import solicitarBeca.dominio.Estudiante;
import solicitarBeca.dominio.enums.TipoDocumento;
import dto.DocumentoDTO;
import solicitarBeca.repository.documents.DocumentoDocument;

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

    public static DocumentoDocument toDocument(Documento document, ObjectId estudianteId) {
        DocumentoDocument doc = new DocumentoDocument();
        doc.set_id(new ObjectId());
        doc.setIdentificador(document.getIdentificador());
        doc.setTipo(document.getTipo());
        doc.setContenido(document.getContenido());
        doc.setEstudiante(estudianteId);
        return doc;
    }
}
