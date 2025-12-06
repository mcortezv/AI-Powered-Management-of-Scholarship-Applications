package adaptadores.pagarAdeudo;

import pagarAdeudo.PrestamoDTO;
import itson.pagarAdeudo.PrestamoDTOI;

public class PrestamoAdaptador {

    public static PrestamoDTO toDTO(PrestamoDTOI dtoI) {
        if (dtoI == null) return null;
        System.out.println("Adaptador recibiendo costo: " + dtoI.getCosto());
        PrestamoDTO dto = new PrestamoDTO();
        dto.setCosto(dto.getCosto());
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
        dto.setCosto(dto.getCosto());
        dtoI.setFechaPrestamo(dto.getFechaPrestamo());
        dtoI.setFechaDevolucion(dto.getFechaDevolucion());
        dtoI.setIsbn(dto.getIsbn());
        dtoI.setTitulo(dto.getTitulo());
        dtoI.setCampus(dto.getCampus());
        dtoI.setDetalles(dto.getDetalles());

        return dtoI;
    }
}
