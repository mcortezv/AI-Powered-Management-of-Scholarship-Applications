package dto;
/**
 * @author Escalante, Sebastian.
 */
public class SolicitudBecasDisponiblesDTO {
   private double promedioActual;
   private int cargaAcademica;
   private double ingresoMensualFamilia;

    public SolicitudBecasDisponiblesDTO() {
    }

    public SolicitudBecasDisponiblesDTO(double promedioActual, int cargaAcademica, double ingresoMensualFamilia) {
        this.promedioActual = promedioActual;
        this.cargaAcademica = cargaAcademica;
        this.ingresoMensualFamilia = ingresoMensualFamilia;
    }

    public double getPromedioActual() {
        return promedioActual;
    }

    public void setPromedioActual(double promedioActual) {
        this.promedioActual = promedioActual;
    }

    public int getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(int cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public double getIngresoMensualFamilia() {
        return ingresoMensualFamilia;
    }

    public void setIngresoMensualFamilia(double ingresoMensualFamilia) {
        this.ingresoMensualFamilia = ingresoMensualFamilia;
    }
}
