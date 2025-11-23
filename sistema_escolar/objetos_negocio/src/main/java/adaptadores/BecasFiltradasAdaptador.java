package adaptadores;
import solicitarBeca.dominio.Beca;
import solicitarBeca.dominio.BecasFiltradas;
import dto.BecasDisponiblesResponseDTO;
import dto.BecasFiltradasDTO;


/**
 *
 * @author Cortez, Manuel;
 */
public class BecasFiltradasAdaptador {

    public static BecasFiltradas toEntity(BecasDisponiblesResponseDTO dto) {
        BecasFiltradas becasFiltradas = new BecasFiltradas();
        becasFiltradas.setBecas(dto.getBecas());
        return becasFiltradas;
    }

    public static BecasFiltradasDTO toDTO(BecasFiltradas becasFiltradas) {
        BecasFiltradasDTO becasFiltradasDTO = new BecasFiltradasDTO();
        for (Beca beca : becasFiltradas.getBecas()) {
            becasFiltradasDTO.getBecas().add(BecaAdaptador.toDTO(beca));
        }
        return becasFiltradasDTO;

    }
}
