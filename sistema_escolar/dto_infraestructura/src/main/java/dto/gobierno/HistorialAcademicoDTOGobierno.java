/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.gobierno;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoDTOGobierno {
    private String carrera;
    private double promedio;
    private double procentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademicoDTOGobierno() {}

    public HistorialAcademicoDTOGobierno(double cargaAcademica, String carrera, double indiceReprobacion, double procentajeBajas, double promedio, int semestre) {
        this.cargaAcademica = cargaAcademica;
        this.carrera = carrera;
        this.indiceReprobacion = indiceReprobacion;
        this.procentajeBajas = procentajeBajas;
        this.promedio = promedio;
        this.semestre = semestre;
    }

    public double getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(double cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
    }

    public double getProcentajeBajas() {
        return procentajeBajas;
    }

    public void setProcentajeBajas(double procentajeBajas) {
        this.procentajeBajas = procentajeBajas;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
