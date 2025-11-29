package presentacion.pagarAdeudo.panels;

import pagarAdeudo.PrestamoDTO;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo.CoordinadorAplicacionPagarAdeudo;

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
