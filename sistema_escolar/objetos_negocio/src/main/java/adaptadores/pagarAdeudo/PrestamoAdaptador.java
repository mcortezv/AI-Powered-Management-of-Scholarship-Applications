package adaptadores.pagarAdeudo;

import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.PrestamoDTOI;

public class PrestamoAdaptador {

    public static PrestamoDTO toDTO(PrestamoDTOI dtoI) {
        if (dtoI == null) return null;

        PrestamoDTO dto = new PrestamoDTO();

        dto.setFechaPrestamo(dtoI.getFechaPrestamo());
        dto.setFechaDevolucion(dtoI.getFechaDevolucion());
        dto.setIsbn(dtoI.getIsbn());
        dto.setTitulo(dtoI.getTitulo());
        dto.setCampus(dtoI.getCampus());
        dto.setDetalles(dtoI.getDetalles());

        return dto;
    }

    public static PrestamoDTOI toDTOI(PrestamoDTO dto) {
        if (dto == null) return null;

        PrestamoDTOI dtoI = new PrestamoDTOI();

        dtoI.setFechaPrestamo(dto.getFechaPrestamo());
        dtoI.setFechaDevolucion(dto.getFechaDevolucion());
        dtoI.setIsbn(dto.getIsbn());
        dtoI.setTitulo(dto.getTitulo());
        dtoI.setCampus(dto.getCampus());
        dtoI.setDetalles(dto.getDetalles());

        return dtoI;
    }
}
