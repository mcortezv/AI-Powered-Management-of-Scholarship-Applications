package presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo;

import adaptadores.EstudianteAdaptador;
import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import dto.pagarAdeudo.SolicitudPagoDTOI;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public interface ICoordinadorNegocioPagarAdeudo {
    double obtenerAdeudoBiblioteca(EstudianteDTO estudianteDTO);
    double obtenerAdeudoColegiatura(EstudianteDTO estudianteDTO);
    List<PrestamoDTO> obtenerListaPrestamos(EstudianteDTO estudianteDTO);
    List<ClaseDTO> obtenerListaClases(EstudianteDTO estudianteDTO);
    SolicitudPagoDTO realizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago) throws Exception;
    boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO);

}
