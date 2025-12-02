package presentacion.pagarAdeudo.panels;

import pagarAdeudo.ClaseDTO;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.PanelPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;

public class DetalleClase extends PanelPagarAdeudo {
    private ClaseDTO claseDTO;

    public DetalleClase(PagarAdeudo frame, CoordinadorAplicacionPagarAdeudo coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {

    }

    public void setClase(ClaseDTO claseDTO){
        this.claseDTO = claseDTO;
    }

}
