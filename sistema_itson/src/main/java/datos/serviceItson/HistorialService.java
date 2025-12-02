package datos.serviceItson;
import datos.dominioItson.HistorialAcademico;
import datos.repositoryItson.daoItson.impl.HistorialAcademicoDAO;


public class HistorialService {
    private final HistorialAcademicoDAO historialAcademicoDAO;

    public HistorialService() {
        this.historialAcademicoDAO = new HistorialAcademicoDAO();
    }

    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        return historialAcademicoDAO.obtenerHistorialAcademico(matricula);
    }
}
