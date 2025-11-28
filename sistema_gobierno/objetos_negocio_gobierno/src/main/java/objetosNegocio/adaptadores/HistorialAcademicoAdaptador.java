package objetosNegocio.adaptadores;
import datos.dominio.HistorialAcademico;
import datos.dominio.enums.Carrera;
import dto_gobierno.HistorialAcademicoDTO;
import dto.gobierno.HistorialAcademicoDTOGobierno;
import objetosNegocio.adaptadores.excepciones.HistorialAcademicoAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoAdaptador {

    public static HistorialAcademico toEntity(HistorialAcademicoDTO dto){
        try {
            HistorialAcademico historialAcademico = new HistorialAcademico();
            historialAcademico.setCarrera(Carrera.valueOf(dto.getCarrera()));
            historialAcademico.setPromedio(dto.getPromedio());
            historialAcademico.setProcentajeBajas(dto.getProcentajeBajas());
            historialAcademico.setCargaAcademica(dto.getCargaAcademica());
            historialAcademico.setSemestre(dto.getSemestre());
            historialAcademico.setIndiceReprobacion(dto.getIndiceReprobacion());
            return historialAcademico;
        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static HistorialAcademico toEntity(HistorialAcademicoDTOGobierno dto){
        try {
            HistorialAcademico historialAcademico = new HistorialAcademico();
            historialAcademico.setCarrera(Carrera.valueOf(dto.getCarrera()));
            historialAcademico.setPromedio(dto.getPromedio());
            historialAcademico.setProcentajeBajas(dto.getProcentajeBajas());
            historialAcademico.setCargaAcademica(dto.getCargaAcademica());
            historialAcademico.setSemestre(dto.getSemestre());
            historialAcademico.setIndiceReprobacion(dto.getIndiceReprobacion());
            return historialAcademico;
        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static HistorialAcademicoDTO toDTO(HistorialAcademico historialAcademico){
        try {
            HistorialAcademicoDTO dto = new HistorialAcademicoDTO();
            dto.setCarrera(historialAcademico.getCarrera().toString());
            dto.setPromedio(historialAcademico.getPromedio());
            dto.setProcentajeBajas(historialAcademico.getProcentajeBajas());
            dto.setCargaAcademica(historialAcademico.getCargaAcademica());
            dto.setSemestre(historialAcademico.getSemestre());
            dto.setIndiceReprobacion(historialAcademico.getIndiceReprobacion());
            return dto;
        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static HistorialAcademicoDTOGobierno toInfraestructuraDTO(HistorialAcademico  historialAcademico){
        try {
            HistorialAcademicoDTOGobierno dto = new HistorialAcademicoDTOGobierno();
            dto.setCarrera(historialAcademico.getCarrera().toString());
            dto.setPromedio(historialAcademico.getPromedio());
            dto.setProcentajeBajas(historialAcademico.getProcentajeBajas());
            dto.setCargaAcademica(historialAcademico.getCargaAcademica());
            dto.setSemestre(historialAcademico.getSemestre());
            dto.setIndiceReprobacion(historialAcademico.getIndiceReprobacion());
            return dto;
        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
