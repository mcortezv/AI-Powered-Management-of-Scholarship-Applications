package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import adaptadores.solicitarBeca.excepciones.HistorialAcademicoAdaptadorException;
import dto.HistorialAcademicoDTO;
import dto.gobierno.HistorialAcademicoDTOGobierno;
import solicitarBeca.dominio.HistorialAcademico;
import solicitarBeca.dominio.enums.Carrera;
import dto.itson.HistorialAcademicoDTOItson;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoAdaptador {

    public static HistorialAcademico toEntity(HistorialAcademicoDTOItson dto) {
        try {
            HistorialAcademico historialAcademico = new HistorialAcademico();
            historialAcademico.setCarrera( Carrera.valueOf(dto.getCarrera()));
            historialAcademico.setPromedio( dto.getPromedio());
            historialAcademico.setProcentajeBajas( dto.getProcentajeBajas());
            historialAcademico.setCargaAcademica( dto.getCargaAcademica());
            historialAcademico.setSemestre( dto.getSemestre());
            historialAcademico.setIndiceReprobacion( dto.getIndiceReprobacion());
            return historialAcademico;
        } catch (Exception ex) {
            throw new HistorialAcademicoAdaptadorException("Error al convertir ResponseDTO HistorialAcademico a Entidad");
        }
    }

    public static HistorialAcademico toEntity(HistorialAcademicoDTO dto) {
        try {
            HistorialAcademico historialAcademico = new HistorialAcademico();
            historialAcademico.setCarrera(Carrera.valueOf(dto.getCarrera()));
            historialAcademico.setPromedio( dto.getPromedio());
            historialAcademico.setProcentajeBajas( dto.getProcentajeBajas());
            historialAcademico.setCargaAcademica( dto.getCargaAcademica());
            historialAcademico.setSemestre( dto.getSemestre());
            historialAcademico.setIndiceReprobacion( dto.getIndiceReprobacion());
            return historialAcademico;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir DTO HistorialAcademico a Entidad");
        }
    }

    public static HistorialAcademicoDTO toDTO(HistorialAcademico historialAcademico) {
        try {
            HistorialAcademicoDTO dto = new HistorialAcademicoDTO();
            dto.setCarrera( historialAcademico.getCarrera().toString());
            dto.setPromedio( historialAcademico.getPromedio());
            dto.setProcentajeBajas( historialAcademico.getProcentajeBajas());
            dto.setCargaAcademica( historialAcademico.getCargaAcademica());
            dto.setSemestre( historialAcademico.getSemestre());
            dto.setIndiceReprobacion( historialAcademico.getIndiceReprobacion());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad HistorialAcademico a DTO");
        }
    }

    public static HistorialAcademicoDTOGobierno toDTOGobierno(HistorialAcademico historialAcademico) {
        try {
            HistorialAcademicoDTOGobierno dto = new HistorialAcademicoDTOGobierno();
            dto.setCarrera( historialAcademico.getCarrera().toString());
            dto.setPromedio( historialAcademico.getPromedio());
            dto.setProcentajeBajas( historialAcademico.getProcentajeBajas());
            dto.setCargaAcademica( historialAcademico.getCargaAcademica());
            dto.setSemestre( historialAcademico.getSemestre());
            dto.setIndiceReprobacion( historialAcademico.getIndiceReprobacion());
            return dto;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad HistorialAcademico a DTO");
        }
    }
}
