package interfaces.pagarAdeudo;

import dto.banco.ClaseDTOI;
import dto.banco.PrestamoDTOI;
import dto.banco.SolicitudPagoDTOI;

import java.util.List;

public interface IAdeudoBO {
    double obtenerAdeudoBiblioteca(String matriculaEstudiante);
    double obtenerAdeudoColegiatura(String matriculaEstudiante);
    List<PrestamoDTOI> obtenerDetallePrestamo(String matriculaEstudiante);
    List<ClaseDTOI> obtenerDetalleClase(String matriculaEstudiante);
    boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO);
}
