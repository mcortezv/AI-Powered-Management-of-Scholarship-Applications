package adaptadores;
import dto.BecaResponseDTO;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.enums.TipoBeca;
import dto.BecaDTO;

/**
 *
 * @author Cortez, Manuel;
 */
public class BecaAdaptador {

    public static BecaDTO toDTO(Beca beca){
        BecaDTO becaDTO = new BecaDTO();
        becaDTO.setCodigo(beca.getCodigo());
        becaDTO.setNombre(beca.getNombre());
        becaDTO.setBecasDisponibles(beca.getBecasDisponibles());
        becaDTO.setDescripcion(beca.getDescripcion());
        becaDTO.setFechaInicio(beca.getFechaInicio());
        becaDTO.setFechaFin(beca.getFechaFin());
        becaDTO.setFechaResultados(beca.getFechaResultados());
        becaDTO.setTipo(beca.getTipo().toString());
        becaDTO.setRequisitos(RequisitosAdaptador.toDTO(beca.getRequisitos()));
        return becaDTO;
    }

    public static Beca toEntity(BecaResponseDTO becaResponseDTO){
        Beca beca = new Beca();
        beca.setCodigo(becaResponseDTO.getCodigo());
        beca.setNombre(becaResponseDTO.getNombre());
        beca.setBecasDisponibles(becaResponseDTO.getBecasDisponibles());
        beca.setDescripcion(becaResponseDTO.getDescripcion());
        beca.setFechaInicio(becaResponseDTO.getFechaInicio());
        beca.setFechaFin(becaResponseDTO.getFechaFin());
        beca.setFechaResultados(becaResponseDTO.getFechaResultados());
        beca.setTipo(TipoBeca.valueOf(becaResponseDTO.getTipo().toString()));
        beca.setRequisitos(RequisitosAdaptador.toEntity(becaResponseDTO.getRequisitos()));
        return beca;
    }

}
