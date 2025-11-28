package adaptadores.solicitarBeca;
import adaptadores.solicitarBeca.excepciones.BecasFiltradasAdaptadorException;
import dto.BecaDTO;
import dto.gobierno.BecaDTOGobierno;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import dto.gobierno.BecasDisponiblesDTOGobierno;
import dto.BecasFiltradasDTO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Cortez, Manuel;
 */
public class BecasFiltradasAdaptador {

    public static BecasFiltradas toEntity(BecasDisponiblesDTOGobierno dto) {
        try {
            BecasFiltradas becasFiltradas = new BecasFiltradas();
            List<Beca> becas = new ArrayList<>();
            for (BecaDTOGobierno becaResponseDTO : dto.getBecas()) {
                becas.add(BecaAdaptador.toEntity(becaResponseDTO));
            }
            becasFiltradas.setBecas(becas);
            return becasFiltradas;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir ResponseDTO BecasDisponibles a entidad");
        }
    }

    public static BecasFiltradasDTO toDTO(BecasFiltradas becasFiltradas) {
        try {
            BecasFiltradasDTO becasFiltradasDTO = new BecasFiltradasDTO();
            List<BecaDTO> becas = new ArrayList<>();
            for (Beca beca : becasFiltradas.getBecas()) {
                becasFiltradasDTO.getBecas().add(BecaAdaptador.toDTO(beca));
            }
            becasFiltradasDTO.setBecas(becas);
            return becasFiltradasDTO;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad BecasFiltradas a DTO");
        }
    }

    public static BecasFiltradasDTO toDTO(BecasDisponiblesDTOGobierno becasFiltradas) {
        try {
            BecasFiltradasDTO becasFiltradasDTO = new BecasFiltradasDTO();
            List<BecaDTO> becas = new ArrayList<>();
            for (BecaDTOGobierno beca : becasFiltradas.getBecas()) {
                becasFiltradasDTO.getBecas().add(BecaAdaptador.toDTO(beca));
            }
            becasFiltradasDTO.setBecas(becas);
            return becasFiltradasDTO;
        } catch (Exception ex) {
            throw new BecasFiltradasAdaptadorException("Error al convertir entidad BecasFiltradas a DTO");
        }
    }
}
