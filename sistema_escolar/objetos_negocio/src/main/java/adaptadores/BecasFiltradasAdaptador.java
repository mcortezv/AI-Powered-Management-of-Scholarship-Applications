package adaptadores;
import dominio.BecasFiltradas;
import dto.BecasDisponiblesResponseDTO;

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
}
