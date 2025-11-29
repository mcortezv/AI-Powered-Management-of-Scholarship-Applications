package datos.repository.dao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import datos.config.MongoClienteProvider;
import datos.dominio.HistorialAcademico;
import datos.excepciones.DaoException;


public class HistorialAcademicoDAO {
    private final MongoCollection<HistorialAcademico> col;

    public HistorialAcademicoDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("historiales", HistorialAcademico.class);
    }

    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        try {
            HistorialAcademico est = col.find(Filters.eq("matriculaEstudiante", matricula)).first();
            return est;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Error al buscar historial academico: " + matricula);
        }
    }
}
