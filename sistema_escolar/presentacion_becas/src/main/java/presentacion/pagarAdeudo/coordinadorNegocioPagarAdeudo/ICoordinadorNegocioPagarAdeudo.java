package presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo;

import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
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
