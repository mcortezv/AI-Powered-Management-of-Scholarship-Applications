package interfaces.pagarAdeudo;

import banco.ClaseDTOI;
import banco.PrestamoDTOI;
import banco.SolicitudPagoDTOI;

import java.util.List;

public interface IAdeudoBO {
    double obtenerAdeudoBiblioteca(Long matricula);
    double obtenerAdeudoColegiatura(Long matricula);
    List<PrestamoDTOI> obtenerDetallePrestamo(Long matricula);
    List<ClaseDTOI> obtenerDetalleClase(Long matricula);
    boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO);
}
