package fachadas;


import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaPayPal;

/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public class FachadaPayPal implements IFachadaPayPal {
    @Override
    public SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO) {
        return null;
    }
}
