package fachadas;
import controles.ControlBanco;
import dto.pagarAdeudo.SolicitudPagoDTO;
import interfaces.IFachadaBanco;


/**
 *  CASO DE USO PAGAR ADEUDO
 * @author Escalante, Sebastian
 */
public class FachadaBanco implements IFachadaBanco {
    private ControlBanco controlBanco;

    public FachadaBanco(ControlBanco controlBanco){
        this.controlBanco = controlBanco;
    }

    @Override
    public SolicitudPagoDTO ejecutarPago(SolicitudPagoDTO solicitudPagoDTO) {
        return null;
    }
}
