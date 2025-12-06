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

    public double calcularTotalPrestamos(List<PrestamoDTO> prestamos) {
        double total = 0.0;
        if (prestamos != null) {
            for (PrestamoDTO p : prestamos) {
                total += p.getCosto();
            }
        }

        System.out.println(total);
        return total;
    }

    public double calcularTotalClases(List<ClaseDTO> clases) {
        double total = 0.0;
        if (clases != null) {
            for (ClaseDTO c : clases) {
                total += c.getCosto();
            }
        }
        System.out.println(total);
        return total;
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
