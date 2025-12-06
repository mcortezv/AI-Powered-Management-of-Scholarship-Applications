package apiBanco.controles;

import datos.dominioBanco.Cuenta;
import datos.dtos.DatosTarjetaDTO;
import datos.serviceBanco.CuentaService;
import datos.serviceBanco.TransaccionService;
import views.panels.MainFrameBanco;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlBancoAPI {

    private final CuentaService cuentaService;
    private final TransaccionService transaccionService;
    private MainFrameBanco ventanaBancaria;

    public ControlBancoAPI(){
        this.cuentaService = new CuentaService();
        this.transaccionService = new TransaccionService();
    }

    public void abrirVentanaPago(ActionListener listenerBotonPagar) {
        this.ventanaBancaria = new MainFrameBanco();
        this.ventanaBancaria.setAccionPagar(listenerBotonPagar);
        this.ventanaBancaria.mostrar();
    }

    public void cerrarVentana() {
        if (this.ventanaBancaria != null) {
            this.ventanaBancaria.cerrar();
        }
    }

    public boolean confirmarPago(double monto, String concepto) {
        if (this.ventanaBancaria == null) {
            return false;
        }
        DatosTarjetaDTO datosDTO = ventanaBancaria.obtenerDatos();
        return procesarSolicitudPago(datosDTO, monto, concepto);
    }

    public boolean procesarSolicitudPago(DatosTarjetaDTO datosTarjeta, double monto, String concepto) {
        String numeroLimpio = datosTarjeta.getNumeroTarjeta().replace("-", "").replace(" ", "").trim();
        try {
            Cuenta cuenta = cuentaService.validarYObtenerCuenta(
                    numeroLimpio,
                    datosTarjeta.getCv(),
                    datosTarjeta.getFechaVencimiento()
            );

            if (!cuentaService.verificarFondos(cuenta, monto)) {
                transaccionService.registrarFallo(numeroLimpio, monto, concepto, "FONDOS INSUFICIENTES");
                return false;
            }

            boolean descuentoExitoso = cuentaService.descontarSaldo(cuenta, monto);

            if (descuentoExitoso) {
                transaccionService.registrarExito(cuenta, monto, concepto);
                return true;
            } else {
                transaccionService.registrarFallo(numeroLimpio, monto, concepto, "ERROR SISTEMA");
                return false;
            }

        } catch (Exception e) {
            transaccionService.registrarFallo(numeroLimpio, monto, concepto, e.getMessage());
            return false;
        }
    }

}
