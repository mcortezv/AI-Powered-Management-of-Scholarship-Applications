package datos.serviceBanco;

import datos.dominioBanco.Cuenta;
import datos.dominioBanco.Transaccion;
import datos.repositoryBanco.dao.TransaccionDAO;
import datos.repositoryBanco.dao.interfaces.ITransaccionDAO;

import java.util.Date;
import java.util.UUID;

public class TransaccionService {
    private final ITransaccionDAO transaccionDAO;

    public TransaccionService() {
        this.transaccionDAO = new TransaccionDAO();
    }

    public void registrarExito(Cuenta cuenta, double monto, String concepto) {
        crearYGuardar(cuenta.getNumeroTarjeta(), monto, concepto, "APROBADA");
    }

    public void registrarFallo(String numeroTarjeta, double monto, String concepto, String motivoError) {
        crearYGuardar(numeroTarjeta, monto, concepto, "RECHAZADA: " + motivoError);
    }

    private void crearYGuardar(String numeroTarjeta, double monto, String concepto, String estado) {
        Transaccion t = new Transaccion();
        t.setFolio("TX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        t.setNumeroTarjetaOrigen(numeroTarjeta);
        t.setMonto(monto);
        t.setEntidadDestino("ITSON");
        t.setConcepto(concepto);
        t.setFecha(new Date());
        t.setEstado(estado);
        transaccionDAO.guardarTransaccion(t);
    }
}