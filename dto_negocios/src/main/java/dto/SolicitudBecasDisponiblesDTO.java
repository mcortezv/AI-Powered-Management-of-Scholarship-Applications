package dto;

public class SolicitudBecasDisponiblesDTO {
   private String promedioActual;
   private String cargaAcademica;
   private double ingresoMensualFamilia;

    public SolicitudBecasDisponiblesDTO() {
    }

    public SolicitudBecasDisponiblesDTO(String promedioActual, String cargaAcademica, double ingresoMensualFamilia) {
        this.promedioActual = promedioActual;
        this.cargaAcademica = cargaAcademica;
        this.ingresoMensualFamilia = ingresoMensualFamilia;
    }

    public String getPromedioActual() {
        return promedioActual;
    }

    public void setPromedioActual(String promedioActual) {
        this.promedioActual = promedioActual;
    }

    public String getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(String cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public double getIngresoMensualFamilia() {
        return ingresoMensualFamilia;
    }

    public void setIngresoMensualFamilia(double ingresoMensualFamilia) {
        this.ingresoMensualFamilia = ingresoMensualFamilia;
    }
}
