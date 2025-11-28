/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.gobierno;
import java.math.BigDecimal;

/**
 *
 * @author Cortez, Manuel;
 */
public class InformacionSocioeconomicaDTOGobierno {
    private  BigDecimal ingresoTotalFamilarMensual;
    private String tipoVivienda;
    private boolean trabajo;
    private boolean deudas;

    public InformacionSocioeconomicaDTOGobierno() {}

    public InformacionSocioeconomicaDTOGobierno(BigDecimal ingresoTotalFamilarMensual, String tipoVivienda, boolean trabajo, boolean deudas) {
        this.trabajo = trabajo;
        this.tipoVivienda = tipoVivienda;
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.deudas = deudas;
    }

    public boolean getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public BigDecimal getIngresoTotalFamilarMensual() {
        return ingresoTotalFamilarMensual;
    }

    public void setIngresoTotalFamilarMensual(BigDecimal ingresoTotalFamilarMensual) {
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
    }

    public boolean getDeudas() {
        return deudas;
    }

    public void setDeudas(boolean deudas) {
        this.deudas = deudas;
    }
}
