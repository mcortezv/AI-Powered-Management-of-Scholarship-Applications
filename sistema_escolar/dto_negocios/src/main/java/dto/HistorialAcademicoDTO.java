/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoDTO {
    private String carrera;
    private double promedio;
    private double procentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademicoDTO() {}

    public HistorialAcademicoDTO(int semestre, double promedio, double procentajeBajas, double indiceReprobacion, String carrera, double cargaAcademica) {
        this.semestre = semestre;
        this.promedio = promedio;
        this.procentajeBajas = procentajeBajas;
        this.indiceReprobacion = indiceReprobacion;
        this.carrera = carrera;
        this.cargaAcademica = cargaAcademica;
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
