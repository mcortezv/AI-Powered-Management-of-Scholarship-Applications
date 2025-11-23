package adaptadores;
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

    public static Beca toEntity(BecaDTO becaDTO){
        Beca beca = new Beca();
        beca.setCodigo(becaDTO.getCodigo());
        beca.setNombre(becaDTO.getNombre());
        beca.setBecasDisponibles(becaDTO.getBecasDisponibles());
        beca.setDescripcion(becaDTO.getDescripcion());
        beca.setFechaInicio(becaDTO.getFechaInicio());
        beca.setFechaFin(becaDTO.getFechaFin());
        beca.setFechaResultados(becaDTO.getFechaResultados());
        beca.setTipo(TipoBeca.valueOf(becaDTO.getTipo()));
        beca.setRequisitos(RequisitosAdaptador.toEntity(becaDTO.getRequisitos()));
        return beca;
    }

}
