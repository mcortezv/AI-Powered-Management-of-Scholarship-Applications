package fachadas;

import controles.ControlPago;
import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public class FachadaPago implements IFachadaPago {
    public ControlPago controlPago;
    public SolicitudPagoDTO solicitudPagoDTO;

    public FachadaPago(ControlPago controlPago){
        this.controlPago = controlPago;
    }

    @Override
    public double solicitarAdeudoTotalBiblioteca(EstudianteDTO estudianteDTO) {
        return controlPago.solicitarAdeudoTotalBiblioteca(estudianteDTO);
    }

    @Override
    public List<PrestamoDTO> solicitarListaPrestamos(EstudianteDTO estudianteDTO) {
        return List.of();
    }

    @Override
    public double solicitarAdeudoTotalColegiatura(EstudianteDTO estudianteDTO) {
        return 0;
    }

    @Override
    public List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO) {
        return List.of();
    }

    @Override
    public SolicitudPagoDTO solicitarRealizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago) {
        return null;
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO) {
        return false;
    }
}
