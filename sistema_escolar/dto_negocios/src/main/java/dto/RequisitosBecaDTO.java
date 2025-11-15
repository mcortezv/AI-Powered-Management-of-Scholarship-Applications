/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class RequisitosBecaDTO {
    
    private double promedioMinimo;
    private double ingresoFamiliarMaximo;
    private Boolean cargaAcademica;

    public RequisitosBecaDTO() {
    }

    public RequisitosBecaDTO(double promedioMinimo, double ingresoFamiliarMaximo, Boolean cargaAcademica) {
        this.promedioMinimo = promedioMinimo;
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
        this.cargaAcademica = cargaAcademica;
    }

    public RequisitosBecaDTO(double promedioMinimo, double ingresoFamiliarMaximo) {
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

    public Boolean isCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(Boolean cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public Boolean getCargaAcademica() {
        return cargaAcademica;
    }

    
    
    
}
