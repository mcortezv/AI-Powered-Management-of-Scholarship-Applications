package interfaces;


import pagarAdeudo.SolicitudPagoDTO;

/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public interface IFachadaPayPal {
    SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO);
}
