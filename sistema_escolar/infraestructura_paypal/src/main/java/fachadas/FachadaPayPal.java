package fachadas;
import controles.ControlPayPal;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPayPal;

/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public class FachadaPayPal implements IFachadaPayPal {
    private final ControlPayPal controlPayPal;

    public FachadaPayPal(ControlPayPal controlPayPal){
        this.controlPayPal = controlPayPal;
    }
    @Override
    public SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO) {
        return null;
    }
}
