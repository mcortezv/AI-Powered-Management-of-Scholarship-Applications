package datos.adaptadoresBanco;

import datos.dominioBanco.Transaccion;
import datos.repositoryBanco.documents.TransaccionDocument;

public class TransaccionAdaptador {

    public static Transaccion toEntity(TransaccionDocument document) {
        if (document == null) {
            return null;
        }

        Transaccion entity = new Transaccion();
        entity.setId(document.getId());
        entity.setFolio(document.getFolio());
        entity.setNumeroTarjetaOrigen(document.getNumeroTarjetaOrigen());
        entity.setMonto(document.getMonto());
        entity.setEntidadDestino(document.getEntidadDestino());
        entity.setConcepto(document.getConcepto());
        entity.setFecha(document.getFecha());
        entity.setEstado(document.getEstado());

        return entity;
    }

    public static TransaccionDocument toDocument(Transaccion entity) {
        if (entity == null) {
            return null;
        }
        TransaccionDocument document = new TransaccionDocument();
        document.setId(entity.getId());
        document.setFolio(entity.getFolio());
        document.setNumeroTarjetaOrigen(entity.getNumeroTarjetaOrigen());
        document.setMonto(entity.getMonto());
        document.setEntidadDestino(entity.getEntidadDestino());
        document.setConcepto(entity.getConcepto());
        document.setFecha(entity.getFecha());
        document.setEstado(entity.getEstado());
        return document;
    }
}