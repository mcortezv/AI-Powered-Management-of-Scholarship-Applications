package presentacion.pagarAdeudo.coordinadorAplicacionPagarAdeudo;

import interfaces.IFachadaPago;
import presentacion.pagarAdeudo.PagarAdeudo;
import presentacion.pagarAdeudo.coordinadorNegocioPagarAdeudo.CoordinadorNegocioPagarAdeudo;
import presentacion.pagarAdeudo.mainFraimePagarAdeudo.MainFramePagarAdeudo;

public class CoordinadorAplicacionPagarAdeudo implements ICoordinadorAplicacionPagarAdeudo{
    private final MainFramePagarAdeudo mainFrame;
    private final CoordinadorNegocioPagarAdeudo coordinadorNegocioPagarAdeudo;
    private PagarAdeudo pagarAdeudo;

    public CoordinadorAplicacionPagarAdeudo(IFachadaPago fachadaPago) {
        coordinadorNegocioPagarAdeudo = new CoordinadorNegocioPagarAdeudo(fachadaPago);
        mainFrame = new MainFramePagarAdeudo(this);
        mainFrame.setVisible(true);
    }

    public void pagarAdeudo(){
        mainFrame.setVisible(false);
        pagarAdeudo = new PagarAdeudo(this);
        pagarAdeudo.setVisible(true);
    }


    @Override
    public void seleccionarAdeudoBiblioteca() {

    }

    @Override
    public void seleccionarAdeudoColegiatura() {

    }
}
