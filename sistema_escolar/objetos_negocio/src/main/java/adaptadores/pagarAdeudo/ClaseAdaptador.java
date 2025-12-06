package adaptadores.pagarAdeudo;

import pagarAdeudo.ClaseDTO;
import itson.pagarAdeudo.ClaseDTOI;

public class ClaseAdaptador {

    public static ClaseDTO toDTO(ClaseDTOI dtoI) {
        if (dtoI == null) return null;

        ClaseDTO dto = new ClaseDTO();
        dtoI.setCosto(dtoI.getCosto());
        dto.setNombre(dtoI.getNombre());
        dto.setHorario(dtoI.getHorario());
        dto.setProfesor(dtoI.getProfesor());
        dto.setAula(dtoI.getAula());
        dto.setCampus(dtoI.getCampus());
        dto.setDetalles(dtoI.getDetalles());

        return dto;
    }

    public static ClaseDTOI toDTOI(ClaseDTO dto) {
        if (dto == null) return null;

        ClaseDTOI dtoI = new ClaseDTOI();
        dto.setCosto(dto.getCosto());
        dtoI.setNombre(dto.getNombre());
        dtoI.setHorario(dto.getHorario());
        dtoI.setProfesor(dto.getProfesor());
        dtoI.setAula(dto.getAula());
        dtoI.setCampus(dto.getCampus());
        dtoI.setDetalles(dto.getDetalles());

        return dtoI;
    }
}
