package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import adaptadores.solicitarBeca.excepciones.RequisitosAdaptadorException;
import dto.RequisitosResponseDTO;
import solicitarBeca.dominio.Requisitos;
import dto.RequisitosDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class RequisitosAdaptador {

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
        } catch (Exception ex) {
            throw new RequisitosAdaptadorException("Error al convertir entidad Requisitos a DTO");
        }
    }

    public static Requisitos toEntity(RequisitosResponseDTO dto){
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
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir ResponseDTO Requisistos a Entidad");
        }
    }

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
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir DTO Requisitos a Entidad");
        }
    }
}