package presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo;

import dtoGobierno.EstudianteDTO;
import pagarAdeudo.ClaseDTO;
import pagarAdeudo.PrestamoDTO;
import pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPago;
import solicitarBeca.dominio.enums.pagarAdeudo.MetodoPago;

import java.util.List;

public class CoordinadorNegocioPagarAdeudo implements ICoordinadorNegocioPagarAdeudo{
    private final IFachadaPago fachadaPago;

    public CoordinadorNegocioPagarAdeudo(IFachadaPago fachadaPago) {
        this.fachadaPago = fachadaPago;
    }

    @Override
    public double obtenerAdeudoBiblioteca(EstudianteDTO estudianteDTO) {
        return fachadaPago.solicitarAdeudoTotalBiblioteca(estudianteDTO);
    }

    @Override
    public double obtenerAdeudoColegiatura(EstudianteDTO estudianteDTO) {
        return fachadaPago.solicitarAdeudoTotalColegiatura(estudianteDTO);
    }

    @Override
    public List<PrestamoDTO> obtenerListaPrestamos(EstudianteDTO estudianteDTO) {
        return fachadaPago.solicitarListaPrestamos(estudianteDTO);
    }

    @Override
    public List<ClaseDTO> obtenerListaClases(EstudianteDTO estudianteDTO) {
        return fachadaPago.solicitarListaClases(estudianteDTO);
    }

    @Override
    public SolicitudPagoDTO realizarPago(SolicitudPagoDTO solicitudPagoDTO, MetodoPago metodoPago) throws Exception {
        return fachadaPago.solicitarRealizarPago(solicitudPagoDTO, metodoPago);
    }

    @Override
    public boolean notificarLiquidacion(SolicitudPagoDTO solicitudPagoDTO) {
        return fachadaPago.notificarLiquidacion(solicitudPagoDTO);
    }
}
