package interfaces.pagarAdeudo;

import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;

import java.util.List;

public interface IAdeudoBO {
    double obtenerAdeudoBiblioteca(String matriculaEstudiante);
    double obtenerAdeudoColegiatura(String matriculaEstudiante);
    List<PrestamoDTO> obtenerDetallePrestamo(String matriculaEstudiante);
    List<ClaseDTO> obtenerDetalleClase(String matriculaEstudiante);
    boolean enviarSolicitudPago(SolicitudPagoDTO solicitudPagoDTO);
}
