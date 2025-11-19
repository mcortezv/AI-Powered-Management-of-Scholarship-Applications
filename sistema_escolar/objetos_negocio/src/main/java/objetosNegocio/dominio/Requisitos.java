/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio.dominio;

/**
 *
 * @author Cortez, Manuel;
 */
public class Requisitos {
    private double promedioMinimo;
    private double ingresoFamiliarMaximo;
    private double procentajeBajas;
    private double cargaAcademica;
    private double indiceReprobacion;
    private boolean trabajo;
    private boolean deudas;

    public Requisitos() {
    }

    public Requisitos(double promedioMinimo, double ingresoFamiliarMaximo, double procentajeBajas, double cargaAcademica, double indiceReprobacion, boolean trabajo, boolean deudas) {
        this.promedioMinimo = promedioMinimo;
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
        this.procentajeBajas = procentajeBajas;
        this.cargaAcademica = cargaAcademica;
        this.indiceReprobacion = indiceReprobacion;
        this.trabajo = trabajo;
        this.deudas = deudas;
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

    public double getProcentajeBajas() {
        return procentajeBajas;
    }

    public void setProcentajeBajas(double procentajeBajas) {
        this.procentajeBajas = procentajeBajas;
    }

    public double getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(double cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
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
