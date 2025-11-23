package dto;
import dominio.enums.TipoVivienda;
import java.math.BigDecimal;

/**
 * @author Escalante, Sebastian.
 */

public class InformacionSocioeconomicaDTO {
    private BigDecimal ingresoTotalFamilarMensual;
    private TipoVivienda tipoVivienda;
    private boolean trabajo;
    private boolean deudas;
   

    public InformacionSocioeconomicaDTO() {
    }

    public InformacionSocioeconomicaDTO(boolean deudas, BigDecimal ingresoTotalFamilarMensual, TipoVivienda tipoVivienda, boolean trabajo) {
        this.deudas = deudas;
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.tipoVivienda = tipoVivienda;
        this.trabajo = trabajo;
    }

    public boolean isDeudas() {
        return deudas;
    }

    public void setDeudas(boolean deudas) {
        this.deudas = deudas;
    }

    public BigDecimal getIngresoTotalFamilarMensual() {
        return ingresoTotalFamilarMensual;
    }

    public void setIngresoTotalFamilarMensual(BigDecimal ingresoTotalFamilarMensual) {
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }
}
