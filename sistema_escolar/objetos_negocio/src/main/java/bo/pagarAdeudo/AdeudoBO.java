package bo.pagarAdeudo;

import itson.pagarAdeudo.ClaseDTOI;
import itson.pagarAdeudo.PrestamoDTOI;
import itson.pagarAdeudo.SolicitudPagoDTOI;
import interfaces.IFachadaITSON;
import interfaces.pagarAdeudo.IAdeudoBO;

import java.util.List;

public class AdeudoBO implements IAdeudoBO {
    private final IFachadaITSON iFachadaITSON;

    public AdeudoBO(IFachadaITSON iFachadaITSON){
        this.iFachadaITSON = iFachadaITSON;
    }

    @Override
    public List<PrestamoDTOI> obtenerDetallePrestamo(Long matricula) {
        return iFachadaITSON.solicitarListaPrestamso(matricula);
    }

    @Override
    public List<ClaseDTOI> obtenerDetalleClase(Long matricula) {
        return iFachadaITSON.solicitarListaClases(matricula);
    }

    @Override
    public boolean enviarSolicitudPago(SolicitudPagoDTOI solicitudPagoDTO) {
        return iFachadaITSON.notificarLiquidacion(solicitudPagoDTO);
    }
}