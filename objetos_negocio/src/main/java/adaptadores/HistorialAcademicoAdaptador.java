package adaptadores;
import dominio.HistorialAcademico;
import dto.HistorialAcademicoResponseDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoAdaptador {

    public static HistorialAcademico toEntity(HistorialAcademicoResponseDTO dto) {
        HistorialAcademico historialAcademico = new HistorialAcademico();
        historialAcademico.setCarrera( dto.getCarrera());
        historialAcademico.setPromedio( dto.getPromedio());
        historialAcademico.setProcentajeBajas( dto.getProcentajeBajas());
        historialAcademico.setCargaAcademica( dto.getCargaAcademica());
        historialAcademico.setSemestre( dto.getSemestre());
        historialAcademico.setIndiceReprobacion( dto.getIndiceReprobacion());
        return historialAcademico;
    }
}
