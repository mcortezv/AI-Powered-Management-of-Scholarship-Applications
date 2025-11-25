package presentacion.pagarAdeudo.panels;

import dto.pagarAdeudo.ClaseDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;

public class DetalleClase extends PanelPagarAdeudo{
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
