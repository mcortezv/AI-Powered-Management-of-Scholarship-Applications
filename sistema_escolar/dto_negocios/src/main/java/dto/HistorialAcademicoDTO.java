package dto;

public class HistorialAcademicoDTO {
    private String carrera;
    private double promedio;
    private double procentajeBajas;
    private double cargaAcademica;
    private int semestre;
    private double indiceReprobacion;

    public HistorialAcademicoDTO() {
    }

    public HistorialAcademicoDTO(String carrera, double promedio, double procentajeBajas, double cargaAcademica, int semestre, double indiceReprobacion) {
        this.carrera = carrera;
        this.promedio = promedio;
        this.procentajeBajas = procentajeBajas;
        this.cargaAcademica = cargaAcademica;
        this.semestre = semestre;
        this.indiceReprobacion = indiceReprobacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getIndiceReprobacion() {
        return indiceReprobacion;
    }

    public void setIndiceReprobacion(double indiceReprobacion) {
        this.indiceReprobacion = indiceReprobacion;
    }
}
