package datos.service;
import datos.dominio.HistorialAcademico;
import datos.repository.dao.HistorialAcademicoDAO;


public class HistorialService {
    private final HistorialAcademicoDAO historialAcademicoDAO;

    public HistorialService() {
        this.historialAcademicoDAO = new HistorialAcademicoDAO();
    }

    public HistorialAcademico obtenerHistorialAcademico(Long matricula){
        return historialAcademicoDAO.obtenerHistorialAcademico(matricula);
    }
}
