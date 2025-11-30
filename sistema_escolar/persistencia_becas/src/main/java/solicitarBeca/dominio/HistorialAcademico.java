/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package solicitarBeca.dominio;
import solicitarBeca.dominio.enums.Carrera;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademico {
    private Carrera carrera;
    private double promedio;
    private double porcentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademico() {}

    public HistorialAcademico(double cargaAcademica, Carrera carrera, double indiceReprobacion, double porcentajeBajas, double promedio, int semestre) {
        this.cargaAcademica = cargaAcademica;
        this.carrera = carrera;
        this.indiceReprobacion = indiceReprobacion;
        this.porcentajeBajas = porcentajeBajas;
        this.promedio = promedio;
        this.semestre = semestre;
    }

    public double getCargaAcademica() {
        return cargaAcademica;
    }

    public void setCargaAcademica(double cargaAcademica) {
        this.cargaAcademica = cargaAcademica;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
    }

    public double getPorcentajeBajas() {
        return porcentajeBajas;
    }

    public void setPorcentajeBajas(double porcentajeBajas) {
        this.porcentajeBajas = porcentajeBajas;
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

    @Override
    public String toString() {
        return "HistorialAcademico{" +
                "cargaAcademica=" + cargaAcademica +
                ", carrera=" + carrera +
                ", promedio=" + promedio +
                ", porcentajeBajas=" + porcentajeBajas +
                ", semestre=" + semestre +
                ", indiceReprobacion=" + indiceReprobacion +
                '}';
    }
}
