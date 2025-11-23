package dto;
import solicitarBeca.dominio.Beca;
import java.util.List;

/**
 * @author Escalante, Sebastian.
 */
public class BecasDisponiblesResponseDTO {
    public List<Beca> becas;

    public BecasDisponiblesResponseDTO(){}

    public BecasDisponiblesResponseDTO(List<Beca> becas) {
        this.becas = becas;
    }

    public List<Beca> getBecas() {
        return becas;
    }

    public void setBecas(List<Beca> becas) {
        this.becas = becas;
    }
}
