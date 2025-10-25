package dto;

import java.util.List;

public class SolicitudBecasDisponiblesResponseDTO {
    public List<BecaDTO> becas;

    public SolicitudBecasDisponiblesResponseDTO(){}

    public SolicitudBecasDisponiblesResponseDTO(List<BecaDTO> becas) {
        this.becas = becas;
    }

    public List<BecaDTO> getBecas() {
        return becas;
    }

    public void setBecas(List<BecaDTO> becas) {
        this.becas = becas;
    }
}
