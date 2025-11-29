package presentacion.pagarAdeudo.panels;

import pagarAdeudo.PrestamoDTO;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;

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
