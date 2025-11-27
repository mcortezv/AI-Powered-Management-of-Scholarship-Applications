package dto;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public class BecasDisponiblesResponseDTO {
    public List<BecaResponseDTO> becas;

    public BecasDisponiblesResponseDTO(){}

    public BecasDisponiblesResponseDTO(List<BecaResponseDTO> becas) {
        this.becas = becas;
    }

    public List<BecaResponseDTO> getBecas() {
        return becas;
    }

    public void setBecas(List<BecaResponseDTO> becas) {
        this.becas = becas;
    }
}
