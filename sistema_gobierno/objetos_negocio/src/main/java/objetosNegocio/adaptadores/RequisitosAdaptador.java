package objetosNegocio.adaptadores;
import datos.dominio.Requisitos;
import dto.RequisitosDTO;
import dto.RequisitosInfraestructuraDTO;
import objetosNegocio.adaptadores.excepciones.RequisitosAdaptadorException;

/**
 *
 * @author Cortez, Manuel;
 */
public class RequisitosAdaptador {

    public static Requisitos toEntity(RequisitosDTO dto){
        try {
            Requisitos requisitos = new Requisitos();
            requisitos.setPromedioMinimo(dto.getPromedioMinimo());
            requisitos.setIngresoFamiliarMaximo(dto.getIngresoFamiliarMaximo());
            requisitos.setProcentajeBajas(dto.getProcentajeBajas());
            requisitos.setCargaAcademica(dto.getCargaAcademica());
            requisitos.setIndiceReprobacion(dto.getIndiceReprobacion());
            requisitos.setTrabajo(dto.isTrabajo());
            requisitos.setDeudas(dto.isDeudas());
            return requisitos;
        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la DTO a Entidad");
        }
    }

    public static Requisitos toEntity(RequisitosInfraestructuraDTO dto){
        try {
            Requisitos requisitos = new Requisitos();
            requisitos.setPromedioMinimo(dto.getPromedioMinimo());
            requisitos.setIngresoFamiliarMaximo(dto.getIngresoFamiliarMaximo());
            requisitos.setProcentajeBajas(dto.getProcentajeBajas());
            requisitos.setCargaAcademica(dto.getCargaAcademica());
            requisitos.setIndiceReprobacion(dto.getIndiceReprobacion());
            requisitos.setTrabajo(dto.isTrabajo());
            requisitos.setDeudas(dto.isDeudas());
            return requisitos;
        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la DTO de Infraestructura a Entidad");
        }
    }

    public static RequisitosDTO toDTO(Requisitos requisitos){
        try {
            RequisitosDTO dto = new RequisitosDTO();
            dto.setPromedioMinimo(requisitos.getPromedioMinimo());
            dto.setIngresoFamiliarMaximo(requisitos.getIngresoFamiliarMaximo());
            dto.setProcentajeBajas(requisitos.getProcentajeBajas());
            dto.setCargaAcademica(requisitos.getCargaAcademica());
            dto.setIndiceReprobacion(requisitos.getIndiceReprobacion());
            dto.setTrabajo(requisitos.isTrabajo());
            dto.setDeudas(requisitos.isDeudas());
            return dto;
        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la Entidad a DTO");
        }
    }

    public static RequisitosInfraestructuraDTO toInfraestructuraDTO(Requisitos  requisitos){
        try {
            RequisitosInfraestructuraDTO dto = new RequisitosInfraestructuraDTO();
            dto.setPromedioMinimo(requisitos.getPromedioMinimo());
            dto.setIngresoFamiliarMaximo(requisitos.getIngresoFamiliarMaximo());
            dto.setProcentajeBajas(requisitos.getProcentajeBajas());
            dto.setCargaAcademica(requisitos.getCargaAcademica());
            dto.setIndiceReprobacion(requisitos.getIndiceReprobacion());
            dto.setTrabajo(requisitos.isTrabajo());
            dto.setDeudas(requisitos.isDeudas());
            return dto;
        } catch (Exception sinUso){
            throw new RequisitosAdaptadorException("No se pudo mappear la Entidad a DTO Infraestructura");
        }
    }
}
