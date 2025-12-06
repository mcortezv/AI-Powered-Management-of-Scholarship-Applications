package interfaces;

import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public interface IFachadaPago {
    List<PrestamoDTO> solicitarListaPrestamos(EstudianteDTO estudianteDTO);
    List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO);
    SolicitudPagoDTO solicitarRealizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago) throws Exception;
    boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO);
}
