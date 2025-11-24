package fachadas;

import controles.ControlPago;
import dto.EstudianteDTO;
import dto.pagarAdeudo.ClaseDTO;
import dto.pagarAdeudo.PrestamoDTO;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;

import java.util.List;

public class FachadaPago implements IFachadaPago {
    public ControlPago solicitudPago;
    public SolicitudPagoDTO solicitudPagoDTO;

    public FachadaPago(ControlPago controlSolicitudPago){
        this.solicitudPago = controlSolicitudPago;
    }

    @Override
    public double solicitarAdeudoTotalBiblioteca(EstudianteDTO estudianteDTO) {
        return 0.0;
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
    public SolicitudPagoDTO solicitarRealizarPago(SolicitudPagoDTO solicitudPagoDTO, String metodoPago) {
        return null;
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO) {
        return false;
    }
}
