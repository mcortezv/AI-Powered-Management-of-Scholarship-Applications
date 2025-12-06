package fachadas;

import controles.ControlPago;
import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;
import java.util.Objects;

public class FachadaPago implements IFachadaPago {
    public ControlPago controlPago;

    public FachadaPago(ControlPago controlPago){
        this.controlPago = controlPago;
    }

    @Override
    public List<PrestamoDTO> solicitarListaPrestamos(EstudianteDTO estudianteDTO) {
        return controlPago.solicitarListaPrestamos(estudianteDTO);
    }

    @Override
    public List<ClaseDTO> solicitarListaClases(EstudianteDTO estudianteDTO) {
        return controlPago.solicitarListaClases(estudianteDTO);
    }

    @Override
    public SolicitudPagoDTO solicitarRealizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago) throws Exception {
        if(Objects.equals(String.valueOf(metodoPago), "BANCO")){
            return controlPago.solicitarRealizarPagoBanco(solicitudPagoDTO);
        }
        if(Objects.equals(String.valueOf(metodoPago), "PAYPAL")){
            return controlPago.solicitarRealizarPagoPayPal(solicitudPagoDTO);
        }else{
            throw new Exception("Error");
        }

    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO) {
        return controlPago.notificarLiquidacion(solicitudPagoDTO);
    }
}
