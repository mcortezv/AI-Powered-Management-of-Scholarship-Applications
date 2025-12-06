package interfaces;

import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public interface IFachadaPago {
    List<PrestamoDTO> solicitarListaPrestamos(EstudianteDTO estudianteDTO);
    List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO);
    void solicitarVistaDePago(ActionListener listener);
    SolicitudPagoDTO realizarPago(SolicitudPagoDTO solicitudPagoDTO);
    void cerrarVentana();
    boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO);
}
