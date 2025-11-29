/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solicitarBeca;

/**
 *
 * @author Cortez, Manuel;
 */
public class HistorialAcademicoDTO {
    private Long matriculaEstudiante;
    private String carrera;
    private double promedio;
    private double porcentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademicoDTO() {}

    public HistorialAcademicoDTO(double cargaAcademica, String carrera, double indiceReprobacion, Long matriculaEstudiante, double porcentajeBajas, double promedio, int semestre) {
        this.cargaAcademica = cargaAcademica;
        this.carrera = carrera;
        this.indiceReprobacion = indiceReprobacion;
        this.matriculaEstudiante = matriculaEstudiante;
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

    public Long getMatriculaEstudiante() {
        return matriculaEstudiante;
    }

    public void setMatriculaEstudiante(Long matriculaEstudiante) {
        this.matriculaEstudiante = matriculaEstudiante;
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
}
