package adaptadores;
import solicitarBeca.dominio.HistorialAcademico;
import solicitarBeca.dominio.enums.Carrera;
import dto.HistorialAcademicoDTO;
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

    public static HistorialAcademico toEntity(HistorialAcademicoDTO dto) {
        HistorialAcademico historialAcademico = new HistorialAcademico();
        historialAcademico.setCarrera(Carrera.valueOf(dto.getCarrera()));
        historialAcademico.setPromedio( dto.getPromedio());
        historialAcademico.setProcentajeBajas( dto.getProcentajeBajas());
        historialAcademico.setCargaAcademica( dto.getCargaAcademica());
        historialAcademico.setSemestre( dto.getSemestre());
        historialAcademico.setIndiceReprobacion( dto.getIndiceReprobacion());
        return historialAcademico;
    }

    public static HistorialAcademicoDTO toDTO(HistorialAcademico  historialAcademico) {
        HistorialAcademicoDTO dto = new HistorialAcademicoDTO();
        dto.setCarrera( historialAcademico.getCarrera().toString());
        dto.setPromedio( historialAcademico.getPromedio());
        dto.setProcentajeBajas( historialAcademico.getProcentajeBajas());
        dto.setCargaAcademica( historialAcademico.getCargaAcademica());
        dto.setSemestre( historialAcademico.getSemestre());
        dto.setIndiceReprobacion( historialAcademico.getIndiceReprobacion());
        return dto;
    }
}
