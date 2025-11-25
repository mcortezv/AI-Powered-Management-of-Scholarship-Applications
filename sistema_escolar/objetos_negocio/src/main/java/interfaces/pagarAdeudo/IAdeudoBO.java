package interfaces.pagarAdeudo;

import dto.pagarAdeudo.*;

import java.util.List;

public interface IAdeudoBO {
    double obtenerAdeudoBiblioteca(String matriculaEstudiante);
    double obtenerAdeudoColegiatura(String matriculaEstudiante);
    List<PrestamoDTOI> obtenerDetallePrestamo(String matriculaEstudiante);
    List<ClaseDTOI> obtenerDetalleClase(String matriculaEstudiante);
    boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO);
}
