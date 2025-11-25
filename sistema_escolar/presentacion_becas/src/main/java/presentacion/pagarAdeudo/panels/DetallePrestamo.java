package presentacion.pagarAdeudo.panels;

import dto.pagarAdeudo.PrestamoDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;

public class DetallePrestamo extends PanelPagarAdeudo{
    private PrestamoDTO prestamoDTO;
    public DetallePrestamo(PagarAdeudo frame, CoordinadorAplicacionPagarAdeudo coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {

    }

    public void setPrestamo(PrestamoDTO prestamo){
        this.prestamoDTO = prestamo;
    }
}
