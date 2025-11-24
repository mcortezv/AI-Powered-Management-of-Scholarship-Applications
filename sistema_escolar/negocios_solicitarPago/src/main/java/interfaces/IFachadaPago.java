package interfaces;

import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public interface IFachadaPago {
    double solicitarAdeudoTotalBiblioteca(EstudianteDTO estudianteDTO);
    List<PrestamoDTO> solicitarListaPrestamos(EstudianteDTO estudianteDTO);
    double solicitarAdeudoTotalColegiatura(EstudianteDTO estudianteDTO);
    List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO);

    SolicitudPagoDTO solicitarRealizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago);
    boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO);
}
