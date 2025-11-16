/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class RequisitosBeca {
    
    private double promedioMinimo;
    private double ingresoFamiliarMaximo;
    private boolean cargaAcademica;

    public RequisitosBeca() {
    }

    public RequisitosBeca(double promedioMinimo, double ingresoFamiliarMaximo, boolean cargaAcademica) {
        this.promedioMinimo = promedioMinimo;
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
        this.cargaAcademica = cargaAcademica;
    }

    public RequisitosBeca(double promedioMinimo, double ingresoFamiliarMaximo) {
        this.promedioMinimo = promedioMinimo;
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
    }

    public double getPromedioMinimo() {
        return promedioMinimo;
    }

    public void setPromedioMinimo(double promedioMinimo) {
        this.promedioMinimo = promedioMinimo;
    }

    public double getIngresoFamiliarMaximo() {
        return ingresoFamiliarMaximo;
    }

    public void setIngresoFamiliarMaximo(double ingresoFamiliarMaximo) {
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
    }

    public boolean isCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(boolean cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }
    
    
    
}
