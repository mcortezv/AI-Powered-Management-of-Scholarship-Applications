package datos.repositoryItson.daoItson.pagarAdeudo;

import datos.dominioItson.pagarAdeudo.SolicitudPago;
import datos.repositoryItson.documents.pagarAdeudo.SolicitudPagoDocument;

public interface ISolicitudPagoDAO {
    boolean guardarSolicitud(SolicitudPagoDocument solicitudPago);
}
