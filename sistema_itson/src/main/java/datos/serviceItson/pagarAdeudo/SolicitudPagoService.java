package datos.serviceItson.pagarAdeudo;

import banco.SolicitudPagoDTOI;
import datos.adaptadoresItson.pagarAdeudo.SolicitudPagoAdaptador;
import datos.repositoryItson.daoItson.pagarAdeudo.impl.SolicitudPagoDAO;
import datos.repositoryItson.documents.pagarAdeudo.SolicitudPagoDocument;

public class SolicitudPagoService {
    private final SolicitudPagoDAO solicitudPagoDAO;

    public SolicitudPagoService(){
        this.solicitudPagoDAO = new SolicitudPagoDAO();
    }

    public boolean notificarLiquidacion(SolicitudPagoDTOI solicitudPagoDTOI){
        SolicitudPagoDocument solicitudPago = SolicitudPagoAdaptador.toDocument(solicitudPagoDTOI);
        return solicitudPagoDAO.guardarSolicitud(solicitudPago);
    }
}
