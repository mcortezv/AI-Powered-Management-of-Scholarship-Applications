package interfaces;


import dto.pagarAdeudo.SolicitudPagoDTO;
import dto.pagarAdeudo.SolicitudPagoDTOI;

/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public interface IFachadaBanco {
    SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO);
}
