package dto;
import java.math.BigDecimal;

/**
 * @author Escalante, Sebastian.
 */

public class InformacionSocioeconomicaDTO {
  //  private BigDecimal ingresoTotalFamilarMensual;
 //   private String tipoVivienda;
    private boolean trabajo;
    private boolean dependencia;
    private Double ingresoFamiliar;
    private String ingresoFamiliarSt;
    private String trabajoSt;
    private String dependenciaEconomica;
   

    public InformacionSocioeconomicaDTO() {
    }

    public InformacionSocioeconomicaDTO(String ingresoFamiliarSt, String trabajoSt, String dependenciaEconomica) {
        this.ingresoFamiliarSt = ingresoFamiliarSt;
        this.trabajoSt = trabajoSt;
        this.dependenciaEconomica = dependenciaEconomica;
    }

    public InformacionSocioeconomicaDTO(boolean trabajo, boolean dependencia, Double ingresoFamiliar) {
        this.trabajo = trabajo;
        this.dependencia = dependencia;
        this.ingresoFamiliar = ingresoFamiliar;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    public void setTrabajo(boolean trabajo) {
        this.trabajo = trabajo;
    }

    public boolean isDependencia() {
        return dependencia;
    }

    public void setDependencia(boolean dependencia) {
        this.dependencia = dependencia;
    }

    public Double getIngresoFamiliar() {
        return ingresoFamiliar;
    }

    public void setIngresoFamiliar(Double ingresoFamiliar) {
        this.ingresoFamiliar = ingresoFamiliar;
    }

    public String getIngresoFamiliarSt() {
        return ingresoFamiliarSt;
    }

    public void setIngresoFamiliarSt(String ingresoFamiliarSt) {
        this.ingresoFamiliarSt = ingresoFamiliarSt;
    }

    public String getTrabajoSt() {
        return trabajoSt;
    }

    public void setTrabajoSt(String trabajoSt) {
        this.trabajoSt = trabajoSt;
    }

    public String getDependenciaEconomica() {
        return dependenciaEconomica;
    }

    public void setDependenciaEconomica(String dependenciaEconomica) {
        this.dependenciaEconomica = dependenciaEconomica;
    }
    
}