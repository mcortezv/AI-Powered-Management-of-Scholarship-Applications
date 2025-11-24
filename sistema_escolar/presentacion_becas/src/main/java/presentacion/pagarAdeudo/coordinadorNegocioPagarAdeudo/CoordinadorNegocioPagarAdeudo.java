package presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo;

import dto.EstudianteDTO;
import interfaces.IFachadaPago;

public class CoordinadorNegocioPagarAdeudo implements ICoordinadorNegocioPagarAdeudo{
    private final IFachadaPago fachadaPago;

    public CoordinadorNegocioPagarAdeudo(IFachadaPago fachadaPago) {
        this.fachadaPago = fachadaPago;
    }

    @Override
    public double obtenerAdeudoBiblioteca(EstudianteDTO estudianteDTO) {
        return fachadaPago.solicitarAdeudoTotalBiblioteca(estudianteDTO);
    }
}
