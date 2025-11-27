package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecaAdaptadorException;
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
        try {
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
        } catch (Exception ex) {
            throw new BecaAdaptadorException("Error al convertir entidad Beca a DTO");
        }
    }

    public static Beca toEntity(BecaDTO becaDTO){
        try {
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
        } catch (Exception ex) {
            throw new BecaAdaptadorException("Error al convertir DTO Beca a entidad");
        }
    }

    public static Beca toEntity(BecaResponseDTO becaResponseDTO){
        try {
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
        } catch (Exception ex) {
            throw new BecaAdaptadorException("Error al convertir ResponseDTO Beca a entidad");
        }
    }
}
