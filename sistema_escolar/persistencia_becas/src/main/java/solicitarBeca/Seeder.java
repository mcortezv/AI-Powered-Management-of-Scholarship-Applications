package solicitarBeca;
import org.bson.types.ObjectId;
import solicitarBeca.config.MongoClientProvider;
import solicitarBeca.repository.dao.DocumentoDAO;
import solicitarBeca.repository.dao.EstudianteDAO;
import solicitarBeca.repository.dao.SolicitudDAO;
import solicitarBeca.repository.documents.DocumentoDocument;
import solicitarBeca.repository.documents.EstudianteDocument;
import solicitarBeca.repository.documents.SolicitudDocument;
import solicitarBeca.dominio.Tutor;
import solicitarBeca.dominio.enums.Carrera;
import solicitarBeca.dominio.enums.EstadoSolicitud;
import solicitarBeca.dominio.enums.TipoDocumento;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class Seeder {

    public static void main(String[] args) {
        try {
            EstudianteDAO estudianteDAO = new EstudianteDAO();
            DocumentoDAO documentoDAO = new DocumentoDAO();
            SolicitudDAO solicitudDAO = new SolicitudDAO();

            EstudianteDocument estudiante = new EstudianteDocument();
            estudiante.set_id(new ObjectId());
            estudiante.setMatricula(2025001L);
            estudiante.setNombre("Juan Perez");
            estudiante.setCarrera(Carrera.INGENIERIA);
            estudiante.setCorreo("juan@example.com");
            estudiante.setTelefono("555-1234");
            estudiante.setDireccion("Av. Universidad #100");
            estudiante.setContrasenia("12345");
            estudiante.setTutor(new Tutor("Carlos Perez", null, "555-9000", "Av. 10", "carlos@example.com"));
            estudiante.setCreadoEn(Instant.now());

            ObjectId estudianteId = estudianteDAO.create(estudiante);
            System.out.println("Estudiante insertado: " + estudianteId);


            DocumentoDocument doc = new DocumentoDocument();
            doc.set_id(new ObjectId());
            doc.setContenido("PDF_FAKE".getBytes());
            doc.setTipo(TipoDocumento.INE);
            doc.setIdentificador(1L);
            doc.setEstudiante(estudianteId);
            doc.setCreadoEn(Instant.now());

            ObjectId documentoId = documentoDAO.create(doc);
            System.out.println("Documento insertado: " + documentoId);

            SolicitudDocument sol = new SolicitudDocument();
            sol.set_id(new ObjectId());
            sol.setId(1001L);
            sol.setEstudiante(estudianteId);
            sol.setDocumentos(List.of(documentoId));
            sol.setFecha(LocalDate.now());
            sol.setEstado(EstadoSolicitud.ACEPTADA);
            sol.setCreadoEn(Instant.now());

            ObjectId solicitudId = solicitudDAO.create(sol);
            System.out.println("Solicitud insertada: " + solicitudId);

            System.out.println("Seeder ejecutado correctamente.");

        } catch (Exception ex) {
            System.err.println("Error ejecutando Seeder: " + ex.getMessage());
        }
    }
}
