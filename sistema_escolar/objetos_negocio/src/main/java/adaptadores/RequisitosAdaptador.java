package adaptadores;
import solicitarBeca.dominio.Requisitos;
import dto.RequisitosDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class RequisitosAdaptador {

    public static RequisitosDTO toDTO(Requisitos requisitos){
        RequisitosDTO dto = new RequisitosDTO();
        dto.setPromedioMinimo(requisitos.getPromedioMinimo());
        dto.setIngresoFamiliarMaximo(requisitos.getIngresoFamiliarMaximo());
        dto.setProcentajeBajas(requisitos.getProcentajeBajas());
        dto.setCargaAcademica(requisitos.getCargaAcademica());
        dto.setIndiceReprobacion(requisitos.getIndiceReprobacion());
        dto.setTrabajo(requisitos.isTrabajo());
        dto.setDeudas(requisitos.isDeudas());
        return dto;
    }

    public static Requisitos toEntity(RequisitosDTO dto){
        Requisitos requisitos = new Requisitos();
        requisitos.setPromedioMinimo(dto.getPromedioMinimo());
        requisitos.setIngresoFamiliarMaximo(dto.getIngresoFamiliarMaximo());
        requisitos.setProcentajeBajas(dto.getProcentajeBajas());
        requisitos.setCargaAcademica(dto.getCargaAcademica());
        requisitos.setIndiceReprobacion(dto.getIndiceReprobacion());
        requisitos.setTrabajo(dto.isTrabajo());
        requisitos.setDeudas(dto.isDeudas());
        return requisitos;
    }
}