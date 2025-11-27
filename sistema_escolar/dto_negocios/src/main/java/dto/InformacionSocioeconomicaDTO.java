package dto;
import java.math.BigDecimal;

/**
 * @author Escalante, Sebastian.
 */

public class InformacionSocioeconomicaDTO {
    private BigDecimal ingresoTotalFamilarMensual;
    private String tipoVivienda;
    private boolean trabajo;
    private boolean deudas;
    private String ingresoFamiliar;
   

    public InformacionSocioeconomicaDTO() {
    }

    public InformacionSocioeconomicaDTO(boolean deudas, BigDecimal ingresoTotalFamilarMensual, String tipoVivienda, boolean trabajo) {
        this.deudas = deudas;
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.tipoVivienda = tipoVivienda;
        this.trabajo = trabajo;
    }

    public InformacionSocioeconomicaDTO(BigDecimal ingresoTotalFamilarMensual, boolean trabajo, boolean deudas) {
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.trabajo = trabajo;
        this.deudas = deudas;
    }

    public InformacionSocioeconomicaDTO(boolean trabajo, boolean deudas, String ingresoFamiliar) {
        this.trabajo = trabajo;
        this.deudas = deudas;
        this.ingresoFamiliar = ingresoFamiliar;
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

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public String getIngresoFamiliar() {
        return ingresoFamiliar;
    }

    public void setIngresoFamiliar(String ingresoFamiliar) {
        this.ingresoFamiliar = ingresoFamiliar;
    }
    
    
}
