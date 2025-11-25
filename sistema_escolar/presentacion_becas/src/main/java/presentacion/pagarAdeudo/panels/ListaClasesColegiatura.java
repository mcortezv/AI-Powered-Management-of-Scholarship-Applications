package presentacion.pagarAdeudo.panels;

import dto.pagarAdeudo.ClaseDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;

import java.util.List;

public class ListaClasesColegiatura extends PanelPagarAdeudo{

    public ListaClasesColegiatura(PagarAdeudo frame, CoordinadorAplicacionPagarAdeudo coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {

    }

    public void setClases(List<ClaseDTO> clases){

    }

    public void setAdeudo(double adeudo){

    }
}
