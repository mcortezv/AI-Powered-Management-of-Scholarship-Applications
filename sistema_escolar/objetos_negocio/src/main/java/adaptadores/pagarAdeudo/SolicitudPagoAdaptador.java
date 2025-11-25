package adaptadores.pagarAdeudo;

import dto.pagarAdeudo.SolicitudPagoDTO;
import dto.pagarAdeudo.SolicitudPagoDTOI;

public class SolicitudPagoAdaptador {

    public static SolicitudPagoDTO toDTO(SolicitudPagoDTOI dtoI) {
        if (dtoI == null) return null;

        SolicitudPagoDTO dto = new SolicitudPagoDTO();

        dto.setIdEstudiante(dtoI.getIdEstudiante());
        dto.setReferenciaPago(dtoI.getReferenciaPago());
        dto.setFechaPago(dtoI.getFechaPago());
        dto.setMontoPagado(dtoI.getMontoPagado());
        dto.setMetodoPago(dtoI.getMetodoPago());
        dto.setEstatusPago(dtoI.getEstatusPago());

        return dto;
    }

    /**
     * Convierte de DTO interno (DTO) al DTO de Infraestructura (DTOI).
     */
    public static SolicitudPagoDTOI toDTOI(SolicitudPagoDTO dto) {
        if (dto == null) return null;

        SolicitudPagoDTOI dtoI = new SolicitudPagoDTOI();

        dtoI.setIdEstudiante(dto.getIdEstudiante());
        dtoI.setReferenciaPago(dto.getReferenciaPago());
        dtoI.setFechaPago(dto.getFechaPago());
        dtoI.setMontoPagado(dto.getMontoPagado());
        dtoI.setMetodoPago(dto.getMetodoPago());
        dtoI.setEstatusPago(dto.getEstatusPago());

        return dtoI;
    }
}
