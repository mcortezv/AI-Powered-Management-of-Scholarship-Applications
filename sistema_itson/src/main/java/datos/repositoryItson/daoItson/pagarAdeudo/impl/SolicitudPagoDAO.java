package datos.repositoryItson.daoItson.pagarAdeudo.impl;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import datos.configMongoItson.MongoClienteProvider;
import datos.repositoryItson.daoItson.pagarAdeudo.ISolicitudPagoDAO;
import datos.repositoryItson.documents.pagarAdeudo.SolicitudPagoDocument;

public class SolicitudPagoDAO implements ISolicitudPagoDAO {
    private final MongoCollection<SolicitudPagoDocument> col;

    public SolicitudPagoDAO() {
        this.col = MongoClienteProvider.INSTANCE.getCollection("solicitudesPago", SolicitudPagoDocument.class);
    }

    @Override
    public boolean guardarSolicitud(SolicitudPagoDocument solicitudPago) {
        try {
            col.insertOne(solicitudPago);
            return true;
        } catch (MongoException e) {
            System.err.println("Error al insertar la solicitud de pago en Mongo: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            return false;
        }
    }

}
