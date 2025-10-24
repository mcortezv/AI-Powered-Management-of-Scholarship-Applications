/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;

import java.time.LocalDateTime;

/**
 *
 * @author Cortez, Manuel;
 */
public class Requisitos {
    private double promedioMinimo;
    private int semestreMinimo;
    private double ingresoFamiliarMaximo;
    private LocalDateTime fechaLimiteSolicitud;


    public Requisitos() {
    }

    public Requisitos(double promedioMinimo, int semestreMinimo, double ingresoFamiliarMaximo, LocalDateTime fechaLimiteSolicitud) {
        this.promedioMinimo = promedioMinimo;
        this.semestreMinimo = semestreMinimo;
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
        this.fechaLimiteSolicitud = fechaLimiteSolicitud;
    }

    public double getPromedioMinimo() {
        return promedioMinimo;
    }

    public void setPromedioMinimo(double promedioMinimo) {
        this.promedioMinimo = promedioMinimo;
    }

    public int getSemestreMinimo() {
        return semestreMinimo;
    }

    public void setSemestreMinimo(int semestreMinimo) {
        this.semestreMinimo = semestreMinimo;
    }

    public double getIngresoFamiliarMaximo() {
        return ingresoFamiliarMaximo;
    }

    public void setIngresoFamiliarMaximo(double ingresoFamiliarMaximo) {
        this.ingresoFamiliarMaximo = ingresoFamiliarMaximo;
    }

    public LocalDateTime getFechaLimiteSolicitud() {
        return fechaLimiteSolicitud;
    }

    public void setFechaLimiteSolicitud(LocalDateTime fechaLimiteSolicitud) {
        this.fechaLimiteSolicitud = fechaLimiteSolicitud;
    }
}
