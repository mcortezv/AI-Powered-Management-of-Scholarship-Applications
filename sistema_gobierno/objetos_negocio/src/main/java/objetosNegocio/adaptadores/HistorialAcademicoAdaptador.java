package objetosNegocio.adaptadores;
import datos.dominio.HistorialAcademico;
import dto.HistorialAcademicoDTO;
import dto.HistorialAcademicoInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.HistorialAcademicoAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoAdaptador {

    public static HistorialAcademico toEntity(HistorialAcademicoDTO dto){
        try {

        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static HistorialAcademico toEntity(HistorialAcademicoInfraestructuraDTO dto){
        try {

        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static HistorialAcademicoDTO toDTO(HistorialAcademico historialAcademico){
        try {

        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static HistorialAcademicoInfraestructuraDTO toInfraestructuraDTO(HistorialAcademico  historialAcademico){
        try {

        } catch (Exception sinUso){
            throw new HistorialAcademicoAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
