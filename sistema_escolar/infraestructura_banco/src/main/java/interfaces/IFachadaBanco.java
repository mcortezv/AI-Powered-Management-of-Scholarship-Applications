package interfaces;
import pagarAdeudo.SolicitudPagoDTO;

/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public interface IFachadaBanco {

    SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO);
}
