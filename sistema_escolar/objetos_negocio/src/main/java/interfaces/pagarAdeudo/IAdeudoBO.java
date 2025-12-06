package interfaces.pagarAdeudo;

import itson.pagarAdeudo.ClaseDTOI;
import itson.pagarAdeudo.PrestamoDTOI;
import itson.pagarAdeudo.SolicitudPagoDTOI;

import java.util.List;

public interface IAdeudoBO {
    List<PrestamoDTOI> obtenerDetallePrestamo(Long matricula);
    List<ClaseDTOI> obtenerDetalleClase(Long matricula);
    boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO);
}
