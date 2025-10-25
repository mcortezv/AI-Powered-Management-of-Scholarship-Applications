package dto;

public class InformacionSocioeconomicaDTO {
    private double ingresoTotalFamilarMensual;
    private String tipoVivienda;
    private boolean trabajo;
    private boolean deudas;

    public InformacionSocioeconomicaDTO() {
    }

    public InformacionSocioeconomicaDTO(boolean deudas, boolean trabajo, String tipoVivienda, double ingresoTotalFamilarMensual) {
        this.deudas = deudas;
        this.trabajo = trabajo;
        this.tipoVivienda = tipoVivienda;
        this.ingresoTotalFamilarMensual = ingresoTotalFamilarMensual;
    }

    public double getIngresoTotalFamilarMensual() {
        return ingresoTotalFamilarMensual;
    }

    public void setIngresoTotalFamilarMensual(double ingresoTotalFamilarMensual) {
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

    public boolean isDeudas() {
        return deudas;
    }

    public void setDeudas(boolean deudas) {
        this.deudas = deudas;
    }
}
