package datos.adaptadoresBanco;

import datos.dominioBanco.Cuenta;
import datos.repositoryBanco.documents.CuentaDocument;

public class CuentaAdaptador {

    public static Cuenta toEntity(CuentaDocument document) {
        if (document == null) {
            return null;
        }

        Cuenta cuenta = new Cuenta();
        cuenta.setId(document.getId());
        cuenta.setNumeroTarjeta(document.getNumeroTarjeta());
        cuenta.setNombreTitular(document.getNombreTitular());
        cuenta.setFechaVencimiento(document.getFechaVencimiento());
        cuenta.setCvv(document.getCvv());
        cuenta.setSaldo(document.getSaldo());
        cuenta.setTipo(document.getTipo());

        return cuenta;
    }


    public static CuentaDocument toDocument(Cuenta entity) {
        if (entity == null) {
            return null;
        }

        CuentaDocument document = new CuentaDocument();
        document.setId(entity.getId());
        document.setNumeroTarjeta(entity.getNumeroTarjeta());
        document.setNombreTitular(entity.getNombreTitular());
        document.setFechaVencimiento(entity.getFechaVencimiento());
        document.setCvv(entity.getCvv());
        document.setSaldo(entity.getSaldo());
        document.setTipo(entity.getTipo());

        return document;
    }
}