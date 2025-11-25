package controles;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import config.MongoClienteProvider;
import dto.EstudianteDTO;
import dto.EstudianteResponseDTO;
import dto.HistorialAcademicoResponseDTO;
import dto.LoginDTO;
import dto.pagarAdeudo.ClaseDTOI;
import dto.pagarAdeudo.PrestamoDTOI;
import dto.pagarAdeudo.SolicitudPagoDTOI;
import org.bson.Document;
import solicitarBeca.dominio.enums.Carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ControlItson {
    MongoCollection<EstudianteDTO> estudiantes;

    public ControlItson(){
        MongoClienteProvider.INSTANCE.init();
        estudiantes = MongoClienteProvider.INSTANCE.getCollection("estudiantes", EstudianteDTO.class);
    }

    public boolean verificarLogin(LoginDTO loginDTO) {
        System.out.println("llego al ControlItson");
        String matricula = loginDTO.getUsuario();
//        String contrasenia = loginDTO.getContrasenia();
        MongoCollection<EstudianteDTO> estudiantes = MongoClienteProvider.INSTANCE.getCollection("estudiantes", EstudianteDTO.class);
        EstudianteDTO estudiante = estudiantes.find(new org.bson.Document("matricula", matricula)).first();
        return estudiante != null;
    }

    public EstudianteResponseDTO verificarEstudiante(Long matricula) {
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("estudiantes", Document.class);
        Document doc = col.find(Filters.eq("_id", matricula.toString())).first();
        if(doc == null){
            return null;
        }
        EstudianteResponseDTO dto = new EstudianteResponseDTO();
        dto.setMatricula(Long.valueOf(doc.getString("_id")));
        dto.setNombre(doc.getString("nombre"));
        dto.setCorreo(doc.getString("correo"));
        dto.setDireccion(doc.getString("direccion"));
        dto.setTelefono(doc.getString("telefono"));
        dto.setCarrera(Carrera.valueOf(doc.getString("carrera")));
        return dto;
    }

    public HistorialAcademicoResponseDTO verificarHistorialAcademcio(Long matricula) {
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("historialAcademico", Document.class);
        Document doc = col.find(Filters.eq("matricula", matricula.toString())).first();
        if (doc == null) {
            return null;
        }
        HistorialAcademicoResponseDTO historial = new HistorialAcademicoResponseDTO();
        String carreraString = doc.getString("carrera");
        if (carreraString != null) {
            historial.setCarrera(Carrera.valueOf(carreraString));
        }
        historial.setPromedio(doc.getDouble("promedio"));
        historial.setProcentajeBajas(doc.getDouble("porcentajeBajas"));
        historial.setCargaAcademica(doc.getDouble("cargaAcademica"));
        historial.setSemestre(doc.getInteger("semestre"));
        historial.setIndiceReprobacion(doc.getDouble("indiceReprobacion"));
        return historial;
    }


    /**
     * CASO PAGAR ADEUDO ESCALANTE, SEBASTIAN
     * @param matriculaEstudiante
     * @return
     */

    public double solicitarAdeudoBiblioteca(String matriculaEstudiante){
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("estudiantes", Document.class);
        Document doc = col.find(Filters.eq("_id", matriculaEstudiante)).first();
        if (doc == null) return 0.0;
        Double adeudo = doc.getDouble("adeudo_biblioteca");
        if(adeudo == null){
            return 0.0;
        }
        return adeudo;
    }

    public double solicitarAdeudoColegiatura(String matriculaEstudiante){
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("estudiantes", Document.class);
        Document doc = col.find(Filters.eq("_id", matriculaEstudiante)).first();
        if (doc == null) return 0.0;
        Double adeudo = doc.getDouble("adeudo_colegiatura");
        if(adeudo == null){
            return 0.0;
        }
        return adeudo;
    }

    public List<PrestamoDTOI> solicitarListaPrestamos(String matriculaEstudiante){
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("prestamos", Document.class);
        FindIterable<Document> docs = col.find(Filters.eq("matricula", matriculaEstudiante));
        List<PrestamoDTOI> prestamos = new ArrayList<>();
        for (Document d : docs) {
            PrestamoDTOI p = new PrestamoDTOI();
            p.setFechaPrestamo(d.getString("fechaPrestamo"));
            p.setFechaDevolucion(d.getString("fechaDevolucion"));
            p.setIsbn(d.getString("isbn"));
            p.setTitulo(d.getString("titulo"));
            p.setCampus(d.getString("campus"));
            p.setDetalles(d.getString("detalles"));
            prestamos.add(p);
        }
        return prestamos;
    }

    public List<ClaseDTOI> solicitarListaClases(String matriculaEstudiante){
        MongoCollection<Document> col = MongoClienteProvider.INSTANCE.getCollection("clasesInscritas", Document.class);
        FindIterable<Document> docs = col.find(Filters.eq("matricula", matriculaEstudiante));
        List<ClaseDTOI> clases = new ArrayList<>();
        for (Document d : docs) {
            ClaseDTOI c = new ClaseDTOI();
            c.setNombre(d.getString("nombre"));
            c.setHorario(d.getString("horario"));
            c.setProfesor(d.getString("profesor"));
            c.setAula(d.getString("aula"));
            c.setCampus(d.getString("campus"));
            c.setDetalles(d.getString("detalles"));
            clases.add(c);
        }
        return clases;
    }

    public boolean solicitarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI){
        try {
            MongoCollection<Document> col =
                    MongoClienteProvider.INSTANCE.getCollection("pagos", Document.class);

            String id = UUID.randomUUID().toString();

            Document doc = new Document()
                    .append("_id", id)
                    .append("idEstudiante", solicitudPagoDTOI.getIdEstudiante())
                    .append("referenciaPago", solicitudPagoDTOI.getReferenciaPago())
                    .append("fechaPago", solicitudPagoDTOI.getFechaPago())
                    .append("montoPagado", solicitudPagoDTOI.getMontoPagado())
                    .append("metodoPago", solicitudPagoDTOI.getMetodoPago())
                    .append("estatusPago", solicitudPagoDTOI.getEstatusPago());

            col.insertOne(doc);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
