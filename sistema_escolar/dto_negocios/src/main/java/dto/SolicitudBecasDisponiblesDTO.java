package dto;
/**
 * @author Escalante, Sebastian.
 */
public class SolicitudBecasDisponiblesDTO {



   private double promedioActual;
   private boolean cargaAcademica;
   private double ingresoMensualFamilia;

    public SolicitudBecasDisponiblesDTO() {
    }

    public SolicitudBecasDisponiblesDTO(double promedioActual, boolean cargaAcademica, double ingresoMensualFamilia) {

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

    public boolean getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(boolean cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public double getIngresoMensualFamilia() {
        return ingresoMensualFamilia;
    }

    public void setIngresoMensualFamilia(double ingresoMensualFamilia) {
        this.ingresoMensualFamilia = ingresoMensualFamilia;
    }
}
