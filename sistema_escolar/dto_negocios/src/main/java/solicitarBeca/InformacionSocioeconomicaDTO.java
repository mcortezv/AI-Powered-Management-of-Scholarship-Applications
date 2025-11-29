package solicitarBeca;
import java.math.BigDecimal;

/**
 * @author Escalante, Sebastian.
 */

public class InformacionSocioeconomicaDTO {
    private BigDecimal ingresoTotalFamilarMensual;
    private boolean dependenciaEconomica;
    private String tipoVivienda;
    private boolean trabajo;
    private boolean deudas;

    public InformacionSocioeconomicaDTO() {}

    public InformacionSocioeconomicaDTO(boolean trabajo, String tipoVivienda, BigDecimal ingresoTotalFamilarMensual, boolean deudas) {
        this.trabajo = trabajo;
        this.tipoVivienda = tipoVivienda;
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.deudas = deudas;
    }

    public InformacionSocioeconomicaDTO(BigDecimal ingresoBig, boolean dependenciaEconomica, boolean generaIngreso) {
        this.ingresoTotalFamilarMensual = ingresoBig;
        this.trabajo = generaIngreso;
        this.dependenciaEconomica = dependenciaEconomica;
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

    public String getDependenciaEconomica() {
        return null;
    }

    public String getIngresoFamiliarSt() {
        return null;
    }

    public String getTrabajoSt() {
        return null;
    }
}