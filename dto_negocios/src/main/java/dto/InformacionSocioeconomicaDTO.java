package dto;
/**
 * @author Escalante, Sebastian.
 */
public class InformacionSocioeconomicaDTO {
    private double ingresoTotalFamilarMensual;
    private boolean dependenciaEconomica;
    private boolean trabajo;
   

    public InformacionSocioeconomicaDTO() {
    }

    public InformacionSocioeconomicaDTO(double ingresoTotalFamilarMensual, boolean dependenciaEconomica, boolean trabajo) {
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
        this.dependenciaEconomica = dependenciaEconomica;
        this.trabajo = trabajo;
    }

    public double getIngresoTotalFamilarMensual() {
        return ingresoTotalFamilarMensual;
    }

    public void setIngresoTotalFamilarMensual(double ingresoTotalFamilarMensual) {
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
    }

    public boolean isDependenciaEconomica() {
        return dependenciaEconomica;
    }

    public void setDependenciaEconomica(boolean dependenciaEconomica) {
        this.dependenciaEconomica = dependenciaEconomica;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    
}
