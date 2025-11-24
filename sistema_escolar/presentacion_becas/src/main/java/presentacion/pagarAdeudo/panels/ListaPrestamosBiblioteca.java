package presentacion.pagarAdeudo.panels;

import dto.pagarAdeudo.PrestamoDTO;
import presentacion.coordinadorAplicacion.CoordinadorAplicacion;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;

import java.util.List;

public class ListaPrestamosBiblioteca extends PanelPagarAdeudo{

    public ListaPrestamosBiblioteca(PagarAdeudo frame, CoordinadorAplicacionPagarAdeudo coordinadorAplicacion) {
        super(frame, coordinadorAplicacion);
    }

    @Override
    public void startComponents() {

    }

    public void setPrestamos(List<PrestamoDTO> prestamos){

    }

    public void setAdeudo(double adeudo){

    }
}
